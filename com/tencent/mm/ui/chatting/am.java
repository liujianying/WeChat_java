package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.k;
import java.util.LinkedList;
import java.util.List;

public final class am {
    public static void l(String str, Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
        } else if (bi.oW(str)) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
        } else {
            a(dF(z.MY().hw(1)), context, new 1(str, context));
        }
    }

    public static void b(bd bdVar, Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
        } else if (bdVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
        } else {
            au.HU();
            if (c.isSDCardAvailable()) {
                a(dF(z.MY().hw(2)), context, new 4(bdVar, context));
                return;
            }
            s.gH(context);
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
        }
    }

    public static void a(bd bdVar, Context context, String str, boolean z) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
        } else if (bdVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
        } else {
            au.HU();
            if (c.isSDCardAvailable()) {
                a(dF(z.MY().hw(4)), context, new 5(bdVar, context, z, str));
                return;
            }
            s.gH(context);
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
        }
    }

    public static void c(bd bdVar, Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
        } else if (bdVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
        } else {
            au.HU();
            if (c.isSDCardAvailable()) {
                a(dF(z.MY().hw(8)), context, new 6(bdVar, context));
                return;
            }
            s.gH(context);
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
        }
    }

    public static void m(String str, Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
        } else if (bi.oW(str)) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
        } else {
            a(dF(z.MY().hw(16)), context, new 7(str, context));
        }
    }

    public static void n(String str, Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
        } else if (bi.oW(str)) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
        } else {
            a(dF(z.MY().hw(32)), context, new 8(str, context));
        }
    }

    public static void d(bd bdVar, Context context) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
        } else if (bdVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
        } else {
            au.HU();
            if (c.isSDCardAvailable()) {
                a(dF(z.MY().hw(64)), context, new 9(bdVar, context));
                return;
            }
            s.gH(context);
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
        }
    }

    public static void a(bd bdVar, String str, Context context) {
        a(bdVar, str, context, 512);
    }

    public static void b(bd bdVar, String str, Context context) {
        a(bdVar, str, context, (int) GLIcon.TOP);
    }

    public static void c(bd bdVar, String str, Context context) {
        a(bdVar, str, context, 128);
    }

    private static void a(bd bdVar, String str, Context context, int i) {
        if (context == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
        } else if (bdVar == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
        } else {
            List list = null;
            switch (i) {
                case 128:
                    list = dF(f.MM());
                    break;
                case GLIcon.TOP /*256*/:
                    list = dF(z.MY().hw(GLIcon.TOP));
                    break;
                case 512:
                    list = dF(z.MY().hw(512));
                    break;
            }
            a(list, context, new 10(bdVar, str, i, context));
        }
    }

    private static List<String> dF(List<String> list) {
        List<String> linkedList = new LinkedList();
        for (String str : list) {
            if (!f.kK(str)) {
                linkedList.add(str);
            }
        }
        x.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    private static void a(List<String> list, Context context, d dVar) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
            return;
        }
        k kVar = new k(context);
        kVar.uAx = new 11();
        kVar.uAy = new 2(context);
        kVar.ofp = new 3(list);
        kVar.ofq = dVar;
        kVar.bEo();
    }
}
