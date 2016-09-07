'use strict';

angular.module('myApp').controller('RegisterController', ['$scope', 'RegistrationService', function($scope, RegistrationService) {
    var self = this;
    self.user={userid:'',username:'',userloginname:'',email:'',password:''};
    self.users=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    alert('in the registercontroller');
    fetchAllUsers();

    function fetchAllUsers(){
    	RegistrationService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;
                console.log('users....'+self.users)
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

    function createUser(user){
    	RegistrationService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }

    function updateUser(user, id){
    	RegistrationService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function deleteUser(id){
    	RegistrationService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    function submit() {
    	alert('in the registercontroller');
            console.log('Saving New User', self.user);
            createUser(self.user);
            console.log('User updated with id ', self.user.id);
        
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.user={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);



/*(function () {
    'use strict';
 
    angular
        .module('app')
        .controller('RegisterController', RegisterController);
 
    RegisterController.$inject = ['UserService', '$location', '$rootScope'];
    function RegisterController(UserService, $location, $rootScope) {
        var vm = this;
 
        vm.register = register;
 
        function register() {
            vm.dataLoading = true;
            UserService.Create(vm.user)
                .then(function (response) {
                    if (response.success) {
                        //FlashService.Success('Registration successful', true);
                        $location.path('/login');
                    } else {
                        //FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
        }
    }
 
})();*/