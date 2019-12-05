package net.greysparrow.example.utils;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.google.inject.Guice;
import com.google.inject.Module;
import lombok.SneakyThrows;

public class CmdUtils {

    @SneakyThrows
    public static <T extends Injectable> T configureCommand(Class<T> cmdClass, String[] args) {
        JCommander cmdBuilder = null;
        try {
            T cmd = cmdClass.getConstructor().newInstance();
            cmdBuilder = JCommander.newBuilder()
                    .addObject(cmd)
                    .programName(cmdClass.getSimpleName())
                    .build();
            cmdBuilder.parse(args);
            return cmd;
        } catch (ParameterException e) {
            cmdBuilder.usage();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static <T extends Injectable> T configureInjector(T cmd, Module module) {
        cmd.setInjector(Guice.createInjector(module));
        return cmd;
    }

}
