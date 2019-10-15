mvn clean install
docker build -t  pintu12345/spring-micro-site-crawler:v3 . 
docker push pintu12345/spring-micro-site-crawler:v3


gcloud compute firewall-rules create test-node-port3 --allow tcp:31002

-----------------------------------------------------------------------------
http://localhost:8100/currency-converter/from/USD/to/INR/quantity/1

http://localhost:8100/currency-converter/from/USD/to/INR/quantity/3

http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/3


<dependency>
     <groupId>org.springframework.cloud</groupId>
	 <artifactId>spring-cloud-starter-kubernetes</artifactId>
</dependency> 
----------------------------------------------------------------------
 <dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-kubernetes-core</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-kubernetes-discovery</artifactId>
		</dependency>
	</dependencies>
	
-------------------------------------------------------------------------

<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-kubernetes-config</artifactId>
</dependency>	
-------------------------------------------------------------------------	
<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-kubernetes-core</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-kubernetes-config</artifactId>
		</dependency>
</dependencies>	