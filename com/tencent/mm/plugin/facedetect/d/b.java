package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;

public interface b {

    public static class b {
        public String Yy;
        public int errCode;

        public b(int i, String str) {
            this.errCode = i;
            this.Yy = str;
        }
    }

    void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2);

    boolean a(FaceCharacteristicsResult faceCharacteristicsResult);

    boolean aKc();

    boolean aKd();

    void aKe();

    b aKf();

    a aKg();

    boolean b(FaceCharacteristicsResult faceCharacteristicsResult);
}
