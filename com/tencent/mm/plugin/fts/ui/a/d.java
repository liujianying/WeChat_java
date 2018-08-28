package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a$b;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;

public final class d extends m {
    public u jwq;
    public CharSequence jxL;
    private a jxM = new a(this);

    public d(int i) {
        super(i);
    }

    public final a$b BV() {
        return this.jxM;
    }

    public final void a(Context context, a aVar, Object... objArr) {
        CharSequence Bc;
        super.a(context, aVar, objArr);
        ab Yg = ((i) g.l(i.class)).FR().Yg(this.fyJ.talker);
        if (Yg == null) {
            Bc = com.tencent.mm.plugin.fts.a.d.Bc(this.fyJ.jrv);
        } else if (!bi.oW(Yg.field_conRemark)) {
            Bc = Yg.field_conRemark;
        } else if (this.jwq != null) {
            Bc = this.jwq.gT(this.fyJ.talker);
            if (bi.oW(Bc)) {
                Bc = Yg.field_nickname;
            }
        } else {
            Bc = Yg.field_nickname;
        }
        if (!bi.oW(Bc)) {
            this.jxL = j.b(context, Bc, (float) c.jvy);
        }
    }
}
