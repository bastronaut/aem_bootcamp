# Bootcamp project based on AEM template

This is the Deloitte Adobe Bootcamp projected for AEM. It is based on the AEM-project Maven Archetype 11.

## Modules

The main parts of the template are:

* core: Java bundle containing all core functionality like OSGi services, listeners or schedulers, as well as component-related Java code such as servlets or request filters.
* ui.apps: contains the /apps (and /etc) parts of the project, ie JS&CSS clientlibs, components, templates, runmode specific configs as well as Hobbes-tests
* ui.content: contains sample content using the components from the ui.apps
* ui.tests: Java bundle containing JUnit tests that are executed server-side. This bundle is not to be deployed onto production.

## How to build

It is recommended to install the full bundle - including the content - on first run. If you have a running AEM instance you can build and package the whole project and deploy into AEM with

    mvn clean install -PautoInstallPackage
    
Or to deploy it to a publish instance, run

    mvn clean install -PautoInstallPackagePublish
    
Or to deploy only the bundle to the author, run

    mvn clean install -PautoInstallBundle

Or to deploy only the content package to author, run the following in the ui.content folder

    mvn clean install -PAutoInstallPackageContent

Or to deploy only the content package to publish, run the following in the ui.content folder

    mvn clean install -PAutoInstallPackageContentPublish

To build all the modules run in the project root directory the following command with Maven 3 without pushing to your AEM instance:

    mvn clean install

## Testing

There are some testing remnants from the Project Archetype that remain for educational purposes. However, these have not been extended and are not guaranteed to be fully funtional.

* unit test in core: this show-cases classic unit testing of the code contained in the bundle. To test, execute:

    mvn clean test

* server-side integration tests: this allows to run unit-like tests in the AEM-environment, ie on the AEM server. To test, execute:

    mvn clean integration-test -PintegrationTests

* client-side Hobbes.js tests: JavaScript-based browser-side tests that verify browser-side behavior. To test:

    in the browser, open the page in 'Developer mode', open the left panel and switch to the 'Tests' tab and find the generated 'MyName Tests' and run them.


## Maven settings

The project comes with the auto-public repository configured. To setup the repository in your Maven settings, refer to:

    http://helpx.adobe.com/experience-manager/kb/SetUpTheAdobeMavenRepository.html

