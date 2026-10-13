from collections import deque


def solve10 (cityNodes, cityFrom, cityTo, company):
    adj = [[] for _ in range(cityNodes + 1)]
    for i in range(len(cityFrom)):
        u = cityFrom[i]
        v = cityTo[i]
        adj[u].append(v)
        adj[v].append(u)
    
    dist = [-1] * (cityNodes + 1)
    dist[company] = 0
    q = deque([company])

    while q:
        cur = q.popleft()
        for next in adj[cur]:
            if dist[next] == -1:
                dist[next] = dist[cur] + 1
                q.append(next)
    cities = []
    for i in range(1, cityNodes + 1):
        if dist[i] != -1 and i != company:
            cities.append((dist[i], i))
    cities.sort()
    res = []
    for i, j in cities:
        res.append(j)

    
    return res