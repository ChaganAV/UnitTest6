import org.junit.jupiter.api.Test;
import ru.gb.model.Calculation;
import ru.gb.repositories.IRepository;
import ru.gb.repositories.NumberRepository;
import ru.gb.services.NumberService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CalculationTest {
    List<Number> numbers1 = Arrays.asList(1,4,6,45,23);
    List<Number> numbers2 = Arrays.asList(3,6,24,64,1);
    List<Number> numbers3 = Arrays.asList(3,64,23,6,2);
    Calculation calculation = new Calculation();
    private final String MESSAGE1 = "Первый список имеет большее среднее значение, если среднее значение первого списка больше";
    private final String MESSAGE2 = "Второй список имеет большее среднее значение, если среднее значение второго списка больше";
    private final String MESSAGE_EQUALLY = "Средние значения равны, если средние значения списков равны";

    /**
     * проверяем на подсчет среднего значения
     */
    @Test
    public void averageTest(){
        assertThat(calculation.getAverage(numbers1)).isEqualTo(15.8);
        assertThat(calculation.getAverage(numbers2)).isEqualTo(19.6);
    }

    /**
     * проверяем на равенство средних значений
     */
    @Test
    public void compareDoubleMoreTest(){
        Double num1 = calculation.getAverage(numbers1);
        Double num2 = calculation.getAverage(numbers2);
        assertThat(calculation.compareDouble(num1,num2)).isEqualTo(MESSAGE2);
    }
    @Test
    public void compareDoubleLessTest(){
        Double num1 = calculation.getAverage(numbers1);
        Double num2 = calculation.getAverage(numbers2);
        assertThat(calculation.compareDouble(num2,num1)).isEqualTo(MESSAGE1);
    }
    @Test
    public void compareDoubleEquallyTest(){
        Double num2 = calculation.getAverage(numbers2);
        Double num3 = calculation.getAverage(numbers3);
        assertThat(calculation.compareDouble(num2,num3)).isEqualTo(MESSAGE_EQUALLY);
    }


}
