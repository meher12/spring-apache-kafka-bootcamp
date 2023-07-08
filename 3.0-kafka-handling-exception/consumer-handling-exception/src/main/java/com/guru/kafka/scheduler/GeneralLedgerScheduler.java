package com.guru.kafka.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class GeneralLedgerScheduler {

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    private static final Logger LOG = LoggerFactory.getLogger(GeneralLedgerScheduler.class);
    //0 7 7 * * ?
    @Scheduled(cron = "46 9 8 7 * ?")
    public void stop() {
        LOG.info("Stopping consumer");
        registry.getListenerContainer("general-ledger.one").pause();
    }

    @Scheduled(cron = "1 9 7 * * ?")
    public void start() {
        LOG.info("Starting consumer");
        registry.getListenerContainer("general-ledger.one").resume();
    }

}