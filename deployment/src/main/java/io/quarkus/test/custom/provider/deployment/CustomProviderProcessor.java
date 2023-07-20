package io.quarkus.test.custom.provider.deployment;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.devui.spi.page.CardPageBuildItem;
import io.quarkus.devui.spi.page.Page;
import io.quarkus.oidc.deployment.devservices.CustomOidcDevUiProviderPageBuildItem;

import java.util.function.BooleanSupplier;

class CustomProviderProcessor {

    private static final String FEATURE = "custom-provider";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep(onlyIf = UseCustomKeycloakTitleProvider.class)
    CustomOidcDevUiProviderPageBuildItem produceKeycloakProviderPageWithCustomTitleDevUi() {
        return new CustomOidcDevUiProviderPageBuildItem(Page
                .webComponentPageBuilder()
                .icon("font-awesome-solid:boxes-stacked")
                .title("Custom Title")
                .componentLink("qwc-oidc-provider.js"));
    }

    @BuildStep(onlyIf = UseCustomKeycloakProvider.class)
    CustomOidcDevUiProviderPageBuildItem produceKeycloakProviderPageDevUi() {
        return new CustomOidcDevUiProviderPageBuildItem(Page
                .webComponentPageBuilder()
                .icon("font-awesome-solid:boxes-stacked")
                .title("Custom Keycloak provider")
                .namespace("io.quarkus.test.custom-provider")
                .componentLink("qwc-custom-provider.js"));
    }

    @BuildStep(onlyIf = UseNonOidcWebComponent.class)
    CardPageBuildItem produceNonOidcWebComponent() {
        // namespace is Quarkus OIDC extension, but it is placed in here
        var cardPage = new CardPageBuildItem();
        cardPage.addPage(Page
                .webComponentPageBuilder()
                .icon("font-awesome-solid:boxes-stacked")
                .title("Non OIDC web component - please watch tabs on the right")
                        .namespace("io.quarks.quarkus-oidc")
                .componentLink("qwc-custom-provider.js"));
        return cardPage;
    }

    @BuildStep(onlyIf = UseGoogleProvider.class)
    CustomOidcDevUiProviderPageBuildItem produceGoogleProviderDevUi() {
        return new CustomOidcDevUiProviderPageBuildItem(Page
                .rawDataPageBuilder("TODO")
                .title("Custom Google provider"));
    }
    
    private static final class UseNonOidcWebComponent implements BooleanSupplier {

        CustomProviderBuildTimeConfig config;

        @Override
        public boolean getAsBoolean() {
            return config.nonOidcWebComponent();
        }
    }

    private static final class UseCustomKeycloakProvider implements BooleanSupplier {

        CustomProviderBuildTimeConfig config;

        @Override
        public boolean getAsBoolean() {
            return config.keycloak();
        }
    }

    private static final class UseCustomKeycloakTitleProvider implements BooleanSupplier {

        CustomProviderBuildTimeConfig config;

        @Override
        public boolean getAsBoolean() {
            return config.keycloakTitle();
        }
    }

    private static final class UseGoogleProvider implements BooleanSupplier {

        CustomProviderBuildTimeConfig config;

        @Override
        public boolean getAsBoolean() {
            return config.google();
        }
    }
}
