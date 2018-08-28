package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a gUX;
    final /* synthetic */ int hW;

    a$1(a aVar, int i) {
        this.gUX = aVar;
        this.hW = i;
    }

    public final void onClick(View view) {
        if (a.a(this.gUX).contains(Integer.valueOf(this.hW))) {
            a.a(this.gUX).remove(Integer.valueOf(this.hW));
        } else {
            a.a(this.gUX).add(Integer.valueOf(this.hW));
        }
        this.gUX.notifyDataSetChanged();
        a.b(this.gUX).a(a.a(this.gUX));
    }
}
