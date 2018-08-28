package com.tencent.mm.ak.a;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b {
    public com.tencent.mm.ak.a.a.b dWS;
    h dWT;
    Executor dWU;
    public final Map<Integer, String> dWV = Collections.synchronizedMap(new HashMap());
    public HashMap<Integer, com.tencent.mm.ak.a.f.b> dWW = new HashMap();

    public b(com.tencent.mm.ak.a.a.b bVar) {
        this.dWS = bVar;
        this.dWT = bVar.dXs;
        this.dWU = bVar.dXt;
        this.dWS.dXm.a(this.dWS.dXo);
    }

    public final Bitmap ma(String str) {
        if (this.dWS != null) {
            return this.dWS.dXl.jz(str);
        }
        return null;
    }

    public final void a(c cVar) {
        this.dWV.remove(Integer.valueOf(cVar.Pr()));
        x.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[]{Integer.valueOf(this.dWV.size()), Integer.valueOf(cVar.Pr())});
    }
}
