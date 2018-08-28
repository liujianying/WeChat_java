package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.as;

class b$19 implements OnClickListener {
    final /* synthetic */ b olf;

    b$19(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof as) {
            n Nk = af.byo().Nk(((as) view.getTag()).bSZ);
            if (Nk != null) {
                Intent intent = new Intent();
                intent.putExtra("sns_text_show", Nk.bAJ().spZ);
                intent.putExtra("sns_local_id", Nk.bBe());
                intent.setClass(this.olf.activity, SnsSingleTextViewUI.class);
                this.olf.activity.startActivity(intent);
            }
        }
    }
}
