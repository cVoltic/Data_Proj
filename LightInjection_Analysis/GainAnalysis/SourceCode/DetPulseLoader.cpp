/* Header File for DetPulseFilter
 * Contains Trigger Filtering Module for PulseCruncher Det Pulse File
 * Contains C++/CERN ROOT includes essentials and all macros
 * Date Created: Mar 30, 2018
 * Date Last Modified: Jun 5, 2018
 */
#include "DetPulseLoader.hh"
DetPulseLoader::DetPulseLoader(string PC_Output, string Output_Dir, int Ch){
  //Unloading Variables
  Oput = PC_Output;
  Oput_Dir = Output_Dir;
  nChannel = Ch;
  //Open PCOutput File and called in DetPulse Tree and gets all of its parameters
  ReadFile = ReadFile = TFile::Open(Oput.c_str());
  ReadTree = (TTree*)ReadFile->Get("DetPulse");
  n = ReadTree->GetEntries();
  return ReadFile,ReadTree;
}

vector<long> DetPulseLoader::Filtered_Pulses(){
  float area=0;
  int detector=0;
  Long64_t event=0;
  ReadTree->SetBranchAddress("a", &area);
  ReadTree->SetBranchAddress("det", &detector);
  ReadTree->SetBranchAddress("evt", &event);

  //declaration of variables to locate spe trigger
  Long64_t evtmap=0, evtprev=0;
  int Dmap=0;

  //create a flag one of events (Filtering Flag system)
  //THis is map to PulseCruncher output. Change this is PulseCruncher change somehow... always a good a idea to look at the .h5 files first
  for (int p = 0; p < n; p++){    //loop through each events in the file
    ReadTree->GetEntry(p);             
    evtmap = event;
    Dmap = detector;
    //run to each set of PMT event to locate a counter, add a counter to Remember this event
    if (Dmap == -100) {
      evtprev = evtmap;
      Pulse.push_back(event);
      cout << Pulse.back() << endl;
    }
    //Get rid of repeating -100 Ch
    if ((evtmap == evtprev) && (Dmap == -100)) continue;  
  }
  return Pulse;
}

