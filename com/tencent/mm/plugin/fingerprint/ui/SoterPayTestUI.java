package com.tencent.mm.plugin.fingerprint.ui;

import android.os.Bundle;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;

public class SoterPayTestUI extends MMActivity implements e {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        findViewById(f.soter_cgi_test_get_challenge).setOnClickListener(new 1(this));
        findViewById(f.regen_upload_ask).setOnClickListener(new 2(this));
        findViewById(f.regen_upload_pay_auth_key).setOnClickListener(new 3(this));
    }

    protected final int getLayoutId() {
        return g.fingerprint_soter_cgi_test;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SoterPayTestUI", "hy: on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        s.makeText(this, String.format("on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}), 1).show();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(lVar.getType(), this);
    }
}
