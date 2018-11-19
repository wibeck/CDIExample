package encoder3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

@RequestScoped
public class CoderImpl implements Coder {

  private List<Character> lettersList = Arrays.asList( 'a', 'b', 'c', 'd', 'e', 'f', 
      'g', 'h', 'i','j', 'k', 'l', 'm', 'n', 'o', 
      'p', 'q', 'r', 's', 't', 'u',
      'v', 'w', 'x', 'y', 'z');
  
  @Override
  public String codeString(String s, int tval) {
    String helper = s.toLowerCase();
    char[] origChars = s.toCharArray(); //used to determine case
    char[] chars = helper.toCharArray();
    
    // loop adjusts alphabetic indices by tval and replaces letters
    for(int arrayPos = 0; arrayPos < chars.length; arrayPos++) {
      
      if(lettersList.contains(chars[arrayPos])) {
        int index = lettersList.indexOf(chars[arrayPos]);
        
        boolean isUpperCase = Character.isUpperCase(origChars[arrayPos]);
        
        //adjust alphabetic indices
        if((index + tval) > (lettersList.size()-1) ) {
          index = (index + tval) - lettersList.size();
        } else {
          if((index + tval) < 0) {
            index = (index + tval) + lettersList.size();
          } else {
            index += tval;
          }
        }
        
        //re-adjust to original Case
        if(isUpperCase) {
          chars[arrayPos] = Character.toUpperCase(lettersList.get(index));
        } else {
          chars[arrayPos] = lettersList.get(index);
        } 
      } else {
        continue;
      }
      
    }
    
    return new String(chars);
  }

}
