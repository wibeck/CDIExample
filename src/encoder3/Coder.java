package encoder3;

import interceptor.Logged;

@Logged
public interface Coder {

  public String codeString(String s, int tval);
}