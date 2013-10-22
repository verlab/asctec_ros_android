package asctec.android.driver.ros.node;


import org.ros.concurrent.CancellableLoop;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Publisher;

import asctec_msgs.GPSData;
import asctec_msgs.IMUCalcData;
import asctec_msgs.LLStatus;
import autopilot.driver.AsctecDriver;

/**
 * Created by dav on 10/22/13.
 */
public class AsctecAutopilotNode extends AbstractNodeMain {
    // Topic names
    private static final String ASCTEC_MSGS_LL_STATUS = "asctec_msgs/llStatus";
    private static final String ASCTEC_MSGS_GPS_DATA = "asctec_msgs/GPSData";
    private static final String ASCTEC_MSGS_IMU_CALC_DATA = "asctec_msgs/IMUCalcData";

    AsctecDriver driver;

    /**
     *
     * @param params
     *            Serial connection parameters
     */
    public AsctecAutopilotNode(AsctecDriver driver) {

        this.driver = driver;

    }

    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("autopilot_sensors");
    }

    @Override
    public void onStart(ConnectedNode connectedNode) {

        // Publisher for IMU sensors.
        final Publisher<asctec_msgs.IMUCalcData> imuPublisher = connectedNode
                .newPublisher(ASCTEC_MSGS_IMU_CALC_DATA,
                        asctec_msgs.IMUCalcData._TYPE);

        // Publisher for GPS sensor
        final Publisher<asctec_msgs.GPSData> gpsPublisher = connectedNode
                .newPublisher(ASCTEC_MSGS_GPS_DATA, asctec_msgs.GPSData._TYPE);

        // Publisher for ll Status.
        final Publisher<asctec_msgs.LLStatus> llsPublisher = connectedNode
                .newPublisher(ASCTEC_MSGS_LL_STATUS,
                        asctec_msgs.LLStatus._TYPE);

        /**
         * Execute a loop.
         */
        connectedNode.executeCancellableLoop(new CancellableLoop() {

            @Override
            protected void loop() throws InterruptedException {
                // Get data.
                double[] senseIMU = driver.senseIMU();

                // IMU
                IMUCalcData msg = imuPublisher.newMessage();

                // Angle
                // Value is multiplied for 1000 to get 2 decimals.
                // compass reading: angle reference for angle_yaw: 0..360000;
                // 1000 = 1 degree
                msg.setAngleRoll((int) Math.round(senseIMU[0] * 1000));
                msg.setAngleNick((int) Math.round(senseIMU[1] * 1000));
                msg.setAngleYaw((int) Math.round(senseIMU[2] * 1000));

                // Magnetic field
                msg.setHx((int) Math.round(senseIMU[3]) * 1000);
                msg.setHy((int) Math.round(senseIMU[4]) * 1000);
                msg.setHz((int) Math.round(senseIMU[5]) * 1000);

                // Acceleration
                // total acceleration measured (10000 = 1g)
                msg.setAccX((short) Math.round(senseIMU[6] * 1000));
                msg.setAccX((short) Math.round(senseIMU[7] * 1000));
                msg.setAccX((short) Math.round(senseIMU[8] * 1000));

                imuPublisher.publish(msg);

                // ////////////// GPS /////////////////
                double[] gpsData = driver.senseGPS();
                // Message
                GPSData gpsMsg = gpsPublisher.newMessage();
                gpsMsg.setLatitude((int) Math.round(gpsData[0] * 1000));
                gpsMsg.setLongitude((int) Math.round(gpsData[1] * 1000));
                gpsMsg.setHeight((int) Math.round(gpsData[2] * 1000));
                gpsMsg.setSpeedX((int) Math.round(gpsData[3] * 1000));
                gpsMsg.setSpeedY((int) Math.round(gpsData[4] * 1000));
                gpsMsg.setHeading((int) Math.round(gpsData[5] * 1000));
                gpsMsg.setHorizontalAccuracy((int) Math
                        .round(gpsData[6] * 1000));
                gpsMsg.setVerticalAccuracy((int) Math.round(gpsData[7] * 1000));
                gpsMsg.setSpeedAccuracy((int) Math.round(gpsData[8] * 1000));
                gpsMsg.setNumSV((int) Math.round(gpsData[9]));
                gpsMsg.setStatus((int) Math.round(gpsData[10]));
                // Publish
                gpsPublisher.publish(gpsMsg);

                // ////////////// LL Status ///////////////
                // get batteryVoltage
                double voltage = driver.getVoltage();
                LLStatus llsMsg = llsPublisher.newMessage();
                llsMsg.setBatteryVoltage1((short) Math.round(voltage * 1000));
                // TODO Motors On is not yet implemented

                llsPublisher.publish(llsMsg);

                Thread.sleep(100);
            }

        });
    }
}
