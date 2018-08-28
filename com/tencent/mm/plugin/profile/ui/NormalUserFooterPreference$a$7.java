package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.report.service.h;

class NormalUserFooterPreference$a$7 implements OnClickListener {
    final /* synthetic */ a lXy;

    NormalUserFooterPreference$a$7(a aVar) {
        this.lXy = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14553, new Object[]{Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.a(this.lXy.lXw).field_username});
        this.lXy.isDeleteCancel = true;
        Intent intent = new Intent();
        intent.putExtra("Chat_User", NormalUserFooterPreference.a(this.lXy.lXw).field_username);
        intent.addFlags(67108864);
        d.e(this.lXy.lXw.mContext, ".ui.chatting.ChattingUI", intent);
    }
}
