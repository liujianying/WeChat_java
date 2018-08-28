package com.tencent.mm.plugin.shake.c.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.c.b.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements OnClickListener {
    final /* synthetic */ a mYd;

    a$2(a aVar) {
        this.mYd = aVar;
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.card_close_img) {
            this.mYd.dismiss();
            if (a.a(this.mYd) != null) {
                a.a(this.mYd).buR();
            }
            x.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
        } else if (view.getId() != R.h.card_accept_btn) {
        } else {
            if (a.b(this.mYd) == a.mYf) {
                a.a(this.mYd, a.mYg);
                a.b(this.mYd, 0);
                a.c(this.mYd);
                a.d(this.mYd);
            } else if (a.b(this.mYd) == a.mYg) {
            } else {
                if (a.b(this.mYd) == a.mYi) {
                    a.d(this.mYd);
                } else if (a.b(this.mYd) == a.mYh) {
                    com.tencent.mm.sdk.b.a.sFg.b(a.e(this.mYd));
                    a.f(this.mYd);
                }
            }
        }
    }
}
