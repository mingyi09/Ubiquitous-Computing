import RPi.GPIO as GPIO
from time import sleep

ledpin = 11
GPIO.setmode(GPIO.BOARD)
GPIO.setup(ledpin, GPIO.OUT)
GPIO.setwarnings(False)

pwm = GPIO.PWM(ledpin, 1000)
pwm.start(0)

dutyList = [0, 25, 50, 75, 100]

while True:
  for duty in dutyList:
    pwm.ChangeDutyCycle(duty)
    sleep(0.5)
  sleep(1)
