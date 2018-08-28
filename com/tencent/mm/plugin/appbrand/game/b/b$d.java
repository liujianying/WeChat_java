package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.handler.image.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class b$d extends a {
    private final g fdD;

    public /* synthetic */ b$d(g gVar, byte b) {
        this(gVar);
    }

    private b$d(g gVar) {
        this.fdD = gVar;
    }

    public final boolean bV(String str) {
        return true;
    }

    public final InputStream bW(String str) {
        if (this.fdD == null) {
            x.e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, runtime NULL", new Object[]{str});
            return null;
        }
        h hVar = new h();
        if (this.fdD.fcw.a(str, hVar) == j.OK && hVar.value != null) {
            return new com.tencent.mm.plugin.appbrand.l.a((ByteBuffer) hVar.value);
        }
        x.e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, ret %s", new Object[]{str, r1.name()});
        return null;
    }
}
