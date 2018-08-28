package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(19)
public class WalletWXCreditOpenResultUI extends WalletBaseUI {
    private CheckBox qxw;

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.wallet_wxcredit_open_result_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Ei().DT().set(196658, Boolean.valueOf(true));
        o.bOW().prH = bi.VE();
        initView();
    }

    protected final void initView() {
        setMMTitle(i.wallet_wxcredit_open_result_title);
        TextView textView = (TextView) findViewById(f.wallet_wxcredit_open_tips);
        this.qxw = (CheckBox) findViewById(f.attention_cb);
        if (((Bankcard) this.sy.getParcelable("key_bankcard")) != null) {
            this.qxw.setText(getString(i.wallet_wxcredit_open_result_wait_attention, new Object[]{r1.field_bankName}));
            textView.setText(i.wallet_wxcredit_open_result_wait_tips);
        }
        ((Button) findViewById(f.next_btn)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletWXCreditOpenResultUI.this.YO();
            }
        });
    }

    private void YO() {
        cDL().m(new Object[]{Boolean.valueOf(this.qxw.isChecked())});
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        YO();
        return true;
    }
}
