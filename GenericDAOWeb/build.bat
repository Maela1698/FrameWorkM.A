jar -cf fw.jar -C .\Framework\build\web\WEB-INF\classes\ etu2025
jar -cvf test_fw.war -C .\Test-Framework\build\web\ WEB-INF\
copy test_fw.war D:\Logiciel\Apache_Software_Foundation\Tomcat_10.0\webapps\
xcopy fw.jar D:\Etude\L2\S4\INF209-Web_dynamique\project\Step_to_Framework\Test-Framework\build\web\WEB-INF\lib\
xcopy D:\Etude\L2\S4\INF209-Web_dynamique\project\Step_to_Framework\Test-Framework\build\web\WEB-INF\ D:\Logiciel\Apache_Software_Foundation\Tomcat_10.0\webapps\Framework\WEB-INF\ /E