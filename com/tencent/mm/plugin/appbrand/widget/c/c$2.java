package com.tencent.mm.plugin.appbrand.widget.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

class c$2 implements OnClickListener {
    final /* synthetic */ LinkedList fyu;
    final /* synthetic */ c$a gFQ;
    final /* synthetic */ b gFR;
    final /* synthetic */ c gFS;

    c$2(c cVar, LinkedList linkedList, c$a c_a, b bVar) {
        this.gFS = cVar;
        this.fyu = linkedList;
        this.gFQ = c_a;
        this.gFR = bVar;
    }

    public final void onClick(View view) {
        Serializable arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fyu.size()) {
                if (((bio) this.fyu.get(i2)).sjd == 2 || ((bio) this.fyu.get(i2)).sjd == 3) {
                    arrayList.add(((bio) this.fyu.get(i2)).rjR);
                }
                i = i2 + 1;
            } else {
                x.i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                this.gFQ.f(2, bundle);
                this.gFR.dismiss();
                return;
            }
        }
    }
}
