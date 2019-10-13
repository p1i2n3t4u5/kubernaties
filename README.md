# kubernaties

steps to deploy in a google cluster
-----------------------------------
1) gcloud container clusters get-credentials standard-cluster-1 --zone us-central1-a --project sillybilly-246306

2) gcloud components update

3) gcloud config list

4) gcloud config set container/cluster standard-cluster-1

5) C:\project\kubernaties\kubernetes>gcloud config set container/cluster standard-cluster-1

6) gcloud compute firewall-rules create test-node-port1 --allow tcp:31000
   gcloud compute firewall-rules create test-node-port2 --allow tcp:31001
   gcloud compute firewall-rules create test-node-port3 --allow tcp:31002

C:\project\kubernaties\kubernetes>kubectl create -f spring-micro-business-remoting-deployment.yaml
deployment.apps/spring-micro-business-remoting created

C:\project\kubernaties\kubernetes>kubectl create -f spring-micro-elastic-deployment.yaml
deployment.apps/spring-micro-elastic created

C:\project\kubernaties\kubernetes>kubectl create -f spring-micro-site-crawler-deployment.yaml
deployment.apps/spring-micro-site-crawler created

C:\project\kubernaties\kubernetes>kubectl create -f business-remoting-service.yaml
service/business-remoting-service created

C:\project\kubernaties\kubernetes>kubectl create -f "elastic-service .yaml"
service/elastic-service created

C:\project\kubernaties\kubernetes>kubectl create -f "site-crawler-service .yaml"
service/site-crawler-service created

C:\project\kubernaties\kubernetes>kubectl create -f default-namespace-permission.yaml

C:\project\kubernaties\kubernetes>kubectl create -f ingress-service.yaml

C:\project\kubernaties\kubernetes>cd nginx

C:\project\kubernaties\kubernetes\nginx>kubectl create -f mandatory.yaml

C:\project\kubernaties\kubernetes\nginx>cd C:\project\kubernaties\kubernetes\properties

C:\project\kubernaties\kubernetes\properties>kubectl create -f site-crawler-configmap.yaml


C:\project\kubernaties\kubernetes\properties>kubectl create -f business-remoting-configmap.yaml

C:\project\kubernaties\kubernetes\properties>kubectl create -f elastic-configmap.yaml


C:\project\kubernaties\kubernetes>kubectl create -f spring-micro-business-remoting-deployment.yaml


C:\project\kubernaties\kubernetes>kubectl create -f spring-micro-elastic-deployment.yaml


C:\project\kubernaties\kubernetes>kubectl create -f spring-micro-site-crawler-deployment.yaml


C:\project\kubernaties\kubernetes>kubectl create -f business-remoting-service.yaml

C:\project\kubernaties\kubernetes>kubectl create -f "elastic-service .yaml"

C:\project\kubernaties\kubernetes>kubectl create -f "site-crawler-service .yaml"

C:\project\kubernaties\kubernetes>kubectl create -f default-namespace-permission.yaml

C:\project\kubernaties\kubernetes>kubectl create -f ingress-service.yaml

C:\project\kubernaties\kubernetes>cd nginx

C:\project\kubernaties\kubernetes\nginx>kubectl create -f mandatory.yaml

C:\project\kubernaties\kubernetes\nginx>cd C:\project\kubernaties\kubernetes\properties

C:\project\kubernaties\kubernetes\properties>kubectl create -f site-crawler-configmap.yaml

C:\project\kubernaties\kubernetes\properties>kubectl create -f business-remoting-configmap.yaml

C:\project\kubernaties\kubernetes\properties>kubectl create -f elastic-configmap.yaml
