def solve2 (a) :
    left = kadane(a)
    right = kadane(a[::-1])[::-1]
    return max(left[i] + right[i + 1] for i in range (len(a) - 1))

def kadane (arr) :
    res = [0] * len(arr)
    cur = arr[0]
    best = arr[0]
    res[0] = best
    for i in range (1, len(arr)):
        cur = max(cur + arr[i], arr[i])
        best = max(best, cur)
        res[i] = best
    return res





