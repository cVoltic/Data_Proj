'''
Standard Interface use to read and manipulate data
Data reader
Created on: 11-12-2019
Last edited: 11-12-2019

@Copyright - Ken Trinh
@All rights reserve
'''

import abc

class DataInterface(metaclass=abc.ABCMeta):
	def __init__(self):
		return
	def __str__(self):
		return "Generic Data Interface"
	
	#Methods that need to be implemented
	#Additional details applied when neccessary
	
	#Return the name of the input file
	#Description need to be implemented in details
	@abc.abstractmethod
	def getName(self):
		pass
	
	#Return the type of the input file
	#Description need to be implemented in details
	@abc.abstractmethod
	def getType(self):
		pass
	
	#Change current data type to another type
	#Description need to be implemented in details
	@abc.abstractmethod
	def changeType(self):
		pass
	
	#Input Data
	#Description need to be implemented in details
	@abc.abstractmethod
	def readData(self):
		pass
		
	#Output Data
	#Description need to be implemented in details
	@abc.abstractmethod
	def writeData(self):
		pass
		
	'''
	#Display data on a canvas
	#Description need to be implemented in details
	@abc.abstractmethod
	def plotData(self):
		pass
		
	#Zoom into a specific portion of data
	#Description need to be implemented in details
	@abc.abstractmethod
	def zoomIn(self):
		pass
	
	#Zoom out from a specific portion of data
	#Description need to be implemented in details
	@abc.abstractmethod
	def zoomOut(self):
		pass
	
	#Perform a cut on the specified data
	#Description need to be implemented in details
	@abc.abstractmethod
	def cutData(self):
		pass
		
	#Reset all changes made to the data
	#Description need to be implemented in details
	@abc.abstractmethod
	def reset(self):
		pass
	'''

