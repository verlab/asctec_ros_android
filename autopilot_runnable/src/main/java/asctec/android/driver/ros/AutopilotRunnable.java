package asctec.android.driver.ros;

import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import org.ros.address.InetAddressFactory;
import org.ros.android.RosActivity;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;

import android.view.Window;
import android.view.WindowManager;

import asctec.android.driver.ros.node.AsctecAutopilotNode;
import asctec.android.driver.ros.node.AsctecControlNode;
import autopilot.driver.AsctecDriver;

public class AutopilotRunnable extends RosActivity {


    public AutopilotRunnable() {
        super("autopilot", "autopilot");
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main);
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {
        NodeConfiguration nodeConfiguration = NodeConfiguration
                .newPublic(InetAddressFactory.newNonLoopback().getHostAddress());
        nodeConfiguration.setMasterUri(getMasterUri());

        // Driver
        AsctecDriver driver = new AsctecDriver();
        // Try to connect
        try {
            driver.connect(getSerialParameters(this));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Create the node for sensors
        AsctecAutopilotNode ascNode = new AsctecAutopilotNode(driver);
        // Exectute the node
        nodeMainExecutor.execute(ascNode, nodeConfiguration);

        // Create node for control
        AsctecControlNode ctrNode = new AsctecControlNode(driver);
        nodeMainExecutor.execute(ctrNode, nodeConfiguration);

        // Altitud control
//        AltitudeNode altNode = new AltitudeNode();
//        nodeMainExecutor.execute(ctrNode, nodeConfiguration);
    }

    //TODO stop driver.

    private HashMap<String, Object> getSerialParameters(Activity act) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("Activity", act);
        params.put("baudrate", 57600);
        params.put("dataBits", 8);
        params.put("stopBits", 1);
        params.put("parity", 0);

        return params;
    }
}
