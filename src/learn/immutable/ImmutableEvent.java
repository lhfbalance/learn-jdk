package learn.immutable;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class ImmutableEvent {

    private final int id;

    private final String message;

    public ImmutableEvent(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public ImmutableEvent(ImmutableEvent immutableEvent) {
        this.id = immutableEvent.id;
        this.message = immutableEvent.message;
    }
}
