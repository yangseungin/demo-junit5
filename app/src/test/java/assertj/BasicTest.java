package assertj;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

class BasicTest {

    private Person yang = new Person("Yang", 31);
    private Person yang2 = new Person("Yang", 31);


    @Test
    void AssertionTest() {
        assertThat("abc")
                .isNotEqualTo("xyz");

        assertThat("abcde")
                .startsWith("abc")
                .endsWith("de")
                .isEqualToIgnoringCase("abcde");

        assertThat(yang).matches(person -> person.getAge() > 30);

//        assertThat(yang).isEqualTo(yang2);  //fail

        assertThat("".isBlank()).isTrue();

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        assertThat(list)
                .contains(3)
                .isNotEmpty()
                .startsWith(1);


    }

    @Test
    void BDDAssertionTest() {
        then(yang.getAge()).isEqualTo(31);
        then(yang.getName()).isEqualTo("Yang").isNotEqualTo("yang");

        then(yang).matches(person -> person.getAge() > 30);
    }

}
