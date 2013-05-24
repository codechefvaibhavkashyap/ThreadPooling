/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaibhav
 */
public class MyMainClass {

    Thread monitor = new Thread(new MonitorThreadClass());
    MyThreadPool mp = new MyThreadPool();
    public static void main(String...q)
    {
      
       
       new MyMainClass().startMonitorThread();
       
    }
    
    public void startMonitorThread()
    {
        mp.init();
       //monitor.setDaemon(true);
       monitor.start();
    }
}
