package com.urlshortener.redirectshorturl.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.urlshortener.redirectshorturl.repositories.ShortenedUrlInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Profile("default")
@Configuration
@EnableDynamoDBRepositories(basePackageClasses = ShortenedUrlInformationRepository.class)
public class DynamoDBConfigLive {

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
        log.info("Creating AWS static credentials provider in live profile");
        return new AWSStaticCredentialsProvider(amazonAWSCredentials());
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        log.info("Generating AWS credentials in live profile");
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }

//    @Bean
//    public DynamoDBMapperConfig dynamoDBMapperConfig() {
//        log.info("Creating dynamo DB mapper config in live profile");
//        return DynamoDBMapperConfig.DEFAULT;
//    }

    @Bean
    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
        log.info("Creating dynamo DB mapper in live profile");
        return new DynamoDBMapper(amazonDynamoDB, config);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        log.info("Creating amazon dynamo DB mapper in live profile");
        return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
                .withRegion(Regions.EU_WEST_1).build();
    }
}
