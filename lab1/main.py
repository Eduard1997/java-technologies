from urllib.parse import urlencode
from urllib import parse
from urllib.request import Request, urlopen
import concurrent.futures
import random
import string

url = "http://localhost:8080/lab1-1.0-SNAPSHOT/process-form"
threads = 10;

def callWorker():
    payload = {'key': 'abra432', 'value': '5', 'sync': 'false', 'mock': 'false' }
    payload = parse.urlencode(payload).encode()
    request = Request(url, data=payload)
    response = urlopen(request).read().decode()
    print(response)


if __name__ == "__main__":
    with concurrent.futures.ThreadPoolExecutor(max_workers=threads) as executor:
        futures = [executor.submit(callWorker)]
        for future in concurrent.futures.as_completed(futures):
            try:
                response = future.result()
            except Exception as ex:
                print(ex)
