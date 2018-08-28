package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.m;
import com.tencent.mm.plugin.appbrand.appusage.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.r.l;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class a extends com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a {
    private int fDQ = 0;
    private Dialog gvJ = null;
    private LinearLayoutManager gyA;
    private n gyB;
    private final i gyC = new i();
    private final ah gyD = new ah("AppBrandLauncherUI#RecentsListUI");
    private final m gyE = new m();
    private c gyF;
    private c gyG;
    private b gyH;
    private final k gyI = new k();
    private boolean gyJ = false;
    private boolean gyK = false;
    private final l gyL = new 10(this);
    private final a gyM = new a(this, (byte) 0);
    private final com.tencent.mm.sdk.e.j.a gyN = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if ("single".equals(str)) {
                if (2 == lVar.fBN || 3 == lVar.fBN) {
                    a.a(a.this, false, -1, true);
                }
            } else if ("batch".equals(str) && 3 == lVar.fBN) {
                a.a(a.this, false, -1, true);
            }
        }
    };
    private final com.tencent.mm.sdk.e.j.a gyO = new 12(this);
    private final com.tencent.mm.sdk.e.j.a gyP = new 13(this);
    private final com.tencent.mm.sdk.e.j.a gyQ = new 14(this);
    private final b gyR = new b(this, (byte) 0);
    private final int gyq;
    private final boolean gyr = true;
    private final boolean gys;
    private final g gyt;
    private final Bundle gyu = new Bundle();
    private final AtomicLong gyv = new AtomicLong(-1);
    private final AtomicLong gyw = new AtomicLong(-1);
    private final AtomicBoolean gyx = new AtomicBoolean(false);
    private final AtomicLong gyy = new AtomicLong(Long.MAX_VALUE);
    private LoadMoreRecyclerView gyz;
    private String mSceneId;

    private final class c extends o<k, d> {
        final Map<String, String> gze;

        private c() {
            this.gze = new HashMap();
        }

        /* synthetic */ c(a aVar, byte b) {
            this();
        }

        public final /* synthetic */ long bn(Object obj) {
            k kVar = (k) obj;
            return (long) (kVar.bGy + kVar.fig).hashCode();
        }

        private void a(d dVar) {
            a.this.gyz;
            if (LoadMoreRecyclerView.aZ(dVar.SU) == a.this.gyB.getItemCount() - 1) {
                dVar.eCO.setVisibility(8);
            } else {
                dVar.eCO.setVisibility(0);
            }
            if (a.this.gys) {
                TextView textView = dVar.gzi;
                a.this.gyz;
                textView.setText(String.valueOf(LoadMoreRecyclerView.aZ(dVar.SU)));
                dVar.gzi.setVisibility(0);
                return;
            }
            dVar.gzi.setVisibility(8);
        }

        private static void a(d dVar, int i) {
            CharSequence jB = com.tencent.mm.plugin.appbrand.appcache.a.jB(i);
            if (bi.oW(jB)) {
                dVar.gzh.setVisibility(8);
                return;
            }
            dVar.gzh.setText(jB);
            dVar.gzh.setVisibility(0);
        }

        private static void a(d dVar, String str) {
            dVar.gzf.setText(str);
        }

        final void b(d dVar, String str) {
            a.this.gyJ;
            this.gze.put(str, b.Ka().a(dVar.gwj, str, com.tencent.mm.modelappbrand.b.a.JZ(), f.dGr));
        }
    }

    static /* synthetic */ void a(a aVar, ArrayList arrayList, boolean z) {
        aVar.WJ();
        aVar.gyz.ds(true);
        if (!(z || bi.cX(arrayList))) {
            o.abK();
        }
        if (z) {
            aVar.gyK = true;
            aVar.gyx.set(false);
            aVar.gyH.setLoading(com.tencent.mm.plugin.appbrand.appusage.c.acL());
        }
        int size;
        if (bi.cX(arrayList)) {
            if (z) {
                size = aVar.gyC.aom().size();
                int size2 = aVar.gyC.aon().size();
                aVar.gyC.aon().clear();
                if (size2 > 0) {
                    aVar.gyB.aa(size, size2);
                }
                aVar.aob();
            }
        } else if (aVar.gyB != null && aVar.gyz != null) {
            size = aVar.gyC.aom().size();
            aVar.gyC.aon().clear();
            aVar.gyC.aon().addAll(arrayList);
            aVar.gyB.X(size, arrayList.size());
        }
    }

    static /* synthetic */ void a(a aVar, boolean z, long j, boolean z2) {
        if (!aVar.aoa()) {
            i aoo = aVar.gyC.aoo();
            if (!bi.cX(aoo) || z) {
                long j2;
                long j3;
                ArrayList aon = aoo.aon();
                if (bi.cX(aon)) {
                    j2 = Long.MAX_VALUE;
                    j3 = 0;
                } else {
                    long j4 = ((k) aon.get(aon.size() - 1)).dlj;
                    j2 = Math.max(((k) aon.get(0)).dlj, j);
                    j3 = j4;
                }
                i e = i.e(aVar.gyr ? e.abh().jM(com.tencent.mm.plugin.appbrand.appusage.l.b.fml) : null, aVar.gyt.k(p.g(p.a(e.abg().fmt.fmu).a("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s>=? and %s<=? and %s=?", new Object[]{"updateTime", "updateTime", "scene"}), new String[]{String.valueOf(j3), String.valueOf(j2), "2"}, null, null, String.format(Locale.US, " %s desc ", new Object[]{"updateTime"}), 2))));
                if (!aVar.aoa()) {
                    if (bi.cX(e)) {
                        aVar.runOnUiThread(new 1(aVar));
                    } else if (bi.cX(aoo)) {
                        aVar.runOnUiThread(new 8(aVar, e));
                    } else {
                        aVar.gyD.uW();
                        com.tencent.mm.plugin.appbrand.r.k.b a = com.tencent.mm.plugin.appbrand.r.k.a(new j(aoo, e), z2);
                        Object obj = (a.gBR == null || a.gBR.size() <= 0) ? null : 1;
                        if (obj != null) {
                            aVar.runOnUiThread(new 9(aVar, e, a));
                        }
                        aVar.gyD.cik();
                    }
                }
            }
        }
    }

    static /* synthetic */ void b(a aVar, ArrayList arrayList) {
        int size = aVar.gyC.size();
        if (!bi.cX(arrayList)) {
            aVar.gyC.aon().addAll(arrayList);
            aVar.gyB.Z(size, arrayList.size());
            if (size > 0) {
                aVar.gyB.bl(size - 1);
            }
        } else if (!com.tencent.mm.plugin.appbrand.appusage.c.acL()) {
            aVar.gyH.setLoading(false);
            if (aVar.gyH.SU != null) {
                aVar.gyH.SU.post(new 5(aVar));
            }
        } else if (!(aVar.gyH == null || aVar.gyH.SU == null || !aVar.gyH.SU.isShown())) {
            aVar.u(new 6(aVar));
        }
        aVar.gyx.set(false);
    }

    static /* synthetic */ void o(a aVar) {
        if (aVar.gyK && !aVar.gyx.get()) {
            aVar.gyw.set(bi.VF());
            if (com.tencent.mm.plugin.appbrand.appusage.c.acL()) {
                com.tencent.mm.plugin.appbrand.appusage.c.acK().a(aVar.gyw.get(), false, aVar.gyu);
                aVar.gyx.set(true);
                return;
            }
            ArrayList aon = aVar.gyC.aon();
            aVar.gyD.H(new 4(aVar, bi.cX(aon) ? Long.MAX_VALUE : ((k) aon.get(aon.size() - 1)).dlj));
        }
    }

    public a() {
        boolean z = true;
        if (!(com.tencent.mm.sdk.a.b.chp() && g.Ei().DT().getBoolean(com.tencent.mm.storage.aa.a.sTB, false))) {
            z = false;
        }
        this.gys = z;
        this.gyt = new g(this.gyr);
        this.gyq = m.fmn != null ? m.fmn.intValue() : AppBrandGlobalSystemConfig.adZ().fpM;
        e.abh().fmf = this.gyq;
    }

    private boolean aoa() {
        boolean z = true;
        MMActivity mMActivity = (MMActivity) getActivity();
        if (mMActivity == null) {
            return true;
        }
        synchronized (mMActivity) {
            if (!(mMActivity.isFinishing() || mMActivity.tlP)) {
                z = false;
            }
        }
        return z;
    }

    public final void onResume() {
        super.onResume();
        getActivity().setTitle(j.app_brand_entrance);
        if (this.gyz != null) {
            this.gyz.setLayoutFrozen(false);
        }
        StringBuilder append = new StringBuilder().append(System.currentTimeMillis());
        g.Eg();
        this.mSceneId = append.append(com.tencent.mm.a.o.getString(com.tencent.mm.kernel.a.Df())).toString();
        int i = this.fDQ + 1;
        this.fDQ = i;
        if (i > 1 && this.gyG != null) {
            this.gyG.onResume();
        }
    }

    public final void onPause() {
        super.onPause();
        if (this.gyz != null) {
            this.gyz.setLayoutFrozen(true);
        }
    }

    public final void anq() {
        super.anq();
        if (this.gyz != null) {
            this.gyz.setAccessibilityDelegate(null);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (this.gyG != null) {
            this.gyG.onDetached();
        }
        if (this.gyH != null) {
            b bVar = this.gyH;
            bVar.SU = null;
            bVar.gzp = null;
            bVar.gzr = null;
        }
        if (this.gyB != null) {
            this.gyB.b(this.gyR);
        }
        if (this.gyF != null) {
            this.gyF.gze.clear();
            this.gyF = null;
        }
        if (g.Eg().dpD && !com.tencent.mm.kernel.a.Dr()) {
            q.aei().d(this.gyP);
            e.abg().d(this.gyO);
            e.abh().d(this.gyN);
            com.tencent.mm.plugin.appbrand.appusage.c.acK().d(this.gyQ);
        }
        this.gyD.lnJ.quit();
        this.gyv.set(-1);
        this.gyw.set(-1);
        this.gyx.set(false);
        this.gyy.set(Long.MAX_VALUE);
        this.gyI.c(this.gyR);
        this.gyI.c(this.gyM);
    }

    public final void anp() {
        if (this.gyz != null) {
            this.gyz.smoothScrollToPosition(0);
        }
    }

    public final void setScene(int i) {
        super.setScene(i);
        this.gyu.putInt("launcher_ui_enter_scene", i);
    }

    public final void initView() {
        getActivity();
        this.gyA = new 15(this);
        this.gyz = new 2(this, getContext());
        ((FrameLayout) this.FU).addView(this.gyz, new LayoutParams(-1, -1));
        this.gyz.a(new f(this, (byte) 0));
        this.gyz.setItemAnimator(this.gyI);
        this.gyI.b(this.gyR);
        this.gyI.b(this.gyM);
        n nVar = new n(this.gyC);
        c cVar = new c(this, (byte) 0);
        this.gyF = cVar;
        nVar.gBb.put(k.class.hashCode(), cVar);
        this.gyB = nVar;
        this.gyB.fX();
        this.gyB.a(this.gyR);
        this.gyz.setAdapter(this.gyB);
        this.gyz.a(new e(this, (byte) 0));
        this.gyG = new c(getActivity(), this.gyz);
        this.gyz.addHeaderView(this.gyG.goL);
        this.gyG.goL.setVisibility(8);
        this.gyG.aog();
        this.gyH = new b(getContext(), this.gyz);
        this.gyH.setLoading(true);
        this.gyz.setLoadingView(this.gyH.SU);
        this.gyz.ds(false);
        this.gyz.setOnLoadingStateChangedListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a() {
            public final void anH() {
                b m = a.this.gyH;
                Object obj = (m.gzp == null || !m.gzp.isShown()) ? null : 1;
                if (obj != null) {
                    a.o(a.this);
                }
            }
        });
        if (com.tencent.mm.plugin.appbrand.m.a.amT()) {
            long currentTimeMillis = System.currentTimeMillis();
            Object obj = g.Ei().DT().get(com.tencent.mm.storage.aa.a.sVC, null);
            long longValue = (obj == null || !(obj instanceof Long)) ? 0 : ((Long) obj).longValue();
            String language = Locale.getDefault().getLanguage();
            Object obj2 = g.Ei().DT().get(com.tencent.mm.storage.aa.a.sVz, null);
            if (currentTimeMillis - longValue >= 3600000 || obj2 == null || !obj2.equals(language)) {
                g.Eh().dpP.a(new com.tencent.mm.plugin.appbrand.j.b(), 0);
            }
            x.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", new Object[]{obj2, language, Long.valueOf(longValue), Long.valueOf(currentTimeMillis)});
        } else {
            x.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
        }
        WJ();
        this.gvJ = com.tencent.mm.plugin.appbrand.ui.j.cI(getActivity());
        this.gvJ.show();
        this.gyI.gAB = false;
        q.aei().a(this.gyP, this.gyD.lnJ.getLooper());
        e.abg().a(this.gyO, this.gyD.lnJ.getLooper());
        e.abh().a(this.gyN, this.gyD.lnJ.getLooper());
        com.tencent.mm.plugin.appbrand.appusage.c.acK().a(this.gyQ, this.gyD.lnJ.getLooper());
        this.gyv.set(bi.VF());
        this.gyD.L(new 7(this));
    }

    private boolean aob() {
        if (!this.gyB.isEmpty() || ((this.gyG.goL != null && this.gyG.goL.getVisibility() == 0) || getActivity() == null)) {
            return true;
        }
        ((AppBrandLauncherUI) getActivity()).db(false);
        return false;
    }

    private void WJ() {
        if (this.gvJ != null) {
            this.gvJ.dismiss();
        }
        this.gvJ = null;
    }
}
