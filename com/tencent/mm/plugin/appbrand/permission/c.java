package com.tencent.mm.plugin.appbrand.permission;

import android.support.v4.e.a;
import android.text.TextUtils;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.b.c.7;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.n.d;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public class c {
    private static final int fwA = (-bi.getInt(af.exh, 0));
    private static final a<String, c> gqi = new a();
    private static final c gqj = new 1();
    private final g fdO;
    private final LinkedList<b> gqk;
    private final Object gql;
    private AppRuntimeApiPermissionBundle gqm;

    public interface b {
        void a(a aVar);
    }

    /* synthetic */ c() {
        this(null);
    }

    static /* synthetic */ void b(c cVar) {
        LinkedList linkedList = new LinkedList();
        synchronized (cVar.gqk) {
            linkedList.addAll(cVar.gqk);
            cVar.gqk.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(a.amr());
        }
    }

    public static c u(g gVar) {
        return a(gVar, true);
    }

    public static c a(g gVar, boolean z) {
        if (gVar == null || TextUtils.isEmpty(gVar.mAppId)) {
            x.e("MicroMsg.AppRuntimeApiPermissionController", "obtain dummy controller, stack %s", new Object[]{bi.i(new Throwable())});
            return gqj;
        }
        c cVar;
        synchronized (gqi) {
            cVar = (c) gqi.get(gVar.mAppId);
            if (cVar == null && z) {
                cVar = new c(gVar);
                gqi.put(gVar.mAppId, cVar);
            }
        }
        return cVar;
    }

    public static int a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        String appId = cVar.getAppId();
        int i = fwA;
        int ahI = bVar.ahI();
        if (i == -1) {
            x.d("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[]{appId, Integer.valueOf(ahI)});
            return 1;
        } else if (i == -2) {
            x.d("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[]{appId, Integer.valueOf(ahI)});
            return 0;
        } else if (cVar.getRuntime() == null) {
            x.e("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, apiName = %s, null runtime from component", new Object[]{appId, bVar.getName()});
            return 0;
        } else if ((bVar instanceof d) && (cVar instanceof p)) {
            return 1;
        } else {
            byte[] bArr;
            int i2;
            AppRuntimeApiPermissionBundle amo = a(cVar.getRuntime(), true).amo();
            if (cVar instanceof l) {
                switch (5.fjn[cVar.getRuntime().fcL.fjj.acv().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        bArr = amo.gqg;
                        break;
                    default:
                        bArr = amo.gqf;
                        break;
                }
            }
            bArr = amo.gqf;
            if (ahI == -2) {
                i = 1;
            } else if (ahI == -1) {
                i = (com.tencent.mm.protocal.d.qVS || (com.tencent.mm.protocal.d.qVN & WebView.NORMAL_MODE_ALPHA) <= 47) ? 1 : 0;
                i = i != 0 ? 1 : 0;
            } else {
                i = (ahI >= bArr.length || ahI < 0) ? 0 : bArr[ahI];
            }
            if (com.tencent.mm.compatible.loader.a.a(o.fFp, bVar.getClass()) || com.tencent.mm.compatible.loader.a.a(o.fFq, bVar.getClass())) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                x.i("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, apiName = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[]{appId, bVar.getName(), Integer.valueOf(ahI), Integer.valueOf(bArr.length), Integer.valueOf(i)});
            }
            return i;
        }
    }

    public static boolean b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        return a(cVar, bVar) == 1;
    }

    private c(g gVar) {
        this.gqk = new LinkedList();
        this.fdO = gVar;
        this.gql = new byte[0];
        if (gVar != null) {
            synchronized (this.gql) {
                this.gqm = gVar.fcu.fqP;
            }
            String str = gVar.mAppId;
            e.a(str, new 2(this, str));
            gVar.fcL.a(new 3(this));
        }
    }

    private AppRuntimeApiPermissionBundle amo() {
        AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle;
        synchronized (this.gql) {
            appRuntimeApiPermissionBundle = this.gqm;
        }
        return appRuntimeApiPermissionBundle;
    }

    public void a(AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle) {
        if (appRuntimeApiPermissionBundle != null) {
            synchronized (this.gql) {
                this.gqm = appRuntimeApiPermissionBundle;
            }
        }
    }

    public a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar, b bVar2) {
        if (bVar == null || cVar == null) {
            return a.amq();
        }
        com.tencent.mm.plugin.appbrand.b.a acv = cVar.getRuntime().fcL.fjj.acv();
        int a = a(cVar, bVar);
        String appId = cVar.getAppId();
        if (a == 6) {
            a.a(cVar.getRuntime(), bVar);
            return a.amq();
        } else if (a == 1) {
            if (!(cVar instanceof l) || acv != com.tencent.mm.plugin.appbrand.b.a.fjg || !com.tencent.mm.compatible.loader.a.a(o.fFr, bVar.getClass())) {
                return a.amr();
            }
            return new a(2, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{bVar.getName(), acv.name().toLowerCase(), "permission ok", "network api interrupted in suspend state"}));
        } else if (a == 4) {
            if (b.bI(appId, bVar.getName())) {
                return a.amr();
            }
            b.a(appId, bVar.getName(), new 4(this, bVar2));
            return a.amu();
        } else if (a == 7) {
            boolean z;
            com.tencent.mm.plugin.appbrand.b.c cVar2 = this.fdO.fcL.fjj;
            switch (7.fjn[cVar2.acv().ordinal()]) {
                case 1:
                    z = true;
                    break;
                case 2:
                case 3:
                    z = false;
                    break;
                case 4:
                    z = ((Boolean) new c$5(cVar2).a(new ag(cVar2.sJQ.getLooper()))).booleanValue();
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                return a.amr();
            }
            return new a(2, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{bVar.getName(), acv.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state"}));
        } else if (a != 8) {
            return a.amq();
        } else {
            if (bVar2 != null) {
                synchronized (this.gqk) {
                    this.gqk.addLast(bVar2);
                }
            }
            return a.amu();
        }
    }
}
