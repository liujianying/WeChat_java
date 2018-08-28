package com.tencent.mm.ui.contact;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.m;
import com.tencent.mm.ui.x;

public class AddressUI extends FragmentActivity {
    public x tLY;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.R(16908290) == null) {
            this.tLY = new a();
            this.tLY.setArguments(getIntent().getExtras());
            supportFragmentManager.bk().a(16908290, this.tLY).commit();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }
}
