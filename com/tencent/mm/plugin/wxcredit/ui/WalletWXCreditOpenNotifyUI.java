package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditOpenNotifyUI extends WalletBaseUI {
    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.wallet_wxcredit_open_notify_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Ei().DT().set(196658, Boolean.valueOf(false));
        initView();
    }

    protected final void initView() {
        int i = 0;
        setMMTitle(i.wallet_wxcredit_open_notify_title);
        showHomeBtn(false);
        enableBackMenu(false);
        addTextOptionMenu(0, getString(i.app_finish), new 1(this));
        ((TextView) findViewById(f.wallet_wxcredit_amount)).setText(e.B(this.sy.getDouble("key_total_amount")));
        Button button = (Button) findViewById(f.next_btn);
        button.setOnClickListener(new 2(this));
        if (!this.sy.getBoolean("key_can_upgrade_amount", true)) {
            i = 8;
        }
        button.setVisibility(i);
    }
}
