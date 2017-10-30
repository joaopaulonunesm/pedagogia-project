angular.module("pedagogiaApp").controller("onePublicationCtrl", function ($scope, $location, $routeParams, publicationAPI) {

	$scope.publication = {};

	$scope.getPublication = function(titleUrl) {
		
		publicationAPI.getPublicationByTitleUrl(titleUrl).then(function(response) {
			
			$scope.publication = response.data;
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});

	};

	$scope.getPublication($routeParams.titleUrl);
	
	$scope.alterPublication = function(titleUrl) {
		
		publicationAPI.putPublication(titleUrl, $scope.publication).then(function(response) {

			$location.path("/publications");
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});

	};
	
});