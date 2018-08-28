package com.tencent.mm.view.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.n.a.e;
import com.tencent.mm.plugin.n.a.f;
import com.tencent.mm.plugin.n.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.f.a;

public final class d extends b {
    public int uTO = 1;
    private ImageView uTP;
    private ImageView uTQ;

    public d(Context context, a aVar) {
        super(context, aVar);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (i != (this.jZk * this.uTJ) - 5) {
            return super.getView(i, view, viewGroup);
        }
        View inflate = y.gq(this.mContext).inflate(f.smiley_grid_item_cross_fade, null);
        inflate.setLayoutParams(new LayoutParams(-1, -1));
        this.uTP = (ImageView) inflate.findViewById(e.art_emoji_icon_origin);
        this.uTQ = (ImageView) inflate.findViewById(e.art_emoji_icon_delete);
        int GR = GR(i);
        this.uTP.setImageDrawable(com.tencent.mm.br.e.cjH().mg(GR));
        CharSequence text = com.tencent.mm.br.e.cjH().getText(GR);
        if (bi.oW(text)) {
            text = inflate.getResources().getString(h.emoji_store_title);
        }
        this.uTP.setContentDescription(text);
        this.uTQ.setImageResource(com.tencent.mm.plugin.n.a.d.del_btn);
        this.uTQ.setContentDescription(this.mContext.getString(h.delete_btn));
        aI((float) this.uTO);
        return inflate;
    }

    public final void aI(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.uTP != null) {
                if (f <= 0.01f) {
                    this.uTP.setVisibility(4);
                } else {
                    this.uTP.setVisibility(0);
                    this.uTP.setImageAlpha((int) (255.0f * f));
                }
            }
            if (this.uTQ == null) {
                return;
            }
            if (f >= 0.99f) {
                this.uTQ.setVisibility(4);
                return;
            }
            this.uTQ.setVisibility(0);
            this.uTQ.setImageAlpha((int) ((1.0f - f) * 255.0f));
        }
    }
}
