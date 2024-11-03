package task02.devices;

public class SmartThermostat extends IoTDevice{

    private int temperature;

    public SmartThermostat(int id, String name) {
        super(id, name);
        temperature = 22;
    }

    @Override
    public void performAction() {
        super.performAction();
        System.out.println("SmartThermostat now has temperature " + temperature);
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }
}
