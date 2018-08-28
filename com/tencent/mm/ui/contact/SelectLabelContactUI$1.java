package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class SelectLabelContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SelectLabelContactUI ulQ;

    SelectLabelContactUI$1(SelectLabelContactUI selectLabelContactUI) {
        this.ulQ = selectLabelContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new Object[]{new ArrayList(SelectLabelContactUI.a(this.ulQ)).toString()});
        SelectLabelContactUI.a(this.ulQ, bi.c(r0, ","));
        return true;
    }
}
