package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceLikeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceLikeUI iDa;

    ExdeviceLikeUI$1(ExdeviceLikeUI exdeviceLikeUI) {
        this.iDa = exdeviceLikeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.iDa, ExdeviceRankInfoUI.class);
        intent.putExtra("app_username", ExdeviceLikeUI.a(this.iDa));
        intent.putExtra("rank_id", "#");
        intent.putExtra("key_is_latest", true);
        intent.putExtra("device_type", 1);
        this.iDa.startActivity(intent);
        this.iDa.finish();
        return false;
    }
}
