'''
Data Import Module
Created on: 11-20-2019
Last edited: 11-20-2019

@Copyright - Ken Trinh
@All rights reserve
'''
#Setting up tkinter application to use with matplotlib
import matplotlib
matplotlib.use("TkAgg")
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
from matplotlib.figure import Figure

#import tkinter for GUI
import tkinter as tk
from tkinter import ttk

#Global Font Variable
LARGE_FONT = ("Helvetica", 12) 

inputFile = ""

class DataPlotter(tk.Frame):
	#constructor
	def __init__(self, parent, controller):
		#Super Frame constructor
		tk.Frame.__init__(self, parent)
		
		#Private variable for graphing page
		self.__label = tk.Label(self, text="Test Graph", font = LARGE_FONT)
		self.__label.pack(pady = 10, padx = 10)
		
		
		self.__figure = Figure(figsize=(5,5), dpi=100)
		#Test Plot (make sure it is doing what it suppose to)
		a = self.__figure.add_subplot(111)
		'''
		x = []
		y = []
		
		for line in inputFile:
			if len(line)>1:
				s = line.split(" ")
				print(s)
				x.append(int(s[0]))
				y.append(int(s[1]))
		a.plot(x,y)
		'''
		a.plot([1,2,3,4,5,6,7,8],[5,6,1,3,8,9,3,5])
		self.__canvas = FigureCanvasTkAgg(self.__figure, self)
		self.__canvas.draw()
		self.__canvas.get_tk_widget().pack(side=tk.BOTTOM, fill=tk.BOTH, expand=True)

	def __str__(self):
		return "Module for plotting data"
'''
	#Plot Method
	def Plot(self, inputFile):
		#Test Plot (make sure it is doing what it suppose to)
		a = self.__figure.add_subplot(111)
		x = []
		y = []
		for line in inputFile:
			if len(line)>1:
				s = line.split(" ")
				x.append(int(s[0]))
				y.append(int(s[1]))
		a.clear()
		a.plot(x,y)
		self.__canvas = FigureCanvasTkAgg(self.__figure, self)
		self.__canvas.draw()
'''	


