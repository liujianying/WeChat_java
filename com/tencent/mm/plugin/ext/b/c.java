package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.api.h;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static Map<String, a> iJu = null;
    final e diJ = new 1(this);
    private String iJs = "";
    private boolean iJt = false;
    private Context mContext = null;

    class a {
        bja iJw = null;
        biy iJx = null;
        String userName = "";

        public a(String str, bja bja, biy biy) {
            this.userName = str;
            this.iJw = bja;
            this.iJx = biy;
        }
    }

    public c(Context context, String str) {
        this.mContext = context;
        this.iJs = str;
        this.iJt = true;
    }

    public final int aIS() {
        if (this.mContext == null) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
            return -1;
        } else if (bi.oW(this.iJs)) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
            return -1;
        } else {
            String Ww = ap.Ww(this.iJs);
            if (bi.oW(Ww)) {
                x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
                return -1;
            }
            a aVar;
            String str = this.iJs;
            if (bi.oW(str)) {
                x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
                aVar = null;
            } else {
                if (iJu == null) {
                    iJu = new HashMap();
                }
                aVar = (a) iJu.get(str);
            }
            if (aVar != null) {
                x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
                return a(aVar.userName, aVar.iJw, aVar.iJx);
            }
            hb hbVar = new hb();
            hbVar.bQl.bQn = Ww;
            com.tencent.mm.sdk.b.a.sFg.m(hbVar);
            str = hbVar.bQm.userName;
            if (bi.oW(str)) {
                x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
                au.DF().a(i$l.AppCompatTheme_ratingBarStyle, this.diJ);
                au.DF().a(new f(Ww, 3), 0);
                Intent intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
                intent.setFlags(268435456);
                this.mContext.startActivity(intent);
                return 2;
            }
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[]{str});
            return a(str, null, null);
        }
    }

    private static void a(String str, a aVar) {
        if (bi.oW(str)) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
            return;
        }
        if (iJu == null) {
            iJu = new HashMap();
        }
        iJu.put(str, aVar);
    }

    private int a(String str, bja bja, biy biy) {
        if (this.mContext == null) {
            x.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
            return -1;
        }
        if (!bi.oW(str)) {
            au.HU();
            if (com.tencent.mm.model.c.FR().Yc(str)) {
                x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
                AH(str);
                return 0;
            }
        }
        if (bja != null) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
            a(bja);
            return 1;
        } else if (biy != null) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
            a(biy);
            return 1;
        } else {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
            return -1;
        }
    }

    private void AH(String str) {
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", false);
        d.e(this.mContext, ".ui.chatting.ChattingUI", intent);
    }

    private void a(bja bja) {
        if (bja == null) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
            return;
        }
        String a = ab.a(bja.rvi);
        if (bi.oW(a)) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            return;
        }
        a(this.iJs, new a(ab.a(bja.rvi), bja, null));
        au.HU();
        if (com.tencent.mm.model.c.FR().Yc(a)) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
            AH(a);
            return;
        }
        Intent intent = new Intent();
        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, bja, 15);
        intent.putExtra("add_more_friend_search_scene", 2);
        com.tencent.mm.plugin.ext.a.ezn.d(intent, this.mContext);
    }

    private void a(biy biy) {
        if (biy == null) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
            return;
        }
        String a = ab.a(biy.rvi);
        if (bi.oW(a)) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            return;
        }
        a(this.iJs, new a(ab.a(biy.rvi), null, biy));
        au.HU();
        if (com.tencent.mm.model.c.FR().Yc(a)) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
            AH(a);
            return;
        }
        Intent intent = new Intent();
        ((h) g.l(h.class)).a(intent, biy, 15);
        intent.putExtra("add_more_friend_search_scene", 2);
        com.tencent.mm.plugin.ext.a.ezn.d(intent, this.mContext);
    }
}
