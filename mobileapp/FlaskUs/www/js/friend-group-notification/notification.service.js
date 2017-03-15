(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('FriendsNotificationService', FriendsNotificationService);

    FriendsNotificationService.$inject = ['$http', 'SERVER', '$q'];

    function FriendsNotificationService($http, SERVER, $q) {
        var services = {
            getNotificationCount: getNotificationCount,
            getTotalUnreadMessagesCount: getTotalUnreadMessagesCount,
            getTotalUnreadGroupMessagesCount:getTotalUnreadGroupMessagesCount,
            getMyAllMessages: getMyAllMessages,
            deleteMessageById: deleteMessageById,
            getRequestToConfirm: getRequestToConfirm,
            getUserById: getUserById,
            addSocialRelation: addSocialRelation,
            deleteRequest: deleteRequest,
            setReadMessage: setReadMessage,
            sendMessage: sendMessage,
            getAllGroups: getAllGroups,
            getMyFriends: getMyFriends,
            getMyUnreadFlaskMessagesCount: getMyUnreadFlaskMessagesCount,
            getAllMyFlaskGroupMessages: getAllMyFlaskGroupMessages,
            sendFlaskGroupMessage: sendFlaskGroupMessage
        }
        var getMyNotificationCountUrl = "/flask-social-portlet.entry/get-requests-count"
        var getTotalUnreadMessagesCountUrl = "/flask-social-portlet.flaskmessages/get-total-unread-messages-count";
        var getTotalUnreadGroupMessagesCountUrl = "/flask-social-portlet.flaskgroupmessages/get-total-unread-group-messages-count";
        var getMyUnreadFlaskMessagesCountUrl = "flask-social-portlet.flaskmessages/get-my-unread-flask-messages-count";
        var getMyAllMessageUrl = "/flask-social-portlet.flaskmessages/get-all-my-flask-messages";
        var deleteMessageUrl = "/flask-social-portlet.flaskmessages/delete-message";
        var getRequestUrl = "/flask-social-portlet.entry/get-requests-to-confirm";
        var getUserByIdUrl = "/flask-social-portlet.entry/get-user-by-id";
        var addSocialRelationUrl = "/flask-social-portlet.entry/add-social-relation";
        var deleteSocialRelationUrl = "/flask-social-portlet.entry/delete-request";
        var sendFlaskMessage = "/flask-social-portlet.flaskmessages/send-flask-message";
        var setMessageReadUrl = "/flask-social-portlet.flaskrecipients/set-read";
        var getUnreadMessagesURL = "/flask-social-portlet.flaskmessages/get-my-unread-flask-messages";
        var searchMyFriend = "/flask-social-portlet.entry/search-my-friends";
        var getAllGroupsURL = "/flask-manage-user-group-portlet.flaskgroup/get-all-my-groups";
        var getAllMyFlaskGroupMessagesUrl = "/flask-social-portlet.flaskgroupmessages/get-all-my-flask-group-messages";
        var sendFlaskGroupMessageUrl = "/flask-social-portlet.flaskgroupmessages/send-flask-group-message";
        var companyId = SERVER.companyId;

        function getMyFriends(searchText) {
            return $http.get(SERVER.url + searchMyFriend, {
                params: {
                    companyId: companyId,
                    keywords: searchText
                }
            })
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getNotificationCount() {
            return $http.get(SERVER.url + getMyNotificationCountUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //get global count for user
        function getTotalUnreadMessagesCount() {
            return $http.get(SERVER.url + getTotalUnreadMessagesCountUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //get global count for group
        function getTotalUnreadGroupMessagesCount() {
            return $http.get(SERVER.url + getTotalUnreadGroupMessagesCountUrl)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //get count per user
        function getMyUnreadFlaskMessagesCount(receiverId) {
            return $http.get(SERVER.url + getMyUnreadFlaskMessagesCountUrl, {
                params: {
                    receiverId: receiverId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getMyAllMessages(receiverId) {
            return $http.get(SERVER.url + getMyAllMessageUrl, {
                params: {
                    receiverId: receiverId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //get group messages
        function getAllMyFlaskGroupMessages(groupId) {
            return $http.get(SERVER.url + getAllMyFlaskGroupMessagesUrl, {
                params: {
                    groupId: groupId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteMessageById(messageId) {
            return $http.get(SERVER.url + deleteMessageUrl, {
                params: {
                    messageId: messageId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getRequestToConfirm() {
            return $http.get(SERVER.url + getRequestUrl, {
                params: {
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getUserById(userId) {
            return $http.get(SERVER.url + getUserByIdUrl, {
                params: {
                    userId: userId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function addSocialRelation(receiverUserId) {
            return $http.get(SERVER.url + addSocialRelationUrl, {
                params:
                { receiverUserId: receiverUserId }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteRequest(receiverUserId) {
            return $http.get(SERVER.url + deleteSocialRelationUrl, {
                params:
                { receiverUserId: receiverUserId }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function setReadMessage(messageId) {
            return $http.get(SERVER.url + setMessageReadUrl, {
                params:
            { messageId: messageId }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        };
        function sendMessage(userId, messgae) {
            return $http.get(SERVER.url + sendFlaskMessage, {
                params: {
                    recipients: userId,
                    message: messgae,
                    sendEmail: true
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //send message to group
        function sendFlaskGroupMessage(groupId, messgae) {
            return $http.get(SERVER.url + sendFlaskGroupMessageUrl, {
                params: {
                    groupId: groupId,
                    message: messgae,
                    sendEmail: true
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getAllUnreadMessages() {
            return $http.get(SERVER.url + getUnreadMessagesURL)
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        //get all user groups
        function getAllGroups(userId) {
            return $http.get(SERVER.url + getAllGroupsURL, {
                params: {
                    "userId": userId
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        //search my friends
        function getMyFriends(searchText) {
            return $http.get(SERVER.url + searchMyFriend, {
                params: {
                    companyId: companyId,
                    keywords: searchText
                }
            })
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        return services;
    }
})();