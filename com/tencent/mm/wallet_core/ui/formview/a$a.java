package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.mm.wallet_core.ui.formview.a.b;

public class a$a extends b {
    private int uZl;
    private WalletFormView uZm;

    public final /* bridge */ /* synthetic */ boolean bqk() {
        return super.bqk();
    }

    public final /* bridge */ /* synthetic */ boolean c(WalletFormView walletFormView, String str) {
        return super.c(walletFormView, str);
    }

    public final /* bridge */ /* synthetic */ boolean d(WalletFormView walletFormView, String str) {
        return super.d(walletFormView, str);
    }

    public final /* bridge */ /* synthetic */ String e(WalletFormView walletFormView, String str) {
        return super.e(walletFormView, str);
    }

    public a$a(WalletFormView walletFormView) {
        this(walletFormView, (byte) 0);
    }

    public a$a(WalletFormView walletFormView, byte b) {
        super((byte) 0);
        this.uZl = 1;
        this.uZm = walletFormView;
        this.uZl = 1;
        cDR();
    }

    public final void Hf(int i) {
        this.uZl = i;
        cDR();
    }

    private void cDR() {
        if (this.uZl == 1) {
            if (this.uZm != null) {
                this.uZm.setKeyListener(new 1(this));
            }
        } else if (this.uZm != null) {
            this.uZm.setInputType(1);
        }
    }

    public final boolean a(WalletFormView walletFormView) {
        return walletFormView.uZy == null ? false : walletFormView.uZy.isAreaIDCardNum(this.uZl);
    }
}
