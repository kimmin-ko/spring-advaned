package hello.advanced.trace;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class TraceId {

    private final String id;
    private final int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public TraceId createNextId() {
        return new TraceId(this.id, this.level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(this.id, this.level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    // private //
    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
