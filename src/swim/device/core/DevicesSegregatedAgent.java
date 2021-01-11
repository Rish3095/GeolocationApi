package swim.device.core;

import swim.basic.CommandLane;
import swim.basic.JoinValueLane;
import swim.basic.SwimLane;
import swim.basic.Value;

public class DevicesSegregatedAgent {
	
	  @SwimLane("joinDevices")
	  JoinValueLane<String, Float[]> lights = this.<String, Floatp[]>joinValueLane().didUpdate((String key, Float[] oldValue, Float[] newValue) -> {
	    System.out.println("The device " + key + " is at " + newValue[0] + ", " + newValue[1]);
	  });

	  @SwimLane("registerDevice")
	  CommandLane<Value> registerRoom = this.<Value>commandLane().onCommand(device -> {
	    String deviceUri = "/device/" + this.getProp("id").stringValue();
	    this.joinDevices.downlink(device.intValue()).nodeUri(deviceUri).laneUri("----").open();
	  });
}
