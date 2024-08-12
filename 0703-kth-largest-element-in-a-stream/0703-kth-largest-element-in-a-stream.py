class KthLargest:
    nlist = list()
    gk = 0
    def __init__(self, k: int, nums: List[int]):
        global nlist
        global gk
        
        gk = k
        nlist = nums.copy()
        nlist.sort()

    def add(self, val: int) -> int:
        nlist.append(val)
        nlist.sort()
        return nlist[-gk]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)