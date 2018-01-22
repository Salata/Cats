package pl.salata;

import java.util.Date;

public class Cat {
    private String name;
    private Date dateBirth;
    private float Weight;
    private String nameHandler;

    public String displayData(){
        String sentence = "Cat's name is " + getName() + " he was born "+getDateBirth()+" he weights "+getWeight()+" "+getNameHandler() + " is responsible for him.";
        return sentence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public String getNameHandler() {
        return nameHandler;
    }

    public void setNameHandler(String nameCarrier) {
        this.nameHandler = nameCarrier;
    }
}
