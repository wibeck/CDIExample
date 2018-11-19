package encoder;

import javax.enterprise.context.RequestScoped;
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
      @Inject
      Coder coder;
      
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
      
      
}
