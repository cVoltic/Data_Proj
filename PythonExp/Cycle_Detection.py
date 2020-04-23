# Given an array of numbers
# Return the number that is repeated more than once

#Let's implement cycle detection.
#Logic:
# For any function f that map an infinite set to itself, and any initial values x0 in S, the sequence of itereated function values must eventually use the same value twice
# There must be a pair of distinct indicies i,j such that xi = xj 


def findDuplicate(nums):
	#initialized two array poiting at the first index of nums
	tortoise = nums[0]
	hare = nums[0]
	
	#initialized pointer search for pair indicies
	while True:
		#print(tortoise, hare)
		#one pointer (hare) will point twice as fast
		#ex: [1,2,3,4,2]
		#before this: 
		#tortoise = 1
		#hare = 1
		tortoise = nums[tortoise]
		hare = nums[nums[hare]]
		#after this
		#tortoise = 2
		#hare = 3
		
		#process repeat until
		#the two values are the same; we found our duplication index
		#this duplication index, if not treated, will begin the cycle again

		if tortoise == hare:
			break
		
	#set up the pointer to retrace our step
	ptr1 = nums[0]
	ptr2 = tortoise
	
	#trace back to where the cycle began
	while ptr1 != ptr2:
		print(ptr1, ptr2)
		ptr1 = nums[ptr1]
		prt2 = nums[ptr2]
		
	return ptr1
	
	
if __name__ == '__main__':
	test_set = [2, 7, 1, 5, 4, 3, 7, 6] 
	print(findDuplicate(test_set))
	
	
