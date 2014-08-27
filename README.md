SubWhitelister
==============
A plugin for whitelisting Twitch Subscribers. Uses TwitchApps Whitelist. (http://whitelist.twitchapps.com/)

Installation
-------------
Simply drag the provided `SubWhitelister.jar` file into your `plugins/` directory and reboot your server. The configuration file will be automatically generated. 

Commands and Permissions
------------------------
| Command    | Description                                  | Permission                     |
|------------|----------------------------------------------|--------------------------------|
| /sw list   | Lists all users on the remote whitelist(s).  | subwhitelister.commands.list   |
| /sw reload | Reloads the remote whitelist(s).             | subwhitelister.commands.reload |
| /sw toggle | Enables or disables the plugin.              | subwhitelister.commands.toggle |
| N/A        | Exempts a user from the whitelist check.     | subwhitelister.exempt          |
| N/A        | Gives a user permission to use all commands. | subwhitelister.commands.*      |
| N/A        | Gives a user all permissions.                | subwhitelister.*               |
