# 각 마이크로 서비스의 deployment에서 이미지 수정 필요
# label과 이미지 이름 소문자로 변경 필요


cd Pay
# jar 파일 생성
mvn package
# 이미지 빌드
docker build -t user1919.azurecr.io/pay .
# acr에 이미지 푸시
docker push user1919.azurecr.io/pay
# kubernetes에 service, deployment 배포
kubectl apply -f kubernetes
# Pod 재배포 
# Deployment가 변경되어야 새로운 이미지로 Pod를 실행한다.
# Deployment가 변경되지 않아도 새로운 Image로 Pod 실행하기 위함
kubectl rollout restart deployment pay  
cd ..

cd Reservation
# jar 파일 생성
mvn package
# 이미지 빌드
docker build -t user1919.azurecr.io/reservation .
# acr에 이미지 푸시
docker push user1919.azurecr.io/reservation
# kubernetes에 service, deployment 배포
kubectl apply -f kubernetes
# Pod 재배포 
# Deployment가 변경되어야 새로운 이미지로 Pod를 실행한다.
# Deployment가 변경되지 않아도 새로운 Image로 Pod 실행하기 위함
kubectl rollout restart deployment reservation  
cd ..

cd Ticket
# jar 파일 생성
mvn package
# 이미지 빌드
docker build -t user1919.azurecr.io/ticket .
# acr에 이미지 푸시
docker push user1919.azurecr.io/ticket
# kubernetes에 service, deployment 배포
kubectl apply -f kubernetes
# Pod 재배포
# Deployment가 변경되어야 새로운 이미지로 Pod를 실행한다.
# Deployment가 변경되지 않아도 새로운 Image로 Pod 실행하기 위함
kubectl rollout restart deployment ticket  
cd ..

cd gateway
# jar 파일 생성
mvn package
# 이미지 빌드
docker build -t user1919.azurecr.io/gateway .
# acr에 이미지 푸시
docker push user1919.azurecr.io/gateway
# kubernetes에 service, deployment 배포
kubectl create deploy gateway --image=user1919.azurecr.io/gateway   
kubectl expose deploy gateway --type=LoadBalancer --port=8080   
cd ..

cd MyReservation
# jar 파일 생성
mvn package
# 이미지 빌드
docker build -t user1919.azurecr.io/myreservation .
# acr에 이미지 푸시
docker push user1919.azurecr.io/myreservation
# kubernetes에 service, deployment 배포
kubectl apply -f kubernetes
# Pod 재배포
# Deployment가 변경되어야 새로운 이미지로 Pod를 실행한다.
# Deployment가 변경되지 않아도 새로운 Image로 Pod 실행하기 위함
kubectl rollout restart deployment myreservation  
cd ..
