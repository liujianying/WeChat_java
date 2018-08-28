package com.tencent.mm.plugin.wallet_core.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;

class WalletSelectBankcardUI$a extends BaseAdapter {
    final /* synthetic */ WalletSelectBankcardUI pym;

    class a {
        TextView pyp;

        a() {
        }
    }

    private WalletSelectBankcardUI$a(WalletSelectBankcardUI walletSelectBankcardUI) {
        this.pym = walletSelectBankcardUI;
    }

    /* synthetic */ WalletSelectBankcardUI$a(WalletSelectBankcardUI walletSelectBankcardUI, byte b) {
        this(walletSelectBankcardUI);
    }

    public final int getCount() {
        return WalletSelectBankcardUI.a(this.pym) ? WalletSelectBankcardUI.b(this.pym) == null ? 1 : WalletSelectBankcardUI.b(this.pym).size() + 1 : WalletSelectBankcardUI.b(this.pym) == null ? 0 : WalletSelectBankcardUI.b(this.pym).size();
    }

    public final Object getItem(int i) {
        if (WalletSelectBankcardUI.b(this.pym) == null || WalletSelectBankcardUI.b(this.pym).size() <= i) {
            return null;
        }
        return WalletSelectBankcardUI.b(this.pym).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        Bankcard bankcard = (Bankcard) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.pym).inflate(g.wallet_select_bankcard_lv_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.pyp = (TextView) view.findViewById(f.bankcard_desc);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (bankcard != null) {
            aVar.pyp.setText(bankcard.field_desc);
        } else {
            aVar.pyp.setText(i.wallet_select_bankcard_new_bankcard);
        }
        return view;
    }
}
