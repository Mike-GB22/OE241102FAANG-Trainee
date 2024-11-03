package task02.devices;

public class SmartLight extends IoTDevice{
    private boolean isOn;
    public SmartLight(int id, String name) {
        super(id, name);
        isOn = false;
    }

    @Override
    public void performAction() {
        super.performAction();
        isOn = !isOn;
        System.out.println("SmartLight now is " + (isOn ? "on" : "off"));
    }
}
