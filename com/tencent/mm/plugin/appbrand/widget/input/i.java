package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.e.a;
import android.support.v4.view.z;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.Reference;
import java.util.Map;

public class i implements e {
    private static final i gGR = new 1();
    private static final a<p, i> gGX = new a();
    private final p fJQ;
    public final Map<a, i> gGQ;
    private final int gGS;
    private final int gGT;
    private int gGU;
    private boolean gGV;
    private int gGW;
    private final Runnable gGY;
    private final Runnable gGZ;

    static /* synthetic */ View b(i iVar) {
        return !iVar.fJQ.isRunning() ? null : iVar.fJQ.aha();
    }

    static /* synthetic */ void d(i iVar) {
        if (iVar.gGQ.size() > 0) {
            for (a aps : (a[]) iVar.gGQ.keySet().toArray(new a[iVar.gGQ.size()])) {
                aps.aps();
            }
        }
    }

    static /* synthetic */ int f(i iVar) {
        int i = iVar.gGU + 1;
        iVar.gGU = i;
        return i;
    }

    static /* synthetic */ int i(i iVar) {
        Display defaultDisplay = ((WindowManager) iVar.fJQ.getContentView().getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    static /* synthetic */ void k(i iVar) {
        if (iVar.gGQ.size() > 0) {
            for (a apr : (a[]) iVar.gGQ.keySet().toArray(new a[iVar.gGQ.size()])) {
                apr.apr();
            }
        }
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.gGQ.remove(aVar);
        }
    }

    private i() {
        this.gGQ = new a();
        this.gGT = 5;
        this.gGU = 0;
        this.gGV = false;
        this.gGW = 0;
        this.gGY = new 2(this);
        this.gGZ = new 3(this);
        this.fJQ = null;
        this.gGS = 0;
    }

    private i(p pVar) {
        int i = 0;
        this.gGQ = new a();
        this.gGT = 5;
        this.gGU = 0;
        this.gGV = false;
        this.gGW = 0;
        this.gGY = new 2(this);
        this.gGZ = new 3(this);
        this.fJQ = pVar;
        this.fJQ.a(this);
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(pVar.mContext, 10);
        if (VERSION.SDK_INT >= 21) {
            i = j.any();
        }
        this.gGS = i + fromDPToPix;
    }

    public static i a(Reference<p> reference) {
        return l(reference == null ? null : (p) reference.get());
    }

    public static i l(p pVar) {
        if (pVar == null || !pVar.isRunning()) {
            x.k("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page " + pVar, new Object[0]);
            return gGR;
        }
        i iVar = (i) gGX.get(pVar);
        if (iVar != null) {
            return iVar;
        }
        iVar = new i(pVar);
        gGX.put(pVar, iVar);
        return iVar;
    }

    private void do(boolean z) {
        if (z) {
            this.gGU = 0;
            this.gGV = false;
        }
        if (!this.fJQ.isRunning()) {
            return;
        }
        if (this.gGV) {
            this.gGU = 0;
        } else if (this.gGU == 0) {
            x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", new Object[]{Boolean.valueOf(z.ak(this.fJQ.getContentView()))});
            this.fJQ.getContentView().post(this.gGZ);
        } else {
            x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", new Object[]{Boolean.valueOf(z.ak(this.fJQ.getContentView()))});
            this.fJQ.getContentView().postOnAnimationDelayed(this.gGZ, 100);
        }
    }

    public void apo() {
        do(true);
    }

    public void app() {
        if (this.fJQ.isRunning()) {
            this.gGV = true;
            this.fJQ.getContentView().post(this.gGY);
        }
    }

    public void onDestroy() {
        this.fJQ.b(this);
        gGX.remove(this.fJQ);
    }
}
