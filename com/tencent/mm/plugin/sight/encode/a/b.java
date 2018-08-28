package com.tencent.mm.plugin.sight.encode.a;

import com.tencent.mm.sdk.platformtools.ah;

public final class b {

    public interface a {
        void onError(int i);
    }

    public static void a(final a aVar, final int i) {
        if (aVar != null) {
            ah.A(new Runnable() {
                public final void run() {
                    aVar.onError(i);
                }
            });
        }
    }
}
