# spring-boot-jdbc-sample

### Environment
- JDK 1.8
- SpringBoot
- MariaDB

### Required
> Build Tool
```
Build - Compiler - Enabled Annotation Processors
```

> Database
```
CREATE DATABASE IF NOT EXISTS `develop`
DEFAULT CHARACTER SET = utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

> Table
```
CREATE TABLE `User` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
```

### Default
```
http://localhost:8080 > error sample?
http://localhost:8080?eventName=xxx
```
