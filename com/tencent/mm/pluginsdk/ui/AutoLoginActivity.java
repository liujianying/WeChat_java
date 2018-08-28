package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public abstract class AutoLoginActivity extends MMActivity {
    public abstract boolean A(Intent intent);

    public abstract void a(a aVar, Intent intent);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
            finish();
            return;
        }
        d.cfH();
        x.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + intent.getAction());
        int a = s.a(intent, "wizard_activity_result_code", -2);
        x.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = " + a);
        if (a != -2) {
            BS(a);
        } else if (!A(intent)) {
            x.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
            finish();
        } else if (bjv()) {
            finish();
            x.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
        } else {
            a(a.qEF, intent);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            super.onNewIntent(intent);
            setIntent(intent);
            int a = s.a(intent, "wizard_activity_result_code", 0);
            x.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = " + a);
            BS(a);
        }
    }

    private void BS(int i) {
        switch (i) {
            case -1:
                a(a.qEF, getIntent());
                return;
            case 0:
                bjv();
                return;
            case 1:
                a(a.qEH, getIntent());
                return;
            default:
                x.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = " + i);
                a(a.qEG, getIntent());
                return;
        }
    }

    public boolean bjv() {
        g.Eg();
        if (com.tencent.mm.kernel.a.Dw() && !com.tencent.mm.kernel.a.Dr()) {
            return false;
        }
        x.w("MicroMsg.AutoLoginActivity", "not login");
        Intent intent = new Intent(this, getClass());
        intent.putExtras(getIntent());
        intent.addFlags(67108864);
        intent.setDataAndType(getIntent().getData(), getIntent().getType());
        intent.setAction(getIntent().getAction());
        Intent intent2 = new Intent();
        intent2.putExtras(getIntent());
        d.a(this, "account", "com.tencent.mm.plugin.account.ui.SimpleLoginUI", intent2, intent);
        return true;
    }

    public int getLayoutId() {
        return -1;
    }
}
