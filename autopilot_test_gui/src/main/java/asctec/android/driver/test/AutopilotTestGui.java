package asctec.android.driver.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.HashMap;

import autopilot.driver.AsctecDriver;

/**
 * Test for the driver without ROS.
 */
public class AutopilotTestGui extends Activity
{
    /**
     * Asctec Driver.
     */
    AsctecDriver driver;

    /**
     * State variable for communication.
     */
    boolean connected = false;
    boolean isTurnedOn = false;

    TextView outputTV;

    /**
     * Default constructor.
     */
    public AutopilotTestGui() {
        driver = new AsctecDriver();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputTV = (TextView) findViewById(R.id.textView1);
        final Activity act = this;

        // Connect checkbox.
        CheckBox cbConnect = (CheckBox) findViewById(R.id.checkBoxConnect);
        cbConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cbConnect = (CheckBox) v;
                if (cbConnect.isChecked()) {
                    try {
                        driver.connect(getSerialParameters(act));
                    } catch (Exception e) {
                        e.printStackTrace();
                        outputTV.setText(">> " + e.getMessage());
                        cbConnect.setChecked(false);
                    }
                } else {
                    // Disconnect
                    try {
                        driver.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                        outputTV.setText(">> " + e.getMessage());
                        cbConnect.setChecked(true);
                    }
                }
            }
        });

        // Button for IMU
        Button buttonIMU = (Button) findViewById(R.id.buttonIMU);
        buttonIMU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[] senseIMU = driver.senseIMU();

                if (senseIMU == null) {
                    outputTV.setText(">> error");
                    return;
                }

                outputTV.setText(">> g: " + senseIMU[0] + "," + senseIMU[1]
                        + "," + senseIMU[2]);
				/*
				 * + senseIMU[4] + "," + senseIMU[5] + "\na:" + senseIMU[6] +
				 * "," + senseIMU[7] + "," + senseIMU[8] + "\np:" +
				 * senseIMU[9]);
				 */

            }
        });
        // Button for Voltage
        Button buttonVoltage = (Button) findViewById(R.id.buttonVolt);
        buttonVoltage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double voltage = driver.getVoltage();
                outputTV.setText(">> voltage=" + voltage + " V");
            }
        });
        // Motors
        Button toggleMotors = (Button) findViewById(R.id.toggleMotors);
        toggleMotors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTurnedOn = !isTurnedOn;
                driver.turnOnOff(isTurnedOn);
            }
        });

        // CRC16
        Button crcButton = (Button) findViewById(R.id.buttonCRC16);
        crcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int response = driver.crc16(new int[] { 00, 01, 4, 0, 0, 0, 0,
                        0, 0, 0, 0, 0 });
                outputTV.setText(">> crc16=" + response);
            }
        });

        // CRC16
        Button crcSpeed= (Button) findViewById(R.id.buttonSpeed);
        crcSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driver.pryControl(0, 0, 0, 0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

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
