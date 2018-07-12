# Spring Boot Springfox custom json at swagger-ui
This microservice manages the cars data

## Configuration
* Install [Lombok](https://projectlombok.org/) to erase repetitive code. This is mostly for the IDE.
* Configure PostgreSQL database:
	* Install PostgreSQL: `sudo apt-get install postgresql postgresql-contrib`
	* Create database: `sudo -u postgres createdb <dbname>`
	* Create user: `sudo -u postgres createuser <username>`
	* Access to postgres: `sudo -u postgres psql`
	* Giving the user a password: `alter user <username> with encrypted password '<password>';`
	* Granting privileges on database: `grant all privileges on database <dbname> to <username>;`
* To use the liquibase maven plugin, you have to
	* At `src/main/resources/liquibase/liquibase.properties` change DATABASE_NAME, DATABASE_USER, DATABASE_PASSWORD with properly values

## Run the microservice
* Using maven: `mvn clean spring-boot:run`
* You can see your app running at [http://localhost:8081/](http://localhost:8081/)

