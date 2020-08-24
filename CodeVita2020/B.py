try:
    n=int(input())
    # input()
    lat=list(map(float,input().split()))
    # input()
    long=list(map(float,input().split()))
    # input()
    height=list(map(int,input().split()))
    # input()
    jason=list(map(float,input().split()))
    # input()
    radius=6371
    tower=list(zip(lat,long,height))

    def reach(heig):
        val=2*heig*radius
        dist=pow(val,0.5)
        return dist


    from math import radians, cos, sin, asin, sqrt


    def distance(lat1, lat2, lon1, lon2):
        lon1 = radians(lon1)
        lon2 = radians(lon2)
        lat1 = radians(lat1)
        lat2 = radians(lat2)

        # Haversine formula
        dlon = lon2 - lon1
        dlat = lat2 - lat1
        a = sin(dlat / 2) ** 2 + cos(lat1) * cos(lat2) * sin(dlon / 2) ** 2
        c = 2 * asin(sqrt(a))
        return c * radius

    def possible(tow,jas):
        x=reach(tow[2])
        y=distance(tow[0],jas[0],tow[1],jas[1])
        return y<=x

    count=0
    for i in range(n):
        if possible(tower[i],jason):
            count+=1
    print(count)
except :
    pass