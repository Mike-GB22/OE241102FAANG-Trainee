package task02.devices;

public class IoTDevice {
    private int id;
    private String name;

    public void performAction(){
        System.out.print("Performing action for device: " + name + ". ");
    }

    public IoTDevice(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
