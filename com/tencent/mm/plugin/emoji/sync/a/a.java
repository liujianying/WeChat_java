package com.tencent.mm.plugin.emoji.sync.a;

import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.security.Key;
import java.util.Arrays;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a extends d {
    private EmojiInfo gZe;
    private String iiH;
    private String iiI;
    private String iil;
    private e ijL;
    private String ijM;
    private String ijN;
    private String ijO;
    private String ijP;
    private String ijQ;
    private com.tencent.mm.plugin.emoji.d.a ijR;
    private com.tencent.mm.ak.a.b.a ijS;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (bi.oW(str)) {
            x.e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
        }
        this.ijM = str;
        this.ijN = str2;
        this.ijO = str3;
        this.iiH = str4;
        this.ijP = str5;
        this.ijQ = str6;
        this.iil = str7;
        this.iiI = str8;
        this.gZe = i.aEA().igx.Zy(this.ijM);
        if (this.gZe == null) {
            this.gZe = new EmojiInfo();
            this.gZe.field_md5 = this.ijM;
            this.gZe.field_cdnUrl = this.ijN;
            this.gZe.field_thumbUrl = this.ijO;
            this.gZe.field_designerID = this.iiH;
            this.gZe.field_encrypturl = this.ijP;
            this.gZe.field_aeskey = this.ijQ;
            this.gZe.field_groupId = this.iil;
        }
        if (bi.oW(this.ijN)) {
            this.ijN = this.gZe.field_cdnUrl;
        } else {
            this.gZe.field_cdnUrl = this.ijN;
        }
        if (bi.oW(this.ijP)) {
            this.ijP = this.gZe.field_encrypturl;
            this.ijQ = this.gZe.field_aeskey;
        } else {
            this.gZe.field_encrypturl = this.ijP;
            this.gZe.field_aeskey = this.ijQ;
        }
        if (!bi.oW(this.iiH)) {
            this.gZe.field_designerID = this.iiH;
        }
        if (!bi.oW(this.iil)) {
            this.gZe.field_groupId = this.iil;
        }
        if (!bi.oW(this.ijO)) {
            this.gZe.field_thumbUrl = this.ijO;
        }
        if (!bi.oW(this.iiI)) {
            this.gZe.field_activityid = this.iiI;
        }
        this.ijR = new com.tencent.mm.plugin.emoji.d.a();
        this.ijS = new com.tencent.mm.ak.a.b.a();
    }

    public final void run() {
        String str;
        if (this.ijL != null) {
            this.ijL.zI(this.ijM);
        } else {
            x.w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
        }
        x.i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", new Object[]{this.gZe.Xh(), this.gZe.field_cdnUrl, this.gZe.field_thumbUrl, this.gZe.field_designerID, this.gZe.field_encrypturl, this.gZe.field_groupId});
        if (bi.oW(this.ijN) && bi.oW(this.ijP)) {
            h.mEJ.a(164, 10, 1, false);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.ijM);
            au.DF().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
            aFb();
        } else {
            boolean z;
            str = this.ijN;
            if (bi.oW(this.ijP) || bi.oW(this.ijQ)) {
                z = false;
            } else {
                str = this.ijP;
                z = true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b mb = this.ijR.mb(str);
            if (mb == null || bi.bC(mb.data)) {
                x.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                aFb();
            } else {
                x.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                byte[] bArr = mb.data;
                if (z) {
                    try {
                        byte[] bArr2 = mb.data;
                        byte[] decode = Base64.decode(Base64.encodeToString(bi.WP(this.ijQ), 0).getBytes(), 0);
                        Key secretKeySpec = new SecretKeySpec(decode, "AES");
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
                        bArr = instance.doFinal(bArr2);
                    } catch (Throwable e) {
                        x.w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", new Object[]{bi.i(e)});
                    }
                }
                Bitmap decodeByteArray = c.decodeByteArray(bArr, 10, 10);
                boolean a = this.ijS.a(str, bArr, f.o(this.gZe.cnF(), new Object[0]));
                File file = new File(this.gZe.cnF());
                if (decodeByteArray != null && a && file.exists()) {
                    str = g.m(file);
                    if (bi.oW(str) || !str.equalsIgnoreCase(this.gZe.Xh())) {
                        if (file.exists()) {
                            file.delete();
                        }
                        aFb();
                        if (z) {
                            com.tencent.mm.plugin.emoji.c.cA(8);
                            com.tencent.mm.plugin.emoji.c.a(this.ijM, 3, 0, 1, this.iil, 1, this.iiH);
                        } else {
                            com.tencent.mm.plugin.emoji.c.cA(5);
                            com.tencent.mm.plugin.emoji.c.a(this.ijM, 2, 0, 1, this.iil, 1, this.iiH);
                        }
                    } else {
                        this.gZe.field_size = bArr.length;
                        this.gZe.field_state = EmojiInfo.tcP;
                        this.gZe.field_temp = 0;
                        this.gZe.field_catalog = EmojiInfo.tcH;
                        this.gZe.field_type = EmojiLogic.ak(bArr);
                        int cnM = i.aEA().igx.cnM();
                        this.gZe.field_idx = cnM < n.aEj() ? n.aEj() : cnM + 1;
                        i.aEA().igx.p(this.gZe);
                        com.tencent.mm.storage.emotion.a aVar = i.aEA().igy;
                        if (!com.tencent.mm.storage.emotion.a.cnl()) {
                            i.aEA().igy.cnm();
                        }
                        cs csVar = new cs();
                        csVar.bKf.bKg = this.ijM;
                        csVar.bKf.bIH = 0;
                        csVar.bKf.success = true;
                        com.tencent.mm.sdk.b.a.sFg.m(csVar);
                        if (z) {
                            com.tencent.mm.plugin.emoji.c.cA(7);
                            com.tencent.mm.plugin.emoji.c.cA(4);
                            com.tencent.mm.plugin.emoji.c.a(this.ijM, 3, 0, 0, this.iil, 0, this.iiH);
                        } else {
                            com.tencent.mm.plugin.emoji.c.cA(2);
                            com.tencent.mm.plugin.emoji.c.cA(4);
                            com.tencent.mm.plugin.emoji.c.a(this.ijM, 2, 0, 0, this.iil, 1, this.iiH);
                        }
                        com.tencent.mm.plugin.emoji.e.e.aDM().c(this.gZe, true);
                    }
                } else {
                    aFb();
                    if (z) {
                        com.tencent.mm.plugin.emoji.c.cA(8);
                        com.tencent.mm.plugin.emoji.c.a(this.ijM, 3, 0, 1, this.iil, 1, this.iiH);
                    } else {
                        com.tencent.mm.plugin.emoji.c.cA(3);
                        com.tencent.mm.plugin.emoji.c.a(this.ijM, 2, 1, 1, this.iil, 1, this.iiH);
                    }
                }
            }
        }
        if (!bi.oW(this.gZe.field_thumbUrl)) {
            b mb2 = this.ijR.mb(this.gZe.field_thumbUrl);
            if (mb2 != null) {
                com.tencent.mm.ak.a.b.a aVar2 = this.ijS;
                str = this.gZe.field_thumbUrl;
                byte[] bArr3 = mb2.data;
                String str2 = this.gZe.field_thumbUrl;
                aVar2.a(str, bArr3, f.o(this.gZe.cnF() + "_cover", new Object[0]));
            }
        }
    }

    private void aFb() {
        x.i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
        cs csVar = new cs();
        csVar.bKf.bKg = this.ijM;
        csVar.bKf.bIH = 0;
        csVar.bKf.success = false;
        com.tencent.mm.sdk.b.a.sFg.m(csVar);
        if (this.gZe != null) {
            x.i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", new Object[]{this.gZe.Xh()});
            this.gZe.field_state = EmojiInfo.tcQ;
            this.gZe.field_catalog = EmojiInfo.tcB;
            i.aEA().igx.p(this.gZe);
        }
    }

    public final String getKey() {
        return this.ijM;
    }

    public final void a(e eVar) {
        this.ijL = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (!(bi.oW(this.ijM) || bi.oW(aVar.ijM) || !this.ijM.equals(aVar.ijM))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
