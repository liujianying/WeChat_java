package com.tencent.mm.ui;

import android.graphics.Color;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.h.13;

class h$13$3 implements Runnable {
    final /* synthetic */ 13 tiR;
    final /* synthetic */ int tiS;

    h$13$3(13 13, int i) {
        this.tiR = 13;
        this.tiS = i;
    }

    public final void run() {
        h.a(this.tiR.tiG, true);
        IconPreference iconPreference = (IconPreference) h.a(this.tiR.tiG).ZZ("more_tab_game_recommend");
        if (this.tiR.tiP == 3) {
            iconPreference.dk(this.tiR.tiG.getString(R.l.app_new), R.g.new_tips_bg);
            h.a(iconPreference, 0, 8, false, 8, 8, 8);
            h.b(this.tiR.bAj, this.tiR.pre, this.tiR.tiQ, this.tiR.dAy, 1);
        } else if (this.tiR.tiP == 4) {
            iconPreference.ao(this.tiR.fhQ, -1, Color.parseColor("#8c8c8c"));
            h.a(iconPreference, 8, 0, true, 8, 8, 8);
            h.b(this.tiR.bAj, this.tiR.pre, this.tiR.tiQ, this.tiR.dAy, 2);
        }
        h.mEJ.a(858, 12, 1, false);
        if (this.tiS == 2) {
            h.mEJ.a(858, 14, 1, false);
        }
    }
}
