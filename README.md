# HAWKS commons (Personal repo)

## Steps to Setup

**1. Clone the application**

```
$  git clone  https://github.com/HawksBay-Group-LLC/hawksbay-commons.git
```

**2. Build project using Maven**

```
$ mvn clean install -DskipTests
```

**3. Deploy jar to github**

```
$ mvn deploy 
```

```
 It will deploy the jar in repo name which we have mentioned in pom.xml file under outputDirectory
 Please mention specific version and repo
```