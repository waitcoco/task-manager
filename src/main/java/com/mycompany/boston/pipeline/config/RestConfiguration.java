package com.mycompany.boston.pipeline.config;

import com.mycompany.boston.pipeline.model.Camera;
import com.mycompany.boston.pipeline.model.Task;
import com.mycompany.boston.pipeline.model.Video;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfiguration extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Camera.class)
                .exposeIdsFor(Task.class)
                .exposeIdsFor(Video.class);
    }
}
