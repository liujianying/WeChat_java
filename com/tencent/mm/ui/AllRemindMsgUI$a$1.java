package com.tencent.mm.ui;

import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.protocal.c.ahg;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.protocal.c.wm;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.AllRemindMsgUI.a;
import com.tencent.mm.ui.AllRemindMsgUI.d;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class AllRemindMsgUI$a$1 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ a tgg;

    AllRemindMsgUI$a$1(a aVar, l lVar) {
        this.tgg = aVar;
        this.bFp = lVar;
    }

    public final void run() {
        List<bge> list = ((ahg) ((n) this.bFp).dZf.dIE.dIL).rKI;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (bge bge : list) {
                d dVar = new d(this.tgg.tgf);
                dVar.tgm = bge;
                dVar.timestamp = ((long) bge.ixe) * 1000;
                dVar.bID = bge.sdX;
                dVar.tgn = bge.shm;
                if (bge.sdX == 1) {
                    avm avm = new avm();
                    try {
                        avm.aG(bge.rvr.lR);
                    } catch (IOException e) {
                        x.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e.toString());
                    }
                    dVar.title = avm.bHD;
                    dVar.username = avm.hbL;
                    dVar.bJC = avm.rcq;
                    if (dVar.username != null) {
                        ab Yg;
                        if (s.fq(dVar.username)) {
                            String string;
                            au.HU();
                            Yg = c.FR().Yg(dVar.username);
                            if (Yg != null) {
                                dVar.nickname = Yg.BL() == null ? Yg.BK() : Yg.BL();
                            }
                            if (bi.oW(dVar.nickname)) {
                                string = this.tgg.tgf.getString(R.l.chatting_roominfo_noname);
                            } else {
                                string = dVar.nickname;
                            }
                            dVar.nickname = string;
                        } else {
                            au.HU();
                            Yg = c.FR().Yg(dVar.username);
                            dVar.nickname = Yg.BL() == null ? Yg.BK() : Yg.BL();
                        }
                    }
                } else if (bge.sdX == 2) {
                    wm wmVar = new wm();
                    try {
                        wmVar.aG(bge.rvr.lR);
                    } catch (IOException e2) {
                        x.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e2.toString());
                    }
                    dVar.title = wmVar.bHD;
                    dVar.bJt = wmVar.rcd;
                    dVar.rBf = wmVar.rce;
                }
                x.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", dVar);
                linkedList.add(dVar);
            }
            AllRemindMsgUI.a(this.tgg.tgf, linkedList);
        }
        ah.A(new 1(this));
    }
}
