package com.tencent.mm.plugin.webwx.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebWeiXinIntroductionUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WebWeiXinIntroductionUI qmH;

    WebWeiXinIntroductionUI$2(WebWeiXinIntroductionUI webWeiXinIntroductionUI) {
        this.qmH = webWeiXinIntroductionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qmH.finish();
        return true;
    }
}
