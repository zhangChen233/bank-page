package com.chen.service;

import java.io.IOException;

import com.chen.pojo.PageInfo;

public interface LogService {
	
	/**
	 * 分页显示
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;

}
