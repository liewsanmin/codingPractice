"""
return the 3 most frequent sites
"""
from csv import reader
def get3MostFrequent(filename):
    try:
        hm = {}
        with open(filename, 'r') as read_obj:
            rows = reader(read_obj)
            for row in rows:
                if(row[0] == 'row'): continue
                sitename = row[2]
                if(row[2] not in hm):
                    hm[sitename] = 1
                else:
                    hm[sitename] += 1

        sortedLst  = sorted(hm.items(), key=lambda item: item[1], reverse=True)
        curlist = list(sortedLst)
        return curlist[0:3]
    except Exception as e:
        print(str(e))

"""
get total input and output bytes
"""
def getTotalBytes(filename):
    try:
        hm = {}
        with open(filename, 'r') as read_obj:
            rows = reader(read_obj)
            for row in rows:
                if(row[0] == 'row'): 
                    continue
                if(row[3] != ''): 
                    inputBytes = float(row[3])
                if(row[4] != ''): 
                    outputBytes = float(row[4])
                sitename = row[2]
                if sitename not in hm:
                    hm[sitename] = [inputBytes, outputBytes]
                else:
                    hm[sitename] = [hm[sitename][0]+inputBytes, hm[sitename][1]+outputBytes]
        return hm
    except Exception as e:
        print(str(e))
        

if __name__ == "__main__":
    # print(get3MostFrequent("screen_share_interview_data.csv"))
    print(getTotalBytes("screen_share_interview_data.csv"))