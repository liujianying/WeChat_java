package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.bag.c.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.snackbar.b;

public final class l implements g {
    private final MMWebView dEn;
    private int fdx = 0;
    private final MMActivity gKS;
    private Bundle mExtras;
    private final f qbr;
    private d qcA;
    private String qcB;
    private String qcC;
    private final e qcD;
    private boolean qcE;
    private String qcF;
    private d qcy;
    private c qcz;

    public l(MMActivity mMActivity, MMWebView mMWebView) {
        this.gKS = mMActivity;
        this.dEn = mMWebView;
        if (this.gKS.getIntent().getExtras() != null) {
            this.fdx = this.gKS.getIntent().getIntExtra("minimize_secene", this.fdx);
        }
        this.qbr = new 1(this);
        this.qcD = new 2(this);
        this.qcE = this.gKS.getIntent().getBooleanExtra("from_bag", false);
        this.qcF = this.gKS.getIntent().getStringExtra("from_bag_id");
        this.qcC = this.gKS.getIntent().getStringExtra("from_bag_icon");
        this.mExtras = n.aL(this.gKS.getIntent());
        if (!bWY()) {
            x.i("MicroMsg.WebViewUIBagHelper", "not support swipeback");
        } else if (this.qcE) {
            this.qcz = new c(this.gKS, this.qbr);
        } else {
            x.i("MicroMsg.WebViewUIBagHelper", "not from bag, can swipe to bag");
            this.qcy = new d(mMActivity, this.qbr);
        }
    }

    public final void e(d dVar) {
        x.i("MicroMsg.WebViewUIBagHelper", "onWebViewPostBinded");
        this.qcA = dVar;
        if (this.qcE) {
            AS(5);
            if (bWY() && this.qcz != null) {
                c cVar = this.qcz;
                if (cVar.gKS.getSwipeBackLayout() != null) {
                    cVar.gKS.getSwipeBackLayout().setSwipeBackListener(new 1(cVar));
                }
            }
        } else if (bWY() && this.qcy != null) {
            this.qcy.start();
        }
    }

    public final void bWR() {
        x.i("MicroMsg.WebViewUIBagHelper", "onWebViewUIDestroy");
        AS(6);
        if (this.qcE) {
            AS(3);
        }
    }

    public final boolean AQ(int i) {
        x.i("MicroMsg.WebViewUIBagHelper", "onWebViewClose hasBag:%b", new Object[]{Boolean.valueOf(bWS())});
        if (!bWS()) {
            return false;
        }
        AR(i);
        h.a(this.gKS, (Point) AS(8).getParcelable("key_current_bag_pos"), this.qcD);
        return true;
    }

    public final void kg(boolean z) {
        x.i("MicroMsg.WebViewUIBagHelper", "onMenuMinimizeSelected cancelCurrentBag:%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            AS(4);
            if (this.qcz != null) {
                this.qcz.gKS.getSwipeBackLayout().setSwipeBackListener(null);
            }
            AR(18);
            b.h(this.gKS, this.gKS.getString(R.l.readerapp_cancel_minimize_done));
            if (bWY()) {
                this.qcy = new d(this.gKS, this.qbr);
                this.qcy.start();
                return;
            }
            return;
        }
        AR(16);
        h.a(this.gKS, (Point) AS(8).getParcelable("key_current_bag_pos"), this.qcD);
    }

    public final void X(Bundle bundle) {
        if (bundle != null) {
            this.qcC = bundle.getString("key_bag_icon");
        }
    }

    public final void Rx(String str) {
        x.i("MicroMsg.WebViewUIBagHelper", "updateUrl url:%s", new Object[]{str});
        this.qcB = str;
    }

    public final boolean bWS() {
        x.i("MicroMsg.WebViewUIBagHelper", "hasBagOfCurrentPage fromBag:%b", new Object[]{Boolean.valueOf(this.qcE)});
        if (!this.qcE) {
            return false;
        }
        Bundle AS = AS(7);
        if (AS == null) {
            return false;
        }
        x.i("MicroMsg.WebViewUIBagHelper", "hasBagOfCurrentPage  hasBag:%b", new Object[]{Boolean.valueOf(AS.getBoolean("key_has_bag"))});
        if (AS.getBoolean("key_has_bag") && this.qcE) {
            return true;
        }
        return false;
    }

    private Bundle AS(int i) {
        return u(i, new Bundle());
    }

    private Bundle u(int i, Bundle bundle) {
        Bundle bundle2 = null;
        if (this.qcA == null) {
            x.e("MicroMsg.WebViewUIBagHelper", "doBagLogic mInvoker null");
            return bundle2;
        }
        x.i("MicroMsg.WebViewUIBagHelper", "Tools doBagLogic : %d", new Object[]{Integer.valueOf(i)});
        bundle.putInt("key_action", i);
        switch (i) {
            case 1:
                bWX();
                bundle.putString("key_url", this.qcB);
                bundle.putString("key_bag_icon", this.qcC);
                bundle.putInt("key_scene", this.fdx);
                bundle.putBundle("key_extras", this.mExtras);
                break;
            case 5:
                bundle.putBoolean("key_in_webviewui_from_bag", true);
                break;
            case 6:
                bundle.putBoolean("key_in_webviewui_from_bag", false);
                break;
            case 7:
                bundle.putString("key_bag_id", this.qcF);
                break;
        }
        try {
            return this.qcA.g(103, bundle);
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUIBagHelper", "doBagLogic exp=%s", new Object[]{e.getLocalizedMessage()});
            return bundle2;
        }
    }

    private void bWX() {
        if (bi.oW(this.qcB) && this.dEn != null) {
            this.qcB = this.dEn.getUrl();
        }
    }

    private void AR(int i) {
        x.v("MicroMsg.WebViewUIBagHelper", "kvReport op:%d", new Object[]{Integer.valueOf(i)});
        bWX();
        Object[] objArr = new Object[]{this.qcB, Integer.valueOf(i)};
        if (this.qcA != null) {
            com.tencent.mm.plugin.webview.ui.tools.d.a(this.qcA, 11576, objArr);
        }
    }

    private boolean bWY() {
        return this.gKS.getSwipeBackLayout() != null;
    }
}
