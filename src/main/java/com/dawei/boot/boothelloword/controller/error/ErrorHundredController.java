package com.dawei.boot.boothelloword.controller.error;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawei.boot.boothelloword.controller.fuse.TestService;

/**
 * @author sinbad on 2020/4/14
 */
@RestController
@RequestMapping(value = "/api/test/error")
public class ErrorHundredController {


	private static final Logger logger = LoggerFactory.getLogger(TestService.class);


	//线程个数
	private static int THREAD_COUNT = 10;
	//总元素数量
	private static int ITEM_COUNT = 1000;

	//帮助方法，用来获得一个指定元素数量模拟数据的ConcurrentHashMap
	private ConcurrentHashMap<String, Long> getData(int count) {
		return LongStream.rangeClosed(1, count)
				.boxed()
				.collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(),
						(o1, o2) -> o1, ConcurrentHashMap::new));
	}

	@GetMapping("wrong")
	public String wrong() throws InterruptedException {
		ConcurrentHashMap<String, Long> concurrentHashMap = getData(ITEM_COUNT - 100);
		//初始900个元素
		logger.info("init size:{}", concurrentHashMap.size());

		ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
		//使用线程池并发处理逻辑
		forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
			//查询还需要补充多少个元素
			int gap = ITEM_COUNT - concurrentHashMap.size();
			logger.info("gap size:{}", gap);
			//补充元素
			concurrentHashMap.putAll(getData(gap));
		}));
		//等待所有任务完成
		forkJoinPool.shutdown();
		forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
		//最后元素个数会是1000吗？
		logger.info("finish size:{}", concurrentHashMap.size());
		return "OK";
	}


}