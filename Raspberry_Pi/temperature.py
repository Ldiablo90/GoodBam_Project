import RPi.GPIO as GPIO
import datetime
import time
import requests 
import Adafruit_DHT

sensor = Adafruit_DHT.DHT11

pin = 4
led_pin ={'pin_R':24, 'pin_G':22, 'pin_B':23}

GPIO.setmode(GPIO.BCM)       # GPIO BCM 모드 설정                                     
for i in led_pin:
    GPIO.setup(led_pin[i], GPIO.OUT)   # 핀 모드를 출력으로 설정
    GPIO.output(led_pin[i], GPIO.HIGH) # LED를 HIGH로 설정해서 LED 끄기

p_R = GPIO.PWM(pins['pin_R'], 2000)  # 주파수 설정 2KHz
p_G = GPIO.PWM(pins['pin_G'], 2000)
p_B = GPIO.PWM(pins['pin_B'], 2000)

p_R.start(0)      # 초기 듀티 사이클 = 0 (LED 끄기)
p_G.start(0)
p_B.start(0)

try:
    while True :
        
        humidty, temperature = Adafruit_DHT.read_retry(sensor, pin)

    

        if humidty is not None and temperature is not None :
            print("Temperature = {0:0.1f}*C Humidity = {1:0.1f}%".format(temperature, humidty))
            float discomfortIndex = (1.8 * temperature) - (0.55 * (1 - humidity / 100.0) * (1.8 * temperature - 26)) + 32;
            print(discomfortIndex)
            
            

  else {
    // 에어콘(파란색 LED)를 끔
    digitalWrite(airCon, LOW);
    flag = 0;
  }
            
            temperature = str(temperature)
            humidty = str(humidty)
            raspID = str(1)
            
            #측정된 온도, 습도값으로 불쾌지수 값 계산 후 시리얼 모니터에 출력
  
            
            
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