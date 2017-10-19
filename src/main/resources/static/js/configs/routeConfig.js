angular.module("queroEventoApp").config(function ($routeProvider) {
	
	$routeProvider.when("/", {
		templateUrl: "views/index/home.html",
		controller: "eventCtrl"
	});

	$routeProvider.when("/topic/:urlName", {
		templateUrl: "views/index/publicacoesPorAssunto.html",
		controller: "eventByCategoryCtrl"
	});

	$routeProvider.when("/publication/title/:urlTitle", {
		templateUrl: "views/index/publicacao.html",
		controller: "eventByUrlTitleCtrl"
	});
	
	$routeProvider.when("/publication/search", {
		templateUrl: "views/index/buscaPublicacao.html",
	});
		
	$routeProvider.otherwise({redirectTo: "/"});
	
});