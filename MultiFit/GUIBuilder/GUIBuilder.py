'''
Data Import Module
Created on: 11-21-2019
Last edited: 11-21-2019

@Copyright - Ken Trinh
@All rights reserve
'''

import sys


from CPanel import *
from tkinter import filedialog


def function():
	pass

#import data file
def openFile():	
		filename = filedialog.askopenfilename(initialdir = "/",title = "Select file",filetypes = (("text files","*.txt"),("all files","*.*")))
		DataPlotter.inputFile = open(filename, 'r')
		return DataPlotter.inputFile
		
	
class MenuBar(tk.Menu):
	def __init__(self, parent):
		tk.Menu.__init__(self, parent)

		fileMenu = tk.Menu(self, tearoff=False)
		self.add_cascade(label="File",underline=0, menu=fileMenu)
		# Add sub command to File tab
		fileMenu.add_command(label = "New file...", command = function) 
		fileMenu.add_command(label = "Open files", command = openFile)

		# it adds a line after the latest menu
		fileMenu.add_separator() 
		fileMenu.add_command(label="Exit", underline=1, command=self.quit)

		#Create Edit tab
		editMenu = tk.Menu(self,tearoff=False)
		self.add_cascade(label = "Edit", menu = editMenu)
		
		#Add sub commands to Edit tab
		editMenu.add_command(label = "Undo", command = function)
		editMenu.add_command(label = "Redo", command = function)
		
	def quit(self):
		sys.exit(0)
		

		
class App(tk.Tk):
	def __init__(self, *args, **kwargs):
		tk.Tk.__init__(self, *args, **kwargs)
		tk.Tk.title(self, "MultiFit 2")
		
		#Call Menu Bar
		menubar = MenuBar(self)
		self.config(menu=menubar)
		
		container = tk.Frame(self)
		container.pack(side="top", fill="both", expand = True)
		container.grid_rowconfigure(0, weight=1)
		container.grid_columnconfigure(0, weight=1)

		#Initializing Loop to cycle through different tasks
		self.frames = {}
		for F in (CPanel, DataPlotter):

			frame = F(container, self)
			self.frames[F] = frame
			frame.grid(row=0, column=0, sticky="nsew")
		
		self.show_frame(CPanel)


	#Reinistialized current frame
	def show_frame(self, cont):
		frame = self.frames[cont]
		frame.tkraise()

if __name__ == "__main__":
	app=App()
	app.mainloop()
