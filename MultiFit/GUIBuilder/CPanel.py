'''
Control Panel Module
Created on: 11-20-2019
Last edited: 11-20-2019

@Copyright - Ken Trinh
@All rights reserve
'''


#import DataPlotter Class
#TODO: move DataPlotter to desginated module folder
from DataPlotter import *

class CPanel(tk.Frame):
	#constructor
	def __init__(self, parent, controller):
		tk.Frame.__init__(self,parent)
		label = tk.Label(self, text="Control Panel", font=LARGE_FONT)
		label.pack(pady=10,padx=10)
		
		#self.__Plotter = DataPlotter(parent, controller)
		
		button = ttk.Button(self, text="Plot",
												command=lambda: controller.show_frame(DataPlotter))
		button.pack()

	
	def __str__(self):
		return "Module Main Control Panel"


