package encoder3;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import interceptor.Logged;

@Decorator
public class CoderDecorator implements Coder {

  @Inject
  @Delegate
  @Any
  Coder coder;
  
  @Logged
  @Override
  public String codeString(String s, int tval) {
      int len = s.length();

      return "\"" + s + "\" becomes " + "\"" + coder.codeString(s, tval) 
              + "\", " + len + " characters in length";
  }

}
