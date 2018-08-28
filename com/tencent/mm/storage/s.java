package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public final class s {
    private static Boolean sOe = null;
    private static Boolean sOf = null;

    public static void ag(bd bdVar) {
        if (auK() && bdVar != null) {
            long j;
            int i = 0;
            int i2 = -1;
            int i3 = 0;
            b iF = bd.iF(bdVar.cqb);
            if (iF != null) {
                i = iF.dCm;
                i2 = iF.dCn;
                i3 = iF.dCo;
                j = (long) iF.dCr;
            } else {
                j = 0;
            }
            if (i2 == 0) {
                boolean z;
                if (a(bdVar, i, i3)) {
                    z = true;
                } else {
                    z = false;
                }
                x.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b", new Object[]{bdVar.field_talker, Boolean.valueOf(z)});
                q gg;
                q qVar;
                if (z) {
                    gg = z.Ne().gg(bdVar.field_msgSvrId);
                    qVar = gg == null ? new q() : gg;
                    qVar.field_msgId = bdVar.field_msgId;
                    qVar.field_msgSvrId = bdVar.field_msgSvrId;
                    qVar.field_content = bdVar.field_content;
                    qVar.field_type = bdVar.getType();
                    qVar.field_talker = bdVar.field_talker;
                    qVar.field_talkerId = bdVar.field_talkerId;
                    qVar.field_createTime = bdVar.field_createTime;
                    qVar.field_imgPath = bdVar.field_imgPath;
                    qVar.eC(bdVar.cqa);
                    qVar.dt(bdVar.cqb);
                    qVar.field_status = bdVar.field_status;
                    if (gg == null) {
                        qVar.field_hasShow = 0;
                        qVar.field_isExpand = false;
                        long ckx = z.Ne().ckx();
                        long L = L(ckx, qVar.field_createTime / 1000);
                        if (L >= 4294967296L) {
                            x.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", new Object[]{Long.valueOf(L)});
                            ckx = z.Ne().ckE();
                            L = L(ckx, qVar.field_createTime / 1000);
                        }
                        qVar.field_orderFlag = (((j << 24) & 4278190080L) | (ckx << 32)) | L;
                        z.Ne().c(qVar);
                        x.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", new Object[]{Long.valueOf(ckx), Long.valueOf(L), Long.valueOf(qVar.field_orderFlag)});
                        return;
                    }
                    z.Ne().d(qVar);
                    return;
                }
                t Nf = z.Nf();
                j = bdVar.field_msgSvrId;
                q qVar2 = new q();
                Cursor a = Nf.dCZ.a("BizTimeLineSingleMsgInfo", null, "msgSvrId" + "=?", new String[]{String.valueOf(j)}, null, null, null, 2);
                if (a.moveToFirst()) {
                    qVar2.d(a);
                    a.close();
                    gg = qVar2;
                } else {
                    a.close();
                    gg = null;
                }
                if (gg == null) {
                    qVar = new q();
                } else {
                    qVar = gg;
                }
                qVar.field_msgId = bdVar.field_msgId;
                qVar.field_msgSvrId = bdVar.field_msgSvrId;
                qVar.field_content = bdVar.field_content;
                qVar.field_type = bdVar.getType();
                qVar.field_talker = bdVar.field_talker;
                qVar.field_talkerId = bdVar.field_talkerId;
                qVar.field_createTime = bdVar.field_createTime;
                qVar.field_imgPath = bdVar.field_imgPath;
                qVar.eC(bdVar.cqa);
                qVar.dt(bdVar.cqb);
                qVar.field_status = bdVar.field_status;
                if (gg == null) {
                    z.Nf().c(qVar);
                } else {
                    z.Nf().d(qVar);
                }
            }
        }
    }

    private static boolean a(bd bdVar, int i, int i2) {
        if ((bdVar.cky() || bdVar.getType() == 1 || bdVar.getType() == 34 || bdVar.getType() == 3) && (i == 3 || i2 == 9 || i2 == 15 || i2 == 17)) {
            return true;
        }
        return false;
    }

    public static void ah(bd bdVar) {
        int i = -1;
        b iF = bd.iF(bdVar.cqb);
        int i2;
        int i3;
        if (iF != null) {
            i2 = iF.dCm;
            i = iF.dCn;
            i3 = iF.dCo;
        } else {
            i3 = 0;
            i2 = 0;
        }
        if (i == 0 && a(bdVar, i2, i3)) {
            x.i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrateBizTimeLineMsg %s", new Object[]{bdVar.field_talker});
            q gg = z.Ne().gg(bdVar.field_msgSvrId);
            q qVar = gg == null ? new q() : gg;
            qVar.field_msgId = bdVar.field_msgId;
            qVar.field_msgSvrId = bdVar.field_msgSvrId;
            qVar.field_content = bdVar.field_content;
            qVar.field_type = bdVar.getType();
            qVar.field_talker = bdVar.field_talker;
            qVar.field_talkerId = bdVar.field_talkerId;
            qVar.field_createTime = bdVar.field_createTime;
            qVar.field_imgPath = bdVar.field_imgPath;
            qVar.eC(bdVar.cqa);
            qVar.dt(bdVar.cqb);
            if (gg == null) {
                qVar.field_status = 4;
                qVar.field_isExpand = false;
                qVar.field_orderFlag = 4294967296L | (qVar.field_createTime / 1000);
                z.Ne().c(qVar);
            }
        }
    }

    public static void ai(bd bdVar) {
        if (bdVar != null) {
            z.Ne().gj(bdVar.field_msgId);
        }
    }

    private static long L(long j, long j2) {
        long j3 = -1;
        String str = (String) g.Ei().DT().get(a.sZX, "");
        if (!bi.oW(str)) {
            String[] split = str.split(":");
            if (split.length == 2 && bi.getLong(split[0], -1) == j) {
                j3 = j2 - bi.getLong(split[1], -1);
            }
        }
        if (j3 < 0) {
            g.Ei().DT().a(a.sZX, j + ":" + (j2 - 604800));
            x.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", new Object[]{str, Long.valueOf(j2)});
            return 604800;
        }
        x.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", new Object[]{str, Long.valueOf(j2)});
        return j3;
    }

    public static boolean auK() {
        if (sOe != null) {
            return sOe.booleanValue();
        }
        c fJ = c.Jx().fJ("100391");
        boolean z = fJ.isValid() && "1".equals(fJ.ckq().get("isOpenSubscribeListVersion1"));
        sOe = Boolean.valueOf(z);
        x.d("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", new Object[]{sOe});
        return sOe.booleanValue();
    }

    public static boolean auL() {
        if (sOf != null) {
            return sOf.booleanValue();
        }
        c fJ = c.Jx().fJ("100391");
        boolean z = fJ.isValid() && "1".equals(fJ.ckq().get("isOpenNumberNotify"));
        sOf = Boolean.valueOf(z);
        x.d("MicroMsg.BizTimeLineInfoStorageLogic", "isOpenNumberNotify open %b", new Object[]{sOf});
        return sOf.booleanValue();
    }

    public static void ckH() {
        if (auK()) {
            boolean z;
            ai aiVar;
            q ckB;
            int ckC = z.Ne().ckC();
            int axd = z.Nf().axd();
            az FW = ((i) g.l(i.class)).FW();
            ai Yq = FW.Yq("officialaccounts");
            if (Yq == null) {
                z = true;
                aiVar = new ai("officialaccounts");
            } else {
                z = false;
                aiVar = Yq;
            }
            aiVar.eV(ckC);
            aiVar.fb(axd);
            if (axd > 0) {
                ckB = z.Nf().ckB();
            } else {
                ckB = z.Ne().ckB();
            }
            if (ckB != null && ckB.field_msgId != 0) {
                bd dW = ((i) g.l(i.class)).bcY().dW(ckB.field_msgId);
                if (dW.field_msgId > 0) {
                    aiVar.aj(dW);
                    aiVar.setContent(dW.field_talker + ":" + dW.field_content);
                    aiVar.ec(Integer.toString(dW.getType()));
                    az.b vu = FW.vu();
                    if (vu != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        dW.ep("officialaccounts");
                        dW.setContent(aiVar.field_content);
                        vu.a(dW, pString, pString2, pInt, true);
                        aiVar.ed(pString.value);
                        aiVar.ee(pString2.value);
                        aiVar.eY(pInt.value);
                    }
                } else {
                    aiVar.clx();
                    x.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is null or MsgId <= 0, lastTalker is %s", new Object[]{ckB.field_talker});
                }
                if (z) {
                    FW.d(aiVar);
                } else {
                    FW.a(aiVar, aiVar.field_username);
                }
            }
        }
    }
}
