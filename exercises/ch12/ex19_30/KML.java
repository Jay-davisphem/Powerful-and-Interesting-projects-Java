import java.util.*;
import java.io.*;
import javax.swing.*;
class KML{
  private double[][] coordinates;
  private static final String startTag = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<kml xmlns=\"http://earth.google.com/kml/2.1\">\n<Document>\n\t<name>Mystery Locations</name>\n";
  private static final String endTag = "</Document>\n</kml>";
  private static final String bodyTag = "\t<Placemark>\n\t\t<name>Location %1$s</name>\n\t\t<Point>\n\t\t\t<coordinates>%2$.2f,%3$.2f,0</coordinates>\n\t\t</Point>\n\t</Placemark>\n";
  public KML(double[][] coords) throws IOException{
    coordinates = new double[coords.length][2];
    for(int i = 0; i < coords.length; i++)
      for(int j = 0; j < coords[i].length; j++)
        coordinates[i][j] = coords[i][j];
    chooseFile("Save");  
  }

  public KML() throws IOException{
    chooseFile("Open");
    chooseFile("Save");
  }
  
  public  String toString(){
    StringBuffer bodyTagStr =  new StringBuffer("");
    for(int i = 0; i < coordinates.length; i++){
      String str = String.format(bodyTag, i+1, coordinates[i][0], coordinates[i][1]);
      bodyTagStr.append(str);
    }
    return startTag + bodyTagStr.toString() + endTag;
  }

  /* 
   * Save coordinates as kml file 
   * @author David Oluwafemi
   * @param action: Usually Open or Save but can be any positive answer
   * */
  private void chooseFile(String action) throws IOException{
    String current = System.getProperty("user.dir");
    JFileChooser chooser = new JFileChooser(current);
    action = action.substring(0, 1).toUpperCase() + action.substring(1).toLowerCase();
    int status = chooser.showDialog(null, action);
    try{
      File file = chooser.getSelectedFile();
      String filename = file.getName();
      if(status == JFileChooser.APPROVE_OPTION){
        if(action.equalsIgnoreCase("open")){
          coordinates = read(file.getAbsolutePath());
          System.out.println("File Opened");
        }else if (action.equalsIgnoreCase("save")){
          write(file.getAbsolutePath());
          System.out.println("File Saved");
        }else{
          System.out.println("Wrong action: " + action);
        }
      }else{
        System.out.println("Failed save or open" + filename);
        System.exit(1);
      }
      }catch(Exception e){
        System.out.println(e.getMessage());
    }
  }
  public double[][] read(String filename) throws FileNotFoundException, IOException{
    File inFile = new File(filename);
    FileReader fileReader = new FileReader(inFile);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    //Scanner scanner =  new Scanner(inFile);
    List<List<Double>> coords = new ArrayList<List<Double>>();
    String line;
    while(true){
      line = bufferedReader.readLine();
      if(line == null) break;
      String[] coord = line.split(" ");
      List<Double> innerList = new ArrayList<Double>(2);
      innerList.add(Double.parseDouble(coord[0]));
      innerList.add(Double.parseDouble(coord[1]));
      coords.add(innerList);
    }
    //scanner.close();
    double[][] coordsList = new double[coords.size()][2];
    for(int i = 0; i < coords.size(); i++){
      for(int j = 0; j < coords.get(0).size(); j++){
        coordsList[i][j] = coords.get(i).get(j);
      }
    }
    return coordsList;
  }
  public void write(String filename) throws IOException{
    File outFile= new File(filename);
    FileOutputStream outFileStream= new FileOutputStream(outFile);
    PrintWriter outStream = new PrintWriter(outFileStream);
    outStream.write(toString());
    outStream.close();

  }
 
  public static void main(String[] args){
    try{
      new KML();
    }catch(FileNotFoundException e){
      System.out.println("FileNotFoundException: " + e.getMessage());
    }catch(IOException e){
      System.out.println("IOException: " + e.getMessage());
    }  
  }
}
