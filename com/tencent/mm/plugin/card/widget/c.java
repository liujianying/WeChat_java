package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.protocal.c.pr;

public final class c extends a {
    protected TextView hJm;
    protected TextView hJn;

    public c(Context context) {
        super(context);
    }

    protected final void azZ() {
        this.hJn = (TextView) azY().findViewById(d.card_aux_title);
        this.hJm = (TextView) azY().findViewById(d.card_sub_title);
    }

    protected final void aAa() {
        if (this.htQ.awm().rnG != null && this.htQ.awm().rnG.size() > 0) {
            pr prVar = (pr) this.htQ.awm().rnG.get(0);
            if (this.hJd != null) {
                this.hJd.setText(prVar.title);
            }
            if (this.hJm != null) {
                if (TextUtils.isEmpty(prVar.huX)) {
                    this.hJm.setVisibility(8);
                } else {
                    this.hJm.setText(prVar.huX);
                }
            }
            if (this.hJn == null) {
                return;
            }
            if (TextUtils.isEmpty(prVar.huY)) {
                this.hJn.setVisibility(8);
            } else {
                this.hJn.setText(prVar.huY);
            }
        }
    }

    public final void v(boolean z, boolean z2) {
    }
}
