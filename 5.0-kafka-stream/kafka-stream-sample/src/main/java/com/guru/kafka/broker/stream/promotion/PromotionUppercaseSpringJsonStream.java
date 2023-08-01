package com.guru.kafka.broker.stream.promotion;

import com.guru.kafka.broker.message.PromotionMessage;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Configuration
public class PromotionUppercaseSpringJsonStream {

    @Bean
    public KStream<String, PromotionMessage> kstreamPromotionUppercase(StreamsBuilder builder) {
        // key
        var stringSerde = Serdes.String();
        // value
        var jsonSerde = new JsonSerde<>(PromotionMessage.class);
        var sourceStream = builder.stream("t-commodity-promotion",
                Consumed.with(stringSerde, jsonSerde));
        var uppercaseStream = sourceStream.mapValues(this::uppercasePromotionCode);

        uppercaseStream.to("t-commodity-promotion-uppercase", Produced.with(stringSerde, jsonSerde));

        sourceStream.print(Printed.<String, PromotionMessage>toSysOut().withLabel("JSON serde original stream"));
        uppercaseStream.print(Printed.<String, PromotionMessage>toSysOut().withLabel("JSON serde uppercase stream"));

        return sourceStream;

    }

    public PromotionMessage uppercasePromotionCode(PromotionMessage message) {
        return new PromotionMessage(message.getPromotionCode().toUpperCase());
    }
}