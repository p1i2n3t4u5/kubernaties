http://localhost:8000/currency-exchange/from/USD/to/INR

http://localhost:8000/h2-console

jdbc:h2:mem:testdb

spring-cloud-starter-config: config client is required to externalize the properties to config server

Running docker without plugin
---------------------------------
docker build -t  pintu12345/spring-micro-business-remoting:v2 .  --> create docker image from docker file

docker image list --> see created image 

docker run spring-micro-business-remoting --> run created image using image name

docker ps --> see all running containers

docker stop 7ce2a21f74f8  --> stop container using container id

docker rm 7ce2a21f74f8 --> remove container using container id

docker image list --> see created image 

docker push pintu12345/spring-micro-business-remoting --> push the image to docker hub

docker image  rm spring-micro-business-remoting --> remove created image 

docker run -it pintu12345/spring-micro-business-remoting:v1 sh  --> to open in interactive mode

docker run -d --rm pintu12345/spring-micro-business-remoting:v1  --> remove the container once stopped show long container id

docker logs -f containerid --> see the logs live with -f

docker run -d -p 8000:8000 pintu12345/spring-micro-business-remoting:v1  --> first is host ip


docker build -t  gcr.io/sillybilly-246306/spring-micro-business-remoting:v1 . 
docker run -d -p 8000:8000 gcr.io/sillybilly-246306/spring-micro-business-remoting:v1



Running Build and Push step separately
---------------------------------------
mvn dockerfile:build -DskipTests=true

mvn dockerfile:push -DskipTests=true

Running using mvn clean install 
---------------------------------
mvn clean install -DskipTests=true

Push images to google container registry
-------------------------------------------
mvn clean install -DskipTests=true
docker build -t  gcr.io/sillybilly-246306/spring-micro-business-remoting:v1 .
docker push gcr.io/sillybilly-246306/spring-micro-business-remoting:v1

gcloud config set container/cluster business-remoting-cluster-1

zipkin server url
------------------
http://localhost:9411/zipkin/


https://github.com/spotify/dockerfile-maven



kubectl create clusterrolebinding admin --clusterrole=cluster-admin --serviceaccount=default:default

docker build -t  pintu12345/spring-micro-business-remoting:v2 .

docker push  pintu12345/spring-micro-business-remoting:v2


Links
-------

https://github.com/kubernetes/ingress-nginx/blob/master/deploy/static/provider/cloud-generic.yaml
https://kubernetes.github.io/ingress-nginx/deploy/rbac/
http://rahmonov.me/posts/nginx-ingress-controller/
https://github.com/kubernetes/ingress-nginx/blob/master/docs/examples/rewrite/README.md
https://kubernetes.github.io/ingress-nginx/examples/rewrite/
https://kubernetes.io/docs/reference/kubectl/cheatsheet/



















