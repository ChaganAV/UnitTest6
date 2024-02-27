import org.junit.jupiter.api.Test;
import ru.gb.model.Calculation;
import ru.gb.repositories.IRepository;
import ru.gb.services.NumberService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberServiceTest {
    /**
     * mock заглушка на репозиторий
     */
    IRepository numberRepositoryMock = mock(IRepository.class);

    /**
     * используем заглушку репозитория для numberService
     */
    NumberService numberService = new NumberService(numberRepositoryMock);
    Calculation calculation = new Calculation();
    /**
     * проверка метода getNumbers сервиса numberService
     */
    @Test
    public void averageNumberServiceTest(){
        // pre
        List<Number> numbersTest = Arrays.asList(2,4,6,8);
        Double doubleResult = calculation.getAverage(numbersTest);
        // act
        when(numberRepositoryMock.getNumbers()).thenReturn(numbersTest);
        List<Number> numbers = numberService.getNumbers();
        // assert
        assertThat(calculation.getAverage(numbers)).isEqualTo(doubleResult);
    }
}
