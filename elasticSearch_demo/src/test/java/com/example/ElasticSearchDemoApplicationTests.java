package com.example;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.get.GetResult;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.*;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.ParsedSum;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@SpringBootTest
class ElasticSearchDemoApplicationTests {


    private final RestHighLevelClient restHighLevelClient;

    @Autowired
    public ElasticSearchDemoApplicationTests (RestHighLevelClient restHighLevelClient){
        this.restHighLevelClient = restHighLevelClient;
    }

    @Test
    void contextLoads() {

    }


    /**
     * 创建索引 创建映射
     */

    @Test
    public void testIndexAndMapping(){
        //创建索引请求对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("supermarket");
        //指定映射   参数1：指定映射 json结构  参数2：指定数据类型
        createIndexRequest.mapping("{\n" +
                "    \"properties\": {\n" +
                "      \"id\":{\n" +
                "        \"type\": \"integer\"\n" +
                "      },\n" +
                "      \"title\":{\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"price\":{\n" +
                "        \"type\": \"double\"\n" +
                "      },\n" +
                "      \"create_at\":{\n" +
                "        \"type\": \"date\"\n" +
                "      },\n" +
                "      \"description\":{\n" +
                "        \"analyzer\": \"ik_max_word\", \n" +
                "        \"type\": \"text\"\n" +
                "      }\n" +
                "    }\n" +
                "  }", XContentType.JSON);
        try {
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            System.out.println(createIndexResponse.isAcknowledged());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("0");
        }finally {
            try {
                restHighLevelClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    void updateTest() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("taskresult");
        updateRequest.id("G699an0Bt_ZlNDHC3zub");
        updateRequest.doc(jsonBuilder()
                .startObject()
                .field("status", 0)
                .endObject());
        UpdateResponse response = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());
        restHighLevelClient.close();

    }

    /**
     * 索引文档
     */
    @Test
    void docTest1() throws IOException {
        IndexRequest indexRequest = new IndexRequest("supermarket");
        indexRequest
                .id("1")
                .source("",XContentType.JSON);

        IndexResponse response = restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
        response.status();
    }

    @Test
    void searchTest() throws IOException {

        //指定搜索索引
        SearchRequest searchRequest = new SearchRequest("taskresult");
        //指定条件对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //查询所有
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        //指定查询条件
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

    }

    @Test
    void searchTest2() throws IOException {

        SearchRequest searchRequest = new SearchRequest("taskresult");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder
                .query(QueryBuilders.matchAllQuery())
                .aggregation(
                        AggregationBuilders
                                .terms("resultType_group") //自己定义 桶
                                .field("resultType") //字段
                                .order(BucketOrder.count(false)) //排序，降序
                                .size(3)) //拿几条数据
                .size(0); //是否显示原数据 0不显示
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        Aggregations aggregations = searchResponse.getAggregations();
        //ParsedStringTerms 取决于聚合字段的类型
        //max(ParsedMax)  min(ParseMin) sum(ParsedSum) avg(ParseAvg) 聚合函数 桶中只有一个返回值
        ParsedStringTerms resultType_group = aggregations.get("resultType_group");
        List<? extends Terms.Bucket> buckets = resultType_group.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            System.out.println(bucket.getKey()+":"+bucket.getDocCount());
        }


    }


    /**
     * max(ParsedMax)最大值
     * min(ParseMin)最小值
     * sum(ParsedSum)总和
     * avg(ParseAvg)平均值
     * 聚合函数 桶中只有一个返回值
     */
    @Test
    void searchTest3() throws IOException {
        SearchRequest searchRequest = new SearchRequest("taskresult");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder
                .query(QueryBuilders.matchAllQuery())
                .aggregation(
                        AggregationBuilders
                                //sum ; avg ; min ; max
                                .sum("price_sum") //自己定义 桶
                                .field("price") //字段
                                )
                .size(0); //是否显示原数据 0不显示
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        Aggregations aggregations = searchResponse.getAggregations();
        ParsedSum price_sum = aggregations.get("price_sum");
        double value = price_sum.getValue();
    }

    /**
     * query：查询精确查询，查询计算文档得分，并根据文档得分进行返回
     * filter query：过滤查询，用来在大量数据中筛选出本地查询相关数据， 不会计算文档得分，
     * 经常使用filter query 结果进行缓存
     * 注意： 一旦使用query和filter query es优先执行filter query 然后在执行 query
     */
    @Test
    void filterQueryFilter() throws IOException {

        SearchRequest searchRequest = new SearchRequest("taskresult");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(QueryBuilders.matchAllQuery())
                        .postFilter(QueryBuilders.termQuery("resultType","IMAGE")); //用来指定过滤条件

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getId()+":"+hit.getSourceAsString());
        }

    }

}
