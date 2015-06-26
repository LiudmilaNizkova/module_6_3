package jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import steps.EndUserSteps;

public class DefinitionSteps {
	 @Steps
	    EndUserSteps endUser;

	   @Given("the user is on Home Yandex page")
	    public void givenTheUserIsOnTheHomeYandexPage() {
	        endUser.is_the_home_page();
	    }
	 
		@When("the user writes emailSubject '$subject'")
	    public void whenTheUserWriteEmailSubject(String subject) {
	        endUser.writeEmail(subject);
	    }
	    
		@When("the user save draft email with '$body'")
	    public void whenTheUserSaveDraftEmailWithBody(String body) {
	        endUser.saveDraftEmail(body);
	    }
	 
	   @Then("user see email in draft folder with subject and quit '$subject'")
	    public void thenUserSeeEmailInDraftFolder(String subject) {
	        endUser.should_see_subject_and_exit(subject);
	    }
	    
	    @Given("the user is on the Main Yandex page")
	    public void givenTheUserIsOnTheMainYandexPage() {
	        endUser.is_the_home_page();
	    }
	    

	    @When("the user enter login '$login'")
	    public void whenTheUserEnterLogin(String login) {
	        endUser.enter_login(login);
	    }
	    
	    @When("the user enter password '$password'")
	    public void whenTheUserEnterPassword(String password) {
	        endUser.enter_password(password);
	    }
	    
	    @When("the user click logonButton")
	    public void whenTheUserClickButton() {
	        endUser.click_buttonLogin();
	    }

	    
	    @When("the user write emailBody")
	    public void whenTheUserWriteEmailBody(String body) {
	        endUser.enter_login(body);
	    }
	     
	    @Then("the user loggin to mail box see the loggedusername '$loggedUserName'")
	    public void thenUserSeeLoggedUserName(String loggedUserName) {
	        endUser.should_see_loggedUser(loggedUserName);
	    }

}
