package com.tencent.mm.plugin.backup.b;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.e.h;
import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

public final class c {
    private int gRy;
    boolean gSg = false;
    com.tencent.mm.plugin.backup.a.b.b gSh;
    d gSi;
    long gSj = 0;
    public long gSk = 0;

    private class b {
        String TAG;
        String bgn;
        boolean ftu;
        int gRH;
        long gRJ;
        long gRK;
        private final com.tencent.mm.plugin.backup.f.c.b gSA;
        private final Runnable gSB;
        final Runnable gSC;
        LinkedBlockingQueue<Runnable> gSs;
        a gSt;
        long gSu;
        String gSv;
        Vector<String> gSw;
        Vector<ey> gSx;
        HashMap<Long, a> gSy;
        long gSz;
        String talker;

        public final String toString() {
            return this.TAG;
        }

        public b(a aVar, f.a aVar2) {
            String displayName;
            this.TAG = "";
            this.gSs = new LinkedBlockingQueue();
            this.gRJ = 0;
            this.gRK = 0;
            this.gSu = 0;
            this.gSv = "";
            this.gSw = new Vector();
            this.gSx = new Vector();
            this.gSy = new HashMap();
            this.gSz = 0;
            this.ftu = false;
            this.gSA = new 1(this);
            this.gSB = new 3(this);
            this.gSC = new 4(this);
            this.gSz = bi.VF();
            this.gSt = aVar;
            this.talker = aVar2.gRG;
            this.gRH = aVar2.gRH;
            if (s.fq(this.talker)) {
                displayName = r.getDisplayName(this.talker, this.talker);
            } else {
                displayName = r.gT(this.talker);
            }
            this.bgn = displayName;
            this.TAG = "MicroMsg.BackupPackAndSend.tag." + (this.ftu ? "S." : "W.") + this.gRH + "." + this.bgn;
            x.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[]{Integer.valueOf(this.gRH), this.bgn, this.talker, aj.cin()});
        }

        public final boolean a(ey eyVar, long j, long j2, LinkedList<u> linkedList, HashMap<Long, a> hashMap) {
            this.gSx.add(eyVar);
            this.gSu = (j > 0 ? j : 0) + this.gSu;
            if (this.gRJ == 0) {
                this.gRJ = j2;
            }
            this.gRK = j2;
            this.gSy.putAll(hashMap);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                f(uVar.mediaId, uVar.path, false);
            }
            x.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[]{Long.valueOf(this.gRJ), Long.valueOf(this.gRK), Long.valueOf(j), Long.valueOf(this.gSu), Integer.valueOf(this.gSx.size()), Integer.valueOf(linkedList.size()), Long.valueOf(bi.bH(this.gSz))});
            if (this.gSu <= 83886080 && this.gSx.size() <= 80) {
                return false;
            }
            are();
            return true;
        }

        public final void are() {
            this.gSv = "MSG_" + this.gSx.size() + "_" + this.talker + "_" + bi.VF();
            x.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[]{Long.valueOf(this.gRJ), Long.valueOf(this.gRK), Long.valueOf(this.gSu), Integer.valueOf(this.gSx.size()), Integer.valueOf(this.gSy.size()), this.gSv, Long.valueOf(bi.bH(this.gSz))});
            if (this.gSx.size() > 0) {
                f(this.gSv, null, false);
                if (this.gSy.isEmpty()) {
                    this.gSs.offer(this.gSC);
                    return;
                } else {
                    this.gSs.offer(this.gSB);
                    return;
                }
            }
            x.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[]{Integer.valueOf(this.gSx.size()), Integer.valueOf(this.gSw.size()), Integer.valueOf(this.gSy.size())});
            Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.gSx.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.gSw.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.gSy.isEmpty());
            this.gSs.offer(this.gSC);
        }

        final void f(String str, String str2, boolean z) {
            boolean z2 = true;
            com.tencent.mm.plugin.backup.f.c.c 2 = new 2(this);
            x.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.gSx.size()), str, str2});
            if (TextUtils.isEmpty(str2)) {
                String str3 = "chatMsgList should not empty";
                if (this.gSx.isEmpty()) {
                    z2 = false;
                }
                Assert.assertTrue(str3, z2);
                if (str != null) {
                    com.tencent.mm.plugin.backup.f.c.a(this.gSA, 2, str, new LinkedList(this.gSx), c.this.gSi.gRA);
                    return;
                }
                return;
            }
            this.gSw.add(str);
            if (str != null) {
                com.tencent.mm.plugin.backup.f.c.a(this.gSA, 2, str, str2, c.this.gSi.gRA);
            }
        }
    }

    public c(d dVar, int i, com.tencent.mm.plugin.backup.a.b.b bVar) {
        this.gSi = dVar;
        this.gRy = i;
        this.gSh = bVar;
        this.gSg = false;
    }

    public final void cancel() {
        x.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", new Object[]{aj.cin()});
        this.gSg = true;
    }

    public final long arc() {
        return this.gSj / 1024;
    }

    public final void dt(boolean z) {
        x.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
        if (this.gRy == 1) {
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sUY, Boolean.valueOf(false));
        } else if (this.gRy == 2) {
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sVb, Boolean.valueOf(false));
        }
        Editor edit = d.aqU().edit();
        edit.putString("BACKUP_PC_CHOOSE_SESSION", null);
        if (z) {
            if (this.gRy == 1) {
                edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
            } else if (this.gRy == 2) {
                edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
                edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
                edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
                edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
            }
        }
        edit.commit();
    }

    public final void ard() {
        x.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
        com.tencent.mm.plugin.backup.h.d dVar = new com.tencent.mm.plugin.backup.h.d();
        dVar.ID = this.gSi.gRu;
        try {
            com.tencent.mm.plugin.backup.f.b.J(dVar.toByteArray(), 8);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "BackupFinishRequest to buf err.", new Object[0]);
        }
    }

    public final void a(LinkedList<f.a> linkedList, long j, boolean z) {
        String str = "MicroMsg.BackupPackAndSend";
        String str2 = "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Long.valueOf(j);
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        e.d(new 1(this, linkedList, j, z), "backupPackThread", 10).start();
    }

    final boolean a(f.a aVar, c cVar, String str, long j, boolean z) {
        ey a;
        long VF;
        Throwable e;
        String str2;
        String str3;
        Object[] objArr;
        ai Yq = com.tencent.mm.plugin.backup.g.d.asG().asH().FW().Yq(aVar.gRG);
        x.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg index[%d], sessionName[%s], startTime[%d], endTime[%d], unReadCount[%d]", new Object[]{Integer.valueOf(aVar.gRH), aVar.gRG, Long.valueOf(aVar.startTime), Long.valueOf(aVar.endTime), Integer.valueOf(Yq != null ? Yq.field_unReadCount : 0)});
        long VF2 = bi.VF();
        int i = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = r2;
        while (true) {
            LinkedList linkedList = new LinkedList();
            long VF3 = j4 - bi.VF();
            Cursor b = com.tencent.mm.plugin.backup.g.d.asG().asH().FT().b(aVar.gRG, aVar.startTime, aVar.endTime, i);
            int i3 = i;
            while (b.moveToNext()) {
                i3++;
                if (this.gSg) {
                    b.close();
                    return false;
                }
                bd bdVar = new bd();
                bdVar.d(b);
                if (!z || bdVar.getType() == 1) {
                    linkedList.add(bdVar);
                }
            }
            b.close();
            j4 = VF3 + bi.VF();
            if (linkedList.size() != 0) {
                int i4 = 0;
                VF3 = j2;
                int i5 = i2;
                while (i4 < linkedList.size()) {
                    bd bdVar2 = (bd) linkedList.get(i4);
                    PLong pLong = new PLong();
                    LinkedList linkedList2 = new LinkedList();
                    HashMap hashMap = new HashMap();
                    try {
                        j3 -= bi.VF();
                        a = h.a(bdVar2, false, str, pLong, linkedList2, hashMap, i5 > 0, false, j);
                        try {
                            VF = bi.VF() + j3;
                        } catch (Exception e2) {
                            e = e2;
                            j2 = j3;
                            x.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupPackSessionMsg packedMsg", new Object[0]);
                            VF = j2;
                            str2 = "MicroMsg.BackupPackAndSend";
                            str3 = "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]";
                            objArr = new Object[8];
                            objArr[0] = Boolean.valueOf(a == null);
                            objArr[1] = Integer.valueOf(linkedList2.size());
                            objArr[2] = Long.valueOf(pLong.value);
                            objArr[3] = Integer.valueOf(hashMap.size());
                            objArr[4] = Long.valueOf(bdVar2.field_msgSvrId);
                            objArr[5] = Integer.valueOf(bdVar2.getType());
                            objArr[6] = Long.valueOf(bdVar2.field_createTime);
                            objArr[7] = bdVar2.field_talker;
                            x.i(str2, str3, objArr);
                            if (a == null) {
                                i5--;
                                long VF4 = VF3 - bi.VF();
                                j2 = pLong.value;
                                VF3 = bdVar2.field_createTime;
                                if (cVar.gSP == null) {
                                    LinkedBlockingQueue linkedBlockingQueue = cVar.gSN;
                                    b bVar = new b(cVar.gSt, aVar);
                                    cVar.gSP = bVar;
                                    linkedBlockingQueue.offer(bVar);
                                }
                                if (cVar.gSP.a(a, j2, VF3, linkedList2, hashMap)) {
                                    cVar.gSP = null;
                                }
                                VF3 = VF4 + bi.VF();
                            }
                            i4++;
                            j3 = VF;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        a = null;
                        j2 = j3;
                        x.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupPackSessionMsg packedMsg", new Object[0]);
                        VF = j2;
                        str2 = "MicroMsg.BackupPackAndSend";
                        str3 = "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]";
                        objArr = new Object[8];
                        if (a == null) {
                        }
                        objArr[0] = Boolean.valueOf(a == null);
                        objArr[1] = Integer.valueOf(linkedList2.size());
                        objArr[2] = Long.valueOf(pLong.value);
                        objArr[3] = Integer.valueOf(hashMap.size());
                        objArr[4] = Long.valueOf(bdVar2.field_msgSvrId);
                        objArr[5] = Integer.valueOf(bdVar2.getType());
                        objArr[6] = Long.valueOf(bdVar2.field_createTime);
                        objArr[7] = bdVar2.field_talker;
                        x.i(str2, str3, objArr);
                        if (a == null) {
                            i5--;
                            long VF42 = VF3 - bi.VF();
                            j2 = pLong.value;
                            VF3 = bdVar2.field_createTime;
                            if (cVar.gSP == null) {
                                LinkedBlockingQueue linkedBlockingQueue2 = cVar.gSN;
                                b bVar2 = new b(cVar.gSt, aVar);
                                cVar.gSP = bVar2;
                                linkedBlockingQueue2.offer(bVar2);
                            }
                            if (cVar.gSP.a(a, j2, VF3, linkedList2, hashMap)) {
                                cVar.gSP = null;
                            }
                            VF3 = VF42 + bi.VF();
                        }
                        i4++;
                        j3 = VF;
                    }
                    str2 = "MicroMsg.BackupPackAndSend";
                    str3 = "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]";
                    objArr = new Object[8];
                    if (a == null) {
                    }
                    objArr[0] = Boolean.valueOf(a == null);
                    objArr[1] = Integer.valueOf(linkedList2.size());
                    objArr[2] = Long.valueOf(pLong.value);
                    objArr[3] = Integer.valueOf(hashMap.size());
                    objArr[4] = Long.valueOf(bdVar2.field_msgSvrId);
                    objArr[5] = Integer.valueOf(bdVar2.getType());
                    objArr[6] = Long.valueOf(bdVar2.field_createTime);
                    objArr[7] = bdVar2.field_talker;
                    x.i(str2, str3, objArr);
                    if (a == null) {
                        i5--;
                        long VF422 = VF3 - bi.VF();
                        j2 = pLong.value;
                        VF3 = bdVar2.field_createTime;
                        if (cVar.gSP == null) {
                            LinkedBlockingQueue linkedBlockingQueue22 = cVar.gSN;
                            b bVar22 = new b(cVar.gSt, aVar);
                            cVar.gSP = bVar22;
                            linkedBlockingQueue22.offer(bVar22);
                        }
                        if (cVar.gSP.a(a, j2, VF3, linkedList2, hashMap)) {
                            cVar.gSP = null;
                        }
                        VF3 = VF422 + bi.VF();
                    }
                    i4++;
                    j3 = VF;
                }
                j2 = VF3;
                i = i3;
                i2 = i5;
            } else {
                long VF5 = j2 - bi.VF();
                if (cVar.gSP == null) {
                    LinkedBlockingQueue linkedBlockingQueue3 = cVar.gSN;
                    b bVar3 = new b(cVar.gSt, aVar);
                    cVar.gSP = bVar3;
                    linkedBlockingQueue3.offer(bVar3);
                }
                cVar.gSP.are();
                cVar.gSP = null;
                VF5 += bi.VF();
                x.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", new Object[]{Integer.valueOf(aVar.gRH), aVar.gRG, Integer.valueOf(i3), Long.valueOf(bi.bH(VF2)), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(VF5)});
                return true;
            }
        }
    }
}
