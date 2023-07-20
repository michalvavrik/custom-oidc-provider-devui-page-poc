# POC for custom Quarkus OIDC provider DEV UI page

Shows how extension can alter Quarkus DEV UI OIDC extension card (showed on the `http://localhost:8080/q/dev-ui/extensions`).

Steps:

1. Run `quarkus build` on this project
2. Go to Quarkus QuickStart Security OpenID Connect QuickStart root directory
3. Add this extension to the QuickStart `sed -i 's/<artifactId>quarkus-oidc<\/artifactId>/<artifactId>quarkus-oidc<\/artifactId><\/dependency><dependency><groupId>io.quarkus.test<\/groupId><artifactId>custom-provider<\/artifactId><version>1.0.0-SNAPSHOT<\/version>/g' pom.xml`
4. Run 
    - `quarkus dev` for no change
    - `quarkus dev -Dquarkus-test.custom-provider.keycloak-title=true` for custom title of the Keycloak provider page (the rest is same)
    - `quarkus dev -Dquarkus-test.custom-provider.keycloak=true` for custom Keycloak provider page with component JS placed at this extension (JS is never found)
    - `quarkus dev -Dquarkus-test.custom-provider.google=true` for custom Google provider page
    - `quarkus dev -Dquarkus-test.custom-provider.non-oidc-web-component=true` for this component page in Quarkus OIDC namespace (never loads as JS is never found)
5. Open browser and go to the `http://localhost:8080/q/dev-ui/extensions`