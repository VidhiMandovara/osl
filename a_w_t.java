/*Write a java program to create a menu-based GUI program using AWT class. Various menu options should be:
1) Read a text file
2) Save content to a text file
3) Copy a file
4) Delete a file


1) Upon selecting the option a frame should open. Frame should contain a text field, button and text area control. User should type full path of the text file name in text field. Button labeled “Load”, upon pressing should load the content of the text file into the text area.
2) Similar to the first one but the user should write the text in text area and upon pressing “Save” button, content should be written to the file.
3) Two text file names (source & destination) should be entered in two text fields. Upon pressing “Copy” button, source file should be copied to the destination.
4) Text file name should be entered into the text field and upon pressing “Delete” button file should be deleted.
In all the cases use suitable label names before the controls. Also make necessary file validations and exception handling.
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class a_w_t{
    void awtUI(){
        Frame f = new Frame("Menu");
        f.setSize(900,500);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        Button b1 = new Button("Read a file");
        Button b2 = new Button("Save content to a file");
        Button b3 = new Button("Copy file");
        Button b4 = new Button("Delete file");
        b1.setBounds(50,50,200,50);
        b2.setBounds(250,100,200,50);
        b3.setBounds(450,150,200,50);
        b4.setBounds(650,200,200,50);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Frame f1 = new Frame("Read a text file");
                f1.setSize(500,500);
                f1.setLayout(new FlowLayout());
                f1.setVisible(true);
                f1.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                });
                Label l1 = new Label("Enter the file name or path to the file");
                TextField t1 = new TextField(20);
                Button b1 = new Button("Load");
                TextArea ta1 = new TextArea(10,20);
                f1.add(l1);
                f1.add(t1);
                f1.add(b1);
                f1.add(ta1);
                b1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String s1 = t1.getText();
                        try{
                            FileReader fr = new FileReader(s1);
                            BufferedReader br = new BufferedReader(fr);
                            String s2 = br.readLine();
                            while(s2!=null){
                                ta1.append(s2);
                                s2 = br.readLine();
                            }
                            br.close();
                            fr.close();
                        }
                        catch(Exception e1){
                            System.out.println(e1);
                        }
                    }
                });
            }
        });

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Frame f2 = new Frame("Save content to a text file");
                f2.setSize(500,500);
                f2.setLayout(new FlowLayout());
                f2.setVisible(true);
                f2.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                });
                Label l1 = new Label("Enter the file name or path to save the file");
                TextField t1 = new TextField(20);
                Button b1 = new Button("Save");
                TextArea ta1 = new TextArea(10,20);
                f2.add(l1);
                f2.add(t1);
                f2.add(b1);
                f2.add(ta1);
                b1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String s1 = t1.getText();
                        try{
                            FileWriter fw = new FileWriter(s1);
                            BufferedWriter bw = new BufferedWriter(fw);
                            String s2 = ta1.getText();
                            bw.write(s2);
                            bw.close();
                            fw.close();
                        }
                        catch(Exception e1){
                            System.out.println(e1);
                        }
                    }
                });
            }
        });

        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Frame f3 = new Frame("Copy a text to another file");
                f3.setSize(500,500);
                f3.setLayout(new FlowLayout());
                f3.setVisible(true);
                f3.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                });
                Label l1 = new Label("Enter the source file name or path");
                Label l2 = new Label("Enter the destination file name");
                TextField t1 = new TextField(20);
                TextField t2 = new TextField(20);
                Button b1 = new Button("Copy");
                f3.add(l1);
                f3.add(t1);
                f3.add(l2);
                f3.add(t2);
                f3.add(b1);
                b1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String s1 = t1.getText();
                        String s2 = t2.getText();
                        try{
                            FileReader fr = new FileReader(s1);
                            BufferedReader br = new BufferedReader(fr);
                            FileWriter fw = new FileWriter(s2);
                            BufferedWriter bw = new BufferedWriter(fw);
                            String s3 = br.readLine();
                            while(s3!=null){
                                bw.write(s3);
                                s3 = br.readLine();
                            }
                            bw.close();
                            fw.close();
                            br.close();
                            fr.close();
                        }
                        catch(Exception e1){
                            System.out.println(e1);
                        }
                    }
                });
            }
        });

        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Frame f4 = new Frame("Delete a file");
                f4.setSize(500,500);
                f4.setLayout(new FlowLayout());
                f4.setVisible(true);
                f4.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                });
                Label l1 = new Label("Enter the file name or path to delete");
                TextField t1 = new TextField(20);
                Button b1 = new Button("Delete");
                f4.add(l1);
                f4.add(t1);
                f4.add(b1);
                b1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String s1 = t1.getText();
                        File f = new File(s1);
                        if(f.exists()){
                            f.delete();
                        }
                        else{
                            System.out.println("File does not exist or has already been deleted");
                        }
                    }
                });
            }
        });
    }
    public static void main(String[] args) {
        a_w_t a = new a_w_t();
        a.awtUI();
    }
}