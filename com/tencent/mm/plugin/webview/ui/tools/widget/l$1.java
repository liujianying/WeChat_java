package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

class l$1 implements OnClickListener {
    final /* synthetic */ LinkedList fyu;
    final /* synthetic */ i fyw;
    final /* synthetic */ l$a qln;
    final /* synthetic */ l qlo;

    l$1(l lVar, LinkedList linkedList, l$a l_a, i iVar) {
        this.qlo = lVar;
        this.fyu = linkedList;
        this.qln = l_a;
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
                x.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                this.qln.f(1, bundle);
                this.fyw.dismiss();
                return;
            }
        }
    }
}
