<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
        <link href="css/hobbies.css" rel="stylesheet"/>
        <link href="fontawesome-free-5.12.1-web/css/fontawesome.css" rel="stylesheet"/>
        <link href="fontawesome-free-5.12.1-web/css/solid.css" rel="stylesheet"/>

    </head>
    <body>

        <div ui-view></div>
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
         
        <script src="js/app/app.js"></script>
        <script src="js/app/PersonInfoService.js"></script>
        <script src="js/app/PersonInfoController.js"></script>
    </body>
</html>