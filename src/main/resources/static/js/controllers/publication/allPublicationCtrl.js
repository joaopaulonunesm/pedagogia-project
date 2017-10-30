angular.module("pedagogiaApp").controller("allPublicationCtrl", function ($scope, $http, publicationAPI, $routeParams, $location) {

	$scope.publications = [];
	
	$scope.getPublications = function() {
		
		publicationAPI.getPublications().then(function(response) {
			
			$scope.publications = response.data;
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.getPublications();
	
	$scope.deletePublication = function(titleUrl) {
		
		publicationAPI.deletePublication(titleUrl).then(function(response) {
			
			$scope.getPublications();
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
		
	};
});