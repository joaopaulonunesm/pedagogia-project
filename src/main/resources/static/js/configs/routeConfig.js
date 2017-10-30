angular.module("pedagogiaApp").config(function ($routeProvider) {
	
	$routeProvider.when("/", {
		templateUrl: "views/index/home.html",
		controller: "allPublicationCtrl"
	});

	$routeProvider.when("/topic/:nameUrl", {
		templateUrl: "views/index/publicacoesPorAssunto.html",
		controller: "publicationByTopicCtrl"
	});

	$routeProvider.when("/publication/title/:titleUrl", {
		templateUrl: "views/index/publicacao.html",
		controller: "onePublicationCtrl"
	});
	
	$routeProvider.when("/publication/search", {
		templateUrl: "views/index/buscaPublicacao.html"
	});
	
	$routeProvider.when("/partner/:nameUrl", {
		templateUrl: "views/index/parceiro.html",
		controller: "onePartnerCtrl"
	});
		
	$routeProvider.otherwise({redirectTo: "/"});
	
});