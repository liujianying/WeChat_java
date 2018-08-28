package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h$a;

class HoneyPayCheckPwdUI$16 implements h$a {
    final /* synthetic */ HoneyPayCheckPwdUI kld;
    final /* synthetic */ h kli;

    HoneyPayCheckPwdUI$16(HoneyPayCheckPwdUI honeyPayCheckPwdUI, h hVar) {
        this.kld = honeyPayCheckPwdUI;
        this.kli = hVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.HoneyPayCheckPwdUI", "modify success");
        Intent intent = new Intent();
        intent.putExtra("key_modify_create_line_succ", true);
        intent.putExtra("key_credit_line", this.kli.kjI);
        this.kld.setResult(-1, intent);
        this.kld.finish();
        com.tencent.mm.plugin.report.service.h.mEJ.e(875, 8, 1);
    }
}
