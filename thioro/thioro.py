import requests
import xlsxwriter


def get_info(email):
    url = "https://mail.sangomargroup.com/admin/api/v1/boxes/%s/stats" % email.replace("@", "%40")

    payload={}
    headers = {
    'Authorization': 'Basic dGhpb3JvLnRoaWFtQHNhbmdvbWFyZ3JvdXAuY29tOlNNU1QyU3J3OTY=',
    'Cookie': 'PHPSESSID=72tmh552sv078cenrgpgva77gg'
    }

    response = requests.request("GET", url, headers=headers, data=payload)
    return response.json()


def export_to_xlxs():
    url = "https://mail.sangomargroup.com/admin/api/v1/boxes"
    payload={}
    headers = {
    'Authorization': 'Basic dGhpb3JvLnRoaWFtQHNhbmdvbWFyZ3JvdXAuY29tOlNNU1QyU3J3OTY=',
    'Cookie': 'PHPSESSID=72tmh552sv078cenrgpgva77gg'
    }

    response = requests.request("GET", url, headers=headers, data=payload)

    data = response.json()

    results = data["results"]
    
    date = ['Periode']
    emails = ["Emails"]
    income = ["Entrant"]
    outcome = ["Sortant"]
    

    for item in results:
        sum_in = 0
        sum_out = 0
        emails.append(item["address"])
        stats = get_info(item["address"])
        for periode in stats:
            date.append(stats[periode])
            sum_in += stats[periode]['in']
            sum_out += stats[periode]['out']
            
        income.append(sum_in)    
        outcome.append(sum_out)
             
        print(item["address"] + " in = " + str(sum_in) + " out = "+ str(sum_out))
            
export_to_xlxs()