var _eventModel = {};

_eventModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_EVENT 					: "/flask-rest-events-portlet.event/get-all-events",
	ADD_EVENT 					: "/flask-rest-events-portlet.event/add-event",
	ADD_EVENT_IMAGE				: "/flask-rest-events-portlet.event/add-event-image",
	UPDATE_EVENT				: "/flask-rest-events-portlet.event/update-event",
	DELETE_EVENT				: "/flask-rest-events-portlet.event/delete-event",
	DELETE_EVENTS				: "/flask-rest-events-portlet.event/delete-events",
	GET_EVENT_TYPES 			: "/flask-rest-events-portlet.eventtype/get-event-types",
	GET_INFO_TYPES 				: "/flask-rest-events-portlet.infotype/get-info-types",
	GET_INFO_CATEGORY 			: "/flask-rest-events-portlet.infotypecategory/get-info-type-categories",
	GET_ALL_VENUES	 			: "/flask-rest-events-portlet.venue/get-all-venues",
	GET_FOLDER					: "/dlapp/get-folder",
	ADD_FOLDER					: "/dlapp/add-folder"
};

_eventModel.DATA_MODEL= {
		EVENT: 
			[
			 	 { name: 'eventId', type: 'long' },
			 	 { name: 'eventName', type: 'string' },
			 	 { name: 'description', type: 'string' },
			 	 { name: 'eventDate', type: 'string' },
			 	 { name: 'startTime', type: 'string' },
			 	 { name: 'endTime', type: 'string' },
			 	 { name: 'eventTypeId', type: 'long' },
			 	 { name: 'eventTypeName', type: 'string' },
			 	 { name: 'venueId', type:'long' },
			 	 { name: 'venueName', type:'string' },
			 	 { name: 'eventImagePath', type:'string' }
			]
		};

_eventModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Event successfully added",
		SAVE: "Event successfully saved",
		ERROR: "There was an error in saving venue",
		DEL_SUCCESS: "Event successfully deleted",
		DEL_ERR: "Error in deleting Event",
 };