package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class a$3 implements OnClickListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ a qIg;

    a$3(a aVar, l lVar) {
        this.qIg = aVar;
        this.bFp = lVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AddContact", "dealwith verify relation out of date");
        m mVar = (m) this.bFp;
        LinkedList linkedList = (mVar.diG == null || mVar.diG.KV() == null) ? null : ((byd) mVar.diG.dID.dIL).sum;
        List list = ((m) this.bFp).qyZ;
        if (list != null && list.size() > 0) {
            this.qIg.c((String) list.get(0), linkedList);
        }
    }
}
