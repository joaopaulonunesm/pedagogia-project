angular.module("pedagogiaApp").controller("newPartnerCtrl", function ($scope, $location, partnerAPI) {

	$scope.partner = {};
	
	$scope.createPartner = function() {

		partnerAPI.postPartner($scope.partner).then(function(response) {

			$location.path("/partners");

		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
});