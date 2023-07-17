def isSameSign(x, y):
    return (x <= 0 and y <= 0) or (x>=0 and y>=0)

def isDiffSign(x, y):
    return (x <= 0 and y >= 0) or (x>=0 and y<=0)


def read_input():
    t = int(input())  # Read the number of test cases
    test_cases = []
    
    for _ in range(t):
        position_A = tuple(map(int, input().split()))  # Read the position of cell A
        position_B = tuple(map(int, input().split()))  # Read the position of cell B
        position_C = tuple(map(int, input().split()))  # Read the position of cell C
        
        test_cases.append((position_A, position_B, position_C))
    
    return test_cases


for a, b, c in read_input():
    ab = (b[0] - a[0], b[1] - a[1])
    ac = (c[0] - a[0], c[1] - a[1])
    if isSameSign(ab[0], ac[0]) and isDiffSign(ab[1], ac[1]):
        print(abs(min(ab[0], ac[0]))+1)

    if isSameSign(ab[1], ac[1]) and isDiffSign(ab[0], ac[0]):
        print(abs(min(ab[1], ac[1]))+1)