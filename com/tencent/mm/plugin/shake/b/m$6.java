package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;

class m$6 extends c<js> {
    final /* synthetic */ m mXg;

    m$6(m mVar) {
        this.mXg = mVar;
        this.sFo = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        js jsVar = (js) bVar;
        if (jsVar instanceof js) {
            switch (jsVar.bTw.action) {
                case TXRecordCommon.START_RECORD_ERR_NOT_INIT /*-4*/:
                    Cursor bur = m.buC().bur();
                    jsVar.bTx.bPa = new ArrayList();
                    while (bur != null && bur.moveToNext()) {
                        d dVar = new d();
                        dVar.d(bur);
                        jsVar.bTx.bPa.add(i.c(dVar.field_lvbuffer, 0));
                    }
                    if (bur != null) {
                        bur.close();
                        break;
                    }
                    break;
                case 12:
                    jsVar.bTx.bTD = a.JC(jsVar.bTw.bTB);
                    break;
            }
        }
        return false;
    }
}
