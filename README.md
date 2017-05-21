#INTERNET OF THINGS PROJECT

Two versions of the project where made.


Purpose : The technology is used to control your home electrical appliances remotely using your mobile phone over internet. Smart Home 2.0 uses Android Application whereas Smart home 1.0 uses Web Interface.
#SMART HOME 1.0 MADE USING RASPBERRY PI


 This project demonstrates the concept of Internet of things by connecting  all the household electrical/electronic appliances to the internet. This is achieved using  relay driver electronic circuit which is connected to Raspberry pi’s GPIO pins. Hardware side is made using circuit consisting of couple of npn transistors, resistors, capacitors and optocoupler relays. This circuit is connected to Raspeberry pi’s (Rpi) GPIO pins. On Rpi runs a webserver which hosts a webpage which can directly control GPIO pins of Rpi using javascript and python. Client requests for webpage eg:http://xx.xx.xx.x/home.html. This webpage has three different <input onClick=”functionName()/> tags. Each button when pressed calls its corresponding function() which calls corresponding python script
 thereby turning the corresponding GPIO pin on Rpi ON. This makes the circuit connected to that particular pin active which makes the electrical appliance to turn ON. A special kind of webserver which is specifically made for Rpi IOT applications called WebIOPi is used
 to design this complete system. (webiopi server: http://webiopi.trouch.com/). Control of electrical appliances was achieved over both LAN(control things when connected to home router) as well as WAN(control things when you are outside and connected to internet. 





![smart home 1](https://cloud.githubusercontent.com/assets/14818804/21540494/6f1b86fe-cdd5-11e6-8522-c4b73c891bab.jpg)
![smart home 2](https://cloud.githubusercontent.com/assets/14818804/21540495/6f268a36-cdd5-11e6-83c8-fa2a0a24276d.jpg)


Youtube Video link : https://www.youtube.com/watch?v=O2tHe25qhVg&t=8s


#2) SMART HOME 2.0 MADE USING ESP8266


![smart home 3](https://cloud.githubusercontent.com/assets/14818804/21540496/6f2c0fec-cdd5-11e6-8f28-bbd73b624585.jpg)


Youtube Video link : https://www.youtube.com/watch?v=927zWW30pb0&t=2s
