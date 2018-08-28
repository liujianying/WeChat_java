package com.tencent.mm.console.a.a;

import android.content.Context;
import com.tencent.mm.hardcoder.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    public final boolean a(Context context, String[] strArr) {
        if (strArr.length <= 1) {
            return false;
        }
        if (bi.getInt(strArr[1], 0) > 0) {
            e.dla = true;
        } else {
            e.dla = false;
        }
        return true;
    }
}
