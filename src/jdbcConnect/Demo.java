package jdbcConnect;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.ResourceBundle;
import org.testng.annotations.AfterTest;

public class Demo {
  @Test
	  
	  public void login() {
			final String username;
			final ResourceBundle userCredentialRepo = ResourceBundle
					.getBundle("resources.resource.UserCredentials");
			
			username = userCredentialRepo.getString("DREAMS_ADMIN");
			System.out.println("UserName : "+username);
	  
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterTest
  public void afterTest() {
  }

}
