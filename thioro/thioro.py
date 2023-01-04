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
    
    thioro = []

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
             
        thioro.append(item["address"] + " in = " + str(sum_in) + " out = "+ str(sum_out))
    return thioro
            
import os
import time
from glob import glob
from prometheus_client import start_http_server, Gauge

class CustomExporter:
    def __init__(self) -> None:
        self.metric_dict = {}

    def create_gauge_for_metric(self, metric_name):
        if self.metric_dict.get(metric_name) is None:
            self.metric_dict[metric_name] = Gauge(metric_name, f"Welcome to my world")
            data = export_to_xlxs()
            for item in data:
                self.metric_dict[metric_name] = Gauge(metric_name, item)
    
    def set_value(self, metric_name):
        self.metric_dict["amir"] = "wone"

    def main(self):
        exporter_port = int(os.environ.get("EXPORTER_PORT", "9877"))
        start_http_server(exporter_port)
        metric_name = f"thioro"
        data = export_to_xlxs()
        while True:
            for item in data:
                self.create_gauge_for_metric(item)
                self.set_value(item)
                time.sleep(10)

if __name__ == "__main__":
    c = CustomExporter()
    c.main()