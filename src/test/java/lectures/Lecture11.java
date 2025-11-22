package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    
    String join="";
    
    for(String name :names) {
    	join +=name+", ";
    }
    
//    System.out.println(join.substring(0, join.length()-1));
//    System.out.println(join.substring(0, join.length()-2)); 	//-2 for remove extra , from list in last

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    
    String join=names.stream()
    		.collect(Collectors.joining());
    System.out.println(join); //annajohnmarcoshelenayasmin
    
    String join2=names.stream()
    		.map(String::toUpperCase)
    		.collect(Collectors.joining("|"));
    System.out.println(join2); //ANNA|JOHN|MARCOS|HELENA|YASMIN
    
    String join3=names.stream()
    		.collect(Collectors.joining(","));
    System.out.println(join3); //anna,john,marcos,helena,yasmin

  }
}
