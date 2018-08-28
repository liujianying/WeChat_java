package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.gallery.model.c;

class AlbumPreviewUI$14 implements OnClickListener {
    final /* synthetic */ AlbumPreviewUI jCE;

    AlbumPreviewUI$14(AlbumPreviewUI albumPreviewUI) {
        this.jCE = albumPreviewUI;
    }

    public final void onClick(View view) {
        AlbumPreviewUI.h(this.jCE);
        Intent intent = new Intent(this.jCE, ImagePreviewUI.class);
        c.v(AlbumPreviewUI.a(this.jCE).jBz);
        intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.jCE).aRN());
        intent.putExtra("max_select_count", AlbumPreviewUI.i(this.jCE));
        intent.putExtra("send_raw_img", AlbumPreviewUI.d(this.jCE));
        intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.jCE));
        intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.jCE));
        this.jCE.startActivityForResult(intent, 0);
    }
}
