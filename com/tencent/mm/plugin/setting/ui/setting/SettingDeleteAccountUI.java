package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountUI extends MMActivity {
    protected final int getLayoutId() {
        return g.setting_delete_account;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.setting_del_account_title);
        initView();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        ((TextView) findViewById(f.delete_account_btn)).setOnClickListener(new 2(this));
    }
}
