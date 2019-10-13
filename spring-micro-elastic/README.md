calling limit service directly
--------------------------------

http://localhost:8080/limits

http://localhost:8081/limits

add vm arguments in run configuration -Dserver.port=8081  to change the port

To Load the changed values from config server call below url using postman POST method call
-------------------------------------------------------------------------------------------- 
first commit the changes in properties file to git and push the changes.

localhost:8081/actuator/refresh
localhost:8080/actuator/refresh

To Load the changed values for all instances of same project with single refresh
---------------------------------------------------------------------------------
first commit the changes in properties file to git and push the changes.
to check the values in properties file 

http://localhost:8888/spring-micro-elastic/dev    
http://localhost:8888/spring-micro-elastic/default


localhost:8081/actuator/bus-refresh    or    localhost:8080/actuator/bus-refresh


--------------------------------------------------------------------------------------
docker build -t  pintu12345/spring-micro-elastic:v3 . 
docker push pintu12345/spring-micro-elastic:v3

kubectl create -f C:\project\kubernaties\kubernetes\spring-micro-elastic-deployment.yaml
kubectl create -f C:\project\kubernaties\kubernetes\elastic-service .yaml

gcloud compute firewall-rules create test-node-port2 --allow tcp:31001



gcloud logging logs list
gcloud logging logs delete  projects/sillybilly-246306/logs/spring-micro-site-crawler
gcloud logging logs delete  projects/sillybilly-246306/logs/spring-micro-elastic
gcloud logging logs delete  projects/sillybilly-246306/logs/spring-micro-business-remoting







