package com.tencent.mm.plugin.account.friend.ui;

import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.protocal.c.xp;
import java.util.LinkedList;

final class b extends BaseAdapter {
    private LinkedList<avz> dzs;
    private final LayoutInflater eMa;
    LinkedList<xp> eMb;
    boolean eMc;
    private boolean[] eMd;

    public b(LayoutInflater layoutInflater) {
        this.eMa = layoutInflater;
    }

    public final void jh(int i) {
        if (i >= 0 && i < this.eMd.length) {
            this.eMd[i] = !this.eMd[i];
            super.notifyDataSetChanged();
        }
    }

    public final void a(LinkedList<avz> linkedList, int i) {
        if (i >= 0) {
            this.dzs = new LinkedList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= linkedList.size()) {
                    break;
                }
                if (i == ((avz) linkedList.get(i3)).rxW) {
                    this.dzs.add(linkedList.get(i3));
                }
                i2 = i3 + 1;
            }
        } else {
            this.dzs = linkedList;
        }
        this.eMd = new boolean[this.dzs.size()];
    }

    public final String[] Ye() {
        int i = 0;
        int i2 = 0;
        for (boolean z : this.eMd) {
            if (z) {
                i2++;
            }
        }
        String[] strArr = new String[i2];
        int i3 = 0;
        while (true) {
            int i4 = i;
            if (i4 >= this.dzs.size()) {
                return strArr;
            }
            if (this.eMd[i4]) {
                i = i3 + 1;
                strArr[i3] = ((avz) this.dzs.get(i4)).hbL;
                i2 = i;
            } else {
                i2 = i3;
            }
            i = i4 + 1;
            i3 = i2;
        }
    }

    public final int getCount() {
        if (this.eMc) {
            if (this.eMb == null) {
                return 0;
            }
            return this.eMb.size();
        } else if (this.dzs != null) {
            return this.dzs.size();
        } else {
            return 0;
        }
    }

    public final Object getItem(int i) {
        if (this.eMc) {
            return this.eMb.get(i);
        }
        return this.dzs.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
        r8 = this;
        r7 = 1;
        r6 = 2;
        r5 = 0;
        r0 = r8.eMc;
        if (r0 == 0) goto L_0x0047;
    L_0x0007:
        r0 = r8.eMb;
        r0 = r0.get(r9);
        r0 = (com.tencent.mm.protocal.c.xp) r0;
        if (r10 == 0) goto L_0x001b;
    L_0x0011:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.plugin.account.friend.ui.b.a) r1;
        r1 = r1.type;
        if (r1 == r6) goto L_0x0040;
    L_0x001b:
        r1 = r8.eMa;
        r2 = com.tencent.mm.plugin.account.a.g.inviteqqfriendsgroup_item;
        r10 = r1.inflate(r2, r11, r5);
        r2 = new com.tencent.mm.plugin.account.friend.ui.b$a;
        r2.<init>();
        r2.type = r6;
        r1 = com.tencent.mm.plugin.account.a.f.qq_friend_group_name;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.eMe = r1;
        r10.setTag(r2);
        r1 = r2;
    L_0x0038:
        r1 = r1.eMe;
        r0 = r0.rDt;
        r1.setText(r0);
    L_0x003f:
        return r10;
    L_0x0040:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.plugin.account.friend.ui.b.a) r1;
        goto L_0x0038;
    L_0x0047:
        r0 = r8.dzs;
        r0 = r0.get(r9);
        r0 = (com.tencent.mm.protocal.c.avz) r0;
        if (r10 == 0) goto L_0x005b;
    L_0x0051:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.plugin.account.friend.ui.b.a) r1;
        r1 = r1.type;
        if (r1 == r7) goto L_0x00d9;
    L_0x005b:
        r1 = r8.eMa;
        r2 = com.tencent.mm.plugin.account.a.g.inviteqqfriends_item;
        r10 = r1.inflate(r2, r11, r5);
        r2 = new com.tencent.mm.plugin.account.friend.ui.b$a;
        r2.<init>();
        r2.type = r7;
        r1 = com.tencent.mm.plugin.account.a.f.inviteqqfriends_nickname_tv;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.eMf = r1;
        r1 = com.tencent.mm.plugin.account.a.f.inviteqqfriends_email_tv;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.eMg = r1;
        r1 = com.tencent.mm.plugin.account.a.f.inviteqqfriends_send_cb;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.CheckBox) r1;
        r2.eMi = r1;
        r1 = com.tencent.mm.plugin.account.a.f.invite_friends_open_already_state;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.eMh = r1;
        r10.setTag(r2);
    L_0x0095:
        r1 = com.tencent.mm.plugin.account.a.a.a.class;
        r1 = com.tencent.mm.kernel.g.n(r1);
        r1 = (com.tencent.mm.plugin.account.a.a.a) r1;
        r1 = r1.getInviteFriendOpenStg();
        r1 = (com.tencent.mm.plugin.account.friend.a.q) r1;
        r3 = r0.hbL;
        r1 = r1.pz(r3);
        if (r1 == 0) goto L_0x00e1;
    L_0x00ab:
        r1 = r2.eMh;
        r1.setVisibility(r5);
    L_0x00b0:
        r3 = r2.eMf;
        if (r0 == 0) goto L_0x0110;
    L_0x00b4:
        r1 = r0.rul;
        if (r1 == 0) goto L_0x00e9;
    L_0x00b8:
        r4 = r1.length();
        if (r4 <= 0) goto L_0x00e9;
    L_0x00be:
        r3.setText(r1);
        r1 = r2.eMg;
        if (r0 == 0) goto L_0x0153;
    L_0x00c5:
        r3 = r0.rQA;
        if (r3 != 0) goto L_0x0114;
    L_0x00c9:
        r0 = r0.hbL;
    L_0x00cb:
        r1.setText(r0);
        r0 = r2.eMi;
        r1 = r8.eMd;
        r1 = r1[r9];
        r0.setChecked(r1);
        goto L_0x003f;
    L_0x00d9:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.plugin.account.friend.ui.b.a) r1;
        r2 = r1;
        goto L_0x0095;
    L_0x00e1:
        r1 = r2.eMh;
        r3 = 8;
        r1.setVisibility(r3);
        goto L_0x00b0;
    L_0x00e9:
        r1 = r0.hcS;
        if (r1 == 0) goto L_0x00f3;
    L_0x00ed:
        r4 = r1.length();
        if (r4 > 0) goto L_0x00be;
    L_0x00f3:
        r1 = new com.tencent.mm.a.o;
        r4 = r0.iwE;
        r1.<init>(r4);
        r1 = r1.toString();
        if (r1 == 0) goto L_0x0106;
    L_0x0100:
        r4 = r1.length();
        if (r4 > 0) goto L_0x00be;
    L_0x0106:
        r1 = r0.rhg;
        if (r1 == 0) goto L_0x0110;
    L_0x010a:
        r4 = r1.length();
        if (r4 > 0) goto L_0x00be;
    L_0x0110:
        r1 = "";
        goto L_0x00be;
    L_0x0114:
        r3 = r0.rQA;
        if (r3 != r6) goto L_0x011b;
    L_0x0118:
        r0 = r0.hbL;
        goto L_0x00cb;
    L_0x011b:
        r3 = r0.rQA;
        if (r3 != r7) goto L_0x0153;
    L_0x011f:
        r0 = r0.hbL;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r3 != 0) goto L_0x0153;
    L_0x0127:
        r3 = "@";
        r0 = r0.split(r3);
        if (r0 == 0) goto L_0x013b;
    L_0x0130:
        r3 = r0.length;
        if (r3 < r6) goto L_0x013b;
    L_0x0133:
        r3 = r0[r5];
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r3 == 0) goto L_0x013f;
    L_0x013b:
        r0 = "";
        goto L_0x00cb;
    L_0x013f:
        r3 = new java.lang.StringBuilder;
        r4 = "@";
        r3.<init>(r4);
        r0 = r0[r5];
        r0 = r3.append(r0);
        r0 = r0.toString();
        goto L_0x00cb;
    L_0x0153:
        r0 = "";
        goto L_0x00cb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.friend.ui.b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
