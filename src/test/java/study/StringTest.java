package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String input = "1,2";
        String[] tokens = input.split(",");
        assertThat(tokens).containsExactly("1", "2");

        input = "1";
        tokens = input.split(",");
        assertThat(tokens).contains("1");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String subString = input.substring(1, input.length() - 1);
        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> { input.charAt(-1); })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("-1");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> { input.charAt(3); })
                .withMessageContaining("3");
    }
}