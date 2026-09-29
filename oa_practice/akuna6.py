from decimal import ROUND_HALF_UP, Decimal
import math


def solve6(ticks, cabinetPrice, prices):
    n = len(prices)
    res = []
    for i in range(n):
        price = prices[i]
        if price == cabinetPrice:
            res.append(price)
        else:
            for lower, upper, width in ticks:
                if lower <= price < upper:
                    p = Decimal(str(price))
                    w = Decimal(str(width))
                    k = (p / w).to_integral_value(rounding=ROUND_HALF_UP)
                    res.append(float(k * w))
                    break
            else:
                res.append(price)
                    
                
    return res
