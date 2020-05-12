/* Header File for LIAnalysis Module
 * Contains PMTGain Analysis for Light Injection Module
 * Contains C++/CERN ROOT includes essentials and all macros
 * Date Created: Aug 28, 2017
 * Date Last Modified: Dec 16, 2017
 */

#include "GainAnalysis.hh"
#include "CombineFile.hh"

GainAnalysis::GainAnalysis(string POput, string Oput_Dir, int Ch) {
  ReadFile,ReadTree = Pulse.DetPulseLoader(PC_Output, Output_Dir, Ch);
  FPulse = Pulse.Filtered_Pulses();
  nChannel = Ch;
  Output_Dir = Oput_Dir; 
  //Create an output file at designated directory
  //Path to Output
  AreaCH << Output_Dir << "/PulseArea.root";
  AreaCHName = AreaCH.str();
  //Create a new Root file and a new tree for refernces
  WriteFile = new TFile(AreaCHName.c_str(),"RECREATE");
  Output_Dir = Oput_Dir; 
}

void GainAnalysis::ExtractArea(){
  
  //Declare a sample with an array corresponding to the amount of values in that array.
  //Set the array to the branch of interested.
  float area=0;
  int detector=0;
  Long64_t event=0;
  ReadTree->SetBranchAddress("a", &area);
  ReadTree->SetBranchAddress("det", &detector);
  ReadTree->SetBranchAddress("evt", &event);

  //Create values to store the historgram array
  float A;

  //declaration of variables to locate spe trigger
  Long64_t evtmap=0, evtprev=0;
  float Amap=0;
  int Dmap=0;
  int w = 0;
  int counter =0;
  int traceback = 0;
  //Create n amount of histogram corresponding to number of PMT to be fill by SPE Pulse Integrated Area
  TH1F *Areahis[nChannel+1];
  for(int l = 0; l < nChannel; l++) {
    ostringstream areabranch;
    areabranch << "areac" << l;
    string areabranchname = areabranch.str();
    ostringstream his;
    his << "his" << l;
    string hisname = his.str();
    Areahis[l] = new TH1F(hisname.c_str(),areabranchname.c_str(),110,range_low,range_high);
  }
  Areahis[nChannel] = new TH1F("PhotoDiode1","PD1",110,range_low,range_high);
  Areahis[nChannel+1] = new TH1F("PhotoDiode2","PD2",110,range_low,range_high);
  //Begin Filtering Events to its respected PMT
  cout << "Begin Processing Run Event\n";

  for(int j = 0; j < n; j++) {
    ReadTree->GetEntry(j);
    evtmap = event;
    Dmap = detector;
    evtmap = event;
    A = area;
    if ((Dmap != -100) && (Pulse[w] == evtmap)) Areahis[Dmap]->Fill(A);  //If channel isn't -100
    else if ((Dmap == 1000) && (Pulse[w] == evtmap)) Areahis[nChannel]->Fill(A);
    else if ((Dmap == 1001) && (Pulse[w] == evtmap)) Areahis[nChannel+1]->Fill(A);
    else if (Pulse[w] < evtmap){
      w++;
      traceback +=1;
      if (Pulse[w] == evtmap) {
        j = j - traceback;
        traceback = 0;
      }
    } else continue;
  } 
  //Write the historgram to file
  for(int m = 0; m < nChannel; m++) {     
    Areahis[m]->Write();
    cout << "Finished Processing Channel: " << m << " of " << number_of_channels << endl;
  }
  Areahis[nChannel]->Write();
  Areahis[nChannel+1]->Write();
  WriteFile->Close();
  ReadFile->Close();
  
}

//Area Branch Fitting Module
void GainAnalysis::SPEFit(){
  printf("SPE analysis***********************************\n");
  //setting up fitting function for SPE
  TF1 *Func0 = new TF1("Func0","TMath::Gaus(x,[pedmean],[pedsig],1)");
  TF1 *Func1 = new TF1("Func1","TMath::Gaus(x,[pedmean]+[spemean],sqrt([spesig]*[spesig]+[pedsig]*[pedsig]),1)",range_low, range_high);
  TF1 *Func2 = new TF1("Func2","TMath::Gaus(x,([pedmean]+[spemean])*2,sqrt(2*[spesig]*[spesig]+[pedsig]*[pedsig]),1)",range_low, range_high);
  TF1 *Func3 = new TF1("Func3","TMath::Gaus(x,([pedmean]+[spemean])*3,sqrt(3*[spesig]*[spesig]+[pedsig]*[pedsig]),1)",range_low, range_high);
  TF1 *Func4 = new TF1("Func4","TMath::Gaus(x,([pedmean]+[spemean])*4,sqrt(4*[spesig]*[spesig]+[pedsig]*[pedsig]),1)",range_low, range_high);
  TF1 *Func5 = new TF1("Func5","TMath::Gaus(x,([pedmean]+[spemean])*5,sqrt(5*[spesig]*[spesig]+[pedsig]*[pedsig]),1)",range_low, range_high);
  //TF1 *Func6 = new TF1("Func6","(x>0)/[decay]*TMath::Exp(-1.0*x/[decay]*(x>0))",range_low, range_high);

  //Recreate a fitting function
  TF1 *spectrumFunc = new TF1("spectrumFunc","([constant]*(TMath::Poisson(0,[occu])*Func0 + TMath::Poisson(1,[occu])*Func1 + TMath::Poisson(2,[occu])*Func2 +TMath::Poisson(3,[occu])*Func3+TMath::Poisson(4,[occu])*Func4+TMath::Poisson(5,[occu])*Func5))",range_low, range_high);

  //Extract pertient values from fitting function and set their limit
  float i_spesig = spectrumFunc->GetParNumber("spesig");
  float i_pedsig = spectrumFunc->GetParNumber("pedsig");
  float i_spemean= spectrumFunc->GetParNumber("spemean");
  float i_occu = spectrumFunc->GetParNumber("occu");
  float i_constant = spectrumFunc->GetParNumber("constant");
  float i_pedmean = spectrumFunc->GetParNumber("pedmean");
  //float i_amp = spectrumFunc->GetParNumber("amp");
  //float i_decay = spectrumFunc->GetParNumber("decay");
  assert(i_spesig>=0);assert(i_pedsig>=0);assert(i_spemean>=0);assert(i_occu>=0);assert(i_pedmean>=0);
  spectrumFunc->SetParameter(i_constant,150000);
  spectrumFunc->SetParLimits(i_spesig,0,50);
  spectrumFunc->SetParLimits(i_spemean,0,150);
  spectrumFunc->SetParLimits(i_pedsig,5,20);
  spectrumFunc->SetParLimits(i_occu,0,5);
  //spectrumFunc->SetParLimits(i_amp,0,1);
  spectrumFunc->SetParLimits(i_pedmean,-10,10);


  //Read in root File and extracted the area branch and separate it
  TFile *ReadFile = TFile::Open(AreaCHName.c_str(),"READ");

  int nChannels = nChannel-1;
  ofstream MOF, FittedOccu, FittedSPEsig, FittedPEDsig, FittedPEDmean;
  MOF.open("GMean.txt");
  FittedOccu.open("FittedOccu.txt");
  FittedSPEsig.open("FittedSPEsig.txt");
  FittedPEDsig.open("FittedPEDsig.txt");
  FittedPEDmean.open("FittedPEDmean.txt");
  ostringstream histo;

  //loop through the extracted area data, store it into a histogram to perform fitting.
  TH1F *call_his ;
  float area_pulse;  
  for(int k = 0; k < nChannels; k++){
    TCanvas* c1 = new TCanvas();
    ostringstream his;
    his << "his" << k;				
    string hisname = his.str();
    
    ReadFile->GetObject(hisname.c_str(),call_his);
    //Set initial parameter for fitting
    spectrumFunc->SetParameter(i_spesig,25);
    spectrumFunc->SetParameter(i_spemean,50);    
    spectrumFunc->SetParameter(i_pedsig,20);
    spectrumFunc->SetParameter(i_occu,1);
    //spectrumFunc->SetParameter(i_amp,0);
    spectrumFunc->SetParameter(i_pedmean,0);

    //setting axis and begin fitting
    call_his->SetAxisRange(range_low,range_high);
    call_his->Fit("spectrumFunc","R");
    //call_his->Write();

    //output .pdf of fitted histogram
    histo << Output_Dir << "PMT_" << k << "_.pdf";  
    string histoname = histo.str(); 
    call_his->Draw();
    c1->SaveAs(histoname.c_str());
    histo.str("");
    histo.clear();


    //extract fitting parameters
    TF1 *fit1 = call_his->GetFunction("spectrumFunc");
    double mean_gauss = fit1->GetParameter(i_spemean);
    double sigma_gauss = fit1->GetParameter(i_spesig);
    double occuOut = fit1->GetParameter(i_occu);
    double PEDOut = fit1->GetParameter(i_pedsig);
    double PEDMEANOut = fit1->GetParameter(i_pedmean);
    MOF << mean_gauss << endl;
    FittedOccu << "PMT: " << k << " Occupancy: " << occuOut << endl;
    FittedSPEsig << "PMT: " << k << " SPEsig: " << sigma_gauss << endl;
    FittedPEDsig << "PMT: " << k << " PEDsig: " << PEDOut << endl;
    FittedPEDmean << "PMT: " << k << " PEDmean: " << PEDMEANOut << endl;
  }
  MOF.close();
  FittedOccu.close();
  FittedSPEsig.close();
  FittedPEDsig.close();
  FittedPEDmean.close();
  //WriteFile->Write();
  //WriteFile->Close();
  ReadFile->Close();

}

//calculate PMTGain
void GainAnalysis::CalcGain(){
  //Declaration of known variables
  float Digitizer_Max_Voltage = 2.0;  //Voltz
  float Digitizer_Bits_Use = pow(2,14);
  float Resistance = 50;              //Ohms
  float eC = 1.6e-19;                 //Coulomb
  float time_per_sample = 4e-9;       //second

  //PMT Gain Scale Calculation
  float GainScale = (Digitizer_Max_Voltage/Digitizer_Bits_Use/Resistance)*(time_per_sample/eC);

  //READ in values from txt file
  string line;
  ifstream RFile;
  RFile.open("GMean.txt");

  //Write out a txt file with PMT Gain and PMT
  ofstream WFile;
  WFile.open("PMTGain.txt");

  int i = 0;
  float PMTGain;
  while(!RFile.eof()) {
    getline(RFile, line);
    float mean = strtof(line.c_str(),0);
    PMTGain = mean * GainScale;
    WFile << /*"PMT: " << i << " PMTGain: " <<*/ PMTGain << endl;
    i++;
  }
  
  WriteFile.close();
  ReadFile.close();

  //path to oputput to output directory
  ostringstream StoreMeanOutput, StorePMTGain, StoreFittedOccu, StoreFittedSPEsig, StoreFittedPEDsig, StoreFittedDecay;
  StoreMeanOutput << "mv GMean.txt " << Output_Dir; 
  StorePMTGain << "mv PMTGain.txt " << Output_Dir;
  StoreFittedOccu << "mv FittedOccu.txt " << Output_Dir;
  StoreFittedSPEsig << "mv FittedSPEsig.txt " << Output_Dir;
  StoreFittedPEDsig << "mv FittedPEDsig.txt " << Output_Dir;
  StoreFittedDecay << "mv FittedPEDmean.txt " << Output_Dir;
  string StoreMeanOutputName = StoreMeanOutput.str();
  string StorePMTGainName = StorePMTGain.str();
  string StoreFittedOccuName = StoreFittedOccu.str();
  string StoreFittedSPEsigName = StoreFittedSPEsig.str();
  string StoreFittedPEDsigName = StoreFittedPEDsig.str();
  string StoreFittedDecayName = StoreFittedDecay.str();
  system(StoreMeanOutputName.c_str());
  system(StorePMTGainName.c_str());
  system(StoreFittedOccuName.c_str());
  system(StoreFittedSPEsigName.c_str());
  system(StoreFittedPEDsigName.c_str());
  system(StoreFittedDecayName.c_str());
}
