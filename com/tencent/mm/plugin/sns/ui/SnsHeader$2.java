package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.storage.ab;

class SnsHeader$2 implements OnClickListener {
    final /* synthetic */ SnsHeader nWo;
    final /* synthetic */ Context val$context;

    SnsHeader$2(SnsHeader snsHeader, Context context) {
        this.nWo = snsHeader;
        this.val$context = context;
    }

    public final void onClick(View view) {
        ab Yg = af.byc().Yg(SnsHeader.e(this.nWo));
        Intent intent;
        if (Yg == null || !(a.gd(Yg.field_type) || SnsHeader.f(this.nWo))) {
            intent = ((Activity) this.val$context).getIntent();
            intent.putExtra("Contact_User", SnsHeader.e(this.nWo));
            com.tencent.mm.plugin.sns.c.a.ezn.d(intent, this.val$context);
            return;
        }
        intent = new Intent();
        intent.putExtra("Contact_User", SnsHeader.e(this.nWo));
        if (SnsHeader.e(this.nWo) != null && SnsHeader.e(this.nWo).length() > 0) {
            com.tencent.mm.plugin.sns.c.a.ezn.d(intent, this.val$context);
        }
    }
}
