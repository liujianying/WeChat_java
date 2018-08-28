package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.aa.a.h;

class AAEntranceUI$1 implements OnClickListener {
    final /* synthetic */ AAEntranceUI eBL;

    AAEntranceUI$1(AAEntranceUI aAEntranceUI) {
        this.eBL = aAEntranceUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", false);
        intent.putExtra("mutil_select_is_ret", false);
        intent.putExtra("Select_block_List", q.GF());
        intent.putExtra("recent_remittance_contact_list", h.VZ());
        d.b(this.eBL.mController.tml, "remittance", ".ui.SelectRemittanceContactUI", intent, 1);
    }
}
