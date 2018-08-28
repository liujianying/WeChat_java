package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class ContactRemarkInfoModUI$7 implements c {
    final /* synthetic */ ContactRemarkInfoModUI ujh;

    ContactRemarkInfoModUI$7(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ujh = contactRemarkInfoModUI;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                x.d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
                Intent intent = new Intent();
                intent.putExtra("max_select_count", 1);
                intent.putExtra("query_source_type", 0);
                intent.putExtra("send_btn_string", " ");
                intent.addFlags(67108864);
                d.b(this.ujh, "gallery", ".ui.GalleryEntryUI", intent, HardCoderJNI.sHCDBDELAY_WRITE);
                return;
            case 1:
                x.d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
                ContactRemarkInfoModUI.w(this.ujh);
                return;
            default:
                return;
        }
    }
}
