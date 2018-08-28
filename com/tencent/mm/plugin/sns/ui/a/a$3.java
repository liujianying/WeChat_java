package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.sns.i.f;

class a$3 implements OnLongClickListener {
    final /* synthetic */ View ohN;
    final /* synthetic */ a oiE;

    a$3(a aVar, View view) {
        this.oiE = aVar;
        this.ohN = view;
    }

    public final boolean onLongClick(View view) {
        int[] iArr;
        int[] iArr2 = new int[2];
        if (view.getTag(f.touch_loc) instanceof int[]) {
            iArr = (int[]) view.getTag(f.touch_loc);
        } else {
            iArr = iArr2;
        }
        this.oiE.nuc.hql.a(this.ohN, this.oiE.nuc.ntw.okI, this.oiE.nuc.ntw.okv, iArr[0], iArr[1]);
        return true;
    }
}
