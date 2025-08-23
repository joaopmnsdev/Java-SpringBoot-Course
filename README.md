# Java Spring Boot Course — API de Vendas

> **Visão**: Um ecossistema Spring Boot 3.5 + Java 21 para treinar práticas profissionais (REST, JPA, camadas) e servir como base para evoluções futuras (Docker, CI/CD e Cloud).

## 📦 Stack & Principais Tecnologias
- **Java 21**
- **Spring Boot 3.5.3**
  - Spring Web (`REST`)
  - Spring Data JPA (`Hibernate`)
- **Banco**: H2 em memória (perfil `test`)
- **Build**: Maven Wrapper (`mvnw`)
- **Postman**: Teste das requisições (`http`)

## 🗂️ Estrutura (resumo)
```
src/main/java/com/marcon/course/
├── CourseApplication.java
├── config/TestConfig.java
├── entities/
│   ├── User.java
│   ├── Order.java
│   ├── OrderItem.java
│   ├── Product.java
│   ├── Category.java
│   ├── Payment.java
│   └── pk/OrderItemPK.java
├── enums/OrderStatus.java
├── repositories/...
├── resources/
│   ├── UserResource.java
│   ├── OrderResource.java
│   ├── ProductResource.java
│   └── CategoryResource.java
└── services/...
```
> Camadas organizadas em **resources** (controladores REST), **services** (regras de negócio), **repositories** (acesso a dados) e **entities** (modelo de domínio).

## 🚀 Como rodar
Com Java instalado (21), use o Maven Wrapper:

```bash
# 1) Rodar com perfil de testes (H2 + carga inicial via TestConfig)
./mvnw spring-boot:run
```

> O **perfil ativo padrão** no `application.properties` é `test` (`spring.profiles.active=test`).

## 🗃️ Banco H2 e Console
- URL do console: `http://localhost:8080/h2-console`
- JDBC: `jdbc:h2:mem:testdb`  
- Usuário: `sa` · Senha: *(vazia)*  
- Dialeto: `org.hibernate.dialect.H2Dialect`  
> A carga inicial (usuários, pedidos, produtos, categorias) é inserida automaticamente pelo `TestConfig` quando o perfil `test` está ativo.

## 🌐 Endpoints (principais)
- **Users**: `/users`
  - `GET /users` — lista usuários
  - `GET /users/{{id}}` — listar por id
  - `PUT /users/{{id}}` — atualizar
  - `DELETE /users/{{id}}` — remover
  - `POST /users` — inserir
- **Products**: `/products`
  - `GET /products` — lista produtos
  - `GET /products/{{id}}` — listar por id
- **Categories**: `/categories`
  - `GET /categories` — lista categorias
  - `GET /categories/{{id}}` — listar por id
- **Orders**: `/orders`
  - `GET /orders` — lista pedidos
  - `GET /orders/{{id}}` — listar por id

### Exemplos com `curl`
```bash
curl http://localhost:8080/users
curl http://localhost:8080/users/1
curl -X PUT http://localhost:8080/users/1
  -H 'Content-Type: application/json'
  -d '{{"name":"Maria Brown","email":"maria@example.com","phone":"999999999","password":"123456"}}'
curl -X DELETE http://localhost:8080/users/1
curl -X POST http://localhost:8080/users \
  -H 'Content-Type: application/json' \
  -d '{"name":"João Marcon","email":"joao@example.com","phone":"47999999999","password":"123456"}'

curl http://localhost:8080/products
curl http://localhost:8080/orders
curl http://localhost:8080/categories
```

## 🧱 Modelo de Domínio
- **User** ⟷ **Order** (1:N)  
- **Order** ⟷ **OrderItem** ⟷ **Product** (N:N com atributos)  
- **Order** ⟷ **Payment** (1:1)  
- **Product** ⟷ **Category** (N:N)  
- **OrderStatus** enum para estados do pedido.

## 🔐 Tratamento de Erros
- Handler global em `resources/execptions/ResourceExceptionHandler.java` e modelo `StandartError`.
- Exceções de serviço em `services/execptions/*` (por ex. `ResourceNotFoundException`, `DatabaseException`).

## 🧭 Roadmap (sugestões para evoluir o projeto)
- [ ] **Documentação OpenAPI/Swagger** (springdoc-openapi) em `/swagger-ui.html`
- [ ] **Validações Bean Validation** (javax/jakarta validation) nos DTOs
- [ ] **DTOs + ModelMapper/MapStruct** para isolar entidade ↔ API
- [ ] **Pagination & Sorting** com `Pageable` nos `GET`
- [ ] **Autenticação & Autorização**: Spring Security + JWT
- [ ] **Observabilidade**: Actuator, logs estruturados, métricas (Micrometer/Prometheus)
- [ ] **Docker**: Dockerfile + docker-compose (H2 não é necessário, mas útil para testes)
- [ ] **CI**: GitHub Actions (build, testes, Quality Gate)
- [ ] **Profiles**: `dev` (PostgreSQL/MySQL) e `prod` (seeds desativados)
- [ ] **Testes**: integração com @SpringBootTest + Testcontainers

## 📝 Licença
Este projeto é de estudo. Use livremente para aprender, experimentar e evoluir.

