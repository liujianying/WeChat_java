package com.tencent.mm.model;

import com.tencent.mm.k.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class as {
    public static void ha(int i) {
        boolean Aj = a.Aj();
        boolean Ak = a.Ak();
        boolean Al = a.Al();
        boolean Am = a.Am();
        boolean Ao = a.Ao();
        boolean Ap = a.Ap();
        int Aq = a.Aq();
        int As = a.As();
        int Ar = a.Ar();
        int At = a.At();
        g.Ek();
        boolean booleanValue = ((Boolean) g.Ei().DT().get(73217, Boolean.valueOf(true))).booleanValue();
        g.Ek();
        boolean z = booleanValue || ((Boolean) g.Ei().DT().get(73218, Boolean.valueOf(true))).booleanValue();
        x.i("MicroMsg.KvNotificationStat", "doStatNotification, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, isNotificationShowDetail: %s, isNotificationSound: %s, isNotificationShake: %s, isActiveSilentTime: %s, activeBegin: %s, activeEnd: %s, scene: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", new Object[]{Boolean.valueOf(Aj), Boolean.valueOf(Ak), Boolean.valueOf(Al), Boolean.valueOf(Am), Boolean.valueOf(Ao), Boolean.valueOf(Ap), hb(Aq) + hb(As), hb(Ar) + hb(At), Integer.valueOf(i), Boolean.valueOf(booleanValue), Boolean.valueOf(r12), Boolean.valueOf(z)});
        h hVar = h.mEJ;
        Object[] objArr = new Object[10];
        objArr[0] = Integer.valueOf(Aj ? 1 : 2);
        objArr[1] = Integer.valueOf(Ak ? 1 : 2);
        objArr[2] = Integer.valueOf(Al ? 1 : 2);
        objArr[3] = Integer.valueOf(Am ? 1 : 2);
        objArr[4] = Integer.valueOf(Ao ? 1 : 2);
        objArr[5] = Integer.valueOf(Ap ? 2 : 1);
        objArr[6] = hb(Ar) + hb(At);
        objArr[7] = hb(Aq) + hb(As);
        objArr[8] = Integer.valueOf(i);
        objArr[9] = Integer.valueOf(z ? 1 : 2);
        hVar.h(15308, objArr);
    }

    private static String hb(int i) {
        if (i > 10) {
            return String.valueOf(i);
        }
        return "0" + i;
    }

    public static void j(boolean z, boolean z2) {
        int i;
        int i2;
        int i3 = 2;
        boolean Aj = a.Aj();
        boolean Ak = a.Ak();
        g.Ek();
        boolean booleanValue = ((Boolean) g.Ei().DT().get(73217, Boolean.valueOf(true))).booleanValue();
        g.Ek();
        boolean z3 = booleanValue || ((Boolean) g.Ei().DT().get(73218, Boolean.valueOf(true))).booleanValue();
        x.i("MicroMsg.KvNotificationStat", "doStatSysNotificationAfterModify, switchNewMsg: %s, switchVoipInvite: %s, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(Aj), Boolean.valueOf(Ak), Boolean.valueOf(booleanValue), Boolean.valueOf(r7), Boolean.valueOf(z3)});
        h hVar = h.mEJ;
        Object[] objArr = new Object[8];
        if (Aj) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        if (Ak) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        if (z3) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(0);
        i2 = z ? Aj ? 2 : 1 : 0;
        objArr[4] = Integer.valueOf(i2);
        if (!z2) {
            i3 = 0;
        } else if (!Ak) {
            i3 = 1;
        }
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(0);
        objArr[7] = Integer.valueOf(0);
        hVar.h(14852, objArr);
    }
}
