package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import java.util.Iterator;

class b$8 extends ag {
    final /* synthetic */ b iJo;

    b$8(b bVar, Looper looper) {
        this.iJo = bVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            if (b.b(this.iJo).size() > 0) {
                Iterator it = b.b(this.iJo).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!"*".equals(str)) {
                        f bl = g.bl(str, false);
                        if (bl == null) {
                            x.w("MicroMsg.SubCoreExt", "appInfo is null");
                        } else if (bi.oW(bl.field_appId)) {
                            x.w("MicroMsg.SubCoreExt", "appId is null");
                        } else {
                            x.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", new Object[]{str, Integer.valueOf(bl.field_appInfoFlag), bl.field_appId});
                            bj Zf = b.aIL().Zf(bl.field_appId);
                            if (Zf == null) {
                                x.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[]{bl.field_appId});
                            } else {
                                if (g.i(bl)) {
                                    if (Zf.field_status != 1) {
                                        Zf.field_status = 1;
                                    }
                                } else if (Zf.field_status != 0) {
                                    Zf.field_status = 0;
                                }
                                bk aIL = b.aIL();
                                if (bi.oW(bl.field_appId) || Zf == null || bi.oW(Zf.field_appId)) {
                                    x.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
                                } else {
                                    int update;
                                    ContentValues wH = Zf.wH();
                                    if (wH.size() > 0) {
                                        update = aIL.diF.update("OpenMsgListener", wH, "appId=?", new String[]{bi.oU(r3)});
                                    } else {
                                        update = 0;
                                    }
                                    x.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[]{Zf.field_appId, Integer.valueOf(update)});
                                }
                            }
                        }
                    }
                }
                b.b(this.iJo).clear();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", new Object[]{e.getMessage()});
        }
    }
}
