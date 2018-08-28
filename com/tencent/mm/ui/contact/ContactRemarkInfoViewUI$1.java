package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.at.c;

class ContactRemarkInfoViewUI$1 implements OnClickListener {
    final /* synthetic */ ContactRemarkInfoViewUI ujm;

    ContactRemarkInfoViewUI$1(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        this.ujm = contactRemarkInfoViewUI;
    }

    public final void onClick(View view) {
        if (ContactRemarkInfoViewUI.a(this.ujm)) {
            Intent intent = new Intent(this.ujm, ContactRemarkImagePreviewUI.class);
            intent.putExtra("Contact_User", ContactRemarkInfoViewUI.b(this.ujm));
            c.Qt();
            intent.putExtra("remark_image_path", c.my(ContactRemarkInfoViewUI.b(this.ujm)));
            intent.putExtra("view_only", true);
            this.ujm.startActivity(intent);
        }
    }
}
