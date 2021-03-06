package functionaltests

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class ForwardingSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test forward to same controller"() {
        when:"A forward is issued to an action in the same controller"
            go '/forwarding/one'

        then:"The forward works correctly"
        	$().text() == 'Forward Destination. Params:'
    }

    void "Test forward to named controller"() {
        when:"A forward is issued to an action in the same controller"
            go '/forwarding/two'

        then:"The forward works correctly"
            $().text() == 'Forward Destination. Params:'
    }

    void "Test forward with parameters"() {
        when:"A forward is issued to an action with parameters"
            go '/forwarding/three'

        then:"The forward works correctly"
            $().text() == 'Forward Destination. Params: test'
    }

    void 'Test forwarding to an action which returns a Map'() {
        when:
            go '/forwarding/forwardToList'

        then:
            $('li', text: 'Jeff')
            $('li', text: 'Zack')
            $('li', text: 'Jake')
            $('li', text: 'Betsy')
    }
}
