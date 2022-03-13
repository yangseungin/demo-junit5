package assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;

class ExceptionAssertionTest {

    @Test
    void ExceptionTest() {
        Throwable throwable = new IllegalArgumentException("wrong count");

        assertThat(throwable).hasMessageContaining("wrong count");

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    throw new RuntimeException(new IllegalArgumentException("boom"));
                })
                .havingCause()
                .withMessage("boom");


        //given
        String[] fruits = {"apple", "banana", "cherry"};
        //when
        Throwable thrown = catchThrowable(() -> System.out.println(fruits[10]));
        //then
        then(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("10");

        assertThat(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("10");


        assertThatThrownBy(() -> {
            throw new Exception("boom");
        })
                .isInstanceOf(Exception.class)
                .hasMessageContaining("boom");



    }

}
