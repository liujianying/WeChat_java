package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1.1;

class NormalUserFooterPreference$a$1$1$2 implements OnClickListener {
    final /* synthetic */ CheckBox lXA;
    final /* synthetic */ 1 lXB;

    NormalUserFooterPreference$a$1$1$2(1 1, CheckBox checkBox) {
        this.lXB = 1;
        this.lXA = checkBox;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lXB.lXz.lXy.bnE();
        if (NormalUserFooterPreference.a(this.lXB.lXz.lXy.lXw).getSource() == 18) {
            NormalUserFooterPreference.a(this.lXB.lXz.lXy.lXw, 9);
            if (this.lXA.isChecked()) {
                NormalUserFooterPreference$a.c(this.lXB.lXz.lXy);
            }
        }
    }
}
