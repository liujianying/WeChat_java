package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class ReadMailUI$8 implements OnClickListener {
    final /* synthetic */ ReadMailUI miD;

    ReadMailUI$8(ReadMailUI readMailUI) {
        this.miD = readMailUI;
    }

    public final void onClick(View view) {
        if (ReadMailUI.G(this.miD).getVisibility() == 8) {
            ReadMailUI.H(this.miD).setText(R.l.readmail_addr_hide);
            ReadMailUI.G(this.miD).setVisibility(0);
            ReadMailUI.G(this.miD).post(new 1(this));
            ReadMailUI.h(this.miD).setVisibility(0);
            return;
        }
        ReadMailUI.H(this.miD).setText(R.l.readmail_addr_show);
        ReadMailUI.G(this.miD).setVisibility(8);
        ReadMailUI.h(this.miD).setVisibility(8);
    }
}
