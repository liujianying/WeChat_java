package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a;
import com.tencent.mm.pluginsdk.ui.d.o;

class SnsStrangerCommentDetailUI$a$2 extends o {
    final /* synthetic */ a obE;

    SnsStrangerCommentDetailUI$a$2(a aVar, Object obj) {
        this.obE = aVar;
        super(obj, null);
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", view.getTag().toString());
        com.tencent.mm.plugin.sns.c.a.ezn.d(intent, a.a(this.obE));
    }
}
