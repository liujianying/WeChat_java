package com.tencent.mm.plugin.account.bind.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.MMWizardActivity;

public class SuccUnbindQQ extends MMWizardActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return g.succ_unbindqq;
    }

    protected final void initView() {
        setMMTitle(j.unbind_qq);
        addTextOptionMenu(0, getString(j.app_finish), new 1(this));
    }
}
