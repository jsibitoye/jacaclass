
package jacaclass;
import sun.audio.*;
import java.io.*;
// javax.sound.sampled.*;
/**
 *
 * @author HP PC
 */
public class audiotest {
    //for taking input stream
    //taking the path
    //then use AudioPlayer.Player.Start(as);
    audiotest()
    {
        try{
        InputStream is = new FileInputStream("w.wav");
        System.out.println("ok");
        AudioStream as = new AudioStream(is);
        AudioPlayer.player.start(as);
        while (true)
        { System.out.println("josh");
        }
        }
        catch(Exception e){ System.out.println("ko sise abg");}
        
    }
    public static void main (String[] args)
    {
        new audiotest();
    }
    
}
