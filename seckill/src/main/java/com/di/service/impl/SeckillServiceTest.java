package com.di.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.di.dto.Exposer;
import com.di.dto.SeckillExecution;
import com.di.entity.Seckill;
import com.di.exception.RepeatKillException;
import com.di.exception.SeckillCloseException;
import com.di.service.SeckillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})

public class SeckillServiceTest{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void getSeckillList() throws Exception{
		List<Seckill> seckills = seckillService.getSeckillList();
		System.out.println(seckills);
	}
	
	@Test
	public void getById() throws Exception{
		long seckillId = 1000;
		Seckill seckill = seckillService.getById(seckillId);
		System.out.println(seckill);
	}
	
	@Test
	public void exportSeckillUrl() throws Exception{
		long seckillId = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		System.out.println(exposer);
	}
	
	@Test
	public void executeSeckill() throws Exception{
		
		long seckillId = 1000;
		long userPhone = 13476191876L;
		String md5 = "bf204e2683e7452aa7db1a50b5713bae";
		try{
			SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
			System.out.println(seckillExecution);
		}catch(RepeatKillException e){
			e.printStackTrace();
		}catch(SeckillCloseException e1){
			e1.printStackTrace();
		}	
	}
	
	@Test
		public void testSeckillLogic() throws Exception{
		long seckillId = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()){
			System.out.println(exposer);
			
			long userPhone = 13476191876L;
			String md5 = exposer.getMd5();
			try{
				SeckillExecution seckillExecution  = seckillService.executeSeckill(seckillId, userPhone, md5);
				System.out.println(seckillExecution);
			}catch(RepeatKillException e)
			{
				e.printStackTrace();
			}catch(SeckillCloseException e1)
			{
				e1.printStackTrace();
			}
		}else{
			System.out.println(exposer);
		}
	}
	
}