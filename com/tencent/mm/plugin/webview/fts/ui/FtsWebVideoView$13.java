package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.plugin.webview.fts.c.d.1;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class FtsWebVideoView$13 implements b {
    final /* synthetic */ FtsWebVideoView pQA;

    FtsWebVideoView$13(FtsWebVideoView ftsWebVideoView) {
        this.pQA = ftsWebVideoView;
    }

    public final void d(String str, String str2, String str3, int i, int i2) {
        x.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(i2)});
        h.mEJ.h(14911, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), FtsWebVideoView.n(this.pQA), ao.fH(this.pQA.getContext())});
        if (FtsWebVideoView.h(this.pQA) != null) {
            d h = FtsWebVideoView.h(this.pQA);
            x.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            h.clean();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", String.valueOf(i2));
                h.ao(h.a(7, jSONObject));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
            }
        }
        this.pQA.pause();
        FtsWebVideoView.a(this.pQA, this.pQA.getContext().getString(R.l.video_error_warnning, new Object[]{i + ":" + i2}), this.pQA.getContext().getString(R.l.video_retry_play));
    }

    public final void bu(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onPrepared");
        a o = FtsWebVideoView.o(this.pQA);
        o.gbA = -1;
        o.gbB = 0;
        o.gbz = 0.0f;
        FtsWebVideoView.c(this.pQA).jR(FtsWebVideoView.f(this.pQA));
    }

    public final void bv(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
        if (FtsWebVideoView.h(this.pQA) != null) {
            d h = FtsWebVideoView.h(this.pQA);
            x.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[]{h.toString()});
            h.akb();
            try {
                h.ao(h.a(3, null));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
            }
        }
        if (FtsWebVideoView.p(this.pQA)) {
            this.pQA.C(0, true);
            return;
        }
        this.pQA.C(0, false);
        this.pQA.pause();
        FtsWebVideoView.q(this.pQA);
        FtsWebVideoView.r(this.pQA).setImageResource(R.g.fts_video_replay_btn);
        FtsWebVideoView.c(this.pQA).setVisibility(8);
    }

    public final void d(String str, String str2, int i, int i2) {
        x.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (FtsWebVideoView.s(this.pQA) == FtsWebVideoView.b.pQB) {
            FtsWebVideoView.a(this.pQA, i < i2 ? FtsWebVideoView.b.pQD : FtsWebVideoView.b.pQC);
            x.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[]{FtsWebVideoView.s(this.pQA)});
        }
    }

    public final void bw(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onVideoPause");
        if (FtsWebVideoView.h(this.pQA) != null && FtsWebVideoView.h(this.pQA) != null) {
            d h = FtsWebVideoView.h(this.pQA);
            x.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[]{h.toString()});
            h.akb();
            try {
                h.ao(h.a(2, null));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
            }
        }
    }

    public final void bx(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[]{Boolean.valueOf(FtsWebVideoView.t(this.pQA))});
        if (FtsWebVideoView.h(this.pQA) != null) {
            d h = FtsWebVideoView.h(this.pQA);
            x.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[]{h.toString()});
            h.gbs = 0;
            if (h.gbr == null) {
                h.gbr = new al(new 1(h), true);
            }
            h.gbr.J(250, 250);
            try {
                h.ao(h.a(1, null));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
            }
        }
        if (FtsWebVideoView.u(this.pQA) > 0 && FtsWebVideoView.u(this.pQA) != Long.MAX_VALUE) {
            long currentTimeMillis = System.currentTimeMillis() - FtsWebVideoView.u(this.pQA);
            h.mEJ.h(14909, new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis()), Long.valueOf(currentTimeMillis), ao.fH(this.pQA.getContext()), FtsWebVideoView.n(this.pQA)});
        }
    }

    public final void by(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
        FtsWebVideoView.c(this.pQA).bTz();
        FtsWebVideoView.a(this.pQA, true);
    }

    public final void bz(String str, String str2) {
        x.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
        FtsWebVideoView.a(this.pQA, false);
        FtsWebVideoView.c(this.pQA).bTA();
        FtsWebVideoView.c(this.pQA).bTw();
    }
}
