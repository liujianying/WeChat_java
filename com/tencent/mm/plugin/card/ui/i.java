package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;

public final class i implements a {
    MMActivity gKS;
    boolean hAu = false;
    View hFD;
    TextView hFE;
    ImageView hFF;
    View hFG;
    TextView hFH;
    ImageView hFI;
    View hyK;

    public i(MMActivity mMActivity, View view) {
        this.gKS = mMActivity;
        this.hyK = view;
    }

    public final void a(g gVar) {
        ayP();
    }

    public final void auM() {
    }

    final void ayP() {
        if (am.axm().huN <= 0 || !this.hAu) {
            this.hFD.setVisibility(8);
            if (this.hFG != null) {
                this.hFG.setVisibility(8);
                return;
            }
            return;
        }
        String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sPW, "");
        String str2 = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sPX, "");
        int dimensionPixelOffset = this.gKS.getResources().getDimensionPixelOffset(b.card_index_newmsg_logo_height);
        if (TextUtils.isEmpty(str2)) {
            this.hFF.setImageResource(c.card_msg_inform);
        } else {
            m.a(this.hFF, str2, dimensionPixelOffset, c.card_msg_inform, true);
        }
        if (TextUtils.isEmpty(str)) {
            this.hFE.setText(this.gKS.getString(com.tencent.mm.plugin.card.a.g.card_index_new_msg, new Object[]{Integer.valueOf(r2)}));
        } else {
            this.hFE.setText(str);
        }
        this.hFD.setVisibility(0);
        if (this.hFG != null) {
            if (TextUtils.isEmpty(str2)) {
                this.hFI.setImageResource(c.card_msg_inform);
            } else {
                m.a(this.hFI, str2, dimensionPixelOffset, c.card_msg_inform, true);
            }
            if (TextUtils.isEmpty(str)) {
                this.hFH.setText(this.gKS.getString(com.tencent.mm.plugin.card.a.g.card_index_new_msg, new Object[]{Integer.valueOf(r2)}));
            } else {
                this.hFH.setText(str);
            }
            this.hFG.setVisibility(0);
        }
    }
}
