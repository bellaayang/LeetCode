
def solve9(arr):
    res = []
    prefix = 0
    for i in range(len(arr)):
        counter = 0
        counter += arr[i] * i - prefix
        res.append(counter)
        prefix += arr[i]
    return res
# 前缀和
