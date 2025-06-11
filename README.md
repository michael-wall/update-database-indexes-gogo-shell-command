**Introduction**
- Use this proof of concept OSGi module that exposes a custom Gogo shell command to manually trigger updating of the Database Indexes in a Liferay environment e.g. after deploying a new hotfix.
- This can be used in place of the following:
   - database.indexes.update.on.startup portal property
   - LIFERAY_DATABASE_PERIOD_INDEXES_PERIOD_UPDATE_PERIOD_ON_PERIOD_STARTUP environment variable
- The Gogo shell command calls IndexUpdaterUtil.updateAllIndexes();

**Usage**
- Build and deploy the custom module or add it to a Liferay Cloud workspace, trigger a Liferay PaaS build and deploy the Liferay PaaS build.
- Blacklist Component 'com.liferay.portal.security.audit.router.internal.DefaultAuditRouter'
- Confirm the module deployed as expected e.g.
```
2025-06-10 14:14:20.580 INFO  [fileinstall-directory-watcher][UpdateDatabaseIndexes:26] activated...
```
- Run the following Gogo shell command (from the Control Panel > System > Gogo Shell OR Liferay PaaS liferay service shell > telnet localhost 11311):
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
- The module has been tested in a local environment with JDK 11 and Liferay DXP 2024.q1.6.
- The command only needs to be run once in a High Availability Liferay environment.
- The command should be run after
  - A new hotfix is deployed in an environment
  - A hotfix is removed from an environment
  - An environment is reverted to an older hotfix
