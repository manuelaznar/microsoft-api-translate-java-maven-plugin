1.- Add the google-api-translate-java-maven-plugin jar to your local maven repo:

> 

&lt;dependency&gt;


> > 

&lt;groupId&gt;

com.neodoo

&lt;/groupId&gt;


> > 

&lt;artifactId&gt;

microsoft-api-translate-java-maven-plugin

&lt;/artifactId&gt;


> > 

&lt;version&gt;

0.1-SNAPSHOT

&lt;/version&gt;



> 

&lt;/dependency&gt;



2.- Add the microsoft-api-translate-java jar to your local maven repo.

> 

&lt;dependency&gt;


> > 

&lt;groupId&gt;

com.memetix

&lt;/groupId&gt;


> > 

&lt;artifactId&gt;

microsoft-translator-java-api

&lt;/artifactId&gt;


> > 

&lt;version&gt;

0.4-SNAPSHOT

&lt;/version&gt;


> > 

&lt;type&gt;

jar

&lt;/type&gt;



> 

&lt;/dependency&gt;



3. Add the plugin to your web app pom file:

> 

&lt;build&gt;



> 

&lt;plugins&gt;



> 

&lt;plugin&gt;


> > 

&lt;groupId&gt;

com.neodoo

&lt;/groupId&gt;


> > 

&lt;artifactId&gt;

microsoft-api-translate-java-maven-plugin

&lt;/artifactId&gt;


> > 

&lt;inherited&gt;

false

&lt;/inherited&gt;


> > 

&lt;configuration&gt;


> > > 

&lt;apiKey&gt;

BING\_API\_KEY

&lt;/apiKey&gt;


> > > 

&lt;debug&gt;

true

&lt;/debug&gt;


> > > 

&lt;sourceTranslationPath&gt;


> > > > ${basedir}/src/main/resources/

> > > 

&lt;/sourceTranslationPath&gt;


> > > 

&lt;languageFilePattern&gt;


> > > > Language_{0}.properties

> > > 

&lt;/languageFilePattern&gt;


> > >_

&lt;sourceLanguage&gt;


> > > > en

> > > 

&lt;/sourceLanguage&gt;


> > > 

&lt;destinationPath&gt;


> > > > ${project.build.directory}/classes/

> > > 

&lt;/destinationPath&gt;


> > > <!--  ar,zh,zh-CN,zh-TW,nl,fr,de,el,it,ja,ko,pt,ru,es -->
> > > 

&lt;targetLanguages&gt;


> > > > nl,fr,de,it,es

> > > 

&lt;/targetLanguages&gt;



> > 

&lt;/configuration&gt;


> > 

&lt;executions&gt;


> > > 

&lt;execution&gt;


> > > > 

&lt;id&gt;

generate-projects

&lt;/id&gt;


> > > > 

&lt;goals&gt;


> > > > > 

&lt;goal&gt;

localize

&lt;/goal&gt;



> > > > 

&lt;/goals&gt;



> > > 

&lt;/execution&gt;



> > 

&lt;/executions&gt;



> 

&lt;/plugin&gt;



> 

&lt;/plugins&gt;



> 

&lt;/build&gt;



4.- Add, if necessary, pluginRepositories:

> 

&lt;pluginRepositories&gt;


> > 

&lt;pluginRepository&gt;


> > > 

&lt;id&gt;

sonatype-nexus-snapshots

&lt;/id&gt;


> > > 

&lt;url&gt;

https://oss.sonatype.org/content/repositories/snapshots

&lt;/url&gt;


> > > 

&lt;snapshots&gt;


> > > > 

&lt;enabled&gt;

true

&lt;/enabled&gt;



> > > 

&lt;/snapshots&gt;


> > > 

&lt;releases&gt;


> > > > 

&lt;enabled&gt;

true

&lt;/enabled&gt;



> > > 

&lt;/releases&gt;



> > 

&lt;/pluginRepository&gt;


> > 

&lt;pluginRepository&gt;


> > > 

&lt;id&gt;

sonatype-nexus-releases

&lt;/id&gt;


> > > 

&lt;url&gt;

https://oss.sonatype.org/content/repositories/releases

&lt;/url&gt;


> > > 

&lt;snapshots&gt;


> > > > 

&lt;enabled&gt;

true

&lt;/enabled&gt;



> > > 

&lt;/snapshots&gt;


> > > 

&lt;releases&gt;


> > > > 

&lt;enabled&gt;

true

&lt;/enabled&gt;



> > > 

&lt;/releases&gt;



> > 

&lt;/pluginRepository&gt;



> 

&lt;/pluginRepositories&gt;

