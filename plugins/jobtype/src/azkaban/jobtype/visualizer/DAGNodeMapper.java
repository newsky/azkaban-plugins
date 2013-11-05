/*
 * Copyright 2012 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package azkaban.jobtype.visualizer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;


public class DAGNodeMapper extends ObjectMapper {
	public DAGNodeMapper() {
    setSerializationInclusion(JsonInclude.Include.NON_NULL);
    enable(SerializationFeature.INDENT_OUTPUT);
    configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
    configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, false);
    disable(SerializationFeature.FLUSH_AFTER_WRITE_VALUE);
    disable(SerializationFeature.CLOSE_CLOSEABLE);
    disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		registerModule(new DAGNodeModule());
	}
}
