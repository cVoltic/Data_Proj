'''
Program to determine seed of number
seed = number that multiply by its digit returns the original number
Ex:
seed of 738 is 123 because 123*1*2*3 = 738
'''

#Declare string with fixed size
#This is use to store the digit to be multiplied together (the product digit)

MAX = 10000
proDigit = [0] * MAX

#Function to store product of digits of
#x in prodDigit[x]
def getDigitProduct(x):
	
	#if given digit x is a single digit
	if x < 10:
		return x
		
	#if product is already compute
	#this is a check in case we have multiple seed of a given number
	if (proDigit[x] != 0):
		return proDigit[x]
		
	#compute product digit
	#This is an actual computaional step
	prod = (int(x%10))*getDigitProduct(int(x/10))
	
	#remember that we have a value stored if there is a value stored previously
	proDigit[x] = prod
	return prod 

 
#print all seed of n
def findSeed(n):
	#define empty array to store the seed
	res = []
	
	#find all seeds using previous medthod
	#scan every number from 1 to half of given number
	for i in range(1, int (n/2 + 2)):
		if (i*getDigitProduct(i) == n):	
			res.append(i)
			
	#if there is no seed
	if (len(res) == 0):
		print ("There is no seed for this number")
		return
	
	#print the seed
	for i in range (len(res)):
		print(str(res[i])+"\n")
		
		
n = 4977
findSeed(n)
