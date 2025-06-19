
package factories;

import builderForOrk.OrkBuilder;

/**
 *
 * @author elenagoncarova
 */
public interface OrkBuilderFactory {
    public OrkBuilder createOrkBuilder();
    public OrkBuilder createOrkBuilder(Boolean withBanner);
}
