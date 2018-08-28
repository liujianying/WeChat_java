package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;

class MallIndexUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ MallIndexUI lab;
    final /* synthetic */ boolean lad;

    MallIndexUI$4(MallIndexUI mallIndexUI, boolean z) {
        this.lab = mallIndexUI;
        this.lad = z;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i;
        h hVar = h.mEJ;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(0);
        if (this.lad) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = "";
        objArr[3] = "";
        objArr[4] = Integer.valueOf(0);
        hVar.h(14872, objArr);
        MallIndexUI mallIndexUI = this.lab;
        boolean z = MallIndexUI.h(this.lab).cec;
        Intent intent = new Intent(mallIndexUI, MallIndexMenuUI.class);
        intent.putExtra("key_default_show_currency", z);
        mallIndexUI.startActivity(intent);
        return true;
    }
}
