package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.m.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r extends q {
    private String bWm;
    private ag handler = new ag(Looper.getMainLooper());
    private a ujV;
    private Map<String, String> ukC = new HashMap();
    private List<String> ukD = new ArrayList();
    private List<String> uko;

    public r(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, String str) {
        super(mMBaseSelectContactUI, list, z, 0);
        this.uko = list;
        if (!bi.oW(str)) {
            this.ukD = bi.F(str.split(","));
            if (this.ukD != null) {
                for (String str2 : this.ukD) {
                    String gT = ((b) g.l(b.class)).gT(str2);
                    if (!bi.oW(gT)) {
                        this.ukC.put(gT, str2);
                    }
                }
            }
        }
        Wj();
    }

    public final void a(a aVar) {
        this.ujV = aVar;
    }

    public final void bA(String str, boolean z) {
        if (this.ujV != null) {
            this.ujV.q(str, getCount(), z);
        }
    }

    private void Wj() {
        this.bWm = null;
        clearCache();
    }

    public final int getCount() {
        return this.ukD == null ? 0 : this.ukD.size();
    }

    protected final com.tencent.mm.ui.contact.a.a iW(int i) {
        d dVar = new d(i);
        dVar.bWm = this.bWm;
        g.Ek();
        dVar.guS = ((i) g.l(i.class)).FR().Ye((String) this.ukD.get(i));
        dVar.ujX = bwq();
        return dVar;
    }

    public final void finish() {
        super.finish();
        Wj();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        return true;
    }
}
