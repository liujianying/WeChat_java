package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.g;

class WalletWXCreditChangeAmountUI$2 extends BaseAdapter {
    final /* synthetic */ WalletWXCreditChangeAmountUI qxj;

    WalletWXCreditChangeAmountUI$2(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.qxj = walletWXCreditChangeAmountUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return (l) WalletWXCreditChangeAmountUI.j(this.qxj).get(i);
    }

    public final int getCount() {
        return 2;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.qxj, g.wallet_list_dialog_item_singlechoice, null);
        if (i == 0) {
            checkedTextView.setText(a$i.app_yes);
        } else {
            checkedTextView.setText(a$i.app_no);
        }
        if (WalletWXCreditChangeAmountUI.l(this.qxj)) {
            if (WalletWXCreditChangeAmountUI.c(this.qxj).qwK == null || !"Y".equals(WalletWXCreditChangeAmountUI.c(this.qxj).kQE)) {
                if (i == 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            } else {
                if (i != 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            }
        } else if (WalletWXCreditChangeAmountUI.f(this.qxj).qwK == null || !"Y".equals(WalletWXCreditChangeAmountUI.f(this.qxj).kQE)) {
            if (i == 0) {
                z = false;
            }
            checkedTextView.setChecked(z);
        } else {
            if (i != 0) {
                z = false;
            }
            checkedTextView.setChecked(z);
        }
        return checkedTextView;
    }
}
