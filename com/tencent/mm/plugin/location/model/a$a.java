package com.tencent.mm.plugin.location.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Set;

public class a$a {
    Set<Long> kCD;
    private a kCE = new a() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(com.tencent.mm.modelgeo.Addr r11) {
            /*
            r10 = this;
            r1 = 0;
            r7 = -1;
            r3 = com.tencent.mm.plugin.location.model.a$a.this;
            r0 = r11.tag;
            if (r0 == 0) goto L_0x01a2;
        L_0x0008:
            r0 = r11.tag;
            r0 = r0 instanceof java.lang.Long;
            if (r0 == 0) goto L_0x01a2;
        L_0x000e:
            r0 = r11.tag;
            r0 = (java.lang.Long) r0;
            r4 = r0.longValue();
            r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
            r0 = com.tencent.mm.kernel.g.l(r0);
            r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
            r0 = r0.bcY();
            r4 = r0.dW(r4);
            r0 = r11.dRH;
            r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
            if (r0 != 0) goto L_0x01a2;
        L_0x002e:
            r2 = r4.field_content;
            r0 = r4.field_isSend;
            if (r0 != 0) goto L_0x01a3;
        L_0x0034:
            r0 = 1;
        L_0x0035:
            r5 = r4.field_talker;
            r5 = com.tencent.mm.model.s.fq(r5);
            if (r5 == 0) goto L_0x004f;
        L_0x003d:
            if (r0 == 0) goto L_0x004f;
        L_0x003f:
            r6 = com.tencent.mm.model.bd.iA(r2);
            if (r6 == r7) goto L_0x004f;
        L_0x0045:
            r6 = r6 + 1;
            r2 = r2.substring(r6);
            r2 = r2.trim();
        L_0x004f:
            r6 = com.tencent.mm.storage.bd.b.YW(r2);
            r2 = r11.Oy();
            r6.label = r2;
            r2 = "";
            if (r5 == 0) goto L_0x01a8;
        L_0x005e:
            if (r0 == 0) goto L_0x01a8;
        L_0x0060:
            r0 = r4.field_content;
            r0 = com.tencent.mm.model.bd.iA(r0);
            if (r0 == r7) goto L_0x01a8;
        L_0x0068:
            r7 = r4.field_content;
            r0 = r7.substring(r1, r0);
            r0 = r0.trim();
            r1 = r0.length();
            if (r1 <= 0) goto L_0x01a8;
        L_0x0078:
            r1 = r6.tbP;
            if (r1 == 0) goto L_0x0087;
        L_0x007c:
            r1 = r6.tbP;
            r2 = "";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x008c;
        L_0x0087:
            r1 = "";
            r6.tbP = r1;
        L_0x008c:
            r1 = r6.tbO;
            if (r1 == 0) goto L_0x009b;
        L_0x0090:
            r1 = r6.tbO;
            r2 = "";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x00a0;
        L_0x009b:
            r1 = "";
            r6.tbP = r1;
        L_0x00a0:
            r1 = r6.tbN;
            if (r1 == 0) goto L_0x00af;
        L_0x00a4:
            r1 = r6.tbN;
            r2 = "";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x00b4;
        L_0x00af:
            r1 = "";
            r6.tbN = r1;
        L_0x00b4:
            r1 = r6.otZ;
            if (r1 == 0) goto L_0x00c3;
        L_0x00b8:
            r1 = r6.otZ;
            r2 = "";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x00c8;
        L_0x00c3:
            r1 = "";
            r6.otZ = r1;
        L_0x00c8:
            r1 = r6.label;
            if (r1 == 0) goto L_0x00d7;
        L_0x00cc:
            r1 = r6.label;
            r2 = "";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x00dc;
        L_0x00d7:
            r1 = "";
            r6.label = r1;
        L_0x00dc:
            r1 = r6.tbM;
            if (r1 == 0) goto L_0x00eb;
        L_0x00e0:
            r1 = r6.tbM;
            r2 = "";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x00f0;
        L_0x00eb:
            r1 = "";
            r6.tbM = r1;
        L_0x00f0:
            r1 = new java.lang.StringBuilder;
            r2 = "<msg><location x=\"";
            r1.<init>(r2);
            r8 = r6.kCw;
            r1 = r1.append(r8);
            r2 = "\" y=\"";
            r1 = r1.append(r2);
            r8 = r6.kCx;
            r1 = r1.append(r8);
            r2 = "\" scale=\"";
            r1 = r1.append(r2);
            r2 = r6.bSz;
            r1 = r1.append(r2);
            r2 = "\" label=\"";
            r1 = r1.append(r2);
            r2 = r6.label;
            r1 = r1.append(r2);
            r2 = "\" maptype=\"";
            r1 = r1.append(r2);
            r2 = r6.tbM;
            r1 = r1.append(r2);
            r2 = "\"  fromusername=\"";
            r1 = r1.append(r2);
            r2 = r6.otZ;
            r1 = r1.append(r2);
            r2 = "\" /></msg>";
            r1 = r1.append(r2);
            r1 = r1.toString();
            if (r5 == 0) goto L_0x01a6;
        L_0x014c:
            r2 = "";
            r2 = r0.equals(r2);
            if (r2 != 0) goto L_0x01a6;
        L_0x0155:
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r0 = r2.append(r0);
            r2 = ":\n";
            r0 = r0.append(r2);
            r0 = r0.append(r1);
            r0 = r0.toString();
        L_0x016d:
            r1 = "MicroMsg.LocationServer";
            r2 = new java.lang.StringBuilder;
            r5 = "xml: ";
            r2.<init>(r5);
            r2 = r2.append(r0);
            r2 = r2.toString();
            com.tencent.mm.sdk.platformtools.x.d(r1, r2);
            r4.setContent(r0);
            r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
            r0 = com.tencent.mm.kernel.g.l(r0);
            r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
            r0 = r0.bcY();
            r6 = r4.field_msgId;
            r0.a(r6, r4);
            r0 = r3.kCD;
            r2 = r4.field_msgId;
            r1 = java.lang.Long.valueOf(r2);
            r0.remove(r1);
        L_0x01a2:
            return;
        L_0x01a3:
            r0 = r1;
            goto L_0x0035;
        L_0x01a6:
            r0 = r1;
            goto L_0x016d;
        L_0x01a8:
            r0 = r2;
            goto L_0x0078;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.location.model.a.a.1.b(com.tencent.mm.modelgeo.Addr):void");
        }
    };

    public final void aZa() {
        if (this.kCD != null) {
            this.kCD.clear();
        }
        b.Oz().a(this.kCE);
    }

    public final String[] Q(bd bdVar) {
        int i = 1;
        String[] strArr = new String[2];
        String str = bdVar.field_content;
        if (bi.oW(str)) {
            strArr[0] = "";
            strArr[1] = "";
            return strArr;
        }
        String str2;
        int i2 = bdVar.field_isSend == 0 ? 1 : 0;
        if (s.fq(bdVar.field_talker) && i2 != 0) {
            i2 = com.tencent.mm.model.bd.iA(str);
            if (i2 != -1) {
                str = str.substring(i2 + 1).trim();
            }
        }
        bd.b GS = ((i) g.l(i.class)).bcY().GS(str);
        if (GS.cmK()) {
            str = GS.label;
            str2 = GS.kFa;
            strArr[0] = str;
            strArr[1] = str2;
        } else {
            strArr[0] = GS.label;
            strArr[1] = "";
        }
        if (bi.oW(strArr[0]) && bi.oW(strArr[1])) {
            x.i("MicroMsg.LocationServer", "pull from sever");
            long j = bdVar.field_msgId;
            if (!(this.kCD == null || this.kCD.contains(Long.valueOf(j)))) {
                str2 = bdVar.field_content;
                if (bdVar.field_isSend != 0) {
                    i = 0;
                }
                if (s.fq(bdVar.field_talker) && i != 0) {
                    i = com.tencent.mm.model.bd.iA(str2);
                    if (i != -1) {
                        str2 = str2.substring(i + 1).trim();
                    }
                }
                GS = bd.b.YW(str2);
                this.kCD.add(Long.valueOf(j));
                b.Oz().a(GS.kCw, GS.kCx, this.kCE, Long.valueOf(bdVar.field_msgId));
            }
        }
        return strArr;
    }
}
