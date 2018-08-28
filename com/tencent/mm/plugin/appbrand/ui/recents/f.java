package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.e;
import com.tencent.mm.plugin.appbrand.appusage.e.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.recents.d.c;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.chg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class f extends h implements b, d.b {
    Activity ftd;
    private a gAm = new a();
    d gAn;
    private boolean gAo = false;
    private OnClickListener gAp = null;
    volatile boolean mFinished = false;

    private static class a {
        String gAt;
        Integer gAu;
        List<String> gAv;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static /* synthetic */ void a(f fVar) {
        boolean z = false;
        aks aks = e.acM().fll;
        if (aks == null) {
            d dVar = fVar.gAn;
            x.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingFailed");
            dVar.gzC = c.gzQ;
            dVar.gzD.gzp.cAH();
            dVar.bN(dVar.gzD.gzp);
            dVar.bN(dVar.gzD.gzT);
            d.bO(dVar.gzD.gzW);
            return;
        }
        if (aks != null && (aks.rNB == 1 || aks.rNB == 2)) {
            e.c jK = e.c.jK(aks.rNB);
            String str = "MicroMsg.AppBrandListRecentsListWAGameHeader";
            String str2 = "Use Game Entry %s";
            Object[] objArr = new Object[1];
            objArr[0] = jK == null ? "null" : jK.name();
            x.i(str, str2, objArr);
            if (jK == e.c.flr) {
                final String str3 = aks.rNA;
                if (bi.oW(str3)) {
                    String str4 = "MicroMsg.AppBrandListRecentsListWAGameHeader";
                    str = "makeH5ClickListener failed. link_wxagame = [%s]";
                    Object[] objArr2 = new Object[1];
                    if (str3 == null) {
                        str3 = "null";
                    }
                    objArr2[0] = str3;
                    x.e(str4, str, objArr2);
                } else {
                    x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "H5 link is [%s]", new Object[]{str3});
                    if (bi.oW(str3)) {
                        fVar.gAp = null;
                    } else {
                        fVar.gAp = new OnClickListener() {
                            public final void onClick(View view) {
                                x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke H5 click listener, invoke h5");
                                ((com.tencent.mm.plugin.appbrand.compat.a.a) g.l(com.tencent.mm.plugin.appbrand.compat.a.a.class)).T(f.this.ftd, str3);
                            }
                        };
                    }
                }
            } else if (jK == e.c.flq) {
                chg chg = aks.rNz;
                if (chg == null) {
                    x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "makeWxAppClickListener failed. wxaInfo = null.");
                } else {
                    str = "MicroMsg.AppBrandListRecentsListWAGameHeader";
                    str2 = "WxApp link is [%s]";
                    objArr = new Object[1];
                    objArr[0] = chg.path == null ? "null" : chg.path;
                    x.i(str, str2, objArr);
                    new AppBrandStatObject().scene = 1001;
                    fVar.gAp = new 3(fVar, chg);
                }
            }
        } else if (aks == null) {
            x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processClickListenerInfo resp is null");
        } else {
            x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processClickListenerInfo resp is not null, but action_code is %d", new Object[]{Integer.valueOf(aks.rNB)});
        }
        if (aks == null) {
            x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processRenderInfo GetWxaGameResponse");
        } else {
            x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "processRenderInfo entry = [%s] ec = [%s] new = [%s] nc = [%s]", new Object[]{aks.rND, aks.rNE, aks.rNC, aks.rNF});
            fVar.gAm.gAt = bi.aG(aks.rNC, "");
            fVar.gAm.gAu = vL(aks.rNF);
            fVar.gAm.gAv = new ArrayList(Math.max(aks.rNy == null ? 0 : aks.rNy.size(), 0));
            if (aks.rNy != null && aks.rNy.size() > 0) {
                Iterator it = aks.rNy.iterator();
                while (it.hasNext()) {
                    chg chg2 = (chg) it.next();
                    if (chg2 != null) {
                        fVar.gAm.gAv.add(chg2.rYG);
                    }
                }
            }
        }
        if (aks.rNs == 1) {
            z = true;
        }
        fVar.gAo = z;
        fVar.gAn.a(fVar.gAm.gAv, fVar.gAm.gAt, fVar.gAm.gAu);
    }

    f(Activity activity, ViewGroup viewGroup) {
        this.gAn = new d(viewGroup, j.app_brand_launcher_head_wxagame);
        this.gAn.gzB = this;
        this.ftd = activity;
    }

    final void aog() {
        e acM = e.acM();
        df(e.enabled());
        if (e.enabled()) {
            if (this != null) {
                synchronized (acM.mLock) {
                    acM.flk.add(this);
                }
            }
            acM.refresh();
            this.gAn.aoi();
            this.mFinished = false;
        }
    }

    final void onDetached() {
        this.mFinished = true;
        e acM = e.acM();
        if (this != null) {
            synchronized (acM.mLock) {
                acM.flk.remove(this);
            }
        }
    }

    final void onResume() {
    }

    public final void acN() {
        x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "AppBrandListRecentsListWAGameHeader.onWAGameDataUpdate");
        e.acM();
        if (e.enabled() && !this.mFinished) {
            View view = this.gAn.gzD.SU;
            if (view != null) {
                view.post(new Runnable() {
                    public final void run() {
                        if (!f.this.mFinished && f.this.gAn.gzD.SU != null) {
                            f.a(f.this);
                        }
                    }
                });
            }
        }
    }

    private static Integer vL(String str) {
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception e) {
            return null;
        }
    }

    final View aoh() {
        return this.gAn.gzD.SU;
    }

    public final void a(int i, View view) {
        if (i == 0 || i == c.gzO || i == c.gzN) {
            x.v("MicroMsg.AppBrandListRecentsListWAGameHeader", "onClick ");
        } else if (i == c.gzQ) {
            this.gAn.aoi();
            e.acM().refresh();
        } else if (i == c.gzP && this.gAp != null) {
            this.gAp.onClick(view);
            if (this.gAo) {
                d dVar = this.gAn;
                if (dVar.gzD.gzV != null) {
                    dVar.gzD.gzV.animate().alpha(0.0f).setDuration(200).start();
                }
            }
        }
    }
}
