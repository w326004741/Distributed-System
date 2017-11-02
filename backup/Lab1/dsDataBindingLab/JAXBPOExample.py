# Phython can read the same JSON file without any difficulty

import json
from pprint import pprint

with open('order.json') as data_file:    
    data = json.load(data_file)
pprint(data)

name = data["billTo"]["name"]
print(name)