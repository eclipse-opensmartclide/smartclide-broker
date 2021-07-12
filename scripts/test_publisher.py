import random
import string
import hashlib
import time
import datetime
import requests

# ===============================================================================
# publish_messages()
# ===============================================================================
def publish_messages():
    # generate random user id
    user_id = ''.join(random.choice(string.digits + string.ascii_lowercase) for _ in range(24))
    string_to_bytes = bytearray(user_id, "ASCII")
    hashed_object = hashlib.md5(string_to_bytes)
    user_id = hashed_object.hexdigest()[:24]
    # initialize counter
    counter = 1
    while True:
        # generate random service id
        service_id = ''.join(random.choice(string.digits + string.ascii_lowercase) for _ in range(24))
        string_to_bytes = bytearray(service_id, "ASCII")
        hashed_object = hashlib.md5(string_to_bytes)
        service_id = hashed_object.hexdigest()[:24]
        # get current date
        current_date = datetime.datetime.fromtimestamp(int(time.time())).strftime('%Y-%m-%d %H:%M:%S')
        # create payload
        payload = {
            'serviceId': service_id,
            'serviceName': 'Test Service ' + str(counter),
            'description': 'A short description of Test Service ' + str(counter) + ' ...',
            'date': current_date,
            'owner': user_id
        }
        # send request
        r = requests.post('http://160.40.53.126:8080/broker/api/v1/publisher/serviceCreation', json=payload)
        print(r.text)
        #print(r.text + ' (payload:', payload)
        counter = counter + 1
        print()

        time.sleep(3)


# ===============================================================================
# main ()
# ===============================================================================
def main():
    print(" * Start sending messages to broker... * ")
    publish_messages()



if __name__ == '__main__':
    main()