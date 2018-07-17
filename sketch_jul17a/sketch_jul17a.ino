#include <SoftwareSerial.h>

/*
Left-Motor:
A0 : 19
D9 : 12
Right-Motor:
A1 : 20
D8 : 11
Middle-Motor:
A2 : 21
D7 : 10
*/
int L_PWM = 11;
int L_DIR = 12;
int R_PWM = 10;
int R_DIR = 8;
int M_PWM = 9;
int M_DIR = 7;

class Motor{
  public:
    int PWM;
    int DIR;
    Motor(int PWM, int DIR){
      this->PWM = PWM;
      this->DIR = DIR;
      };
  };

Motor Left = Motor(L_PWM, L_DIR);
Motor Right = Motor(R_PWM, R_DIR);
Motor Middle = Motor(M_PWM, M_DIR);
int MotorDirection(Motor m, int DIR){
/*
params:
DIR : The direction of the motor using digital mode
m : The motor choosing
*/  
  if(DIR)
    digitalWrite(m.DIR, HIGH);
  else
    digitalWrite(m.DIR, LOW);

  return 0;
}

int MotorPWM(Motor m, int PWM){
/*
params:
PWM : The direction of the motor using analog mode
m : The motor choosing
*/
  analogWrite(m.PWM, PWM);
}

int Left(){
  // Turn off the left motor

  // Turn on the right motor
  return 0;
}


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);   
  Serial.println(Left.PWM);
  MotorDirection(Left, 1);
  MotorPWM(Left, 255);
}



void loop() { 
  // put your main code here, to run repeatedly:

}
