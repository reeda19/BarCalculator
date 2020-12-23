package repository;


import model.BoughtDrink;
import model.Drink;
import org.springframework.data.repository.CrudRepository;

public interface BoughtDrinkRepository extends CrudRepository<BoughtDrink, Integer> {

}
