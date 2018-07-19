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
    Serial.println(this->rate);
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
    Serial.println(this->rate);
    return 0;
    };

    int ShutDown(){
    MotorPWM(0);
    return 0;
    };
  
    int Maintain(){
    MotorPWM(127);
    return 0;
    };

    int REVERSE_Maintain(){
    Maintain();
    t
    return 0;
    };

    int SetLevel(int level){
      // level range {0, 8}
      if(level <0 || level > 8)
        return -1;

      MotorPWM(pow(2, level) - 1);
      };
  
};

Motor Left(L_PWM, L_DIR);
Motor Right(R_PWM, R_DIR);
Motor Middle(M_PWM, M_DIR);

int ForWard(){
  Serial.println("Going Forward");
  // Maintain the power of both right and left motors
  Left.Maintain();
  Right.Maintain();
  return 0;
};

int BackWard(){
  Serial.println("Going Backward");
  // Maintain the both power motor as an opposite to the 'ForWard'
  Left.REVRSE_Maintain();
  Right.REVRSE_Maintain();
  return 0;
}

int Turn_Right(){
  Serial.println("Turnning to the right");
  // Maintain the right motor and REVERSE the left one
  
}

int LeftWard(){
  Serial.println("Turning Left");
  // Slow down the left motor
  Left.ShutDown();
  // Strength the right motor
  Right.SpeedUp();
  return 0;
};

int RightWard(){
  Serial.println("Turning Right");
  // Slow down the right motor
  Right.ShutDown();
  // Strength the left motor
  Left.SpeedUp();
  return 0;
};

int UpWard(int level){
  Middle.SetLevel(level);
  return 0;  
};

int DownWard(){
  // 7/18 2018 We decided not to do this part
  return 0;  
};


// Bluetooth part
class BlueTooth{
  private:
    String buff;
  public:
    BlueTooth(){
      this->buff = "" ;
      };

      
    int test(){return 0;};
    String Listen(){
      while (Serial.available()) {
        this->buff = "";
            delay(10);  //small delay to allow input buffer to fill
    
            char c = Serial.read();  //gets one byte from serial buffer
            if (c == ';') {
              break;
            }  //breaks out of capture loop to print readstring
            this->buff += c; 
          } //makes the string readString  
    
          if (this->buff.length() >0) {
            Serial.print("Receive data : ");
            Serial.println(this->buff); //prints string to serial port out
            return this->buff;
          }
    };

      
  };



// Arduino part
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);

}



void loop() { 
  // put your main code here, to run repeatedly:
}
