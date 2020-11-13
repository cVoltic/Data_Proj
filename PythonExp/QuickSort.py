def quickSort(array):
    quickSortHelper(array, 0, len(array)-1)
    return array

def quickSortHelper(array,startIdx, endIdx):
        if startIdx >= endIdx:
            return
        pivot = startIdx
        left = startIdx + 1
        right = endIdx
            
        while left <= right:
            if array[left] > array[pivot] and array[left] > array[right]:
                swap(array, left, right)
            # if either pointer condition do not met, we move that pointer
            if array[left] <= array[pivot]:
                left += 1
            if array[right] >= array[pivot]:
                right -= 1
        # when the loop is over, we swap pivot with the right index
        swap(array, pivot, right)
        # check to see which side is smaller
        # move the new pivot and end index appropriately
        # perform quick sort on the smallest sub array first get it sorted faster
        # after that, treat the other size the same
        # vice versa if right subArr is bigger
        leftSubArrIsSmaller = right - 1 - startIdx < endIdx - 1 - right
        if leftSubArrIsSmaller:
            quickSortHelper(array,startIdx, right-1)
            quickSortHelper(array, right+1, endIdx)
        else:
            quickSortHelper(array, right+1, endIdx)     
            quickSortHelper(array, startIdx, right-1)
                        
#function to swap array
def swap(array, i, j):
        array[i], array[j] = array[j], array[i]
