package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.List;

public class WalletForgotPwdUI$a extends BaseAdapter {
    private Context context;
    List<Bankcard> dEw = new ArrayList();
    final /* synthetic */ WalletForgotPwdUI phK;

    public WalletForgotPwdUI$a(WalletForgotPwdUI walletForgotPwdUI, Context context) {
        this.phK = walletForgotPwdUI;
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        WalletFormView walletFormView;
        if (view == null) {
            walletFormView = (WalletFormView) View.inflate(this.context, g.wallet_bank_clickable_item, null);
        } else {
            walletFormView = (WalletFormView) view;
        }
        final Bankcard ze = ze(i);
        if (ze != null) {
            walletFormView.setText(((Bankcard) this.dEw.get(i)).field_desc);
        }
        walletFormView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletForgotPwdUI.a(WalletForgotPwdUI$a.this.phK, ze);
                WalletForgotPwdUI.a(WalletForgotPwdUI$a.this.phK, false);
                WalletForgotPwdUI.a(WalletForgotPwdUI$a.this.phK);
            }
        });
        return walletFormView;
    }

    public final int getCount() {
        return this.dEw.size();
    }

    private Bankcard ze(int i) {
        if (i < 0 || i > this.dEw.size() - 1) {
            return null;
        }
        return (Bankcard) this.dEw.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
