angular.module("pedagogiaApp").factory("partnerAPI", function ($http, configs){

	var _postPartner = function (partner){
		return $http.post(configs.baseUrl + '/partners', partner);
	}
	
	var _putPartner = function (nameUrl, partner){
		return $http.put(configs.baseUrl + '/partners/' + nameUrl, partner);
	}

	var _deletePartner = function (nameUrl){
		return $http.delete(configs.baseUrl + '/partners/' + nameUrl);
	}

	var _getPartners = function (){
		return $http.get(configs.baseUrl + '/partners');
	}

	var _getPartnersByNameUrl = function (nameUrl){
		return $http.get(configs.baseUrl + '/partners/name/url/' + nameUrl);
	}
	
    return {
    	postPartner: _postPartner,
    	putPartner: _putPartner,
    	deletePartner: _deletePartner,
    	getPartners: _getPartners,
    	getPartnersByNameUrl: _getPartnersByNameUrl
    };
	
});