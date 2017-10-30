angular.module("pedagogiaApp").factory("commentAPI", function ($http, configs){

	var _postComment = function (titleUrl, comment){
		return $http.post(configs.baseUrl + '/comments/publication/' + titleUrl, comment);
	};
	
	var _deleteComment = function (id){
		return $http.delete(configs.baseUrl + '/comments/' + id);
	};
	
	var _getComments = function (){
		return $http.get(configs.baseUrl + '/comments');
	};

    return {
    	postComment: _postComment,
    	deleteComment: _deleteComment,
    	getComments: _getComments
    };
	
});