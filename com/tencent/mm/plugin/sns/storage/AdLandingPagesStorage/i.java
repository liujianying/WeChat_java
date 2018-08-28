package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.database.Cursor;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.c.afl;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class i {
    private static final i nIR = new i();
    private Map<Long, String> jjd = new HashMap();
    private d nIS = af.byp();
    public y nIT = af.byq();
    public Map<String, String> nIU = new HashMap();

    static /* synthetic */ void a(i iVar) {
        x.i("OpenCanvasMgr", "clearing old canvasInfo cache");
        Cursor axc = iVar.nIS.axc();
        if (axc != null) {
            long currentTimeMillis = System.currentTimeMillis() - 777600000;
            while (axc.moveToNext()) {
                c cVar = new c();
                cVar.d(axc);
                if (cVar.field_createTime < currentTimeMillis) {
                    x.i("OpenCanvasMgr", "ad canvas eliminate %d " + cVar.field_canvasId);
                    iVar.nIS.a(cVar, new String[0]);
                }
            }
            axc.close();
            axc = iVar.nIT.axc();
            if (axc != null) {
                currentTimeMillis = System.currentTimeMillis() - 777600000;
                while (axc.moveToNext()) {
                    com.tencent.mm.plugin.sns.storage.x xVar = new com.tencent.mm.plugin.sns.storage.x();
                    xVar.d(axc);
                    if (xVar.field_createTime < currentTimeMillis) {
                        x.i("OpenCanvasMgr", "ux canvas eliminate %d " + xVar.field_canvasId);
                        iVar.nIT.a(xVar, new String[0]);
                    }
                }
                axc.close();
            }
        }
    }

    public static i bAE() {
        return nIR;
    }

    private i() {
        HandlerThread Xs = e.Xs("OpenCanvasMgr");
        Xs.start();
        new ag(Xs.getLooper()).postDelayed(new Runnable() {
            public final void run() {
                i.a(i.this);
            }
        }, 5000);
    }

    public final String h(long j, int i, int i2) {
        x.i("OpenCanvasMgr", "open pageId %d, preLoad %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (j <= 0) {
            return "";
        }
        String str = "";
        if (i2 != 1) {
            if (this.jjd.containsKey(Long.valueOf(j))) {
                str = (String) this.jjd.get(Long.valueOf(j));
            } else {
                c cVar = new c();
                cVar.field_canvasId = j;
                this.nIS.b(cVar, new String[0]);
                if (TextUtils.isEmpty(cVar.field_canvasXml)) {
                    str = "";
                } else {
                    this.jjd.put(Long.valueOf(j), cVar.field_canvasXml);
                    str = cVar.field_canvasXml;
                }
            }
        }
        if (i != 1 || !TextUtils.isEmpty(str)) {
            return str;
        }
        c cVar2 = new c();
        cVar2.field_canvasId = j;
        a aVar = new a();
        aVar.dIG = new yw();
        aVar.dIH = new yx();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
        aVar.dIF = 1286;
        b KT = aVar.KT();
        ((yw) KT.dID.dIL).rEZ = j;
        v.a(KT, new 2(this, j, i, cVar2));
        return "";
    }

    public final void p(long j, String str) {
        if (!TextUtils.isEmpty(str) && j > 0) {
            this.jjd.put(Long.valueOf(j), str);
            c cVar = new c();
            cVar.field_canvasId = j;
            cVar.field_canvasXml = str;
            this.nIS.a(cVar);
        }
    }

    public final String k(String str, String str2, int i, int i2) {
        x.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", new Object[]{str, str2, Integer.valueOf(i)});
        if (bi.oW(str)) {
            return "";
        }
        com.tencent.mm.plugin.sns.storage.x xVar;
        String str3 = "";
        if (i2 != 1) {
            Object obj;
            if (bi.oW(str2)) {
                str3 = str;
            } else {
                obj = str + str2;
            }
            if (this.nIU.containsKey(obj)) {
                str3 = (String) this.nIU.get(obj);
            } else {
                xVar = new com.tencent.mm.plugin.sns.storage.x();
                xVar.field_canvasId = str;
                xVar.field_canvasExt = str2;
                this.nIT.b(xVar, new String[]{"canvasId", "canvasExt"});
                if (TextUtils.isEmpty(xVar.field_canvasXml)) {
                    str3 = "";
                } else {
                    this.nIU.put(obj, xVar.field_canvasXml);
                    str3 = xVar.field_canvasXml;
                }
            }
        }
        if (i != 1 || !TextUtils.isEmpty(str3)) {
            return str3;
        }
        xVar = new com.tencent.mm.plugin.sns.storage.x();
        xVar.field_canvasId = str;
        a aVar = new a();
        aVar.dIG = new afl();
        aVar.dIH = new afm();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
        aVar.dIF = 1890;
        b KT = aVar.KT();
        afl afl = (afl) KT.dID.dIL;
        afl.rJs = str;
        afl.rJt = str2;
        v.a(KT, new 3(this, str, i, xVar));
        return "";
    }
}
