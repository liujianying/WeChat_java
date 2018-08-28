package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class AttachDownloadPage$2 implements OnMenuItemClickListener {
    final /* synthetic */ AttachDownloadPage meu;

    AttachDownloadPage$2(AttachDownloadPage attachDownloadPage) {
        this.meu = attachDownloadPage;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.meu, "", new String[]{this.meu.getString(R.l.plugin_favorite_opt)}, "", false, new 1(this));
        return true;
    }
}
