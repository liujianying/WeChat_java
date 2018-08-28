package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;

class SelectContactUI$12 implements OnClickListener {
    final /* synthetic */ SelectContactUI ulL;

    SelectContactUI$12(SelectContactUI selectContactUI) {
        this.ulL = selectContactUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11140, new Object[]{Integer.valueOf(0)});
        d.A(this.ulL, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
    }
}
