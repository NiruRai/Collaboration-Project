	<!-- When the application starts some dummy contacts are shown -->
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
<title>Register User</title>
<html>
 <body data-ng-app="myApp" class="ng-cloak"> <!--"data-ng-app" inform that the page in using angular js/class="ng-cloak" does not page to load partially  -->
      <div data-ng-controller="UserController as ctrl"> <!-- which controller is used in mentioned// by doing "as ctrl" in place of UserController "ctrl" can be used -->
          	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">RegisterUser&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
			</div>


			<div class="collapse navbar-collapse" id="myNavbar">

				<ul class="nav navbar-nav navbar-right">

					<li><a href="userList"><span
							class="glyphicon glyphicon-user"></span> View List</a></li>

					<li><a href="<c:url value="/" />"><span
							class="glyphicon glyphicon-log-in"></span> Insert User</a></li>

				</ul>


			</div>
		</div>
	</nav>
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">User Registration Form </span></div>
              <div class="formcontainer">
                 <form data-ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" data-ng-model="ctrl.user.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file"> First Name</label>
                              <div class="col-md-7">
                                  <input type="text" data-ng-model="ctrl.user.username" name="uname" class="username form-control input-sm" placeholder="Enter your name" required data-ng-minlength="3"/>
                                  <div class="has-error" data-ng-show="myForm.$dirty">
                                      <span data-ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span data-ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span data-ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Last Name</label>
                              <div class="col-md-7">
                                  <input type="text" data-ng-model="ctrl.user.lastname" name="lastname" class="lastname form-control input-sm" placeholder="Enter your lastname" required data-ng-minlength="3"/>
                                  <div class="has-error" data-ng-show="myForm.$dirty">
                                      <span data-ng-show="myForm.lastname.$error.required">This is a required field</span>
                                      <span data-ng-show="myForm.lastname.$error.minlength">Minimum length required is 3</span>
                                      <span data-ng-show="myForm.lastname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Address</label>
                              <div class="col-md-7">
                                  <input type="text" data-ng-model="ctrl.user.address" class="form-control input-sm" placeholder="Enter your Address. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Email</label>
                              <div class="col-md-7">
                                  <input type="email" data-ng-model="ctrl.user.email" name="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                                  <div class="has-error" data-ng-show="myForm.$dirty">
                                      <span data-ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span data-ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Mobile</label>
                              <div class="col-md-7">
                                  <input type="tel" data-ng-model="ctrl.user.mobile" name="mobile" class="mobile form-control input-sm" placeholder="Enter your mobileno" required data-ng-minlength="10" data-ng-maxlength="12"/>
                                  <div class="has-error" data-ng-show="myForm.$dirty">
                                      <span data-ng-show="myForm.mobile.$error.required">This is a required field</span>
                                      <span data-ng-show="myForm.mobile.$error.minlength">Minimum length required is 10</span>
                                      <span data-ng-show="myForm.mobile.$error.maxlength">Maximum length required is 12</span>
                                      <span data-ng-show="myForm.mobile.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" data-ng-disabled="myForm.$invalid">   <!-- If there will be no value in the form these buttons will be disabled and after clicking once they will become disable again -->
                              <button type="button" data-ng-click="ctrl.reset()" class="btn btn-warning btn-sm" data-ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form> 
              </div> 
          </div>
          
         
         
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/resources/js/app.js' />"></script>
      <script src="<c:url value='/resources/js/service/user_service.js' />"></script>
      <script src="<c:url value='/resources/js/controller/user_controller.js' />"></script>
  </body>
</html>
