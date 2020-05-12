/* Header File for LIAnalysis Module
 * Contains PMTGain Analysis for Light Injection Module
 * Contains C++/CERN ROOT includes essentials and all macros
 * Date Created: Aug 28, 2017
 * Date Last Modified: Sep 11, 2017
 */

#ifndef GAINANALYSIS_HH
#define GAINANALYSIS_HH

#include "DetPulseLoader.hh"

class GainAnalysis: {
  protected:
    //Gain Analysis Mode
    //mode = 0;  Combine Segmented Data for Gain Analysis
    //mode = 1;  Single File for Gain Analysis
    //mode = 2;  Combined Voltage for Gain Analysis
    DetPulseLoader Pulse;
    ostringstream AreaCH;
    string AreaCHName;
    string Output_Dir;
    TFile *WriteFile;
    TFile *ReadFile;
    TTree *ReadTree;
    vector<long> FPulse;
    int nChannel;
    int range_low=-50, range_high=500;         //I think this could be move to constructor of the class...
  public:
    //Constructor
    GainAnalysis(string POput, string Oput_Dir, int Ch) {
      cout << "Constructor Called\n" << endl;
    }
    ~GainAnalysis() {
      cout << "Destructor Called\n" << endl;
    }
    //Isolate area branch from DetPulse Tree of PulseCruncher Output
    void ExtractArea();
    //Run Fitting Function through area branch to obtain SPEMean
    void SPEFit();
    //Calculate PMTGain from obtained SPEMean
    void CalcGain();
    
};

#endif

