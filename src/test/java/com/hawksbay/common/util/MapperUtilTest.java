package com.hawksbay.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.hawksbay.common.entity.StorageInfo;
import com.hawksbay.common.entity.UserMessage;

@ExtendWith(MockitoExtension.class)
public class MapperUtilTest {

	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private MapperUtil mapperUtil;

	@Test
    public void covertToObject() {
		StorageInfo info = new StorageInfo();
		info.setName("HawksBay");
    	when(modelMapper.map(any(), any())).thenReturn(info);
    	StorageInfo result = mapperUtil.convertObject(info, StorageInfo.class);

        //then
        assertEquals("HawksBay", result.getName());
    }
	
	@Test
    public void covertToObjectNotEquals() {
		StorageInfo info = new StorageInfo();
		info.setName("HawksBay");
    	when(modelMapper.map(any(), any())).thenReturn(new UserMessage());
    	UserMessage result = mapperUtil.convertObject(info, UserMessage.class);

        //then
        assertEquals(null, result.getMessage());
    }

}
