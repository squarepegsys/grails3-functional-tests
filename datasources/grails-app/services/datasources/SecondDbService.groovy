package datasources

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class SecondDbService {

   def secondary

    def countBooks() {
        def sql =  new Sql(secondary)

        def count = -1

        sql.eachRow("select count(1) as total from book") {
            count=it.total
        }

        return count

    }
}
