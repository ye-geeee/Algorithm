from collections import Counter
from functools import reduce

def solution(clothes):
    return reduce(lambda x, y : x * (y+1), Counter(kind for name, kind in clothes).values(), 1) - 1

if __name__ == '__main__':
     clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
     print(solution(clothes))