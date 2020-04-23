#Given an array of possible steps and an integer n,
#Return the number of possible combination can go into n.

#simple solution for arr = [1,2] steps -> Fibonacci Sequence reduced
def num_ways_two(n):

	#base case solution
	if n == 0 or n == 1: return 1
	#initialized empty array of length n+1
	#set up the two base cases
	num_ways = [None]*(n+1)
	num_ways[0] = 1
	num_ways[1] = 1
	
	#iterate to length of array from the first two steps
	for i in range(2,n+1):
		num_ways[i] = num_ways[i-1] + num_ways[i-2]

	return num_ways[n]
	
	
#simple solution for arr = [1,2] steps -> Fibonacci Sequence reduced
def num_ways_X(n,X):

	#lets's assume X = [1,3,5] for now
	#base case solution
	if n == 0 or n == 1: return 1
	#initialized empty array of length n+1
	#set up the two base cases
	num_ways = [None]*(n+1)
	num_ways[0] = 1
	num_ways[1] = 1
	
	#iterate to length of array from the first two steps
	for i in range(2,n+1):
		total = 0
		#we need an extra loop for X here
		#interestingly, we can replace X here and it would work
		for j in X:
			#add the condition to prevent negative
			if i-j >= 0:
				total += num_ways[i-j]
				print
		#add it to the main array
		num_ways[i] = total
	return num_ways[n]
	
#testing
if __name__ == '__main__':
	X = [1,3,5,7]
	n=7
	print(num_ways_X(n,X))
	
