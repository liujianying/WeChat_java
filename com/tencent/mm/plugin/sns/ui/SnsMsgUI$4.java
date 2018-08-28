package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsMsgUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$4(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", SnsMsgUI.m(this.nYl));
        this.nYl.setResult(-1, intent);
        this.nYl.finish();
        return true;
    }
}
