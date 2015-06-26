package pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.WebElementFacade;

import net.thucydides.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

//@DefaultUrl("https://en.wiktionary.org/wiki/Wiktionary:Main_Page")
@DefaultUrl("http://www.yandex.ru/")

public class DictionaryPage extends PageObject {

   @FindBy(name="search")
    private WebElementFacade searchTerms;

    @FindBy(name="go")
    private WebElementFacade lookupButton;
    
    @FindBy(name = "login")
	private WebElementFacade inputLogin;

	@FindBy(name = "passwd")
	private WebElementFacade inputPassword;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElementFacade loginButton;
	
	@FindBy(xpath = "(//span[@class='js-messages-title-dropdown-name'])")
	private WebElementFacade loggedUser;
	
//	@FindBy(xpath= "(//img[contains(@class,'b-icon b-ico-arrow_up' and contains(@src,'//yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif'))])")
	@FindBy(xpath= "(//img[@class='b-icon b-ico-arrow_up'])")
	private WebElementFacade label1;
	
	//@FindBy(xpath = "(//html/body/div[10]/div[2]/div/div[1]/h2/a)")
	@FindBy(xpath= "//a[contains(@class,'b-link b-topbar__title') and contains(@href,'https://mail.yandex.by')]")
	private WebElementFacade emailLabel;
	
	@FindBy(xpath = "(//span[@class='b-toolbar__item__label js-toolbar-item-title-compose'])")
	private WebElementFacade buttonNewEmail;
	
	@FindBy(xpath = "(//span[contains(@class,'b-pseudo-link daria-action') and contains(@data-action,'mail-common.abook-popup')])")
	private WebElementFacade sendTo;
	
	@FindBy(xpath = "(//span[@class='abook-entry-name-content'])")
	private WebElementFacade chooseEmail;
	
	@FindBy(xpath = "(//button[@class='nb-button _nb-action-button _init js-abook-popup-ok ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'])")
	private WebElementFacade submitEmail;
	
	@FindBy(id = "compose-subj")
	private WebElementFacade sendSubject;
	
	@FindBy(id = "compose-send")
	private WebElementFacade sendBody;
	
	@FindBy(linkText = "Черновики")
	private WebElementFacade folderDraft;
		
	@FindBy(xpath = "(//button[contains(@class,' nb-button _nb-small-button _init daria-action  b-popup__focus-me') and contains(@data-action,'dialog.save')])")
	private WebElementFacade saveDraftEmail;
	
	@FindBy(xpath = "(//span[@class='b-messages__subject'])")
	private WebElementFacade titleEmail;
	
	@FindBy(xpath = "(//span[@class='header-user-pic b-mail-dropdown__handle'])")
	private WebElementFacade buttonExit;
	
	@FindBy(xpath = "(//a[contains(@class,'b-mail-dropdown__item__content ') and contains(@data-metric,'Меню сервисов:Выход')])")
	private WebElementFacade buttonExitExit;
	
	@FindBy(xpath = "(//div[@class='b-popup__close daria-action'])")
	private WebElementFacade popupWindow;
	
	@FindBy(xpath = "(//html[@id='js']/body/div[5]/div[2]/table/tbody/tr/td/div[3]/div/a)")
	private WebElementFacade submitExit;
	
	public void enter_lg(String login) {
		 inputLogin.type(login);
	}
	 
	public void enter_psw(String psw) {
		 inputPassword.type(psw);
	}
	 
	public void click_button() {
	    loginButton.click();
	}

	public String getLoggedUserName(){
		return loggedUser.getText();
	}
	
	public void enterToEmailBox(){
		label1.click();
		emailLabel.click();
	}
	
	public void writeNewEmail(){
		buttonNewEmail.click();
	}
	
	public void writeTo (){
		sendTo.click();
		chooseEmail.click();
		submitEmail.click();
	}
	
	public void writeSubject(String subject){
		sendSubject.type(subject);
	}
	
	public void writeBody(String body){
		sendBody.type(body);
	}
	
	public void saveEmailToDraft(){
		if (saveDraftEmail.getText().equals("Сохранить и перейти")){
			saveDraftEmail.click();
		}
	}
	
	public void openDraftFolder(){
		folderDraft.click();
	}
	
	public String getTitleOfEmail(){
		return titleEmail.getText();
	}
	
	 public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }
	 
	 public void quitFromMailBox(){
		buttonExit.click();
		buttonExitExit.click();
		if (popupWindow.getAttribute("title").equals("Закрыть")){
			submitExit.click();
				
		}
	}
	 
	 
   /* public void lookup_terms() {
        lookupButton.click();
    }
    
    
    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }*/

}
