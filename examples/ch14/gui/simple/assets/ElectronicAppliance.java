package assets.electronics;

import assets.asset.*;

public class ElectronicAppliance extends Asset{
  protected double powerUsage;
  protected int voltage, waltage;

  public ElectronicAppliance(){
    super();
  }

  public void turnOn(){
  }
  public void turnOff(){
  }
  public void setTemperature(){
  }
  public int getTemperature(){
    return 100;
  }
  public static void main(String[] args){
    Asset asset = new ElectronicAppliance();
    System.out.println(asset);
  }
}
