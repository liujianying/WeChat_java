package com.tencent.mm.plugin.facedetect.service;

import android.os.Bundle;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.1;

class FaceDetectProcessService$1$1 implements Runnable {
    final /* synthetic */ FaceResult iPE;
    final /* synthetic */ 1 iPF;

    FaceDetectProcessService$1$1(1 1, FaceResult faceResult) {
        this.iPF = 1;
        this.iPE = faceResult;
    }

    public final void run() {
        String a = o.a(this.iPE);
        Bundle bundle = new Bundle();
        bundle.putInt("key_face_result_code", 0);
        bundle.putString("key_face_result_file_path", a);
        FaceDetectProcessService.a(this.iPF.iPD, bundle);
    }
}
