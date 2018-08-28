package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.b.p$c;

class ReadMailUI$12 implements OnClickListener {
    final /* synthetic */ ReadMailUI miD;

    ReadMailUI$12(ReadMailUI readMailUI) {
        this.miD = readMailUI;
    }

    public final void onClick(View view) {
        ReadMailUI.j(this.miD).setVisibility(8);
        ReadMailUI.a(this.miD, new p$c());
    }
}
