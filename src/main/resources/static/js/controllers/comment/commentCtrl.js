angular.module("pedagogiaApp").controller("commentCtrl", function ($scope, $http, commentAPI, $routeParams, $location) {

	$scope.comments = [];
	
	$scope.getComments = function() {
		
		commentAPI.getComments().then(function(response) {
			
			$scope.comments = response.data;
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.getComments();
	
	$scope.deleteComment = function(id) {
		
		commentAPI.deleteComment(id).then(function(response) {
			
			$scope.getComments();
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
		
	};
	
});