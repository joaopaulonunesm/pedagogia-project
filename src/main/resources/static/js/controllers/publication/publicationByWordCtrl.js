angular.module("pedagogiaApp").controller("publicationByWordCtrl", function ($scope, $http, publicationAPI, $location) {

	$scope.publications = [];
	
	$scope.search = {word: ""};
	
	$scope.getPublicationsByWord = function() {
		
		if($scope.search.word.length > 0 && $scope.search.word.length != null){
			
			publicationAPI.getPublicationsByWord($scope.search.word).then(function(response) {

				$scope.publications = response.data;
				
				if($scope.publications != null){
					$location.path("/publication/search");
				}

			}, function(response) {
				console.log(response.data);
				console.log(response.status);
			});
		} else {
			$location.path("/home");
		}

	};

});

