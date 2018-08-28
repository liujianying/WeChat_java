package com.tencent.mm.plugin.account.security.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.i;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI extends MMWizardActivity {
    protected final int getLayoutId() {
        return g.security_account_normal;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle(j.safe_device_account_protect);
        setBackBtn(new 1(this));
        ((ImageView) findViewById(f.security_account_state_icon)).setImageResource(i.accounts_saftphone_icon);
        ((TextView) findViewById(f.security_account_tips)).setText(j.safe_device_bind__hit);
        ((TextView) findViewById(f.tip_title)).setText(j.safe_device_bind_mobile);
        findViewById(f.tip_title).setOnClickListener(new 2(this));
    }
}
