package com.example.buscacep.service;

import com.example.buscacep.model.Cep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceCEP {

    @GET("{cep}/json/")
    Call<Cep> findCEP(@Path("cep") String cep);

}