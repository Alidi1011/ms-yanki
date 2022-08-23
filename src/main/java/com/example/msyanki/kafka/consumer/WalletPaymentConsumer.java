package com.example.msyanki.kafka.consumer;

import com.example.msyanki.dto.PaymentDto;
import com.example.msyanki.model.CustomerWallet;
import com.example.msyanki.model.WalletTransaction;
import com.example.msyanki.repository.CustomerWalletRepository;
import com.example.msyanki.repository.WalletTransactionRepository;
import com.example.msyanki.service.CustomerWalletService;
import com.example.msyanki.service.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class WalletPaymentConsumer {

    private final WalletTransactionService transactionService;
    private final CustomerWalletService walletService;


    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @KafkaListener(topics = "${kafka.topic.name}")
    public void listener(@Payload PaymentDto paymentDto) {
        log.info("Message received in ms-yanki: {} ", paymentDto);

        CustomerWallet customerWalletOrigin = this.getWalletByPhoneNumber(paymentDto.getPhoneNumberOrigin());
        CustomerWallet customerWalletDestiny = this.getWalletByPhoneNumber(paymentDto.getPhoneNumberDestination());


        if(customerWalletOrigin != null & customerWalletDestiny != null){
            WalletTransaction walletTransaction = new WalletTransaction();
            LocalDateTime dateTime;

            if(paymentDto.getDateTime() == null){
                dateTime = LocalDateTime.now();
            }else{
                dateTime = LocalDate.parse(paymentDto.getDateTime(), FORMATTER).atStartOfDay();
            }

            walletTransaction.setAmount(paymentDto.getAmount());
            walletTransaction.setPhoneOrigin(paymentDto.getPhoneNumberOrigin());
            walletTransaction.setPhoneDestiny(paymentDto.getPhoneNumberDestination());
            walletTransaction.setCreatedAt(dateTime);

            customerWalletOrigin.setBalance(customerWalletOrigin.getBalance().subtract(paymentDto.getAmount()));
            customerWalletDestiny.setBalance(customerWalletDestiny.getBalance().add(paymentDto.getAmount()));

            walletService.update(customerWalletOrigin);
            walletService.update(customerWalletDestiny);
            WalletTransaction transactionSaved = transactionService.save(walletTransaction);
            log.info("walletTransaction saved in ms-yanki: {} ", transactionSaved);
        }else{
            log.error("PhoneNumbers sent don't exist in ms-yanki");
        }

    }

    private CustomerWallet getWalletByPhoneNumber(String phoneNumber){
        System.out.println("PhoneNumber:" + phoneNumber);
        CustomerWallet customerWallet = walletService.findByCellphoneNumber(phoneNumber);
        if(customerWallet == null) {
            log.error("PhoneNumber: " + phoneNumber + " sent don't exist in ms-yanki");
        }
        return customerWallet;
    }

}
