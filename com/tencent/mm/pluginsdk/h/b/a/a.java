package com.tencent.mm.pluginsdk.h.b.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;

public final class a {
    public static boolean b(String str, Context context, boolean z) {
        o.Ta();
        return c(s.nK(str), context, z);
    }

    public static boolean c(String str, Context context, boolean z) {
        if (bi.oW(str) || context == null) {
            return false;
        }
        Intent addFlags = new Intent("android.intent.action.VIEW").addFlags(268435456);
        addFlags.putExtra("ChannelID", "com.tencent.mm");
        addFlags.putExtra("PosID", 3);
        Uri fromFile = Uri.fromFile(new File(str));
        if (z) {
            addFlags.setDataAndType(fromFile, "video/quicktime");
        } else {
            addFlags.setDataAndType(fromFile, "video/*");
        }
        if (!bi.k(context, addFlags)) {
            return false;
        }
        context.startActivity(addFlags);
        return true;
    }
}
