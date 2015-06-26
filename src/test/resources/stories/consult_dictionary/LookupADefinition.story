					
Scenario: Login to email
Given the user is on the Main Yandex page
When the user enter login 'ludik.ludik2015'
When the user enter password 'Qwerty111'
When the user click logonButton
Then the user loggin to mail box see the loggedusername 'ludik.ludik2015@yandex.ru'


Scenario: Write new email and save it in draft folder
Given the user is on Home Yandex page
When the user writes emailSubject 'test module 5'
When the user save draft email with 'Hello!\n\nThis is test of Module 5.\n\nBye'
Then user see email in draft folder with subject and quit 'test module 5'