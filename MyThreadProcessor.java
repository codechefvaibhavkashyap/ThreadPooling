/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaibhav
 */
public class MyThreadProcessor implements Runnable {

    @Override
    public void run()
    {
        System.out.println("INSIDE RUN");
       MyThreadPool.insertFreeThread(this);
    }
    
    public void performOperation()
    {
        System.out.println("CURRENT THREAD :"+Thread.currentThread().getName());
        for(int i =0 ; i<30000 ; i++)
        {
            System.out.println(" executing "+i);
        }
        
        MyThreadPool.insertFreeThread(this);
    }
    
    public boolean checkAlive()
    {
        System.out.println("CHECKING THREAD STATUS");
        boolean isAlive = false;
        if(Thread.currentThread().isAlive())isAlive = true;
        return isAlive;
    }
}
