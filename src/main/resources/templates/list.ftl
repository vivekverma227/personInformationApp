<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Person Information </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.person.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="fname">First Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.person.first_name" id="fname" class="firstname form-control input-sm" placeholder="Enter your First Name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="lname">Last Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.person.last_name" id="lname" class="lastname form-control input-sm" placeholder="Enter your Last Name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="age">Age</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.person.age" id="age" class="form-control input-sm" placeholder="Enter your Age." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="favColour">Favourite Colour</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.person.favourite_colour" id="favColour" class="form-control input-sm" placeholder="Enter your Favourite Colour."  required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="hobbies">Hobbies</label>
	                        <div class="col-md-5">
                                <input type="text" class="form-control" id="hobbies" ng-model="hobby" placeholder="Enter your Hobbies."  />
							</div>
                            <div class="form-group col-md-2">
                                <button type="button" class="btn btn-primary" ng-click="addHobbies(hobby)">Add Hobbies</button>
                            </div>

  
	                    </div>
	                </div>
                    <div class="row">
						<div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="hobbies"></label>
                        <div ng-repeat="item in myHobbies">
                                    <button type="button" ng-click="remove($index)" id="hobbyStyle" class="btn btn-danger col-md-1">{{item  }} <i class="fas fa-trash-alt fa-sm"></i></button>
                        </div>
                        </div>
                    </div>
	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.person.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Person Information </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>FISRT NAME</th>
		                <th>LAST NAME</th>
		                <th>AGE</th>
		                <th>FAVOURITE COLOUR</th>
		                <th>HOBBIES</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="p in ctrl.getAllPersons()">
		                <td>{{p.id}}</td>
		                <td>{{p.first_name}}</td>
		                <td>{{p.last_name}}</td>
		                <td>{{p.age}}</td>
		                <td>{{p.favourite_colour}}</td>
		                <td id="hob" ng-repeat = "hobby in p.hobbies">{{hobby}}</td>
		                <td><button type="button" ng-click="ctrl.editPerson(p.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removePerson(p.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>