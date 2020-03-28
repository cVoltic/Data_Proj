'''
Program use to print all permuations of a string 
Cannot change the position of upper case alphabet
Ex:
[aBcDeF] has 6 permutations including self:

[aBeDcF]
[cBaDeF]
[cBeDaF]
[eBaDcF]
[eBcDaF]

'''
from itertools import permutations

#method to split the string
def split(word):
	return list(word)

#medthod to get permutation of the string
def splitCases(word):
	#Split word into a list of number -> allow us to isolate upper and lowercase letter
	tempString = split(word)


	#temporary string to store lowercase letter
	lowerString = []
	upperString = [None]*len(tempString)
	
	#Split input into a string of uppercase and a string of lowercase
	for i in range(0,len(tempString)):
		if(tempString[i].islower() == True): lowerString.append(tempString[i])
		elif(tempString[i].isupper() == True): upperString[i] = tempString[i]
	
	return upperString, lowerString

def getPermutation(upperString, lowerString):
	
	#Get all permutation for lowercase letters
	perm = permutations(lowerString)
	
	#total list to store all permutation
	totalPerm = []
	
	#loop to create a list of all permutation
	for j in list(perm):
	
		#completePerm is always a copy of upperString
		completePerm = upperString[:]

		#Turn a tuple into a list to use Pop method
		#This is the current permutation we are interested in
		currentPerm = list(j)
		
		#look at each value in original string length
		#add current value accordingly
		for k in range(0,len(completePerm)):
			if (completePerm[k] == None):
				completePerm[k] = currentPerm[0]
				currentPerm.pop(0)		
					
		#add to total permutation list	
		#reintialized completePerm to fixed uppercase letters
		totalPerm.append(completePerm)	
		completePerm = upperString[:]
	
	return totalPerm
	

test = "adwFgDb"
upperCase, lowerCase = splitCases(test)
perm = getPermutation(upperCase, lowerCase)
for i in perm:
	print i
