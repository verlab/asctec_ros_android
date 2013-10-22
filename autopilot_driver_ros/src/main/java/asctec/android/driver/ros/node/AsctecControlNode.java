package asctec.android.driver.ros.node;

import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.service.ServiceResponseBuilder;

import autopilot.driver.AsctecDriver;

/**
 * Created by dav on 10/22/13.
 */
public class AsctecControlNode extends AbstractNodeMain {

    private AsctecDriver driver;

    public AsctecControlNode(AsctecDriver driver) {
        this.driver = driver;
    }

    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("autopilot_control");
    }
//
//    @Override
//    public void onStart(final ConnectedNode connectedNode) {
//
//        // Service for setting motors on/off.
//        connectedNode
//                .newServiceServer(
//                        "mav/setMotorsOnOff",
//                        asctec_hl_comm.mav_ctrl_motors._TYPE,
//                        new ServiceResponseBuilder<asctec_hl_comm.mav_ctrl_motorsRequest, asctec_hl_comm.mav_ctrl_motorsResponse>() {
//
//                            @Override
//                            public void build(mav_ctrl_motorsRequest req,
//                                              mav_ctrl_motorsResponse res)
//                                    throws ServiceException {
//
//                                boolean startMotors = req.getStartMotors();
//                                driver.turnOnOff(startMotors);
//
//                                // TODO get state of the motors is not yet
//                                // implemented.
//                                res.setMotorsRunning(startMotors);
//                            }
//                        });
//
//        // TODO Service for controlling the movement.
//        // connectedNode
//        // .newServiceServer("asctec_hl_comm/mav_ctrl_motors",asctec_hl_comm.MavCtrlSrv._TYPE,
//        // new ServiceResponseBuilder<asctec_hl_comm.MavCtrlSrvRequest,
//        // asctec_hl_comm.MavCtrlSrvResponse>() {
//        //
//        // @Override
//        // public void build(MavCtrlSrvRequest req,
//        // MavCtrlSrvResponse res) throws ServiceException {
//        // controlMovement(req, res);
//        // }
//        // });
//
//        // cmd_vel
//        Subscriber<geometry_msgs.Twist> suscriptor = connectedNode
//                .newSubscriber("cmd_vel", geometry_msgs.Twist._TYPE);
//
//        suscriptor
//                .addMessageListener(new MessageListener<geometry_msgs.Twist>() {
//
//                    @Override
//                    public void onNewMessage(geometry_msgs.Twist msg) {
//                        // Velocities
//                        double x = msg.getLinear().getX();
//                        double y = msg.getLinear().getY();
//                        double z = msg.getLinear().getZ();
//                        double ax = msg.getAngular().getX();
//                        double ay = msg.getAngular().getY();
//                        double az = msg.getAngular().getZ();
//
//                        connectedNode.getLog().info("velocity x: " + x);
//
//                        driver.velocityControl(x, y, z, ax, ay, az);
//                    }
//                });
//
//        // take off service
//
//        // Start loop
//    }
//
//    /**
//     * Control the movement of the quadcopter. control commands, all units in SI
//     * units !!!
//     *
//     * There are 3 operating modes of the helicopter:
//     *
//     * 1. Acceleration: x, y, z correspond to x_dotdot etc... with the exception
//     * that yaw is angular velocity Inputs must be in body-coordinates Currently
//     * x~pitch, y~roll, z~thrust, units in rad and rad/s for yaw
//     *
//     * 2. Velocity: x, y, z, yaw correspond to x_dot etc... Vehicle must have
//     * it's own pose estimation e.g. vision/GPS Inputs must be in
//     * body-coordinates Units in m/s and rad/s respectively 3. Position Vehicle
//     * must have it's own pose estimation e.g. vision/GPS Inputs in fixed
//     * coordinate system v_max_* is only valid for this mode and limits the
//     * velocity a vehicle approaches the waypoint
//     *
//     * Based on http://wiki.ros.org/asctec_hl_interface#Services
//     *
//     * @param req
//     *            request message
//     * @param res
//     *            response message.
//     */
//    protected void controlMovement(MavCtrlSrvRequest req, MavCtrlSrvResponse res) {
//
//        // TODO
//        mav_ctrl ctrl = req.getCtrl();
//        // driver.velocityControl(x, y, z, angX, angY, angZ);
//    }
}
