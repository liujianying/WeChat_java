package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.a;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.a.c.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;

class d$3 implements c {
    final /* synthetic */ d ihl;

    d$3(d dVar) {
        this.ihl = dVar;
    }

    public final void a(boolean z, Object... objArr) {
        if (objArr == null || objArr.length < 4) {
            x.w("MicroMsg.emoji.EmojiService", "extra obj error");
            return;
        }
        ap apVar;
        EmojiInfo emojiInfo;
        int intValue = ((Integer) objArr[2]).intValue();
        if (objArr[0] instanceof ap) {
            apVar = (ap) objArr[0];
        } else {
            apVar = null;
        }
        if (objArr[1] instanceof EmojiInfo) {
            emojiInfo = (EmojiInfo) objArr[1];
        } else {
            emojiInfo = null;
        }
        if (objArr[3] instanceof Long) {
            ((Long) objArr[3]).longValue();
        }
        if (apVar == null || emojiInfo == null) {
            x.w("MicroMsg.emoji.EmojiService", "msginfo or  emojiInfo");
            return;
        }
        this.ihl.ihk.remove(apVar.bKg);
        if (emojiInfo.field_state == EmojiInfo.tcR) {
            x.d("MicroMsg.emoji.EmojiService", "first receive emoji,then update.");
            emojiInfo.field_state = EmojiInfo.tcP;
            ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().d(emojiInfo);
        }
        x.d("MicroMsg.emoji.EmojiService", "download finish %s, success %b", new Object[]{emojiInfo.Xh(), Boolean.valueOf(z)});
        if (z) {
            String str;
            Object[] objArr2;
            String cnF = emojiInfo.cnF();
            if (intValue == 102 || intValue == 101 || intValue == 103) {
                String str2;
                if (intValue == 103) {
                    str2 = cnF + "_openim";
                } else if (intValue == 101) {
                    str2 = cnF + "_extern";
                } else {
                    str2 = cnF + "_encrypt";
                }
                boolean z2 = false;
                if (e.cm(str2) > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        z2 = a.h(Base64.encodeToString(bi.WP(apVar.aeskey), 0), str2, cnF);
                        if (z2) {
                            if (intValue == 101) {
                                com.tencent.mm.plugin.emoji.c.cA(11);
                            } else {
                                com.tencent.mm.plugin.emoji.c.cA(7);
                            }
                            x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), cnF});
                            if (z2) {
                                str = "MicroMsg.emoji.EmojiService";
                                cnF = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                objArr2 = new Object[6];
                                objArr2[0] = emojiInfo == null ? "" : emojiInfo.Xh();
                                objArr2[1] = Integer.valueOf(e.cm(str2));
                                objArr2[2] = com.tencent.mm.a.g.cu(str2) == null ? "" : com.tencent.mm.a.g.cu(str2);
                                objArr2[3] = emojiInfo == null ? "" : emojiInfo.field_aeskey;
                                objArr2[4] = emojiInfo == null ? "" : emojiInfo.field_encrypturl;
                                objArr2[5] = apVar == null ? "" : apVar.tbd;
                                x.i(str, cnF, objArr2);
                                if (intValue == 101) {
                                    com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 4, 0, 1, apVar.bKk, 1, apVar.tbe);
                                } else {
                                    com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 3, 0, 1, apVar.bKk, 1, apVar.tbe);
                                }
                                e.deleteFile(str2);
                                d.a(apVar);
                                return;
                            }
                            e.deleteFile(str2);
                        } else {
                            if (intValue == 101) {
                                com.tencent.mm.plugin.emoji.c.cA(12);
                            } else {
                                com.tencent.mm.plugin.emoji.c.cA(8);
                            }
                            x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), cnF});
                            if (z2) {
                                e.deleteFile(str2);
                            } else {
                                str = "MicroMsg.emoji.EmojiService";
                                cnF = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                objArr2 = new Object[6];
                                objArr2[0] = emojiInfo == null ? "" : emojiInfo.Xh();
                                objArr2[1] = Integer.valueOf(e.cm(str2));
                                objArr2[2] = com.tencent.mm.a.g.cu(str2) == null ? "" : com.tencent.mm.a.g.cu(str2);
                                objArr2[3] = emojiInfo == null ? "" : emojiInfo.field_aeskey;
                                objArr2[4] = emojiInfo == null ? "" : emojiInfo.field_encrypturl;
                                objArr2[5] = apVar == null ? "" : apVar.tbd;
                                x.i(str, cnF, objArr2);
                                if (intValue == 101) {
                                    com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 4, 0, 1, apVar.bKk, 1, apVar.tbe);
                                } else {
                                    com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 3, 0, 1, apVar.bKk, 1, apVar.tbe);
                                }
                                e.deleteFile(str2);
                                d.a(apVar);
                                return;
                            }
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", new Object[]{bi.i(e)});
                        if (intValue == 101) {
                            com.tencent.mm.plugin.emoji.c.cA(12);
                        } else {
                            com.tencent.mm.plugin.emoji.c.cA(8);
                        }
                    }
                } else {
                    x.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", new Object[]{emojiInfo.Xh()});
                    if (intValue == 101) {
                        com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 4, 1, 1, apVar.bKk, 1, apVar.tbe);
                    } else {
                        com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 3, 1, 1, apVar.bKk, 1, apVar.tbe);
                    }
                    d.a(apVar);
                    return;
                }
            }
            File file = new File(cnF);
            if (e.cm(cnF) > 0) {
                cnF = com.tencent.mm.a.g.m(file);
                String Xh = emojiInfo.Xh();
                if (intValue == 101) {
                    Xh = emojiInfo.field_externMd5;
                }
                if (bi.oW(cnF) || !cnF.equalsIgnoreCase(Xh)) {
                    String str3 = "MicroMsg.emoji.EmojiService";
                    String str4 = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                    Object[] objArr3 = new Object[3];
                    objArr3[0] = cnF;
                    objArr3[1] = emojiInfo == null ? "" : emojiInfo.Xh();
                    objArr3[2] = emojiInfo == null ? "" : emojiInfo.field_cdnUrl;
                    x.i(str3, str4, objArr3);
                    file.delete();
                    d.a(apVar);
                    if (intValue == 101) {
                        com.tencent.mm.plugin.emoji.c.cA(14);
                        com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 4, 0, 1, apVar.bKk, 0, apVar.tbe);
                        return;
                    } else if (intValue == 102) {
                        com.tencent.mm.plugin.emoji.c.cA(5);
                        com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 3, 0, 1, apVar.bKk, 1, apVar.tbe);
                        return;
                    } else {
                        com.tencent.mm.plugin.emoji.c.cA(5);
                        com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 2, 0, 1, apVar.bKk, 1, apVar.tbe);
                        return;
                    }
                }
                if (intValue == 101) {
                    com.tencent.mm.plugin.emoji.c.cA(13);
                    com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 4, 0, 0, apVar.bKk, 0, apVar.tbe);
                } else if (intValue == 102) {
                    com.tencent.mm.plugin.emoji.c.cA(4);
                    com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 3, 0, 0, apVar.bKk, 0, apVar.tbe);
                } else {
                    com.tencent.mm.plugin.emoji.c.cA(4);
                    com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 2, 0, 0, apVar.bKk, 1, apVar.tbe);
                }
                com.tencent.mm.plugin.emoji.e.e.aDM().c(emojiInfo, true);
                if (this.ihl.ihj != null) {
                    this.ihl.ihj.h(emojiInfo);
                }
                d.a(apVar);
                return;
            }
            str = "MicroMsg.emoji.EmojiService";
            cnF = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
            objArr2 = new Object[2];
            objArr2[0] = emojiInfo == null ? "" : emojiInfo.Xh();
            objArr2[1] = emojiInfo == null ? "" : emojiInfo.field_cdnUrl;
            x.i(str, cnF, objArr2);
            if (intValue == 101) {
                com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 4, 1, 1, apVar.bKk, 1, apVar.tbe);
                com.tencent.mm.plugin.emoji.c.cA(3);
            } else {
                com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 2, 1, 1, apVar.bKk, 1, apVar.tbe);
                com.tencent.mm.plugin.emoji.c.cA(3);
            }
            d.a(apVar);
            return;
        }
        x.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s", new Object[]{emojiInfo.Xh()});
        if (intValue == 101) {
            com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 4, 1, 1, apVar.bKk, 1, apVar.tbe);
            com.tencent.mm.plugin.emoji.c.cA(3);
        } else {
            com.tencent.mm.plugin.emoji.c.a(apVar.bKg, 2, 1, 1, apVar.bKk, 1, apVar.tbe);
            com.tencent.mm.plugin.emoji.c.cA(3);
        }
        d.a(apVar);
    }
}
