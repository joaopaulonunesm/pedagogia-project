angular.module("pedagogiaApp").controller("allPartnerCtrl", function ($scope, $location, partnerAPI) {

	$scope.partners = [];
	
	$scope.getPartners = function() {
		
		partnerAPI.getPartners().then(function(response) {
			
			$scope.partners = response.data;
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.getPartners();
	
	$scope.deletePartner = function(nameUrl) {
		
		partnerAPI.deletePartner(nameUrl).then(function(response) {
			
			$scope.getPartners();
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
		
	};
	
});