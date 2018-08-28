package com.tencent.mm.plugin.webview.fts.c;

import android.view.View;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.b;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements a {
    final /* synthetic */ FtsWebVideoView pQQ;
    final /* synthetic */ b pQR;

    b$3(b bVar, FtsWebVideoView ftsWebVideoView) {
        this.pQR = bVar;
        this.pQQ = ftsWebVideoView;
    }

    public final void agL() {
        FtsWebVideoView ftsWebVideoView = this.pQQ;
        x.i("MicroMsg.FtsWebVideoView", "onUIResume");
        ftsWebVideoView.pQf.SM();
    }

    public final void agK() {
        FtsWebVideoView ftsWebVideoView = this.pQQ;
        x.i("MicroMsg.FtsWebVideoView", "onUIPause");
        ftsWebVideoView.pQf.SL();
    }

    public final void onDestroy() {
        FtsWebVideoView ftsWebVideoView = this.pQQ;
        x.i("MicroMsg.FtsWebVideoView", "onUIDestroy");
        x.i("MicroMsg.FtsWebVideoView", "clean");
        ftsWebVideoView.stop();
        ftsWebVideoView.pQf.ajZ();
        ftsWebVideoView.pQg.onDestroy();
        try {
            ftsWebVideoView.getContext().unregisterReceiver(ftsWebVideoView.pQz);
        } catch (Exception e) {
        }
    }

    public final void ajd() {
        b bVar = this.pQR.pQO;
        b.a Aj = bVar.Aj(bVar.goR);
        float[] fArr = bVar.goO;
        if (Aj != null && Aj.gpb != null && fArr != null) {
            View view = (View) Aj.gpb.get();
            if (view != null) {
                if (bVar.goR != bVar.goN) {
                    b.a Aj2 = bVar.Aj(bVar.goN);
                    if (!(Aj2 == null || Aj2.gpb == null)) {
                        View view2 = (View) Aj2.gpb.get();
                        if (view2 != null) {
                            bVar.a(bVar.goN, fArr, view2.getVisibility());
                        }
                    }
                }
                int i = bVar.goR;
                bVar.goN = -1;
                bVar.goR = -1;
                if (bVar.pQJ != null) {
                    bVar.pQJ.ajd();
                    bVar.pQJ = null;
                }
                bVar.a(i, fArr, view.getVisibility());
            }
        }
    }

    public final boolean agV() {
        if (!this.pQQ.ajE()) {
            return false;
        }
        this.pQQ.jT(false);
        return true;
    }

    public final void bIu() {
        FtsWebVideoView ftsWebVideoView = this.pQQ;
        if (!ftsWebVideoView.hEj && ftsWebVideoView.getSystemVolume() == 0) {
            ftsWebVideoView.setMute(true);
        }
    }

    public final void bTS() {
        FtsWebVideoView ftsWebVideoView = this.pQQ;
        if (ftsWebVideoView.hEj && ftsWebVideoView.getSystemVolume() > 0) {
            ftsWebVideoView.setMute(false);
        }
    }
}
