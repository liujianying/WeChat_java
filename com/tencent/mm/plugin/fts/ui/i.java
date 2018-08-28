package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.c.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.HashSet;

public final class i extends d implements b {
    private boolean eMT;
    private int jtk;
    private ag jvE = new ag(Looper.getMainLooper());
    private e jwC;
    private a jwD;
    private boolean jwE;
    private ag jwF = new 1(this, Looper.getMainLooper());
    private boolean jwG;
    private boolean jww;

    public i(e eVar, int i, int i2) {
        super(eVar);
        this.jtk = i;
        Context context = getContext();
        int i3 = -1;
        switch (i) {
            case IX5WebViewClient.ERROR_TOO_MANY_REQUESTS /*-15*/:
                i3 = 4240;
                break;
            case IX5WebViewClient.ERROR_FILE /*-13*/:
                i3 = 4224;
                break;
            case IX5WebViewClient.ERROR_IO /*-7*/:
                i3 = 4208;
                break;
            case IX5WebViewClient.ERROR_CONNECT /*-6*/:
                i3 = 4160;
                break;
            case IX5WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                i3 = 4144;
                break;
            case IX5WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                i3 = 4112;
                break;
            case IX5WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                i3 = 4128;
                break;
            case IX5WebViewClient.ERROR_HOST_LOOKUP /*-2*/:
                i3 = 4176;
                break;
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                i3 = 4192;
                break;
        }
        x.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i3)});
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i3));
        this.jwC = (e) ((n) g.n(n.class)).createFTSUIUnitList(hashSet, context, this, i2).get(0);
        this.jwD = new a();
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a qh(int i) {
        com.tencent.mm.plugin.fts.a.d.a.a qh = this.jwC.qh(i);
        if (qh != null) {
            qh.jtl = i;
            qh.pageType = 2;
        }
        return qh;
    }

    protected final void aQx() {
        this.eMT = true;
        this.jww = false;
        this.jwD.reset();
        this.jwC.a(this.bWm, this.jvE, new HashSet());
    }

    protected final void clearCache() {
        super.clearCache();
        this.jwC.acV();
        this.jwC.aQe();
        this.jwF.removeMessages(1);
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        this.jwC.a(view, aVar, z);
        if (aVar.jts) {
            x.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[]{Integer.valueOf(aVar.jtk), Integer.valueOf(aVar.jsZ), Integer.valueOf(aVar.jtl), Integer.valueOf(aVar.jtm), aVar.jtn, Long.valueOf(aVar.jto)});
            if (!this.jww) {
                k.c(this.bWm, true, aQg(), aVar.jtk);
                this.jww = true;
            }
            k.a(aVar, this.jwD);
        } else if (aVar instanceof h) {
            this.jwG = true;
            k.a(aVar, this.jwD);
        }
        return false;
    }

    public final void finish() {
        if (!this.jww) {
            this.jww = true;
            if (!this.jwG) {
                k.c(this.bWm, false, aQg(), this.jtk);
            }
        }
        this.jwD.reset();
        super.finish();
    }

    public final void a(e eVar, String str) {
        if (str.equals(this.bWm)) {
            this.eMT = false;
        }
        setCount(eVar.qg(0));
        notifyDataSetChanged();
        J(getCount(), true);
        this.jwD.jyY = System.currentTimeMillis();
        a aVar = this.jwD;
        for (e.a aVar2 : ((a) eVar).jvp) {
            aVar.jyZ = aVar2.jte.size() + aVar.jyZ;
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.jwE = true;
            ((n) g.n(n.class)).getFTSImageLoader().aPM();
            com.tencent.mm.plugin.sns.b.n.nkx.pause();
            x.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
            return;
        }
        this.jwE = false;
        if (!((n) g.n(n.class)).getFTSImageLoader().aPN()) {
            this.jwF.removeMessages(1);
            this.jwF.sendEmptyMessageDelayed(1, 200);
        }
    }

    protected final int aQg() {
        return this.jwC.aQg();
    }
}
