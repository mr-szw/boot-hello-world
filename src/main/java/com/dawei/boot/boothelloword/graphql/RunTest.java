package com.dawei.boot.boothelloword.graphql;

import com.dawei.boot.boothelloword.graphql.fetcher.AuthorDataFetcher;
import com.dawei.boot.boothelloword.graphql.fetcher.BookDataFetcher;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sinbad on 2020/05/13.
 */
public class RunTest {


	public static void main(String[] args) {
		//这里是定义schema 的字符串，定义了一个名为hello的查询，返回的数据类型是String
		//schema除了直接通过String字符串定义之外，还可以通过SDL文件（后缀为*.graphqls的文件）或编码的方式定义。
		String schema = "type Query {\n" +
				"  getBookById(bookId: String): BookInfo\n" +
				"}\n" +
				"type BookInfo {\n" +
				"  bookId: String\n" +
				"  bookName: String\n" +
				"  authorInfo: AuthorInfo\n" +
				"}" +
				"type AuthorInfo {\n" +
				"    id: Int,\n" +
				"    authorName: String\n" +
				"}";

		//{hero(name:\"jack\"){id,name,addr}}
		/*
		query($userId: Long,$uuid: String ,$phone: String) {
			sgCategoryNewUser(userId: $userId, uuid: $uuid, phone:$phone,cpltUuid:true,cpltPhone:true){
				flashBuyNewUser
			}
		*/
		String queryStr = "query GetBookById($bookId: String, $authorId: Int) { " +
								"getBookById(bookId: $bookId) {" +
									"bookId" +
									"bookName" +
									"authorInfo(authorId: $authorId) " +
								"} "
							+ "}";

		SchemaParser schemaParser = new SchemaParser();
		TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

		//实例化一个RuntimeWiring对象，这个对象中关联了一个DataFetcher对象，DataFetcher对象是用来获取数据的，获取数据的方式需要开发人员根据实际情况实现，它只关心返回结果
		//这里是将名为hello的查询关联到一个简单的StaticDataFetcher对象，它返回一个字符串"world"
		RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
				.type("Query", builder -> builder.dataFetcher("getBookById", new BookDataFetcher()))
				.type("Query", builder -> builder.dataFetcher("authorInfo", new AuthorDataFetcher()))
				.build();

		SchemaGenerator schemaGenerator = new SchemaGenerator();

		//将schema定义与RuntimeWiring绑定，生产可执行的schema
		GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

		GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();

		Map<String, Object> variablesMap = new HashMap<>();
		variablesMap.put("bookId", "book-1");
		variablesMap.put("authorId", 123);

		//GraphQL.newGraphQL(graphQLSchema)

		ExecutionInput executionInput = ExecutionInput.newExecutionInput()
				// 需要执行的查询语言
				.query(queryStr)
				// 执行操作的名称，默认为null
				.operationName("GetBookById")
				// 获取query语句中定义的变量的值
				.variables(variablesMap)
				.build();

		//执行hello查询
		ExecutionResult executionResult = graphQL.execute(executionInput);

		//输出查询结果，结果为{hello=world},默认是Map格式的数据
		System.out.println(executionResult.getData().toString());
	}


}

