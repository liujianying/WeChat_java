package com.tencent.mm.modelvoice;

import android.database.Cursor;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public final class q {
    private static HashMap<String, WeakReference<i>> epL = new HashMap();
    public static volatile HashMap<String, Integer> epM = new HashMap();
    public static volatile HashMap<String, Integer> epN = new HashMap();
    public static volatile HashMap<String, Integer> epO = new HashMap();

    public static boolean oj(String str) {
        if (str == null) {
            return false;
        }
        p ow = m.TI().ow(str);
        if (ow == null || ow.enO >= 250) {
            return false;
        }
        ow.enO++;
        ow.bWA = 8192;
        return a(ow);
    }

    public static int iF(int i) {
        return ((i - 6) / 32) * 20;
    }

    public static b aC(String str, String str2) {
        u TI = m.TI();
        String fullPath = getFullPath(str2);
        switch (bi.getInt(str, -1)) {
            case 1:
                if (TI.epY.get(fullPath) == null) {
                    TI.epY.put(fullPath, new l(fullPath));
                }
                return (b) TI.epY.get(fullPath);
            case 4:
                if (TI.epZ.get(fullPath) == null) {
                    TI.epZ.put(fullPath, new h(fullPath));
                }
                return (b) TI.epZ.get(fullPath);
            default:
                if (TI.epX.get(fullPath) == null) {
                    TI.epX.put(fullPath, new a(fullPath));
                }
                return (b) TI.epX.get(fullPath);
        }
    }

    public static b ok(String str) {
        u TI = m.TI();
        String fullPath = getFullPath(str);
        switch (o.oh(str)) {
            case 0:
                if (TI.epX.get(fullPath) == null) {
                    TI.epX.put(fullPath, new a(fullPath));
                }
                return (b) TI.epX.get(fullPath);
            case 1:
                if (TI.epY.get(fullPath) == null) {
                    TI.epY.put(fullPath, new l(fullPath));
                }
                return (b) TI.epY.get(fullPath);
            case 2:
                if (TI.epZ.get(fullPath) == null) {
                    TI.epZ.put(fullPath, new h(fullPath));
                }
                return (b) TI.epZ.get(fullPath);
            default:
                if (TI.epX.get(fullPath) == null) {
                    TI.epX.put(fullPath, new a(fullPath));
                }
                return (b) TI.epX.get(fullPath);
        }
    }

    public static void ol(String str) {
        u TI = m.TI();
        String fullPath = getFullPath(str);
        a aVar;
        switch (o.oh(str)) {
            case 0:
                aVar = (a) TI.epX.get(fullPath);
                if (aVar != null) {
                    aVar.Tz();
                    TI.epX.remove(fullPath);
                    return;
                }
                return;
            case 1:
                l lVar = (l) TI.epY.get(fullPath);
                if (lVar != null) {
                    lVar.Tz();
                    TI.epY.remove(fullPath);
                    return;
                }
                return;
            case 2:
                h hVar = (h) TI.epZ.get(fullPath);
                if (hVar != null) {
                    hVar.Tz();
                    TI.epZ.remove(fullPath);
                    return;
                }
                return;
            default:
                aVar = (a) TI.epX.get(fullPath);
                if (aVar != null) {
                    aVar.Tz();
                    TI.epX.remove(fullPath);
                    return;
                }
                return;
        }
    }

    public static String getFullPath(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return O(str, false);
    }

    public static String O(String str, boolean z) {
        a aVar = new a();
        String b = h.b(Gd(), "msg_", str, ".amr", 2);
        x.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + aVar.Ad() + " " + b);
        if (bi.oW(b)) {
            return null;
        }
        if (z || new File(b).exists()) {
            return b;
        }
        String str2 = TO() + str;
        if (new File(str2 + ".amr").exists()) {
            j.q(str2 + ".amr", b, true);
            return b;
        } else if (!new File(str2).exists()) {
            return b;
        } else {
            j.q(str2, b, true);
            return b;
        }
    }

    public static String om(String str) {
        String ov = u.ov(com.tencent.mm.model.q.GF());
        p pVar = new p();
        pVar.fileName = ov;
        pVar.bWJ = str;
        pVar.createTime = System.currentTimeMillis() / 1000;
        pVar.clientId = ov;
        pVar.enK = System.currentTimeMillis() / 1000;
        pVar.status = 1;
        pVar.enF = com.tencent.mm.model.q.GF();
        pVar.bWA = -1;
        if (!m.TI().b(pVar)) {
            return null;
        }
        x.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
        return ov;
    }

    public static boolean a(String str, i iVar) {
        if (str == null) {
            return false;
        }
        p ow = m.TI().ow(str);
        if (ow == null) {
            x.d("MicroMsg.VoiceLogic", "startSend null record : " + str);
            return false;
        } else if (ow.status != 1) {
            return false;
        } else {
            ow.status = 2;
            ow.bWA = 64;
            epL.put(str, new WeakReference(iVar));
            return a(ow);
        }
    }

    public static boolean on(String str) {
        if (str == null) {
            return false;
        }
        x.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + str + "]");
        p ow = m.TI().ow(str);
        if (ow == null) {
            return false;
        }
        ow.status = 8;
        ow.dHI = o.nM(str);
        ow.bWA = 96;
        return a(ow);
    }

    public static boolean oo(String str) {
        if (str == null) {
            return false;
        }
        p ow = m.TI().ow(str);
        if (ow == null) {
            x.d("MicroMsg.VoiceLogic", "cancel null download : " + str);
            return true;
        }
        x.d("MicroMsg.VoiceLogic", "cancel download : " + str + " SvrlId:" + ow.bYu);
        if (ow.bYu != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().R(ow.bWJ, ow.bYu);
        }
        return oq(str);
    }

    public static boolean op(String str) {
        if (str == null) {
            return false;
        }
        p ow = m.TI().ow(str);
        if (ow == null) {
            x.i("MicroMsg.VoiceLogic", "cancel null record : " + str);
            return true;
        }
        x.i("MicroMsg.VoiceLogic", "cancel record : " + str + " LocalId:" + ow.enN);
        if (ow.enN != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dX((long) ow.enN);
        }
        return oq(str);
    }

    public static boolean oq(String str) {
        if (bi.oW(str)) {
            return false;
        }
        m.TI().jy(str);
        ol(str);
        return new File(getFullPath(str)).delete();
    }

    public static boolean X(String str, int i) {
        return m(str, i, 0);
    }

    private static boolean m(String str, int i, int i2) {
        if (str == null) {
            return false;
        }
        x.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + str + "], fullPath[" + getFullPath(str) + "]");
        p ow = m.TI().ow(str);
        if (ow == null) {
            return false;
        }
        if (!(ow.status == 97 || ow.status == 98)) {
            ow.status = 3;
        }
        ow.dHI = o.nM(str);
        if (ow.dHI <= 0) {
            nP(str);
            return false;
        }
        ow.enK = System.currentTimeMillis() / 1000;
        ow.epI = i;
        ow.bWA = 3424;
        bd bdVar = new bd();
        bdVar.ep(ow.bWJ);
        bdVar.setType(34);
        bdVar.eX(1);
        bdVar.eq(str);
        if (ow.status == 97) {
            bdVar.setStatus(2);
            bdVar.setContent(n.b(ow.enF, (long) ow.epI, false));
        } else if (ow.status == 98) {
            bdVar.setStatus(5);
            bdVar.setContent(n.b(ow.enF, -1, true));
        } else {
            bdVar.setStatus(1);
            bdVar.setContent(n.b(ow.enF, (long) ow.epI, false));
        }
        bdVar.ay(com.tencent.mm.model.bd.iD(ow.bWJ));
        bdVar.Dn(i2);
        com.tencent.mm.j.a.a.yw().c(bdVar);
        ow.enN = (int) com.tencent.mm.model.bd.i(bdVar);
        boolean a = a(ow);
        epL.remove(str);
        return a;
    }

    public static int a(String str, int i, long j, String str2, int i2, int i3) {
        if (str == null) {
            return -1;
        }
        x.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + str + "] newOff:" + i + " SvrID:" + j + " clientID:" + str2 + " hasSendEndFlag " + i2);
        p ow = m.TI().ow(str);
        if (ow == null) {
            return -1;
        }
        ow.emu = i;
        ow.enK = System.currentTimeMillis() / 1000;
        ow.bWA = 264;
        if (bi.oW(ow.clientId) && str2 != null) {
            ow.clientId = str2;
            ow.bWA |= 512;
        }
        if (ow.bYu == 0 && j != 0) {
            ow.bYu = j;
            ow.bWA |= 4;
        }
        int i4 = 0;
        if (ow.dHI <= i && ow.status == 3 && i2 == 1) {
            ow.status = 99;
            ow.bWA |= 64;
            bd dW = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW((long) ow.enN);
            dW.ep(ow.bWJ);
            dW.ax(ow.bYu);
            dW.setStatus(2);
            dW.setContent(n.b(ow.enF, (long) ow.epI, false));
            dW.Dn(i3);
            Integer num = (Integer) epM.get(getFullPath(str));
            if (num != null) {
                ow.epK = num.intValue();
                ow.bWA |= 524288;
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a((long) ow.enN, dW);
            x.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + str + " total:" + ow.dHI + " status:" + ow.status + " netTimes:" + ow.enO + " msgId:" + dW.field_msgId);
            i4 = 1;
            ol(str);
        }
        if (a(ow)) {
            return i4;
        }
        return -4;
    }

    public static synchronized int a(int i, byte[] bArr, int i2) {
        int i3;
        int i4 = 0;
        synchronized (q.class) {
            if (bArr != null) {
                if (bArr.length != 0) {
                    i3 = i;
                    while (i4 < i2) {
                        i3 += bArr[i4 + 0];
                        i4++;
                    }
                }
            }
            i3 = 0;
        }
        return i3;
    }

    public static int b(int i, byte[] bArr, int i2) {
        if (!(bArr == null || bArr.length == 0)) {
            int hashCode;
            int i3;
            if (i == 0) {
                hashCode = bArr.hashCode() & 255;
                i3 = hashCode;
                i = hashCode;
            } else {
                i3 = i & 255;
            }
            for (hashCode = 0; hashCode < i2; hashCode++) {
                i += (bArr[hashCode + 0] & i3) * 256;
            }
        }
        return i;
    }

    public static int c(String str, byte[] bArr, int i) {
        p ow = m.TI().ow(str);
        if (ow == null) {
            return -1;
        }
        ow.epK = b(ow.epK, bArr, i);
        ow.bWA |= 524288;
        return a(ow) ? ow.epK : 0;
    }

    public static boolean or(String str) {
        p ow = m.TI().ow(str);
        if (ow == null) {
            return true;
        }
        File file = new File(getFullPath(str));
        b ok = ok(str);
        if (ok != null && (ok instanceof a) && Math.abs(file.length() - ((long) ow.dHI)) == 6) {
            x.i("MicroMsg.VoiceLogic", "maybe amr, ignore for the moment. %d %d", new Object[]{Long.valueOf(file.length()), Integer.valueOf(ow.dHI)});
            return true;
        } else if (file.length() != ((long) ow.dHI)) {
            x.e("MicroMsg.VoiceLogic", "checkChecksum fail. %d, %d", new Object[]{Long.valueOf(file.length()), Integer.valueOf(ow.dHI)});
            return false;
        } else {
            g br = ok.br(0, ow.dHI);
            if (br.ret != 0 || ow.epK == 0 || ow.epK == b(ow.epK & 255, br.buf, br.bEG)) {
                return true;
            }
            x.e("MicroMsg.VoiceLogic", "checkChecksum fail2. %d", new Object[]{Integer.valueOf(ow.epK)});
            return false;
        }
    }

    public static int a(p pVar, byte[] bArr, int i, String str, String str2, d.a aVar) {
        a aVar2 = new a();
        p bE = m.TI().bE(pVar.bYu);
        if (bE != null && bE.status == 99) {
            return 0;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().I(pVar.bWJ, pVar.bYu).field_msgSvrId == pVar.bYu && bE == null) {
            return 0;
        }
        if (bE != null) {
            pVar.fileName = bE.fileName;
        } else {
            pVar.fileName = u.ov(pVar.enF);
        }
        pVar.bWA |= 1;
        x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Ac() + "checktime :" + aVar2.Ad());
        boolean z = false;
        if (bArr != null && bArr.length > 1) {
            boolean z2;
            if (bE != null) {
                x.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
            }
            String str3 = pVar.eoB;
            String str4 = pVar.fileName;
            int write = aC(str3, str4).write(bArr, bArr.length, 0);
            if (write < 0) {
                x.e("MicroMsg.VoiceLogic", "Write Failed File:" + str4 + " newOffset:" + write + " voiceFormat:" + str3);
                z2 = false;
            } else if (bArr.length != write) {
                x.e("MicroMsg.VoiceLogic", "Write File:" + str4 + " fileOff:" + write + " bufLen:" + bArr.length + " voiceFormat:" + str3);
                z2 = false;
            } else {
                x.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str4 + "] + buf:" + bArr.length + " voiceFormat:" + str3);
                ol(str4);
                z2 = true;
            }
            pVar.epK = b(pVar.epK, bArr, bArr.length);
            pVar.bWA |= 524288;
            z = z2;
        }
        x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Ac() + "checktime :" + aVar2.Ad());
        pVar.enK = System.currentTimeMillis() / 1000;
        pVar.bWA |= 256;
        if (z) {
            pVar.status = 99;
        } else if (pVar.dHI == 0) {
            pVar.status = 5;
        } else {
            pVar.status = 6;
        }
        pVar.bWA |= 64;
        if (bE == null) {
            if (z) {
                pVar.enN = (int) a(pVar, z, i, str, str2, aVar);
            }
            if (aVar != null) {
                pVar.cqa = com.tencent.mm.model.bd.c(aVar);
                if (aVar.dIN != null) {
                    pVar.dYP = aVar.dIN.rcr;
                }
            }
            x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Ac() + "checktime :" + aVar2.Ad());
            pVar.bWA = -1;
            x.d("MicroMsg.VoiceLogic", "Insert fileName:" + pVar.fileName + " stat:" + pVar.status + " net:" + pVar.emu + " total:" + pVar.dHI);
            if (m.TI().b(pVar)) {
                x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Ac() + "checktime :" + aVar2.Ad());
                if (z) {
                    return 1;
                }
            }
            x.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + pVar.fileName + " stat:" + pVar.status + " net:" + pVar.emu + " total:" + pVar.dHI);
            return -2;
        }
        x.d("MicroMsg.VoiceLogic", "Sync Update file:" + pVar.fileName + " stat:" + pVar.status);
        if (!a(pVar)) {
            return -44;
        }
        if (z) {
            a(pVar, aVar);
            return 1;
        }
        if (bE != null && bE.enH == pVar.dHI) {
            a(bE.fileName, bE.enH, aVar);
            x.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + bE.fileName);
        }
        x.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[]{aVar, Boolean.valueOf(z), bi.cjd()});
        m.TK().run();
        return 0;
    }

    private static boolean a(p pVar, d.a aVar) {
        try {
            pVar.enN = (int) a(pVar, true, 3, "", pVar.cqb, aVar);
            pVar.bWA |= 2048;
            return a(pVar);
        } catch (Throwable e) {
            x.e("MicroMsg.VoiceLogic", "exception:%s", new Object[]{bi.i(e)});
            return false;
        }
    }

    private static long a(p pVar, boolean z, int i, String str, String str2, d.a aVar) {
        if (((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dY(pVar.bYu)) {
            x.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[]{Long.valueOf(pVar.bYu)});
            if (bi.oV(pVar.fileName).length() > 0) {
                m.TI().jy(pVar.fileName);
            } else {
                x.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
            }
            return -1;
        }
        bd bdVar = new bd();
        bdVar.ax(pVar.bYu);
        bdVar.eq(pVar.fileName);
        bdVar.ay(com.tencent.mm.model.bd.o(pVar.bWJ, pVar.createTime));
        bdVar.ep(pVar.bWJ);
        bdVar.eX(com.tencent.mm.model.q.gQ(pVar.enF) ? 1 : 0);
        bdVar.setType(34);
        bdVar.eu(str);
        bdVar.Dn(pVar.eoI);
        bdVar.setStatus(i);
        if (aVar == null) {
            int i2 = pVar.cqa;
            if (i2 != 0) {
                x.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[]{Integer.valueOf(i2)});
                bdVar.fg(i2);
                if (bdVar.field_msgId == 0 && bdVar.field_isSend == 0 && (i2 & 2) != 0) {
                    bdVar.ay(com.tencent.mm.model.bd.g(bdVar.field_talker, pVar.createTime, bdVar.field_msgSeq));
                }
            }
            if (pVar.dYP != 0) {
                bdVar.aA((long) pVar.dYP);
            }
            x.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(pVar.dYP)});
        } else {
            com.tencent.mm.model.bd.a(bdVar, aVar);
        }
        x.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[]{str2});
        if (!bi.oW(str2)) {
            bdVar.dt(str2);
            bdVar.ev(com.tencent.mm.model.bd.iG(str2));
        }
        if (z) {
            bdVar.setContent(n.b(pVar.enF, (long) pVar.epI, false));
        } else {
            bdVar.setContent(n.b(pVar.enF, 0, false));
        }
        if (!bi.oW(str2)) {
            bdVar.dt(str2);
            bdVar.ev(com.tencent.mm.model.bd.iG(str2));
            b iF = com.tencent.mm.model.bd.iF(str2);
            if (iF != null) {
                bdVar.ev(iF.dCq);
                bdVar.et(iF.dCp);
                x.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[]{iF.dCp});
                if (iF.dCs != null) {
                    iu iuVar = new iu();
                    iuVar.bSn.bGS = bdVar;
                    iuVar.bSn.bSo = iF;
                    com.tencent.mm.sdk.b.a.sFg.m(iuVar);
                }
            }
        }
        x.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[]{Long.valueOf(bdVar.field_msgSvrId), Long.valueOf(bdVar.field_msgSeq)});
        return com.tencent.mm.model.bd.i(bdVar);
    }

    public static int a(String str, int i, d.a aVar) {
        if (str == null) {
            return -1;
        }
        p ow = m.TI().ow(str);
        if (ow == null) {
            return -1;
        }
        ow.enH = i;
        ow.enK = System.currentTimeMillis() / 1000;
        ow.bWA = 272;
        int i2 = 0;
        if (ow.dHI > 0 && i >= ow.dHI) {
            a(ow, aVar);
            ow.status = 99;
            ow.bWA |= 64;
            x.d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + str + " newsize:" + i + " total:" + ow.dHI + " status:" + ow.status + " netTimes:" + ow.enO);
            i2 = 1;
            ol(str);
        }
        x.d("MicroMsg.VoiceLogic", "updateRecv file:" + str + " newsize:" + i + " total:" + ow.dHI + " status:" + ow.status);
        if (a(ow)) {
            return i2;
        }
        return -3;
    }

    public static boolean nQ(String str) {
        p ow = m.TI().ow(str);
        if (ow == null) {
            return false;
        }
        if (ow.status == 3) {
            bd dW = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW((long) ow.enN);
            dW.setContent(n.b(ow.enF, (long) ow.epI, false));
            dW.setStatus(2);
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a((long) ow.enN, dW);
        }
        ow.status = 97;
        ow.enK = System.currentTimeMillis() / 1000;
        ow.bWA = 320;
        return a(ow);
    }

    public static boolean iG(int i) {
        bd dW = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW((long) i);
        if (dW.field_msgId == 0 || dW.field_imgPath == null) {
            return false;
        }
        if (bi.oW(dW.field_imgPath)) {
            return false;
        }
        p ow = m.TI().ow(dW.field_imgPath);
        if (ow == null || bi.oW(ow.fileName)) {
            return false;
        }
        ow.status = 3;
        ow.emu = 0;
        ow.createTime = System.currentTimeMillis() / 1000;
        ow.enK = System.currentTimeMillis() / 1000;
        ow.bWA = 8648;
        boolean a = a(ow);
        x.d("MicroMsg.VoiceLogic", " file:" + ow.fileName + " msgid:" + ow.enN + "  stat:" + ow.status);
        if (ow.enN == 0 || bi.oW(ow.bWJ)) {
            x.e("MicroMsg.VoiceLogic", " failed msg id:" + ow.enN + " user:" + ow.bWJ);
            return a;
        }
        dW.setStatus(1);
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a(dW.field_msgId, dW);
        m.TK().run();
        return true;
    }

    public static String e(String str, String str2, int i) {
        if (bi.oW(str)) {
            return null;
        }
        if (!(bi.oW(str2) || str2.startsWith("amr_") || str2.startsWith("spx_"))) {
            str2.startsWith("silk_");
        }
        String om = om(str);
        if (bi.oW(om) || !j.q(getFullPath(str2), getFullPath(om), false)) {
            return null;
        }
        m(om, i, 1);
        return om;
    }

    public static boolean nP(String str) {
        com.tencent.mm.plugin.report.service.h.mEJ.a(111, 234, 1, false);
        if (str == null) {
            return false;
        }
        p ow = m.TI().ow(str);
        if (ow == null) {
            x.e("MicroMsg.VoiceLogic", "Set error failed file:" + str);
            return false;
        }
        ow.status = 98;
        ow.enK = System.currentTimeMillis() / 1000;
        ow.bWA = 320;
        boolean a = a(ow);
        x.d("MicroMsg.VoiceLogic", "setError file:" + str + " msgid:" + ow.enN + " old stat:" + ow.status);
        if (ow.enN == 0 || bi.oW(ow.bWJ)) {
            x.e("MicroMsg.VoiceLogic", "setError failed msg id:" + ow.enN + " user:" + ow.bWJ);
            return a;
        }
        bd dW = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW((long) ow.enN);
        f.mDy.a(111, 33, 1, true);
        dW.setMsgId((long) ow.enN);
        dW.setStatus(5);
        dW.ep(ow.bWJ);
        dW.setContent(n.b(ow.enF, -1, true));
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a(dW.field_msgId, dW);
        return a;
    }

    public static bd os(String str) {
        if (str == null) {
            return null;
        }
        p ow = m.TI().ow(str);
        if (ow != null) {
            return ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW((long) ow.enN);
        }
        return null;
    }

    public static p ot(String str) {
        return m.TI().ow(str);
    }

    public static List<p> TN() {
        List<p> list = null;
        u TI = m.TI();
        Cursor b = TI.dCZ.b(("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo") + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime", null, 2);
        int i = 0;
        if (b.moveToFirst()) {
            list = new ArrayList();
            do {
                p pVar = new p();
                pVar.d(b);
                list.add(pVar);
                i++;
            } while (b.moveToNext());
        }
        x.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:" + i);
        b.close();
        return list;
    }

    private static boolean a(p pVar) {
        if (pVar == null || pVar.bWA == -1) {
            return false;
        }
        return m.TI().a(pVar.fileName, pVar);
    }

    public static float E(bd bdVar) {
        boolean z = bdVar != null && bdVar.ckz();
        Assert.assertTrue(z);
        float f = ((float) new n(bdVar.field_content).time) / 1000.0f;
        if (f < 1.0f) {
            f = 1.0f;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static float bD(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static boolean F(bd bdVar) {
        if (bdVar == null || !bdVar.ckz()) {
            return false;
        }
        return new n(bdVar.field_content).enG;
    }

    public static boolean G(bd bdVar) {
        if (bdVar == null || !bdVar.ckz() || bdVar.field_isSend == 1) {
            return false;
        }
        if (new n(bdVar.field_content).time != 0) {
            return false;
        }
        return true;
    }

    public static void H(bd bdVar) {
        if (bdVar != null && bdVar.ckz()) {
            bd dW = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW(bdVar.field_msgId);
            if (dW.field_msgId == bdVar.field_msgId) {
                n nVar = new n(dW.field_content);
                if (!nVar.enG) {
                    nVar.enG = true;
                    bdVar.setContent(nVar.enF + ":" + nVar.time + ":" + (nVar.enG ? 1 : 0) + "\n");
                    ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a(bdVar.field_msgId, bdVar);
                }
            }
        }
    }

    public static int ou(String str) {
        if (epL.get(str) != null) {
            i iVar = (i) ((WeakReference) epL.get(str)).get();
            if (iVar != null) {
                return (int) iVar.wu();
            }
        }
        return -1;
    }

    public static String TO() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("voice/").toString();
    }

    public static String Gd() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("voice2/").toString();
    }
}
