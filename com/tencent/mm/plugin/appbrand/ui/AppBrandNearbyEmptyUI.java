package com.tencent.mm.plugin.appbrand.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.report.a.j$a;
import com.tencent.mm.plugin.appbrand.report.a.j.b;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public final class AppBrandNearbyEmptyUI extends DrawStatusBarActivity {
    protected final int getLayoutId() {
        return h.app_brand_nearby_empty_ui;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        this.mController.contentView.setBackgroundColor(-855310);
        lF(-855310);
        setMMTitle(j.app_brand_nearby_list_title);
        nS(-16777216);
        setBackBtn(new 1(this));
        k.c(this);
        TextView textView = (TextView) findViewById(g.content_title);
        TextView textView2 = (TextView) findViewById(g.content_message);
        com.tencent.mm.plugin.appbrand.report.a.j jVar;
        switch (getIntent().getIntExtra("extra_enter_reason", 0)) {
            case 0:
                jVar = new com.tencent.mm.plugin.appbrand.report.a.j();
                jVar.grT = b.gsg;
                jVar.grX = j$a.EMPTY_PAGE;
                jVar.xP();
                break;
            case 1:
                textView.setText(j.app_brand_nearby_lbs_not_allowed_title);
                textView2.setText(j.app_brand_nearby_lbs_not_allowed_message);
                jVar = new com.tencent.mm.plugin.appbrand.report.a.j();
                jVar.grT = b.gsg;
                jVar.grX = j$a.LBS_NOT_ALLOW;
                jVar.xP();
                break;
            default:
                finish();
                return;
        }
        setResult(-1);
    }

    public final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && j.b(getWindow())) {
            return -855310;
        }
        if (VERSION.SDK_INT >= 21) {
            return AppBrandLauncherUI.guy;
        }
        return super.getStatusBarColor();
    }
}
