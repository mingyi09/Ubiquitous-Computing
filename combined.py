import RPi.GPIO as GPIO
import time

ledpin = 11
GPIO.setmode(GPIO.BOARD)
GPIO.setup(ledpin, GPIO.OUT)
GPIO.setwarnings(False)

GPIO_TRIGGER = 16
GPIO_ECHO = 18

GPIO.setup(GPIO_TRIGGER, GPIO.OUT)
GPIO.setup(GPIO_ECHO, GPIO.IN)

pwm = GPIO.PWM(ledpin, 1000)
pwm.start(0)


def distance():
  GPIO.output(GPIO_TRIGGER, True)

  time.sleep(0.00001)
  GPIO.output(GPIO_TRIGGER, False)

  StartTime = time.time()
  StopTime = time.time()

  while GPIO.input(GPIO_ECHO) == 0:
    StartTime = time.time()

  while GPIO.input(GPIO_ECHO) == 1:
    StopTime = time.time()

  TimeElapsed = StopTime - StartTime
  distance = (TimeElapsed * 34300) /2
  return distance

dutyList = [0, 25, 50, 75, 100]

while True:
  dist = distance()
  print("Measured Distance = %.1f cm" % dist)
  if dist*2 <= 100:  
    pwm.ChangeDutyCycle(dist*2)
  time.sleep(0.5)
