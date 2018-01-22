package pl.salata;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CatDAO {


    List <Cat> cats = new ArrayList<Cat>();

    public void addCat(Cat cat){
        cats.add(cat);
        System.out.println("Thank you, new cat has been added to cats registry.");
    }

    public List<Cat> getCats() {
        return cats;
    }

    public Cat getKotById(Integer id) {
        if (id<cats.size()) {
            return cats.get(id);
        } else {
            return null;
        }
    }
}
