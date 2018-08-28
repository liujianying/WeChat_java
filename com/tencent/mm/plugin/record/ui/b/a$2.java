package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;

class a$2 implements OnLongClickListener {
    private Context context;
    private g iWQ;
    final /* synthetic */ a mtv;
    private b mtw;
    private vx mtx;
    private String path;

    a$2(a aVar) {
        this.mtv = aVar;
    }

    public final boolean onLongClick(View view) {
        if (view != null) {
            this.context = view.getContext();
            this.mtw = (b) view.getTag();
            this.iWQ = this.mtw.msw;
            this.mtx = this.mtw.bOz;
        }
        fz fzVar = new fz();
        fzVar.bOL.type = 2;
        fzVar.bOL.bON = this.mtw.bOz;
        a.sFg.m(fzVar);
        this.path = fzVar.bOM.path;
        if (e.cn(this.path)) {
            if (this.mtv.fUH == null) {
                this.mtv.fUH = new k(this.context);
            }
            this.mtv.fUH.ofp = new 1(this);
            this.mtv.fUH.ofq = new 2(this);
            this.mtv.fUH.bEo();
        } else {
            x.w("MicroMsg.ImageViewWrapper", "file not exists");
        }
        return true;
    }
}
