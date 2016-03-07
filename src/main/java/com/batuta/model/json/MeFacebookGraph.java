package com.batuta.model.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeFacebookGraph {

	private String id;
	private String first_name;
	private String gender;
	private String last_name;
	private String link;
	private String locale;
	private String name;
	private String timezone;
	private String updated_time;
	private String verified;
//	{
//		   "id": "653647894734682",
//		   "first_name": "Michele E Marcelo",
//		   "gender": "female",
//		   "last_name": "Ziglioli",
//		   "link": "https://www.facebook.com/app_scoped_user_id/653647894734682/",
//		   "locale": "pt_BR",
//		   "name": "Michele E Marcelo Ziglioli",
//		   "timezone": -3,
//		   "updated_time": "2015-10-15T03:15:24+0000",
//		   "verified": true
//		}
}
