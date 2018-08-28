package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j$b;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.ag;

class SnsSightPlayerUI$7 implements OnClickListener {
    final /* synthetic */ String jcw;
    final /* synthetic */ SnsSightPlayerUI obb;
    final /* synthetic */ bsu obd;

    SnsSightPlayerUI$7(SnsSightPlayerUI snsSightPlayerUI, bsu bsu, String str) {
        this.obb = snsSightPlayerUI;
        this.obd = bsu;
        this.jcw = str;
    }

    public final void onClick(View view) {
        if (j$b.Sight.value != 0) {
            j.a(a.njN, this.obd.ksA, SnsSightPlayerUI.a(this.obb).bAH() == null ? "" : SnsSightPlayerUI.a(this.obb).bAH().ntU, 1, j$b.Sight.value, this.obd.hbL, null, this.obd.ksA, 0, 0, 0);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("key_snsad_statextstr", this.obd.nNV);
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", this.jcw);
        intent.putExtra("useJs", true);
        c cVar = new c(SnsSightPlayerUI.a(this.obb).bBn(), 18, 5, "", 2, SnsSightPlayerUI.a(this.obb).bAK());
        g.Ek();
        g.Eh().dpP.a(cVar, 0);
        new ag(Looper.getMainLooper()).post(new 1(this, intent));
    }
}
