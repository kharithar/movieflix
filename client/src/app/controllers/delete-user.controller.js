/**
 * Created by Haritha on 8/18/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('DeleteUserController', DeleteUserController);

    DeleteUserController.$inject = ['userService'];

    function DeleteUserController(userService) {
        var deleteUsersVm = this;

        deleteUsersVm.deleteUser = deleteUser;


        function deleteUser(id) {
            userService.deleteUser(id)
                .then(function(data){
                    $location.path('/users');
                },function(error) {
                    console.log(error);
                });
        }

    }

})();