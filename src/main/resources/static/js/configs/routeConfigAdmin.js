angular.module("pedagogiaApp").config(function ($routeProvider) {
	
	$routeProvider.when("/", {
		templateUrl: "views/admin/home.html"
	});
	
	$routeProvider.when("/topics", {
		templateUrl: "views/admin/assuntos.html",
		controller: "topicCtrl"
	});
	
	$routeProvider.when("/comments", {
		templateUrl: "views/admin/comentarios.html",
		controller: "commentCtrl"
	});
	
	$routeProvider.when("/login", {
		templateUrl: "views/admin/login.html",
		controller: "loginCtrl"
	});
	
	$routeProvider.when("/publications", {
		templateUrl: "views/admin/publicacoes.html",
		controller: "allPublicationCtrl"
	});
	
	$routeProvider.when("/publications/insert", {
		templateUrl: "views/admin/component/novaPublicacao.html",
		controller: "newPublicationCtrl"
	});
	
	$routeProvider.when("/publications/edit/:titleUrl", {
		templateUrl: "views/admin/component/editarPublicacao.html",
		controller: "onePublicationCtrl"
	});
	
	$routeProvider.when("/partners", {
		templateUrl: "views/admin/parcerias.html",
		controller: "allPartnerCtrl"
	});
	
	$routeProvider.when("/partners/insert", {
		templateUrl: "views/admin/component/novaParceria.html",
		controller: "newPartnerCtrl"
	});
	
	$routeProvider.when("/partners/edit/:nameUrl", {
		templateUrl: "views/admin/component/editarParceria.html",
		controller: "onePartnerCtrl"
	});
		
	$routeProvider.otherwise({redirectTo: "/"});
	
});