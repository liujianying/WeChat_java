package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.w;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

class GameIndexListView$2 implements a {
    final /* synthetic */ GameIndexListView jYS;

    GameIndexListView$2(GameIndexListView gameIndexListView) {
        this.jYS = gameIndexListView;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            Collection collection;
            GameIndexListView.a(this.jYS, (bb) bVar.dIE.dIL);
            bb b = GameIndexListView.b(this.jYS);
            boolean c = GameIndexListView.c(this.jYS);
            if (b == null || bi.cX(b.jRH)) {
                collection = null;
            } else {
                LinkedList linkedList = new LinkedList();
                if (c && !bi.oW(b.jPB)) {
                    e eVar = new e();
                    eVar.type = 2000;
                    eVar.jLy = b.jPB;
                    linkedList.add(eVar);
                }
                Iterator it = b.jRH.iterator();
                while (it.hasNext()) {
                    ac acVar = (ac) it.next();
                    e eVar2;
                    if (acVar.jPF != 7) {
                        eVar2 = new e();
                        eVar2.type = acVar.jPF;
                        eVar2.position = acVar.jPC;
                        eVar2.jLz = acVar;
                        linkedList.add(eVar2);
                    } else if (!(acVar.jQx == null || bi.cX(acVar.jQx.jPz))) {
                        if (!bi.oW(acVar.jQx.bHD)) {
                            eVar2 = new e();
                            eVar2.jLz = acVar;
                            eVar2.type = BaseReportManager.MAX_READ_COUNT;
                            linkedList.add(eVar2);
                        }
                        Iterator it2 = acVar.jQx.jPz.iterator();
                        while (it2.hasNext()) {
                            w wVar = (w) it2.next();
                            e eVar3 = new e();
                            eVar3.jLz = acVar;
                            eVar3.type = 1001;
                            eVar3.jLA = acVar.jQx.jPz.indexOf(wVar);
                            linkedList.add(eVar3);
                        }
                        eVar2 = new e();
                        eVar2.jLz = acVar;
                        eVar2.type = 1002;
                        linkedList.add(eVar2);
                    }
                }
                Object collection2 = linkedList;
            }
            GameIndexListView.d(this.jYS);
            ai.a(GameIndexListView.b(this.jYS));
            if (!GameIndexListView.b(this.jYS).jRJ) {
                this.jYS.ds(false);
            }
            if (!bi.cX(collection2)) {
                GameIndexListView$b e = GameIndexListView.e(this.jYS);
                e.jYT.addAll(collection2);
                e.RR.notifyChanged();
            }
        }
        return 0;
    }
}
