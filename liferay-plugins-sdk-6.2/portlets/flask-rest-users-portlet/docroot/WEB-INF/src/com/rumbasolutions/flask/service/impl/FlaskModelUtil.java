package com.rumbasolutions.flask.service.impl;

import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.theme.ThemeDisplay;
import com.rumbasolutions.flask.model.FlaskAdmin;
import com.rumbasolutions.flask.model.FlaskRole;
import com.rumbasolutions.flask.model.impl.FlaskAdminImpl;
import com.rumbasolutions.flask.model.impl.FlaskRoleImpl;

public class FlaskModelUtil {

	public static final String FLASK_ADMIN =  "Flask Admin";
	public static final String LIFERAY_ADMIN=  "Administrator";
	public static final String FLASK_CONTENT_ADMIN=  "Flask Content Manager";
	public static final String FLASK_USER=  "User";
	public static final String USA_COUNTRY_NAME= "United States";
	public static final String MOBILE_PHONE_TYPE= "mobile";
	private static final String PERSONAL_ADDR_TYPE = "personal";
	private static Log LOGGER = LogFactoryUtil.getLog(FlaskModelUtil.class);
	
	public enum FlaskRoleEnum{
		FLASK_ADMIN   ("Flask Admin"),
		FLASK_CONTENT_ADMIN ("Flask Content Manager"),
		FLASK_USER  ("User");
		
		private final String roleName;
		FlaskRoleEnum(String roleName){
			this.roleName = roleName;
		}
		public String getRoleName(){
			return roleName;
		}
		
	}
	public static FlaskAdmin getFlaskAdmin(User user, ServiceContext serviceContext) {
		
		FlaskAdmin admin = new FlaskAdminImpl(); 
		
		try {
			admin.setUserId(user.getUserId()); 
			admin.setFirstName(user.getFirstName()); 
			admin.setLastName(user.getLastName());
			admin.setMiddleName(user.getMiddleName());
			admin.setEmail(user.getEmailAddress());
			admin.setScreenName(user.getScreenName());
			Contact userContact = user.getContact();
			
			admin.setMobileNumber(getPhoneNumber(user));
			
			List<Address> addrList = AddressLocalServiceUtil.getAddresses(user.getCompanyId(),
					Contact.class.getName(),
					userContact.getClassPK()) ;
			if( addrList.size() > 0){
				Address addr = addrList.get(0);
				admin.setAptNo(addr.getStreet1());
				admin.setStreetName(addr.getStreet2());
				admin.setState(addr.getRegion().getName());			
				admin.setCity(addr.getCity());
				admin.setCountry(addr.getCountry().getName());
				admin.setAreaCode(addr.getZip());			
			}
			ThemeDisplay theme = serviceContext.getThemeDisplay();
			if(theme !=null){
				String porttraitURL = theme.getPortalURL() == null ? "" : theme.getPortalURL();
				admin.setPortraitURL(porttraitURL);
			}
			admin.setIsMale(user.isMale());
		} catch (Exception e) {
			LOGGER.error("Exception in getFlaskAdmin " + e.getMessage());
		} 
		return admin;
	}

	private static String getPhoneNumber(User user){
		String phoneNo="";
		try {
			 List<Phone> phoneList = PhoneLocalServiceUtil.getPhones(user.getCompanyId(), Contact.class.getName(),
				     user.getContact().getClassPK());
			 
			if(phoneList.size() > 0){
				phoneNo = phoneList.get(0).getNumber();
			}
		} catch (Exception e) {
			LOGGER.error("getPhoneNumber:" + e.getMessage());
		}
		return phoneNo;
	}
	
	public static FlaskRole getFlaskRole(Role role){

		FlaskRole fRole = new FlaskRoleImpl(); 
		fRole.setRoleId(role.getRoleId()); 
		fRole.setRoleName(role.getName());
		fRole.setRoleDesc(role.getDescription());
		return fRole;
	}
	
	public static  ServiceContext getServiceContext(){
		
		return ServiceContextThreadLocal.getServiceContext();
	}
	
	public static int getPersonalAddressId(){
		int id=0;
		 try {
			List<ListType> addressTypes = ListTypeServiceUtil.getListTypes(Contact.class.getName()+ ListTypeConstants.ADDRESS); 
				
			for(ListType lt : addressTypes){
				if(lt.getName().toLowerCase().contains(PERSONAL_ADDR_TYPE)){
					id  = lt.getListTypeId();
					break;
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error in getPersonalAddressId" + e.getMessage());
		}
		return id;	
	}
	
	public static int getMobilePhoneTypeId(){
		int id=0;
		 try {
			 
			List<ListType> phoneTypes = ListTypeServiceUtil
			    	      .getListTypes(Contact.class.getName()
			    	        + ListTypeConstants.PHONE);
	
			for(ListType lt : phoneTypes){
				if(lt.getName().toLowerCase().contains(MOBILE_PHONE_TYPE)){
					id  = lt.getListTypeId();
					break;
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error in getPersonalAddressId:" + e.getMessage());
		}
		return id;	
	}

	public static long getCountryId(String countryName) {
		long countryId =19;
		if(countryName == null || countryName.isEmpty())
			countryName = USA_COUNTRY_NAME;
		 try {
			Country country = CountryServiceUtil.getCountryByName(USA_COUNTRY_NAME);
			countryId = country.getCountryId();
		} catch (Exception e) {
			LOGGER.error("Exception in get countryID " + e.getMessage());;
		} 
		 return countryId;
	}
	
	
	
}