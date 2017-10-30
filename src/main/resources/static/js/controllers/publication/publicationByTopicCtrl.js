angular.module("pedagogiaApp").controller("publicationByTopicCtrl", function ($scope, $http, publicationAPI, topicAPI, $routeParams, $location) {

	$scope.topic = {};
	
	$scope.publications = [];
	
	$scope.getPublicationsByTopic = function(topic) {

		publicationAPI.getPublicationsByTopic(topic).then(function(response) {

			$scope.publications = response.data;

		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.getTopic = function(topic) {
		
		topicAPI.getTopicByNameUrl(topic).then(function(response) {
			
			$scope.topic = response.data;
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.getTopic($routeParams.nameUrl);

	$scope.getPublicationsByTopic($routeParams.nameUrl);

});