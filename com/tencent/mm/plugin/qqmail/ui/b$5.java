package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class b$5 extends a {
    final /* synthetic */ String dat;
    final /* synthetic */ b mgt;

    b$5(b bVar, String str) {
        this.mgt = bVar;
        this.dat = str;
    }

    public final boolean onReady() {
        y yVar = (y) this.mgt.mgm.get(this.dat);
        if (yVar != null) {
            yVar.state = 1;
            this.mgt.b(yVar);
        }
        return true;
    }

    public final void onSuccess(String str, Map<String, String> map) {
        String str2 = (String) map.get(".Response.result.DataID");
        y yVar = (y) this.mgt.mgm.get(this.dat);
        if (yVar != null) {
            yVar.state = 2;
            yVar.meb = str2;
            this.mgt.b(yVar);
        }
    }

    public final void onError(int i, String str) {
        x.e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", Integer.valueOf(i), str);
        y yVar = (y) this.mgt.mgm.get(this.dat);
        if (yVar != null) {
            yVar.state = 3;
            this.mgt.b(yVar);
        }
        if (i == -5) {
            this.mgt.mgk.meR.a(new 1(this));
        }
    }

    public final void onComplete() {
        b.a(this.mgt);
    }
}
