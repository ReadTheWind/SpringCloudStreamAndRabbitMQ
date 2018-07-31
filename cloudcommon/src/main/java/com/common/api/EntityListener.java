package com.common.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Configurable
public class EntityListener {
	private static final Logger log = LoggerFactory.getLogger(EntityListener.class);
	private Environment environment;

	public EntityListener() {
	}

	@PrePersist
	public void prePersist(Object target) {
		System.out.println("PagodaEntityListener.prePersist " + target);

		try {
			System.out.print("调用spring entiyt listener");

		} catch (Exception var3) {
			log.error("PagodaEntityListener.prePersist", var3);
		}

	}

	@PreRemove
	public void preRemove(Object target) {
		System.out.println("PagodaEntityListener.preRemove " + target);
	}

	@PreUpdate
	public void preUpdate(Object target) {
		System.out.println("PagodaEntityListener.preUpdate " + target);
	}

	@PostLoad
	public void postLoad(Object target) {
		System.out.println("PagodaEntityListener.postLoad " + target);
	}
}
