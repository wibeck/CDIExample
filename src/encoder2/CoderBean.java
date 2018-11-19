package encoder2;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.sun.istack.internal.NotNull;

@RequestScoped
public class CoderBean {

      private String inputString;
      private String codedString;
      @Max(26)
      @Min(0)
      @NotNull
      private int transVal;
      
      private final static int TEST = 1;
      private final static int SHIFT = 2;
      private int coderType = SHIFT;
      
      @Inject
      @Chosen
      @RequestScoped
      private Coder coder;
      
      public void encodeString() {
        setCodedString(coder.codeString(inputString, transVal));
      }
      
      public void reset() {
        setInputString("");
        setTransVal(0);
    }

      public String getInputString() {
        return inputString;
      }

      public void setInputString(String inputString) {
        this.inputString = inputString;
      }

      public String getCodedString() {
        return codedString;
      }

      public void setCodedString(String codedString) {
        this.codedString = codedString;
      }

      public int getTransVal() {
        return transVal;
      }

      public void setTransVal(int transVal) {
        this.transVal = transVal;
      }

      @Produces
      @Chosen
      @RequestScoped
      public Coder getCoder() {

          switch (coderType) {
              case TEST:
                  return new TestCoderImpl();
              case SHIFT:
                  return new CoderImpl();
              default:
                  return null;
          }
      }

      public void setCoder(Coder coder) {
        this.coder = coder;
      }

      public int getCoderType() {
        return coderType;
      }

      public void setCoderType(int coderType) {
        this.coderType = coderType;
      }

      public static int getTest() {
        return TEST;
      }

      public static int getShift() {
        return SHIFT;
      }
      
      
      
}
