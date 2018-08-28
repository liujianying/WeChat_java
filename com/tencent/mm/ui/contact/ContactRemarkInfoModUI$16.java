package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.at.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

class ContactRemarkInfoModUI$16 implements OnClickListener {
    final /* synthetic */ ContactRemarkInfoModUI ujh;

    ContactRemarkInfoModUI$16(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ujh = contactRemarkInfoModUI;
    }

    public final void onClick(View view) {
        if (ContactRemarkInfoModUI.j(this.ujh)) {
            String o;
            ContactRemarkInfoModUI.k(this.ujh);
            Intent intent = new Intent(this.ujh, ContactRemarkImagePreviewUI.class);
            intent.putExtra("Contact_User", ContactRemarkInfoModUI.l(this.ujh));
            if (ai.oW(ContactRemarkInfoModUI.m(this.ujh)) || ContactRemarkInfoModUI.n(this.ujh)) {
                o = ContactRemarkInfoModUI.o(this.ujh);
            } else {
                c.Qt();
                o = c.my(ContactRemarkInfoModUI.l(this.ujh));
            }
            intent.putExtra("remark_image_path", o);
            intent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.n(this.ujh));
            this.ujh.startActivityForResult(intent, TbsListener$ErrorCode.INFO_CODE_BASE);
        }
    }
}
