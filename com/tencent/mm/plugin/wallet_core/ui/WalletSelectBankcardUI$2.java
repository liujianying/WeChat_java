package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class WalletSelectBankcardUI$2 implements OnItemClickListener {
    final /* synthetic */ WalletSelectBankcardUI pym;

    WalletSelectBankcardUI$2(WalletSelectBankcardUI walletSelectBankcardUI) {
        this.pym = walletSelectBankcardUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        final Bankcard bankcard = (Bankcard) adapterView.getItemAtPosition(i);
        if (bankcard != null) {
            h.a(this.pym, true, this.pym.getString(i.wallet_select_bankcard_bcp_confirm_num_msg, new Object[]{bankcard.field_desc, bankcard.field_mobile}), this.pym.getString(i.wallet_select_bankcard_bcp_confirm_num_title), this.pym.getString(i.wallet_select_bankcard_bcp_confirm_num_continue), this.pym.getString(i.wallet_select_bankcard_bcp_confirm_num_reset), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletSelectBankcardUI$2.this.pym.sy.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                    WalletSelectBankcardUI.a(WalletSelectBankcardUI$2.this.pym, bankcard);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletSelectBankcardUI$2.this.pym.sy.putBoolean("key_balance_change_phone_need_confirm_phone", true);
                    WalletSelectBankcardUI.a(WalletSelectBankcardUI$2.this.pym, bankcard);
                }
            });
            return;
        }
        this.pym.sy.putBoolean("key_balance_change_phone_need_confirm_phone", false);
        WalletSelectBankcardUI.a(this.pym, null);
    }
}
