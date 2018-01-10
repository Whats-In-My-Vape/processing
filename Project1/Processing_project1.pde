/*
| box |
 # Error loading text upsidedown
 # Iteration problem fixed 
 */

Rotate rotate = new Rotate();
Text text = new Text();

void setup() {
  frameRate(30); // < Cause of problem \ setting a lower frame rate helped, but I'd prefer to have a way of dumping or reusing the data
  //background(0);
  size(1000, 800, P3D);
}

void draw() {

  rotate.move();
  rotate.display();
  rotate.colour();
  rotate.particle();
  text.show();
}