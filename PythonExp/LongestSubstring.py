# Write a function that take a string
# Return the longest non-repeating substring
# assument there will be only 1 longest substring without any duplication

def longestSubstringNoRepeat(string):
	# declare a hash table to store the last index where the character are seen
	# update this index as the repeat comes in
	# declare a length wise to keep track of the longest substring
	# delcare the current index pointer
	
	subStr = {}
	longest = [0,1]
	startIdx = 0
	
	#begin iterating through the string
	for i in range(len(string)):
		#if the string is found in the index list 
		#update the current pointer to the value directly after the the first duplucation
		if string[i] in subStr:
			startIdx = max(startIdx, subStr[string[i]]+1)
		
		#keep track of the longest string
		if longest[1] - longest[0] < i+1 - startIdx:
			longest = [startIdx, i+1]
			
		#update the substring of characters with the index
		subStr[string[i]] = i
		
	return string[longest[0]:longest[1]]
