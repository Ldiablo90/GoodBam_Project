import RPi.GPIO as GPIO
import datetime
import time
import requests 
import Adafruit_DHT

sensor = Adafruit_DHT.DHT11
pin = 4
#핀 번호 할당 방법은 커넥터 핀 번호로 설정
GPIO.setmode(GPIO.BCM)
GPIO.setup(22, GPIO.OUT, initial=GPIO.LOW)#그린
GPIO.setup(23, GPIO.OUT, initial=GPIO.LOW)#블루
GPIO.setup(24, GPIO.OUT, initial=GPIO.LOW)#레드


try:
    while True :
        
        humidty, temperature = Adafruit_DHT.read_retry(sensor, pin)

    

        if humidty is not None and temperature is not None :
            print("Temperature = {0:0.1f}*C Humidity = {1:0.1f}%".format(temperature, humidty))
            float discomfortIndex = (1.8 * temperature) - (0.55 * (1 - humidity / 100.0) * (1.8 * temperature - 26)) + 32;
            #측정된 온도, 습도값으로 불쾌지수 값 계산 후 시리얼 모니터에 출력
            print(discomfortIndex)
            
            if discomfortIndex > 70: #불쾌지수가 70이상이면 파랑LED
                GPIO.output(22,GPIO.LOW)
                GPIO.output(23,GPIO.HIGH)
                GPIO.output(24,GPIO.LOW)
            else:
                #불쾌지수가 미만이이면 초록LED
                GPIO.output(22,GPIO.HIGH)
                GPIO.output(23,GPIO.LOW)
                GPIO.output(24,GPIO.LOW)
            
            temperature = str(temperature)
            humidty = str(humidty)
            raspID = str(1)
            
            now = datetime.datetime.now()
            date = now.strftime('%Y-%m-%d')
            time = now.strftime('%H:%M:%S')
            data = requests.get('http://192.168.0.61:8070/test?&temperature='+temperature+'&humidty='+humidty+'&raspID='+raspID
            +'&date='+date+'&time='+time)
            print(data.text)

        else :
            print('Read error')
        time.sleep(3)

except KeyboardInterrupt:

    print("Terminated by Keyboard")

finally:

    print("End of Program")
