def solver3 (n, plannedDate, alternateDate):
    arr = sorted(zip(plannedDate, alternateDate))
    last = 0
    for planned, alternate in arr:
        if alternate >= last:
            last = alternate
        else:
            last = planned
    return last



