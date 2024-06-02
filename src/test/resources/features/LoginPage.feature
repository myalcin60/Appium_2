@LoginPage
Feature: Login page test

  Scenario: Login page
    Given Kullanici kitap yurdu uygulamasini acar
    Then Kullanici acilan sayfada kitapyurdu metninin gorundugunu dogrular
