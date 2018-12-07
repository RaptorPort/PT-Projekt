@echo off
:start
timeout 20
start /MAX gradlew.bat
goto start