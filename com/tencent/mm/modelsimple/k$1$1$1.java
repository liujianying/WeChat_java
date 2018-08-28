package com.tencent.mm.modelsimple;

import android.content.Intent;
import com.tencent.mm.modelsimple.k.1.1;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class k$1$1$1 implements Runnable {
    final /* synthetic */ 1 efu;

    k$1$1$1(1 1) {
        this.efu = 1;
    }

    public final void run() {
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony[%b]", new Object[]{Boolean.valueOf(ad.chV())});
        Intent intent = new Intent();
        intent.putExtra("key_disaster_content", this.efu.efr);
        intent.putExtra("key_disaster_url", this.efu.efs);
        intent.setClass(ad.getContext(), DisasterUI.class).addFlags(268435456);
        ad.getContext().startActivity(intent);
    }
}
