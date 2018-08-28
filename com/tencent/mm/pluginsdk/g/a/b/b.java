package com.tencent.mm.pluginsdk.g.a.b;

import java.io.IOException;

public final class b extends IOException {
    private final long cfA;
    private final long qCP;

    public b() {
        this(0, 0);
    }

    public b(long j, long j2) {
        super(String.format("contentLength: %d, requestRange:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        this.cfA = j;
        this.qCP = j2;
    }

    public final String toString() {
        return "FileSizeOutOfRangeException{contentLength=" + this.cfA + ", requestRange=" + this.qCP + '}';
    }
}
