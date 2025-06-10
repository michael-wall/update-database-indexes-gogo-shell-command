package com.mw.admin;

import com.liferay.portal.db.index.IndexUpdaterUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Michael Wall
 */
@Component(
		immediate = true,
		property = {"osgi.command.function=updateAllIndexes", "osgi.command.scope=updateDatabaseIndexes"},
		service = UpdateDatabaseIndexes.class
	)
public class UpdateDatabaseIndexes{

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		if (_log.isInfoEnabled()) _log.info("activated...");
	}

	public void updateAllIndexes() {
		
		log("calling IndexUpdaterUtil.updateAllIndexes()");
		
		IndexUpdaterUtil.updateAllIndexes();
		
		log("called IndexUpdaterUtil.updateAllIndexes()");
	}
	
	private void log(String output) {
		_log.info(output);
		System.out.println(output);	// gogo shell console output
	}	

	private static final Log _log = LogFactoryUtil.getLog(UpdateDatabaseIndexes.class);		
}