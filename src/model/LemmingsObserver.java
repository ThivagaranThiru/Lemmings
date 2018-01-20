package model;

import java.util.List;

public interface LemmingsObserver {
	public void notify(List<LemmingsEvent> events);
}
