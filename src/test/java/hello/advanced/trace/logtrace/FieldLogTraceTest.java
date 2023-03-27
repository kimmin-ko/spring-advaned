package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end() {
        TraceStatus status1 = trace.begin("controller");
        TraceStatus status2 = trace.begin("service");

        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        TraceStatus status1 = trace.begin("controller");
        TraceStatus status2 = trace.begin("service");

        trace.exception(status2, new IllegalArgumentException("service exception"));
        trace.exception(status1, new IllegalArgumentException("controller exception"));
    }

}