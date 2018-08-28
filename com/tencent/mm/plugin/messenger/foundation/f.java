package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.by.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.q.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.LinkedList;

public final class f implements com.tencent.mm.plugin.zero.a.f {
    private s lcm;

    public final void bD(Object obj) {
        c bcZ = t.bcZ();
        if (bcZ != null) {
            this.lcm = (s) bcZ.get();
        }
        if (this.lcm == null) {
            this.lcm = new a((byte) 0);
        }
        if (obj instanceof k) {
            ((i) g.l(i.class)).bcY().Gz(((k) obj).TAG);
        } else if (obj instanceof String) {
            if (obj.equals("NetSceneInit")) {
                ((i) g.l(i.class)).bcY().Gz((String) obj);
            }
        } else if (obj instanceof p.c) {
            ((i) g.l(i.class)).bcY().Gz(obj.toString());
        }
    }

    public final void a(pm pmVar, byte[] bArr, boolean z) {
        q sw = a.sw(pmVar.rtM);
        if (sw != null) {
            try {
                sw.a(pmVar, bArr, z, this.lcm);
                return;
            } catch (IOException e) {
                x.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + e.getMessage());
                throw new RuntimeException("docmd: parse protobuf error");
            }
        }
        x.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[]{Integer.valueOf(pmVar.rtM)});
    }

    public final void bE(Object obj) {
        if (obj instanceof k) {
            this.lcm.atH();
            ((i) g.l(i.class)).bcY().GA(((k) obj).TAG);
            ah Em = g.Em();
            String str = ((k) obj).TAG;
            com.tencent.mm.modelmulti.q qVar = ((k) obj).dZJ;
            k kVar = (k) obj;
            LinkedList linkedList = (kVar.dZR == null || kVar.dZR.qWX.rnB == null) ? null : kVar.dZR.qWX.rnB.hbG;
            Em.H(new b(str, qVar, linkedList));
        } else if ((obj instanceof String) && obj.equals("NetSceneInit")) {
            this.lcm.atH();
            ((i) g.l(i.class)).bcY().GA((String) obj);
        } else if (obj instanceof p.c) {
            this.lcm.atH();
            ((i) g.l(i.class)).bcY().GA(obj.toString());
        }
    }

    public final void bF(Object obj) {
        if (obj instanceof k) {
            ((i) g.l(i.class)).bcY().GA(((k) obj).TAG);
        }
    }
}
