/* Header File for DetPulseLoader
 * Contains Trigger Filtering Module for PulseCruncher Det Pulse File
 * Contains C++/CERN ROOT includes essentials and all macros
 * Date Created: Mar 30, 2018
 * Date Last Modified: April 1, 2018
 */

//Root Include 
#include "TROOT.h"
#include "TObject.h"
#include "TFile.h"
#include "TTree.h"
#include "TH1.h"
#include "TF1.h"
#include "TCanvas.h"
	
//C++ class
#include <iostream>
#include <cmath>
#include <string>
#include <sstream>
#include <fstream>
#include <vector>
#include <cassert>

using namespace std;
 
#ifndef DETPULSELOADER_HH
#define DETPULSELOADER_HH
class DetPulseLoader{
  protected:
    string Oput, Oput_Dir;
    int nChannel, n;
    vector<long> Pulse;
    //Open file of interest
    TFile *ReadFile
    TTree *ReadTree
  public:
    //Constructor
    DetPulseLoader(string PC_Output, string Output_Dir, int Ch) {
      cout << "Constructor Called\n" << endl;
    }
    //Destructor
    ~DetPulseLoader() {
      cout << "Destructor Called\n" << endl;
    }
  vector<long> Filtered_Pulse(void);
}
 
 
#endif
