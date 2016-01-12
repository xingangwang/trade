@echo on

rem ====================================
set JAVA_HOME=C:\Java\jdk1.7.0_10


rem ====================================
set path=%JAVA_HOME%\bin;%path%


rem ====================================

::set CLASSPATH=%CLASSPATH%;plugins/mbg/mybatis-generator-core-1.3.2.jar;plugins/mbg/mybatis-generator-core-atme-plugins-0.0.1-SNAPSHOT.jar

rem %classpath%

rem ====================================
rem MyBatisGenerator

java -cp plugins/mbg/mybatis-generator-core-1.3.2.jar;plugins/mbg/mybatis-generator-core-atme-plugins-0.0.1-SNAPSHOT.jar org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite