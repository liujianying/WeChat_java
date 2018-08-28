package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class AlbumPreviewUI$a implements Runnable {
    public WeakReference<a> jCL;
    public WeakReference<ProgressDialog> jCM;
    public ArrayList<GalleryItem$MediaItem> jCN;

    private AlbumPreviewUI$a() {
    }

    /* synthetic */ AlbumPreviewUI$a(byte b) {
        this();
    }

    public final void run() {
        String str = "MicroMsg.AlbumPreviewUI";
        String str2 = "on NotifyMediaItemsChanged, size %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.jCN == null ? -1 : this.jCN.size());
        x.d(str, str2, objArr);
        if (this.jCL != null) {
            a aVar = (a) this.jCL.get();
            if (aVar != null) {
                AlbumPreviewUI.z(this.jCN);
                aVar.jBz.addAll(this.jCN);
                aVar.notifyDataSetChanged();
                if (this.jCM != null) {
                    ProgressDialog progressDialog = (ProgressDialog) this.jCM.get();
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        x.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start)});
                    }
                }
            }
        }
    }

    public final String toString() {
        return super.toString() + "|notifyRunnable";
    }
}
