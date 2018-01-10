public class Rotate {
  private int constant = 300; 
  private int amount = 500; // partical amount
  private int [][][]xyz = new int[constant][constant][constant];
 
  private void move() {
    float rotx = (mouseY/360.0)*-2*PI+PI; //
    float roty = (mouseX/420.0)*2*PI-PI;  // floats must be here
 
    translate(500, 400, 0); //centre drawing
    rotateX(rotx); 
    rotateY(roty); // rotate drawing coordinates according to user input variables
  }
 
  private void display() {
    background(0); // I thought by redoing the backround that it would stop the ram from filling up but that didn't work
    fill(0, 135, 200); //text colour
    strokeWeight(2);    
    stroke(255, 0, 0);  
    noFill();           // setting up box
    box(constant);           
  }
 
  private void particle() {
    xyz = new int[constant][constant][constant];                                              // new array and empty
    for (int i = 0; i < amount; i++)                                                           
      xyz[int(random(0, constant))][int(random(0, constant))][int(random(0, constant))] = 1;  // sets particles randomly
  }
 
  private void colour() {
    for (int x = 0; x < constant; x++)                                                        
      for (int y = 0; y < constant; y++)                                                      
        for (int z = 0; z < constant; z++) {                                                  
          if (xyz[x][y][z] > 0) {                                                             // 
            stroke((random(-180, 255)), (random(-175, 155)), (random(-175, 255)));            // Colour settings
            point(x - 150, y - 150, z - 150);                                                 // particle mapping
          }
        }
  }
}