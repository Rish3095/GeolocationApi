package swim.device.core;

import swim.transit.Kernel;
import swim.transit.Space;

public class DevicePlane {
	
	@SwimAgent("device")
	@SwimRoute("/device/:id")
	AgentRoute<DeviceAgent> deviceAgent;
	
	@SwimAgent("device")
	@SwimRoute("/map/:devices")
	AgentRoute<DevicesSegregatedAgent> devicesSegregatedAgent;
	
	public static void main(String[] args) {
	    final Kernel kernel = ServerLoader.loadServer();
	    final Space space = kernel.getSpace("device");
	    
	    kernel.start();
	    System.out.println("Running DevicePlane...");
	    
	    //TODO: Pass the data from the API's
	    // Depending on the number of devices, that amount of web-agents will start
	    
	    kernel.run();

	}
	
}
