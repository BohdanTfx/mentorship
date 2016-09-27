package com.epam.mentorship.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.epam.mentorship.aspect.annotation.BeforeSave;
import com.epam.mentorship.aspect.annotation.BeforeUpdate;
import com.epam.mentorship.model.BaseEntity;

@Aspect
@Component
public class EntityManagerAspect {

	@Before("execution(public * com.epam.mentorship.dao.jpa.GenericJpaDao.save(..))")
	public void beforeSave(JoinPoint joinPoint) {
		BaseEntity<?> entity = findEntity(joinPoint.getArgs());
		try {
			executeAnnotatedMethod(entity, BeforeSave.class);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Before("execution(public * com.epam.mentorship.dao.jpa.GenericJpaDao.update(..))")
	public void beforeUpdate(JoinPoint joinPoint) {
		BaseEntity<?> entity = findEntity(joinPoint.getArgs());
		try {
			executeAnnotatedMethod(entity, BeforeUpdate.class);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private void executeAnnotatedMethod(BaseEntity<?> entity, Class<? extends Annotation> class1)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = entity.getClass().getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(class1)) {
				method.invoke(entity);
			}
		}
	}

	private BaseEntity<?> findEntity(Object[] args) {
		BaseEntity<?> entity = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof BaseEntity<?>) {
				entity = (BaseEntity<?>) args[i];
			}
		}
		return entity;
	}

}
