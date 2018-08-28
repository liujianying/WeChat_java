package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.k;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class b implements ar {
    private a iLB;
    private b iLC;
    boolean iLD = false;
    private com.tencent.mm.sdk.e.m.b iLE = new 1(this);
    boolean iLF = false;
    long iLG = 0;
    private final long iLH = 300000;
    private final long iLI = 4000;
    private final String iLJ = "fun1";
    int iLK = 0;
    private ag iLL = new 3(this, Looper.getMainLooper());

    private class b extends c<mb> {
        private b() {
            this.sFo = mb.class.getName().hashCode();
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
            this.sFo = mb.class.getName().hashCode();
        }

        private boolean a(mb mbVar) {
            if (!b.a(b.this)) {
                x.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
                return false;
            } else if (ad.getContext() == null) {
                x.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
                return false;
            } else {
                x.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[]{Integer.valueOf(mbVar.bWC.bWA), mbVar.bWC.scanResult});
                try {
                    switch (mbVar.bWC.bWA) {
                        case 0:
                            if (bi.oW(mbVar.bWC.scanResult) || !mbVar.bWC.scanResult.startsWith("qlauncher://")) {
                                return false;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
                            intent.setData(Uri.parse(mbVar.bWC.scanResult));
                            intent.setFlags(268435456);
                            ad.getContext().startActivity(intent);
                            mbVar.bWD.ret = 1;
                            return true;
                        default:
                            return false;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[]{e.getMessage()});
                    return false;
                }
            }
        }
    }

    static /* synthetic */ boolean a(b bVar) {
        if (ad.getContext() == null) {
            x.w("MicroMsg.SubCoreExtQLauncher", "isPluginInstall, ApplicationContext null");
            bVar.iLF = false;
            return false;
        } else if (System.currentTimeMillis() - bVar.iLG < 300000) {
            return bVar.iLF;
        } else {
            au.Em().H(new 2(bVar));
            return bVar.iLF;
        }
    }

    public static b aJl() {
        au.HN();
        b bVar = (b) bs.iK("plugin.extqlauncher");
        if (bVar != null) {
            return bVar;
        }
        bVar = new b();
        au.HN().a("plugin.extqlauncher", bVar);
        return bVar;
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        au.HU();
        com.tencent.mm.model.c.FW().a(this.iLE);
        if (this.iLB == null) {
            this.iLB = new a();
        }
        a.sFg.b(this.iLB);
        if (this.iLC == null) {
            this.iLC = new b(this, (byte) 0);
        }
        a.sFg.b(this.iLC);
    }

    public final void onAccountRelease() {
        if (this.iLB != null) {
            a.sFg.c(this.iLB);
        }
        if (this.iLC != null) {
            a.sFg.c(this.iLC);
        }
        au.HU();
        com.tencent.mm.model.c.FW().b(this.iLE);
        this.iLL.removeMessages(0);
    }

    public static int aJm() {
        if (au.HX()) {
            int hX = t.hX(s.dAN);
            int GB = k.GB();
            if ((q.GJ() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
                return hX - GB;
            }
            return hX;
        }
        x.w("MicroMsg.SubCoreExtQLauncher", "getMMUnread account not ready");
        return 0;
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void aJn() {
        this.iLL.removeMessages(0);
        this.iLL.sendEmptyMessageDelayed(0, 4000);
    }
}
