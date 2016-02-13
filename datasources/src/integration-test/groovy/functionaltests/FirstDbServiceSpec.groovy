package functionaltests

import datasources.FirstDbService
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification;

@Integration
@Rollback
class FirstDbServiceSpec extends Specification {

  @Autowired
  FirstDbService service

  void "Test that we can inject a datasource into a service"(){ 

    when:
    int total = service.countBooks()

    then:
    total==0
    

  }

}
