package com.alura.conversormonedas;

public record Rate (
        String result,
        String base_code,
        String target_code,
        String conversion_rate){}
