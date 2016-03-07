package com.batuta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.batuta.service.ServiceDefault;

import lombok.Getter;

@RestController
public abstract class ControllerDefault<T extends ServiceDefault<?, ?>> {

    @Autowired
    @Getter
    T service;

}
