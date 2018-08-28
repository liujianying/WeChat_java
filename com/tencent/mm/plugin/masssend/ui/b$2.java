package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.i.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b laG;

    b$2(b bVar) {
        this.laG = bVar;
    }

    public final void onError() {
        this.laG.laB.reset();
        this.laG.erD.SO();
        this.laG.hnz.SO();
        af.Wq("keep_app_silent");
        this.laG.laA.aMo();
        x.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
        Toast.makeText(this.laG.laz, this.laG.laz.getString(R.l.chatting_rcd_err), 0).show();
    }
}
