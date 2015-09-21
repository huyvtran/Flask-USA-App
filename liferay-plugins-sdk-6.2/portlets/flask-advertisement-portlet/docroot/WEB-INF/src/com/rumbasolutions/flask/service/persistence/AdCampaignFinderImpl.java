package com.rumbasolutions.flask.service.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.rumbasolutions.flask.model.AdCampaign;
public class AdCampaignFinderImpl extends BasePersistenceImpl<AdCampaign> implements AdCampaignFinder {
	
	private static Log LOGGER = LogFactoryUtil.getLog(AdCampaignFinderImpl.class);

	@Override
	public List getAdCampaginList(){
		Session session = null;
		List campaignList = null;
		try{
			session = openSession();
			StringBuilder sb = new StringBuilder();
			String sqlSelect = "  select campaignId, campaignName,  flaskads_adcustomer.customerId, " +
						" flaskads_adcustomer.customerName, displayGeneral, displayPreEvent, " +
						" displayDuringEvent, displayPostEvent, eventTypeId, frequencyPerHour, " +
						"CONCAT_WS(', ', IF(displayGeneral=1, 'General',null) , IF(displayPreEvent=1, 'Pre-Event',null) ," + 
						"IF(displayDuringEvent = 1, 'During-Event',null) , IF(displayPostEvent = 1, 'Post-Event', null)) " +
						" as 'adDisplayTime'";
			String sqlFrom = "  from flaskads_adcampaign inner join flaskads_adcustomer " + 
							" on flaskads_adcustomer.customerId = flaskads_adcampaign.customerId ";
			
			sb.append(sqlSelect);
			sb.append(sqlFrom);

			sb.append(" LIMIT 1000 ");
			SQLQuery queryObj = session.createSQLQuery(sb.toString());
			queryObj.addScalar("campaignId", Type.LONG);
			queryObj.addScalar("campaignName", Type.STRING);
			queryObj.addScalar("customerId", Type.LONG);
			queryObj.addScalar("customerName", Type.STRING);
			queryObj.addScalar("displayGeneral", Type.BOOLEAN);
			queryObj.addScalar("displayPreEvent", Type.BOOLEAN);
			queryObj.addScalar("displayDuringEvent", Type.BOOLEAN);
			queryObj.addScalar("displayPostEvent", Type.BOOLEAN);
			queryObj.addScalar("eventTypeId", Type.LONG);
			queryObj.addScalar("frequencyPerHour", Type.LONG);
			queryObj.addScalar("adDisplayTime", Type.STRING);

			queryObj.setCacheable(true);
			QueryPos qPosition = QueryPos.getInstance(queryObj);

			campaignList = queryObj.list();
		}catch(Exception e)
		{
			LOGGER.error("Exception in getAdCampaginList : "+ e.getMessage());
		}finally{
			closeSession(session);
		}
		return campaignList;
	}
	
	@Override
	public List getCampaignsForEvents(String eventList){
		Session session = null;
		List campaignList = null;
		eventList = eventList.trim();
		if(eventList.isEmpty())  return null;
		
		try{
			session = openSession();
			StringBuilder sb = new StringBuilder();
			String sqlSelect = "select  fac.campaignId, fac.campaignName, fe.eventName, fac.imageTitle 'fullScreenTitle',"
								+ " fac.imageDesc 'fullScreenDesc', fac.imageGroupId 'fullScreenGroupId', "
								+ " fac.imageUUID 'fullScreenUUID', fac.frequencyPerHour, fci.imageTitle, "
								+ " fci.imageDesc, fci.imageGroupId, fci.imageUUID ";
			
			String sqlFrom = " from flaskads_campaignevent  fce "
					+ " inner join  flaskads_adcampaign fac on  fce.campaignId = fac.campaignId "
					+ " inner join flaskevents_event fe on fe.eventId = fce.eventId "
					+ " inner join flaskads_campaignimage fci on fci.campaignId = fac.campaignId";
			String sqlWhere = " where fce.eventId in ( " + eventList + ")" ;
			
			sb.append(sqlSelect);
			sb.append(sqlFrom);
			
			if(!eventList.isEmpty()){
				sb.append(sqlWhere);
			}

			sb.append(" LIMIT 1000 ");
			SQLQuery queryObj = session.createSQLQuery(sb.toString());
			queryObj.addScalar("campaignId", Type.LONG);
			queryObj.addScalar("campaignName", Type.STRING);
			queryObj.addScalar("eventName", Type.STRING);
			queryObj.addScalar("fullScreenTitle", Type.STRING);
			queryObj.addScalar("fullScreenDesc", Type.STRING);
			queryObj.addScalar("fullScreenGroupId", Type.LONG);
			queryObj.addScalar("fullScreenUUID", Type.STRING);
			queryObj.addScalar("frequencyPerHour", Type.LONG);
			queryObj.addScalar("imageTitle", Type.STRING);
			queryObj.addScalar("imageDesc", Type.STRING);
			queryObj.addScalar("imageGroupId", Type.LONG);
			queryObj.addScalar("imageUUID", Type.STRING);

			queryObj.setCacheable(true);
			QueryPos qPosition = QueryPos.getInstance(queryObj);

			campaignList = queryObj.list();
		}catch(Exception e)
		{
			LOGGER.error("Exception in getAdCampaginList : "+ e.getMessage());
		}finally{
			closeSession(session);
		}
		return campaignList;
	}	
}
