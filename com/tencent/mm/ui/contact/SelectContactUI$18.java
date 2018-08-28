package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ak.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

class SelectContactUI$18 implements Runnable {
    final /* synthetic */ SelectContactUI ulL;
    final /* synthetic */ ArrayList ulP;

    SelectContactUI$18(SelectContactUI selectContactUI, ArrayList arrayList) {
        this.ulL = selectContactUI;
        this.ulP = arrayList;
    }

    public final void run() {
        String GF = q.GF();
        Iterator it = this.ulP.iterator();
        int i = 0;
        String str = null;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            x.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[]{str2});
            int i2 = i + (s.fq(str2) ? 1 : 0);
            l lVar = new l(4, GF, str2, this.ulL.getIntent().getStringExtra("shareImagePath"), 0, null, 0, "", str, true, R.g.chat_img_template);
            au.DF().a(lVar, 0);
            if (lVar.bGS != null) {
                str = lVar.bGS.field_imgPath;
            }
            i = i2;
        }
        SelectContactUI.e(this.ulL).dismiss();
        Intent intent = new Intent();
        intent.putStringArrayListExtra("Select_Contact", this.ulP);
        this.ulL.setResult(-1, intent);
        h.mEJ.h(11048, new Object[]{Integer.valueOf(1), Integer.valueOf(this.ulP.size() - i), Integer.valueOf(i)});
        this.ulL.finish();
    }
}
