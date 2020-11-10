## given an array and a target
## outut the number of pairs that reach the target


def uniquePairs(array, target):
	##declare two sets to store our answer
	ans, comp = set(), set()
	

	for profitYear in array:
		##diff -> let us search the rest of the array for a match
		diff = target - profitYear
		
		##when diff is in the composition set already
		##this happen profit year is the exact value 
		##that when add back to the value in comp will reachg the target
		if diff in comp:
			##sort the tuple so that there is no way we can get a second match
			order = (profitYear, diff) if profitYear > diff else (diff, profitYear)
			##add to our answer if not already there
			if order not in ans:
				ans.add(order)
		
		##add to the composition set the profit year so we can keep track
		##of what year we are in
		comp.add(profitYear)
		
	return len(ans)







if __name__=="__main__":
	array = [1,1,2,45,46,46]
	target = 47
	
	output = uniquePairs(array,target)
	print(output)
