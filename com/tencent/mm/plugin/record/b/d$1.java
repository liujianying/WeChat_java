package com.tencent.mm.plugin.record.b;

import com.tencent.mm.model.au;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;

class d$1 implements a {
    final /* synthetic */ d mrW;

    d$1(d dVar) {
        this.mrW = dVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", new Object[]{Integer.valueOf(i), str});
        if (keep_progressinfo != null) {
            x.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", new Object[]{keep_progressinfo.mediaId, Integer.valueOf(keep_progressinfo.field_toltalLength), Integer.valueOf(keep_progressinfo.field_finishedLength)});
        }
        if (i == -21006 || i == -21005) {
            this.mrW.bqt();
            return 0;
        }
        f Kr = n.getRecordMsgCDNStorage().Kr(str);
        if (Kr == null) {
            x.w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", new Object[]{str});
            this.mrW.bqt();
            return 0;
        }
        if (i != 0) {
            x.w("MicroMsg.RecordMsgCDNService", "[record] tran fail, startRet[%d], mediaId[%s], type[%d]", new Object[]{Integer.valueOf(i), str, Integer.valueOf(Kr.field_type)});
            if (-5103059 == i) {
                Kr.field_status = 4;
            } else {
                Kr.field_status = 3;
            }
            Kr.field_errCode = i;
            n.getRecordMsgCDNStorage().b(Kr, new String[]{"localId"});
        } else {
            if (keep_progressinfo != null) {
                Kr.field_offset = keep_progressinfo.field_finishedLength;
                Kr.field_totalLen = keep_progressinfo.field_toltalLength;
                Kr.field_status = 1;
                n.getRecordMsgCDNStorage().b(Kr, new String[]{"localId"});
            } else if (keep_sceneresult != null) {
                String str2 = "MicroMsg.RecordMsgCDNService";
                String str3 = "[record] summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s], mediaId:%s, isDownload:%b";
                Object[] objArr = new Object[8];
                objArr[0] = Integer.valueOf(keep_sceneresult.field_retCode);
                objArr[1] = Integer.valueOf(keep_sceneresult.field_UploadHitCacheType);
                objArr[2] = Boolean.valueOf(z);
                objArr[3] = Boolean.valueOf(keep_sceneresult.field_exist_whencheck);
                objArr[4] = bi.Xf(keep_sceneresult.field_aesKey);
                objArr[5] = keep_sceneresult.field_filemd5;
                objArr[6] = str;
                objArr[7] = Boolean.valueOf(1 == Kr.field_type);
                x.i(str2, str3, objArr);
                if (keep_sceneresult.field_retCode >= 0) {
                    Kr.field_status = 2;
                    if (1 == Kr.field_type) {
                        String str4 = Kr.field_path + ".temp";
                        str2 = Kr.field_path;
                        if (bi.oW(str4) || bi.oW(str2)) {
                            x.w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
                        } else {
                            File file = new File(str4);
                            File file2 = new File(str2);
                            if (file.exists()) {
                                boolean renameTo = file.renameTo(file2);
                                x.v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", new Object[]{Boolean.valueOf(renameTo), str4, file2});
                            }
                        }
                        n.getRecordMsgCDNStorage().a(Kr, new String[]{"localId"});
                    } else {
                        x.i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", new Object[]{keep_sceneresult.mediaId, str});
                        x.d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", new Object[]{keep_sceneresult});
                        x.d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", new Object[]{keep_sceneresult.field_aesKey, keep_sceneresult.field_fileId});
                        if (keep_sceneresult.isUploadBySafeCDNWithMD5()) {
                            x.i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", new Object[]{Boolean.valueOf(keep_sceneresult.field_upload_by_safecdn), Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Integer.valueOf(keep_sceneresult.field_filecrc), keep_sceneresult.field_aesKey, keep_sceneresult.field_mp4identifymd5});
                            au.DF().a(new ab(keep_sceneresult.field_fileId, keep_sceneresult.field_filemd5, keep_sceneresult.field_mp4identifymd5, keep_sceneresult.field_filecrc, new 1(this, Kr, keep_sceneresult)), 0);
                            return 0;
                        }
                        Kr.field_cdnKey = keep_sceneresult.field_aesKey;
                        Kr.field_cdnUrl = keep_sceneresult.field_fileId;
                        n.getRecordMsgCDNStorage().b(Kr, new String[]{"localId"});
                    }
                } else {
                    x.e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", new Object[]{keep_sceneresult.mediaId, Integer.valueOf(keep_sceneresult.field_retCode)});
                    if (-5103059 == keep_sceneresult.field_retCode) {
                        Kr.field_status = 4;
                    } else {
                        Kr.field_status = 3;
                    }
                    Kr.field_errCode = keep_sceneresult.field_retCode;
                    n.getRecordMsgCDNStorage().b(Kr, new String[]{"localId"});
                }
            }
            return 0;
        }
        this.mrW.bqt();
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
