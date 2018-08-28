package com.tencent.mm.pluginsdk.g.a.b;

import java.io.IOException;

public final class f extends IOException {
    public final int httpStatusCode;
    public final IOException qCQ;

    public f(int i, IOException iOException) {
        this.httpStatusCode = i;
        this.qCQ = iOException;
    }

    public final String toString() {
        return "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.qCQ + '}';
    }
}
