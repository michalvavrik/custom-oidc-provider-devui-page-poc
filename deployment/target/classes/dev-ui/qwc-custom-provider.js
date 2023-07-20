import { QwcHotReloadElement, html, css} from 'qwc-hot-reload-element';
import '@vaadin/button';
import '@vaadin/details';
import '@vaadin/horizontal-layout';
import '@vaadin/icon';
import '@vaadin/message-list';
import '@vaadin/password-field';
import '@vaadin/split-layout';

export class QwcCustomProvider extends QwcHotReloadElement {
    render() {
        return html`
            <div class="container" style="color: var(--lumo-secondary-text-color);border: 0">
                <div>I have custom OIDC provider page :-)</div>
            </div>`;
    }
}
customElements.define('qwc-custom-provider', QwcCustomProvider);
