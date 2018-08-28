package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class SnsUploadBrowseUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SnsUploadBrowseUI ogp;

    SnsUploadBrowseUI$3(SnsUploadBrowseUI snsUploadBrowseUI) {
        this.ogp = snsUploadBrowseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.ogp, j.sns_gallery_del, j.app_tip, new 1(this), new 2(this));
        return true;
    }
}
