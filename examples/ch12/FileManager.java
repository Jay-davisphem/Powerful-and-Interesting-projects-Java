import java.io.*;
import java.swing.*;

import javax.swing.JFileChooser;
class FileManager{
  private static final String EMPTY_STRING = "";
  private static String lineTerminator = System.getProperty("line.separator");
  public FileManager(){
  }

  public String openFile() throws FileNotFoundException, IOException {
    String filename, doc = EMPTY_STRING;
    JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
    int reply = chooser.showOpenDialog(null);
    if (reply == JFileChooser.APPROVE_OPTION)
      doc = openFile(chooser.getSelectedFile().getAbsolutePath());
    return doc;
  }
  public String openFile(String filename) throws FileNotFoundException, IOException {
    String line;
    StringBuffer doc = new StringBuffer(EMPTY_STRING);

    File inFile = new File(filename);
    FileReader fileReader = new FileReader(inFile);
    BufferedReader bufReader = new BufferedReader(fileReader);

    while (true){
      line = bufReader.readLine();
      if(line == null) break;
      doc.append(line + lineTerminator);
    }
    return doc.toString();
  }

  public void saveFile(String filename, String data) throws IOException {
    File outFile = new File(filename);
    FileOutputStream outFileStream = new FileOutputStream(outFile);
    PrintWriter outStream = new PrintWriter(outFileStream);
    outStream.print(data);
    outStream.close();
  }

  public void saveFile(String data) throws IOException{
    String filename, doc = EMPTY_STRING;
    JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
    int reply = chooser.showSaveDialog(null);
    if (reply ==  JFileChooser.APPROVE_OPTION) saveFile(chooser.getSelectedFile().getAbsolutePath(), data);
  }
}
