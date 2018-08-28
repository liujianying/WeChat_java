package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnClickListener {
    final /* synthetic */ a uha;

    a$1(a aVar) {
        this.uha = aVar;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.AddressAdapter", "on delView clicked");
        this.uha.hkQ.aYm();
        if (this.uha.lCE != null) {
            this.uha.lCE.bv(((ViewStub) a.a(this.uha).get(view)).getTag());
        }
    }
}
