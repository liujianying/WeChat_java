package com.tencent.mm.plugin.cdndownloader.e;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class a$1 implements a {
    final /* synthetic */ a hKw;

    a$1(a aVar) {
        this.hKw = aVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        String str2;
        String str3 = "FileDownloaderXWEBProxy";
        String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = keep_progressinfo == null ? "null" : keep_progressinfo.toString();
        if (keep_sceneresult == null) {
            str2 = "null";
        } else {
            str2 = keep_sceneresult.toString();
        }
        objArr[3] = str2;
        x.d(str3, str4, objArr);
        if (i == -21006) {
            x.i("FileDownloaderXWEBProxy", "duplicate request, ignore this request, media id is %s", new Object[]{str});
        } else if (i != 0) {
            x.e("FileDownloaderXWEBProxy", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
            a.a(this.hKw, str, 4, i, false);
        } else if (keep_progressinfo != null) {
            a.a(this.hKw, str, (long) keep_progressinfo.field_finishedLength, (long) keep_progressinfo.field_toltalLength);
        } else if (keep_sceneresult != null) {
            if (keep_sceneresult.field_retCode != 0) {
                x.e("FileDownloaderXWEBProxy", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[]{str, Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult});
                a.a(this.hKw, str, 4, keep_sceneresult.field_retCode, keep_sceneresult.field_isResume);
            } else {
                x.i("FileDownloaderXWEBProxy", "cdn trans suceess, media id : %s", new Object[]{str});
                a.a(this.hKw, str, 3, 0, keep_sceneresult.field_isResume);
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
