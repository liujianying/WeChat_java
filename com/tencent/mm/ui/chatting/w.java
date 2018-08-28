package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.FileInputStream;
import java.io.InputStream;

public final class w implements j {
    private Context context;
    private ab guS;
    private String tJc;
    private boolean tLT = true;
    private boolean tLU = true;

    public w(Context context, ab abVar, String str) {
        this.context = context;
        this.guS = abVar;
        this.tJc = str;
        if (ab.gY(this.tJc)) {
            this.tLU = false;
        }
        if (ab.XQ(this.tJc)) {
            this.tLT = false;
        }
        if (ab.XO(this.tJc)) {
            this.tLT = false;
        }
        String str2 = (this.guS == null || !ab.gY(this.guS.field_username)) ? this.guS == null ? null : this.guS.field_username : this.tJc;
        if (s.ha(str2)) {
            this.tLU = false;
        }
    }

    public final void l(EmojiInfo emojiInfo) {
        au.HU();
        if (!c.isSDCardAvailable()) {
            com.tencent.mm.ui.base.s.gH(this.context);
        } else if (emojiInfo != null) {
            int i;
            if (this.guS.field_username.equals("medianote") && (q.GJ() & 16384) == 0) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 != 0) {
                emojiInfo.field_start = 0;
                emojiInfo.field_state = EmojiInfo.tcP;
                ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().d(emojiInfo);
                bd bdVar = new bd();
                bdVar.setType(47);
                bdVar.ep("medianote");
                bdVar.eX(1);
                if (emojiInfo.aaq()) {
                    bdVar.setContent(an.a(q.GF(), 0, false, emojiInfo.Xh(), false, ""));
                }
                bdVar.eq(emojiInfo.Xh());
                bdVar.ay(com.tencent.mm.model.bd.iD(bdVar.field_talker));
                bdVar.setStatus(2);
                au.HU();
                c.FT().T(bdVar);
                return;
            }
            ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(bi.oW(this.tJc) ? this.guS.field_username : this.tJc, emojiInfo, null);
        }
    }

    public final void m(EmojiInfo emojiInfo) {
        au.HU();
        if (c.isSDCardAvailable()) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            StringBuilder stringBuilder = new StringBuilder();
            au.HU();
            String stringBuilder2 = stringBuilder.append(c.Gg()).append(emojiInfo.Xh()).toString();
            if (e.cn(stringBuilder2 + "_thumb")) {
                wXMediaMessage.thumbData = e.e(stringBuilder2 + "_thumb", 0, e.cm(stringBuilder2 + "_thumb"));
            } else {
                try {
                    InputStream fileInputStream = new FileInputStream(stringBuilder2);
                    wXMediaMessage.setThumbImage(b.a(fileInputStream, 1.0f));
                    fileInputStream.close();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ChattingSmileyPanelImpl", e, "", new Object[0]);
                    x.e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
                }
            }
            wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
            l.a(wXMediaMessage, emojiInfo.field_app_id, null, this.tJc, 1, emojiInfo.Xh());
            return;
        }
        com.tencent.mm.ui.base.s.gH(this.context);
    }

    public final boolean bcO() {
        return this.tLU;
    }

    public final boolean bcP() {
        return this.tLT;
    }

    public final void bcQ() {
    }
}
