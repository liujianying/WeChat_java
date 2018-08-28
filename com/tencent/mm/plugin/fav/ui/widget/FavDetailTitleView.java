package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m$e;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class FavDetailTitleView extends LinearLayout {
    private ImageView eCl;
    private TextView eCm;

    public FavDetailTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.eCl = (ImageView) findViewById(m$e.avatar_iv);
        this.eCm = (TextView) findViewById(m$e.title_tv);
    }

    public final void D(g gVar) {
        if (gVar != null && gVar.field_favProto != null) {
            CharSequence gU;
            if (14 != gVar.field_type || bi.oW(gVar.field_favProto.title)) {
                this.eCl.setVisibility(0);
                wr wrVar = gVar.field_favProto.rBG;
                if (wrVar == null || bi.oW(wrVar.rBh)) {
                    x.v("MicroMsg.FavDetailTitleView", "display name, from item info user[%s]", new Object[]{gVar.field_fromUser});
                    gU = b.gU(gVar.field_fromUser);
                    a.b.a(this.eCl, gVar.field_fromUser);
                } else {
                    gU = b.Bc(wrVar.rBh);
                    String gU2;
                    if (q.GF().equals(wrVar.bSS)) {
                        gU2 = b.gU(wrVar.toUser);
                        if (!bi.aG(gU2, "").equals(wrVar.toUser)) {
                            gU = gU + " - " + gU2;
                        }
                    } else {
                        gU2 = b.gU(wrVar.bSS);
                        if (!bi.aG(gU2, "").equals(wrVar.bSS)) {
                            gU = gU + " - " + gU2;
                        }
                    }
                    x.v("MicroMsg.FavDetailTitleView", "display name, source from[%s] to[%s]", new Object[]{wrVar.bSS, wrVar.toUser});
                    a.b.a(this.eCl, wrVar.rBh);
                }
            } else {
                gU = gVar.field_favProto.title;
                this.eCl.setVisibility(8);
            }
            this.eCm.setText(j.a(getContext(), gU, this.eCm.getTextSize()));
        }
    }
}
