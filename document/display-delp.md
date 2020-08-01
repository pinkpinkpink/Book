
apiVersion: apps/v1
kind: Deployment
metadata:
  labels:
    app: eemp-pr-gs-dbct-portal-s-display-server
  name: eemp-pr-gs-dbct-portal-s-display-server-deployment
spec:
  selector:
    matchLabels:
      app: eemp-pr-gs-dbct-portal-s-display-server
  template:
    metadata:
      labels:
        app: eemp-pr-gs-dbct-portal-s-display-server
    spec:
      containers:
        - ports:
            - name: port-8024
              containerPort: 8024
          name: eemp-pr-gs-dbct-portal-s-display-server
          image: >-
            10.18.101.186/dhd/com.zdww.eemp.pr-gs-dbct-portal-display/pr-gs-dbct-portal-display-s-full:v1
          imagePullPolicy: Always
      hostNetwork: true
      dnsPolicy: ClusterFirstWithHostNet
      restartPolicy: Always
      imagePullSecrets:
        - name: eemp-pr-gs-dbct-portal-s-server-secret
  replicas: 1



