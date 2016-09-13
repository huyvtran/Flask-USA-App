﻿(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('TailgateService', TailgateService);

    TailgateService.$inject = ['$http', 'SERVER', '$q'];

    function TailgateService($http, SERVER, $q) {
        var baseURL = SERVER.url;
        var allTailgateURL = "flask-user-tailgate-portlet.tailgateinfo/add-tailgate-info";
        var myTailgatesURL = "flask-user-tailgate-portlet.tailgateinfo/get-all-my-tailgate";
        var getTailgateImagesURL = "flask-user-tailgate-portlet.tailgateimages/get-tailgate-images";
        var getTailGateURL = "flask-user-tailgate-portlet.tailgateinfo/get-tailgate";
        var geteventURL = "flask-rest-events-portlet.event/get-event";
        var getTalgetUsersURL = "flask-user-tailgate-portlet.tailgateusers/get-tailgate-members";
        var addtailgateUserURL = "flask-user-tailgate-portlet.tailgateusers/add-tailgate-user";
        var getVenuebyVenueIdURL = "flask-rest-events-portlet.venue/get-venue";
        var getAllEventsURL = "flask-rest-events-portlet.event/get-all-events";
        var getmapMarkersURL = "flask-user-tailgate-portlet.tailgatemarker/get-tailgate-marker";
        var addTialgateMarkerURL = "flask-user-tailgate-portlet.tailgatemarker/add-tailgate-marker";
        var inviteFriendsTailgateURL = "flask-social-portlet.entry/search-my-friends";
        var addMessageBoardURL = "flask-user-tailgate-portlet.tailgatemessageboard/add-message-board";
        var getmessageBoardsByTailgateIdURL = "flask-user-tailgate-portlet.tailgatemessageboard/get-message-boards-by-tailgate-id";
        var getUserByIdURL = "flask-rest-users-portlet.flaskadmin/get-user-by-id";
        var getFilteredEventsURL = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var deleteTailgateInfoURL = "flask-user-tailgate-portlet.tailgateinfo/delete-tailgate-info";
        var deleteTailgateMarkerURL = "flask-user-tailgate-portlet.tailgatemarker/delete-tailgate-marker";
        var deleteTailgateUserIdURL = "flask-user-tailgate-portlet.tailgateusers/delete-tailgate-user";


        var tailgateServices = {
            getEvent: getEvent,
            getAllTailgate: getAllTailgate,
            getMyTailgates: getMyTailgates,
            getTailgate: getTailgate,
            getMyTailgateImages: getMyTailgateImages,
            getMyTailgateUsers: getMyTailgateUsers,
            addTailgate: addTailgate,
            getallEvents: getallEvents,
            getMapMarkers: getMapMarkers,
            addTailgateMarkers: addTailgateMarkers,
            getUserFrends: getUserFrends,
            addcurrentUser: addcurrentUser,
            getvenueDetails: getvenueDetails,
            saveMessage: saveMessage,
            getAllMessages: getAllMessages,
            getAllUser: getAllUser,
            getallFilteredEvents: getallFilteredEvents,
            deleteMapMarkers: deleteMapMarkers,
            deleteTailgate: deleteTailgate
        }

        function getallFilteredEvents(tailgateParams) {
            return $http.get(baseURL + getFilteredEventsURL, {
                params: tailgateParams
            }
            )
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }
        function getvenueDetails(venueId) {
            return $http.get(baseURL + getVenuebyVenueIdURL, {
                params: { 'venueId': venueId }
            }
            )
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function addTailgate(currTailgateparams) {
            return $http.get(baseURL + allTailgateURL, {
                params: currTailgateparams
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }
        function deleteTailgate(tailgateId) {
            return $http.get(baseURL + deleteTailgateInfoURL, {
                params: {'tailgateId' : tailgateId}
            }
            )
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                //add errror handling 
            });
        }
        function getUserFrends() {
            return $http.get(baseURL + inviteFriendsTailgateURL, {
                params: {
                    companyId: SERVER.companyId,
                    keywords: ''
                }
            })
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }
        function getEvent(eventId) {
            return $http.get(baseURL + geteventURL, {
                params: { 'eventId': eventId }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getMapMarkers(tailgateId) {
            return $http.get(baseURL + getmapMarkersURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }
        function deleteMapMarkers(tailgateId) {
            return $http.get(baseURL + deleteTailgateUserIdURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getallEvents() {
            return $http.get(baseURL + getAllEventsURL
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }
        function addcurrentUser(user) {
            return $http.get(baseURL + addtailgateUserURL, {
                params: user
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getAllTailgate() {
            return $http.get(baseURL + allTailgateURL)
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getMyTailgates(uId) {
            return $http.get(baseURL + myTailgatesURL, {
                params: { 'userId': uId }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }
        function getTailgate(tailgateId) {
            return $http.get(baseURL + getTailGateURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getMyTailgateImages(tailgateId) {
            return $http.get(baseURL + getTailgateImagesURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getMyTailgateUsers(tailgateId) {
            return $http.get(baseURL + getTalgetUsersURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }


        function addTailgateMarkers(param) {
            return $http.get(baseURL + addTialgateMarkerURL, {
                params: {
                    'tailgateId': param.tailgateId,
                    'latitude': param.lattitude,
                    'longitude': param.longitude,
                    'name': param.name,
                    'description': param.description
                }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getAllMessages(tailgateId) {
            return $http.get(baseURL + getmessageBoardsByTailgateIdURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling 
                });
        }

        function saveMessage(msgtxt, tailgateId) {
            return $http.get(baseURL + addMessageBoardURL, {
                params: {
                    'messageText': msgtxt,
                    'tailgateId':tailgateId
                }
            })
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getAllUser(userId) {
            return $http.get(baseURL + getUserByIdURL, {
                params: { 'userId': userId }
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        return tailgateServices;
    }
})();


