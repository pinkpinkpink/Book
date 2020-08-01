apiVersion: apps/v1
kind: Deployment
metadata:
  labels:
    app: eemp-pr-gs-dbct-portal-s-server
  name: eemp-pr-gs-dbct-portal-s-server-deployment
  namespace: dbct-partion
spec:
  apiVersion: apps/v1
  kind: Deployment
  metadata:
    labels:
      app: eemp-pr-gs-dbct-portal-s-server
    name: eemp-pr-gs-dbct-portal-s-server-deployment
  spec:
    selector:
      matchLabels:
        app: eemp-pr-gs-dbct-portal-s-server
    template:
      metadata:
        labels:
          app: eemp-pr-gs-dbct-portal-s-server
      spec:
        containers:
          - ports:
              - name: port-8025
                containerPort: 8025
            name: eemp-pr-gs-dbct-portal-s-server
            image: '10.18.101.186/dhd/com.zdww.eemp.pr-gs-dbct-portal-manage/pr-gs-dbct-portal-manage-s-full:v1'
            imagePullPolicy: Always
        hostNetwork: true
        dnsPolicy: ClusterFirstWithHostNet
        restartPolicy: Always
        imagePullSecrets:
          - name: public-secret
    replicas: 1
  
  
  
  
  
  
  
  





