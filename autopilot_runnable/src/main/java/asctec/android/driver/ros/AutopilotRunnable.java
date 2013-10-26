package asctec.android.driver.ros;

import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import org.ros.address.InetAddressFactory;
import org.ros.android.RosActivity;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import asctec.android.driver.ros.node.AsctecAutopilotNode;
import asctec.android.driver.ros.node.AsctecControlNode;
import autopilot.driver.AsctecDriver;

import static asctec.android.driver.ros.R.*;

public class AutopilotRunnable extends RosActivity {
    TextView textView1;
    String text;

    Handler handler;
    public AutopilotRunnable() {
        super("autopilot", "autopilot");
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(layout.main);
        textView1 = (TextView) findViewById(id.textViewEx);

        text = "Asctec Autopilot ROS\n";
        textView1.setText(text);

         handler = (Handler) new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                textView1.setText(text);
            }
        };


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
//            textView1.setText(textView1.getText() + "> Driver has started!\n");
            text += "> Driver has started!\n";
            handler.sendEmptyMessage(0);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(AutopilotRunnable.class.getName(),"Error when initializing driver", e);

            text += "Error initializing driver: " +e.getMessage();
            handler.sendEmptyMessage(0);
//            textView1.setText(textView1.getText() +
//                    e.getMessage());
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
