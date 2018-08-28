package com.tencent.mm.view.e;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.view.c.a;

class a$8 implements OnItemClickListener {
    final /* synthetic */ a uWa;

    a$8(a aVar) {
        this.uWa = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmojiGroupInfo GS = a.i(this.uWa).getItem(i);
        if (GS == null) {
            x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "info is null. ignore click action.");
        } else if (GS.field_productID.equalsIgnoreCase("TAG_STORE_MANEGER_TAB")) {
            a.j(this.uWa);
        } else {
            boolean z;
            a.a(this.uWa, a.d(this.uWa).GY(a.e(this.uWa)), false, true);
            a abS = a.d(this.uWa).abS(GS.field_productID);
            a.a(this.uWa, abS.gKG);
            int cCn = abS.uVA > abS.cCn() + -1 ? abS.cCn() - 1 : abS.uVA;
            if (a.c(this.uWa) != null) {
                a.c(this.uWa).k(a.e(this.uWa) + cCn, false);
            }
            if (a.d(this.uWa).cCL() && abS.iiv.equals("TAG_DEFAULT_TAB")) {
                z = true;
            } else {
                z = false;
            }
            a.a(this.uWa, abS.cCn(), cCn, z);
            a.d(this.uWa).uWt = cCn;
            a.d(this.uWa).setShowProductId(GS.field_productID);
            if (GS.equals(String.valueOf(EmojiGroupInfo.tcz))) {
                h.mEJ.h(11594, new Object[]{Integer.valueOf(0)});
            }
        }
    }
}
