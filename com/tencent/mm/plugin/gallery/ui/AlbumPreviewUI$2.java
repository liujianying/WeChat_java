package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

class AlbumPreviewUI$2 implements OnItemClickListener {
    final /* synthetic */ AlbumPreviewUI jCE;

    AlbumPreviewUI$2(AlbumPreviewUI albumPreviewUI) {
        this.jCE = albumPreviewUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 1;
        MediaItem qx;
        ArrayList qw;
        Intent intent;
        if (c.aRf().aRI() == 0 || c.aRf().aRI() == 5 || c.aRf().aRI() == 10 || c.aRf().aRI() == 11) {
            if (c.aRf().aRJ() == 2) {
                h.a(this.jCE, true, this.jCE.getString(R.l.gallery_send_video_to_chat), "", this.jCE.getString(R.l.app_send), this.jCE.getString(R.l.app_cancel), new 1(this, i), null);
                return;
            }
            qx = AlbumPreviewUI.a(this.jCE).qx(i);
            if (qx == null) {
                x.w("MicroMsg.AlbumPreviewUI", "get item error, null, position %d", new Object[]{Integer.valueOf(i)});
                this.jCE.setResult(0);
            } else {
                Intent intent2 = new Intent();
                if (qx.getType() == 2) {
                    intent2.putExtra("is_video", true);
                    intent2.putExtra("video_full_path", qx.egA);
                }
                if (c.aRf().aRI() == 10) {
                    intent2.putExtra("CropImage_OutputPath", qx.egA);
                }
                intent2.setData(Uri.parse(Uri.encode(qx.egA)));
                x.i("MicroMsg.AlbumPreviewUI", "getItem ok");
                this.jCE.setResult(-1, intent2);
            }
            this.jCE.finish();
        } else if (c.aRf().aRI() == 4) {
            if (i < AlbumPreviewUI.a(this.jCE).jBD.size()) {
                x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                return;
            }
            qx = AlbumPreviewUI.a(this.jCE).qx(i);
            if (qx == null) {
                x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
            } else if (qx.getType() != 2 || AlbumPreviewUI.a(this.jCE).jBA.size() == 0) {
                qw = AlbumPreviewUI.a(this.jCE).qw(qx.getType());
                c.v(qw);
                intent = new Intent(this.jCE, ImagePreviewUI.class);
                intent.putExtra("key_edit_video_max_time_length", this.jCE.getIntent().getIntExtra("key_edit_video_max_time_length", 10));
                intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.jCE).aRN());
                intent.putExtra("preview_all", true);
                intent.putExtra("preview_position", qw.indexOf(qx));
                this.jCE.L(i - AlbumPreviewUI.a(this.jCE).jBD.size(), true);
                intent.putExtra("send_raw_img", AlbumPreviewUI.d(this.jCE));
                intent.putExtra("max_select_count", AlbumPreviewUI.i(this.jCE));
                intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.jCE));
                intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.jCE));
                this.jCE.startActivityForResult(intent, 0);
            } else {
                h.bA(this.jCE.mController.tml, a.af(this.jCE.mController.tml, R.l.gallery_pic_can_not_choose_video));
            }
        } else if (AlbumPreviewUI.n(this.jCE)) {
            if (i < AlbumPreviewUI.a(this.jCE).jBD.size()) {
                x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                return;
            }
            qx = AlbumPreviewUI.a(this.jCE).qx(i);
            if (qx == null) {
                x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
            } else if (qx.getType() != 2 || AlbumPreviewUI.a(this.jCE).jBA.size() == 0) {
                qw = AlbumPreviewUI.a(this.jCE).qw(qx.getType());
                c.v(qw);
                intent = new Intent(this.jCE, ImagePreviewUI.class);
                intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.jCE).aRN());
                intent.putExtra("preview_all", true);
                intent.putExtra("preview_position", qw.indexOf(qx));
                this.jCE.L(i - AlbumPreviewUI.a(this.jCE).jBD.size(), true);
                intent.putExtra("send_raw_img", AlbumPreviewUI.d(this.jCE));
                String str = "max_select_count";
                if (qx.getType() != 2) {
                    i2 = AlbumPreviewUI.i(this.jCE);
                }
                intent.putExtra(str, i2);
                intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.jCE));
                intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.jCE));
                this.jCE.startActivityForResult(intent, 0);
            } else {
                h.bA(this.jCE.mController.tml, a.af(this.jCE.mController.tml, R.l.gallery_pic_can_not_choose_video));
            }
        } else if (i < AlbumPreviewUI.a(this.jCE).jBD.size()) {
            x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
        } else {
            c.v(AlbumPreviewUI.a(this.jCE).jBz);
            Intent intent3 = new Intent(this.jCE, ImagePreviewUI.class);
            intent3.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.jCE).aRN());
            intent3.putExtra("preview_all", true);
            intent3.putExtra("preview_position", i - AlbumPreviewUI.a(this.jCE).jBD.size());
            this.jCE.L(i - AlbumPreviewUI.a(this.jCE).jBD.size(), true);
            intent3.putExtra("send_raw_img", AlbumPreviewUI.d(this.jCE));
            intent3.putExtra("max_select_count", AlbumPreviewUI.i(this.jCE));
            intent3.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.jCE));
            intent3.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.jCE));
            this.jCE.startActivityForResult(intent3, 0);
        }
    }
}
