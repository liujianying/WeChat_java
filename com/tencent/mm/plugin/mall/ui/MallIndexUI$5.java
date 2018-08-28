package com.tencent.mm.plugin.mall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;

class MallIndexUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ MallIndexUI lab;

    MallIndexUI$5(MallIndexUI mallIndexUI) {
        this.lab = mallIndexUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        MallIndexUI.m(this.lab);
        h.mEJ.h(14419, new Object[]{this.lab.fMk, Integer.valueOf(5)});
        return true;
    }
}
