/*Create a class CovidParameters which inherits Patient class. The class
CovidParameters has the following members:
- No argument constructor which initialises CTScore, D-dimer
and platelet to zero and also call the parent class constructor.
- Parameterise constructor which initialise the class variables as
per arguments given and also call the parent class
constructor.
- float CTScore - which is used to store CT scan score of
patients.
- float D-dimer - which is used to store D-dimer score of
patients.
- int platelet - which is used to store platelet count of patient */

class Patient {
    private String name;
    private int age;

    public Patient() { //default constructor
        name = "";
        age = 0;
    }

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
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
}

class CovidParameters extends Patient {
    private float CTScore;
    private float Ddimer;
    private int platelet;

    public CovidParameters() { //default constructor
        super(); 
        this.CTScore = 0.0f;
        this.Ddimer = 0.0f;
        this.platelet = 0;
    }

    public CovidParameters(String name, int age, float CTScore, float Ddimer, int platelet) {// Parameterized constructor
        super(name, age);
        this.CTScore = CTScore;
        this.Ddimer = Ddimer;
        this.platelet = platelet;
    }

    public float getCTScore() {
        return CTScore;
    }

    public void setCTScore(float CTScore) {
        this.CTScore = CTScore;
    }

    public float getDdimer() {
        return Ddimer;
    }

    public void setDdimer(float Ddimer) {
        this.Ddimer = Ddimer;
    }

    public int getPlatelet() {
        return platelet;
    }

    public void setPlatelet(int platelet) {
        this.platelet = platelet;
    }

    public void displayDetails() {
        System.out.println("Patient Name: " + getName());
        System.out.println("Patient Age: " + getAge());
        System.out.println("CT Score: " + getCTScore());
        System.out.println("D-dimer: " + getDdimer());
        System.out.println("Platelet Count: " + getPlatelet());
    }
}

public class inhe {
    public static void main(String[] args) {
        CovidParameters patient1 = new CovidParameters("Nicolas Jackson", 35, 23.5f, 124.2f, 180000);

        System.out.println("Patient 1 Details:");
        patient1.displayDetails();
        System.out.println();

        CovidParameters patient2 = new CovidParameters("Diddier Drogba", 55, 13.3f, 14.22f, 180000);
        System.out.println("Patient 2 Details:");
        patient2.displayDetails();
    }
}
