package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.2;
import java.util.ArrayList;
import java.util.List;

class ShakeTvHistoryListUI$2$1 implements OnClickListener {
    final /* synthetic */ 2 nbv;

    ShakeTvHistoryListUI$2$1(2 2) {
        this.nbv = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h hVar = h.mEJ;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(2);
        o buE = m.buE();
        List<n> arrayList = new ArrayList();
        Cursor bvi = buE.bvi();
        if (bvi != null) {
            while (bvi.moveToNext()) {
                n nVar = new n();
                nVar.d(bvi);
                arrayList.add(nVar);
            }
            bvi.close();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (n nVar2 : arrayList) {
            stringBuilder.append(nVar2.field_username);
            stringBuilder.append("|");
        }
        objArr[1] = stringBuilder.toString();
        hVar.h(12662, objArr);
        m.buE().diF.delete("shaketvhistory", null, null);
        au.DF().a(new c(2, null), 0);
        ShakeTvHistoryListUI.a(this.nbv.nbu).WT();
        this.nbv.nbu.enableOptionMenu(false);
    }
}
