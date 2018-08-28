package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ch;
import java.util.List;

class ImageGalleryGridUI$10 implements OnClickListener {
    final /* synthetic */ List gco;
    final /* synthetic */ ch tOZ;
    final /* synthetic */ ImageGalleryGridUI tUJ;

    ImageGalleryGridUI$10(ImageGalleryGridUI imageGalleryGridUI, ch chVar, List list) {
        this.tUJ = imageGalleryGridUI;
        this.tOZ = chVar;
        this.gco = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.tOZ.bJF.type == 14 && this.tOZ.bJF.bJH.rBI.size() == 0) {
            this.tUJ.cwy();
            return;
        }
        ImageGalleryGridUI.a(this.tUJ, this.tOZ);
        ImageGalleryGridUI.dK(this.gco);
    }
}
