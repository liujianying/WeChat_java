package com.tencent.mm.plugin.gallery.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.2;
import com.tencent.mm.sdk.platformtools.x;

class AlbumPreviewUI$2$1 implements OnClickListener {
    final /* synthetic */ int hW;
    final /* synthetic */ 2 jCF;

    AlbumPreviewUI$2$1(2 2, int i) {
        this.jCF = 2;
        this.hW = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MediaItem qx = AlbumPreviewUI.a(this.jCF.jCE).qx(this.hW);
        if (qx == null) {
            x.w("MicroMsg.AlbumPreviewUI", "get item for video error, null, position %d", new Object[]{Integer.valueOf(this.hW)});
            this.jCF.jCE.setResult(0);
        } else {
            x.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
            Intent intent = new Intent();
            intent.setData(Uri.parse("file://" + Uri.encode(qx.egA)));
            this.jCF.jCE.setResult(-1, intent);
        }
        this.jCF.jCE.finish();
    }
}
