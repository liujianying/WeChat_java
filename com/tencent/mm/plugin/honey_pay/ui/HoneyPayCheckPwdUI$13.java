package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h.a;

class HoneyPayCheckPwdUI$13 implements a {
    final /* synthetic */ HoneyPayCheckPwdUI kld;
    final /* synthetic */ c klh;

    HoneyPayCheckPwdUI$13(HoneyPayCheckPwdUI honeyPayCheckPwdUI, c cVar) {
        this.kld = honeyPayCheckPwdUI;
        this.klh = cVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
        Intent intent = new Intent(this.kld.mController.tml, HoneyPayMainUI.class);
        intent.putExtra("key_create_succ", true);
        if (this.klh.kjC.ruX != null) {
            intent.putExtra("key_card_no", this.klh.kjC.ruX.rIw);
            intent.putExtra("key_card_type", this.klh.kjC.ruX.hwg);
        }
        Toast.makeText(this.kld.mController.tml, i.honey_pay_create_card_success_word, 1).show();
        this.kld.startActivity(intent);
        h.mEJ.e(875, 2, 1);
    }
}
