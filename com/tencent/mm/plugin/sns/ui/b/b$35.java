package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.bw.a$f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.b.a;

class b$35 implements OnLongClickListener {
    final /* synthetic */ b olf;

    b$35(b bVar) {
        this.olf = bVar;
    }

    public final boolean onLongClick(View view) {
        String str = (String) view.getTag();
        x.d("MicroMsg.TimelineClickListener", "onCommentLongClick:" + str);
        if (bi.oW(str)) {
            return true;
        }
        if (str.equals(af.bxU())) {
            return true;
        }
        String str2;
        int i;
        if (((MaskImageButton) view).uAL == null || !(((MaskImageButton) view).uAL instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) ((MaskImageButton) view).uAL;
        }
        Intent intent = new Intent();
        n Nl = af.byo().Nl(str2);
        if (Nl == null || !Nl.xb(32)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            return false;
        }
        a aVar = new a(this.olf.activity, view);
        aVar.uKW = new 1(this);
        aVar.ofq = new 2(this, Nl, str, str2);
        int[] iArr = new int[2];
        if (view.getTag(a$f.touch_loc) instanceof int[]) {
            iArr = (int[]) view.getTag(a$f.touch_loc);
        }
        aVar.bU(iArr[0], iArr[1]);
        return false;
    }
}
