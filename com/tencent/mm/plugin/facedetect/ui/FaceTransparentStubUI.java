package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.g.a.np;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

@a(3)
public class FaceTransparentStubUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("KEY_REQUEST_CODE", BaseReportManager.MAX_READ_COUNT);
        Bundle bundleExtra = getIntent().getBundleExtra("KEY_EXTRAS");
        if (!bundleExtra.containsKey("k_user_name")) {
            g.Eg();
            if (com.tencent.mm.kernel.a.Dw()) {
                bundleExtra.putString("k_user_name", q.GI());
            }
        }
        np npVar = new np();
        npVar.bYG.context = this;
        npVar.bYG.bYI = intExtra;
        npVar.bYG.extras = bundleExtra;
        com.tencent.mm.sdk.b.a.sFg.m(npVar);
        x.i("MicroMsg.FaceTransparentStubUI", "hy: start face detect event result: %b", new Object[]{Boolean.valueOf(npVar.bYH.bYJ)});
        if (!npVar.bYH.bYJ) {
            if (npVar.bYH.extras != null) {
                Intent intent = new Intent();
                intent.putExtras(npVar.bYH.extras);
                setResult(1, intent);
            } else {
                setResult(1);
            }
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.FaceTransparentStubUI", "hy: on activity result in FaceTransparentStubUI");
        setResult(i2, intent);
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
