package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetSettingsUI extends MMActivity {
    String appId;
    int bPh;

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(e.wxa_widget_settings);
        this.appId = getIntent().getStringExtra("app_id");
        this.bPh = getIntent().getIntExtra("pkg_type", 0);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(b.open_ban_btn);
        DebuggerInfo sD = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.sD(this.appId);
        boolean z2 = sD != null && sD.fvF;
        mMSwitchBtn.setCheck(z2);
        mMSwitchBtn.setSwitchListener(new 2(this));
        mMSwitchBtn = (MMSwitchBtn) findViewById(b.inject_debug_btn);
        if ((sD != null && sD.fvD) || a.ho(this.bPh)) {
            z = true;
        }
        mMSwitchBtn.setCheck(z);
        mMSwitchBtn.setEnabled(a.jC(this.bPh));
        mMSwitchBtn.setSwitchListener(new 3(this));
    }

    protected final int getLayoutId() {
        return c.wxa_widget_settings_ui;
    }
}
