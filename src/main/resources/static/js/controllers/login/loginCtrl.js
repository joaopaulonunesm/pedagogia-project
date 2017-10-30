angular.module("pedagogiaApp").controller("loginCtrl", function ($scope, $location, loginAPI) {

	$scope.login = {};
	
	$scope.getLogin = function() {
		
		loginAPI.getLogin().then(function(response) {
			
			$scope.login = response.data;
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.alterLogin = function() {
		
		loginAPI.getLogin($scope.login).then(function(response) {

			$location.path("/home");
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});

	};

});