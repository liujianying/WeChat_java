package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountInputPassUI extends MMActivity {
    protected final int getLayoutId() {
        return g.setting_delete_account_input_pass;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.setting_del_account_title);
        initView();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(i.app_finish), new 2(this));
    }
}
