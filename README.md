# Állásjelentkezési API

Ez az alkalmazás egy álláshirdetés és ügyfélregisztrációs szolgáltatást valósit meg, amely Spring Boot hazsnálatával készült.

## Követelmények

- Java 11
- Maven
- H2 adatbázis (memóriában)

## Konfiguráció

1. Klónozd a tárolót.
2. Navigálj a projekt könyvtárába.

## Az alkalmazás futtatása

bash: 
`./mvnw spring-boot:run `

## A tovább fejlesztési lehetőségek között szeretném fel sorolni :

- Biztonság: Implementálni kéne további hitelesítést és jogosultságkezelést OAuth2 vagy JWT használatával.
- Adatbázis: Váltsani kellene a H2-ről egy éles környezetben is használható adatbázisra, például MySQL.
- Hibakezelés: Fejleszteni kéne a naplózást.
- Tesztelés: Adjon hozzá több egység- és integrációs tesztet.
- CI/CD: Állítson be folyamatos integrációs és folyamatos telepítési csővezetékeket.
