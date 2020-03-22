'''
Data Import Module
Created on: 11-12-2019
Last edited: 11-12-2019

@Copyright - Ken Trinh
@All rights reserve
'''
from DataInterface import *

class ReadData(DataInterface):
	#Class Constructor
	def __init__(self, data):
		self.__data = data
		
	def __str__(self):
		return "Data Read Successfully"
	
	#get name of data
	def getName(self):
		return self.__data
	
	#get data type
	def getType(self):
		return ("This file is in a .{} format".format(self.__data[-3:]))
		
	#import data as string
	def readData(self):
		f = open(self.__data, 'r')
		return f
	
	
if __name__ == "__main__":
	testData = ReadData("TestData.txt")
	print(testData.getType())

