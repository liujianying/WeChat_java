package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class AlbumPreviewUI$15 implements OnMenuItemClickListener {
    final /* synthetic */ AlbumPreviewUI jCE;

    AlbumPreviewUI$15(AlbumPreviewUI albumPreviewUI) {
        this.jCE = albumPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        boolean z = false;
        x.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[]{Integer.valueOf(c.aRm()), Boolean.valueOf(AlbumPreviewUI.l(this.jCE))});
        try {
            AlbumPreviewUI.b(this.jCE).al(11610, (AlbumPreviewUI.l(this.jCE) ? 3 : 2) + "," + c.aRm());
        } catch (Throwable e) {
            x.e("MicroMsg.AlbumPreviewUI", "report error, %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
        }
        if (AlbumPreviewUI.m(this.jCE) < 0) {
            try {
                AlbumPreviewUI.a(this.jCE, AlbumPreviewUI.b(this.jCE).AC());
            } catch (Throwable e2) {
                AlbumPreviewUI.a(this.jCE, 104857600);
                x.e("MicroMsg.AlbumPreviewUI", "getMaxSendVideoSize error, %s", new Object[]{e2.getMessage()});
                x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
            }
        }
        c.aRl();
        if (AlbumPreviewUI.a(this.jCE).aRN().size() == 0) {
            x.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
            this.jCE.setResult(-2);
            this.jCE.finish();
        } else {
            Intent intent = new Intent();
            int aRJ = c.aRf().aRJ();
            if (AlbumPreviewUI.l(this.jCE)) {
                aRJ = 1;
            }
            if (AlbumPreviewUI.n(this.jCE)) {
                aRJ = 1;
            }
            ArrayList arrayList;
            GalleryItem$MediaItem galleryItem$MediaItem;
            if (aRJ == 1) {
                String str = "CropImage_Compress_Img";
                boolean z2 = AlbumPreviewUI.l(this.jCE) ? true : !AlbumPreviewUI.d(this.jCE);
                intent.putExtra(str, z2);
                arrayList = AlbumPreviewUI.a(this.jCE).jBA;
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    galleryItem$MediaItem = (GalleryItem$MediaItem) it.next();
                    if (!galleryItem$MediaItem.mMimeType.equals("edit") || bi.oW(galleryItem$MediaItem.jAT)) {
                        arrayList2.add(galleryItem$MediaItem.egA);
                    } else {
                        arrayList2.add(galleryItem$MediaItem.jAT);
                    }
                }
                intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList2);
                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.o(this.jCE));
                AlbumPreviewUI.p(this.jCE);
                this.jCE.setResult(-1, intent);
                AlbumPreviewUI.q(this.jCE);
                if (bi.oW(AlbumPreviewUI.j(this.jCE)) || "medianote".equals(AlbumPreviewUI.k(this.jCE))) {
                    this.jCE.finish();
                } else if (bi.VG() - AlbumPreviewUI.r(this.jCE) < 1000) {
                    x.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                } else {
                    x.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                    AlbumPreviewUI.a(this.jCE, bi.VG());
                    intent.setClassName(this.jCE, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.jCE));
                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.jCE));
                    this.jCE.startActivityForResult(intent, 4373);
                }
            } else if (aRJ == 2) {
                x.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
                a TQ = a.TQ((String) AlbumPreviewUI.a(this.jCE).aRN().get(0));
                TQ.fi = AlbumPreviewUI.m(this.jCE);
                aRJ = TQ.cfa();
                if (aRJ == 0) {
                    intent.setData(Uri.fromFile(new File((String) AlbumPreviewUI.a(this.jCE).aRN().get(0))));
                    intent.putStringArrayListExtra("key_select_video_list", AlbumPreviewUI.a(this.jCE).aRN());
                    this.jCE.setResult(-1, intent);
                    AlbumPreviewUI.q(this.jCE);
                    this.jCE.finish();
                } else if (aRJ == 2) {
                    AlbumPreviewUI.s(this.jCE);
                } else {
                    AlbumPreviewUI.t(this.jCE);
                }
            } else if (aRJ != 3) {
                x.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
                this.jCE.setResult(-2);
                this.jCE.finish();
            } else if (bi.VG() - AlbumPreviewUI.r(this.jCE) < 1000) {
                x.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
            } else {
                AlbumPreviewUI.a(this.jCE, bi.VG());
                arrayList = AlbumPreviewUI.a(this.jCE).jBA;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    galleryItem$MediaItem = (GalleryItem$MediaItem) it2.next();
                    if (galleryItem$MediaItem.getType() == 1) {
                        if (!galleryItem$MediaItem.mMimeType.equals("edit") || bi.oW(galleryItem$MediaItem.jAT)) {
                            arrayList4.add(galleryItem$MediaItem.egA);
                        } else {
                            arrayList4.add(galleryItem$MediaItem.jAT);
                        }
                    } else if (galleryItem$MediaItem.getType() == 2) {
                        arrayList3.add(galleryItem$MediaItem.egA);
                    }
                }
                String str2 = "CropImage_Compress_Img";
                if (AlbumPreviewUI.l(this.jCE)) {
                    z = true;
                } else if (!AlbumPreviewUI.d(this.jCE)) {
                    z = true;
                }
                intent.putExtra(str2, z);
                intent.putStringArrayListExtra("key_select_video_list", arrayList3);
                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.o(this.jCE));
                AlbumPreviewUI.p(this.jCE);
                if (arrayList4.size() > 0) {
                    intent.setClassName(this.jCE, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList4);
                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.jCE));
                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.jCE));
                    intent.putExtra("CropImage_limit_Img_Size", 26214400);
                    x.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                    this.jCE.startActivityForResult(intent, 4373);
                } else {
                    x.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
                    this.jCE.setResult(-1, intent);
                    this.jCE.finish();
                }
            }
        }
        return true;
    }
}
