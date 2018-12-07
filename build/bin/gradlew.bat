@echo off
for /L %%N IN (1, 1, 10) DO CALL :loopbody %%X
GOTO :END

:loopbody
color cb
echo (%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)

color 01
echo (%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)

color f2
echo (%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)

color 58
echo (%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)

color 4f
echo (%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)(%random%) (%random%) (%random%) (%random%)
GOTO :EOF
:END
exit