package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a$b;
import java.util.regex.Pattern;

public final class c extends a {
    private static final Pattern eCg = Pattern.compile(",");
    public CharSequence eCh;
    public CharSequence eCi;
    private b eCj = new b(this);
    a eCk = new a(this);
    public String username;

    public c(int i) {
        super(2, i);
    }

    public final void ck(Context context) {
        if (this.guS == null) {
            x.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[]{Integer.valueOf(this.position)});
            return;
        }
        CharSequence c;
        this.username = this.guS.field_username;
        if (bi.oW(this.bIY)) {
            c = ((b) g.l(b.class)).c(this.guS);
        } else {
            c = ((b) g.l(b.class)).getDisplayName(this.guS.field_username, this.bIY);
        }
        if (q.GF().equals(this.username)) {
            c = c + context.getString(i.aa_myself_note);
        }
        this.eCh = j.a(context, c, com.tencent.mm.bp.a.ad(context, d.NormalTextSize));
    }

    public final a$b Wg() {
        return this.eCj;
    }

    protected final a.a Wh() {
        return this.eCk;
    }
}
