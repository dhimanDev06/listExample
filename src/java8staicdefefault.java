import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface java8staicdefefault {

    void nornalShow();
    default void showAsDefault(){
        System.out.println("hi Default");
    }
    static String showAsStatic(String str){
        LocalDate lc = LocalDate.now();
        LocalDateTime ldt = LocalDateTime.now();
        LocalTime lt = LocalTime.now();
        return str + lc.plusDays(2)+" "+lt+" "+ldt.plusHours(5);
    }
}
