package com.tencent.mm.plugin.facedetect.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.x;

public class FaceDetectProcessService extends Service {
    public g iPA = null;
    private Messenger iPB = null;
    private a iPC = null;
    private a iPz = new a(this);

    public void onCreate() {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo service onCreate hashCode: %d", new Object[]{Integer.valueOf(hashCode())});
        super.onCreate();
        this.iPA = new g();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo onStartCommand");
        if (intent == null) {
            x.e("MicroMsg.FaceDetectProcessService", "intent is null!!");
            return super.onStartCommand(intent, i, i2);
        }
        Messenger messenger = (Messenger) intent.getParcelableExtra("k_messenger");
        if (messenger != null) {
            this.iPB = messenger;
            return super.onStartCommand(intent, i, i2);
        }
        x.i("MicroMsg.FaceDetectProcessService", "hy: get command: %d", new Object[]{Integer.valueOf(intent.getIntExtra("k_cmd", -1))});
        switch (intent.getIntExtra("k_cmd", -1)) {
            case 0:
                a aVar;
                int engineInit;
                String stringExtra = intent.getStringExtra("k_bio_id");
                byte[] byteArrayExtra = intent.getByteArrayExtra("k_bio_config");
                FaceContextData.a((FaceContextData) intent.getParcelableExtra("k_ontext_data"));
                switch (intent.getIntExtra("k_server_scene", 2)) {
                    case 0:
                    case 1:
                        aVar = null;
                        break;
                    case 2:
                    case 5:
                        aVar = new b();
                        break;
                    default:
                        aVar = null;
                        break;
                }
                this.iPC = aVar;
                g gVar = this.iPA;
                if (gVar.iNy != null) {
                    x.w("MicroMsg.FaceDetectNativeManager", "hy: last detection not destroyed");
                    gVar.aJS();
                }
                if (o.aJW()) {
                    gVar.iNy = new FaceProNative();
                    engineInit = gVar.iNy.engineInit(stringExtra, byteArrayExtra, o.aJY(), o.aJZ());
                    x.i("MicroMsg.FaceDetectNativeManager", "hy: init result : %d", new Object[]{Integer.valueOf(engineInit)});
                } else {
                    x.w("MicroMsg.FaceDetectNativeManager", "hy: model file not valid");
                    engineInit = -4;
                }
                cz(0, engineInit);
                break;
            case 1:
                f.y(new 2(this, new p() {
                    public final void b(FaceResult faceResult) {
                        int i = -1;
                        String str = "MicroMsg.FaceDetectProcessService";
                        String str2 = "alvinluo release out result == null:%b, result: %d";
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(faceResult == null);
                        objArr[1] = Integer.valueOf(faceResult != null ? faceResult.result : -1);
                        x.i(str, str2, objArr);
                        if (faceResult == null || faceResult.result != 0) {
                            x.i("MicroMsg.FaceDetectProcessService", "alvinluo release out data not valid");
                            if (faceResult != null) {
                                i = faceResult.result;
                            }
                            FaceDetectProcessService.this.cz(1, i);
                            return;
                        }
                        f.y(new 1(this, faceResult));
                    }
                }));
                break;
            case 4:
                a.aKA().iSn = intent.getBooleanExtra("key_is_need_video", false);
                break;
            case 5:
                if (this.iPC != null) {
                    this.iPC.C(intent);
                    break;
                }
                break;
            default:
                x.e("MicroMsg.FaceDetectProcessService", "hy: unsupported cmd");
                break;
        }
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo service onBind hashCode: %d", new Object[]{Integer.valueOf(hashCode())});
        this.iPz = new a(this);
        return this.iPz;
    }

    public boolean onUnbind(Intent intent) {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo service onUnbind");
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo service onDestroy");
        super.onDestroy();
    }

    private void n(Message message) {
        try {
            if (this.iPB != null) {
                x.i("MicroMsg.FaceDetectProcessService", "alvinluo serivce send msg to client: %d, msg: %s, client hashCode: %d", new Object[]{Integer.valueOf(message.what), message.toString(), Integer.valueOf(this.iPB.hashCode())});
                this.iPB.send(message);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectProcessService", e, "", new Object[0]);
        }
    }

    private void cz(int i, int i2) {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo replyToClient requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        n(message);
    }
}
