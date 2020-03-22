'''
Data Import Module
Created on: 11-12-2019
Last edited: 11-20-2019

@Copyright - Ken Trinh
@All rights reserve
'''
#from src import *
from tkinter import filedialog

class DataAccessor():
	#Class Constructor
	def __init__(self):
		self.__data = ""
		self.__type = self.__data[-3:]
		
	def __str__(self):
		return "Data Read Successfully"
	
	#return the data file name
	def getName(self):
		return self.__data
	
	#return the data file type
	def getType(self):
		return ("This file is in a .{} format".format(self.__type))
	
	#change the current data file type	
	def changeType(self, newType):
		self.__type = newType
		self.__data = self.__data.replace(self.__data[-3:],self.__type)
		return self.__data
		
	#import data file
	def readData(self):
	
		self.__data = filedialog.askopenfilename(initialdir = "/",title = "Select file",filetypes = (("text files","*.txt"),("all files","*.*")))
		inputFile = open(self.__data, 'r')
		return inputFile
	
	#export data as a file
	def writeData(self,exportFile):
		outputFile = open(exportFile, 'w')
		return outputFile
		
'''	
if __name__ == "__main__":
	testData = DataAccessor("TestData.txt")
	#testData.changeType("dat")
	write = testData.writeData("newData.dat")
	for line in range (0,10):
		write.write("line\n")
	print(testData.getType())
'''
