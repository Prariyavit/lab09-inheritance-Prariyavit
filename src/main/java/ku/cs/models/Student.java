package ku.cs.models;

public class Student {
    private String id;
    private String name;
    private double score;
    private Wallet wallet;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        score = 0;
        this.wallet = new Wallet();
    }

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.wallet = new Wallet();
    }

    public void changeName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public void addScore(double score) {
        if (score > 0) {
            this.score += score;
        }
    }

    public String grade()
    {
        if (score >= 80) return "A";
        else if (score >= 75) return "B+";
        else if (score >= 70) return "B";
        else if (score >= 65) return "C+";
        else if (score >= 60) return "C";
        else if (score >= 55) return "D+";
        else if (score >= 50) return "D";
        else return "F";
    }

    public boolean isId(String id) {
        return this.id.equals(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public Wallet getWallet() { return wallet; }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", wallet=" + wallet +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student other = (Student) obj;
            return id.equals(other.id) && name.equals(other.name);
        }
        return false;
    }
}