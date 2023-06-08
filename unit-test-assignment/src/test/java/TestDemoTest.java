import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

class TestDemoTest {
  private TestDemo testDemo;

  @BeforeEach
  void setUp() throws Exception {
    testDemo = new TestDemo();
  }

  @ParameterizedTest
  @MethodSource("argumentsForAddPositive")
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected,
      Boolean expectException) {
    if (!expectException) {
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
    } else {
      assertThatThrownBy(() -> testDemo.addPositive(a, b))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("Both parameters must be positive!");
    }

  } 
  @ParameterizedTest
  @MethodSource("TestDemoTest#argumentsForAddPositive")
  
  static Stream<Arguments> argumentsForAddPositive () {
   return Stream.of(
    arguments (2, 4, 6, false),
    arguments (1, 2, 3, false),
    arguments (0, 2, 0, true),
    arguments (-1, 4, 0, true),
    arguments (2, 8, 10, false)
    );
  }
  
 @Test 
 void assertThatNumberSquaredIsCorrect() {  
   TestDemo mockDemo = spy(testDemo); 
   doReturn(5).when(mockDemo).getRandomInt(); 
   
   int fiveSqaured = mockDemo.randomNumberSquared();
   assertThat(fiveSqaured).isEqualTo(25); 
   
   
 } // Number Squared Correct Test Method 
 


  
  
  

} // class 
