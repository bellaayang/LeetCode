from collections import deque


def solve8(logs, window, limit):
    q = deque()
    total = 0
    res = []
    for i in range(len(logs)):
        t, size = logs[i]
        while q and q[0][0] <= t - window:
            old_time, old_size = q.popleft()
            total -= old_size
        if total + size <= limit:
            q.append((t, size))
            total += size
            res.append(i)
    return res

        