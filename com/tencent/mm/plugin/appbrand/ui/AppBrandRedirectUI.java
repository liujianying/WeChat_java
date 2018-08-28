package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.tencent.mm.al.b;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandRedirectUI extends MMActivity {
    private int fromScene = -1;
    private boolean gvt = false;
    private int result = 0;

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j.a(getWindow());
        x.i("AppBrandRedirectUI", "onCreate");
        setResult(0);
        this.fromScene = getIntent().getIntExtra("key_from_scene", -1);
        if (this.fromScene == 0) {
            getIntent().putExtra("WizardRootClass", getClass().getName());
            x.i("AppBrandRedirectUI", "start to bind phone number");
            Intent intent = new Intent();
            intent.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMContactUI");
            intent.putExtra("is_bind_for_safe_device", false);
            intent.putExtra("bind_scene", 5);
            String simCountryIso = ((TelephonyManager) this.mController.tml.getSystemService("phone")).getSimCountryIso();
            if (!bi.oW(simCountryIso)) {
                b.a j = b.j(this, simCountryIso, this.mController.tml.getString(j.country_code));
                if (j != null) {
                    intent.putExtra("country_name", j.dYy);
                    intent.putExtra("couttry_code", j.dYx);
                }
            }
            MMWizardActivity.D(this, intent);
            return;
        }
        x.e("AppBrandRedirectUI", "from scene is illegal, finish activity");
        finish();
    }

    protected void onResume() {
        super.onResume();
        x.i("AppBrandRedirectUI", "onResume");
        if (this.gvt) {
            x.i("AppBrandRedirectUI", "onResume, RESULT_CANCELED  finish activity");
            setResult(0);
            finish();
            return;
        }
        this.gvt = true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("AppBrandRedirectUI", "onKeyDown KEYCODE_BACK, result cancel, finishUI");
            setResult(0);
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onNewIntent(Intent intent) {
        x.i("AppBrandRedirectUI", "onNewIntent");
        super.onNewIntent(intent);
        if (intent != null) {
            this.result = intent.getIntExtra("wizard_activity_result_code", 0);
            setResult(this.result);
            x.i("AppBrandRedirectUI", "result:%d, finish activity", new Object[]{Integer.valueOf(this.result)});
        } else {
            x.i("AppBrandRedirectUI", "intent is null");
            setResult(0);
        }
        finish();
    }
}
