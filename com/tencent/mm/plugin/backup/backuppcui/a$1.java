package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a gXc;
    final /* synthetic */ int hW;

    a$1(a aVar, int i) {
        this.gXc = aVar;
        this.hW = i;
    }

    public final void onClick(View view) {
        if (a.a(this.gXc).contains(Integer.valueOf(this.hW))) {
            a.a(this.gXc).remove(Integer.valueOf(this.hW));
        } else {
            a.a(this.gXc).add(Integer.valueOf(this.hW));
        }
        this.gXc.notifyDataSetChanged();
        a.b(this.gXc).a(a.a(this.gXc));
    }
}
