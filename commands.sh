docker build --platform=linux/amd64 . -t lasalhettiarachchi/postmsitp:1.0.0
docker images
docker run -p 8080:8080 lasalhettiarachchi/postmsitp:1.0.0
docker push docker.io/lasalhettiarachchi/postmsitp:1.0.0