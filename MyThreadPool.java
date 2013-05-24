
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaibhav
 */
public class MyThreadPool {
    public int g=0;
    public static int MAX_POOL_SIZE = 2;
    
    public static Queue<MyThreadProcessor> poolQueue = new LinkedBlockingQueue<MyThreadProcessor>(2);
    public static Queue<MyThreadProcessor> initialQueue = new LinkedBlockingQueue<MyThreadProcessor>(2);
    
    public void init()
    {
        MonitorThreadClass.firstExecute = true;
        for(int i=0 ; i<MAX_POOL_SIZE ; i++)
        {
            MyThreadProcessor m = new MyThreadProcessor();
            initialQueue.add(m);
        }
    }
    
    public static synchronized void insertFreeThread(MyThreadProcessor mtp)
    {
        if(poolQueue.size() != MAX_POOL_SIZE)
        {
            System.out.println("INSERTING FREE THREAD");
            poolQueue.add(mtp);
        }
    }
    
    public static synchronized  MyThreadProcessor fetchFreeThread()
    {
        MyThreadProcessor mtpObj = null;
        
        if(poolQueue.peek() != null)
        {
            System.out.println("FETCHING FREE THREAD");
            mtpObj = poolQueue.poll();
            if(!mtpObj.checkAlive())
            {
                System.out.println("OBJECT FOUND NULL");
                mtpObj = null;
            }
        }
        
        return mtpObj;
    }
    
    public static void initialcall()
    {
        if(initialQueue.peek() != null)
        {
            Thread t = new Thread(initialQueue.poll());
            t.start();
        }
        else
        {
            initialQueue = null;
            MonitorThreadClass.firstExecute=false;
        }
    }
}
