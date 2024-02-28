import org.junit.jupiter.api.Test;
import ru.gb.model.Calculation;
import ru.gb.repositories.NumberRepository;
import ru.gb.services.NumberService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberRepositoryTest {
    /**
     * репозиторий
     */
    private NumberRepository numberRepository = new NumberRepository();
    /**
     * mock заглушка на сервис
     */
    private NumberService numberServiceMock = mock(NumberService.class);
    //Calculation calculation = new Calculation();
    @Test
    public void averageNumberServiceTest(){
        // pre
        List<Number> numbersTest = numberRepository.getNumbers();
                // act
        when(numberServiceMock.getNumbers()).thenReturn(numbersTest);
        List<Number> numbers = numberServiceMock.getNumbers();
        // assert
        assertThat(numbers).isEqualTo(numbersTest);
    }
}
