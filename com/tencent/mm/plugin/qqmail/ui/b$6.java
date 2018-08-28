package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class b$6 implements f {
    final /* synthetic */ String dat;
    final /* synthetic */ String ges;
    final /* synthetic */ b mgt;

    b$6(b bVar, String str, String str2) {
        this.mgt = bVar;
        this.dat = str;
        this.ges = str2;
    }

    public final void a(int i, int i2, l lVar) {
        x.i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", Integer.valueOf(i), Integer.valueOf(i2));
        y yVar;
        if (i < i2) {
            x.i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", this.dat, Integer.valueOf(i), Integer.valueOf(i2));
            yVar = (y) this.mgt.mgm.get(this.dat);
            if (yVar != null) {
                yVar.state = 1;
                ah.A(new 1(this, yVar));
            }
        } else if (i >= i2) {
            yVar = (y) this.mgt.mgm.get(this.dat);
            String str = ((o) lVar).boq().ruD;
            this.mgt.mgo.put(this.dat, str);
            this.mgt.mgp.put(this.dat, this.ges);
            this.mgt.mgn.remove(this.dat);
            x.i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", this.dat, str);
            if (yVar != null) {
                yVar.state = 2;
                yVar.meb = str;
                ah.A(new 2(this, yVar));
            }
            b.a(this.mgt);
        }
    }
}
