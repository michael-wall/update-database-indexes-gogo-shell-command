**Introduction**
- Use this proof of concept OSGi module to manually trigger updating of the Database Indexes for example after deploying a new hotfix.
- It calls IndexUpdaterUtil.updateAllIndexes();
- Build and deploy the custom module.
- Confirm it deployed e.g.
```
2025-06-10 14:14:20.580 INFO  [fileinstall-directory-watcher][UpdateDatabaseIndexes:26] activated...
```
- Run the following gogo shell command (from the Control Panel > System > Gogo Shell OR liferay service shell > telnet localhost 11311):
```
updateDatabaseIndexes:updateAllIndexes
```
- Check for the expected output in the Gogo shell:
```
calling IndexUpdaterUtil.updateAllIndexes()
called IndexUpdaterUtil.updateAllIndexes()
```
or in the Liferay service logs:

```
2025-06-10 14:08:45.693 INFO  [...][UpdateDatabaseIndexes:39] calling IndexUpdaterUtil.updateAllIndexes()
2025-06-10 14:08:45.695 INFO  [...][LoggingTimer:74] Starting com.liferay.portal.db.index.IndexUpdaterUtil#updateAllIndexes#Updating database indexes
2025-06-10 14:08:45.860 INFO  [...][LoggingTimer:35] Completed com.liferay.portal.db.index.IndexUpdaterUtil#updateAllIndexes#Updating database indexes in 164 ms
2025-06-10 14:08:45.861 INFO  [...][UpdateDatabaseIndexes:39] called IndexUpdaterUtil.updateAllIndexes()
```

**Notes**
- This is a ‘proof of concept’ that is being provided ‘as is’ without any support coverage or warranty.
- This should be tested in a non-production environment.
- The module has been tested in a local environment with JDK 11 and Liferay DXP 2024.q1.6
