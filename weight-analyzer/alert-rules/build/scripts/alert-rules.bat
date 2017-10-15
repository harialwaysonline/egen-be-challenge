@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  alert-rules startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and ALERT_RULES_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\aether-util-0.9.0.M2.jar;%APP_HOME%\lib\log4j-1.2.12.jar;%APP_HOME%\lib\logback-core-1.1.11.jar;%APP_HOME%\lib\plexus-utils-3.0.20.jar;%APP_HOME%\lib\maven-repository-metadata-3.1.1.jar;%APP_HOME%\lib\aether-impl-0.9.0.M2.jar;%APP_HOME%\lib\maven-artifact-3.1.1.jar;%APP_HOME%\lib\morphia-1.3.2.jar;%APP_HOME%\lib\spring-aop-4.3.11.RELEASE.jar;%APP_HOME%\lib\commons-beanutils-1.8.3.jar;%APP_HOME%\lib\spring-expression-4.3.11.RELEASE.jar;%APP_HOME%\lib\snakeyaml-1.17.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.25.jar;%APP_HOME%\lib\maven-project-2.0.8.jar;%APP_HOME%\lib\plexus-archiver-2.8.1.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\plexus-io-2.3.2.jar;%APP_HOME%\lib\logback-classic-1.1.11.jar;%APP_HOME%\lib\spring-boot-starter-logging-1.5.7.RELEASE.jar;%APP_HOME%\lib\maven-settings-3.1.1.jar;%APP_HOME%\lib\plexus-cipher-1.4.jar;%APP_HOME%\lib\xbean-reflect-3.4.jar;%APP_HOME%\lib\junit-4.12.jar;%APP_HOME%\lib\maven-aether-provider-3.1.1.jar;%APP_HOME%\lib\maven-settings-builder-3.1.1.jar;%APP_HOME%\lib\spring-boot-maven-plugin-1.5.7.RELEASE.jar;%APP_HOME%\lib\google-collections-1.0.jar;%APP_HOME%\lib\maven-artifact-manager-2.0.8.jar;%APP_HOME%\lib\maven-profile-2.0.8.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.25.jar;%APP_HOME%\lib\slf4j-api-1.7.25.jar;%APP_HOME%\lib\maven-plugin-api-3.1.1.jar;%APP_HOME%\lib\weight-analyzer-db-mediator-0.0.1-SNAPSHOT.jar;%APP_HOME%\lib\spring-beans-4.3.11.RELEASE.jar;%APP_HOME%\lib\spring-boot-1.5.7.RELEASE.jar;%APP_HOME%\lib\jsr305-2.0.1.jar;%APP_HOME%\lib\maven-common-artifact-filters-1.4.jar;%APP_HOME%\lib\mongo-java-driver-3.4.3.jar;%APP_HOME%\lib\maven-shared-utils-0.7.jar;%APP_HOME%\lib\commons-compress-1.9.jar;%APP_HOME%\lib\plexus-classworlds-2.5.1.jar;%APP_HOME%\lib\wagon-provider-api-1.0-beta-2.jar;%APP_HOME%\lib\maven-core-3.1.1.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.25.jar;%APP_HOME%\lib\weight-analyzer-alert-rules-0.0.1-SNAPSHOT.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\cdi-api-1.0.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\guava-10.0.1.jar;%APP_HOME%\lib\commons-logging-api-1.1.jar;%APP_HOME%\lib\cglib-nodep-2.2.2.jar;%APP_HOME%\lib\plexus-sec-dispatcher-1.3.jar;%APP_HOME%\lib\jsr250-api-1.0.jar;%APP_HOME%\lib\spring-boot-loader-tools-1.5.7.RELEASE.jar;%APP_HOME%\lib\maven-archiver-2.6.jar;%APP_HOME%\lib\spring-context-4.3.11.RELEASE.jar;%APP_HOME%\lib\plexus-container-default-1.5.5.jar;%APP_HOME%\lib\maven-model-3.1.1.jar;%APP_HOME%\lib\plexus-component-annotations-1.5.5.jar;%APP_HOME%\lib\org.eclipse.sisu.inject-0.0.0.M5.jar;%APP_HOME%\lib\spring-boot-starter-1.5.7.RELEASE.jar;%APP_HOME%\lib\maven-plugin-registry-2.0.8.jar;%APP_HOME%\lib\plexus-interpolation-1.21.jar;%APP_HOME%\lib\easy-rules-core-3.0.0.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\aether-spi-0.9.0.M2.jar;%APP_HOME%\lib\maven-model-builder-3.1.1.jar;%APP_HOME%\lib\spring-core-4.3.11.RELEASE.jar;%APP_HOME%\lib\spring-boot-autoconfigure-1.5.7.RELEASE.jar;%APP_HOME%\lib\plexus-build-api-0.0.7.jar;%APP_HOME%\lib\org.eclipse.sisu.plexus-0.0.0.M5.jar;%APP_HOME%\lib\proxytoys-1.0.jar;%APP_HOME%\lib\aether-api-0.9.0.M2.jar;%APP_HOME%\lib\sisu-guice-3.1.0-no_aop.jar

@rem Execute alert-rules
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %ALERT_RULES_OPTS%  -classpath "%CLASSPATH%" Launcher %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable ALERT_RULES_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%ALERT_RULES_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
