/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaibhav
 */
public class MonitorThreadClass implements Runnable {
    
    public static boolean firstExecute;
    int j =0;
    @Override
    public void run()
    {
        while(true)
        {
            //System.out.println("gand fatgayi");
            if(!firstExecute)
            {
                MyThreadProcessor mtpObject = MyThreadPool.fetchFreeThread();
                if(mtpObject == null)
                { 
                    try
                    {
                        System.out.println("No Free Thread Available , Try after some time");
                        Thread.sleep(5000);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                if(mtpObject!=null)mtpObject.performOperation();
            }
            else
            {
                MyThreadPool.initialcall();
            }
        }
    }
}
