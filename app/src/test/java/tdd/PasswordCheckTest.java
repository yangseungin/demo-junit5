package tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordCheckTest {

//    TODO 길이가 8글자 이상
//    TODO 0부터 9사이의 숫자를 포함
//    TODO 대문자 포함
//    TODO 세규칙을 모두 충족하면 강함, 2개 충족하면 보통, 1개이사의 규칙을 충족하면 약함

    private PasswordCheck passwordCheck = new PasswordCheck();

    private void assertStrength(String password, PasswordType expSType) {
        PasswordType result = passwordCheck.check(password);
        assertEquals(expSType, result);
    }

    @Test
    @DisplayName("모든 규칙 만족")
    void meetAllRules() {
        assertStrength("pass12!A", PasswordType.STRONG);

        assertStrength("abc432@Check", PasswordType.STRONG);
    }

    @Test
    @DisplayName("길이가 8글자 미만이고 나머지 규칙을 만족하는 경우")
    void test1() {
        assertStrength("ab1!D", PasswordType.NORMAL);
    }

    @Test
    @DisplayName("숫자를 포함하지않고 나머지 조건을 만족하는 경우")
    void test2() {
        assertStrength("ab!@QWERTY", PasswordType.NORMAL);
    }

    @Test
    @DisplayName("null인 경우")
    void input_null() {
//        TODO - 값이 없는경우 PasswordType.INVALID를 리턴하도록 작성
        assertStrength(null, PasswordType.INVALID);
    }

    @Test
    @DisplayName("빈 문자열인 경우")
    void input_empty() {
        assertStrength("", PasswordType.INVALID);
    }

    @Test
    @DisplayName("대문자를 포함하지 않고 나머지 규칙을 만족하는 경우")
    void not_contain_uppercase_letter() {
        assertStrength("abcd123!@", PasswordType.NORMAL);
    }

    @Test
    @DisplayName("길이가 8글자 이상인 경우")
    void if_only_condition_must_be_8_or_more_is_satisfied() {
        assertStrength("abcdefghijk", PasswordType.WEAK);


    }

}
