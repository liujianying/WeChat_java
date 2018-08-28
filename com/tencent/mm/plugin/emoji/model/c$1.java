package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.a;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.a.c.c;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;

class c$1 implements c {
    final /* synthetic */ c ihd;

    c$1(c cVar) {
        this.ihd = cVar;
    }

    public final void a(boolean z, Object... objArr) {
        if (objArr == null || objArr.length < 2) {
            x.w("MicroMsg.emoji.EmojiAppMsgDownloadService", "extra obj error");
            return;
        }
        ta taVar;
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        if (objArr[0] instanceof ta) {
            taVar = (ta) objArr[0];
        } else {
            taVar = null;
        }
        if (taVar == null) {
            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msginfo or  emojiInfo");
        } else if (z) {
            au.HU();
            String L = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", taVar.rwk);
            String str = L + "_encrypt";
            if (booleanValue) {
                boolean z2 = false;
                if (e.cm(str) > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        z2 = a.h(Base64.encodeToString(bi.WP(taVar.rwn), 0), str, L);
                        if (z2) {
                            com.tencent.mm.plugin.emoji.c.cA(7);
                        } else {
                            com.tencent.mm.plugin.emoji.c.cA(8);
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", new Object[]{bi.i(e)});
                        com.tencent.mm.plugin.emoji.c.cA(8);
                    }
                    x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    if (z2) {
                        e.deleteFile(str);
                    } else {
                        String str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                        String str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                        Object[] objArr2 = new Object[5];
                        objArr2[0] = taVar.rwk;
                        objArr2[1] = Integer.valueOf(e.cm(str));
                        objArr2[2] = g.cu(str) == null ? "" : g.cu(str);
                        objArr2[3] = taVar.rwn;
                        objArr2[4] = taVar.rwm;
                        x.i(str2, str3, objArr2);
                        com.tencent.mm.plugin.emoji.c.a(taVar.rwk, 3, 0, 1, "", 1, "");
                        e.deleteFile(str);
                        c.bi(taVar.rwk, 2);
                        return;
                    }
                }
                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", new Object[]{taVar.rwk});
                com.tencent.mm.plugin.emoji.c.a(taVar.rwk, 3, 1, 1, "", 1, "");
                c.bi(taVar.rwk, 2);
                return;
            }
            File file = new File(L);
            int cm = e.cm(L);
            byte[] e2 = e.e(L, 0, 10);
            if (cm <= 0 || e2 == null) {
                c.a(taVar, booleanValue);
                return;
            }
            String m = g.m(file);
            if (bi.oW(m) || !m.equalsIgnoreCase(taVar.rwk)) {
                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s", new Object[]{m, taVar.rwk, taVar.jPK});
                file.delete();
                c.bi(taVar.rwk, 2);
                if (booleanValue) {
                    com.tencent.mm.plugin.emoji.c.cA(5);
                    com.tencent.mm.plugin.emoji.c.a(taVar.rwk, 3, 0, 1, "", 1, "");
                    return;
                }
                com.tencent.mm.plugin.emoji.c.cA(5);
                com.tencent.mm.plugin.emoji.c.a(taVar.rwk, 2, 0, 1, "", 1, "");
                return;
            }
            if (booleanValue) {
                com.tencent.mm.plugin.emoji.c.cA(4);
                com.tencent.mm.plugin.emoji.c.a(taVar.rwk, 3, 0, 0, "", 0, "");
            } else {
                com.tencent.mm.plugin.emoji.c.cA(4);
                com.tencent.mm.plugin.emoji.c.a(taVar.rwk, 2, 0, 0, "", 1, "");
            }
            int i = EmojiInfo.tcM;
            if (o.bv(e2)) {
                i = EmojiInfo.tcL;
            } else {
                i = EmojiInfo.tcM;
            }
            EmojiInfo Zy = i.aEA().igx.Zy(m);
            if (Zy == null) {
                Zy = new EmojiInfo();
                Zy.field_md5 = m;
                Zy.field_catalog = EmojiInfo.tcB;
                Zy.field_size = e.cm(L);
            }
            Zy.field_type = i;
            Zy.field_state = EmojiInfo.tcP;
            i.aEA().igx.p(Zy);
            c.bi(taVar.rwk, 1);
            EmojiLogic.a(ad.getContext(), null, Zy.Xh(), Zy.mcn, Zy);
        } else {
            c.a(taVar, booleanValue);
        }
    }
}
