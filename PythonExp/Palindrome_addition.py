#Reverse and add a number, if result is palindrome -> return the result
#else repeat the process
#repeat should not exceed 4,294,967,295
#repeat should not exceed 1000 iterations

#3 main function to considered 
#	1. reverse the digit
#	2. check to see if number is palindrome
# 3. reverse and add

#function to reverse digit
def reverseDigits(n):
	#empty variable to store/return the reverese digit
	rev_num = 0
	while (n > 0):
		#always shift the digit a place before adding a new digit
		#of courese remove/truncate the last digit from original as you add
		rev_num = 10*rev_num + n%10
		n = n/10
	
	return rev_num
	
#function to check for palindrome
def isPalindrome(n):
	return(reverseDigits(n) == n)


#function to reverese and add:
def reverseAdd(n):
		rev_num = 0
		#counter to track iterations
		counter = 0
		while (n < 4294967295):
			#simplest case senario
			if (counter == 999):
				print('No Palindrome exists')
				break
				
			#initiate reverse of digit, and add to original
			rev_num = reverseDigits(n)
			n = n + rev_num

			#check to see if palindrome
			if(isPalindrome(n)):
				print(n)
				break
			else:
				counter += 1
				if(n > 4294967295):
					print('No Palindrome exists')
					break
					
#main for testing
if __name__ == '__main__':

	reverseAdd(195)
	reverseAdd(265)
	reverseAdd(196)
