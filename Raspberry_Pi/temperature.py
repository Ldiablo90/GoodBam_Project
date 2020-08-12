import RPi.GPIO as GPIO
import datetime
from time import sleep
import requests 
import Adafruit_DHT
import json
import urllib.request
import threading
#온습도 센서 데이터 획득을 위한 Adafruit_DHT 라이브러리 설치
#LED 제어를 위해 RPi.GPIO 설치
sensor = Adafruit_DHT.DHT11
pin = 4
green = 15
blue = 16
red = 18
#핀번호 할당
GPIO.setmode(GPIO.BOARD)
GPIO.setup(green, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(blue, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(red, GPIO.OUT, initial=GPIO.LOW)
#3색 LED초기화

LED = 11
GPIO.setup(LED, GPIO.OUT, initial=GPIO.LOW)
#LED 초기화
global url
url = 'http://192.168.0.61:8070/sensor'
#웹서버 주소
def tempData():
        
        humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)

        if humidity is not None and temperature is not None :
            print("Temperature = {0:0.1f}*C Humidity = {1:0.1f}%".format(temperature, humidity))
            discomfortIndex = (1.8 * temperature) - (0.55 * (1 - humidity / 100.0) * (1.8 * temperature - 26)) + 32;
            #측정된 온도, 습도값으로 불쾌지수 값 계산 후 시리얼 모니터에 출력
            print(discomfortIndex)
          
            if discomfortIndex > 70: 
                #불쾌지수 70 이상 시 파랑색
                GPIO.output(green,GPIO.HIGH)
                GPIO.output(blue,GPIO.LOW)
                GPIO.output(red,GPIO.HIGH)
            else:
                #불쾌지수 70 이상 시 초록색
                GPIO.output(green,GPIO.LOW)
                GPIO.output(blue,GPIO.HIGH)
                GPIO.output(red,GPIO.HIGH)
            
            temperature = str(temperature)
            humidity = str(humidity)
            raspID = str(1)
            
            now = datetime.datetime.now()
            date = now.strftime('%Y-%m-%d')
            time = now.strftime('%H:%M:%S')
            data = requests.get('http://192.168.0.61:8070/test?&temperature='+temperature+'&humidty='+humidity+'&raspID='+raspID
            +'&date='+date+'&time='+time)
            print(data.text)
            #reuqest GET 방식으로 습득한 온습도를 웹서버로 전송
        else :
            print('Read error')



def sensorData():
    
    json_data = urllib.request.urlopen(url).read()
    text_data = json.loads(json_data)
    sensorDate = sorted(text_data, key = lambda db_sensor: db_sensor['sensorDate'])

    for db_sensor in sensorDate:
        rs = db_sensor['ledSensor']
        #웹서버에서 받은 데이터 변수 rs에 저장
    return rs


def LED_1():
    rs = sensorData()
    if rs==str(1):
      print('GPIO.HIGH')
      GPIO.output(LED, GPIO.HIGH)
      #DB에서 받은 데이터가 1이면 LED켜짐짐
    elif rs==str(0):
      print('GPIO.LOW')
      GPIO.output(LED,GPIO.LOW)
      #DB에서 받은 데이터가 0이면 LED꺼짐 
    else :
        print('error') 
        
        
def test1():
    while True:
        tempData()
        sleep(300)
        #5분 단위로 함수 실행

def test2():
    while True:
        sensorData()
        sleep(5)
        #5초 단위로 함수 실행
def test3():
    while True:
        LED_1()
        sleep(1)
        #1초 단위로 함수 실행

if __name__ == '__main__':

    t1 = threading.Thread(target=test1)
    t2 = threading.Thread(target=test2)
    t3 = threading.Thread(target=test3) 

    t1.start()
    t2.start()
    t3.start()

    #멀티스레딩으로 3개의 함수 동시 실