package listeners;


import java.util.Date;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * 
 * to create a listener, choose new -> listener
 * then we choose here: HTTP session events -> lifecycle, changes to attributes
 * 
 * 
 * */



/**
 * Application Lifecycle Listener implementation class MyListener
 * e.g. put the logs of listeners in a logfile
 *
 */
public class MyListener implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("hello from listener. Session was created at: "+new Date(se.getSession().getCreationTime()));
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("hello from listener. Session was destroyed at: "+new Date(se.getSession().getCreationTime()));
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("from listener key with: "+event.getName()+" and with value: "+event.getValue()+" was added");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("from listener key with: "+event.getName()+" and with value: "+event.getValue()+" was removed");
    
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("from listener key with: "+event.getName()+" and with value: "+event.getValue()+" was modified");
    }
	
}
