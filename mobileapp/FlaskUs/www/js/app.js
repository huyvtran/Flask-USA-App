(function () {
    var app = angular.module('flaskApp'); 
    app.run(function ($ionicPlatform, $rootScope, $ionicLoading, $ionicPopup, $cookies) {
        $ionicPlatform.ready(function () {
            // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
            // for form inputs)
            if (cordova.platformId === 'ios' && window.cordova && window.cordova.plugins.Keyboard) {
                cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
                cordova.plugins.Keyboard.disableScroll(true);
            }
            if (window.StatusBar) {
                // org.apache.cordova.statusbar required
                StatusBar.styleDefault();
            }

            $rootScope.$on('loading:show', function () {
                $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' })
            })

            $rootScope.$on('loading:hide', function () {
                $ionicLoading.hide()
            })
            // Gelocation On ionic ready
            navigator.geolocation.getCurrentPosition(
                function (position) {
                    //when Success
                    $cookies.putObject('user_location_data', position);
                    var GetMyObj = $cookies.getObject('user_location_data');
                    console.log(GetMyObj);
                },
                function errorCallback(error) {
                    //when Error
                    $cookies.putObject('user_location_data', error);
                }
            );
            // Check for network connection
            if (window.Connection) {
                if (navigator.connection.type == Connection.NONE) {
                    $ionicPopup.alert({
                        title: 'No Internet Connection',
                        content: 'There is no internet connection. Only some part of aplication will work'
                    });
                }
            }
        }, false);
    });

   document.addEventListener("deviceready", function () {
   })
})();