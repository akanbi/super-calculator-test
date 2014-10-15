Projeto de testes funcionais para Android usando uiautomator.

Exemplo da palestra do TCD 2014.


COMANDOS
--------

(Substituir "C:/AndroidSDK/sdk" pelo caminho de instalação do Android SDK)

Build:
ant build

Install:
C:/AndroidSDK/sdk/platform-tools/adb push bin/SuperCalculatorTest.jar /data/local/tmp/

Run:
C:/AndroidSDK/sdk/platform-tools/adb shell uiautomator runtest SuperCalculatorTest.jar -c ,

Inspect:
C:/AndroidSDK/sdk/tools/uiautomatorviewer.bat
