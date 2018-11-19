package greeting;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Default
@RequestScoped
public class Greeting {
  
  public Greeting() {}
  public String greet(String name) {
      return "Hello, " + name + ".";
  }
}
