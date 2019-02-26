//Katarina Sperduto

import java.util.*;

public class Triangle{
  public double side1;
  public double side2;
  public double side3;

  public Triangle(){
    side1 = 1.0;
    side2 = 1.0;
    side3 = 1.0;
  }
  public Triangle(double side1, double side2, double side3){
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }
  public double findArea(){
    double p = (side1+side2+side3)/2;
    double area = Math.sqrt((p*(p-side1)*(p-side2)*(p-side3)));
    return area;
  }
  public double findPerimeter(){
    double perimeter = side1 + side2 + side3;
    return perimeter;
  }
  public double findHyp(){
    double side1And2 = Math.max(side1,side2);
    double side1And3 = Math.max(side1,side3);
    double side2And3 = Math.max(side2,side3);
    double maxSide_1 = Math.max(side1And2,side1And3);
    double maxSide_2 = Math.max(maxSide_1, side2And3);
    double hyp = maxSide_2;
    return hyp;
  }

  public boolean isEquilateral(){
    if (side1 == side2 && side1 == side3 && side2 == side3 ){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean isIsosceles(){
    if (side1 == side2 || side1 == side3 || side2 == side3){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean isScalene(){
    if (side1 != side2 && side1 != side3 && side2 != side3){
      return true;
    }
    else{
      return false;
    }
  }
public boolean isRight(){
  if (isEquilateral() == true) {
    return false;
    }
  else if (findHyp() == side1){
    double hyp = side1;
    if ((side2*side2)+(side3*side3)==(side1*side1)){
      return true;
    }
    else{
      return false;
    }
  }
  else if (findHyp() == side2){
    double hyp = side2;
    if ((side1*side1)+(side3*side3)==(side2*side2)){
      return true;
    }
    else{
      return false;
    }
  }
  else {
    double hyp = side3;
    if ((side2*side2)+(side1*side1)==(side3*side3)){
      return true;
    }
    else{
      return false;
    }
  }
}

}
