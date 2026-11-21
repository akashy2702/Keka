# Interview Starter

A minimal Java 21 / Spring Boot 3 backend starter with an in-memory items API, validation, consistent errors, and a configured outbound `RestClient`.

## Run

```bash
./mvnw spring-boot:run
```

The application listens on `http://localhost:8080`. No database or external service is needed to start it.

## API

### Create an jobItem

```bash
curl -i -X POST http://localhost:8080/api/v1/items \
  -H 'Content-Type: application/json' \
  -d '{"name":"Sample Item","description":"Test jobItem"}'
```

Returns `201 Created` with a `Location` header and a body such as:

```json
{
  "id": "generated-uuid",
  "name": "Sample Item",
  "description": "Test jobItem",
  "createdAt": "2026-11-20T10:00:00"
}
```

`name` is required, cannot be blank, and is limited to 100 characters. `description` is optional and limited to 1000 characters.

### Get an jobItem

```bash
curl http://localhost:8080/api/v1/items/{id}
```

### List items

```bash
curl http://localhost:8080/api/v1/items
```

### Delete an jobItem

```bash
curl -i -X DELETE http://localhost:8080/api/v1/items/{id}
```

Successful deletion returns `204 No Content`. Missing items return `404`; invalid or malformed requests return `400` with a JSON error body.

## Outbound HTTP

`ExternalApiClient` demonstrates typed GET and POST calls using the configured `RestClient`. Change `external-api.base-url` in `src/main/resources/application.yml` or set `EXTERNAL_API_BASE_URL`. Connect/read timeouts are configurable there, and outbound calls only happen when a client method is invoked.

## Add interview requirements

- **New POST endpoint:** add a request record under `dto`, annotate its fields, add a controller method, and implement the operation in the service. Return `201 Created` for a new resource.
- **Business rule:** put the rule in the service, not the controller or repository. Throw a focused runtime exception for a rejected operation and map it in `GlobalExceptionHandler`.
- **External API call:** inject `ExternalApiClient` into the service that needs it and call its typed `get` or `post` method. Keep URLs and timeouts in `application.yml`; do not call the external service during startup.
- **New entity/storage:** add a model record, a small repository interface, and an in-memory implementation backed by `ConcurrentHashMap`. Keep it independent of the service's rules.
- **Validation/error response:** add Jakarta constraints to the request record. Add one specific `@ExceptionHandler` when a new error needs a distinct HTTP status; unexpected errors already return a sanitized `500`.

## Tests

```bash
./mvnw test
```

## Structure

Application code is under `com.example.demo`, split into `controller`, `service`, `repository`, `dto`, `model`, `client`, `config`, and `exception`. `JobRepository` is the storage boundary; its in-memory implementation can be replaced with a database-backed implementation when needed.
