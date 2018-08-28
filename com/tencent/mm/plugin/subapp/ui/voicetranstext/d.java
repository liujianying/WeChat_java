package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.h;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.protocal.c.byo;

public final class d {
    public static byo aI(int i, String str) {
        byo byo = new byo();
        switch (i) {
            case 0:
                byo.rea = 8000;
                byo.reb = 16;
                byo.rdY = 5;
                byo.rdZ = 5;
                break;
            case 1:
                byo.rea = 16000;
                byo.reb = 16;
                byo.rdY = 4;
                byo.rdZ = 4;
                break;
            case 4:
                byo.rea = 16000;
                b ok = q.ok(str);
                if (ok != null) {
                    int SilkGetEncSampleRate = MediaRecorder.SilkGetEncSampleRate(((h) ok).br(0, 1).buf);
                    if (SilkGetEncSampleRate >= 8000) {
                        byo.rea = SilkGetEncSampleRate;
                    }
                }
                byo.reb = 16;
                byo.rdY = 6;
                byo.rdZ = 6;
                break;
            default:
                byo.rea = 0;
                byo.reb = 0;
                byo.rdY = 0;
                byo.rdZ = 0;
                break;
        }
        return byo;
    }
}
