try:
    from math import radians, cos, sin, asin, sqrt
    n=int(input())
    lt=list(map(float,input().split()))
    lg=list(map(float,input().split()))
    ht=list(map(int,input().split()))
    jn=list(map(float,input().split()))
    r=6371
    tr=list(zip(lt,lg,ht))

    def dist(x1, x2, y1, y2):
        y1 = radians(y1)
        y2 = radians(y2)
        x1 = radians(x1)
        x2 = radians(x2)
        d1 = y2 - y1
        d2 = x2 - x1
        a = sin(d2 / 2) ** 2 + cos(x1) * cos(x2) * sin(d1 / 2) ** 2
        c = 2 * asin(sqrt(a))
        return c * r

    def isOK(q,z):
        vx=pow(q[2]*2*r,0.5)
        vy=dist(q[0],z[0],q[1],z[1])
        return vy<=vx

    ans=0
    for i in range(n):
        if isOK(tr[i],jn):
            ans+=1
    print(ans)
except:
    pass