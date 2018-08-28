package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.sdk.platformtools.x;

class LoginUI$18 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ LoginUI eSk;

    LoginUI$18(LoginUI loginUI, l lVar) {
        this.eSk = loginUI;
        this.bFp = lVar;
    }

    public final void run() {
        x.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
        Intent be = a.ezn.be(this.eSk);
        be.addFlags(67108864);
        be.putExtra("kstyle_show_bind_mobile_afterauth", ((q) this.bFp).Ri());
        be.putExtra("kstyle_bind_wording", ((q) this.bFp).Rj());
        be.putExtra("kstyle_bind_recommend_show", ((q) this.bFp).Rl());
        this.eSk.startActivity(be);
        this.eSk.finish();
    }
}
