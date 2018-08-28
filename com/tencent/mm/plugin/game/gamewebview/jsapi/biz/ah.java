package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.v;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.protocal.c.ccy;
import com.tencent.mm.protocal.c.ccz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import org.json.JSONObject;

public final class ah extends a {
    public static final int CTRL_BYTE = 10000;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "openWeAppPage";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiOpenWeAppPage", "invoke");
        JSONObject ti = d.ti(str);
        if (ti == null) {
            x.e("MicroMsg.GameJsApiOpenWeAppPage", "data is null");
            aVar.tp(a.f("openWeAppPage:fail_null_data", null));
            return;
        }
        String optString = ti.optString("userName");
        String optString2 = ti.optString("relativeURL");
        int optInt = ti.optInt("appVersion", 0);
        String optString3 = ti.optString("searchId");
        String optString4 = ti.optString("docId");
        int optInt2 = ti.optInt("position", 1);
        int optInt3 = ti.optInt("scene", TbsLog.TBSLOG_CODE_SDK_BASE);
        qu quVar = new qu();
        if (optInt3 == TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM) {
            quVar.cbq.scene = 1006;
        } else if (optInt3 == 3) {
            quVar.cbq.scene = 1005;
        } else if (optInt3 == 16) {
            quVar.cbq.scene = 1042;
        } else {
            quVar.cbq.scene = TbsLog.TBSLOG_CODE_SDK_BASE;
        }
        quVar.cbq.userName = optString;
        quVar.cbq.cbs = optString2;
        quVar.cbq.cbu = optInt;
        quVar.cbq.cby = false;
        optString = ti.optString("statSessionId");
        optString2 = ti.optString("statKeywordId");
        String optString5 = ti.optString("subScene");
        quVar.cbq.bGG = optString + ":" + optString2 + ":" + optString3 + ":" + optString4 + ":" + optInt2 + ":" + optString5;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
        b.a aVar2 = new b.a();
        aVar2.dIG = new ccy();
        aVar2.dIH = new ccz();
        aVar2.uri = "/cgi-bin/mmux-bin/weappsearchadclick";
        aVar2.dIF = 1873;
        b KT = aVar2.KT();
        ccy ccy = (ccy) KT.dID.dIL;
        ccy.syz = ti.optString("statSessionId");
        ccy.syA = ti.optString("statKeywordId");
        ccy.rUM = ti.optString("searchId");
        ccy.shK = ti.optString("docId");
        ccy.eIy = ti.optInt("position", 1);
        ccy.lPe = ti.optString("userName");
        ccy.syB = ti.optInt("appVersion", 0);
        ccy.syC = ti.optString("adBuffer");
        ccy.syD = ti.optString("clickExtInfo");
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.r("20StatSessionId", ccy.syz + ",");
        dVar.r("21KeywordId", ccy.syA + ",");
        dVar.r("22SearchId", ccy.rUM + ",");
        dVar.r("23DocId", ccy.shK + ",");
        dVar.r("24Pos", ccy.eIy + ",");
        dVar.r("25AppUserName", ccy.lPe + ",");
        dVar.r("26AppVersion", ccy.syB + ",");
        dVar.r("27AdBuffer", ccy.syC + ",");
        dVar.r("28AdClickBuffer", ccy.syD + ",");
        dVar.r("29scene", optInt3 + ",");
        x.i("MicroMsg.GameJsApiOpenWeAppPage", "doClickReportScene oreh" + dVar.wF());
        v.a(KT, new 1(this, dVar));
        if (quVar.cbr.cbD) {
            aVar.tp(a.f("openWeAppPage:ok", null));
        } else {
            aVar.tp(a.f("openWeAppPage:fail:" + bi.oV(quVar.cbr.cbE), null));
        }
    }
}
