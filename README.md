## <img src="https://img.shields.io/badge/Topic-Full%20Stack%20Java%20development-blueviolet" height=30/>
<br> <img src="https://img.shields.io/badge/-Java-red" height=30/> 
<img src="https://img.shields.io/badge/-JSP-blue" height=30/> 
<img src="https://img.shields.io/badge/-Servlets-important" height=30/> 
<img src="https://img.shields.io/badge/-JDBC-yellow" height=30/> 
<img src="https://img.shields.io/badge/-Hibernate-lightgrey" height=30/>
<img src="https://img.shields.io/badge/-Oracle%20Database-%23ff0000" height=30/> 
<img src="https://img.shields.io/badge/-Spring-brightgreen" height=30/> 
<img src="https://img.shields.io/badge/-Spring%20Boot-%2300b33c" height=30/> 
<img src="https://img.shields.io/badge/-Maven-%233385ff" height=30/> 
<img src="https://img.shields.io/badge/-JavaScript-yellowgreen" height=30/> 
<img src="https://img.shields.io/badge/-CSS-9cf" height=30/> 
<img src="https://img.shields.io/badge/-Spring%20Tool%20Suite%204%20(STS4)-brightgreen" height=30/>
<img src="https://img.shields.io/badge/-Restful--webservices-%23ffff00" height=30/> 

<h2><strong>Note:-</strong></h2>
The folders are named as <i>conceptName_NserialNo</i>, for example Dependency_Injection_N13, Spring_Bean_N21, etc. It is recommended to follow the order while learning. This tutorial will be extremely beneficial for those who want to learn advanced back-end and front-end in Java.

<h2><strong>About:-</strong></h2>
<ul>
  <li><h3>Spring5_Dependency_Injection_N38</h3> - This is an app to understand bean creation by Spring in runtime using @Component annotation. Here, Spring will create the object in runtime and inject it. @ComponentScan is used along with @Configuration to specify the packages that are to be scanned by spring. The configuration will be applicable only for those packages.</li>
  <li><h3>Spring5_Autowire_N39</h3> - This is an app to understand dependency injection using @Autowired annotation. Here, Spring will try to create object for classes with @Component annotation. During creation of object if some properties needed to be injected with their object (i.e., if there are some dependencies) then spring will take care of that in runtime. @ComponentScan is used along with @Configuration to specify the packages that are to be scanned by spring. The configuration will be applicable only for those packages.</li>
  <li><h3>Spring5_Aitowire_Qualifier_N40</h3> - This is an app to understand the use of @Qualifier annotation. Here, Spring will try to create object for the class with @Component annotation during object creation if there is any dependency which is ambiguous then that ambiguity can be resolved using @Qualifier annotation. @ComponentScan is used along with @Configuration to specify the packages that are to be scanned by spring. The configuration will be applicable only for those packages.</li>
  <li><h3>Spring5_Spring_Bean_and_Constructor_Injection_N41</h3> - This is an app to understand bean declaration using @Bean annotation and also the example of constructor-injection is covered. @ComponentScan is used along with @Configuration to specify the packages that are to be scanned by spring. The configuration will be applicable only for those packages.</li>
  <li><h3>Spring5_Spring_MVC_minimal_setup_N42</h3> - This is an app with minimal setup and dependencies in pom.xml to start Spring MVC. Here, @RequestMapping annotation is used inside controller class (with @Controller annotation) to map the request url. SpringSample-servlet.xml file in WEB-INF folder has the Bean configuration to tell Spring about the location of view (.jsp) files.</li>
  <li><h3>Spring5_Spring_MVC_basic_form_N43</h3> - This is an app with basic form. Form is submitted to an url which is mapped with an API in controller class. In that API all the field value are extracted using HttpServletRequest object and then these values are passed to JSP view using the same HttpServletRequest object (eg., request.setAttribute("gender", gender)). In JSP file values are displayed using JSP Scripting Elements (eg., <%= request.getAttribute("gender") %>). SpringSample-servlet.xml file in WEB-INF folder has the Bean configuration to tell Spring about the location of view (.jsp) files.</li>
  <li><h3>Spring5_SpringMVC_form_requestParam_model_N44</h3> - In this app, when form is being submitted to an url which is mapped to displayInfo API in controller, the field values are extracted using @RequestParam in the API and then these values are passed to the JSP view using Model object (eg., model.addAttribute("languages", languages)). In JSP page, field values are displayed using expression language and JSTL tags. SpringSample-servlet.xml file in WEB-INF folder has the Bean configuration to tell Spring about the location of view (.jsp) files.</li>
  <li><h3>Spring5_SpringMVC_form_modelAndView_N45</h3> - In this app, when form is being submitted to an url which is mapped to displayInfo API in controller, the field values are extracted using @RequestParam in the API and then these values are passed to the JSP view using ModelAndView object (eg., modelAndView.addObject("languages", languages)). In JSP pages, field values are displayed using expression language and JSTL tags. SpringSample-servlet.xml file in WEB-INF folder has the Bean configuration to tell Spring about the location of view (.jsp) files.</li>
  <li><h3>Spring5_SpringMVC_form_using_css_js_validation_N46</h3> - In this app, when form is being submitted, there will be client-side validations. If validation passes then the form will be submitted to an url which is mapped to displayInfo API in controller. The field values are extracted using @RequestParam in the API. Then there will be a validation in the server-side (even when javaScript is disabled for the browser, server-side validation will work). If there is no server-side validation then these values are passed to the 'displayInformation' JSP view using ModelAndView object (eg., modelAndView.addObject("languages", languages)). In JSP pages, field values are displayed using expression language and JSTL tags. SpringSample-servlet.xml file in WEB-INF folder has the Bean configuration to tell Spring about the location of view (.jsp) files.</li>
  <li><h3>Spring5_SpringMVC_form_customized_error_message_N47</h3> - In this app, when form is being submitted, there will be client-side validations. If validation passes then the form will be submitted to an url which is mapped to displayInfo API in controller. The field values are extracted using @RequestParam in the API. Then there will be a validation in the server-side (even when javaScript is disabled for the browser, server-side validation will work). If there is no server-side validation then these values are passed to the 'displayInformation' JSP view using ModelAndView object (eg., modelAndView.addObject("languages", languages)). In JSP pages, field values are displayed using expression language and JSTL tags and are beautified with CSS. SpringSample-servlet.xml file in WEB-INF folder has the Bean configuration to tell Spring about the location of view (.jsp) files.</li>
  <li><h3>Spring5_SpringMVC_form_element_N48</h3> - In this app, customer-form is made using JSTL form elements. When customer-form is being submitted, there will be client-side validations. If validation passes then the form will be submitted to an url which is mapped to displayInformation API in controller. The field values are extracted from Customer entity using @ModelAttribute in the API. Then there will be a validation in the server-side (even when javaScript is disabled for the browser, server-side validation will work). If there is no server-side validation then the entity is passed to the 'displayInformation' JSP view using ModelAndView object (eg., modelAndView.addObject("customer", customer)). In JSP pages, field values are displayed using expression language and JSTL tags and are beautified with CSS. SpringSample-servlet.xml file in WEB-INF folder has the Bean configuration to tell Spring about the location of view (.jsp) files.</li>
  <li><h3>Spring5_SpringMVC_form_elements_N49</h3> - In this app, customer-form is made using JSTL form elements and radio, dropdown and checkboxes are populated dynamically using Map. When customer-form is being submitted, there will be client-side validations. If validation passes then the form will be submitted to an url which is mapped to displayInformation API in controller. The field values are extracted from Customer entity using @ModelAttribute in the API. Then there will be a validation in the server-side (even when javaScript is disabled for the browser, server-side validation will work). If there is no server-side validations then the entity is passed to the 'displayInformation' JSP view using ModelAndView object (eg., modelAndView.addObject("customer", customer)). In JSP pages, field values are displayed using expression language and JSTL tags and are beautified with CSS. SpringSample-servlet.xml file in WEB-INF folder has the Bean configuration to tell Spring about the location of view (.jsp) files.</li>
  <li><h3>Spring5_SpringMVC_form_repopulation_validation_N50</h3> - In this app, customer-form is made using JSTL form elements and radio, dropdown and checkboxes are populated dynamically using Map. When customer-form is being submitted, there will be client-side validations. If validation passes then the form will be submitted to an url which is mapped to displayInformation API in controller. The field values are extracted from Customer entity using @ModelAttribute in the API. Then there will be a validation in the server-side. To display these server-side validation error messages in the customer-form, the form is repopulated with submitted values and error messages are shown using object of BindingResult (even when javaScript is disabled for the browser, server-side validation will work). If there is no server-side validation then the entity is passed to the 'displayInformation' JSP view using ModelAndView object (eg., modelAndView.addObject("customer", customer)). In JSP pages, field values are displayed using expression language and JSTL tags and are beautified with CSS. SpringSample-servlet.xml file in WEB-INF folder has the Bean configuration to tell Spring about the location of view (.jsp) files.</li>
  <li><h3>Spring5_SpringMVC_form_hibernate_validator_N51</h3> - In this app, customer-form is made using JSTL form elements and radio, dropdown and checkboxes are populated dynamically using Map. When customer-form is being submitted, there will be client-side validations. If validation passes then the form will be submitted to an url which is mapped to displayInformation API in controller. The field values are extracted from Customer entity using @ModelAttribute in the API. Then there will be a validation in the server-side. Server-side validation is achieved using custom validate method as well as by using annotations on property of Customer entity (Hibernate-Validator). To make hibernate-validator work we need to use @Valid annotation. To display these server-side validation error messages in the customer-form, the form is repopulated with submitted values and error messages are shown using object of BindingResult (even when javaScript is disabled for the browser, server-side validation will work). If there is no server-side validation then the entity is passed to the 'displayInformation' JSP view using ModelAndView object (eg., modelAndView.addObject("customer", customer)). In JSP pages, field values are displayed using expression language and JSTL tags and are beautified with CSS. SpringSample-servlet.xml file in WEB-INF folder has the Bean configuration to tell Spring about the location of view (.jsp) and template files.</li>
  <li><h3>Spring5_SpringMVC_DB_connectivity_usingXMLconfig_N52</h3> - In this app, there is customer-form. One can create a customer by submitting the form. Both cliet-side and server-side validations are added in the app. If javaScript for the browser is disabled then, also server-side validation will work. Both server and client side validation messages are shown on Customer-Form UI. To connect with database xml based configuration is used. User can update and delete from UI. </li>
  <li><h3>Spring5_SpringMVC_DB_connectivity_Annotation_CRUD_N53</h3> - In this app, there is customer-form. One can create a customer by submitting the form. Both cliet-side and server-side validations are added in the app. If javaScript for the browser is disabled then, also server-side validation will work. Both server and client side validation messages are shown on Customer-Form UI. To connect with database Annotation based configuration is used. User can update and delete from UI. 
<p align="center">
  <img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/image2.png">
	<br><strong>Client Side validation</strong>
</p>
<p align="center">
  <img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/image4.png">
  	<br><strong>Server Side validation when JavaScript is off for the browser</strong>
</p>
<p align="center">
  <img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/image1.png">
	<br><strong>List of registered users</strong>
</p>
</li>
  <li><h3>RestApp_using_JERSEY_N54</h3> - This is a very simple rest-app to show the use of diffrent JERSEY based annotations like @GET, @POST, @PUT, @DELETE, @Path, @PathParam and @Produces. JERSEY is an implementation of JAX-RS 2.0 by Oracle. JAX-RS stands for JAVA API for RESTFUL Web Services. It provides us a java based API which supports in creation of REST(Representational State Transfer) APIs. A collection REST APIs is called RESTful Webservices.</li>
  <li><h3>RestApp_JERSEY_CRUD_simulation_N55</h3> - This a rest-app to simulate CRUD operations using List instead of actual database.</li>
  <li><h3>RestApp_JERSEY_CRUD_db_connectivity_using_hibernate_N56</h3> - This is a rest-app in which supports CRUD operation on Brand table in database. There is a POJO class Brand which represents database table with name Brand. Hiibernate is connected to the database using hibernate.cfg.xml file. Since, Brand is the entity class, so, different annotations(like @Entity, @Table, @Id, @Column, etc) are used to tell hibernate about the specifications of the entity. @GeneratedValue and @SequenceGenerator is used to auto-increment Brand_Id (pk) using the BRAND_SEQUENCE which is a sequence in the oracle database to generate Brand_Id by incrementing one. The the REST APIs in this app will produce and consume XML data.</li>
  <li><h3>RestApp_JERSEY_CRUD_with_JSON_N57</h3> - This is a rest-app in which supports CRUD operation on Brand table in database. There is a POJO class Brand which represents database table with name Brand. Hiibernate is connected to the database using hibernate.cfg.xml file. Since, Brand is the entity class, so, different annotations(like @Entity, @Table, @Id, @Column, etc) are used to tell hibernate about the specifications of the entity. @GeneratedValue and @SequenceGenerator is used to auto-increment Brand_Id (pk) using the BRAND_SEQUENCE which is a sequence in the oracle database to generate Brand_Id by incrementing one. The the REST APIs in this app will produce and consume JSON data.</li>
  <li><h3>RestApp_JERSEY_adding_subResource_N58</h3> - This is a rest-app in which there are two POJO classes Brand and Product. APIs are called based on endpoints and type of request. The type of data consumed during POST and PUT request is JSON and PLAIN_TEXT is returned in response. The type of data produced during GET request is JSON and during DELETE is PLAIN_TEXT.
<p align="center">
  <img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/image5.png">
	<br><strong>Brand Table</strong>
</p>
<p align="center">
  <img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/image6.png">
	<br><strong>Product Table</strong>
</p>
</li>
  <li><h3>RestApp_JERSEY_add_subResource_many_to_one_N59</h3> - In this rest-app, the JSON response that is received for Product contains Brand information. This is achieved by using referential integrity i.e., @ManyToOne and @JoinColumn annotations in the Product POJO class.</li>
  <li><h3>RestApp_JERSEY_seperate_resource_for_subResource_N60</h3> - In this rest-app, there is a seperate resource for both Brand and Product. All APIs for product information will be inside Product resource and the same is applicable for Brand. This approach better and easy to maintain and scale.</li>
  <li><h3>RestApp_JERSEY_delegation_of_url_to_subResource_N61</h3> - In this rest-app, there is a seperate resource for both Brand and Product. All APIs for product information will be inside Product resource but the call to those APIs is delegated from APIs present in brand resource. This approach not recommended as it is difficult to maintain and scale.</li>
  <li><h3>RestApp_JERSEY_filter_using_QueryParam_N62</h3> - In this rest-app, @QueryParam is used to read query parameters.</li>
  <li><h3>RestApp_JERSEY_pagination_using_QueryParam_N63</h3> - In this rest-app, getProductsByBrand API in ProductResource has to return based on category and size whose values are read using @QueryParam.</li>
  <li><h3>RestApp_JERSEY_HeaderParam_CookieParam_N64</h3> - In this rest-app header and cookie values are read by using @HeaderParam and @CookieParam.</li>
  <li><h3>RestApp_JERSEY_ContextParam_N65</h3> - In this rest-app, @Context annotation is used. The JAX-RS API from the Java EE ecosystem of technologies provides the annotation @Context, to inject 12 object instances related to the context of HTTP requests. It behaves just like the @Autowired annotation in Java EE and Spring respectively.
	<ul>
		<li>SecurityContext – Security context instance for the current HTTP request
		<li>Request – Used for setting precondition request processing
		<li>Application, Configuration, and Providers -> Provide access to the JAX-RS application, configuration, and providers instances
		<li>ResourceContext – Resource context class instances
		<li>ServletConfig – The ServletConfig instance instance
		<li>ServletContext – The ServletContext instance
		<li>HttpServletRequest – The HttpServletRequest instance for the current request
		<li>HttpServletResponse – The HttpServletResponse instance for the current request
		<li>HttpHeaders – Maintains the HTTP header keys and values
		<li>UriInfo – Query parameters and path variables from the URI called
	</ul>
  </li>
  <li><h3>RestApp_JERSEY_send_status_code_N66</h3> - In this rest-app, Response object is usted to return payload along with status code.</li>
  <li><h3>RestApp_JERSEY_location_headers_N67</h3> - In this rest-app, Response object is used to return payload, status code and absolute location of created Brand.</li>
  <li><h3>RestApp_JERSEY_rectified_location_header_N68</h3> - In this rest-app, Response object is used to return payload, status code and exact location of created Brand.</li>
  <li><h3>RestApp_JERSEY_URI_builder_N69</h3> - In this rest-app, Response object is used to return payload, status code and exact location of created Brand. Here, the location is build using UriBuilder.</li>
  <li><h3>RestApp_JERSEY_WebApplicationException_N70</h3> - In this rest-app, the use of WebApplicationException is shown. If there is no header with the name 'headerAttribute' then a WebApplicationException is thrown.</li>
  <li><h3>RestApp_JERSEY_exception_handling_with_JSON_response_N71</h3> - In this rest-app, error is handled manually if operation is unsuccessful.</li>
  <li><h3>RestApp_JERSEY_exception_mapper_N72</h3> - In this rest-app, error is handled in a genric way using ExceptionMapper interface.</li>
  <li><h3>RestApp_JERSEY_custom_exception_mapper_N73</h3> - In this rest-app, custom error handling is done using ExceptionMapper interface.</li>
  <li><h3>RestApp_JERSEY_HATEOAS_part_1_N74, RestApp_JERSEY_HATEOAS_part_2_N75, RestApp_JERSEY_HATEOAS_part_3_N76, RestApp_JERSEY_HATEOAS_part_4_N77 </h3> - These are the rest-apps in which JSON response has list of links. These links are used to navigate across the app easily. Brand POJO class has one property 'listOfLinks' which is not a column in database fron Brand table. Such properties are annotated with @Transient annotation.</li>
  <li><h3>RestApp_JERSEY_MessageBodyWriter_N78</h3> - In this app MessageBodyWriter is used to convert the type from Name to String.</li>
  <li><h3>RestApp_JERSEY_singleton_resource_N79</h3> This is a rest-app which shows the use of @Singleton. The class with @Singleton annotation instantiates only once. Everytime the browser is refreshed with url "http://localhost:8080/RestApp_JERSEY_singleton_resource_N79/testSingleton/test", the value of x increases by one.</li>
  <li><h3>RestApp_JERSEY_param_at_class_level_N80</h3> - This is a rest-app in which @PathParam and @QueryParam annotation is used on instance variables at class level.</li>
  <li><h3>RestApp_JERSEY_param_converter_N81, RestApp_JERSEY_param_converter_using_inner_class_N82</h3> - These rest-apps shows the use of ParamConverter and ParamConverterProider interface to convert parameters</li>
  <li><h3>RestApp_JERSEY_Building_Client_part_1_N83</h3> - This is a rest-app to build custom REST client.</li>
  <li><h3>RestApp_JERSEY_Building_Client_part_2_N84</h3> - In this rest-app, a custom client is build and @PathParam annotation is used to read brandId and return JSON response as string.</li>
  <li><h3>RestApp_JERSEY_Building_Client_post_part_3_N85</h3> - In this rest-app, a custom client is build and a post request is fired from the client. And the payload Brand has only one property 'brandName'. Here, brandId is not required as it is fetched from BRAND_SEQUENCE and is auto incremented.</li>
  <li><h3>RestApp_JERSEY_Building_Client_post_part_4_N86</h3> - In this rest-app, a custom client is build and a post request is fired from the client. And the payload Brand has only two properties 'brandName' and 'brandId'. However, brandId is not required as it is fetched from BRAND_SEQUENCE and is auto incremented. So, adding brandId is optional but good to have.</li>
  <li><h3>RestApp_JERSEY_Building_Client_part_5_N87</h3> - In this rest-app, a custom REST client is build and array of all the brands as response is returned.</li>
  <li><h3>RestApp_JERSEY_Building_Client_HATEOS_part_5_N88</h3> - In this rest-app , a custom REST client is build and Brand with a particular brandId is returned as response. Here, the Brand objects contains all the information of the brand along with 'self' and 'productsLink' for easy navigation.</li>
  <li><h3>RestApp_JERSEY_Building_Client_PUT_part_5_N89</h3> - In this rest-app, a custom REST client is build and PUT request is fired.</li>
  <li><h3>RestApp_JERSEY_Building_Client_DELETE_part_5_N90</h3> - In this rest-app, a custom REST client is build and DELETE request is fired.</li>
  <li><h3>SpringBoot_minimal_setup_91</h3> - This a spring-boot app with minimal setup.</li>
  <li><h3>SpringBoot_basic_webApp_92</h3> - This is simple webapplication using spring-boot.</li>
  <li><h3>SpringBoot_webApp_adding_support_for_JSP_93</h3> - By defult spring-boot doesn't support JSP files. We need to add properties in application.properties to get the support JSP files in spring-boot application.</li>
  <li><h3>SpringBoot_REST_CRUD_hibernate_custom_sessionfactory_94</h3> - This is a rest-app made using spring-boot. Hibernate is used as ORM and sessionFactory is customly configured to connect with oracle database. Database connections are externalized in properties file. The concept of HATEOAS is properly implemented for easy navigation across the app.</li>
  <li><h3>SpringBoot_REST_CRUD_logback_for_logging_95</h3> - This is a rest-app made using spring-boot. Hibernate is used as ORM and sessionFactory is customly configured to connect with oracle database. Database connections are externalized in properties file. The concept of HATEOAS is properly implemented for easy navigation across the app. The logback is used as logging framework to log warnings, errors and important informations. Logback is intended as a successor to the popular log4j project, picking up where log4j 1.x leaves off.</li>
  <li><h3>SpringBoot_REST_app_checkStatus_96</h3> - This a Rest app that return different responses based on different the values of Query-parameter. If Query-parameter is null or any value other than {big, small} then a BAD_REQUEST is sent as a response.</li>
  <li><h3>Spring5_SpringMVC_no_XML_Only_Java_N97</h3> - This is the spring mvc web application with complete Java based configuration. There is no xml configuration involved here.</li>
  <li><h3>Spring5_SpringSecurity_part1_N98</h3> - In this project we integrated Spring 5 and SpringSecurity 5.0 and made a basic web application where login-page is provided by SpringSecurity itself.
		<p align="center">
  			<img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/SpringSecurity_overview.PNG">
			<br><strong>Spring-Security overview</strong>
     		</p>
	  	<p align="center">
  			<img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/SpringSecurity_Internal_Flow.png">
			<br><strong>Spring-Security Internal Flow</strong>
     		</p>
  </li>
  <li><h3>Spring5_SpringSecurity_part2_custom_login_form_N99</h3> - In this project I integrated Spring 5 and SpringSecurity 5.0 and made a web app with custom login page.
		<p align="center">
  			<img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/SpringSecurity_in_action.PNG">
			<br><strong>Spring-Security in action</strong>
     		</p>
	</li>
  <li><h3>Spring5_SpringSecurity_part3_beautify_loginPage_N100</h3> - In this project I integrated Spring 5 and SpringSecurity 5.0 and made a web app with custom login page.Additionally I beautified the login page using css and bootstrap.</li>
  <li><h3>Spring5_SpringSecurity_part4_logout_N101</h3> - In this project I integrated Spring 5 and SpringSecurity 5.0 and made a web app with a beautiful custom login page. I also added the logout functionality into the app.
     <p align="center">
  	<img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/Custom_Login_Page.png">
	<br><strong>Custom Login Page</strong>
     </p>
     <p align="center">
  	<img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/Custom_Login_Page_invalid.PNG">
	<br><strong>Custom Login Page when wrong password given</strong>
     </p>
     <p align="center">
  	<img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/Custom_Login_Page_logged_out_mode.PNG">
	<br><strong>Custom Login Page after logout</strong>
     </p>
  </li>
  <li><h3>Spring5_SpringSecurity_part5_CSRF_N102</h3> - In this project I integrated Spring 5 and SpringSecurity 5.0 and made a web app with login logout functionality. For demonstration purpose I used <form> tag instead of <form:form> tag and manually included CSRF token in the request.
	  <p>
	  	Cross-site request forgery (also known as CSRF) is a web security vulnerability that allows an attacker to induce users to perform actions that they do 		not intend to perform. It allows an attacker to partly circumvent the same origin policy, which is designed to prevent different websites from 			interfering with each other.
	  </p>
  </li>
  <li><h3>Spring5_SpringSecurity_part6_User_Roles_N103</h3> - In this project I integrated Spring 5 and SpringSecurity 5.0 and made a web app with login logout functionality. Along with that I also showed username and all the roles for him using SpringSecurity JSTL taglib.</li>
  <li><h3>Spring5_SpringSecurity_part7_role_based_access_N104</h3> - In this project I integrated Spring 5 and SpringSecurity 5.0 and made a web app with login logout functionality. Along with that I also showed username and all the roles for him using SpringSecurity JSTL taglib. One more functionality added to the web-app is role based access to different web resources.</li>
  <li><h3>/Spring5_SpringSecurity_part8_role_access_denied_N105</h3> - In this project I integrated Spring 5 and SpringSecurity 5.0 and made a web app with login logout functionality. Along with that I also showed username and all the roles for him using SpringSecurity JSTL taglib. One more functionality added to the web-app is role based access to different web resources. I have also added functionality of custom Access-Denied page for any unauthorized access.
	  <p>Some of the highlighted features are as follows:-</p>
	  <ul>
		<li>Resources from css, js and images folder are allowed and we don't need to authentication for that.</li>
		<li>Any url with pattern "/notice/**" and "/holiday/**" can be accessed by users with role "STUDENT", "TEACHER", "ADMIN". But without authentication these urls won't be accessible. And if we click on that url without being authenticated, we will be redirected to the login-page.</li>
		<li>Any url with pattern "/performance" can be accessed by users with role "TEACHER"</li>
		<li>Any url with pattern "/pendingFees" can be accessed by users with role "ADMIN"</li>
		<li>Any url for which there is some role assigned, if we try to access that url without logging in then we will be redirected to the login page. After logging in successfully we will either be directly redirected to the page that we tried to access earlier or to the Access-Denied Page depending on the role of the logged in user. But if we click on "Login" button from any page, we will be redirected to login page and after logging in successfully we will be redirected to "/" url or the url specified in MySpringMvcDispatcherServletInitializer class under method getServletMappings().</li>
		<li>After logout we will be redirected to login page (This is the default behavior). In the login page here we have a Home button.</li>
		<li>As a logged in user if we try to access any url which is meant to be used by a user with different role then we will be redirected to the Access-Denied page.</li>
		<p align="center">
  			<img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/User_not_logged_in.png">
			<br><strong>Home page showing Login button when user is not logged in</strong>
     		</p>
		<p align="center">
  			<img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/User_logged_in.png">
			<br><strong>Home page showing username, roles and Logout button for a logged in used</strong>
     		</p>
		<p align="center">
  			<img src="https://github.com/aman-1998/Full_Stack_Development_Part_II/blob/main/images/Access_denied_page.png">
			<br><strong>Simple access-denied page</strong>
     		</p>  
	  </ul>
  </li>
</ul>

<h2><strong>Some important links:-</strong></h2>
1. https://docs.spring.io/spring-framework/docs/2.0.8/reference/spring-form.tld.html#spring-form.tld.input <br>
2. https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/spring-form-tld.html <br>
3. https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/view.html <br>
4. https://www.denisbouquet.com/css-forbid-selection-user-select-dragging-ghost-image/ <br>
5. https://pixabay.com/vectors/search/error/ <br>
6. https://studyeasy.org/spring/spring-mvc-minimal/ <br>
7. https://studyeasy.org/jstl/jstl-taglibs/ <br>
8. https://studyeasy.org/general/implicit-objects/ <br>
9. https://studyeasy.org/general/locale/ <br>
10. https://studyeasy.org/jsp/setting-up-jndi/ <br>
11. https://studyeasy.org/hibernate/hibernate-configuration-xml/ <br>
12. https://studyeasy.org/maven/java-11-on-maven/ <br>
13. https://www.codejava.net/frameworks/hibernate/how-to-make-hibernate-work-with-oracle-database <br>
14. https://mvnrepository.com/artifact/org.springframework <br>
15. https://mvnrepository.com <br>
16. https://stackoverflow.com/questions/12745751/hibernate-sequencegenerator-and-allocationsize <br>
17. https://newbedev.com/hibernate-sequencegenerator-and-allocationsize <br>
18. https://discourse.hibernate.org/t/sequencegenerator-allocationsize-versus-increment-by/5070 <br>
19. https://discourse.hibernate.org <br>
20. https://marketplace.eclipse.org <br>
21. https://www.eclipse.org <br>
22. https://shields.io <br>
23. https://spring.io/tools <br>
24. https://codepen.io/ankithingarajiya/pen/jjOxMo <br>
25. https://support.oracle.com/knowledge/Oracle%20Database%20Products/2287819_1.html#CAUSE <br>
26. https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/spring-form-tld.html <br>
27. https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/view.html <br>
28. https://docs.spring.io/spring-framework/docs/2.0.8/reference/spring-form.tld.html#spring-form.tld.input <br>
29. https://www.tutorialspoint.com/jsp/jsp_expression_language.htm <br>
30. https://howtodoinjava.com/spring-mvc/spring-mvc-display-validate-and-submit-form-example/ <br>
31. https://howtodoinjava.com/spring-mvc/spring-mvc-resourcebundleviewresolver-configuration-example/ <br>
32. https://mkyong.com/spring-mvc/spring-mvc-form-check-if-a-field-has-an-error/ <br>
33. https://docs.oracle.com/cd/E17802_01/j2ee/j2ee/1.4/docs/tutorial-update2/doc/JSPIntro7.html <br>
34. https://www.flaticon.com/search?word=cross&type=icon <br>
35. https://pixabay.com/vectors/search/error/ <br>
36. https://freepngimg.com/png/15560-red-cross-mark-png-file <br>
37. https://www.pngwing.com/en/free-png-bhnfk <br>
38. https://www.youtube.com/watch?v=lYI9w7I4N0I <br>
39. https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator/7.0.2.Final <br>
40. https://docs.jboss.org/hibernate/validator/3.1/reference/en/html_single/ <br>
41. https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-gettingstarted <br>
42. https://www.baeldung.com/spring-validation-message-interpolation <br>
43. https://stackoverflow.com/questions/15498724/tomcat-server-not-starting-with-in-45-seconds <br>
44. https://stackoverflow.com/questions/39632667/how-do-i-kill-the-process-currently-using-a-port-on-localhost-in-windows <br>
45. https://www.youtube.com/watch?v=4IjsEgNNl88 <br>
46. https://mvnrepository.com/artifact/org.hibernate/hibernate-core/5.6.5.Final <br>
47. https://stackoverflow.com/questions/13388045/oracle-data-source-configuration-for-spring <br>
48. https://howtodoinjava.com/java/regex/java-regex-validate-email-address/ <br>
49. https://www.w3schools.com/java/java_regex.asp <br>
50. https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc8/21.4.0.0.1 <br>
51. https://www.javatpoint.com/spring-mvc-requestparam-annotation <br>
52. https://initialcommit.com/blog/pass-data-from-jsp-to-spring-controller <br>
53. https://stackoverflow.com/questions/6989711/spring-mvc-pre-populate-checkboxes <br>
54. https://stackoverflow.com/questions/1900843/how-to-compare-two-object-variables-in-el-expression-language <br>
55. https://stackoverflow.com/questions/15875301/how-to-make-spring-form-as-read-only <br>
56. https://stackoverflow.com/questions/1271641/in-sql-is-update-always-faster-than-deleteinsert <br>
57. https://stackoverflow.com/questions/29075047/spring-validation-exception-bindexception <br>
58. https://www.youtube.com/playlist?list=PLsyeobzWxl7ps4Z1C4VMtvZEx5-PgyoYI <br>
59. https://restfulapi.net/http-status-codes/ <br>
60. https://www.restapitutorial.com/httpstatuscodes.html <br>
61. https://stackoverflow.com/questions/4738817/error-in-hibernate-cfg-xml <br>
62. https://stackoverflow.com/questions/42065877/entitymanagerfactory-is-closed-hibernate <br>
63. https://www.ques10.com/p/29518/what-do-you-mean-by-json-why-use-json-over-xml/ <br>
64. https://spring.io/projects/spring-hateoas <br>
65. https://spring.io/guides/gs/rest-hateoas/ <br>
66. https://www.baeldung.com/hibernate-one-to-many <br>
67. https://mkyong.com/hibernate/hibernate-parameter-binding-examples/ <br>
68. https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started.first-application <br>
69. https://docs.spring.io/spring-boot/docs/1.4.x/reference/html/common-application-properties.html <br>
70. https://www.codejava.net/frameworks/spring-boot/connect-to-oracle-database-examples <br>
71. https://www.bezkoder.com/spring-boot-hibernate-oracle/ <br>
72. https://spring.io/guides/gs/accessing-data-mysql/ <br>
73. https://www.baeldung.com/sql-logging-spring-boot <br>
74. https://www.baeldung.com/spring-open-session-in-view <br>
75. https://stackoverflow.com/questions/44839753/returning-json-object-as-response-in-spring-boot <br>
76. https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc <br>
77. https://www.baeldung.com/spring-request-response-body <br>
78. https://www.springboottutorial.com/spring-boot-hateoas-for-rest-services <br>
79. https://www.baeldung.com/hibernate-5-spring <br>
80. https://www.onlinetutorialspoint.com/spring-boot/spring-boot-hibernate-integration-example.html <br>
81. https://www.baeldung.com/spring-data-jpa-query <br>
82. https://stackoverflow.com/questions/30528255/how-to-access-a-value-defined-in-the-application-properties-file-in-spring-boot <br>
83. https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config <br>
84. https://howtodoinjava.com/hibernate/hibarnate-build-sessionfactory/ <br>
85. https://howtodoinjava.com/spring-boot2/logging/multiple-log-files/ <br>
86. https://logback.qos.ch/manual/layouts.html#conversionWord <br>
87. https://logback.qos.ch/manual/filters.html <br>
88. https://logback.qos.ch <br>
89. https://www.baeldung.com/spring-controller-vs-restcontroller <br>
90. https://www.baeldung.com/logback <br>
91. https://tedblob.com/logback-multiple-log-files/?amp=1 <br>
92. https://examples.javacodegeeks.com/enterprise-java/logback/logback-additivity-example/ <br>
93. https://stackoverflow.com/questions/24180772/logback-logger-logging-twice <br>
94. https://howtodoinjava.com/spring-boot2/rest/rest-with-spring-hateoas-example/ <br>
95. https://www.baeldung.com/spring-resttemplate-json-list <br>
96. https://www.nginx.com/blog/service-discovery-in-a-microservices-architecture/ <br>
97. https://www.baeldung.com/spring-webclient-resttemplate <br>
98. https://spring.io/guides/gs/service-registration-and-discovery/ <br>
99. https://start.spring.io <br>
100. https://stackoverflow.com/questions/41230164/eureka-unknownhostexception-in-service-discovery <br>
101. https://www.youtube.com/watch?v=xruvRk1Uf5I <br>
102. https://www.youtube.com/watch?v=TxjIlNYRZ5M <br>
103. https://www.youtube.com/watch?v=y8IQb4ofjDo&list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas <br>
104. https://www.youtube.com/watch?v=PdxPp-cn7bI <br>
105. https://spring.io/projects/spring-cloud <br>
106. https://www.freepnglogos.com <br>
107. https://www.baeldung.com/web-mvc-configurer-adapter-deprecated <br>
108. https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html <br>
109. https://www.javadevjournal.com/spring-security/spring-security-login/ <br>
110. https://o7planning.org/10353/configure-static-resources-in-spring-mvc <br>
111. https://stackoverflow.com/questions/29396281/what-does-configuredefaultservlethandling-means <br>
112. https://stackoverflow.com/questions/47552835/the-type-webmvcconfigureradapter-is-deprecated <br>
113. https://mkyong.com/spring-mvc/spring-mvc-webmvcconfigureradapter-is-deprecated/ <br>
114. https://bbbootstrap.com/snippets/bootstrap-5-login-form-using-neomorphism-89456141 <br>
115. https://bbbootstrap.com <br>
116. https://stackoverflow.com/questions/25368535/spring-security-does-not-allow-css-or-js-resources-to-be-loaded <br>
117. https://github.com/spring-projects/spring-security/issues/4857 <br>
118. https://docs.spring.io/spring-security/site/docs/4.1.3.RELEASE/guides/html5/helloworld-boot.html <br>
119. https://codepen.io - Templates with code (No need to download)<br>
120. https://www.tutorialspoint.com/spring_security/spring_security_with_taglib.htm <br>
121. https://www.javaguides.net/2019/06/spring-security-how-to-get-current-logged-in-username-in-jsp.html <br>
122. https://bushansirgur.in/how-to-include-one-jsp-in-another-jsp-example/#:~:text=To%20include%20JSP%20in%20another,name%20of%20the%20JSP%20file. <br>
123. https://www.baeldung.com/java-config-spring-security <br>
124. https://www.baeldung.com/spring-security-login <br>
125. https://www.youtube.com/watch?v=U-NQlwbgZLo - Common User (user in CDB) and Local User (user in PDB) in Oracle database <br>
126. https://www.baeldung.com/spring-security-jdbc-authentication <br>
127. https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/appendix-schema.html <br>
128. https://mkyong.com/spring-security/spring-security-form-login-using-database/ <br>
129. https://www.baeldung.com/hibernate-c3p0 <br>
130. https://mvnrepository.com/artifact/com.mchange/c3p0/0.9.5.5 <br>
131. https://www.mchange.com/projects/c3p0/ - c3p0 connection pooling <br>
132. https://danboterhoven.medium.com/why-you-should-use-bcrypt-to-hash-passwords-af330100b861 <br>
133. https://en.wikipedia.org/wiki/Bcrypt <br>
134. https://crackstation.net/hashing-security.htm - Salted Password Hashing <br>
135. https://www.bcryptcalculator.com - Generate Bcrypt passwords <br>
136. https://www.aegissofttech.com/articles/bcrypt-password-encoding-spring-security.html - Encrypt password using Bcrypt algorithm <br>
137. https://www.youtube.com/watch?v=3xSeynG0-zM - Signin and Login with Bcrypt password <br>
138. https://www.digitalocean.com/community/tutorials/spring-hibernate-integration-example-tutorial <br>
139. https://stackoverflow.com/questions/1099025/spring-transactional-what-happens-in-background <br>
140. https://www.baeldung.com/transaction-configuration-with-jpa-and-spring <br>
141. https://www.baeldung.com/hibernate-c3p0 - Hibernate with c3p0 connection pool <br>
142. https://stackoverflow.com/questions/475893/what-are-the-required-c3p0-settings-for-hibernate-in-order-to-avoid-deadlocks <br>
143. https://mkyong.com/hibernate/how-to-configure-the-c3p0-connection-pool-in-hibernate/ <br>
144. https://howtodoinjava.com/hibernate/hibernate-c3p0-connection-pool-configuration-tutorial/#1-maven-dependencies <br>
145. https://howtodoinjava.com/hibernate/hibernate-c3p0-connection-pool-configuration-tutorial/#1-maven-dependencies <br>
146. https://thorben-janssen.com/jpa-native-queries/#resultHandling <br>
147. https://docs.jboss.org/hibernate/stable/validator/api/org/hibernate/validator/constraints/package-summary.html - Hibernate validator constraints <br>
148. https://docs.jboss.org/hibernate/validator/3.1/reference/en/html_single/ - Javax validation constraints <br>
149. https://stackoverflow.com/questions/11244569/what-is-referencedcolumnname-used-for-in-jpa <br>
150. https://mkyong.com/hibernate/hibernate-parameter-binding-examples/#:~:text=It%27s%20use%20question%20mark%20(%3F),stockCode%20%3D%20%3F%20and%20s. <br>
151. https://www.digitalocean.com/community/tutorials/java-clone-object-cloning-java - Cloning <br>
152. https://turreta.com/2017/07/13/clone-objects-java-generics-using-apache-commons-lang-objectutils/ Cloning genrics using ObjectUtils <br>
153. https://www.tutorialspoint.com/hibernate/hibernate_native_sql.htm - Native Query in Hibernate <br>
154. https://www.digitalocean.com/community/tutorials/hibernate-native-sql-query-example <br>
155. https://thorben-janssen.com/jpa-native-queries/#resultHandling <br>
156. https://stackoverflow.com/questions/9908082/does-a-hibernate-transaction-rollback-delete-session-flushed-entities <br>
157. http://wiki.openbravo.com/wiki/Hibernate_5.3_Migration_Guide#Typed_Queries - ResultTransformer in Hibernate <br>
158. https://www.baeldung.com/jpa-sql-resultset-mapping <br>
159. https://stackoverflow.com/questions/1780896/java-getting-the-properties-of-a-class-to-construct-a-string-representation - getting list of fields in a class <br>
160. https://www.geeksforgeeks.org/clone-method-in-java-2/ <br>
161. https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.12.0 - Apache Commons <br>
162. https://www.geeksforgeeks.org/hibernate-native-sql/ <br>
163. https://howtodoinjava.com/hibernate/hibernate-many-to-many-mapping/  - ManyToMany <br>
164. https://stackoverflow.com/questions/21985308/how-is-the-owning-side-of-this-many-to-many-relationship-determined  - Owning entity <br>
165. https://stackoverflow.com/questions/36803306/should-jointable-be-specified-in-both-sides-of-a-manytomany-relationship  - Two owning entities <br>
166. https://levelup.gitconnected.com/how-to-deal-with-the-remote-host-identification-has-changed-message-with-github-1dea015dae8d - WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED! <br>
167. https://www.javatpoint.com/java-date-to-string - Date to String <br>
168. https://www.javatpoint.com/java-string-to-date - String to Date <br>
169. https://www.techiedelight.com/print-all-keys-values-from-properties-file-java/ - Access value in properties file in Java <br>
170. https://stackabuse.com/how-to-access-property-file-values-in-spring-boot/ - Access value in properties file in Spring / Spring Boot <br>
171. https://javabeat.net/spring-mvc-component-scan-annotations/ - component-scan Vs annotation-config Vs annotation-driven <br>
172. https://www.baeldung.com/spring-contextannotation-contextcomponentscan - component-scan Vs annotation-config <br>
173. https://stackoverflow.com/questions/14212527/how-to-set-default-value-to-the-inputtype-date - Default population of input type date <br>
174. https://www.aegissofttech.com/articles/bcrypt-password-encoding-spring-security.html - <b>Setup Bcrypt in Spring Boot</b> <br>
175. https://www.geeksforgeeks.org/understanding-rainbow-table-attack/ <br>
176. https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt - <b>Registration with Spring Security (Bcrypt)</b> <br>
177. https://bcrypt-generator.com - <b>Bcrypt Generator with various strength</b> <br>
178. https://www.youtube.com/watch?v=z6o3YyYTiiI - Change Password of a User in Oracle database <br>
179. https://www.springcloud.io/post/2022-02/jwt-cookie/#gsc.tab=0 - Storage of JWT <br>
180. https://stackabuse.com/spring-security-in-memory-invalidation-of-jwt-token-during-user-logout/ <br>
181. https://stackoverflow.com/questions/63834132/how-to-pass-jwt-token-to-localstorage-using-javascript-script-for-html <br>
182. https://medium.com/kanlanc/heres-why-storing-jwt-in-local-storage-is-a-great-mistake-df01dad90f9e <br>
183. https://crackstation.net/hashing-security.htm - <b>Password hashing - Best Practices</b> <br>
184. https://danboterhoven.medium.com/why-you-should-use-bcrypt-to-hash-passwords-af330100b861 - Why you should use BCrypt to hash passwords <br>
185. https://en.wikipedia.org/wiki/Bcrypt - Bcrypt in Detail <br>
186. https://docs.spring.io/spring-security/reference/5.8/migration/servlet/config.html - <b>In Spring Security 5.8, the antMatchers, mvcMatchers, and regexMatchers methods were deprecated in favor of new requestMatchers methods.</b> <br>
187. https://itecnote.com/tecnote/spring-security-invalid-property-principal-of-bean-class-org-springframework-security-authentication-usernamepasswordauthenticationtoken/ - org.springframework.beans.NotReadablePropertyException: Invalid property 'principal' of bean class [org.springframework.security.authentication.UsernamePasswordAuthenticationToken]: Bean property 'principal' is not readable...<br>
188. https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html - Servlet Authentication Architecture <br>
