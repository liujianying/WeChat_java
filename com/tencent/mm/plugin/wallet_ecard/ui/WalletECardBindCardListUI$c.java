package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.a;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.b;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.d;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ff;

class WalletECardBindCardListUI$c extends BaseAdapter {
    final /* synthetic */ WalletECardBindCardListUI pCn;
    public final int pCo;
    public final int pCp;

    private WalletECardBindCardListUI$c(WalletECardBindCardListUI walletECardBindCardListUI) {
        this.pCn = walletECardBindCardListUI;
        this.pCo = 0;
        this.pCp = 1;
    }

    /* synthetic */ WalletECardBindCardListUI$c(WalletECardBindCardListUI walletECardBindCardListUI, byte b) {
        this(walletECardBindCardListUI);
    }

    public final int getCount() {
        return WalletECardBindCardListUI.f(this.pCn).size() + 1;
    }

    public final Object getItem(int i) {
        if (i < WalletECardBindCardListUI.f(this.pCn).size()) {
            return WalletECardBindCardListUI.f(this.pCn).get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        if (i >= WalletECardBindCardListUI.f(this.pCn).size()) {
            return 1;
        }
        return 0;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final boolean isEnabled(int i) {
        ff ffVar = (ff) getItem(i);
        if (ffVar == null) {
            return super.isEnabled(i);
        }
        if (ffVar.rge) {
            return false;
        }
        return true;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == 1) {
            if (view == null) {
                view = LayoutInflater.from(this.pCn.mController.tml).inflate(g.ecard_bind_card_list_item_add, viewGroup, false);
                view.setTag(new a(this.pCn, view));
            }
            ((a) view.getTag()).gFa.setText(i.ecard_bind_card_add_other_debit_card);
        } else {
            if (view == null) {
                view = LayoutInflater.from(this.pCn.mController.tml).inflate(g.ecard_bind_card_list_item, viewGroup, false);
                view.setTag(new d(this.pCn, view));
            }
            ((b) view.getTag()).a(view, (ff) getItem(i));
        }
        return view;
    }
}
