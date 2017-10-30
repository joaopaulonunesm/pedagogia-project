angular.module("pedagogiaApp").controller("newPublicationCtrl", function ($scope, $http, publicationAPI, $routeParams, $location) {

	$scope.publication = {};
	
	$scope.createPublication = function() {

		publicationAPI.postPublication($scope.publication).then(function(response) {

			$location.path("/publications");

		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
});