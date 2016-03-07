package com.batuta.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.batuta.model.MetricaAcesso;
import com.batuta.model.User;
import com.batuta.repository.MetricaAcessoRepository;

@Service
public class MetricaAcessoService extends ServiceDefault<MetricaAcesso, MetricaAcessoRepository> {

	public boolean addMetricaAcessoByUser(User user){
		save(new MetricaAcesso(Calendar.getInstance(), user));
		return true;
		
	}
}
