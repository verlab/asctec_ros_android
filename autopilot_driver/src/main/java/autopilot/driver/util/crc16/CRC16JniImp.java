package autopilot.driver.util.crc16;

/**
 * Implementation for CRF16 based on JNI.
 *
 */
public class CRC16JniImp implements ICRC16 {

	static {
	    System.loadLibrary("ndk_asctec");
	}
	
	private native short crc16(int data[], short cnt);
	
	@Override
	public int crc16(int[] data) {
		return crc16(data, (short) data.length);
	}

}
