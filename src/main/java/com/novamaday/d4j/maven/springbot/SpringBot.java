package com.novamaday.d4j.maven.springbot;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.ClientPresence;
import discord4j.rest.RestClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

/*
* This project uses the example repository provided by Discord4J Team as a template
* Reference: https://github.com/Discord4J/example-projects
* It's important to give credit , I ain't an asshole
*/

@SpringBootApplication
public class SpringBot {
    public static void main(String[] args) {
        //Start spring application
        new SpringApplicationBuilder(SpringBot.class)
            .build()
            .run(args);
    }


    @Bean
    public GatewayDiscordClient gatewayDiscordClient() {
        return DiscordClientBuilder.create(System.getenv("D_BOT_TOKEN")).build()
            .gateway()
            .setInitialPresence(ignore -> ClientPresence.online(ClientActivity.listening("to /commands")))
            .login()
            .block();
    }

    @Bean
    public RestClient discordRestClient(GatewayDiscordClient client) {
        return client.getRestClient();
    }
}
