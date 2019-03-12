package com.kaleb.clean_pokerandomizer.di;

import com.kaleb.clean_pokerandomizer.di.components.ApplicationComponent;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version ComponentHolder, v 0.1 12/03/19 16.15 by Billy Kaleb Hananto
 */
public class ComponentHolder {

    private static ComponentHolder componentHolder;

    private final ApplicationComponent applicationComponent;

    private ComponentHolder(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    public static void set(ApplicationComponent applicationComponent) {
        if (componentHolder == null) {
            componentHolder = new ComponentHolder(applicationComponent);
        }
    }

    public static ApplicationComponent provide() {
        if (componentHolder == null) throw new IllegalStateException(
            "Application components needs to be set in Application");

        return componentHolder.applicationComponent;
    }
}
