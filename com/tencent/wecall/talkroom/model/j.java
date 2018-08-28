package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.pb.common.c.c;

public final class j {
    public static boolean ads(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("client_");
    }

    public static int cIc() {
        int i = 0;
        try {
            return a.cHu().kvL;
        } catch (Exception e) {
            c.x("tagorewang:VoiceGroupUtil", new Object[]{"getActiveRoomId err: ", e});
            return i;
        }
    }

    public static long cId() {
        try {
            return a.cHu().vxz;
        } catch (Exception e) {
            c.x("tagorewang:VoiceGroupUtil", new Object[]{"getActiveRoomKey err: ", e});
            return 0;
        }
    }
}
