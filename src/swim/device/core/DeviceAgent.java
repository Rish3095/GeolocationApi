package swim.device.core;

import swim.basic.CommandLane;
import swim.basic.SwimLane;
import swim.basic.ValueLane;

public class DeviceAgent {
	
	  @SwimLane("geolocation")
	  ValueLane<Float[]> geolocation = this.valueLane();
	  @SwimLane("deviceOwner")
	  CommandLane<String> owner = this.<String>commandLane().onCommand(msg -> {
	    this.geolocation.set(!geolocation.get());
	  });
	  
	  @Override
      public void didStart() {
        System.out.println("Started Agent: " + nodeUri().toString());
      }

	  @Override
	  public void willStop() {
        super.willStop();
	  }
}
