package com.horus.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

public class ElasticClientConfiguration {

	@Value("${spring.data.elasticsearch.cluster-name}")
	private String clusterName;
	@Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusterNodes;

	@Bean
	public Client client() throws UnknownHostException {

		String server = clusterNodes.split(":")[0];
		Integer port = Integer.parseInt(clusterNodes.split(":")[1]);
		Settings settings = Settings.settingsBuilder().put("cluster.name", clusterName).build();

		return TransportClient.builder().settings(settings).build()
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(server), port));
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
		return new ElasticsearchTemplate(client());
	}

}
