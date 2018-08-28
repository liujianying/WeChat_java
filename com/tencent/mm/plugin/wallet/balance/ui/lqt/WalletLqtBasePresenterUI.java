package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class WalletLqtBasePresenterUI extends WalletBaseUI {
    private c dtb = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtb.A(getIntent(), this);
        this.uYS = true;
    }

    public void onResume() {
        super.onResume();
        this.dtb.GM(2);
    }

    public void onPause() {
        super.onPause();
        this.dtb.GM(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.dtb.onDestroy();
    }

    public final <T extends b<? extends a>> T t(Class<? extends b<? extends a>> cls) {
        return this.dtb.a(this, cls);
    }

    public final <T extends a> T w(Class<? extends a> cls) {
        return this.dtb.b(this, cls);
    }

    public boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected int getLayoutId() {
        return 0;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
