package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class AlbumPreviewUI$17 implements OnClickListener {
    final /* synthetic */ AlbumPreviewUI jCE;

    AlbumPreviewUI$17(AlbumPreviewUI albumPreviewUI) {
        this.jCE = albumPreviewUI;
    }

    public final void onClick(View view) {
        AlbumPreviewUI.u(this.jCE);
        AlbumPreviewUI.v(this.jCE).aRT();
        x.d("MicroMsg.AlbumPreviewUI", "click folder times[%d]", new Object[]{Integer.valueOf(AlbumPreviewUI.w(this.jCE))});
    }
}
