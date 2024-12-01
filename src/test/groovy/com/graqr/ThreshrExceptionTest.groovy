package com.graqr

import com.graqr.threshr.ThreshrException
import spock.lang.Specification

class ThreshrExceptionTest extends Specification {

    def "test ThreshrException with message"() {
        when:
        try {
            new File(null as String)
        } catch (Exception e) {
            throw new ThreshrException("test", e)
        }

        and:
        def error = thrown(ThreshrException)

        then:
        error.getMessage() == "test"

        and:
        error.cause.class == ThreshrException
    }

    def "test ThreshrException with message and cause"() {
        when:
        try {
            new File(null as String)
        } catch (Exception e) {
            throw new ThreshrException(e)
        }

        and:
        def error = thrown(ThreshrException)

        then:
        error.getMessage() == null

        and:
        error.cause.class == ThreshrException
    }
}
