package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class GroupCardSelectUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ GroupCardSelectUI ujL;

    GroupCardSelectUI$3(GroupCardSelectUI groupCardSelectUI) {
        this.ujL = groupCardSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_User", bi.c(GroupCardSelectUI.e(this.ujL), ","));
        this.ujL.setResult(-1, intent);
        this.ujL.finish();
        return true;
    }
}
