def read_input():
    t = int(input())  # Read the number of test cases
    test_cases = []
    
    for _ in range(t):
        n, k, x = map(int, input().split())  # Read n, k, and x for each test case
        test_cases.append((n, k, x))
    
    return test_cases

# Example usage
test_cases = read_input()
for n, k, x in test_cases:
    if x!=1:
        print('YES')
        print(n)
        print('1 '* n)
        continue

    if k>=3:
        print('YES')
        print(n//2)
        if(n%2 == 0):
            print('2 '*(n//2))
        else:
            print('2 '*(n//2 - 1) + '3')
        continue

    if k==2 and n%2==0:
        print('YES')
        print(n//2)
        print('2 '*(n//2))
        continue
    print('NO')

