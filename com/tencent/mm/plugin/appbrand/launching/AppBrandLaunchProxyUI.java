package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.precondition.d;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.launching.precondition.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;

@a(7)
public final class AppBrandLaunchProxyUI extends MMBaseActivity implements k {
    private p geH;
    private h geI;
    private MMActivity.a geJ = null;

    public static boolean v(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            if (intent.getComponent() == null || !intent.getComponent().getShortClassName().equals(".plugin.appbrand.launching.AppBrandLaunchProxyUI")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void a(Context context, String str, String str2, int i, int i2, AppBrandStatObject appBrandStatObject, LaunchParamsOptional launchParamsOptional) {
        a(context, str, null, str2, i, i2, appBrandStatObject, null, launchParamsOptional);
    }

    public static boolean a(Context context, String str, String str2, String str3, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        if (bi.oW(str) && bi.oW(str2)) {
            return false;
        }
        return g.ghE.a(context, str, str2, str3, i, i2, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        h fVar;
        j.a(getWindow());
        j.a(getWindow(), true);
        if (getIntent().getBooleanExtra("extra_from_mm", true)) {
            fVar = new f(this);
        } else {
            fVar = new d(this);
        }
        this.geI = fVar;
        if (this.geI != null) {
            x.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, uiDelegate %s", new Object[]{this.geI.getClass().getSimpleName()});
            this.geI.w(getIntent());
            if (!isFinishing()) {
                getString(s.j.app_tip);
                this.geH = com.tencent.mm.ui.base.h.a(this, getString(s.j.loading_tips), true, new 1(this));
                if (this.geH == null) {
                    x.e("MicroMsg.AppBrandLaunchProxyUI", "onCreate, get null progress dialog");
                    finish();
                    return;
                }
                this.geH.setOnDismissListener(new 2(this));
                if (this.geH.getWindow() != null) {
                    LayoutParams attributes = this.geH.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.geH.getWindow().setAttributes(attributes);
                    return;
                }
                return;
            }
            return;
        }
        finish();
    }

    protected final void onResume() {
        super.onResume();
        if (this.geI != null) {
            this.geI.onResume();
        } else {
            super.finish();
        }
    }

    protected final void onPause() {
        super.onPause();
        if (this.geI != null) {
            this.geI.onPause();
        } else {
            super.finish();
        }
    }

    protected final void onDestroy() {
        super.onDestroy();
        if (this.geH != null) {
            this.geH.dismiss();
            this.geH = null;
        }
    }

    public final void a(MMActivity.a aVar, Intent intent, int i) {
        this.geJ = aVar;
        startActivityForResult(intent, i);
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.geJ != null) {
            this.geJ.b(i, i2, intent);
        }
        this.geJ = null;
    }

    public final boolean akz() {
        return !isFinishing();
    }
}
