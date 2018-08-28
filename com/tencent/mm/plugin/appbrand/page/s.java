package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.q.l;

public final class s extends l {
    private p fFv;
    private String mUrl;

    public s(Context context, n nVar) {
        super(context, nVar);
    }

    protected final View agC() {
        if (this.fFv == null) {
            this.fFv = getContainer().getPreloadedPageView();
        }
        return this.fFv.getContentView();
    }

    public final void loadUrl(String str) {
        if (this.mUrl == null) {
            this.mUrl = str;
            this.fFv.sX(str);
            agH();
        }
    }

    public final boolean sV(String str) {
        return l.vP(this.mUrl).equals(l.vP(str));
    }

    protected final void agD() {
        super.agD();
        this.fFv.onDestroy();
    }

    public final void cleanup() {
        super.cleanup();
        this.fFv.cleanup();
    }

    public final void agE() {
        super.agE();
        this.fFv.agL();
    }

    public final void agF() {
        super.agF();
        this.fFv.agK();
    }

    public final void b(String str, String str2, int[] iArr) {
        if (d(iArr, this.fFv.hashCode())) {
            this.fFv.j(str, str2, 0);
        }
    }

    public final p getCurrentPageView() {
        return this.fFv;
    }

    public final String getCurrentUrl() {
        return this.mUrl;
    }
}
