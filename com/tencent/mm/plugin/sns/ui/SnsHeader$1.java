package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class SnsHeader$1 implements OnClickListener {
    final /* synthetic */ SnsHeader nWo;
    final /* synthetic */ Context val$context;

    SnsHeader$1(SnsHeader snsHeader, Context context) {
        this.nWo = snsHeader;
        this.val$context = context;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.SnsHeader", "change backGround");
        if (SnsHeader.a(this.nWo) == null || !SnsHeader.a(this.nWo).isShowing()) {
            String d;
            if (SnsHeader.b(this.nWo) != null) {
                SnsHeader.b(this.nWo).bDp();
            }
            if (SnsHeader.c(this.nWo) == 1) {
                d = SnsHeader.d(this.nWo);
            } else {
                d = SnsHeader.e(this.nWo);
            }
            l Np = af.bys().Np(d);
            long j = Np.field_snsBgId;
            if (SnsHeader.f(this.nWo) || j != 0) {
                String[] strArr;
                SnsHeader.a(this.nWo, Np.bAT());
                if (SnsHeader.c(this.nWo) == 1 || SnsHeader.d(this.nWo).trim().equals(SnsHeader.e(this.nWo).trim())) {
                    strArr = new String[]{this.val$context.getString(j.sns_ui_setback)};
                    SnsHeader.a(this.nWo, false);
                } else {
                    strArr = SnsHeader.g(this.nWo) ? new String[0] : new String[]{this.val$context.getString(j.sns_love_back)};
                }
                String string = SnsHeader.g(this.nWo) ? this.val$context.getString(j.sns_set_has_like_bg) : "";
                if (SnsHeader.g(this.nWo)) {
                    this.val$context.getString(j.app_ok);
                } else {
                    this.val$context.getString(j.app_cancel);
                }
                SnsHeader.a(this.nWo, h.a(this.nWo.getContext(), string, strArr, new 1(this, j)));
            }
        }
    }
}
