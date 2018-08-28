package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.4;
import com.tencent.mm.ui.base.h.c;

class GestureGalleryUI$4$1 implements c {
    final /* synthetic */ 4 osw;

    GestureGalleryUI$4$1(4 4) {
        this.osw = 4;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                GestureGalleryUI.a(this.osw.osu, GestureGalleryUI.b(this.osw.osu));
                return;
            case 1:
                GestureGalleryUI gestureGalleryUI = this.osw.osu;
                String b = GestureGalleryUI.b(this.osw.osu);
                if (b != null && b.length() != 0) {
                    Intent intent = new Intent();
                    intent.putExtra("Retr_File_Name", b);
                    intent.putExtra("Retr_Msg_Type", 0);
                    intent.putExtra("Retr_Compress_Type", 0);
                    b.ezn.l(intent, gestureGalleryUI.mController.tml);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
