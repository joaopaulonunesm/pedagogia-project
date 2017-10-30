angular.module("pedagogiaApp").factory("publicationAPI", function ($http, configs){

	var _postPublication = function (publication){
		return $http.post(configs.baseUrl+ '/publications', publication);
	}
	
	var _putPublication = function (titleUrl, publciation){
		return $http.put(configs.baseUrl + '/publications/' + titleUrl, publciation);
	}
	
	var _deletePublication = function (titleUrl){
		return $http.delete(configs.baseUrl + '/publications/' + titleUrl);
	}
	
	var _getPublicationByTitleUrl = function (titleUrl){
		return $http.get(configs.baseUrl + '/publications/title/url/' + titleUrl);
	}
	
	var _getPublicationsByWord = function (word){
		return $http.get(configs.baseUrl  + '/publications/containg/' + word);
	}
	
	var _getPublicationsByTopic = function (topic){
		return $http.get(configs.baseUrl  + '/publications/topic/'+ topic);
	}
	
	var _getPublicationsByView = function (){
		return $http.get(configs.baseUrl  + '/publications/view');
	}

	var _getPublicationsByStar = function (){
		return $http.get(configs.baseUrl  + '/publications/star');
	}
	
	var _getPublications = function (){
		return $http.get(configs.baseUrl  + '/publications');
	}

	return {
		postPublication: _postPublication,
		putPublication: _putPublication,
		deletePublication: _deletePublication,
		getPublicationByTitleUrl: _getPublicationByTitleUrl,
		getPublicationsByWord: _getPublicationsByWord,
		getPublicationsByTopic: _getPublicationsByTopic,
		getPublicationsByView: _getPublicationsByView,
		getPublicationsByStar: _getPublicationsByStar,
		getPublications: _getPublications
    };
	
});