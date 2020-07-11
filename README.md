1.WHY I CHOSE MYSQL:
           DATABASE SCHEMA DESIGN IS SPECIFIED IN UML DIAGRAMS IN UML DIAGRAM FOLDER. 
           
	   
	   1.Since my project contains many relations and the performance metrics is upto 1000000 i choose to go with mysql.
           
           2.I got many relationships in my project.
                            1.USER table and course table is connected with registered  course table.
                            2.notification table is related with user table and course table  
           3.MySQL is customizable. The open-source GPL license allows programmers to modify the MySQL software to fit their own specific environments.
           
           4..MySQL works very quickly and works well even with large datasets.
           
           5.MySQL supports large databases, up to 50 million rows or more in a table. The default file size limit for a table is 4GB, but you can increase this (if your operating system can handle it) to a theoretical limit of 8 million terabytes (TB).




2.API LIST AND EXPLANATIONS OF BOTH FRONT END AND BACK END:
   
   
   
  		 FRONT END:
   				Front End contains the following pages:
              			Fetch Api calls are made in front end for communication of the pages with API endpoints 
               
	       
	       
	      			1.LoginPage:
                            			
						
						LoginPage consists of textboxes username and password .once clicked on login
                            			button it validates the form and sents username and password as JSON format to 
                            			loginapi and gets the response as true or false inorder to proceed to next page.
                           			 username is then stored in javascript cookie to use it in later pages.
               
	       
	       
	       
	       
	       
	       
	       			2.RegisterPage:
                            			
						
						Registerpage consists of form with 3 textboxes:
                                                                        1.username
                                                                        2.email
                                                                        3.password
                            			it then vaildate the form and sends the data as JSON object to registerapi and gets response as boolean to check whether the 							credentials are registered.
               
	       
	       
	       
	       			3.Homepage:
                          			
						
						Homepage consists courses to register and it is register course page.once clicked on register button.it proceeds to fetch api 							function and username,courseid,coursename is sent as JSON format to registercourseapi.
                        

               
	       
	       
	       
	       
	       
	       			4.Addcourses:
                          
			  
			  
			  
			  			Addcourses consists of two checkboxes
                                                                1.courseid
                                                                2.coursename
                            			it validates them and sent them to addcoursesapi and gets boolean response to check whether the course is added or not

               
	       
	       			5.MyCourses:
                            			
						
						Mycourses passes the username to the getcourseapi and gets response as 
                            			JSON object which consits of coursedetails of the user.
               
	       
	       
	      			 6.Notifications:
                            			
						
						
						Notifications has two arguments 
                                               			1.notification
                                               			2.status
                           			 when clicked on notification button.getnotificationapi for the loggeduser takesplace and JSON object of all the notifications comes as response.
                            			after the process updatestatus takesplace .sothat the notifications status are updated as read.





BACK END:
    Backend contains the following service




					1.Login service:
 					
					
							Endpointurl:/login
 							MethodType:POST
          						checkLogin()
								•	USERNAME
								•	PASSWORD
					Login service gets username and password from login page and passes it to checklogin method to check the credentials with database(mysql) and returns boolean to front end on basis of credentials given.








					2.Signup Service:
							
							
							EndpointUrl:/signup
							Methodtype:POST
							createNewUser()
								•	USERNAME
								•	PASSWORD
							Signup service gets two arguments username and password and passes it to createNewuser method to add it to USER table in database.




					3.AddcourseAPI:
							EndPointUrl:/addcourse
							Methodtype:POST
						       AddCourse()
							•	COURSEID
							•	COURSENAME
							addcourse api gets courseid and coursename and passes it to addcourse method to add it to the course table in database and all students gets a notification in notification table;




					4.RegistercourseAPI:
							   EndPointURL:/registercourse?username?courseid?coursename
								Methodtype:POST
							   Registercourse()
								•	USERNAME
								•	COURSEID
								•	COURSENAME
								Registercourseapi gets these three arguments and passess it to registercourse method to add it to the database and notification table gets an entry  of a notification that course is registered. 





						5.GetcoursesApi:
								   EndpointURL:/getcourses?username
							       Methodtype:POST
							       Getcourses()
								•	USERNAME
										RETURNS:
								•	COURSEID
								•	COURSENAME
								getcourseapi passess the username to getcourseapi and gets all courseid and coursename of the user.




						6.NotificationApi:
									EndpointUrl:/notifications?username
								   MethodType:POST
								   Notifycourses()
						•	USERNAME
						RETURNS:
						•	NOTIFICATIONS
						•	STATUS
						notificationapi passes the username and fetches all the notifications in the table of the specified user. 




						7.UpdateNotificationStatus:
								    ENDPOINTURL:/updatestatus
								     METHODTYPE:POST
						Updatestatus()
						•	notificationid
						this api updates status as read after the click on notification button.



6.TESTING :
           
	   1.Our project is designed based on multitier architecture with microservices on top of princples of restfulapis.
	    
            2.we did a Api testing for all the end points  using jmeter testing we spond 100000 test for apis 
            individually.
            
	    3.we could see get post patch calls work perfectly fine.
            
	    4.Mysql support million parallel threads
            
	    5.we dont see any issues with database.
            
	    6.from restful services we didnt use any static keywords.so multithreading works perfectly fine on these scenerio.
