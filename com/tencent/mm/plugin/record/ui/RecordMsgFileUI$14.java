package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.List;

class RecordMsgFileUI$14 implements Runnable {
    final /* synthetic */ Runnable bzs;
    final /* synthetic */ String jal;
    final /* synthetic */ RecordMsgFileUI mtg;
    final /* synthetic */ List mth;

    RecordMsgFileUI$14(RecordMsgFileUI recordMsgFileUI, List list, String str, Runnable runnable) {
        this.mtg = recordMsgFileUI;
        this.mth = list;
        this.jal = str;
        this.bzs = runnable;
    }

    public final void run() {
        File file = new File(h.c(RecordMsgFileUI.a(this.mtg), RecordMsgFileUI.b(this.mtg)));
        for (String str : this.mth) {
            if (file.exists()) {
                String m = RecordMsgFileUI.m(this.mtg);
                x.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), m});
                if (RecordMsgFileUI.c(this.mtg) == 15) {
                    g.bcT().a(this.mtg.mController.tml, str, file.getAbsolutePath(), m, 62, RecordMsgFileUI.a(this.mtg).duration, "");
                } else {
                    g.bcT().a(this.mtg.mController.tml, str, file.getAbsolutePath(), m, 1, RecordMsgFileUI.a(this.mtg).duration, "");
                }
            } else {
                String str2 = RecordMsgFileUI.a(this.mtg).rzv;
                if (!bi.oW(str2)) {
                    WXVideoObject wXVideoObject = new WXVideoObject();
                    wXVideoObject.videoUrl = str2;
                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
                    str2 = bi.aG(RecordMsgFileUI.a(this.mtg).title, this.mtg.mController.tml.getResources().getString(R.l.favorite_video));
                    wXMediaMessage.mediaObject = wXVideoObject;
                    wXMediaMessage.title = str2;
                    wXMediaMessage.description = RecordMsgFileUI.a(this.mtg).desc;
                    wXMediaMessage.thumbData = bi.readFromFile(h.f(RecordMsgFileUI.a(this.mtg), RecordMsgFileUI.b(this.mtg)));
                    if (wXMediaMessage.thumbData == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        au.HU();
                        wXMediaMessage.thumbData = bi.readFromFile(stringBuilder.append(c.Gm()).append("web/").append(com.tencent.mm.a.g.u(bi.aG(RecordMsgFileUI.a(this.mtg).bJv, "").getBytes())).toString());
                    }
                    l.a(wXMediaMessage, "", "", str, 3, null);
                }
            }
            g.bcT().dF(this.jal, str);
        }
        ah.A(this.bzs);
    }

    public final String toString() {
        return super.toString() + "|onActivityResult1";
    }
}
