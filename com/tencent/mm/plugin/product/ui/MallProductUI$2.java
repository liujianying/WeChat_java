package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.f;
import com.tencent.mm.sdk.platformtools.bi;

class MallProductUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ MallProductUI lUa;

    MallProductUI$2(MallProductUI mallProductUI) {
        this.lUa = mallProductUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        f e = MallProductUI.e(this.lUa);
        if (!bi.oW(e.lSG.lQN)) {
            g.Ek();
            g.Eh().dpP.a(new f(e.lSG.bmV(), e.lSG.lQN), 0);
        }
        e.lSG.clear();
        this.lUa.finish();
        return true;
    }
}
