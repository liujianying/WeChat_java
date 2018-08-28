package com.google.android.exoplayer2.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class q$f {
    private final Map<String, String> aBE = new HashMap();
    private Map<String, String> aBF;

    public final synchronized Map<String, String> lX() {
        if (this.aBF == null) {
            this.aBF = Collections.unmodifiableMap(new HashMap(this.aBE));
        }
        return this.aBF;
    }
}
