import requests
import time
import json


# ===============================================================================
# consume_messages()
# ===============================================================================
def consume_messages():
    while True:
        r = requests.get('http://160.40.53.126:8080/broker/api/v1/consumer/security')
        data = r.text
        print(json.loads(data))
        #print('Message received: ', json.loads(data))

        print()

        time.sleep(4)


# ===============================================================================
# main ()
# ===============================================================================
def main():
    print(" * Start receiving messages from Security component queue... * ")
    print()
    consume_messages()


if __name__ == '__main__':
    main()