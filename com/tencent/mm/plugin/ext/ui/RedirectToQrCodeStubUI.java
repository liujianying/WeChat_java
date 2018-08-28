package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

public class RedirectToQrCodeStubUI extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.RedirectToQrCodeStubUI", "hy: start to handle qrcode string");
        String stringExtra = getIntent().getStringExtra("K_STR");
        int intExtra = getIntent().getIntExtra("K_TYPE", -1);
        int intExtra2 = getIntent().getIntExtra("K_VERSION", -1);
        cb cbVar = new cb();
        cbVar.bJq.activity = this;
        cbVar.bJq.bHL = stringExtra;
        cbVar.bJq.bJr = intExtra;
        cbVar.bJq.bJs = intExtra2;
        cbVar.bJq.scene = 47;
        a.sFg.m(cbVar);
        finish();
    }
}
