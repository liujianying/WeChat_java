package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k implements e, c {
    boolean mrO = false;
    SparseArray<e> mrR = new SparseArray();
    LinkedList<g> mrS = new LinkedList();

    private class d implements Runnable {
        private g mrL;

        public d(g gVar) {
            this.mrL = gVar;
        }

        public final void run() {
            Iterator it = this.mrL.field_dataProto.rBI.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                String c;
                String c2;
                boolean z3;
                vx vxVar = (vx) it.next();
                if (!(bi.oW(vxVar.rzo) && bi.oW(vxVar.rAG))) {
                    c = h.c(vxVar, this.mrL.field_oriMsgId);
                    c2 = h.c(vxVar, this.mrL.field_msgId);
                    x.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[]{c, c2, Boolean.valueOf(j.q(c, c2, false))});
                    if (j.q(c, c2, false)) {
                        if (bi.oW(vxVar.rzF)) {
                            x.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
                            vxVar.UM(com.tencent.mm.a.g.cu(c2));
                            z2 = true;
                        }
                        if (bi.oW(vxVar.rzH)) {
                            x.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
                            vxVar.UN(com.tencent.mm.a.g.cv(c2));
                            z2 = true;
                        }
                    }
                    c = h.e(vxVar.jdM, this.mrL.field_msgId, false);
                    f Kr = n.getRecordMsgCDNStorage().Kr(c);
                    if (Kr == null) {
                        Kr = new f();
                        Kr.field_cdnKey = vxVar.rzq;
                        Kr.field_cdnUrl = vxVar.rzo;
                        Kr.field_dataId = vxVar.jdM;
                        Kr.field_mediaId = c;
                        Kr.field_totalLen = (int) vxVar.rzJ;
                        Kr.field_localId = Kr.field_mediaId.hashCode();
                        Kr.field_path = h.c(vxVar, this.mrL.field_msgId);
                        Kr.field_type = 2;
                        Kr.field_fileType = h.vn(vxVar.bjS);
                        Kr.field_recordLocalId = this.mrL.field_localId;
                        Kr.field_toUser = this.mrL.field_toUser;
                        Kr.field_isThumb = false;
                        String c3 = h.c(vxVar, this.mrL.field_msgId);
                        if (bi.oW(vxVar.rAG) || FileOp.cn(c3)) {
                            z = true;
                        } else {
                            Kr.field_status = -1;
                            a(vxVar, c3, c);
                        }
                        boolean b = n.getRecordMsgCDNStorage().b(Kr);
                        x.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d", new Object[]{Integer.valueOf(Kr.field_localId), Boolean.valueOf(b), Integer.valueOf(Kr.field_recordLocalId)});
                    } else {
                        if (Kr.field_status == -1) {
                            a(vxVar, h.c(vxVar, this.mrL.field_msgId), c);
                        }
                        z = Kr.field_status == 0;
                    }
                }
                if (bi.oW(vxVar.dwE) && bi.oW(vxVar.dwv)) {
                    z3 = z;
                } else {
                    boolean q = j.q(h.f(vxVar, this.mrL.field_oriMsgId), h.f(vxVar, this.mrL.field_msgId), false);
                    x.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[]{c, c2, Boolean.valueOf(q)});
                    c = h.Ba(vxVar.jdM);
                    c2 = h.e(c, this.mrL.field_msgId, false);
                    f Kr2 = n.getRecordMsgCDNStorage().Kr(c2);
                    String f = h.f(vxVar, this.mrL.field_msgId);
                    if (Kr2 == null) {
                        Kr2 = new f();
                        Kr2.field_cdnKey = vxVar.rzk;
                        Kr2.field_cdnUrl = vxVar.dwE;
                        Kr2.field_dataId = c;
                        Kr2.field_mediaId = c2;
                        Kr2.field_totalLen = (int) vxVar.rzU;
                        Kr2.field_localId = Kr2.field_mediaId.hashCode();
                        Kr2.field_path = h.f(vxVar, this.mrL.field_msgId);
                        Kr2.field_type = 2;
                        Kr2.field_fileType = b.MediaType_FULLSIZEIMAGE;
                        Kr2.field_recordLocalId = this.mrL.field_localId;
                        Kr2.field_toUser = this.mrL.field_toUser;
                        Kr2.field_isThumb = true;
                        if (bi.oW(vxVar.dwv) || FileOp.cn(f)) {
                            z3 = true;
                        } else {
                            Kr2.field_status = -1;
                            b(vxVar, f, c2);
                            z3 = z;
                        }
                        z = n.getRecordMsgCDNStorage().b(Kr2);
                        x.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d", new Object[]{Integer.valueOf(Kr2.field_localId), Boolean.valueOf(z), Integer.valueOf(Kr2.field_recordLocalId)});
                        z = z3;
                    } else {
                        if (Kr2.field_status == -1) {
                            b(vxVar, h.f(vxVar, this.mrL.field_msgId), c2);
                        }
                        if (Kr2.field_status == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    }
                }
                z = z3;
            }
            if (z2) {
                x.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[]{Integer.valueOf(this.mrL.field_localId), Long.valueOf(this.mrL.field_msgId), Integer.valueOf(this.mrL.field_type)});
                n.bqv().c(this.mrL, new String[]{"localId"});
            }
            if (z) {
                n.bqx().run();
            }
        }

        private void a(vx vxVar, String str, String str2) {
            x.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", new Object[]{vxVar.jdM, str2, str});
            i iVar = new i();
            iVar.field_fileType = 19;
            iVar.field_authKey = vxVar.dwA;
            iVar.field_aesKey = vxVar.rAD;
            iVar.dPW = vxVar.rAG;
            iVar.field_fullpath = str;
            iVar.field_mediaId = str2;
            iVar.dPV = new 1(this, vxVar, str);
            if (!com.tencent.mm.modelcdntran.g.ND().b(iVar, -1)) {
                x.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
            }
        }

        private void b(vx vxVar, String str, String str2) {
            x.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", new Object[]{vxVar.jdM, str2, str});
            i iVar = new i();
            iVar.field_fileType = 19;
            iVar.field_authKey = vxVar.dwA;
            iVar.field_aesKey = vxVar.dwB;
            iVar.dPW = vxVar.dwv;
            iVar.field_fullpath = str;
            iVar.field_mediaId = str2;
            iVar.dPV = new 2(this, vxVar, str);
            if (!com.tencent.mm.modelcdntran.g.ND().b(iVar, -1)) {
                x.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
            }
        }
    }

    public k() {
        au.DF().a(632, this);
        n.getRecordMsgCDNStorage().a(this);
    }

    public final void a(g gVar) {
        au.Em().H(new 1(this, gVar));
    }

    final void b(g gVar) {
        if (!this.mrS.contains(gVar)) {
            this.mrS.add(gVar);
        }
    }

    final void finish() {
        this.mrS.clear();
        this.mrR.clear();
        this.mrO = false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar == null) {
            x.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
            return;
        }
        switch (lVar.getType()) {
            case 632:
                vx vxVar;
                x.d("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                a aVar = (a) lVar;
                if (i == 3) {
                    Object obj;
                    Iterator it = aVar.mrL.field_dataProto.rBI.iterator();
                    while (it.hasNext()) {
                        vxVar = (vx) it.next();
                        if (bi.oW(vxVar.rzo)) {
                            if (!bi.oW(vxVar.dwE)) {
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            i = 0;
                            i2 = 0;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        i = 0;
                        i2 = 0;
                    }
                }
                if (i == 0 && i2 == 0) {
                    c(aVar.mrL.field_msgId, aVar.mrL.field_localId, aVar.mrK);
                    break;
                }
                x.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[]{Long.valueOf(aVar.mrL.field_msgId), Integer.valueOf(aVar.mrL.field_localId)});
                x.w("MicroMsg.RecordMsgSendService", "try upload from local");
                Iterator it2 = aVar.mrL.field_dataProto.rBI.iterator();
                while (it2.hasNext()) {
                    String e;
                    vxVar = (vx) it2.next();
                    if (vxVar.rzJ > 0) {
                        e = h.e(vxVar.jdM, aVar.mrL.field_msgId, false);
                        if (n.getRecordMsgCDNStorage().Kr(e) == null) {
                            f fVar = new f();
                            fVar.field_cdnKey = vxVar.rzq;
                            fVar.field_cdnUrl = vxVar.rzo;
                            fVar.field_dataId = vxVar.jdM;
                            fVar.field_mediaId = e;
                            fVar.field_totalLen = (int) vxVar.rzJ;
                            fVar.field_localId = fVar.field_mediaId.hashCode();
                            fVar.field_path = h.c(vxVar, aVar.mrL.field_msgId);
                            fVar.field_type = 2;
                            fVar.field_fileType = h.vn(vxVar.bjS);
                            fVar.field_recordLocalId = aVar.mrL.field_localId;
                            fVar.field_toUser = aVar.mrL.field_toUser;
                            fVar.field_isThumb = false;
                            boolean b = n.getRecordMsgCDNStorage().b(fVar);
                            x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(fVar.field_localId), Boolean.valueOf(b)});
                        }
                    }
                    if (vxVar.rzU > 0) {
                        e = h.Ba(vxVar.jdM);
                        String e2 = h.e(e, aVar.mrL.field_msgId, false);
                        if (n.getRecordMsgCDNStorage().Kr(e2) == null) {
                            f fVar2 = new f();
                            fVar2.field_cdnKey = vxVar.rzk;
                            fVar2.field_cdnUrl = vxVar.dwE;
                            fVar2.field_dataId = e;
                            fVar2.field_mediaId = e2;
                            fVar2.field_totalLen = (int) vxVar.rzU;
                            fVar2.field_localId = fVar2.field_mediaId.hashCode();
                            fVar2.field_path = h.f(vxVar, aVar.mrL.field_msgId);
                            fVar2.field_type = 2;
                            fVar2.field_fileType = b.MediaType_FULLSIZEIMAGE;
                            fVar2.field_recordLocalId = aVar.mrL.field_localId;
                            fVar2.field_toUser = aVar.mrL.field_toUser;
                            fVar2.field_isThumb = true;
                            boolean b2 = n.getRecordMsgCDNStorage().b(fVar2);
                            x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(fVar2.field_localId), Boolean.valueOf(b2)});
                        }
                    }
                }
                n.bqx().run();
                return;
                break;
        }
        this.mrO = false;
        a(null);
    }

    final void c(long j, int i, String str) {
        au.HU();
        bd dW = com.tencent.mm.model.c.FT().dW(j);
        if (dW.field_msgId == j) {
            dW.setContent(str);
            dW.setStatus(1);
            au.HU();
            com.tencent.mm.model.c.FT().a(j, dW);
        }
        com.tencent.mm.y.g fI = ao.cbY().fI(j);
        if (fI != null) {
            fI.field_xml = dW.field_content;
            ao.cbY().c(fI, new String[]{"msgId"});
        }
        n.bqv().vl(i);
        this.mrR.remove(i);
        ao.cca();
        a.fM(j);
        x.d("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
    }

    public final void a(int i, f fVar) {
        if (1 != i) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[]{Integer.valueOf(i)});
        } else if (fVar == null) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
        } else if (2 != fVar.field_type) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload , mediaid:%s, recordLocalId:%d, status:%d", new Object[]{fVar.field_mediaId, Integer.valueOf(fVar.field_recordLocalId), Integer.valueOf(fVar.field_status)});
        } else if (fVar.field_status == 0 || 1 == fVar.field_status || -1 == fVar.field_status) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
        } else {
            Object obj;
            List<f> vk = n.getRecordMsgCDNStorage().vk(fVar.field_recordLocalId);
            for (f fVar2 : vk) {
                if (fVar2.field_status != 0 && 1 != fVar2.field_status) {
                    if (-1 == fVar2.field_status) {
                        x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[]{fVar2.field_mediaId});
                        obj = null;
                        break;
                    }
                }
                x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[]{fVar2.field_mediaId});
                obj = null;
                break;
            }
            int obj2 = 1;
            x.d("MicroMsg.RecordMsgSendService", "on cdn storage changed cdnInfoList.size:%d,", new Object[]{Integer.valueOf(vk.size())});
            if (obj2 != null) {
                g vm = n.bqv().vm(fVar.field_recordLocalId);
                String str = "MicroMsg.RecordMsgSendService";
                String str2 = "finish get record info, id %d result %B";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(fVar.field_recordLocalId);
                objArr[1] = Boolean.valueOf(vm != null);
                x.d(str, str2, objArr);
                if (vm != null) {
                    List<vx> list = vm.field_dataProto.rBI;
                    for (f fVar22 : vk) {
                        x.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[]{fVar22.field_dataId, Boolean.valueOf(fVar22.field_isThumb)});
                        if (!fVar22.field_isThumb) {
                            for (vx vxVar : list) {
                                if (fVar22.field_dataId.equals(vxVar.jdM)) {
                                    x.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[]{vxVar.rzq, fVar22.field_cdnKey, vxVar.rzo, fVar22.field_cdnUrl, Long.valueOf(vxVar.rzJ), Integer.valueOf(fVar22.field_totalLen)});
                                    vxVar.UG(fVar22.field_cdnKey);
                                    vxVar.UF(fVar22.field_cdnUrl);
                                    break;
                                }
                            }
                        }
                        for (vx vxVar2 : list) {
                            if (fVar22.field_dataId.equals(h.Ba(vxVar2.jdM))) {
                                x.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[]{vxVar2.rzk, fVar22.field_cdnKey, vxVar2.dwE, fVar22.field_cdnUrl, Long.valueOf(vxVar2.rzU), Integer.valueOf(fVar22.field_totalLen)});
                                vxVar2.UE(fVar22.field_cdnKey);
                                vxVar2.UD(fVar22.field_cdnUrl);
                                break;
                            }
                        }
                    }
                    au.HU();
                    bd dW = com.tencent.mm.model.c.FT().dW(vm.field_msgId);
                    x.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d", new Object[]{Boolean.valueOf(false), Long.valueOf(dW.field_msgId), Long.valueOf(vm.field_msgId), Integer.valueOf(vm.field_localId)});
                    if (dW.field_msgId == vm.field_msgId) {
                        dW.setContent(h.a(vm.field_title, vm.field_desc, vm.field_dataProto, vm.field_favFrom));
                        dW.setStatus(1);
                        au.HU();
                        com.tencent.mm.model.c.FT().a(vm.field_msgId, dW);
                    }
                    com.tencent.mm.y.g fI = ao.cbY().fI(vm.field_msgId);
                    if (fI != null) {
                        fI.field_xml = dW.field_content;
                        ao.cbY().c(fI, new String[]{"msgId"});
                    }
                    n.bqv().vl(vm.field_localId);
                    this.mrR.remove(vm.field_localId);
                    ao.cca();
                    a.fM(vm.field_msgId);
                }
                for (f fVar222 : vk) {
                    n.getRecordMsgCDNStorage().a(fVar222, new String[]{"localId"});
                }
                this.mrO = false;
                a(null);
            }
        }
    }
}
