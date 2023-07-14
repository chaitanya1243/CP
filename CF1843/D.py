

def read_input():
    t = int(input())  # Read the number of test cases
    test_cases = []
    
    for _ in range(t):
        n = int(input())  # Read the number of vertices in the tree
        tree = {}
        
        for _ in range(n - 1):
            u, v = map(int, input().split())  # Read an edge in the tree
            tree.setdefault(u,[]).append(v)
            tree.setdefault(v,[]).append(u)
        
        q = int(input())  # Read the number of assumptions
        assumptions = []
        
        for _ in range(q):
            x, y = map(int, input().split())  # Read the assumed vertices for apples
            assumptions.append((x, y))
        
        test_cases.append((n, tree, q, assumptions))
    
    return test_cases


cache = {}
def dfs(tree, v, parent):
    if v in cache: return cache[v]
    if v != 1 and len(tree[v]) == 1: 
        cache[v] = 1
        return 1
    total = 0
    for child in tree[v]:
        if child == parent: continue
        total += dfs(tree, child, v)
    cache[v] = total
    return cache[v]

def bfs(tree):
    q, order, visited = [1],[], set()
    while q:
        v = q.pop()
        order.append(v)
        visited.add(v)
        for child in tree[v]:
            if child not in visited:
                q.append(child)
    order.reverse()
    return order
        

        
    

# Example usage
def main():
    test_cases = read_input()

    for n, tree, q, assumptions in test_cases:
        ans = {}
        order = bfs(tree)
        for v in order:
            ans[v] = max(sum(ans.get(x,0) for x in tree[v]), 1)

            
        for u,v in assumptions:
            print(ans[u] * ans[v])


main()
