package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;

public abstract class MMPresenterActivity extends MMActivity {
    private c dtb = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtb.A(getIntent(), this);
    }

    protected void onResume() {
        super.onResume();
        this.dtb.GM(2);
    }

    protected void onPause() {
        super.onPause();
        this.dtb.GM(3);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.dtb.onDestroy();
    }
}
