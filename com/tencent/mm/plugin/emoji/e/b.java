package com.tencent.mm.plugin.emoji.e;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.c.c;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class b {
    public a ieT = new a();
    public com.tencent.mm.plugin.emoji.c.b ieU = new com.tencent.mm.plugin.emoji.c.b();
    public d ieV = new d();
    public c ieW = new c();
    public com.tencent.mm.sdk.b.c ieX = new 1(this);
    public com.tencent.mm.sdk.b.c ieY = new 3(this);
    public com.tencent.mm.sdk.b.c ieZ = new 4(this);
    public com.tencent.mm.sdk.b.c ifa = new 5(this);
    public com.tencent.mm.sdk.b.c ifb = new 6(this);
    public final com.tencent.mm.sdk.b.c ifc = new com.tencent.mm.sdk.b.c<az>() {
        {
            this.sFo = az.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            a aEv = i.aEv();
            x.i("MicroMsg.emoji.EmojiDescNewMgr", "[cpan] language change Current Language:%s LastLanguage:%s", new Object[]{w.chP().toLowerCase(), aEv.ieK});
            if (!(bi.oW(aEv.ieK) || aEv.ieK.equalsIgnoreCase(r1))) {
                aEv.aDI();
            }
            i.aEA();
            l.igJ = true;
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c ifd = new 8(this);
    public com.tencent.mm.sdk.b.c ife = new com.tencent.mm.sdk.b.c<cr>() {
        {
            this.sFo = cr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cr crVar = (cr) bVar;
            if (crVar != null && (crVar instanceof cr)) {
                boolean z = crVar.bKd.bKe;
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sPf, Boolean.valueOf(z));
                i.aEB().igc = z;
                if (z) {
                    Toast.makeText(ad.getContext(), R.l.emoji_chatting_reward_tips_enable_toast, 0).show();
                } else {
                    h.mEJ.h(12953, new Object[]{Integer.valueOf(2), ""});
                    Toast.makeText(ad.getContext(), R.l.emoji_chatting_reward_tips_disable_toast, 0).show();
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c iff = new 10(this);
    public com.tencent.mm.sdk.b.c ifg = new 2(this);
}
