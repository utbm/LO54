package com.mycompany.sp4.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class}, initializers = {SystemPropertyInitializer.class})
public class RootConfigTest {

	@Value("${test}")
	String testProperty;

	@Test
	public void should_inject_system_properties_via_property_placeholder() throws Exception {
		assertThat(testProperty).isEqualTo("testValue");
	}
}
