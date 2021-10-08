package com.example.buscacep.ConfigRetrofit;

import com.example.buscacep.service.ServiceCEP;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {


    private Retrofit retrofit;

    public RetrofitConfig() {

        this.retrofit = new Retrofit.Builder().baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public ServiceCEP getCEPService() {
        return this.retrofit.create(ServiceCEP.class);
    }


}
