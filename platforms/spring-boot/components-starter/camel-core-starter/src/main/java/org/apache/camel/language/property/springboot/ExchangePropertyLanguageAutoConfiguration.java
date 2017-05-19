/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.language.property.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.language.property.ExchangePropertyLanguage;
import org.apache.camel.spi.LanguageCustomizer;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.apache.camel.spring.boot.LanguageConfigurationProperties;
import org.apache.camel.spring.boot.util.GroupCondition;
import org.apache.camel.util.IntrospectionSupport;
import org.apache.camel.util.ObjectHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.SpringBootAutoConfigurationMojo")
@Configuration
@Conditional(ExchangePropertyLanguageAutoConfiguration.Condition.class)
@AutoConfigureAfter(CamelAutoConfiguration.class)
@EnableConfigurationProperties({LanguageConfigurationProperties.class,
        ExchangePropertyLanguageConfiguration.class})
public class ExchangePropertyLanguageAutoConfiguration
        extends
            AllNestedConditions {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ExchangePropertyLanguageAutoConfiguration.class);
    @Autowired
    private CamelContext camelContext;
    @Autowired(required = false)
    private List<LanguageCustomizer<ExchangePropertyLanguage>> customizers;
    @Autowired
    private LanguageConfigurationProperties globalConfiguration;
    @Autowired
    private ExchangePropertyLanguageConfiguration languageConfiguration;

    public ExchangePropertyLanguageAutoConfiguration() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @ConditionalOnBean(CamelContext.class)
    public static class OnCamelContext {
    }

    @ConditionalOnBean(CamelAutoConfiguration.class)
    public static class OnCamelAutoConfiguration {
    }

    @ConditionalOnBean(CamelAutoConfiguration.class)
    public static class Condition extends GroupCondition {
        public Condition() {
            super("camel.component", "camel.component.exchangeproperty");
        }
    }

    @Bean(name = "exchangeProperty-language")
    @Scope("prototype")
    @ConditionalOnClass(CamelContext.class)
    @ConditionalOnMissingBean(ExchangePropertyLanguage.class)
    public ExchangePropertyLanguage configureExchangePropertyLanguage()
            throws Exception {
        ExchangePropertyLanguage language = new ExchangePropertyLanguage();
        if (CamelContextAware.class
                .isAssignableFrom(ExchangePropertyLanguage.class)) {
            CamelContextAware contextAware = CamelContextAware.class
                    .cast(language);
            if (contextAware != null) {
                contextAware.setCamelContext(camelContext);
            }
        }
        Map<String, Object> parameters = new HashMap<>();
        IntrospectionSupport.getProperties(languageConfiguration, parameters,
                null, false);
        IntrospectionSupport.setProperties(camelContext,
                camelContext.getTypeConverter(), language, parameters);
        boolean useCustomizers = globalConfiguration.getCustomizer()
                .isEnabled()
                && languageConfiguration.getCustomizer().isEnabled();
        if (useCustomizers && ObjectHelper.isNotEmpty(customizers)) {
            for (LanguageCustomizer<ExchangePropertyLanguage> customizer : customizers) {
                LOGGER.debug("Configure language {}, with customizer {}",
                        language, customizer);
                customizer.customize(language);
            }
        }
        return language;
    }
}