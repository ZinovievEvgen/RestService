package helback.service_impl;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Service
public class DataFormatterService {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss");

    public void dataFormatter() {
        //daily
        LocalDate yesterdayZ = LocalDate.now().minusDays(1);
        String yesterdayStart = String.format(yesterdayZ.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " - 03:00:00", formatter);
        String yesterdayFinish = String.format(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " - 02:59:59", formatter);

        //year
        Calendar calendar = Calendar.getInstance();
        int lastYear = calendar.get(Calendar.YEAR) - 1;
        int year = calendar.get(Calendar.YEAR);

        String startY = String.format("20.01." + lastYear + " - 00:00:00", formatter);
        String finishY = String.format("19.01." + year + " - 23:59:59", formatter);
        System.out.println("startY" + startY);
        System.out.println("finishY" + finishY);
    }

    /*  если дату в строку переделать без Т
        public String replaceChar(String date, DateTimeFormatter form) {
        String replaceDate;
        LocalDateTime dateTime = LocalDateTime.parse(date, form);
        return replaceDate = date.toString().replace("T", " ");
    }*/
}
