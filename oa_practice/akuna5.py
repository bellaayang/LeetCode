def solve5 (s):
    n = len(s)
    res = 0
    for i in range(n):
        if s[i] == '1':
            j = i + 1
            while j < n:
                if s[j] == '0':
                    zero = 0
                    while j < n and s[j] == '0':
                        zero +=1
                        j += 1
                    res += 1 + zero
                else:
                    j += 1
    return res
                    
print(solve5("10101"))  # 6
print(solve5("1010"))   # 6
print(solve5("10010"))  # 7
print(solve5("11"))     # 0
print(solve5("0011"))   # 0
print(solve5(""))       # 0           
