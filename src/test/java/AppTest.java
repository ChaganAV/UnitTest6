import org.junit.jupiter.api.Test;
import ru.gb.model.Calculation;
import ru.gb.repositories.IRepository;
import ru.gb.services.NumberService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTest {
    /**
     * mock заглушка на репозиторий
     */
    private IRepository repositoryMock = mock(IRepository.class);
    /**
     * service
     */
    private NumberService numberService = new NumberService(repositoryMock);
    /**
     * калькулятор для расчетов
     */
    Calculation calculation = new Calculation();
    /**
     * константы
     */
    private final String MESSAGE1 = "Первый список имеет большее среднее значение, если среднее значение первого списка больше";
    private final String MESSAGE2 = "Второй список имеет большее среднее значение, если среднее значение второго списка больше";
    private final String MESSAGE_EQUALLY = "Средние значения равны, если средние значения списков равны";
    @Test
    public void runTest(){
        // pre
        List<Number> numbersTest = Arrays.asList(1,4,6,45,23);
        Double doubleResultTest = calculation.getAverage(numbersTest);
        List<Number> numbers2Test = Arrays.asList(3,6,24,64,1);
        Double doubleResult2Test = calculation.getAverage(numbers2Test);
//        List<Number> numbers3 = Arrays.asList(3,64,23,6,2);
        // act
        when(repositoryMock.getNumbers()).thenReturn(numbersTest);
        List<Number> numbers1 = numberService.getNumbers();
        //
        when(repositoryMock.getNumbers()).thenReturn(numbers2Test);
        List<Number> numbers2 = numberService.getNumbers();


        // assert
        /**
         * проверка getAverage
         */
        assertThat(calculation.getAverage(numbers1)).isEqualTo(doubleResultTest);
        assertThat(calculation.getAverage(numbers2)).isEqualTo(doubleResult2Test);
        /**
         * проверка compareDouble
         */
        double result1 = calculation.getAverage(numbers1);
        double result2 = calculation.getAverage(numbers2);
        assertThat(calculation.compareDouble(result1, result2)).isEqualTo(MESSAGE2);
    }
}
