package net.greysparrow.example;

import com.beust.jcommander.Parameter;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;
import net.greysparrow.example.configure.ConfigureModule;
import net.greysparrow.example.service.NumberService;
import net.greysparrow.example.utils.Injectable;

import java.io.PrintStream;

import static net.greysparrow.example.utils.CmdUtils.configureCommand;
import static net.greysparrow.example.utils.CmdUtils.configureInjector;

@Slf4j
public class FizzBuzzCmd implements Injectable {

    @Parameter(names = "-min", description = "Minimum integer value to iterate from")
    private Integer minimumValue = 1;

    @Parameter(names = "-max", description = "Maximum integer value to iterate up to and include", required = true)
    private Integer maximumValue;

    @Parameter(names = "-extended", description = "Use extended FizzBuzz mode?")
    private boolean useExtendedMode = false;

    private Injector guice;

    public static void main(String[] args) {
        try {
            configureCmd(args).configureGuice().run(System.out);
        } catch (Exception e) {
            log.error("{}: {}", e.getClass().getName(), e.getMessage());
        }
    }

    @VisibleForTesting
    static FizzBuzzCmd configureCmd(String[] args) {
        return configureCommand(FizzBuzzCmd.class, args);
    }

    @VisibleForTesting
    FizzBuzzCmd configureGuice() {
        configureInjector(this, new ConfigureModule(useExtendedMode));
        return this;
    }

    @VisibleForTesting
    void run(PrintStream output) {
        guice.getInstance(NumberService.class).iterate(minimumValue, maximumValue, output);
    }

    @Override
    public void setInjector(Injector injector) {
        this.guice = injector;
    }

}
