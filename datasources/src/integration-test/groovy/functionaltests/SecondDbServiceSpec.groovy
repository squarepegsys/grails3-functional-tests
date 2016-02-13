package functionaltests

import datasources.SecondDbService
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class SecondDbServiceSpec extends Specification {

  @Autowired
  SecondDbService service

  void "Test that we can inject a datasource into a service"(){ 

    when:
    int total = service.countBooks()

    then:
    total==0
    

  }

}
