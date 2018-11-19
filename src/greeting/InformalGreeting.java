package greeting;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

import interceptor.Logged;


@Informal
@RequestScoped
public class InformalGreeting extends Greeting {
  private String msg;
    private static final Logger logger =
      Logger.getLogger(InformalGreeting.class.getCanonicalName());
  public InformalGreeting() {}
 
  public String greet(String name) {
    return "Hi, " + name + "!" + msg;
  }
  
  @PostConstruct
  public void setMsg() {
    msg = "I'm constructed, Bitch!";
  }
  @Logged
  @PreDestroy
  public void setDesMsg() {
    msg += "I'm about to be destroyed";
    logger.log(Level.INFO, msg);
  }
}
