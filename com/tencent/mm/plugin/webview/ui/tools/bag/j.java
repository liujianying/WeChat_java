package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import org.json.JSONObject;

public enum j {
    ;
    
    private long ngz;
    private WebViewBag qcn;
    public String qco;
    private a qcp;
    public boolean qcq;
    public a qcr;

    private j(String str) {
        this.ngz = -1;
        this.qcr = new a();
    }

    public final void nc(boolean z) {
        x.i("MicroMsg.WebViewBagMgr", "checkResumeBag mInWebViewUIFromBag:%b", new Object[]{Boolean.valueOf(this.qcq)});
        if (bi.oW(this.qcr.url) || this.qcq) {
            bVg();
            x.i("MicroMsg.WebViewBagMgr", "checkResumeBag hide bag");
        } else if (this.qcn == null || this.qcn.getVisibility() != 0) {
            nd(z);
            x.i("MicroMsg.WebViewBagMgr", "checkResumeBag show bag");
        } else {
            x.i("MicroMsg.WebViewBagMgr", "already show");
        }
    }

    public final void bWU() {
        x.i("MicroMsg.WebViewBagMgr", "clearBag mCurrentUrl:%s", new Object[]{this.qcr.url});
        bVg();
        a aVar = this.qcr;
        aVar.url = null;
        aVar.bWP = null;
        aVar.dRk = 0;
        aVar.scene = 0;
        aVar.uec = new JSONObject();
        aVar.save();
        cKK();
    }

    final void nd(boolean z) {
        x.i("MicroMsg.WebViewBagMgr", "showBag url:%s", new Object[]{this.qcr.url});
        if (!b.bv(ad.getContext())) {
            x.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
        } else if (bi.oW(this.qcr.url)) {
            bWU();
        } else {
            boolean z2 = this.qcn == null;
            if (this.qcn == null) {
                this.qcp = new a(new 2(this));
                this.qcn = new WebViewBag(ad.getContext(), null);
                this.qcn.setListener(new 3(this));
                this.qcn.setOnClickListener(new 4(this));
            }
            aK(1.0f);
            this.qcn.setTouchEnable(true);
            this.qcn.setIcon(this.qcr.bWP);
            bWW();
            this.qco = ac.ce(String.format("bagId#%d#%s", new Object[]{Long.valueOf(System.currentTimeMillis()), this.qcr.url}));
            x.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", new Object[]{Boolean.valueOf(z2), this.qco});
            if (z2) {
                if (z) {
                    this.qcn.setVisibility(4);
                    cKJ();
                    this.qcn.setVisibility(0);
                    this.qcn.bWT();
                    return;
                }
                cKJ();
            } else if (this.qcn.getVisibility() != 0) {
                this.qcn.setVisibility(0);
                if (z) {
                    this.qcn.bWT();
                }
            } else {
                x.i("MicroMsg.WebViewBagMgr", "already showed");
            }
        }
    }

    public final void bWV() {
        x.i("MicroMsg.WebViewBagMgr", "removeBag");
        if (this.qcn != null) {
            WebViewBag webViewBag = this.qcn;
            5 5 = new 5(this);
            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            Animation animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.setDuration(80);
            animationSet.restrictDuration(100);
            animationSet.setAnimationListener(5);
            animationSet.setFillAfter(true);
            webViewBag.ido.startAnimation(animationSet);
        }
    }

    public final void bVg() {
        if (this.qcn != null) {
            this.qcn.setVisibility(8);
        }
    }

    public final void aK(float f) {
        if (this.qcn != null) {
            this.qcn.setAlpha(f);
            if (f == 0.0f) {
                this.qcn.setVisibility(8);
            } else {
                this.qcn.setVisibility(0);
            }
        }
    }

    final void a(String str, int i, String str2, Bundle bundle) {
        this.qcr.url = str;
        this.qcr.bWP = str2;
        this.qcr.scene = i;
        this.qcr.dRk = bi.VF();
        this.qcr.uec = n.an(bundle);
        this.qcr.save();
    }

    private void cKJ() {
        x.i("MicroMsg.WebViewBagMgr", "attachBag");
        WindowManager windowManager = (WindowManager) ad.getContext().getSystemService("window");
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.format = 1;
        layoutParams.packageName = ad.getContext().getPackageName();
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        layoutParams.width = b.qbm;
        layoutParams.height = b.qbm;
        layoutParams.x = this.qcr.qcw;
        layoutParams.y = this.qcr.qcv;
        try {
            windowManager.addView(this.qcn, layoutParams);
            bWW();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewBagMgr", "add failed %s", new Object[]{e});
        }
    }

    private void cKK() {
        x.i("MicroMsg.WebViewBagMgr", "unAttachBag");
        if (this.qcn != null) {
            try {
                ((WindowManager) ad.getContext().getSystemService("window")).removeView(this.qcn);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewBagMgr", "remove failed %s", new Object[]{e});
            }
            this.qcn = null;
        } else {
            x.e("MicroMsg.WebViewBagMgr", "unAttachBag mBag null");
        }
        if (this.qcp != null) {
            try {
                ((WindowManager) ad.getContext().getSystemService("window")).removeView(this.qcp.qba);
            } catch (Exception e2) {
                x.e("MicroMsg.BagCancelController", "whenBagUnAttach remove failed %s", new Object[]{e2});
            }
            this.qcp = null;
        }
    }

    private void bWW() {
        x.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", new Object[]{Long.valueOf(this.qcr.dRk)});
        if ("1".equals((String) g.Ei().DT().get(a.tab, "0"))) {
            this.qcn.j(60000, 100, this.qcr.dRk + 2000);
        } else {
            this.qcn.j(3600000, 30000, this.qcr.dRk + 3600000);
        }
    }

    private void AR(int i) {
        x.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", new Object[]{Integer.valueOf(i)});
        h.mEJ.h(11576, new Object[]{this.qcr.url, Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.qcr.dRk)});
    }
}
