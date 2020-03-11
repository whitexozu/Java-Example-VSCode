package optional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OptionalTest {

  public static <T> Optional <T> getAsOptional(final List <T> list, final int index) {
    try {
      return Optional.of(list.get(index));
    } catch (IndexOutOfBoundsException e) {
      return Optional.empty();
    }
  }

  public static void main(final String[] args) throws Exception {
    // Map Optional 적용
    final Map <Integer, String> cities = new HashMap <> ();
    cities.put(1, "Seoul");
    cities.put(2, "Busan");
    cities.put(3, "Daejeon");

    /* 
      cities 의 4번째 값이 null이면 Optional.empty 반환, null이 아니면 Optional.[value] 반환
      값이 있으면 length 반환, 없으면 0 반환
    */
    final Optional < String > maybeCity = Optional.ofNullable(cities.get(3)); // Optional
    System.out.println(maybeCity);
    final int length = maybeCity.map(String::length).orElse(0); // null-safe
    System.out.println("length: " + length);

    // List Optional 적용
    final List <String> foods = new LinkedList<>();
    foods.add(0, "nudle");
    foods.add(1, "pizza");
    foods.add(2, "hotdog");
    foods.add(3, "chicken");
    
    /* 
      foods 의 4번째 값이 null이면 Optional.empty 반환, null이 아니면 Optional.[value] 반환
      값이 있으면 length 반환, 없으면 0 반환
    */
    final Optional < String > maybeFood = getAsOptional(foods, 4); // Optional ()
    System.out.println(maybeFood);
    final int length2 = maybeFood.map(String::length).orElse(0); // null-safe
    System.out.println("length: " + length2);

    /*
      ifPresent 메소드
      maybeFood 의 4번째 값이 null이 아닌경우에만 실행.
    */
    maybeFood.ifPresent(city -> {
      System.out.println("length: " + city.length());
    });
  }
}