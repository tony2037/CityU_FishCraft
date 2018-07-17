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
    short int rate;
    Motor(int PWM, int DIR){
      this->PWM = PWM;
      this->DIR = DIR;
      this->rate = 0;
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

int SpeedUp(Motor *m){
  if(m->rate >= 255)
    Serial.println("The motor is full load");
  else
  {
    ++ m->rate;
    m->rate = m->rate << 1;
    -- m->rate;
    if(m->rate >= 255)
      m->rate = 255;
    }
  }

int SpeedDown(Motor *m){
  if(m->rate <= 0)
    Serial.println("The motor is off");
  else
  {
    ++ m->rate;
    m->rate = m->rate >> 1;
    -- m->rate;
    if(m->rate <=  0)
      m->rate = 0;
    }
  return 0;
  }

int Left(){
  Serial.println("Turning Left");
  // Slow down the left motor
  MotorPWM(Left, 0);
  // Strength the right motor
  SpeedUp(&Right);
  return 0;
}

int Right(){
  Serial.println("Turning Right");
  // Slow down the right motor
  MotorPWM(Right, 0);
  // Strength the left motor
  SpeedUp(&Left);
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
