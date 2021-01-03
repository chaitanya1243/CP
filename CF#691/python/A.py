


def solve(n, red , blue):
    rcount = bcount = 0
    for i in range(n):
        if int(red[i]) > int(blue[i]):
            rcount = rcount +1
        elif int(red[i]) < int(blue[i]):
            bcount = bcount + 1
    print( 'RED' if rcount>bcount else ('BLUE' if bcount>rcount  else 'EQUAL'))

if __name__ == "__main__":
    T = int(input())
    for t in range(T):
        n = int(input())
        red = input()
        blue = input()
        solve(n, red, blue)