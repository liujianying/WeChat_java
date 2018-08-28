package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class e$18 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$18(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
        e.d(this.oSe);
    }
}
