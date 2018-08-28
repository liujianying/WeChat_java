package com.tencent.tencentmap.mapsdk.a;

import com.tencent.beacon.event.UserAction;
import java.util.Map;

public final class fo {
    public static dw a;

    public static boolean a(String str, boolean z, long j, long j2, Map map, boolean z2) {
        boolean onUserAction;
        try {
            onUserAction = UserAction.onUserAction(str, true, 0, 0, map, true);
            try {
                fx.c("UserActionWrapper", "UserActionWrapper onUserAction event:" + str + ",ret:" + onUserAction);
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            onUserAction = false;
        }
        if (onUserAction) {
            return onUserAction;
        }
        try {
            if (a == null) {
                return onUserAction;
            }
            onUserAction = a.a(str, true, 0, 0, map, true);
            fx.c("UserActionWrapper", "UserActionWrapper...call App UserAction event:" + str + ",ret:" + onUserAction);
            return onUserAction;
        } catch (Throwable th3) {
            return onUserAction;
        }
    }
}
