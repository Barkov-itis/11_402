package ru.itis.spring_11_402.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CurrencyRateLoaderImpl implements CurrencyRateLoader {
    private static final String CBR_DAILY_CUR = "https://www.cbr-xml-daily.ru/daily_json.js";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getCurrencyRates() {
        String response = restTemplate.getForObject(CBR_DAILY_CUR, String.class);
        log.info("Курсы валют успешно загружены");
        return response;
    }



    private String smsUrl;
    private String login;
    private String password;

    public void sendSms(String phone, String text) {
        //https://smsc.ru/sys/send.php?login=<login>&psw=<password>&phones=<phones>&mes=<message>
        String url = smsUrl + "?login=" + login + "&psw=" + password + "&phones=" + phone + "&mes=" + text;

        String result = restTemplate.getForObject(url, String.class);
    }





}
