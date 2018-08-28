package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.plugin.qqmail.ui.b.3;

class b$3$1 implements OnClickListener {
    final /* synthetic */ 3 mgw;

    b$3$1(3 3) {
        this.mgw = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.mgw.mgu.state == 0 || this.mgw.mgu.state == 1) {
            b bVar = this.mgw.mgt;
            y yVar = this.mgw.mgu;
            if (bVar.mode == 5) {
                w.bow().cancel(yVar.mea);
            } else if (bVar.mode == 6) {
                o oVar = (o) bVar.mgn.get(yVar.path);
                if (oVar != null) {
                    au.DF().c(oVar);
                }
                bVar.mgo.remove(yVar.path);
                bVar.mgp.remove(yVar.path);
            }
        }
        this.mgw.mgt.mgm.remove(this.mgw.mgu.path);
        this.mgw.mgt.mgn.remove(this.mgw.mgu.path);
        this.mgw.mgt.mgo.remove(this.mgw.mgu.path);
        this.mgw.mgt.mgp.remove(this.mgw.mgu.path);
        this.mgw.mgt.mgl.removeView(this.mgw.mgv);
        this.mgw.mgt.boV();
    }
}
