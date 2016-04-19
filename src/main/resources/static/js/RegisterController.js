/**
 * Created by Monika on 2016-04-13.
 */
(function () {
    "use strict";
    angular.module("ngClassifieds")
        .controller("RegisterController", function ($scope, $http) {
            $scope.user =
            {
                name: "",
                surname: "",
                email: "",
                password: "",
                repasswd: "",
            };

            $scope.message = {
                text: "Please, fill the form to register."
            };
            $scope.registerFunction = function () {
                console.info("elo");
                console.info($scope.user);

                if ($scope.user.password === $scope.user.repasswd) {
                    console.info("Congrats");
                    var ajax = $http.post('/register/newUser', $scope.user);                    //send using AJAX
                    ajax.success(function (data) {
                        $scope.message.text = 'Great job. You are registered now.';

                    });

                }
                else {
                    console.error("Passwords are not equal");
                    $scope.message.text = 'Passwords are not equal.';

                }
            }
        });
})();