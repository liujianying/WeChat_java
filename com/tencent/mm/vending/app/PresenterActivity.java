package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.vending.e.b;

public abstract class PresenterActivity extends Activity implements b {
    private c dtb = new c();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtb.A(getIntent(), this);
    }

    protected void onResume() {
        super.onResume();
        this.dtb.GM(2);
    }

    protected void onPause() {
        this.dtb.GM(3);
        super.onPause();
    }

    protected void onDestroy() {
        this.dtb.onDestroy();
        super.onDestroy();
    }
}
