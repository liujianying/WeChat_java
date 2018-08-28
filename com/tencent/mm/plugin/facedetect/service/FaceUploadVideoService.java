package com.tencent.mm.plugin.facedetect.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class FaceUploadVideoService extends Service implements e {
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            x.e("MicroMsg.FaceUploadVideoService", "hy: null intent called to FaceUploadVideoService! Stub");
            return super.onStartCommand(null, i, i2);
        }
        String stringExtra = intent.getStringExtra("key_video_file_name");
        long longExtra = intent.getLongExtra("k_bio_id", -1);
        String stringExtra2 = intent.getStringExtra("key_app_id");
        x.i("MicroMsg.FaceUploadVideoService", "hy: start uploading %s", new Object[]{stringExtra});
        if (bi.oW(stringExtra)) {
            x.w("MicroMsg.FaceUploadVideoService", "hy: null file name");
            return super.onStartCommand(intent, i, i2);
        } else if (!new File(stringExtra).exists()) {
            x.w("MicroMsg.FaceUploadVideoService", "hy: file not exist");
            return super.onStartCommand(intent, i, i2);
        } else if (longExtra == -1 && bi.oW(stringExtra2)) {
            x.w("MicroMsg.FaceUploadVideoService", "hy: bioId or app id null");
            com.tencent.mm.a.e.deleteFile(stringExtra);
            return super.onStartCommand(intent, i, i2);
        } else {
            i iVar = new i();
            iVar.dPV = new a(this, longExtra, stringExtra2, stringExtra, (byte) 0);
            iVar.field_mediaId = o.AV(stringExtra);
            iVar.field_fullpath = stringExtra;
            iVar.field_thumbpath = "";
            iVar.field_fileType = b.MediaType_FILE;
            iVar.field_talker = "";
            iVar.field_priority = b.dOk;
            iVar.field_needStorage = false;
            iVar.field_isStreamMedia = false;
            iVar.field_appType = 0;
            iVar.field_bzScene = 0;
            iVar.field_largesvideo = 0;
            if (!g.ND().c(iVar)) {
                x.e("MicroMsg.FaceUploadVideoService", "hy: video task info failed. clientid:%s", new Object[]{iVar.field_mediaId});
                com.tencent.mm.a.e.deleteFile(stringExtra);
                FaceDetectReporter.e(longExtra, 1, 10086);
            }
            return super.onStartCommand(intent, i, i2);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof r) {
            r rVar = (r) lVar;
            x.i("MicroMsg.FaceUploadVideoService", "hy: bind video errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            com.tencent.mm.kernel.g.DF().b(1197, this);
            com.tencent.mm.a.e.deleteFile(rVar.mFileName);
            stopSelf();
        }
    }
}
