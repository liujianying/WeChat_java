package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.c.hu;
import com.tencent.mm.protocal.c.hv;
import java.util.LinkedList;

class c$5 implements OnClickListener {
    final /* synthetic */ c tOm;
    final /* synthetic */ LinkedList tOn;

    c$5(c cVar, LinkedList linkedList) {
        this.tOm = cVar;
        this.tOn = linkedList;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        hv hvVar = new hv();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.tOn.size()) {
                hu huVar = new hu();
                huVar.riL = (String) this.tOn.get(i3);
                hvVar.riM.add(huVar);
                i2 = i3 + 1;
            } else {
                c.a(this.tOm, hvVar);
                return;
            }
        }
    }
}
