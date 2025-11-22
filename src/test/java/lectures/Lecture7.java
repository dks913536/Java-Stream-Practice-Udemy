package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
	long count= MockData.getPeople()
	 	.stream()
	 	.filter(person -> person.getGender().equalsIgnoreCase("female"))
	 	.count();
	
//	System.out.println(count);

  }

  @Test
  public void min() throws Exception {
	  double min=MockData.getCars()
			  .stream()
			  .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
			  .mapToDouble(Car::getPrice)
			  .min()
			  .getAsDouble();
//	  System.out.println("Min : "+min);

  }

  @Test
  public void max() throws Exception {
	  double max=MockData.getCars()
			  .stream()
			  .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
			  .mapToDouble(Car::getPrice)
			  .max()
			  .getAsDouble();
//	  System.out.println("Max : "+max);

  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double averagePrice=cars.stream()
    		.mapToDouble(Car::getPrice)
    		.average()
    		.orElse(0);	//for empty list its return 0
//    System.out.println("Average : "+averagePrice);

  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
    		.mapToDouble(Car::getPrice)
    		.sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
//    System.out.println("Sum : "+sum);
//    System.out.println("BigDecimalSum :"+bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
    		.mapToDouble(Car::getPrice)
    		.summaryStatistics();
    System.out.println(statistics);
    System.out.println("Average : "+statistics.getAverage());
    System.out.println("Count : "+statistics.getCount());
    System.out.println("Max : "+statistics.getMax());
    System.out.println("Min : "+statistics.getMin());
    System.out.println("Sum : "+statistics.getSum());
    

  }

}