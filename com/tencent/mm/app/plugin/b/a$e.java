package com.tencent.mm.app.plugin.b;

import com.tencent.mm.e.b.h;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class a$e extends c<fd> {
    h bAX;
    String fileName;

    public a$e() {
        this.fileName = "";
        this.sFo = fd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fd fdVar = (fd) bVar;
        if (fdVar.bNn.op == 1) {
            if (this.bAX == null) {
                this.bAX = new h(ad.getContext(), false);
            }
            fdVar.bNo.bJm = this.bAX.dd(fdVar.bNn.username);
            this.fileName = this.bAX.getFileName();
            x.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", new Object[]{Integer.valueOf(fdVar.bNn.op), Boolean.valueOf(fdVar.bNo.bJm)});
        } else if (fdVar.bNn.op == 2 && this.bAX != null) {
            fdVar.bNo.fileName = this.fileName;
            fdVar.bNo.bJm = this.bAX.wk();
            x.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", new Object[]{Integer.valueOf(fdVar.bNn.op), this.fileName, Boolean.valueOf(fdVar.bNo.bJm)});
            this.fileName = "";
        }
        return true;
    }
}
