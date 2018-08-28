package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;

class n$1 implements OnClickListener {
    final /* synthetic */ ViewGroup hHO;
    final /* synthetic */ n hHP;

    n$1(n nVar, ViewGroup viewGroup) {
        this.hHP = nVar;
        this.hHO = viewGroup;
    }

    public final void onClick(View view) {
        Button button = (Button) this.hHO.findViewById(d.code_button);
        View findViewById = this.hHO.findViewById(d.code_qr_disable_layout);
        if (button.getVisibility() != 0 || findViewById.getVisibility() != 0) {
            if (findViewById.getVisibility() == 0) {
                if (l.isNetworkAvailable(this.hHP.gKS.mController.tml)) {
                    findViewById.setVisibility(8);
                    this.hHO.findViewById(d.code_qr_area).setVisibility(0);
                } else {
                    com.tencent.mm.plugin.card.d.d.a(this.hHP.gKS, this.hHP.gKS.getString(g.card_get_code_network_connet_failure), false);
                    return;
                }
            }
            this.hHP.hHC.d(c.hIz);
        }
    }
}
