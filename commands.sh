docker build . -t lasalhettiarachchi/postms:1.0.0
docker images
docker run -p 8080:8080 lasalhettiarachchi/postms:1.0.0
docker images push docker.io/lasalhettiarachchi/postms:1.0.0