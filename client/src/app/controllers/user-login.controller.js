/**
 * Created by Haritha on 8/12/2016.
 */
(function(){
    'use strict';
    angular.module('movieflix')
        .controller('UserLoginController', UserLoginController);
    UserLoginController.inject = ['userService', '$location', '$http','$routeParams'];

    function UserLoginController(userService, $location, $http,$routeParams){
        var userLoginVm = this;
        userLoginVm.findUser = findUser;
        userLoginVm.token = null;
        userLoginVm.error = null;
        userLoginVm.roleUser = false;
        userLoginVm.roleAdmin = false;
        $routeParams.type = 'movie';
        function findUser() {
            userService.findUser(userLoginVm.user)
                .then(function(data){
                   /** userLoginVm.token = data.token;
                    console.log(userLoginVm.token);
                    $http.defaults.headers.common.Authorization = 'Bearer ' + userLoginVm.token;
                    checkRoles();*/
                    $location.path('/movies/'+'movie');
                },function(error){
                    console.log(error);
                })
        }

        /**function checkRoles() {
            userService.hasRole('USER').then(function(user) {userLoginVm.role = user});
            userService.hasRole('ADMIN').then(function(admin) {userLoginVm.role = admin});
            console.log(userLoginVm.role);
        }
        function logout() {
            userLoginVm.userName = '';
            userLoginVm.password = '';
            userLoginVm.token = null;
            $http.defaults.headers.common.Authorization = '';
        }

        function loggedIn() {
            return userLoginVm.token !== null;
        }*/
    }
})();