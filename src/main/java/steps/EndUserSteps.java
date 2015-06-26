package steps;

import static org.fest.assertions.Assertions.assertThat;
import pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class EndUserSteps extends ScenarioSteps{

	DictionaryPage dictionaryPage;

	@Step
	public void enter_login(String keyword)
	{
		dictionaryPage.enter_lg(keyword);
	}
	
	@Step
	public void enter_password(String keyword)
	{
		dictionaryPage.enter_psw(keyword);
	}
	
	@Step
	public void click_buttonLogin()
	{
		dictionaryPage.click_button();
	}
	
	@Step
	public void should_see_loggedUser (String loggedUsedName)
	{
		boolean isFound = false;
		if (dictionaryPage.getLoggedUserName().equals(loggedUsedName)){
			isFound = true;
		}
		assertThat(isFound);
	}
	
	@Step
	public void is_the_home_page()
	{
		dictionaryPage.open();
	}
	
	
	@Step
	public void writeEmail(String subject){
		dictionaryPage.enterToEmailBox();
		dictionaryPage.writeNewEmail();
		dictionaryPage.writeTo();
		dictionaryPage.writeSubject(subject);
	}
	
	@Step
	public void saveDraftEmail(String body){
		dictionaryPage.writeBody(body);
		dictionaryPage.openDraftFolder();
		dictionaryPage.saveEmailToDraft();
	}
	
	@Step
	public void should_see_subject_and_exit(String subject){
		dictionaryPage.openDraftFolder();
		boolean isFound = false;
		if (dictionaryPage.getTitleOfEmail().equals(subject)){
			isFound = true;
		}
		assertThat(isFound);
		dictionaryPage.quitFromMailBox();
	}
	
	

	/*@Step
	public void should_see_definition(String definition)
	{
		boolean isFound = false;
		for (String onscreenDefinition : dictionaryPage.getDefinitions())
		{
			isFound = definition.contains(onscreenDefinition);
		}
		assertThat(isFound);
	}
	
	@Step
	public void enters(String keyword)
	{
		dictionaryPage.enter_keywords(keyword);
	}
	
	@Step
	public void looks_for(String term)
	{
		enters(term);
		starts_search();
	}
	
	@Step
	public void starts_search()
	{
		dictionaryPage.lookup_terms();
	}*/

}
