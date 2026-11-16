@echo off
setlocal EnableDelayedExpansion
cd /d "%~dp0"
set "POO_BUILD=build\exec-%RANDOM%-%RANDOM%"
mkdir "%POO_BUILD%"
(
  for /r "src" %%f in (*.java) do if /I not "%%~nxf"=="TesteDeProgresso.java" (
    set "POO_FILE=%%f"
    echo "!POO_FILE:\=/!"
  )
  for /r "testes" %%f in (*.java) do if /I not "%%~nxf"=="TesteDeProgresso.java" (
    set "POO_FILE=%%f"
    echo "!POO_FILE:\=/!"
  )
) > "%POO_BUILD%\fontes.txt"
javac --release 21 -encoding UTF-8 -d "%POO_BUILD%\classes" @"%POO_BUILD%\fontes.txt"
if errorlevel 1 exit /b 1
java -cp "%POO_BUILD%\classes" VerificarAula
exit /b %ERRORLEVEL%
