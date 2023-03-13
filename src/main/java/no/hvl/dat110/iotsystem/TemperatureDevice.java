package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to
		Client sensorClient = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
		// - connect to the broker - user "sensor" as the user name
		sensorClient.connect();
		// - publish the temperature(s)
		int i = 0;
		while (i < COUNT) {
			sensorClient.publish(Common.TEMPTOPIC, sn.read() + "");
			i++;
		}
			// - disconnect from the broker
			sensorClient.disconnect();
			// TODO - end

			//System.out.println("Temperature device stopping ... ");

			//throw new UnsupportedOperationException(TODO.method());

		}
	}
