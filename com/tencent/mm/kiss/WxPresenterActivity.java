package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.e.a;

public abstract class WxPresenterActivity extends MMActivity {
    protected c dtb = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtb.A(getIntent(), this);
    }

    public void onResume() {
        super.onResume();
        this.dtb.GM(2);
    }

    public void onPause() {
        this.dtb.GM(3);
        super.onPause();
    }

    public void onDestroy() {
        this.dtb.onDestroy();
        super.onDestroy();
    }

    public void keep(a aVar) {
        this.dtb.keep(aVar);
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T t(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.dtb.a(this, cls);
    }

    public final com.tencent.mm.vending.app.a EW() {
        return this.dtb.EW();
    }
}
