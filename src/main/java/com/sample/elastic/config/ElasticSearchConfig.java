package com.sample.elastic.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.sample.elastic.repository")
public class ElasticSearchConfig {

	
	@Bean
	public TransportClient  builder() throws UnknownHostException {
		Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
	    TransportClient client = TransportClient.builder()
	            .settings(settings)
	            .build();
	    client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("101.53.136.181"), 9200));
	    return client;

	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
		return new ElasticsearchTemplate(builder());
	}
	
	/*@Bean
	public NodeBuilder builder() {
		return new NodeBuilder().clusterName("elasticsearch");
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws IOException {
		final Settings.Builder elasticsearchSettings = Settings.settingsBuilder()
				.put("http.enabled", "true")
				.put("index.number_of_shards", "1");

		return new ElasticsearchTemplate(
				builder().local(false).settings(elasticsearchSettings.build()).node().client());
	}*/
}
