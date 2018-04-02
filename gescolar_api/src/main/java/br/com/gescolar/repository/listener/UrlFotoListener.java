package br.com.gescolar.repository.listener;

import javax.persistence.PostLoad;

import org.springframework.util.StringUtils;

import br.com.gescolar.GescolarApplication;
import br.com.gescolar.model.Professor;
import br.com.gescolar.storage.S3;


public class UrlFotoListener {
	
	@PostLoad
	public void postLoad(Object object) {
		
		Professor p = null;
		if (object instanceof Professor)
			 p = ((Professor) object);
		
		if (p != null) {
			if (StringUtils.hasText(p.getFoto())) {
				S3 s3 = GescolarApplication.getBean(S3.class);
				p.setUrlfoto(s3.configurarUrl(p.getFoto()));
			}
		}
	}

}
