package autopilot.communication.serial;

import java.io.IOException;
import java.util.Map;


import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbManager;
import android.util.Log;

import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialProber;

import autopilot.communication.ICommunication;


public class SerialCommunication implements ICommunication {

	private static final int SEND_TIMEOUT = 100;

	private static final String TAG = SerialCommunication.class.getSimpleName();

	private UsbManager manager;

	private UsbSerialDriver serialDriver;

	@Override
	public synchronized void send(byte[] data) {
		try {
			serialDriver.write(data, 1000);
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}

	}

	@Override
	public synchronized void send(byte data) {
		try {
			serialDriver.write(new byte[] { data }, SEND_TIMEOUT);
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}
	}

	@Override
	public synchronized int receive(byte[] buffer) {
		try {
			int read = serialDriver.read(buffer, SEND_TIMEOUT);
			return read;
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
			return -1;
		}

	}

	@Override
	public void connect(Map<String, Object> params) throws Exception {
		Activity activity = (Activity) params.get("Activity");
		manager = (UsbManager) activity.getSystemService(Context.USB_SERVICE);

		// Serial parameters
		int baudRate = (Integer) params.get("baudrate");
		int dataBits = (Integer) params.get("dataBits");
		int stopBits = (Integer) params.get("stopBits");
		int parity = (Integer) params.get("parity");

		// Open serial driver.
		serialDriver = UsbSerialProber.acquire(manager);
		try {
			serialDriver.open();
			serialDriver.setParameters(baudRate, dataBits, stopBits, parity);
		} catch (IOException e) {
			serialDriver.close();
			throw new Exception("Error opeening the driver.", e);
		}
	}

	@Override
	public void disconnect() throws Exception {
		serialDriver.close();

	}

}
