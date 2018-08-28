package com.tencent.mm.plugin.music.a;

import com.tencent.mm.g.a.s;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class a extends c<s> {
    public a() {
        this.sFo = s.class.getName().hashCode();
    }

    private static boolean a(s sVar) {
        boolean z = true;
        boolean z2 = false;
        if (sVar.bGU.action != 6) {
            x.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[]{Integer.valueOf(sVar.bGU.action)});
        }
        d bhf;
        String str;
        f HZ;
        f HZ2;
        d bhf2;
        String str2;
        com.tencent.mm.z.a aVar;
        switch (sVar.bGU.action) {
            case 0:
                z2 = d.bhf().b(sVar.bGU.bGY);
                break;
            case 1:
                z2 = d.bhf().a(sVar.bGU.bGW, sVar.bGU.bGY);
                break;
            case 2:
                boolean z3;
                bhf = d.bhf();
                str = sVar.bGU.bGW;
                f HZ3 = bhf.HZ(str);
                if (HZ3 == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
                    z3 = false;
                } else {
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", new Object[]{str});
                    HZ3.pause();
                    bhf.b(str, HZ3);
                    bhf.f(str, HZ3);
                    z3 = true;
                }
                sVar.bGV.bGZ = z3;
                return z3;
            case 3:
                z2 = d.bhf().HV(sVar.bGU.bGW);
                break;
            case 4:
                bhf = d.bhf();
                str = sVar.bGU.bGW;
                int i = sVar.bGU.bGX;
                HZ = bhf.HZ(str);
                if (HZ == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
                    z2 = bhf.bK(str, i);
                } else if (i < 0) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(HZ.getDuration())});
                } else {
                    if (HZ.getDuration() <= 0) {
                        x.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(HZ.getDuration())});
                    } else if (i <= 0 || i <= HZ.getDuration()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", new Object[]{str, Integer.valueOf(i)});
                        if (HZ.PY() || HZ.PZ() || HZ.isPaused()) {
                            z2 = HZ.if(i);
                        }
                    } else {
                        x.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(HZ.getDuration())});
                    }
                    HZ.bhx();
                    z2 = bhf.bK(str, i);
                }
                sVar.bGV.bGZ = z2;
                return z2;
            case 5:
                z2 = d.bhf().HW(sVar.bGU.bGW);
                break;
            case 6:
                sVar.bGV.bHa = d.bhf().HX(sVar.bGU.bGW);
                return true;
            case 7:
                HZ2 = d.bhf().HZ(sVar.bGU.bGW);
                if (HZ2 == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
                } else {
                    z2 = HZ2.PY();
                }
                sVar.bGV.bGZ = z2;
                return z2;
            case 8:
                HZ2 = d.bhf().HZ(sVar.bGU.bGW);
                if (HZ2 == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
                } else {
                    z2 = HZ2.PZ();
                }
                sVar.bGV.bGZ = z2;
                return z2;
            case 9:
                d.bhf().Ib(sVar.bGU.appId);
                return true;
            case 10:
                sVar.bGU.bGW = d.bhf().dQ(sVar.bGU.appId, sVar.bGU.bGW);
                return true;
            case 11:
                sVar.bGV.count = d.bhf().HY(sVar.bGU.appId);
                return true;
            case 12:
                d.bhf().Ia(sVar.bGU.appId);
                return true;
            case 13:
                bhf = d.bhf();
                String str3 = sVar.bGU.bGW;
                f HZ4 = bhf.HZ(str3);
                if (HZ4 == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
                    com.tencent.mm.z.c HX = bhf.HX(str3);
                    if (HX != null) {
                        z2 = HX.dGA;
                    }
                } else {
                    z2 = HZ4.dGA;
                }
                sVar.bGV.bGZ = z2;
                return z2;
            case 14:
                bhf2 = d.bhf();
                str2 = sVar.bGU.bGW;
                HZ = bhf2.HZ(str2);
                if (HZ == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
                } else {
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", new Object[]{str2});
                    HZ.dGA = false;
                    HZ.lxc = true;
                    HZ.bhw();
                    HZ.dkh = System.currentTimeMillis();
                    aVar = (com.tencent.mm.z.a) bhf2.lwH.get(str2);
                    if (aVar != null) {
                        aVar.dGs = 0;
                        aVar.dGu = true;
                    }
                    bhf2.b(str2, HZ);
                    bhf2.f(str2, HZ);
                    z2 = true;
                }
                sVar.bGV.bGZ = z2;
                return z2;
            case 15:
                bhf2 = d.bhf();
                str2 = sVar.bGU.processName;
                if (bhf2.lwE.size() == 0) {
                    return true;
                }
                x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", new Object[]{str2});
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bhf2.lwE);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str4 = (String) it.next();
                    String str5 = (String) bhf2.lwF.get(str4);
                    if (str2 != null && str2.equalsIgnoreCase(str5)) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
                        bhf2.Ib(str4);
                    }
                }
                return true;
            case 16:
                sVar.bGU.bGY = d.bhf().jE(sVar.bGU.bGW);
                return true;
            case 17:
                HZ2 = d.bhf().HZ(sVar.bGU.bGW);
                if (HZ2 == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
                } else {
                    z = HZ2.isStopped();
                }
                sVar.bGV.bGZ = z;
                return z;
            case 18:
                d bhf3 = d.bhf();
                com.tencent.mm.z.a aVar2 = sVar.bGU.bGY;
                if (aVar2 != null) {
                    aVar = (com.tencent.mm.z.a) bhf3.lwH.get(aVar2.bGW);
                    if (aVar != null) {
                        aVar.bGW = aVar2.bGW;
                        aVar.cfD = aVar2.cfD;
                        if (!(aVar2.filePath == null || aVar2.filePath.equals(""))) {
                            aVar.filePath = aVar2.filePath;
                        }
                        aVar.dGs = aVar2.dGs;
                        aVar.dGt = aVar2.dGt;
                        aVar.dGu = aVar2.dGu;
                        aVar.dGv = aVar2.dGv;
                        aVar.fromScene = aVar2.fromScene;
                        aVar.processName = aVar2.processName;
                        aVar.dGx = aVar2.dGx;
                        aVar.appId = aVar2.appId;
                        if (aVar2.dGy != null) {
                            aVar.dGy = aVar2.dGy;
                        }
                    } else {
                        bhf3.lwH.put(aVar2.bGW, aVar2);
                        aVar = aVar2;
                    }
                    f HZ5 = bhf3.HZ(aVar2.bGW);
                    if (HZ5 != null) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
                        HZ5.c(aVar);
                    } else {
                        x.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
                    }
                    z2 = true;
                    break;
                }
                x.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
                break;
            default:
                return true;
        }
        sVar.bGV.bGZ = z2;
        return z2;
    }
}
