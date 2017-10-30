angular.module("pedagogiaApp").controller("topicCtrl", function ($scope, $location, topicAPI) {

	$scope.topic = {};
	
	$scope.topics = [];
	
	$scope.createTopic = function() {

		topicAPI.postTopic($scope.topic).then(function(response) {

			$scope.getTopics();
			$scope.topic = {};

		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.getTopics = function() {
		
		topicAPI.getTopics().then(function(response) {
			
			$scope.topics = response.data;
			
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.getTopics();
	
});