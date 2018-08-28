package com.tencent.mm.plugin.secinforeport;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.c.a.d.1;
import com.tencent.c.e.a.e;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.normsg.Normsg.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.bgo;
import com.tencent.mm.protocal.c.bgp;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.charset.Charset;

enum c implements com.tencent.mm.plugin.secinforeport.a.c {
    ;

    private c(String str) {
    }

    public final boolean H(int i, long j) {
        return a.H(i, j);
    }

    public final void a(int i, boolean z, boolean z2, boolean z3) {
        byte[] h = b.h(z, z2, z3);
        if (h != null) {
            n(i, h);
        }
    }

    public final void vJ(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<st><Manufacturer>").append(Build.MANUFACTURER).append("</Manufacturer><Model>").append(Build.MODEL).append("</Model><VersionRelease>").append(VERSION.RELEASE).append("</VersionRelease><VersionIncremental>").append(VERSION.INCREMENTAL).append("</VersionIncremental><Display>").append(Build.DISPLAY).append("</Display></st>");
        n(i, stringBuilder.toString().getBytes(Charset.forName("UTF-8")));
    }

    public final void bto() {
        e.cFl().wk();
        Context context = ad.getContext();
        e.cFl().a(context, q.zy(), new 1(new 1(this), new com.tencent.c.b.c(context)));
    }

    private void n(int i, byte[] bArr) {
        a aVar = new a();
        aVar.uri = com.tencent.mm.plugin.normsg.a.b.lFJ.IO("Q\u001e\u001b\u0012W\u001b\u0011\u0019Y\u0018\u001d\u0010\u0000\u001e\u001d\u001c\t@\u000e\u0002\u0004F\u001a\u0002\u0016\n\u0016\u0017\u0001\r\t:0)?3?:3");
        aVar.dIF = 771;
        aVar.dIG = new bgo();
        aVar.dIH = new bgp();
        com.tencent.mm.ab.b KT = aVar.KT();
        bgo bgo = (bgo) KT.dID.dIL;
        bgo.shz = i;
        bgo.shy = new com.tencent.mm.bk.b(bArr);
        f.mDy.a(416, 0, 1, false);
        v.a(KT, new 2(this, i), false);
    }
}
