package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.conversation.BizConversationUI.a.b;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.util.HashMap;

class BizConversationUI$a$a extends d {
    private String bVX;
    HashMap<String, b> hsb = new HashMap();

    public BizConversationUI$a$a(Context context, String str, a aVar) {
        super(context, aVar);
        this.bVX = str;
    }

    public final void WT() {
        au.HU();
        setCursor(c.FW().b(s.dAN, this.gRN, this.bVX));
        if (this.tlG != null) {
            this.tlG.Xb();
        }
        super.notifyDataSetChanged();
    }

    protected final void a(ai aiVar, boolean z, int i, boolean z2) {
        if (aiVar != null) {
            b bVar;
            b bVar2 = (b) this.hsb.get(aiVar.field_username);
            if (bVar2 == null) {
                bVar2 = new b((byte) 0);
                this.hsb.put(aiVar.field_username, bVar2);
                bVar = bVar2;
            } else {
                bVar = bVar2;
            }
            if (bVar.unB <= 0) {
                bVar.shu = z;
                boolean z3 = bVar.shx || aiVar.field_unReadCount > 0;
                bVar.shx = z3;
                bVar.jTf = i + 1;
                if (z2) {
                    bVar.unB = bVar.jTf;
                }
                bVar.shw = (int) (System.currentTimeMillis() / 1000);
                if (aiVar.field_lastSeq != bVar.slb) {
                    bVar.slb = aiVar.field_lastSeq;
                    bd GE = ((i) g.l(i.class)).bcY().GE(aiVar.field_username);
                    if (GE != null && GE.cky()) {
                        l wS = ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).wS(GE.field_content);
                        if (wS != null || (!bi.cX(wS.dzs) && !bi.oW(((m) wS.dzs.get(0)).url))) {
                            try {
                                Uri parse = Uri.parse(((m) wS.dzs.get(0)).url);
                                bVar.shs = bi.getLong(parse.getQueryParameter("mid"), 0);
                                bVar.sht = bi.getInt(parse.getQueryParameter("idx"), 0);
                            } catch (UnsupportedOperationException e) {
                                x.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[]{e.getMessage()});
                            } catch (Exception e2) {
                                x.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[]{e2.getMessage()});
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(ai aiVar, int i) {
        au.HU();
        a(aiVar, c.FW().g(aiVar), i, true);
    }
}
