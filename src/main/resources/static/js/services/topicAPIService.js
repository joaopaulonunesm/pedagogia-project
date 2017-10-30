angular.module("pedagogiaApp").factory("topicAPI", function ($http, configs){

	var _postTopic = function (topic){
		return $http.post(configs.baseUrl + '/topics', topic);
	}
	
	var _putTopic = function (nameUrl, topic){
		return $http.put(configs.baseUrl + '/topics/' + nameUrl, topic);
	}

	var _deleteTopic = function (nameUrl){
		return $http.delete(configs.baseUrl + '/topics/' + nameUrl);
	}

	var _getTopicByName = function (name){
		return $http.get(configs.baseUrl + '/topics/name/containg/' + name);
	}
	
	var _getTopicByNameUrl = function (urlName){
		return $http.get(configs.baseUrl + '/topics/name/url/' + urlName);
	}
	
	var _getTopics = function (){
		return $http.get(configs.baseUrl + '/topics/ammountpublication');
	}

	return {
		postTopic: _postTopic,
		putTopic: _putTopic,
		deleteTopic: _deleteTopic,
		getTopicByName: _getTopicByName,
		getTopicByNameUrl: _getTopicByNameUrl,
		getTopics: _getTopics
    };
	
});