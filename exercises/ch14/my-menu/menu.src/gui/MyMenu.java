import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class MyMenu extends JFrame implements ActionListener{
  protected static final long serialVersionUID = 3L;
  private Map<String, Color> colors = new HashMap<String, Color>();

  private JMenu fileMenu;
  private JMenu editMenu;
  private JMenu colorMenu;
  private Container parentContainer;

  public static void main(String[] args){
    MyMenu menu = new MyMenu();
    menu.setVisible(true);
  }
  private Container getRootContainer(){
    Container parentContainer = getContentPane();
    setSize(500, 500);
    setResizable(true);
    setLocation(100, 100);
    parentContainer.setLayout(new FlowLayout());
    return parentContainer;
  }
  public MyMenu(){
    parentContainer = getRootContainer();
    
    createFileMenu();
    createEditMenu();
    createColorMenu();

    createMenuBar();

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private JMenuBar createMenuBar(){
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    menuBar.add(fileMenu);
    menuBar.add(editMenu);
    menuBar.add(colorMenu);

    menuBar.setBackground(Color.green);

    return menuBar;
  }
  private void addMenuItem(JMenu menu, String name){
    JMenuItem item;
    String tmpName = name;
    if(name.startsWith("--sep--")){  
      tmpName = name.substring(name.indexOf("--sep--") + 1);
    }
    item = new JMenuItem(tmpName);
    item.addActionListener(this);
    menu.add(item);
    if(name.startsWith("--sep--")) menu.addSeparator();
  }

  private void createXXMenu(JMenu menu, String[] names){
    for(String name: names){
      addMenuItem(menu, name);
    }
  }

  private void createFileMenu(){
    fileMenu = new JMenu("File");
    String[] names = new String[1];
    names[0] = "Quit";
    createXXMenu(fileMenu, names);
  }
  private void createEditMenu(){
    editMenu = new JMenu("Edit");
    String[] names = new String[1];
    names[0] = "Erase";
    createXXMenu(editMenu, names);
  }
  private void createColorMenu(){
    colorMenu = new JMenu("Color");
    String[] names = new String[5];
    names[0] = "Red";
    colors.put(names[0], Color.red);

    names[1] = "Green";
    colors.put(names[1], Color.green);
    names[2] = "Blue";
    colors.put(names[2], Color.blue);
    names[3] = "Pink";
    colors.put(names[3], Color.pink);
    names[4] = "Black";
    colors.put(names[4], Color.black);
    createXXMenu(colorMenu, names);
  }
  private Color getColor(String nm){
    return colors.get(nm);
  }
  public void actionPerformed(ActionEvent e){
    String menuName;
    menuName = e.getActionCommand();
    if (menuName.equals("Quit")) {
      System.exit(0);
    } else if(menuName.equals("Erase")){
      parentContainer.setBackground(Color.white);
    }else {
      parentContainer.setBackground(getColor(menuName));
    }
  }
}
