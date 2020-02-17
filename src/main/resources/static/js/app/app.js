var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/EmblAssignment_Vivek',
    PERSON_SERVICE_API : 'http://localhost:8080/EmblAssignment_Vivek/api/personInfo/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'PersonInfoController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, PersonInfoService) {
                        console.log('Load all persons');
                        var deferred = $q.defer();
                        PersonInfoService.loadAllPersons().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

