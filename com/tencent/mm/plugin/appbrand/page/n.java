package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.report.a.b;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public class n extends FrameLayout {
    private g fdO;
    private LinkedList<l> gmH = new LinkedList();
    private LinkedList<l> gmI = new LinkedList();
    private LinkedList<Runnable> gmJ = new LinkedList();
    private p gmK;
    private volatile b gmL;
    public boolean gmM;
    private boolean gmN = false;
    private a gmO;
    private String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.n$13 */
    class AnonymousClass13 implements Runnable {
        final /* synthetic */ String val$url;

        public AnonymousClass13(String str) {
            this.val$url = str;
        }

        public final void run() {
            n.a(n.this, this.val$url, aa.gpi);
        }
    }

    public n(Context context, g gVar) {
        super(context);
        this.fdO = gVar;
        this.mAppId = gVar.mAppId;
        this.gmL = new b(this.fdO);
    }

    public b getReporter() {
        return this.gmL;
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public int getPageCount() {
        return this.gmH.size() + this.gmI.size();
    }

    public String getAppId() {
        return this.mAppId;
    }

    public void sW(String str) {
        runOnUiThread(new 1(this, str));
    }

    public void V(String str, boolean z) {
        runOnUiThread(new 12(this, str, z));
    }

    public final void uW(final String str) {
        runOnUiThread(new Runnable() {
            public final void run() {
                n.a(n.this, str, aa.gpl);
            }
        });
    }

    public void agJ() {
        runOnUiThread(new Runnable() {
            public final void run() {
                n.this.ko(1);
            }
        });
    }

    public void ko(int i) {
        runOnUiThread(new 17(this, i));
    }

    protected final void b(String str, aa aaVar) {
        View bVar;
        x.d("MicroMsg.AppBrandPageContainer", "navigateToNext: %s, Staging Count: %d", new Object[]{str, Integer.valueOf(this.gmI.size())});
        if (this.fdO.aaq()) {
            bVar = new com.tencent.mm.plugin.appbrand.game.page.b(getContext(), this);
        } else {
            boolean z;
            if (!this.fdO.aaq()) {
                if (aaVar == aa.gpl) {
                    z = true;
                } else if (aaVar == aa.gpj || aaVar == aa.gpk) {
                    z = this.fdO.fcv.foP.rH(str);
                } else {
                    int size = (this.gmH.size() + 1) - (aaVar == aa.gpi ? 1 : 0);
                    if (this.fdO.fcv.foP.rH(str) && size == 1) {
                        z = true;
                    }
                }
                if (z) {
                    bVar = new s(getContext(), this);
                } else {
                    bVar = new e(getContext(), this);
                }
            }
            z = false;
            if (z) {
                bVar = new s(getContext(), this);
            } else {
                bVar = new e(getContext(), this);
            }
        }
        addView(bVar, 0);
        2 2 = new 2(this, new boolean[]{false}, aaVar, bVar);
        this.gmI.push(bVar);
        this.gmJ.push(2);
        if (this.gmH.size() == 0) {
            postDelayed(2, 5000);
        } else {
            postDelayed(2, 500);
        }
        bVar.getCurrentPageView().a(new 3(this, bVar, 2, System.currentTimeMillis(), aaVar));
        bVar.loadUrl(str);
        bVar.a(aaVar);
    }

    private void uX(String str) {
        p currentPageView = getCurrentPage().getCurrentPageView();
        l uY = uY(str);
        if (uY != null) {
            uY.loadUrl(str);
            uY.a(aa.gpl);
            uY.alJ();
        } else {
            l uZ = uZ(str);
            if (uZ != null) {
                uZ.loadUrl(str);
                uY = (l) this.gmH.getFirst();
                a(uY, uZ);
                a(uZ, uY, aa.gpl);
            }
            uY = uZ;
        }
        if (uY != null) {
            this.gmL.a(uY.getCurrentPageView(), currentPageView, aa.gpl);
        }
    }

    private void alK() {
        for (int size = this.gmI.size() - 1; size >= 0; size--) {
            if (this.gmJ.get(size) != null) {
                ((Runnable) this.gmJ.get(size)).run();
            }
        }
        this.gmI.clear();
        this.gmJ.clear();
    }

    private void a(l lVar, l lVar2) {
        Iterator it = this.gmH.iterator();
        Object obj = null;
        while (it.hasNext()) {
            l lVar3 = (l) it.next();
            if (lVar3 == lVar) {
                obj = 1;
            } else if (lVar3 == lVar2) {
                return;
            } else {
                if (obj != null) {
                    a(lVar3);
                    it.remove();
                }
            }
        }
    }

    private void a(l lVar, final l lVar2, aa aaVar) {
        Runnable anonymousClass4;
        Animator ofFloat;
        this.gmH.remove(lVar2);
        if (lVar2.mSwiping) {
            a(lVar2);
        } else {
            anonymousClass4 = new Runnable() {
                public final void run() {
                    n.this.a(lVar2);
                }
            };
            ofFloat = ObjectAnimator.ofFloat(lVar2, "translationX", new float[]{0.0f, (float) lVar2.getWidth()});
            ofFloat.setDuration(250);
            a(ofFloat, anonymousClass4);
        }
        x.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[]{lVar.getCurrentUrl(), lVar2.getCurrentUrl()});
        lVar.a(aaVar);
        lVar.agE();
        if (lVar2.mSwiping) {
            lVar.alJ();
            return;
        }
        anonymousClass4 = new 5(this, lVar);
        ofFloat = ObjectAnimator.ofFloat(lVar, "translationX", new float[]{-(((float) lVar.getWidth()) * 0.25f), 0.0f});
        ofFloat.setDuration(250);
        a(ofFloat, anonymousClass4);
    }

    private synchronized void a(l lVar, boolean z) {
        x.i("MicroMsg.AppBrandPageContainer", "hy: test switchPageIn");
        if (lVar != null) {
            this.gmH.remove(lVar);
            this.gmH.push(lVar);
            this.gmI.remove(lVar);
            lVar.bringToFront();
            requestLayout();
            invalidate();
            lVar.agE();
            Runnable 7 = new 7(this, lVar);
            if (z) {
                Animator ofFloat = ObjectAnimator.ofFloat(lVar, "translationX", new float[]{(float) lVar.getWidth(), 0.0f});
                ofFloat.setDuration(250);
                a(ofFloat, 7);
            } else {
                7.run();
            }
        }
    }

    private l uY(String str) {
        if (this.gmH.size() == 0) {
            return null;
        }
        return ((this.gmH.getFirst() instanceof e) && ((l) this.gmH.getFirst()).sV(str)) ? (l) this.gmH.getFirst() : null;
    }

    private l uZ(String str) {
        if (this.gmH.size() < 2) {
            return null;
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.gmH.size()) {
                return null;
            }
            if ((this.gmH.get(i2) instanceof e) && ((l) this.gmH.get(i2)).sV(str)) {
                return (l) this.gmH.get(i2);
            }
            i = i2 + 1;
        }
    }

    private void a(l lVar) {
        lVar.setVisibility(8);
        lVar.agD();
        removeView(lVar);
        lVar.cleanup();
    }

    public void c(String str, String str2, int[] iArr) {
        runOnUiThread(new 8(this, str, str2, iArr));
    }

    public synchronized l getCurrentPage() {
        l lVar;
        if (this.gmI.isEmpty()) {
            try {
                lVar = (l) this.gmH.getFirst();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandPageContainer", e.getMessage());
                lVar = null;
            }
        } else {
            lVar = (l) this.gmI.getFirst();
        }
        return lVar;
    }

    public synchronized String getCurrentUrl() {
        String currentUrl;
        l currentPage = getCurrentPage();
        if (currentPage != null) {
            currentUrl = currentPage.getCurrentUrl();
        } else {
            currentUrl = null;
        }
        return currentUrl;
    }

    public final void cleanup() {
        l lVar;
        if (!bi.cX(this.gmH)) {
            b bVar = this.gmL;
            p currentPageView = getCurrentPage().getCurrentPageView();
            if (!(currentPageView == null || bVar.gmD)) {
                bVar.c(currentPageView);
            }
        }
        Iterator it = this.gmH.iterator();
        while (it.hasNext()) {
            lVar = (l) it.next();
            lVar.agD();
            lVar.cleanup();
        }
        it = this.gmI.iterator();
        while (it.hasNext()) {
            lVar = (l) it.next();
            lVar.agD();
            lVar.cleanup();
        }
        if (this.gmK != null) {
            this.gmK.cleanup();
        }
        this.gmH.clear();
        this.gmI.clear();
    }

    public p getPreloadedPageView() {
        p pVar = null;
        if (this.fdO.aaq()) {
            return null;
        }
        if (this.gmK == null) {
            if (this.fdO.fcv.foS || !d.anb()) {
                pVar = d.vx(this.fdO.mAppId);
            }
            if (pVar == null) {
                pVar = new p();
            }
            pVar.a(getContext(), this.fdO);
            return pVar;
        }
        p pVar2 = this.gmK;
        this.gmK = null;
        pVar2.show();
        removeView(pVar2.getContentView());
        return pVar2;
    }

    public final void alL() {
        if (!this.fdO.aaq()) {
            postDelayed(new 9(this), 200);
        }
    }

    public a getAppConfig() {
        return this.fdO.fcv;
    }

    public g getRuntime() {
        return this.fdO;
    }

    public void agL() {
        if (this.gmH.size() != 0) {
            ((l) this.gmH.getFirst()).agE();
            this.gmL.d(((l) this.gmH.getFirst()).getCurrentPageView());
        }
    }

    public void agK() {
        if (this.gmH.size() != 0) {
            ((l) this.gmH.getFirst()).agF();
            this.gmL.c(((l) this.gmH.getFirst()).getCurrentPageView());
        }
    }

    public void setOnReadyListener(a aVar) {
        this.gmO = aVar;
    }

    public final void alM() {
        if (!this.gmN) {
            this.gmN = true;
            this.gmO.aax();
            ReportStorageSizeTask reportStorageSizeTask = new ReportStorageSizeTask();
            reportStorageSizeTask.appId = this.mAppId;
            AppBrandMainProcessService.a(reportStorageSizeTask);
        }
    }

    private void a(Animator animator, Runnable runnable) {
        animator.addListener(new 10(this, runnable));
        animator.start();
    }

    public boolean agM() {
        if (this.fdO.aal() != null || this.gmH.size() > 1) {
            return true;
        }
        if (!getRuntime().aap()) {
            return false;
        }
        getCurrentPage().setNeedRequestActivityTranslucent(true);
        getCurrentPage().mC(false);
        return true;
    }

    public void agI() {
        Iterator it = this.gmH.iterator();
        while (it.hasNext()) {
            ((l) it.next()).agI();
        }
    }
}
