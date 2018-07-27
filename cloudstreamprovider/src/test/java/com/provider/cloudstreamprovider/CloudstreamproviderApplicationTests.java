package com.provider.cloudstreamprovider;

import com.provider.cloudstreamprovider.rabbtimq.IMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudstreamproviderApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	IMessageService messageService;

	@Test
	public void sendmsg() {
		messageService.send("Hello Word!!!");
	}

}
