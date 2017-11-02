//package zj;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import com.example.Person;
//import com.example.mockito.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class MyMockitoTest {
//
//    @BeforeEach
//    void init(@Mock Person person) {
//        when(person.getName()).thenReturn("Dilbert");
//    }
//
//    @Test
//    void simpleTestWithInjectedMock(@Mock Person person) {
//        assertEquals("Dilbert", person.getName());
//    }
//
//}