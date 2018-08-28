package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class k implements e {
    List<a> cWy = new ArrayList();
    at dRY = new at(1, "location_worker");
    int h = 300;
    LinkedList<b> kDb = new LinkedList();
    b kDc = null;
    int w = 300;

    public final void a(a aVar) {
        this.cWy.remove(aVar);
        x.i("MicroMsg.StaticMapServer", "removeCallback " + this.cWy.size());
        if (this.cWy.size() == 0) {
            x.i("MicroMsg.StaticMapServer", "clean task");
            this.kDb.clear();
            this.kDc = null;
            stop();
        }
    }

    public k() {
        start();
    }

    public final void start() {
        g.DF().a(648, this);
    }

    public final void stop() {
        x.i("MicroMsg.StaticMapServer", "stop static map server");
        g.DF().b(648, this);
    }

    final void OA() {
        if (this.kDc == null && this.kDb.size() > 0) {
            int intValue;
            this.kDc = (b) this.kDb.removeFirst();
            try {
                intValue = Integer.valueOf(bi.aG(com.tencent.mm.k.g.AT().getValue("StaticMapGetClient"), "")).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            x.i("MicroMsg.StaticMapServer", "run local %d", new Object[]{Integer.valueOf(intValue)});
            if (intValue == 0) {
                g.DF().a(new g(this.kDc.dRS, this.kDc.dRT, this.kDc.bSz + 1, this.w, this.h, b(this.kDc), w.chP()), 0);
                return;
            }
            int i = this.w;
            for (intValue = this.h; i * intValue > 270000; intValue = (int) (((double) intValue) / 1.2d)) {
                i = (int) (((double) i) / 1.2d);
            }
            if (bi.fU(ad.getContext())) {
                this.dRY.c(new a(this, true, String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.kDc.dRS), Float.valueOf(this.kDc.dRT), Integer.valueOf(this.kDc.bSz), w.chP()}), b(this.kDc)));
                return;
            }
            this.dRY.c(new a(this, false, String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.kDc.dRT), Float.valueOf(this.kDc.dRS), Integer.valueOf(this.kDc.bSz)}), b(this.kDc)));
        }
    }

    public static String b(b bVar) {
        String u = com.tencent.mm.a.g.u((bVar.toString()).getBytes());
        String str = c.Gc() + u.charAt(0) + u.charAt(1) + "/" + u.charAt(3) + u.charAt(4) + "/";
        if (!com.tencent.mm.a.e.cn(str)) {
            new File(str).mkdirs();
        }
        return str + "static_map_" + u;
    }

    private void gg(boolean z) {
        x.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            if (this.kDc != null) {
                for (a aVar : this.cWy) {
                    if (aVar != null) {
                        aVar.a(b(this.kDc), this.kDc);
                    }
                }
            }
        } else if (this.kDc != null) {
            for (a aVar2 : this.cWy) {
                if (aVar2 != null) {
                    aVar2.a(this.kDc);
                }
            }
        }
        this.kDc = null;
        OA();
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() != 648) {
            return;
        }
        if (i == 0 && i2 == 0 && this.kDc != null) {
            gg(true);
        } else {
            gg(false);
        }
    }
}
