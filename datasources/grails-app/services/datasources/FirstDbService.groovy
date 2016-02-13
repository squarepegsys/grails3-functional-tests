package datasources

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class FirstDbService {

   def dataSource

    def countBooks() {
        def sql =  new Sql(dataSource)

        def count = -1

        sql.eachRow("select count(1) as total from book") {
            count=it.total
        }

        return count

    }
}
