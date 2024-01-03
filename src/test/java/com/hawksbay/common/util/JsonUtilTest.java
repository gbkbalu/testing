package com.hawksbay.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hawksbay.common.entity.UserMessage;

@ExtendWith(MockitoExtension.class)
public class JsonUtilTest {

	@Mock
	private ObjectMapper mapper;
	
	@InjectMocks
	private JsonUtil jsonUtil;

	@Test
    public void getEntityFromJson() throws JsonMappingException, JsonProcessingException {
		String json = "{\"message\":\"HawksBay\"}";
		UserMessage message = new UserMessage("HawksBay");
    	when(mapper.readValue(json, UserMessage.class)).thenReturn(message);
    	UserMessage result = jsonUtil.getEntityFromJson(json, UserMessage.class);

        //then
        assertEquals("HawksBay", result.getMessage());
    }
	
	@Test
    public void getJsonFromEntity() throws JsonProcessingException{
		String json = "{\"message\":\"HawksBay\"}";
		UserMessage message = new UserMessage("HawksBay");
    	when(mapper.writeValueAsString(message)).thenReturn(json);
    	String result = jsonUtil.getJsonFromEntity(message);

        //then
        assertEquals(json, result);
    }
	
	@Test
    public void getEntityFromFilePath() throws JsonMappingException, JsonProcessingException {
		String path = "classpath:message.json";
		String json = "{\"message\":\"HawksBay\"}";
		UserMessage message = new UserMessage("HawksBay");
		when(mapper.readValue(json, UserMessage.class)).thenReturn(message);
		UserMessage result = jsonUtil.getEntityFromFilePath(path, UserMessage.class);

        //then
        assertEquals("HawksBay", result.getMessage());
    }
	
	@Test
    public void getJsonData() throws JsonMappingException, JsonProcessingException {
		String path = "classpath:message.json";
		String json = "{\"message\":\"HawksBay\"}";
    	String result = jsonUtil.getJsonData(path);

        //then
        assertEquals(json, result);
    }

}
