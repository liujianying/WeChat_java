package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.ui.MMActivity;

class s$3 implements OnClickListener {
    final /* synthetic */ s nNl;
    final /* synthetic */ Context val$context;

    s$3(s sVar, Context context) {
        this.nNl = sVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        if (s.a(this.nNl) != null) {
            String eF = s.a(this.nNl).field_snsId == 0 ? "" : i.eF(s.a(this.nNl).field_snsId);
            h.mEJ.h(11989, new Object[]{Integer.valueOf(3), eF, Integer.valueOf(0)});
            int i = s.a(this.nNl).nJc;
            Intent intent = new Intent();
            intent.setClass(this.val$context, SnsCommentDetailUI.class);
            intent.putExtra("INTENT_TALKER", s.a(this.nNl).field_userName);
            intent.putExtra("INTENT_SNS_LOCAL_ID", v.ai("sns_table_", (long) i));
            intent.putExtra("INTENT_FROMGALLERY", true);
            ((MMActivity) this.val$context).startActivityForResult(intent, 1);
        }
    }
}
