package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class e {
    public static e ifs;
    private String aAL;
    boolean bgH = false;

    public static e aDM() {
        if (ifs == null) {
            synchronized (e.class) {
                ifs = new e();
            }
        }
        return ifs;
    }

    public final String aDN() {
        if (bi.oW(this.aAL)) {
            this.aAL = i.aEA().igx.getKey();
        }
        return this.aAL;
    }

    public final boolean isEnable() {
        if (bi.oW(aDN())) {
            return false;
        }
        return true;
    }

    public final boolean c(EmojiInfo emojiInfo, boolean z) {
        if (emojiInfo == null) {
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
            return false;
        } else if (isEnable()) {
            String cnF = emojiInfo.cnF();
            if (com.tencent.mm.a.e.cn(cnF)) {
                boolean z2 = false;
                byte[] e = com.tencent.mm.a.e.e(cnF, 0, 10);
                if (e != null) {
                    try {
                        if (e.length >= 10) {
                            z2 = o.bw(e);
                        }
                    } catch (Throwable th) {
                        x.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                        z2 = false;
                    }
                }
                if (z || z2) {
                    int i;
                    long currentTimeMillis = System.currentTimeMillis();
                    int cm = com.tencent.mm.a.e.cm(cnF);
                    if (cm > 1024) {
                        i = 1024;
                    } else {
                        i = cm;
                    }
                    Object e2 = com.tencent.mm.a.e.e(cnF, 0, cm);
                    Object aesCryptEcb = AesEcb.aesCryptEcb(com.tencent.mm.a.e.e(cnF, 0, i), aDN().getBytes(), true, false);
                    if (bi.bC(aesCryptEcb) || bi.bC(e2)) {
                        i = -1;
                    } else {
                        System.arraycopy(aesCryptEcb, 0, e2, 0, i);
                        i = com.tencent.mm.a.e.b(cnF, e2, e2.length);
                    }
                    if (i == 0) {
                        h.mEJ.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                        h.mEJ.a(252, 6, 1, false);
                        emojiInfo.field_reserved4 |= EmojiInfo.tcW;
                        emojiInfo.field_size = cm;
                        i.aEA().igx.q(emojiInfo);
                        x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(e2.length), Long.valueOf(r8)});
                        return true;
                    }
                    x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                    h.mEJ.a(252, 3, 1, false);
                    return false;
                }
                x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
                return true;
            }
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", new Object[]{cnF});
            emojiInfo.field_reserved4 = 0;
            i.aEA().igx.q(emojiInfo);
            return false;
        } else {
            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
            return false;
        }
    }

    public final byte[] a(EmojiInfo emojiInfo) {
        if (emojiInfo == null) {
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            return null;
        }
        String cnF = emojiInfo.cnF();
        Object e = com.tencent.mm.a.e.e(cnF, 0, com.tencent.mm.a.e.cm(cnF));
        if (com.tencent.mm.a.e.cm(cnF) <= 0 || e == null || e.length < 10) {
            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", new Object[]{cnF});
            return null;
        }
        Object obj = new byte[10];
        System.arraycopy(e, 0, obj, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW || o.bw(obj)) {
            return e;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int cm = com.tencent.mm.a.e.cm(cnF);
        if (cm > 1024) {
            cm = 1024;
        }
        byte[] e2 = com.tencent.mm.a.e.e(cnF, 0, cm);
        Object obj2 = null;
        if (!bi.oW(aDN())) {
            obj2 = AesEcb.aesCryptEcb(e2, aDN().getBytes(), false, false);
        }
        if (bi.bC(obj2) || bi.bC(e)) {
            h.mEJ.a(252, 2, 1, false);
            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", new Object[]{cnF});
            return e;
        }
        System.arraycopy(obj2, 0, e, 0, cm);
        h.mEJ.a(252, 0, System.currentTimeMillis() - currentTimeMillis, false);
        h.mEJ.a(252, 5, 1, false);
        x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(e.length), Long.valueOf(r8)});
        return e;
    }

    public final boolean b(EmojiInfo emojiInfo) {
        int i = 1024;
        if (emojiInfo == null) {
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            return false;
        }
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        String cnF = emojiInfo.cnF();
        int cm = com.tencent.mm.a.e.cm(cnF);
        if (cm <= 1024) {
            i = cm;
        }
        Object e = com.tencent.mm.a.e.e(cnF, 0, i);
        if (com.tencent.mm.a.e.cm(cnF) > 0 && e != null && e.length >= 10) {
            Object obj = new byte[10];
            System.arraycopy(e, 0, obj, 0, 10);
            if (o.bw(obj)) {
                z = true;
            } else if ((emojiInfo.field_reserved4 & EmojiInfo.tcW) == EmojiInfo.tcW) {
                byte[] bArr = null;
                if (!bi.oW(aDN())) {
                    bArr = AesEcb.aesCryptEcb(e, aDN().getBytes(), false, false);
                }
                if (!bi.bC(bArr) && o.bw(bArr)) {
                    z = true;
                }
            }
            x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z)});
            return z;
        }
        z = false;
        x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z)});
        return z;
    }
}
