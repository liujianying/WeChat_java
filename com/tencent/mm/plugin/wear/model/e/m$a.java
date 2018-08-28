package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.e.b.g.a;
import com.tencent.mm.e.c.c;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.cez;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class m$a extends d {
    private cez pJV;

    public m$a(cez cez) {
        this.pJV = cez;
    }

    protected final void execute() {
        String om = q.om(this.pJV.szk);
        x.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", new Object[]{om});
        x.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", new Object[]{q.O(om, false)});
        InputStream byteArrayInputStream = new ByteArrayInputStream(this.pJV.rdU.toByteArray());
        c cVar = new c(8000, 16000);
        cVar.df(r0);
        byte[] bArr = new byte[320];
        int i = 0;
        while (true) {
            try {
                i = byteArrayInputStream.read(bArr, 0, 320);
            } catch (IOException e) {
            }
            if (i > 0) {
                cVar.a(new a(bArr, i), 0, false);
            } else {
                cVar.wA();
                x.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
                q.X(om, (int) this.pJV.szF);
                m.TK().run();
                x.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
                au.HU();
                com.tencent.mm.model.c.FW().Ys(this.pJV.szk);
                return;
            }
        }
    }

    public final String getName() {
        return "SendVioceMsgTask";
    }
}
