def read_input():
    t = int(input())  # Read the number of test cases
    test_cases = []
    
    for _ in range(t):
        n = int(input())  # Read the length of the array
        arr = list(map(int, input().split()))  # Read the array elements
        test_cases.append((n, arr))  # Append the test case to the list
    
    return test_cases

def read_input1():
    t = int(input())  # Read the number of test cases
    test_cases = []
    
    for _ in range(t):
        n = int(input())  # Read the length of the array
        test_cases.append(n)  # Append the test case to the list
    
    return test_cases
    
def read_input2():
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




def sort_and_calculate_cumsum(arr):
    arr.sort()  # Sort the array in ascending order
    cumsum = 0
    n = len(arr)
    
    for i in range(n // 2):
        cumsum += arr[n - i - 1] - arr[i]
    
    return cumsum
    
    
def count_sequences(arr):
    count = 0
    s = 0
    sequence_started = False
    
    for num in arr:
        s += abs(num)
        if num == 0: continue
        if num <= 0:
            if not sequence_started:
                count += 1
                sequence_started = True
        else:
            sequence_started = False
    
    return s, count
    
def prob3(n):
    s = n
    while n > 1:
        n = n//2
        s += n
        
    return s;

cache = {}
# def leaves(tree, root, parent):
#     if root in cache: return cache[root]
#     if len(tree[root]) = 1: return cache[root] = 1;
#     s = 0;
#     for child in tree[root]:
#         if child == parent continue;
#         s += leaves(tree, child, root)
#     return cache[root] = s
        
    

# Example usage
test_cases = read_input2()
# for n, arr in test_cases:
#     s, count = count_sequences(arr)
#     print(s, count)

# for n, tree, q, assumptions in test_cases:
#     cache = {}
#     leaves(tree, 1, 0)
#     for u,v in assumptions:
#         print(cache[u] * cache[v])

