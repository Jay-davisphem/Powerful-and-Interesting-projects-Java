import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataOutputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
class TestFile{
  public static void main(String args[]) throws IOException{
    File outFile = new File("sample2.data");
    FileOutputStream outFileStream = new FileOutputStream(outFile);
    DataOutputStream outDataStream = new DataOutputStream(outFileStream);
    outDataStream.writeChars("Oluwafemi");
    File directory = new File(".");
    JFileChooser chooser = new JFileChooser(directory); 
    chooser.setFileFilter(new JavaFilter());
    String filename[] = directory.list();
    for (int i = 0; i < filename.length; i++) {
      System.out.format("%s ::: %s\n", filename[i], directory.toURI());
    }
    int status = chooser.showOpenDialog(null);
    if (status == JFileChooser.APPROVE_OPTION){ 
      System.out.println("Open is clicked");
      directory = chooser.getSelectedFile();
      System.out.println("Selected File: " + directory.getName() + "\nFull path " + directory.getAbsolutePath());
    } 
    else System.out.println("Cancel is clicked"); //== JFileChooser.CANCEL_OPTION
    chooser.showSaveDialog(null);
  }
}
class JavaFilter extends FileFilter{
  private static final String JAVA = "java";
  private static final char DOT = '.';

  public boolean accept(File f){
    if (extension(f).equalsIgnoreCase(JAVA)) return true;
    else return false;
  }
  public String getDescription( ) {
    return "Java source files (.java)";
  }
  private String extension(File f){
    String filename = f.getName();
    int loc = filename.lastIndexOf(DOT);
    if (loc > 0 && loc < filename.length() - 1) {
      //make sure the dot is not
      //at the first or the last character position
      return filename.substring(loc+1);
    } else {
      return "";
    }
  }
}
