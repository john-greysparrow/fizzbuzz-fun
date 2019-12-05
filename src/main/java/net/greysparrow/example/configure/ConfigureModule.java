package net.greysparrow.example.configure;

import com.google.inject.AbstractModule;
import net.greysparrow.example.service.NumberService;
import net.greysparrow.example.service.OutputTypeProvider;
import net.greysparrow.example.service.impl.ExtendedFizzBuzzOutputTypeProvider;
import net.greysparrow.example.service.impl.IntegerNumberService;
import net.greysparrow.example.service.impl.StandardFizzBuzzOutputTypeProvider;

public class ConfigureModule extends AbstractModule {

    private boolean useExtendedMode;

    public ConfigureModule(boolean useExtendedMode) {
        this.useExtendedMode = useExtendedMode;
    }

    @Override
    protected void configure() {
        bind(NumberService.class).to(IntegerNumberService.class);
        bind(OutputTypeProvider.class).to(getOutputTypeProviderClass(useExtendedMode));
    }

    private Class<? extends OutputTypeProvider> getOutputTypeProviderClass(boolean useExtendedProvider) {
        return useExtendedProvider ? ExtendedFizzBuzzOutputTypeProvider.class : StandardFizzBuzzOutputTypeProvider.class;
    }

}
