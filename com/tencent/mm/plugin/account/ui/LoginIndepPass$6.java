package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.sdk.platformtools.x;

class LoginIndepPass$6 implements Runnable {
    final /* synthetic */ LoginIndepPass eRJ;

    LoginIndepPass$6(LoginIndepPass loginIndepPass) {
        this.eRJ = loginIndepPass;
    }

    public final void run() {
        x.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
        Intent be = a.ezn.be(this.eRJ);
        be.addFlags(67108864);
        this.eRJ.startActivity(be);
        this.eRJ.finish();
    }
}
