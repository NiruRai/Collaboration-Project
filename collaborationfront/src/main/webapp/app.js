'use strict';

var app = angular.module("ctrlApp", ['ngRoute']);
app.config(['$routeProvider', function($routeProvider) {
        $routeProvider
        
        .when('/', {
           templateUrl: 'l_home/home.html',
           controller: 'HomeController'
        })
        
        .when('/login', {
           templateUrl: 'l_login/login.html',
           controller: 'LoginController'
        })
        
        .when('/signUp', {
            templateUrl: 'l_signUp/signUp.html',
            controller: 'RegisterController'
         }).
        
        otherwise({
           redirectTo: '/'
        });
     }]);
     
     app.controller('HomeController', function($scope) {
        $scope.message = "This page will be used to display static page";
     });
     
    


