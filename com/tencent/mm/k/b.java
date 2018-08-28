package com.tencent.mm.k;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static int Au() {
        return bi.getInt(g.AT().getValue("InputLimitSessionTextMsg"), 8192) * 2;
    }

    public static int Av() {
        return bi.getInt(g.AT().getValue("InputLimitSNSObjectText"), 2000) * 2;
    }

    public static int Aw() {
        return bi.getInt(g.AT().getValue("SnsCommentMaxSize"), 1000) * 2;
    }

    public static int Ax() {
        return bi.getInt(g.AT().getValue("InputLimitFavText"), 100000) * 2;
    }

    public static int Ay() {
        return bi.getInt(g.AT().getValue("InputLimitSendEmotionBufSize"), 1048576);
    }

    public static int Az() {
        int i = 1024;
        try {
            return bi.getInt(g.AT().getValue("InputLimitSendEmotionWidth"), 1024);
        } catch (Exception e) {
            x.k("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", new Object[]{e});
            return i;
        }
    }

    public static int AA() {
        int i = 5242880;
        try {
            return bi.getInt(g.AT().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
        } catch (Exception e) {
            x.k("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", new Object[]{e});
            return i;
        }
    }

    public static int AB() {
        return bi.getInt(g.AT().getValue("InputLimitFavImageSize"), 26214400);
    }

    public static int AC() {
        return bi.getInt(g.AT().getValue("InputLimitVideoSize"), 26214400);
    }

    public static String AD() {
        return g.AT().getValue("InputLimitForbiddenChar");
    }
}
