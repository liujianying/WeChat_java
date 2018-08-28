package com.tencent.mm.plugin.clean.ui;

import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import org.json.JSONObject;

@a(19)
public class CleanUI extends MMActivity {
    private JSONObject hRA;
    private long hRw;
    private String hRx = "com.tencent.qqpimsecure";
    private String hRy = "00B1208638DE0FCD3E920886D658DAF6";
    private String hRz = "11206657";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("had_detected_no_sdcard_space", false) && aBu()) {
            finish();
            return;
        }
        startActivity(new Intent(this, CleanNewUI.class));
        finish();
    }

    private boolean aBu() {
        aBv();
        if (!p.r(this.mController.tml, this.hRx)) {
            return false;
        }
        Signature[] bh = p.bh(this, this.hRx);
        if (bh == null || bh[0] == null) {
            return false;
        }
        String u = g.u(bh[0].toByteArray());
        if (u == null || !u.equalsIgnoreCase(this.hRy)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.hRx);
            if (launchIntentForPackage != null) {
                Bundle bundle = new Bundle();
                p.g(bundle, this.hRz);
                launchIntentForPackage.putExtras(bundle);
                launchIntentForPackage.addFlags(268435456);
                startActivity(launchIntentForPackage);
                h.mEJ.a(282, 6, 1, false);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
        }
        return true;
    }

    private boolean aBv() {
        au.HU();
        String str = (String) c.DT().get(aa.a.sSl, "");
        if (bi.oW(str)) {
            return false;
        }
        try {
            this.hRA = new JSONObject(str);
            this.hRx = this.hRA.getString("packageName");
            this.hRA.get("md5");
            this.hRz = this.hRA.getString("launcherID");
            this.hRy = this.hRA.getString("signature");
            this.hRA.get("url");
            this.hRw = this.hRA.getLong("size");
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanUI", e, "", new Object[0]);
            return false;
        }
    }

    protected final int getLayoutId() {
        return R.i.clean_empty;
    }
}
