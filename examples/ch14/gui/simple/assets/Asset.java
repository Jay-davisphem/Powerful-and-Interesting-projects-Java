package assets.asset;

import java.util.Date;
import java.util.UUID;
public class Asset{
  protected  String _manufacturer, _model, _currentLocation, _owner;
  protected Date _purchaseDate;
  protected double _purchasePrice;
  protected UUID _assetID;
  public Asset(String manufacturer, String model, String currentLocation, String owner, Date purchaseDate, double purchasePrice){
    _assetID = UUID.randomUUID();
    _manufacturer = manufacturer;
    _model = model;
    _currentLocation = currentLocation;
    _owner = owner;
    _purchaseDate = purchaseDate;
    _purchasePrice = purchasePrice;
  }
  public Asset(){
    this("No name", "model-less", "lost", "No one", new Date(), 1200000.45);
  }

  public String track(){
    return _currentLocation;
  }
  public String toString(){
    return _assetID.toString();
  }
}
