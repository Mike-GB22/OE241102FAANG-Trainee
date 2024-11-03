// 2024.11.02
// Система управления IoT
package task02;

import task02.devices.IoTDevice;
import task02.devices.SmartLight;
import task02.devices.SmartThermostat;

import java.util.ArrayList;
import java.util.List;

public class IoTSystem {
    public static void main(String[] args) {
        int count = 0;
        List<IoTDevice> listOfDevives = new ArrayList<>();

        listOfDevives.add(new SmartLight(count++, "Light in Room 1"));
        listOfDevives.add(new SmartLight(count++, "Light in Room 2"));

        listOfDevives.add(new SmartThermostat(count++, "Thermostatt in Room 1"));
        listOfDevives.add(new SmartThermostat(count++, "Thermostatt in Room 2"));

        for (IoTDevice device : listOfDevives){
            device.performAction();
        }

        for (IoTDevice device : listOfDevives){
            if (device instanceof SmartThermostat) {
                ((SmartThermostat) device).setTemperature(30);
                device.performAction();
            }
        }

    }
}
