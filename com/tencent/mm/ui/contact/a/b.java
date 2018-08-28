package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ab;

public final class b extends e {
    public String bgn;
    public int jxE = 0;
    private boolean umr;

    public b(int i) {
        super(i);
    }

    public final void ck(Context context) {
        if (this.jxE == 0 || this.bgn == null) {
            ab abVar = this.guS;
            if (!this.umr) {
                g.Ek();
                abVar = ((i) g.l(i.class)).FR().Yg(this.username);
                this.guS = abVar;
                this.umr = true;
            }
            ab abVar2 = abVar;
            if (abVar2 == null) {
                this.eCh = "";
                return;
            }
            this.eCh = j.a(context, ((com.tencent.mm.plugin.messenger.a.b) g.l(com.tencent.mm.plugin.messenger.a.b.class)).c(abVar2), a.ad(context, c.NormalTextSize));
            this.username = abVar2.field_username;
            return;
        }
        this.umD = this.jxE;
        this.umC = this.bgn;
    }
}
