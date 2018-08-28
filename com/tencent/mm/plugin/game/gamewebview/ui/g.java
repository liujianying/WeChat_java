package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g extends i {
    private Map<Integer, atl> jKi = new HashMap();

    public g(b bVar) {
        super(bVar);
    }

    public final void aTe() {
        if (bi.oW(getBundle().getString("game_hv_menu_appid"))) {
            super.aTe();
            return;
        }
        d dVar = new d(this.jIJ);
        dVar.a(new 1(this));
        dVar.qgF = new 2(this);
        if (this.jKc.isFullScreen()) {
            dVar.qgK = true;
            dVar.qgL = true;
        } else {
            dVar.qgK = false;
            dVar.qgL = false;
        }
        if (this.jKc.getPageView().jJb.isShown()) {
            this.jKc.getPageView().fq(false);
            ah.i(new 3(this, dVar), 100);
            return;
        }
        this.jIJ.YC();
        ah.i(new 4(this, dVar), 100);
    }

    private l aTf() {
        try {
            List list;
            List list2 = a.qgo;
            CommonLogicTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 9;
            commonLogicTask.jfZ.putString("game_hv_menu_appid", getBundle().getString("game_hv_menu_appid"));
            GameWebViewMainProcessService.b(commonLogicTask);
            String string = commonLogicTask.jfZ.getString("game_hv_menu_pbcache");
            if (!bi.oW(string)) {
                byte[] bytes = string.getBytes("ISO-8859-1");
                alt alt = new alt();
                alt.aG(bytes);
                if (!bi.cX(alt.rOg)) {
                    LinkedList linkedList = alt.rOg;
                    x.i("MicroMsg.GameWebViewMenuHelp", "use net menu data");
                    list = linkedList;
                    this.jKi.clear();
                    for (atl atl : list) {
                        this.jKi.put(Integer.valueOf(atl.rWO), atl);
                    }
                    c.bXN();
                    return c.c(this.jKc.getContext(), list);
                }
            }
            list = list2;
            this.jKi.clear();
            for (atl atl2 : list) {
                this.jKi.put(Integer.valueOf(atl2.rWO), atl2);
            }
            c.bXN();
            return c.c(this.jKc.getContext(), list);
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMenuHelp", "get cache hv game menu fail! exception:%s", e.getMessage());
            return null;
        }
    }
}
