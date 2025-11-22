package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    
    
    
//    List<Car> carsFilter= cars.stream()
//    	.filter(carPredicate)
//    	.collect(Collectors.toList());
//    carsFilter.forEach(System.out::println);
//    System.out.println(carsFilter.size());

  }
  final Predicate<Car> carPredicate=car -> car.getPrice() < 20000; //its like function we can resused it.
  
  
  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
//    List<PersonDTO> dtos=people.stream()
//    	.map(person -> {
//    		PersonDTO dto=new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//    		return dto;
//    	})
//    	.collect(Collectors.toList());
    //--------------OR---------------------
    List<PersonDTO> dtos=people.stream()
        	.map(PersonDTO::map)
        	.collect(Collectors.toList());
    
    dtos.forEach(System.out::println);
    System.out.println(dtos.size());
    
    /* for map(PersonDTO::map) PersonDTO called from PersonDTO.java class
    public static PersonDTO map(Person person) {
    return new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
  }
     */

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
	  double average=MockData.getCars()
			  .stream()
			  .mapToDouble(Car::getPrice)
			  .average()
			  .orElse(0);
	  System.out.println(average);

  }

}



