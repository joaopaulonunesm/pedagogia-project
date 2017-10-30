angular.module("pedagogiaApp").controller("onePartnerCtrl", function ($scope, $location, $routeParams, partnerAPI) {

	$scope.partner = {};

	$scope.getPartner = function(nameUrl) {
		
		partnerAPI.getPartnersByNameUrl(nameUrl).then(function(response) {
			
			$scope.partner = response.data;
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});

	};

	$scope.getPartner($routeParams.nameUrl);
	
	$scope.alterPartner = function(nameUrl) {
		
		partnerAPI.putPartner(nameUrl, $scope.partner).then(function(response) {

			$location.path("/partners");
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});

	};
	
});