## 외부 라이브러리 및 사용 목적
| 라이브러리 | 사용 목적 |
|------------|------------|
| **Spring Boot** | 웹 애플리케이션 프레임워크, 애플리케이션 구동 및 설정 관리 |
| **Spring Data JPA** | ORM 기반 DB 접근 (Hibernate 기반) |
| **Spring Cloud OpenFeign** | 선언형 HTTP 클라이언트, 마이크로서비스 간 통신 및 외부 API 연동 |
| **Spring Data Redis** | 캐싱 및 조회수 중복 방지 (In-memory DB 활용) |
| **Spring AOP** | 전역 예외 처리 등 횡단 관심사 분리 |
| **Lombok** | 보일러플레이트 코드 제거 (컴파일 시 annotation 처리) |
| **MySQL Connector/J** | MySQL 연동 JDBC 드라이버 |

## docker 실행 순서
### 프로젝트 디렉토리 이동
```
cd assignment
```
### Docker 이미지 빌드
```
docker build -t syncpay-app .
```
### 애플리케이션 실행
```
docker run -p 8080:8080 syncpay-app
```
### DB / Redis 설정
```
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
  application:
    name: syncpay
  datasource:
    url: jdbc:mysql://localhost:3306/"your_database"
    username: "your_username"
    password: "your_password"
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: create-drop
  data:
    redis:
      host: localhost
      port: 6379

payment:
  toss:
   SECRET_KEY : "your_toss_secret_key"
  kakao:
    SECRET_KEY : "your_kakao_secret_key"
```
### 항목별 설명
| 설정 항목                        | 설명                         |
|-------------------------------|----------------------------|
| `your_database`               | 연결할 MySQL 데이터베이스 이름 |
| `your_username`               | MySQL 사용자명                 |
| `your_password`               | MySQL 비밀번호                 |
| `ddl-auto: create-drop`       | 실행 시 테이블 자동 생성/삭제 (운영 시에는 `update` 또는 `none` 권장) |
| `your_toss_secret_key`        | [토스페이](https://developers.tosspayments.com/)에서 발급받은 Secret Key |
| `your_kakao_secret_key`       | [카카오페이](https://developers.kakao.com/)에서 발급받은 Secret Key |