# detach-cache

## 스프링 캐시가 적용된 상태에서의 LazyLoading 테스트

스프링 캐시는 하이버네이트가 관리하지 않는 캐시이기 때문에
A 라는 엔티티를 조회하되
1. 한 메서드는 하위 자식필드를 fetch 하지 않고 캐시한다.
2. 다른 메서드로 조회한 후 자식필드를 fetch 한다.

이 때 LazyInitializing exception 발생
