package com.tencent.mm.plugin.game.wepkg.utils;

import com.tencent.mm.plugin.game.wepkg.model.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b$a {
    public final Map<String, e> kgm = new ConcurrentHashMap();

    public final e Er(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return (e) this.kgm.get(str);
    }

    public final e Es(String str) {
        return (e) this.kgm.remove(str);
    }
}
