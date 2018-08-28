package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.k.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;

public final class i {
    private Context context;
    private View eLM;
    f eOE;
    private View hsd;
    public OnClickListener mtE;
    a opw;
    String qII;
    private HashMap<String, Preference> qIJ = new HashMap();
    boolean qIK = false;
    boolean qIL;
    public j qIM;
    b qIN;
    private OnClickListener qIO;
    private OnClickListener qIP;
    private OnClickListener qIQ;
    private b qIR;
    private k.a qIS;
    private j.a qIT;
    String username;

    public i(Context context) {
        boolean z = false;
        if (this.qIK) {
            z = true;
        }
        this.qIL = z;
        this.qIN = null;
        this.mtE = null;
        this.opw = null;
        this.qIQ = new 1(this);
        this.qIR = new 2(this);
        this.qIS = new 3(this);
        this.qIT = new 4(this);
        this.context = context;
        this.qIM = new j(this.context);
        this.qIM.qIX = this.qIT;
    }

    final void FX(String str) {
        j jVar = this.qIM;
        jVar.username = str;
        jVar.bSD = s.fq(str);
        if (!(jVar.bSD || p.a.qJH == null)) {
            jVar.qIZ = p.a.qJH.TE(str);
        }
        if (!jVar.qIZ) {
            jVar.hLB = ((com.tencent.mm.plugin.chatroom.b.b) g.l(com.tencent.mm.plugin.chatroom.b.b.class)).Ga().ih(str);
        }
        if (jVar.qIZ && p.a.qJH != null) {
            jVar.hOC = p.a.qJH.TG(jVar.username);
        }
        this.qIM.qJm = this.qIL;
        this.qIM.notifyChanged();
        bpx();
    }

    private static String BY(int i) {
        if (i >= 0) {
            return "pref_contact_list_row_" + i;
        }
        String str = "unkown";
        if (i == -1) {
            str = "header";
        } else if (i == -2) {
            str = "footer";
        }
        return "pref_contact_list_row_" + str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bpx() {
        /*
        r15 = this;
        r0 = r15.eOE;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r15.qII;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r15.qIJ;
        r0 = r0.keySet();
        r1 = r0.iterator();
    L_0x0013:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0025;
    L_0x0019:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r2 = r15.eOE;
        r2.aaa(r0);
        goto L_0x0013;
    L_0x0025:
        r0 = r15.qIJ;
        r0.clear();
        r0 = r15.eOE;
        r1 = r15.qII;
        r1 = r0.indexOf(r1);
        r0 = 0;
        r2 = 0;
        r3 = r15.eLM;
        if (r3 == 0) goto L_0x0039;
    L_0x0038:
        r0 = 1;
    L_0x0039:
        r3 = r15.hsd;
        if (r3 == 0) goto L_0x01d3;
    L_0x003d:
        r3 = r15.qIK;
        if (r3 == 0) goto L_0x004c;
    L_0x0041:
        r3 = r15.qIM;
        r4 = r3.qJf;
        r3 = r3.qJn;
        if (r4 <= r3) goto L_0x0110;
    L_0x0049:
        r3 = 1;
    L_0x004a:
        if (r3 == 0) goto L_0x01d3;
    L_0x004c:
        r2 = 1;
        r7 = r2;
    L_0x004e:
        if (r0 == 0) goto L_0x007b;
    L_0x0050:
        r0 = new com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference;
        r2 = r15.context;
        r0.<init>(r2);
        r2 = -1;
        r2 = BY(r2);
        r0.setKey(r2);
        r2 = r15.eLM;
        r0.setCustomView(r2);
        r2 = com.tencent.mm.plugin.comm.a.d.comm_list_item_selector;
        r0.background = r2;
        r2 = r15.qIO;
        r0.mtE = r2;
        r2 = r15.eOE;
        r2.a(r0, r1);
        r2 = r15.qIJ;
        r3 = r0.mKey;
        r2.put(r3, r0);
        r0 = r1 + 1;
        r1 = r0;
    L_0x007b:
        r0 = r15.qIN;
        if (r0 == 0) goto L_0x0113;
    L_0x007f:
        r0 = r15.qIN;
        r2 = r0;
    L_0x0082:
        r0 = r15.mtE;
        if (r0 == 0) goto L_0x0118;
    L_0x0086:
        r0 = r15.mtE;
        r3 = r0;
    L_0x0089:
        r0 = r15.qIM;
        r0 = r0.qJo;
        r4 = r15.qIM;
        r5 = r4.cdR();
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r4 != 0) goto L_0x00a5;
    L_0x0099:
        if (r0 == 0) goto L_0x011d;
    L_0x009b:
        r4 = com.tencent.mm.model.q.GF();
        r0 = r0.equals(r4);
        if (r0 != 0) goto L_0x011d;
    L_0x00a5:
        r0 = 0;
    L_0x00a6:
        r4 = r15.qIM;
        r4 = r4.qIZ;
        if (r4 == 0) goto L_0x01d0;
    L_0x00ac:
        r0 = r15.qIM;
        r0 = r0.qJa;
        r4 = r0;
    L_0x00b1:
        r0 = r15.qIM;
        r6 = r0.qJg;
        if (r5 == 0) goto L_0x00b9;
    L_0x00b7:
        if (r4 == 0) goto L_0x011f;
    L_0x00b9:
        r0 = 2;
    L_0x00ba:
        r8 = r6 + r0;
        r6 = 0;
        r5 = r15.qIM;
        r9 = r15.context;
        if (r9 != 0) goto L_0x0121;
    L_0x00c3:
        r0 = 0;
    L_0x00c4:
        r5 = 0;
    L_0x00c5:
        r9 = r15.qIM;
        r9 = r9.getCount();
        if (r5 >= r9) goto L_0x01a7;
    L_0x00cd:
        if (r5 >= r8) goto L_0x01a7;
    L_0x00cf:
        r9 = new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
        r10 = r15.context;
        r11 = 1;
        r9.<init>(r10, r11);
        r10 = BY(r6);
        r9.setKey(r10);
        r10 = r9.qJB;
        r11 = r15.qIM;
        r10.qIM = r11;
        r10.row = r6;
        r10.index = r5;
        r10 = r9.qJB;
        r10.qJC = r0;
        r10 = r9.qJB;
        r10.hLy = r4;
        r10 = r9.qJB;
        r10.mtE = r3;
        r10 = r9.qJB;
        r11 = r15.qIS;
        r10.qIS = r11;
        r10 = r9.qJB;
        r10.qJD = r2;
        r10 = r15.eOE;
        r11 = r1 + r6;
        r10.a(r9, r11);
        r10 = r15.qIJ;
        r11 = r9.mKey;
        r10.put(r11, r9);
        r5 = r5 + r0;
        r6 = r6 + 1;
        goto L_0x00c5;
    L_0x0110:
        r3 = 0;
        goto L_0x004a;
    L_0x0113:
        r0 = r15.qIR;
        r2 = r0;
        goto L_0x0082;
    L_0x0118:
        r0 = r15.qIQ;
        r3 = r0;
        goto L_0x0089;
    L_0x011d:
        r0 = 1;
        goto L_0x00a6;
    L_0x011f:
        r0 = 1;
        goto L_0x00ba;
    L_0x0121:
        r0 = "window";
        r0 = r9.getSystemService(r0);
        r0 = (android.view.WindowManager) r0;
        r0 = r0.getDefaultDisplay();
        r10 = r0.getWidth();
        r0 = r0.getHeight();
        r11 = (float) r10;
        r12 = r9.getResources();
        r13 = com.tencent.mm.plugin.comm.a.c.NormalAvatarWrapSize;
        r12 = r12.getDimension(r13);
        r13 = r9.getResources();
        r14 = com.tencent.mm.plugin.comm.a.c.MiddlePadding;
        r13 = r13.getDimension(r14);
        r14 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r13 = r13 * r14;
        r12 = r12 + r13;
        r11 = r11 / r12;
        r12 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1));
        if (r11 < 0) goto L_0x0198;
    L_0x0156:
        if (r0 <= r10) goto L_0x0198;
    L_0x0158:
        r0 = 1;
        r5.qJu = r0;
    L_0x015b:
        r0 = r9.getResources();
        r11 = com.tencent.mm.plugin.comm.a.c.MiddlePadding;
        r0 = r0.getDimension(r11);
        r11 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = r11 * r0;
        r0 = r5.qJu;
        if (r0 == 0) goto L_0x019c;
    L_0x016c:
        r0 = r9.getResources();
        r5 = com.tencent.mm.plugin.comm.a.c.NormalAvatarWrapSize;
        r0 = r0.getDimension(r5);
    L_0x0176:
        r0 = r0 + r11;
        r0 = (int) r0;
        r0 = r10 / r0;
        r5 = "MicroMsg.ContactsListArchAdapter";
        r9 = "[getWrapColNum] :%s";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = java.lang.Integer.valueOf(r0);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.x.i(r5, r9, r10);
        com.tencent.mm.pluginsdk.ui.applet.j.qIW = r0;
        r5 = 4;
        if (r0 != r5) goto L_0x00c4;
    L_0x0192:
        r5 = 43;
        com.tencent.mm.pluginsdk.ui.applet.j.qIV = r5;
        goto L_0x00c4;
    L_0x0198:
        r0 = 0;
        r5.qJu = r0;
        goto L_0x015b;
    L_0x019c:
        r0 = r9.getResources();
        r5 = com.tencent.mm.plugin.comm.a.c.NormalAvatarSize;
        r0 = r0.getDimension(r5);
        goto L_0x0176;
    L_0x01a7:
        if (r7 == 0) goto L_0x0008;
    L_0x01a9:
        r0 = new com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference;
        r2 = r15.context;
        r0.<init>(r2);
        r2 = -2;
        r2 = BY(r2);
        r0.setKey(r2);
        r2 = r15.hsd;
        r0.setCustomView(r2);
        r2 = r15.qIP;
        r0.mtE = r2;
        r2 = r15.eOE;
        r1 = r1 + r6;
        r2.a(r0, r1);
        r1 = r15.qIJ;
        r2 = r0.mKey;
        r1.put(r2, r0);
        goto L_0x0008;
    L_0x01d0:
        r4 = r0;
        goto L_0x00b1;
    L_0x01d3:
        r7 = r2;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.applet.i.bpx():void");
    }
}
