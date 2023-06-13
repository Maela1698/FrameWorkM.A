
@REM jar -cvf test_fw.war -C .\Test-Framework\build\web\ .
@REM copy test_fw.war D:\Logiciel\Apache_Software_Foundation\Tomcat_10.0\webapps\


:: Cr�ation du dossier temporaire temp
mkdir temp
cd temp

:: Cr�ation de la structure du fichier
mkdir WEB-INF
mkdir src
cd WEB-INF
mkdir classes
mkdir lib
cd ../../

jar -cf fw.jar -C .\GenericDAOWeb\build\web\WEB-INF\classes\ etu1966

set tomcat_root=C:\mywebserver\apache-tomcat-10.0.20
set project_root=C:\Users\ASUS\Documents\GitHub\FrameWorkM.A\TestFramewrok
set fw_root=C:\Users\ASUS\Documents\GitHub\FrameWorkM.A\GenericDAOWeb
set lib_root=.\temp\WEB-INF\lib\fw.jar

:: Compilation du modele
copy fw.jar .\temp\WEB-INF\lib
for /r %project_root%\ %%f in (*.java) do copy %%f .\temp\src
javac -cp %lib_root% -parameters -d .\temp\WEB-INF\classes .\temp\src\*.java
::rmdir /S /Q .\temp\src


:: Copie des Autre fichiers
copy .\TestFramewrok\web\view\*.jsp .\temp\
copy .\TestFramewrok\web\WEB-INF\web.xml .\temp\WEB-INF\


:: D�ploiement vers tomcat
jar -cvf test_fw.war -C .\temp\ .
copy test_fw.war %tomcat_root%\webapps\

:: Supprimer le dossier temp
::rmdir /S /Q .\temp

