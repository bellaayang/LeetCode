def solve4 (n, edges, values, k):
    res = float('-inf')
    adj = [[] for _ in range(n)] #建邻接表
    for u, v in edges:
        adj[u].append(values[v])
        adj[v].append(values[u])
    for i in range(n):
        arms = sorted(adj[i], reverse=True)
        total = values[i]
        for x in arms[:k]:
            if x <= 0:
                break
            total += x
        res = max(res, total)
    return res
