package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.MMActivity;

class j$5 implements OnLongClickListener {
    final /* synthetic */ j nMb;

    j$5(j jVar) {
        this.nMb = jVar;
    }

    public final boolean onLongClick(View view) {
        g.Ek();
        if (((Boolean) g.Ei().DT().get(7490, Boolean.valueOf(true))).booleanValue()) {
            j.c(this.nMb).startActivity(new Intent().setClass(j.c(this.nMb), SnsLongMsgUI.class));
            g.Ek();
            g.Ei().DT().set(7490, Boolean.valueOf(false));
        } else {
            Intent intent = new Intent();
            intent.setClass(j.c(this.nMb), SnsCommentUI.class);
            intent.putExtra("sns_comment_type", 1);
            ((MMActivity) j.c(this.nMb)).startActivityForResult(intent, 9);
        }
        return true;
    }
}
