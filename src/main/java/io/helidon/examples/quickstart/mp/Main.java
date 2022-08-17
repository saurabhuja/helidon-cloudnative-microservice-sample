package io.helidon.examples.quickstart.mp;

import io.helidon.microprofile.server.Server;
import io.helidon.config.Config;
import static io.helidon.config.ConfigSources.classpath;
import java.io.IOException;

public final class Main {

    private Main() { }

    public static void main(final String[] args) throws IOException {
        Server server = startServer();
        System.out.println("http://localhost:" + server.port() + "/greet");
    }

    static Server startServer() {
        return Server.builder()
                .config(buildConfig())
                .build()
                .start();

    }

    private static Config buildConfig() {
        return Config.builder().disableEnvironmentVariablesSource()
                .sources(
                        classpath("META-INF/mp-config.yaml"),
                        classpath("META-INF/microprofile-config.properties"))
                .build();
    }


}

