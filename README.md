# k8s-101
A simple k8s deployment and toy example

to build a docker image simply run `mvn clean package` (or `mvn compile jib:build`)

change the `deployment.yml` and apply changes by `kubectl apply -f deployment.yml`

use `kubectl get all` to se a detailed view

the app expose the following end-points
- `/api` - return a simple string
- `/healthCheck` - return 200 ok if `alive==true`
- `/kill` - make the healthcheck fail by setting `alive=false`
