package com.tencent.mm.pluginsdk;

import com.tencent.mm.pluginsdk.a.c;
import com.tencent.mm.pluginsdk.o.e;
import com.tencent.mm.sdk.platformtools.x;

public class o$a {
    public static e qyh;
    public static o$c qyi;
    public static o$d qyj;

    public static e cbj() {
        if (qyh == null) {
            x.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
            qyh = new c();
        }
        return qyh;
    }
}
