'''
# Simple alogrithm to demonstrate string search
# Given a main string and an input of several smaller strings
# Output wheather each smaller string showed up in the main string
# EX:
# input: 
# main_str = "abcdefghdas"
# sub_str = "ab abc def defgh asd"
# output:
# true, true, true, true, false
'''

#Construction of decomposition function
def StrDecomposition(main,sub):
	#create an empy list store our result
	result = []
	
	#obviously we need to run through each sub-string
	for i,n in enumerate(sub):
		#getting the length of the substring we are working with
		n_len = len(n)
		
		#now, let's check for the existing of this string in the main string
		j=0
		while(j < len(main)):
			#first case senario,
			#the end of main string is reach but still cant find the sub string
			#append false to the list and breate out of loop
			if(j == len(main)-1):
				result.append('false')
				break
		
			#if the string exist, append true to our result list and break out of loop
			if(n == main[j:j+n_len]):
				result.append('true')
				break
			#if the string is not found, 
			#but it is not the end of main string
			#scan the next element of the loop
			elif (j != len(main)-1):
				j+=1
			
	#ofcourse we return the list here
	return result
'''
#now obviously the previous function was an O(n) complexity
#since every substring will require us to scan the main string at least once
#we can do better by applying binary search tree O(nlogn) complexity
def BinaryStrDecomposition(main,sub):
	#create an empy list store our result
	result = []
	
	#obviously we need to run through for each sub-string
	for i,n in enumerate(sub):
		#getting the length of the substring we are working with
		n_len = len(n)
		print (n)
		#theory:
		#1. break the search of main string into two parts
		#2. front and back
		#3. front = length of substring
		#4. back = remaining
		#5. if front -> stop
		#6. else -> search back repeat
		
		#break main
		#memorize main string
		main_memory = main
		front = True
		back = False
		should_restart = True
		
		while(should_restart):
			should_restart = False
			while(front):
				#if found in front
				if (n == main_memory[0:n_len]):
					result.append('true')
					break
				else:
					front = False
					back = True
					break

			while(back):
				#get rid of whatever not found in front from main string and restart
				main_memory = main_memory[n_len:]
				front = True
				back = False
				should_restart = True
			
			#if nothing found after our search
			if(len(main_memory) == 0):
				should_restart = False
				result.append('false')
				break
	#ofcourse we return the list here
	#though this method is fast, we have a senario where a substr lies in the exact middle of the cut
	return result
'''


#Main Function for output
if __name__ == "__main__":
	main_str = "abcdefghdas"
	sub_str = "ab abc def defgh asd"
	
	#turn substring into a list of substrings to work with easier
	sub_str_decom = sub_str.split()
	#print our result
	result = StrDecomposition(main_str,sub_str_decom)
	for i, n in enumerate(result):
		print(n)
	
