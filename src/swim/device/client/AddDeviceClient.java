package swim.device.client;

import swim.basic.ClientRuntime;
import swim.basic.MapDownlink;

public class AddDeviceClient {
	
	public static void main(String[] args) throws InterruptedException {
	    ClientRuntime swimClient = new ClientRuntime();
	    swimClient.start();

	    final String hostUri = "warp://localhost:9001";
	    final String buildingUri = "/building/swim";
	    final String firstRoomUri = "/swim/1";
	    final String secondRoomUri = "/swim/2";
	    final String thirdRoomUri = "/swim/3";

	    final MapDownlink<Integer, Boolean> link = swimClient.downlinkMap()
	        .keyForm(Form.forInteger()).valueForm(Form.forBoolean())
	        .hostUri(hostUri).nodeUri(buildingUri).laneUri("lights")
	        .didUpdate((key, newValue, oldValue) -> {
	          System.out.println("The lights in room " + key + " are " + (newValue ? "on" : "off"));
	        })
	        .open();

	    Thread.sleep(2000);

	    swimClient.command(hostUri, firstRoomUri, "toggleLights", Value.absent());
	    swimClient.command(hostUri, secondRoomUri, "toggleLights", Value.absent());
	    swimClient.command(hostUri, thirdRoomUri, "toggleLights", Value.absent());
	    swimClient.command(hostUri, secondRoomUri, "toggleLights", Value.absent());
	    swimClient.command(hostUri, secondRoomUri, "toggleLights", Value.absent());
	    swimClient.command(hostUri, thirdRoomUri, "toggleLights", Value.absent());

	    Thread.sleep(2000);
	    System.out.println("Will shut down client in 2 seconds");
	    Thread.sleep(2000);

	    swimClient.stop();
	  }
}
