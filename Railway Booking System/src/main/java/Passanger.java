public class Passanger {

    private String name;
    private int age;
    private char gender;
    private String  berth;
    private String Booking_id;
    private String allocatedBerth;

    public Passanger(String name,int age, char gender, String berth, String booking_id, String allocatedBerth) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berth = berth;
        Booking_id = booking_id;
        this.allocatedBerth = allocatedBerth;
    }

    @Override
    public String toString() {
        return "Passanger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", berth='" + berth + '\'' +
                ", Booking_id='" + Booking_id + '\'' +
                ", allocatedBerth='" + allocatedBerth + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBerth() {
        return berth;
    }

    public void setBerth(String berth) {
        this.berth = berth;
    }

    public String getBooking_id() {
        return Booking_id;
    }

    public void setBooking_id(String booking_id) {
        Booking_id = booking_id;
    }

    public String getAllocatedBerth() {
        return allocatedBerth;
    }

    public void setAllocatedBerth(String allocatedBerth) {
        this.allocatedBerth = allocatedBerth;
    }
}
