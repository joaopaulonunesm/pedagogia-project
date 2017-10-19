angular.module("queroEventoApp").controller("eventByUrlTitleCtrl", function ($scope, $http, eventAPI, categoryAPI, $routeParams) {

	$scope.publication = [];
	
	$scope.getEventByUrl = function(url) {
		
		eventAPI.getEventByUrlTitle(url).then(function(response) {
			
			$scope.publication = response.data;
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});

	};

	$scope.getEventByUrl($routeParams.urlTitle);

});