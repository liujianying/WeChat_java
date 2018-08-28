package com.tencent.mm.bg;

import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import com.tencent.mm.model.p.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static m qUZ;
    public static l qVa;

    public static void Um(String str) {
        if (((h) g.Ef().DM()).ES()) {
            d.a(str, qUZ, qVa);
        }
    }

    public static void b(String str, p pVar) {
        new 1(str, pVar).alone();
    }

    public static a Un(String str) {
        x.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new 2(str), str);
        return new 2(str);
    }
}
