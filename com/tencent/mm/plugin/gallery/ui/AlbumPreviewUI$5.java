package com.tencent.mm.plugin.gallery.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class AlbumPreviewUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ AlbumPreviewUI jCE;

    AlbumPreviewUI$5(AlbumPreviewUI albumPreviewUI) {
        this.jCE = albumPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.AlbumPreviewUI", "backBtn");
        this.jCE.setResult(-2);
        if (AlbumPreviewUI.v(this.jCE).Ld) {
            AlbumPreviewUI.v(this.jCE).aRT();
        } else {
            this.jCE.finish();
        }
        return true;
    }
}
