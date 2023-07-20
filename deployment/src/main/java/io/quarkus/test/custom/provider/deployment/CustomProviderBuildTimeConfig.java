package io.quarkus.test.custom.provider.deployment;

import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "quarkus-test.custom-provider")
@ConfigRoot
public interface CustomProviderBuildTimeConfig {

    /**
     * Show custom title for Keycloak provider page.
     */
    @WithDefault("false")
    boolean keycloakTitle();

    /**
     * Show custom Keycloak provider page.
     */
    @WithDefault("false")
    boolean keycloak();

    /**
     * Show custom Google provider page.
     */
    @WithDefault("false")
    boolean google();

    /**
     * This web component has io.quarkus.oidc namespace, but it is placed in here.
     */
    @WithDefault("false")
    boolean nonOidcWebComponent();

}
