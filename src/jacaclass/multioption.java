package jacaclass;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
public class multioption {  
    JTextField[] jt = new JTextField[10];
    int count=0; float P_gp;
     double jamb(int n, String text , String head){
        if( n !=0 ){
      Object field[]= new Object[20];
        int c=0;
      for(int i=1; i<=n; i++){          
          int d=i-1;
          jt[d]= new JTextField();
          jt[d].addKeyListener( new updater(d));
       field[count]=text+" "+i;
       count++;
       field[count]=jt[d];
          count++;
      }
      int a= JOptionPane.showConfirmDialog(null, field, head,JOptionPane.OK_CANCEL_OPTION);
      
      if(a==0){
         try { 
          for (int y=0; y<n ; y++)
              P_gp= P_gp + Float.parseFloat(jt[y].getText());
          }
          catch(Exception exp){ JOptionPane.showMessageDialog(null, "Please Review Your Datas");}
         
      }
    }
        return P_gp/(n+0.0);
    }
     
     
    class updater extends KeyAdapter
{
        int d;
        updater (int dd){
        d=dd;
        }
    public void keyReleased(KeyEvent e) {
        String chcker=jt[d].getText();
        String[]c=chcker.split("");
        String gpstring="";
        for(int j= 0;j<=chcker.length();j++){
           try{int num = Integer.parseInt(c[j]);
            gpstring +=num;
           }
           catch(Exception notnum){
               if (c[j].equals("."))
                   gpstring+=c[j];
           }
        }
        if(gpstring.length()>1 & !gpstring.contains(".") )
             gpstring= gpstring.substring(0,1);
        if (gpstring.length()>4)
         gpstring= gpstring.substring(0, 4);
       
        
        if (gpstring.contains(".") & gpstring.indexOf(".") == 0){
                 gpstring="";} 
        try{
            double nm= Double.parseDouble(gpstring);
            if(nm>5.0)
                gpstring= "5";
//        else
//            jt[d].setForeground(Color.darkGray);
        }
        catch(Exception eee){}
        jt[d].setText(gpstring);
    }
}
}
