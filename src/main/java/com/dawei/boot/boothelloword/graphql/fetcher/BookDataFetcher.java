package com.dawei.boot.boothelloword.graphql.fetcher;

import com.dawei.boot.boothelloword.graphql.entry.BookInfo;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author sinbad on 2021/5/11.
 */
public class BookDataFetcher implements DataFetcher<BookInfo> {
	@Override
	public BookInfo get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
		return null;
	}
}
