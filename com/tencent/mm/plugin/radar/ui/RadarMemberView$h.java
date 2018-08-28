package com.tencent.mm.plugin.radar.ui;

import android.view.View.OnClickListener;

final class RadarMemberView$h implements OnClickListener {
    final /* synthetic */ RadarMemberView mlg;

    RadarMemberView$h(RadarMemberView radarMemberView) {
        this.mlg = radarMemberView;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r7) {
        /*
        r6 = this;
        r3 = 0;
        r4 = 1;
        r2 = 0;
        r1 = "";
        r0 = r6.mlg;
        r0 = com.tencent.mm.plugin.radar.ui.RadarMemberView.c(r0);
        if (r0 == 0) goto L_0x0029;
    L_0x000e:
        r0 = r6.mlg;
        r0 = com.tencent.mm.plugin.radar.ui.RadarMemberView.c(r0);
        if (r0 == 0) goto L_0x0057;
    L_0x0016:
        r0 = r0.Bx();
        if (r0 != r4) goto L_0x0057;
    L_0x001c:
        r0 = r6.mlg;
        r0 = com.tencent.mm.plugin.radar.ui.RadarMemberView.c(r0);
        if (r0 == 0) goto L_0x0055;
    L_0x0024:
        r0 = r0.wN();
    L_0x0028:
        r1 = r0;
    L_0x0029:
        r0 = r1;
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x0034;
    L_0x002e:
        r0 = b.f.a.U(r0);
        if (r0 == 0) goto L_0x00d9;
    L_0x0034:
        r0 = r4;
    L_0x0035:
        if (r0 == 0) goto L_0x004a;
    L_0x0037:
        r0 = r6.mlg;
        r0 = r0.getMember();
        if (r0 == 0) goto L_0x004a;
    L_0x003f:
        r0 = r6.mlg;
        r0 = r0.getMember();
        if (r0 == 0) goto L_0x0049;
    L_0x0047:
        r2 = r0.hcS;
    L_0x0049:
        r1 = r2;
    L_0x004a:
        r0 = r6.mlg;
        if (r1 != 0) goto L_0x0051;
    L_0x004e:
        r1 = "";
    L_0x0051:
        com.tencent.mm.plugin.radar.ui.RadarMemberView.a(r0, r1);
        return;
    L_0x0055:
        r0 = r2;
        goto L_0x0028;
    L_0x0057:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r5 = "service(IMessengerStorage::class.java)";
        b.c.b.e.h(r0, r5);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r5 = r0.FS();
        r0 = r6.mlg;
        r0 = com.tencent.mm.plugin.radar.ui.RadarMemberView.c(r0);
        if (r0 == 0) goto L_0x00cf;
    L_0x0071:
        r0 = r0.getUsername();
    L_0x0075:
        r5 = r5.Hh(r0);
        if (r5 == 0) goto L_0x008c;
    L_0x007b:
        r0 = r5.wR();
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x0089;
    L_0x0083:
        r0 = b.f.a.U(r0);
        if (r0 == 0) goto L_0x00d1;
    L_0x0089:
        r0 = r4;
    L_0x008a:
        if (r0 == 0) goto L_0x00dc;
    L_0x008c:
        r0 = r6.mlg;
        r0 = com.tencent.mm.plugin.radar.ui.RadarMemberView.c(r0);
        if (r0 == 0) goto L_0x00d3;
    L_0x0094:
        r0 = r0.wR();
    L_0x0098:
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x00a2;
    L_0x009c:
        r0 = b.f.a.U(r0);
        if (r0 == 0) goto L_0x00d5;
    L_0x00a2:
        r0 = r4;
    L_0x00a3:
        if (r0 != 0) goto L_0x00dc;
    L_0x00a5:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r5 = "service(IMessengerStorage::class.java)";
        b.c.b.e.h(r0, r5);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r5 = r0.FS();
        r0 = r6.mlg;
        r0 = com.tencent.mm.plugin.radar.ui.RadarMemberView.c(r0);
        if (r0 == 0) goto L_0x00d7;
    L_0x00bf:
        r0 = r0.wR();
    L_0x00c3:
        r0 = r5.Hh(r0);
    L_0x00c7:
        if (r0 == 0) goto L_0x0029;
    L_0x00c9:
        r1 = r0.wN();
        goto L_0x0029;
    L_0x00cf:
        r0 = r2;
        goto L_0x0075;
    L_0x00d1:
        r0 = r3;
        goto L_0x008a;
    L_0x00d3:
        r0 = r2;
        goto L_0x0098;
    L_0x00d5:
        r0 = r3;
        goto L_0x00a3;
    L_0x00d7:
        r0 = r2;
        goto L_0x00c3;
    L_0x00d9:
        r0 = r3;
        goto L_0x0035;
    L_0x00dc:
        r0 = r5;
        goto L_0x00c7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarMemberView$h.onClick(android.view.View):void");
    }
}
