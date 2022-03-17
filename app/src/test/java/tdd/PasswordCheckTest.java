package tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordCheckTest {

//    TODO 길이가 8글자 이상
//    TODO 0부터 9사이의 숫자를 포함
//    TODO 대문자 포함
//    TODO 세규칙을 모두 충족하면 강함, 2개 충족하면 보통, 1개이사의 규칙을 충족하면 약함

    @Test
    @DisplayName("모든 규칙 만족")
    void meetAllRules() {
        PasswordCheck passwordCheck = new PasswordCheck();
        PasswordType result = passwordCheck.check("pass12!A");
        assertEquals(PasswordType.STRONG, result);

        PasswordType result2 = passwordCheck.check("abc432@Check");
        assertEquals(PasswordType.STRONG, result2);
    }

    @Test
    @DisplayName("길이가 8글자 미만이고 나머지 규칙을 만족하는 경우")
    void test1() {
        PasswordCheck passwordCheck = new PasswordCheck();
        PasswordType result = passwordCheck.check("ab1!D");
        assertEquals(PasswordType.NORMAL, result);
    }

    @Test
    @DisplayName("숫자를 포함하지않고 나머지 조건을 만족하는 경우")
    void test2() {
        PasswordCheck passwordCheck = new PasswordCheck();
        PasswordType result = passwordCheck.check("ab!@QWERTY");
        assertEquals(PasswordType.NORMAL, result);
    }


}
