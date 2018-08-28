package com.tencent.mm.plugin.appbrand.ui;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public final class AppBrandStarListUI extends DrawStatusBarActivity {
    private Dialog gvJ = null;

    static /* synthetic */ void a(AppBrandStarListUI appBrandStarListUI) {
        Fragment R = appBrandStarListUI.getSupportFragmentManager().R(16908290);
        if (R == null || !(R instanceof c)) {
            appBrandStarListUI.getSupportFragmentManager().bk().b(16908290, c.bM(appBrandStarListUI.getString(j.app_brand_star_list_title), appBrandStarListUI.getString(j.app_brand_star_list_blank_page_tip))).commit();
            if (appBrandStarListUI.gvJ != null) {
                appBrandStarListUI.gvJ.dismiss();
            }
            appBrandStarListUI.gvJ = null;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && j.b(getWindow())) {
            return -855310;
        }
        if (VERSION.SDK_INT >= 21) {
            return AppBrandLauncherUI.guy;
        }
        return super.getStatusBarColor();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void onBackPressed() {
        Fragment R = getSupportFragmentManager().R(16908290);
        if (R != null && (R instanceof a)) {
            boolean z;
            a aVar = (a) R;
            if (aVar.gvQ) {
                aVar.gvQ = false;
                aVar.a(AppBrandStarListUI$a$c.SWITCH_TO_NORMAL);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
        }
        super.onBackPressed();
    }
}
