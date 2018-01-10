public class Text {
  private String a = "SHOE PICS SENPAI PLZ";
  private PFont text;

  private void show() {
    textSize(20);
    textAlign(CENTER);
    text = createFont("Arial", 24, true);
    textFont(text, 24);
    text(a, 0, 0);
  }
}