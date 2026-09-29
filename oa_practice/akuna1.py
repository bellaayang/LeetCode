def solve (minComps, speed, speedThreshold):
    res = 0
    idx = 0
    sum = 0
    for s in speed:
        sum += s
        idx += 1
        if idx >= minComps and sum >= speedThreshold:
            res += 1
            idx = 0
            sum = 0
    return res
