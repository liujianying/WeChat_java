package com.tencent.mm.ui.bizchat;

import android.content.Context;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.contact.a.a$b;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.ui.contact.a.a {
    private static Map<String, c> tEc = new HashMap();
    public CharSequence eCh;
    public long hpD = -1;
    public String tEb;
    private b tEd = new b(this);
    a tEe = new a(this);
    public String username;

    static /* synthetic */ c aae(String str) {
        if (str == null) {
            return null;
        }
        if (tEc.containsKey(str) && tEc.get(str) != null) {
            return (c) tEc.get(str);
        }
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        aVar.dXB = com.tencent.mm.api.a.cy(str);
        aVar.dXy = true;
        aVar.dXV = true;
        aVar.dXN = g.default_avatar;
        c Pt = aVar.Pt();
        tEc.put(str, Pt);
        return Pt;
    }

    public a(int i) {
        super(4, i);
    }

    public final void ck(Context context) {
        this.eCh = j.a(context, this.eCh, com.tencent.mm.bp.a.ad(context, com.tencent.mm.plugin.selectcontact.a.c.NormalTextSize));
    }

    public final a$b Wg() {
        return this.tEd;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Wh() {
        return this.tEe;
    }
}
