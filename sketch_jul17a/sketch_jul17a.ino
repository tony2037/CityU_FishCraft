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
  private:
    int MotorDirection(int DIR){
  //params:
  //DIR : The direction of the motor using digital mode
    if(DIR)
      digitalWrite(this->DIR, HIGH);
    else
      digitalWrite(this->DIR, LOW);

    return 0;
  };

    int MotorPWM(int PWM){
  //params:
  //PWM : The direction of the motor using analog mode
    analogWrite(this->PWM, PWM);
  };
  public:
    int PWM;
    int DIR;
    short int rate;
    Motor(int PWM, int DIR){
      this->PWM = PWM;
      this->DIR = DIR;
      this->rate = 0;
      MotorDirection(1);
      MotorPWM(0);
      };

    int SpeedUp(){
    if(this->rate >= 255)
      Serial.println("The motor is full load");
    else
    {
      ++ this->rate;
      this->rate = this->rate << 1;
      -- this->rate;
      if(this->rate >= 255)
        this->rate = 255;
      }

    MotorPWM(this->rate);
    return 0;
        };

     int SpeedDown(){
    if(this->rate <= 0)
      Serial.println("The motor is off");
    else
    {
      ++ this->rate;
      this->rate = this->rate >> 1;
      -- this->rate;
      if(this->rate <=  0)
        this->rate = 0;
      }

    MotorPWM(this->rate);
    return 0;
    };

    int ShutDown(){
  MotorPWM(0);
  return 0;
        };
  };

Motor Left = Motor(L_PWM, L_DIR);
Motor Right = Motor(R_PWM, R_DIR);
Motor Middle = Motor(M_PWM, M_DIR);



int LeftWard(){
  Serial.println("Turning Left");
  // Slow down the left motor
  Left.ShutDown();
  // Strength the right motor
  Right.SpeedUp();
  return 0;
}

int RightWard(){
  Serial.println("Turning Right");
  // Slow down the right motor
  Right.ShutDown();
  // Strength the left motor
  Left.SpeedUp();
  return 0;
}


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);   
  Serial.println(Left.PWM);
}



void loop() { 
  // put your main code here, to run repeatedly:

}
