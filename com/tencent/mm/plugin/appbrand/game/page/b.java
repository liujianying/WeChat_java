package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.sdk.platformtools.x;

@SuppressLint({"ViewConstructor"})
public final class b extends l {
    private d fCC;
    private String mURL;

    public b(Context context, n nVar) {
        super(context, nVar);
        x.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
    }

    protected final View agB() {
        return new FrameLayout(getContext());
    }

    protected final View agC() {
        d dVar = new d(getContext(), getContainer().getRuntime());
        this.fCC = dVar;
        return dVar.fCH;
    }

    public final void loadUrl(String str) {
        this.mURL = str;
        this.fCC.sX(str);
    }

    public final boolean sV(String str) {
        return true;
    }

    public final void b(String str, String str2, int[] iArr) {
        this.fCC.j(str, str2, 0);
    }

    public final d getCurrentPageView() {
        return this.fCC;
    }

    public final String getCurrentUrl() {
        return this.mURL;
    }

    public final void cleanup() {
        super.cleanup();
        this.fCC.cleanup();
    }

    protected final void agD() {
        super.agD();
        this.fCC.onDestroy();
    }

    public final void agE() {
        super.agE();
        this.fCC.agL();
    }

    public final void agF() {
        super.agF();
        this.fCC.agK();
    }

    protected final void agG() {
    }

    protected final void agH() {
    }

    public final void agI() {
        if (this.fCC != null) {
            d dVar = this.fCC;
            if (dVar.fCI != null) {
                dVar.fCI.getMBRenderer();
            }
        }
    }
}
