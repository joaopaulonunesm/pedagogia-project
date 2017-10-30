angular.module("pedagogiaApp").factory("loginAPI", function ($http, configs){

	var _putLogin = function (login){
		return $http.put(configs.baseUrl + '/logins', login);
	};
	
	var _getLogin = function (id, login){
		return $http.get(configs.baseUrl + '/logins');
	};
	
    return {
    	putLogin: _putLogin,
    	getLogin: _getLogin
    };
	
});