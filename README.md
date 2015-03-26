# microsoft-api-translate-java-maven-plugin
Automatically exported from code.google.com/p/microsoft-api-translate-java-maven-plugin

Fork of google-api-translate-java-maven-plugin to support Microsoft API Translator because the deprecation of the Google Translate API announced on May 26, 2011 and scheduled for permanent shutdown on December 1, 2011. 



1.- Add the google-api-translate-java-maven-plugin jar to your local maven repo:

    <dependency>

        <groupid>

        com.neodoo

        </groupid>

        <artifactid>

        microsoft-api-translate-java-maven-plugin

        </artifactid>

        <version>

        0.1-SNAPSHOT

        </version>

    </dependency>

2.- Add the microsoft-api-translate-java jar to your local maven repo.

    <dependency>

        <groupid>

        com.memetix

        </groupid>

        <artifactid>

        microsoft-translator-java-api

        </artifactid>

        <version>

        0.4-SNAPSHOT

        </version>

        <type>

        jar

        </type>

    </dependency>

3. Add the plugin to your web app pom file:

    <build>

    <plugins>

    <plugin>

        <groupid>

        com.neodoo

        </groupid>

        <artifactid>

        microsoft-api-translate-java-maven-plugin

        </artifactid>

        <inherited>

        false

        </inherited>

        <configuration>

            <apikey>

            BING_API_KEY

            </apikey>

            <debug>

            true

            </debug>

            <sourcetranslationpath>

                ${basedir}/src/main/resources/ 

            </sourcetranslationpath>

            <languagefilepattern>

                Language{0}.properties 

            </languagefilepattern>

            <sourcelanguage>

                en 

            </sourcelanguage>

            <destinationpath>

                ${project.build.directory}/classes/ 

            </destinationpath>

            <!-- ar,zh,zh-CN,zh-TW,nl,fr,de,el,it,ja,ko,pt,ru,es -->

            <targetlanguages>

                nl,fr,de,it,es 

            </targetlanguages>

        </configuration>

        <executions>

            <execution>

                <id>

                generate-projects

                </id>

                <goals>

                    <goal>

                    localize

                    </goal>

                </goals>

            </execution>

        </executions>

    </plugin>

    </plugins>

    </build>

4.- Add, if necessary, pluginRepositories:

    <pluginrepositories>

        <pluginrepository>

            <id>

            sonatype-nexus-snapshots

            </id>

            <url>

            https://oss.sonatype.org/content/repositories/snapshots

            </url>

            <snapshots>

                <enabled>

                true

                </enabled>

            </snapshots>

            <releases>

                <enabled>

                true

                </enabled>

            </releases>

        </pluginrepository>

        <pluginrepository>

            <id>

            sonatype-nexus-releases

            </id>

            <url>

            https://oss.sonatype.org/content/repositories/releases

            </url>

            <snapshots>

                <enabled>

                true

                </enabled>

            </snapshots>

            <releases>

                <enabled>

                true

                </enabled>

            </releases>

        </pluginrepository>

    </pluginrepositories>

