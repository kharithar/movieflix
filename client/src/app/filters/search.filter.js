/**
 * Created by Haritha on 8/14/2016.
 */
angular
    .module('movieflix')
    .filter('search',searchFilter);
function searchFilter(){
    console.log('in search filter');
    return function(arr, by, value) {
        return !value ? arr : arr.filter(function(elem) {
            return elem[by.code].toString().toLowerCase().indexOf(value.toLowerCase()) >= 0;
        })
    }
}