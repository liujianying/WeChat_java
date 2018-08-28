package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.music.b.d;
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class a extends b {
    private c fIu;
    private TextView lAw;

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.lAw = (TextView) this.view.findViewById(com.tencent.mm.plugin.music.b.c.music_banner_text_view);
            this.lAw.setTextSize(0, (float) com.tencent.mm.bp.a.ad(ad.getContext(), com.tencent.mm.plugin.music.b.a.HintTextSize));
            this.view.setOnClickListener(new 1(this));
        }
        this.fIu = new 2(this);
        com.tencent.mm.sdk.b.a.sFg.b(this.fIu);
    }

    public final int getLayoutId() {
        return d.music_banner_view;
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(com.tencent.mm.plugin.music.b.c.music_banner_view).setVisibility(i);
        }
    }

    public final boolean anR() {
        return biC();
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.fIu);
    }

    private boolean biC() {
        int i = 8;
        if (com.tencent.mm.an.b.PY()) {
            avq Qa = com.tencent.mm.an.b.Qa();
            CharSequence charSequence = ad.getContext().getString(e.music_detail_playing) + ad.getContext().getString(e.music_detail_split) + Qa.rYl;
            if (this.lAw != null) {
                this.lAw.setText(charSequence);
            }
            if (!Qa.rYC) {
                i = 0;
            }
            setVisibility(i);
            if (Qa.rYC) {
                return false;
            }
            return true;
        }
        js jsVar = new js();
        jsVar.bTw.action = 10;
        com.tencent.mm.sdk.b.a.sFg.m(jsVar);
        if (jsVar.bTx.bGZ) {
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }

    public final int getOrder() {
        return 1;
    }
}
