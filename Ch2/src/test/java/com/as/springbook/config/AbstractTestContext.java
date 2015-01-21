/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author komatsu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AbstractTestContextConfig.class})
@TestExecutionListeners({AbstractTestExecutionListenerComponent.class})
@ActiveProfiles("test")
public abstract class AbstractTestContext extends AbstractTransactionalJUnit4SpringContextTests {

	@PersistenceContext
	protected EntityManager em;
	
}
