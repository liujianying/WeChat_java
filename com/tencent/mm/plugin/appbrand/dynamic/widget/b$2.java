package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b.a;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

class b$2 implements OnClickListener {
    final /* synthetic */ LinkedList fyu;
    final /* synthetic */ a fyv;
    final /* synthetic */ i fyw;
    final /* synthetic */ b fyx;

    b$2(b bVar, LinkedList linkedList, a aVar, i iVar) {
        this.fyx = bVar;
        this.fyu = linkedList;
        this.fyv = aVar;
        this.fyw = iVar;
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
                x.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                this.fyv.f(2, bundle);
                this.fyw.dismiss();
                return;
            }
        }
    }
}
