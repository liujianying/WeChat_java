package com.tencent.mm.ui.contact;

import android.os.Bundle;
import android.support.v4.app.m;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.x;

public class OpenIMAddressUI extends MMActivity {
    public x tLY;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.R(16908290) == null) {
            this.tLY = new a();
            this.tLY.setArguments(getIntent().getExtras());
            supportFragmentManager.bk().a(R.h.inner_content, this.tLY).commit();
        }
    }

    protected final int getLayoutId() {
        return R.i.open_im_address_ui;
    }
}
