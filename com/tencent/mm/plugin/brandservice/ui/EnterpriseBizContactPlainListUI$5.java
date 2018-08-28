package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class EnterpriseBizContactPlainListUI$5 implements a {
    final /* synthetic */ EnterpriseBizContactPlainListUI hpF;
    final /* synthetic */ String hpH;

    EnterpriseBizContactPlainListUI$5(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, String str) {
        this.hpF = enterpriseBizContactPlainListUI;
        this.hpH = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z && EnterpriseBizContactPlainListUI.b(this.hpF) == 3) {
            Intent intent = this.hpF.getIntent();
            intent.putExtra("enterprise_biz_name", this.hpH);
            this.hpF.setResult(-1, intent);
            this.hpF.finish();
        }
    }
}
