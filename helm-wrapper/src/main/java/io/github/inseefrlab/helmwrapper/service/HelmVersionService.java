package io.github.inseefrlab.helmwrapper.service;

import io.github.inseefrlab.helmwrapper.utils.Command;
import org.zeroturnaround.exec.InvalidExitValueException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class HelmVersionService {

    public String getVersion()
            throws InvalidExitValueException, IOException, InterruptedException, TimeoutException {
        String version = Command.executeAndGetResponseAsRaw("helm version --template={{.Version}}")
                .getOutput().getString(StandardCharsets.UTF_8.name());
        return version;
    }

}