package business;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.TimerService;
import javax.ejb.Timer;

import java.util.logging.Logger;

@Stateless
public class MyTimerService 
{
	@Resource
	TimerService timerService;
	
	private static final Logger logger = Logger.getLogger("business.MyTimeService");
	
	public MyTimerService() 
	{		
	}
	public void setTimer(long interval)
	{
		timerService.createTimer(interval, "Setting a Programmatic Timer");
	}
	
	@Timeout 
	public void programmaticTimeout(Timer timer) {
		
		logger.info("@Timeout in programmatic(); called at: " + new java.util.Date()); 
	}
	
	@Schedule(second="*/60", minute = "*", hour=" 0-23", dayOfWeek="Mon-Fri", dayOfMonth="*", month="*", year="*", info="MyTimer")
	private void scheduledTimeOut(final Timer t)
	{
		logger.info("Schedule in scheduledTimeout(); called at: " + new java.util.Date());
	}
}
