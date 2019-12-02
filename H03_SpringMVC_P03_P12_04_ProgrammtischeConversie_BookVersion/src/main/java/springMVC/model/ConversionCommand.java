package springMVC.model;

import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;


@Component("conversionCommand")
public class ConversionCommand implements Serializable {

    private double number;



    @NumberFormat(style = NumberFormat.Style.NUMBER)
    public double getNumber() {
        return number;
    }


    public void setNumber(double number) {
        this.number = number;
    }
}
