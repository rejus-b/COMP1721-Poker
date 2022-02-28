import java.io.FileWriter;
import java.io.Writer;


public class Money {
  private int euros, cents;

  public Money(int e, int c) {
    euros = e;
    cents = c;
  }

  public int getEuros() {
    return euros;
  }

  public int getCents() {
    return cents;
  }

  public Money plus(Money other) {
    int sumEuros = euros + other.euros;
    int sumCents = cents + other.cents;
    return new Money(sumEuros + sumCents / 100, sumCents % 100);
  }

    public void writeTo(Writer destination){
        
    }

}
