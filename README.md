# Shopping Cart

Java JSP/Servlet shopping-cart application packaged as a Maven WAR and deployed to Apache Tomcat. MySQL stores products, users, carts, orders, and transactions.

This project does not include a Dockerfile, Compose file, or CI/CD workflow. The supported run path in this repository is:

```text
MySQL 8 -> application.properties -> Maven WAR -> Apache Tomcat -> browser
```

## Repository Layout

```text
src/                          Java source and runtime configuration
WebContent/                   JSP pages, static assets, and WEB-INF/web.xml
databases/mysql_query.sql     Schema and demo data
pom.xml                       Maven WAR build definition
```

## Compatibility

Use the following runtime versions for predictable builds:

- JDK 8 or newer with Java 8 source/target support
- Maven 3.8 or newer
- MySQL 8.x
- Apache Tomcat 9.x or another Tomcat runtime compatible with `javax.servlet-api` 3.1

Tomcat 10+ uses the Jakarta Servlet namespace and is not the default choice for this application because the project depends on `javax.servlet`. Confirm the selected Tomcat version before deployment.

Verify the tools:

```bash
java -version
mvn -version
mysql --version
```

## Configuration

Runtime settings are stored in `src/application.properties` and are packaged into the WAR. Before building, set values appropriate for the target environment:

```properties
db.driverName=com.mysql.cj.jdbc.Driver
db.connectionString=jdbc:mysql://DB_HOST:3306/shopping-cart
db.username=DB_USER
db.password=DB_PASSWORD
mailer.email=MAILBOX
mailer.password=MAIL_APP_PASSWORD
```

The mail settings are only needed for email notification features. Do not commit production passwords or app passwords. For production, use a deployment-time configuration strategy or a protected build workspace rather than storing secrets in source control.

The current application reads `application.properties` from the classpath, so changing database settings requires rebuilding and redeploying the WAR.

## Database Setup

Create a dedicated MySQL user for the application instead of using `root` in a deployed environment. From the project directory, create the database and sample data:

```bash
mysql -u root -p < databases/mysql_query.sql
```

The script creates the `shopping-cart` schema, tables, products, a sample order, and demo users. It contains `DROP TABLE` statements, so treat it as an initialisation script and do not run it against an existing environment without a backup and an explicit data-loss review.

For a non-local database, make sure the MySQL account can connect from the Tomcat host and that the database firewall allows access on port `3306`.

Check that the schema is available:

```bash
mysql -u DB_USER -p -e "USE \`shopping-cart\`; SHOW TABLES;"
```

## Build the WAR

Run from the repository root:

```bash
mvn clean package
```

The build artifact is:

```text
target/shopping-cart.war
```

The Maven build compiles Java with source and target level 1.8 and includes the `WebContent` directory as the WAR web root. A successful build is the first deployment check.

## Run With Tomcat

Copy the WAR into Tomcat's deployment directory:

```bash
cp target/shopping-cart.war /path/to/tomcat/webapps/
```

Start Tomcat:

```bash
/path/to/tomcat/bin/startup.sh
```

Tomcat normally deploys the application using the WAR filename as its context path. Open:

```text
http://TOMCAT_HOST:8080/shopping-cart/
```

For a server deployment, place a reverse proxy or load balancer in front of Tomcat for TLS termination. Keep Tomcat and MySQL private to the application network where possible, and expose only the proxy's required ports.

## Smoke Checks

Check that Tomcat is listening:

```bash
ss -ltnp | grep 8080
```

Check the application response:

```bash
curl -I http://127.0.0.1:8080/shopping-cart/
```

Check deployment and application logs:

```bash
tail -f /path/to/tomcat/logs/catalina.out
ls -lt /path/to/tomcat/logs/
```

A successful smoke test should return an HTTP response from the application and show no database connection errors in the Tomcat logs.

## Demo Accounts

The SQL seed data includes these accounts:

```text
Admin: admin@gmail.com / admin
User:  guest@gmail.com / guest
```

They are demonstration credentials with plaintext passwords in the seed script. Do not use them in a real environment. Replace or remove seeded accounts before production use.

## Deploying an Update

Build a new artifact, stop or undeploy the current application according to the team's change procedure, then replace the WAR:

```bash
mvn clean package
cp target/shopping-cart.war /path/to/tomcat/webapps/
```

For a controlled deployment, keep the previous WAR and database backup until the new version passes smoke checks. Monitor Tomcat logs after deployment and verify login, product browsing, cart actions, and order creation.

## Rollback

Keep the last known-good WAR outside Tomcat's `webapps` directory. To roll back:

```bash
/path/to/tomcat/bin/shutdown.sh
cp /path/to/releases/shopping-cart-known-good.war /path/to/tomcat/webapps/shopping-cart.war
/path/to/tomcat/bin/startup.sh
```

If the release changed database structure or data, restore the corresponding MySQL backup according to the database recovery procedure. The repository does not provide migrations or automated rollback scripts.

## Stop Tomcat

```bash
/path/to/tomcat/bin/shutdown.sh
```

If Tomcat does not stop cleanly, inspect the process and logs before terminating it:

```bash
ps -ef | grep '[o]rg.apache.catalina.startup.Bootstrap'
tail -n 100 /path/to/tomcat/logs/catalina.out
```

## Operational Notes

- The application has no dedicated health endpoint. Use the context URL, Tomcat status, logs, and a database connectivity check for monitoring.
- Back up MySQL before running `databases/mysql_query.sql` or deploying changes that may affect persisted data.
- Back up the database separately from the WAR and Tomcat installation.
- Store credentials outside Git and restrict file permissions on configuration and deployment files.
- The application uses server-side JSP/Servlet rendering; there is no separate frontend build or Node.js runtime.
