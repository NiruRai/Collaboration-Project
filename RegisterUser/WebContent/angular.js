 var isHtml5Compatible = document.createElement('canvas').getContext != undefined;  
  
        if (isHtml5Compatible) {  
            initiateLocalStorage();  
  
        }  
  
        function initiateLocalStorage() {  
            // Create the AngularJS app   
            var app = angular.module('Users', ['storageService']);  
  
            // Create the Controller  
            app.controller('UsersController', ['$scope', 'getLocalStorage', function ($scope, getLocalStorage) {  
                $scope.appTitle = " User List";  
                $scope.appHeadline = "Register New User";  
  
                //Read the Users List from LocalStorage  
                $scope.users = getLocalStorage.getUsers();  
  
                //Count the Users List  
                $scope.count = $scope.users.length;  
  
  
                //Add Users - using AngularJS push to add Users in the Users Object  
                
                $scope.addUsers = function () {  
                    $scope.users.push({ 'userno': $scope.userno, 'username': $scope.username, 'usersalary': $scope.usersalary, 'useraddress':$scope.useraddress });  
                    getLocalStorage.updateUsers($scope.users);  
                    $scope.userno = '';  
                    $scope.username = '';  
                    $scope.usersalary = ''; 
                    $scope.useraddress = '';
                    $scope.count = $scope.users.length;  
                };  
  
                //Delete Users   
                $scope.deleteUser = function (user) {  
                    $scope.users.splice($scope.users.indexOf(user), 1);  
                    getLocalStorage.updateUsers($scope.users);  
                    $scope.count = $scope.users.length;  
                };  
            
            
           $scope.editUser = function (id){
                console.log('id to be edited', id);
                for(var i = 0; i < self.users.length; i++){
                    if(self.users[i].id === id) {
                        self.user = angular.copy(self.users[i]);
                        break;
                    }
                }
            }
            }]); 
            //Create the Storage Service Module  
              
            var storageService = angular.module('storageService', []);  
            storageService.factory('getLocalStorage', function () {  
                var userList = {};  
                return {  
                    list: userList,  
                    updateUsers: function (UsersArr) {  
                        if (window.localStorage && UsersArr) {  
                            //Local Storage to add Data  
                            localStorage.setItem("users", angular.toJson(UsersArr));  
                        }  
                        userList = UsersArr;  
  
                    },  
                    getUsers: function () {  
                        //Get data from Local Storage  
                        userList = angular.fromJson(localStorage.getItem("users"));  
                        return userList ? userList : [];  
                    }  
                };  
  
            });  
        }  