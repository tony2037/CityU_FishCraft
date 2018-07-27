#include <SoftwareSerial.h>
SoftwareSerial BT_Serial(4, 5);
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
    short int rate; // The rate of the motor now
    short int direct; // The direction of the motor now
    
    Motor(int PWM, int DIR){
      this->PWM = PWM;
      this->DIR = DIR;
      this->rate = 0;
      this->direct = 1;
      MotorDirection(this->direct);
      MotorPWM(this->rate);
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

  
    int Maintain(){
    // Change the direction of the motor
    this->direct = 0;
    MotorDirection(this->direct);
    // Set up the rate to 63
    MotorPWM(63);
    return 0;
    };

    int ReverseMaintain(){
    // Maintain();
    Maintain();
    // Inverse the direction
    this->rate = !this->rate;
    MotorDirection(this->direct);
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
  Left.ReverseMaintain();
  Right.ReverseMaintain();
  return 0;
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
class Bluetooth{
  public:
    byte data;
    Bluetooth(){
      this->data = 0;
      };
    ~Bluetooth(){};

    void Listen(){
      
      while(Serial.available() > 0){
        data = Serial.read();
        BT_Serial.write(data);
      }
      

      while(BT_Serial.available() > 0){
        data = BT_Serial.read();
        Serial.print(data);
        Parse(data);
      }

      };

    void Parse(byte data){
      // Parse forward
      if(data & 0b00001000)
        ForWard();
      if(data & 0b00000100)
        BackWard();
      if(data & 0b00000010)
        LeftWard();
      if(data & 0b00000001)
        RightWard();
      
      };
  };
Bluetooth BT = Bluetooth();

// Arduino part
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  BT_Serial.begin(9600);
  
}


char dataa;

void loop() { 
  // put your main code here, to run repeatedly:
  BT.Listen();
//  while(Serial.available() > 0){
//        dataa = Serial.read();
//        BT_Serial.write(dataa);
//      }
//
//      while(BT_Serial.available() > 0){
//        dataa = BT_Serial.read();
//        Serial.print(dataa);
//      }
}
