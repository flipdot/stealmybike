package stealmybike.flipdot.org.stealmybike;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by daniel on 17.04.16.
 */
public class AppInject {
    private static Injector injector;

    public static <T> T get(Class<T> clazz) {
        return injector.getInstance(clazz);
    }

    public static Injector init(
            final MainActivtyUiElements mainActivtyUiElements
    ) {
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(MainActivtyUiElements.class).toInstance(mainActivtyUiElements);
            }
        });

        return injector;
    }
}
