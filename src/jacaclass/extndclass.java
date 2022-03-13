/*    */ package jacaclass;
/*    */ 
/*    */ import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
 public class extndclass
 {
   JFrame win = new JFrame();
   startPage sp = new startPage() ;
   Timer tm1,tm2,tm3,tm4;
   int won,ooo;
   details dt = new details();
   course  cs = new course();
   calc cl;
  extndclass()
  {
      
        win.setDefaultCloseOperation(3);
        win.getContentPane().add(sp);
        win.setVisible(true);
        win.setSize(1000, 700);
        win.setLocationRelativeTo(null);
        win.setResizable(false);
        win.setTitle("CGPA CALCULATOR");
       // setLookAndFeel();
        tm1= new Timer(2,new t1());
        tm2= new Timer(2,new t2());
        tm3= new Timer(2,new t3());
        tm4= new Timer(2,new t4());
        
        tm1.start();
    }
  
   public class t1 implements ActionListener {
       public void actionPerformed(ActionEvent event) {
            
                    if(sp.chk == true)
                    {
                        win.getContentPane().removeAll();
                        win.setContentPane(dt.infom());
                        win.repaint();
                        win.validate();
                        tm1.stop();
                        tm2.start();
                    }
       }
      }
   
   public class t2 implements ActionListener {
       public void actionPerformed(ActionEvent event) {
           
                    if(dt.d==1)
                    {
                    dt.d=0;
                    dt.navigator=1;
                    cs= new course();
                    
                    win.getContentPane().removeAll();
                    win.setContentPane(cs);
                    if(won == 0)
                        cs.forword.setEnabled(false);
                    win.repaint();
                    win.validate();
                    tm2.stop();
                    tm3.start();
                    } 
                    
                   else if(dt.d==2)
                    {
                        dt.d=0;
                        cs = new course();
                    win.getContentPane().removeAll();
                    win.setContentPane(cs);
                    win.repaint();
                    win.validate();
                    tm2.stop();
                    tm3.start();
                    } 
       }
      }
   public class t3 implements ActionListener {
       public void actionPerformed( ActionEvent event) {
                    //JOptionPane.sh    owMessageDialog(null, dt.d);
               ooo++;
               if(ooo%100==0)
            //       System.out.println("course:");
                    if(cs.d==1) 
                    {
                        cs.d=0;
                     //   System.out.println("course: done");
                        try{
                        cl= new calc();}
                        catch(Exception e){System.out.println("ex error 1"+e);}
                        
                    win.getContentPane().removeAll();
                    
                    win.setContentPane(cl);
                    
                    win.repaint();
                    win.validate();
                    tm3.stop();
                    tm4.start();
                    }    
                    else if(cs.d==2)
                    {
                    cs.d=0;
                    win.getContentPane().removeAll();
                    win.setContentPane(dt.infom());
                    win.repaint();
                    win.validate();
                    tm3.stop();
                    tm2.start();
                    }    
       }
      }
   public class t4 implements ActionListener {
       public void actionPerformed(ActionEvent event) {
                    if(cl.d==1)
                    {
                    cl.d=0;
                    cs=new course();
                    win.getContentPane().removeAll();
                    win.setContentPane(cs);
                    cs.nav=0;
                    won=1;
                    cs.forword.setEnabled(true);
                    win.repaint();
                    System.out.println(cs.nav);
                    win.validate();
                    tm4.stop();
                    tm3.start();
                    }    
       }
      }
   
   
   private void setLookAndFeel() {
try {
UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
 SwingUtilities.updateComponentTreeUI(win);
 } catch (Exception e) {}
 }
   
   
   
}

/* Location:           C:\Users\HP PC\Documents\NetBeansProjects\javaClass\build\classes\
 * Qualified Name:     jacaclass.extndclass
 * JD-Core Version:    0.6.0
 */