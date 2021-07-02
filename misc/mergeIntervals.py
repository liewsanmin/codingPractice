def merge(intervals):
    intervals.sort(key=lambda x: x[0])

    merged = []
    for interval in intervals:
        # if the list of merged intervals is empty or if the current
        # interval does not overlap with the previous, simply append it.
        """
        if not merged or merged[-1][1] < interval[0]:
            import pdb; pdb.set_trace()
            merged.append(interval)
            import pdb; pdb.set_trace()
        else:
        # otherwise, there is overlap, so we merge the current and previous
        # intervals.
            import pdb; pdb.set_trace()
            merged[-1][1] = max(merged[-1][1], interval[1])
            import pdb; pdb.set_trace()
        """
        if not merged: merged.append(interval)
        elif interval[0] <= merged[-1][1]:
            merged[-1][1] = max(merged[-1][1], interval[1])
        else: merged.append(interval)

    return merged

if __name__ == "__main__":
    theInput = [[1,3],[2,6],[8,10],[15,18]]
    print(merge(theInput))