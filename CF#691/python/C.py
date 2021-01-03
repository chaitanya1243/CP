import math



def main():
    n, m = (int(x) for x in input().split())

    l1 = [int(x) for x in input().split()]
    l2 = [int(x) for x in input().split()]
    # print(l1)
    if len(l1)==1:
        xx = [str(l1[0]+x) for x in l2]
        # print(xx)
        print(*xx)
        # ' '.
        exit()

    common_gcd = l1[1]-l1[0]


    for i in range(1, len(l1)):
        common_gcd = math.gcd(common_gcd, l1[i]-l1[0])
    # print(common_gcd)
    # ans = ''

    # for i in l2:
    #     ans = ans + str(math.gcd(common_gcd, l1[0]+i)) + ' '

    print(*[math.gcd(common_gcd, l1[0]+i) for i in l2])

if __name__ == "__main__":
    main()
    # li = []
    # import array
    # array.array.

    
    
