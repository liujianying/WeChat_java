package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    private static final c ifu;

    public static c cr(String str, String str2) {
        return c(str, str2, new Object[0]);
    }

    public static c c(String str, String str2, Object... objArr) {
        au.HU();
        String K = EmojiLogic.K(com.tencent.mm.model.c.Gg(), str, str2);
        if (bi.oW(K)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.dXw = true;
        aVar.dXy = true;
        aVar.dXA = K;
        aVar.dYc = objArr;
        return aVar.Pt();
    }

    public static c r(String str, String str2, int i) {
        au.HU();
        String K = EmojiLogic.K(com.tencent.mm.model.c.Gg(), str, str2);
        if (bi.oW(K)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.dXw = true;
        aVar.dXy = true;
        aVar.dXA = K;
        aVar.dXF = i;
        aVar.dXE = i;
        return aVar.Pt();
    }

    public static c aDO() {
        a aVar = new a();
        aVar.dXw = true;
        aVar.dXy = false;
        aVar.dXD = 3;
        return aVar.Pt();
    }

    public static c g(String str, String str2, Object... objArr) {
        au.HU();
        String Gq = com.tencent.mm.model.c.Gq();
        au.HU();
        String K = EmojiLogic.K(com.tencent.mm.model.c.Gg(), str, str2);
        if (bi.oW(K)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.dXw = true;
        aVar.dXy = true;
        aVar.dXA = K;
        aVar.dXB = Gq;
        aVar.dYc = objArr;
        return aVar.Pt();
    }

    static {
        a aVar = new a();
        aVar.dXw = true;
        aVar.dXD = 1;
        aVar.dXV = false;
        ifu = aVar.Pt();
    }

    public static c o(String str, Object... objArr) {
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.dXy = true;
        aVar.dXA = str;
        aVar.dYc = objArr;
        return aVar.Pt();
    }

    public static c p(String str, Object... objArr) {
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.dXy = true;
        aVar.dXA = str;
        aVar.dXZ = false;
        aVar.dYc = objArr;
        return aVar.Pt();
    }

    public static c a(String str, int i, Object... objArr) {
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.dXy = true;
        aVar.dXA = str;
        aVar.dXF = i;
        aVar.dXE = i;
        aVar.dYc = objArr;
        return aVar.Pt();
    }

    public static c cs(String str, String str2) {
        au.HU();
        String K = EmojiLogic.K(com.tencent.mm.model.c.Gg(), str, str2);
        if (bi.oW(K)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.dXw = true;
        aVar.dXy = true;
        aVar.dXA = K;
        aVar.dXW = true;
        return aVar.Pt();
    }

    public static c ct(String str, String str2) {
        au.HU();
        String K = EmojiLogic.K(com.tencent.mm.model.c.Gg(), str, str2);
        if (bi.oW(K)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.dXw = true;
        aVar.dXy = true;
        aVar.dXA = K;
        aVar.dXW = false;
        return aVar.Pt();
    }

    public static c h(String str, String str2, Object... objArr) {
        au.HU();
        String K = EmojiLogic.K(com.tencent.mm.model.c.Gg(), str, str2);
        if (bi.oW(K)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.dXw = false;
        aVar.dXy = true;
        aVar.dXA = K;
        aVar.dYc = objArr;
        return aVar.Pt();
    }

    public static c j(String str, String str2, Object... objArr) {
        au.HU();
        String K = EmojiLogic.K(com.tencent.mm.model.c.Gg(), str, str2);
        if (bi.oW(K)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.dXw = true;
        aVar.dXy = true;
        aVar.dXA = K;
        aVar.dYc = objArr;
        return aVar.Pt();
    }
}
