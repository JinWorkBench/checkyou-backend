# 1. OpenJDK 17 이미지 기반
FROM openjdk:17-jdk-slim

# 2. 프로젝트 jar 파일 복사할 디렉토리 생성
WORKDIR /app

# 3. 의존성 캐싱을 위해 gradle 빌드 먼저 수행
COPY . /app

# 4. 빌드 (build/libs/*.jar 생성)
RUN ./gradlew build

# 5. 실행
CMD ["java", "-jar", "build/libs/backend-0.0.1-SNAPSHOT.jar"]
