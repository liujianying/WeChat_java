package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

final class e extends b {
    private static final Map<String, e> ghA = new ConcurrentHashMap();
    private final String ghB;
    private final String ghC;

    static e up(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return (e) ghA.remove(str);
    }

    e(Context context, String str) {
        this.ghB = str;
        this.ghC = context.getClass().getName();
        ghA.put(str, this);
        a aVar = new a(str);
        long toMillis = TimeUnit.SECONDS.toMillis(300);
        aVar.J(toMillis, toMillis);
    }

    protected final String akW() {
        return this.ghC;
    }
}
