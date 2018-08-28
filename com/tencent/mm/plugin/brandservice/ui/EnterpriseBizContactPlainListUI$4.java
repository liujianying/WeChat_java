package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.protocal.c.ix;

class EnterpriseBizContactPlainListUI$4 implements a {
    final /* synthetic */ EnterpriseBizContactPlainListUI hpF;
    final /* synthetic */ ix hpG;

    EnterpriseBizContactPlainListUI$4(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, ix ixVar) {
        this.hpF = enterpriseBizContactPlainListUI;
        this.hpG = ixVar;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            Intent intent = this.hpF.getIntent();
            intent.putExtra("enterprise_biz_name", this.hpG.userName);
            this.hpF.setResult(-1, intent);
            this.hpF.finish();
        }
    }
}
