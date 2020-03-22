'''
GUI module graphic generator
Created on: 11-20-2019
Last edited: 11-20-2019

@Copyright - Ken Trinh
@All rights reserve
'''

import tkinter as tk
import abc

class PlotterGUI(metaclass=abc.ABCMeta):
	#Constructor
	def __init__(self):
		pass
	
	#String Method
	def __str__(self):
		return "Generic GUI generator"
		
	
	#Methods that need to be implemented
	#Additional details applied when neccessary
	
	#Create Title
	#Description need to be implemented in details
	@abc.abstractmethod
	def createTitle(self):
		pass
		
	#Create Button
	#Description need to be implemented in details
	@abc.abstractmethod
	def createButton(self):
		pass
	
	#Reset everything
	#Description need to be implemented in details
	@abc.abstractmethod
	def reset(self):
		pass
	
