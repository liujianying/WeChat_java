package com.tencent.mm.wallet_core.d;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.ui.MMActivity;

public abstract class g {
    public MMActivity fEY;
    public i uXK;

    public abstract boolean d(int i, int i2, String str, l lVar);

    public abstract boolean m(Object... objArr);

    public g(MMActivity mMActivity, i iVar) {
        this.fEY = mMActivity;
        this.uXK = iVar;
    }

    public CharSequence ui(int i) {
        return null;
    }

    public boolean r(Object... objArr) {
        return false;
    }

    public boolean s(Object... objArr) {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }
}
