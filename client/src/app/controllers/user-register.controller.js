/**
 * Created by Haritha on 8/12/2016.
 */
(function(){
    'use strict';
    angular.module('movieflix')
        .controller('AddUserController', AddUserController);
    AddUserController.inject = ['userService', '$location'];

    function AddUserController(userService, $location){
        var addUserVm = this;
        addUserVm.addUser = addUser;

        function addUser() {
            console.log('in add user');
            userService.addUser(addUserVm.newUser)
                .then(function(data){
                    $location.path('/user-login');
                },function(error){
                    console.log(error);
                })
        }
    }
})();