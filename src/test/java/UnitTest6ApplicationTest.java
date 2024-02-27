import org.junit.jupiter.api.Test;
import ru.gb.model.Calculation;
import ru.gb.repositories.NumberRepository;
import ru.gb.services.NumberService;

import java.util.Arrays;
import java.util.List;

public class UnitTest6ApplicationTest {
    @Test
    public void mainTest(){
//        List<Number> numbers1 = Arrays.asList(1,4,6,45,23);
//        List<Number> numbers2 = Arrays.asList(3,6,24,64,1);
//        List<Number> numbers3 = Arrays.asList(3,64,23,6,2);
        NumberRepository numberRepository = new NumberRepository();
        NumberService numberService = new NumberService(numberRepository);
        List<Number> numbers1 = numberService.getNumbers();
        List<Number> numbers2 = numberService.getNumbers();
        Calculation calculation = new Calculation();
        double result1 = calculation.getAverage(numbers1);
        double result2 = calculation.getAverage(numbers2);
        String message = calculation.compareDouble(result1, result2);
        System.out.println(message);
    }
}
