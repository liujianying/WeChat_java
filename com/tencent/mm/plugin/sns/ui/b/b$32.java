package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$32 implements OnClickListener {
    final /* synthetic */ b olf;

    b$32(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof String) {
            n Nl = af.byo().Nl((String) view.getTag());
            if (Nl != null && Nl.xb(32)) {
                x.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                a bAH = Nl.bAH();
                if (bAH == null) {
                    x.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                } else if (bi.oW(bAH.nyg)) {
                    x.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
                } else {
                    x.i("MicroMsg.TimelineClickListener", "open webview url : " + bAH.nyg);
                    Intent intent = new Intent();
                    intent.putExtra("jsapiargs", new Bundle());
                    intent.putExtra("useJs", true);
                    intent.putExtra("rawUrl", bAH.nyg);
                    com.tencent.mm.plugin.sns.c.a.ezn.j(intent, this.olf.activity);
                }
            }
        }
    }
}
