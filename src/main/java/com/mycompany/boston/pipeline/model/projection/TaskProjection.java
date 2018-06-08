package com.mycompany.boston.pipeline.model.projection;

import com.mycompany.boston.pipeline.model.Task;
import org.springframework.data.rest.core.config.Projection;

// jojo: projection example (useless for now)
@Projection(name = "all", types = {Task.class})
public interface TaskProjection {
}