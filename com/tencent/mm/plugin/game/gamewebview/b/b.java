package com.tencent.mm.plugin.game.gamewebview.b;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class b {
    public static Map<String, a> jHU;

    public static void a(a aVar) {
        if (!bi.oW(aVar.getName())) {
            jHU.put(aVar.getName(), aVar);
        }
    }
}
