package com.tencent.mm.plugin.sns.ui;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bi;

class bf$1 implements a {
    final /* synthetic */ SpannableString ohq;
    final /* synthetic */ int ohr;
    final /* synthetic */ bf ohs;

    bf$1(bf bfVar, SpannableString spannableString, int i) {
        this.ohs = bfVar;
        this.ohq = spannableString;
        this.ohr = i;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        if (!bi.oW(str)) {
            Drawable createFromPath = Drawable.createFromPath(str);
            if (createFromPath != null) {
                createFromPath.setBounds(0, 0, (int) (((double) this.ohs.ohl.getTextSize()) * 1.3d), (int) (((double) this.ohs.ohl.getTextSize()) * 1.3d));
                this.ohq.setSpan(new ImageSpan(createFromPath, 0), this.ohr, this.ohr + 3, 33);
                this.ohs.ohl.setText(this.ohq);
            }
        }
    }
}
