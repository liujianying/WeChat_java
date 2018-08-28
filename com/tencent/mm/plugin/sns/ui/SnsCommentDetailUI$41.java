package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$41 implements OnClickListener {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$41(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void onClick(View view) {
        String str = (String) view.getTag();
        x.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:" + str);
        Intent intent = new Intent();
        n e = SnsCommentDetailUI.e(this.nUO);
        if (e.xb(32)) {
            c cVar = new c(e.bBn(), 1, 2, "", e.bBr(), e.bAK());
            g.Ek();
            g.Eh().dpP.a(cVar, 0);
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_Scene", 37);
            a.ezn.d(intent, this.nUO);
            return;
        }
        intent.putExtra("Contact_User", str);
        a.ezn.d(intent, this.nUO);
    }
}
