'use strict';

angular.module('crudApp').controller('PersonInfoController',
    ['PersonInfoService', '$scope',  function( PersonInfoService, $scope) {

        var self = this;
        self.person = {};
        self.persons=[];
        $scope.myHobbies = [];

        self.submit = submit;
        self.getAllPersons = getAllPersons;
        self.createPerson = createPerson;
        self.updatePerson = updatePerson;
        self.removePerson = removePerson;
        self.editPerson = editPerson;
        self.reset = reset;
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
        self.hobby = '';

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
        
        function inArray(x, arr) {
        	  for(var i = 0; i < arr.length; i++) {
        	    if(x === arr[i]) return true;
        	  }
        	  return false;
        	}


       $scope.addHobbies = function(hobby) {
            if (hobby) {
                $scope.myHobbies.push(hobby);
                $scope.hobby = "";
                self.person.hobbies = $scope.myHobbies;
            }
        };

        $scope.remove = function(item) {
            $scope.myHobbies.splice(item, 1);
        };

        
        function submit() {
            console.log('Submitting');
            if (self.person.id === undefined || self.person.id === null) {
                console.log('Saving New Person', self.person);
                createPerson(self.person);
            } else {
                updatePerson(self.person, self.person.id);
                console.log('Person updated with id ', self.person.id);
            }
        }

        function createPerson(person) {
            console.log('About to create person');
            PersonInfoService.createPerson(person)
                .then(
                    function (response) {
                        console.log('Person created successfully');
                        self.successMessage = 'Person created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.person={};
                        $scope.myHobbies = [];
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Person');
                        self.errorMessage = 'Error while creating Person: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updatePerson(person, id){
            console.log('About to update person');
            PersonInfoService.updatePerson(person, id)
                .then(
                    function (response){
                        console.log('Person updated successfully');
                        self.successMessage='Person updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.person={};
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Person');
                        self.errorMessage='Error while updating Person '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removePerson(id){
            console.log('About to remove Person with id '+id);
            PersonInfoService.removePerson(id)
                .then(
                    function(){
                        console.log('Person '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing person '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllPersons(){
            return PersonInfoService.getAllPersons();
        }

        function editPerson(id) {
            self.successMessage='';
            self.errorMessage='';
            PersonInfoService.getPerson(id).then(
                function (person) {
                    self.person = person;
                },
                function (errResponse) {
                    console.error('Error while removing person ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.person={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    
 


    ]);