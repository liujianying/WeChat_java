package com.tencent.mm.plugin.game.gamewebview.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<String, Integer> jGa;

    static {
        Map hashMap = new HashMap();
        jGa = hashMap;
        hashMap.put("addDownloadTaskStraight", Integer.valueOf(1));
        jGa.put(f.NAME, Integer.valueOf(2));
        jGa.put("pauseDownloadTask", Integer.valueOf(3));
        jGa.put(aq.NAME, Integer.valueOf(4));
        jGa.put("openCustomWebview", Integer.valueOf(5));
        jGa.put("openUrlWithExtraWebview", Integer.valueOf(6));
        jGa.put("sendAppMessage", Integer.valueOf(7));
    }

    public static int CZ(String str) {
        if (jGa.containsKey(str)) {
            return ((Integer) jGa.get(str)).intValue();
        }
        return 0;
    }
}
