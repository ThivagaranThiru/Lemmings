package model;

import java.util.ArrayList;
import java.util.List;


public abstract class LemmingsObservable {
	
	private ArrayList<LemmingsObserver> observers = new ArrayList <>();
	
	public void register(LemmingsObserver o) {
		observers.add(o);
	}
	
	public void unregister(LemmingsObserver o) {
		observers.remove(o);
	}
	
	public void notifyObserver(List<LemmingsEvent> events) {
		for (LemmingsObserver lemmingsObserver : observers) {
			lemmingsObserver.notify(events);
		}
	}
}
