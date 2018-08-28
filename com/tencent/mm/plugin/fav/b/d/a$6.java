package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;

class a$6 implements a {
    final /* synthetic */ a iXG;

    a$6(a aVar) {
        this.iXG = aVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (keep_progressinfo != null) {
            x.i("MicroMsg.Fav.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", keep_progressinfo.mediaId, Integer.valueOf(keep_progressinfo.field_toltalLength), Integer.valueOf(keep_progressinfo.field_finishedLength));
        }
        String str2 = "";
        if (keep_progressinfo != null) {
            str2 = keep_progressinfo.mediaId;
        } else if (keep_sceneresult != null) {
            str2 = keep_sceneresult.mediaId;
        }
        if (i == -21006 || i == -21005) {
            this.iXG.Bw(str2);
            return 0;
        }
        if (!bi.oW(str2)) {
            str = str2;
        }
        c Br = ((ae) g.n(ae.class)).getFavCdnStorage().Br(str);
        if (Br == null) {
            x.e("MicroMsg.Fav.FavCdnService", "klem onCdnCallback info null");
            this.iXG.Bw(str);
            return 0;
        }
        if (i != 0) {
            x.w("MicroMsg.Fav.FavCdnService", "cdn transfer callback, startRet=%d", Integer.valueOf(i));
            h.mEJ.h(10660, Integer.valueOf(Br.field_type), Integer.valueOf(i));
            Br.field_status = 4;
            ((ae) g.n(ae.class)).getFavCdnStorage().a(Br, new String[0]);
            a.g(Br);
            this.iXG.Bw(str);
        } else if (keep_progressinfo != null) {
            Br.field_offset = keep_progressinfo.field_finishedLength;
            Br.field_totalLen = keep_progressinfo.field_toltalLength;
            Br.field_status = 1;
            ((ae) g.n(ae.class)).getFavCdnStorage().a(Br, new String[0]);
        } else if (keep_sceneresult != null) {
            String str3;
            if (keep_sceneresult.field_retCode >= 0) {
                Br.field_status = 3;
                if (1 == Br.field_type) {
                    str2 = Br.field_path + ".temp";
                    str3 = Br.field_path;
                    int i2 = Br.field_dataType;
                    if (!(str2 == null || str3 == null)) {
                        if (i2 == -2 && !a.Bv(str2) && a.cL(str2, str3)) {
                            x.i("MicroMsg.Fav.FavCdnService", "renameAndCopyFile write amr head ok!");
                        } else {
                            File file = new File(str2);
                            File file2 = new File(str3);
                            if (file.exists()) {
                                boolean renameTo = file.renameTo(file2);
                                x.i("MicroMsg.Fav.FavCdnService", "rename file suc:%b, old:%s, new:%s", Boolean.valueOf(renameTo), str2, file2);
                            }
                        }
                    }
                } else {
                    Br.field_cdnKey = keep_sceneresult.field_aesKey;
                    Br.field_cdnUrl = keep_sceneresult.field_fileId;
                }
                ((ae) g.n(ae.class)).getFavCdnStorage().a(Br, new String[0]);
                a.a(Br, keep_sceneresult);
                ((ae) g.n(ae.class)).getFavCdnStorage().b(Br, new String[]{"dataId"});
                this.iXG.iXA.remove(Br.field_dataId);
                x.i("MicroMsg.Fav.FavCdnService", "transfer done, mediaid=%s, md5=%s aeskey=%s completeInfo=%s", keep_sceneresult.mediaId, str, keep_sceneresult.field_aesKey, keep_sceneresult.toString());
            } else {
                x.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:%d", keep_sceneresult.mediaId, Integer.valueOf(keep_sceneresult.field_retCode));
                a.a aVar = (a.a) this.iXG.iXA.get(Br.field_dataId);
                if (aVar != null) {
                    aVar.errCode = keep_sceneresult.field_retCode;
                }
                if (-6101 != keep_sceneresult.field_retCode) {
                    switch (keep_sceneresult.field_retCode) {
                        case -5103015:
                            h.mEJ.a(141, 8, 1, true);
                            break;
                        case -21020:
                            h.mEJ.a(141, 7, 1, true);
                            break;
                        case -21014:
                            h.mEJ.a(141, 6, 1, true);
                            break;
                        case -21009:
                            h.mEJ.a(141, 5, 1, true);
                            break;
                        case -21000:
                            h.mEJ.a(141, 4, 1, true);
                            break;
                        case -10005:
                            h.mEJ.a(141, 3, 1, true);
                            break;
                        case -10003:
                            h.mEJ.a(141, 2, 1, true);
                            break;
                        default:
                            h.mEJ.a(141, 0, 1, true);
                            break;
                    }
                }
                int i3;
                Br.field_extFlag |= 1;
                h.mEJ.a(141, 1, 1, true);
                str3 = "MicroMsg.Fav.FavCdnService";
                String str4 = "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d";
                Object[] objArr = new Object[4];
                objArr[0] = keep_sceneresult.mediaId;
                if (aVar != null) {
                    i3 = aVar.ewn;
                } else {
                    i3 = 1;
                }
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = Integer.valueOf(Br.field_type);
                objArr[3] = Integer.valueOf(Br.field_dataType);
                x.e(str3, str4, objArr);
                Br.field_status = 4;
                h.mEJ.h(10660, Integer.valueOf(Br.field_type), Integer.valueOf(keep_sceneresult.field_retCode));
                ((ae) g.n(ae.class)).getFavCdnStorage().a(Br, new String[0]);
                a.g(Br);
            }
            a.a(this.iXG, str);
            h.mEJ.h(10625, Integer.valueOf(1), keep_sceneresult.field_fileId, "", keep_sceneresult.field_transInfo);
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
