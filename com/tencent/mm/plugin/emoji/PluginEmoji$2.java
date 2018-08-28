package com.tencent.mm.plugin.emoji;

import com.tencent.mm.br.f;
import com.tencent.mm.br.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.ui.e.c.a;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PluginEmoji$2 implements a {
    final /* synthetic */ PluginEmoji icR;

    PluginEmoji$2(PluginEmoji pluginEmoji) {
        this.icR = pluginEmoji;
    }

    public final CharSequence c(CharSequence charSequence, int i) {
        return g.cjL().g(charSequence, i);
    }

    public final CharSequence b(CharSequence charSequence, float f) {
        return g.cjL().a(charSequence, f);
    }

    public final int bd(String str, int i) {
        g.cjL();
        f cjI = f.cjI();
        if (bi.oW(str)) {
            return i;
        }
        int length = str.length();
        if (i == 0 || i == length) {
            return i;
        }
        int i2;
        if (f.sMh == null) {
            StringBuilder stringBuilder = new StringBuilder();
            int length2 = cjI.sLX.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(cjI.sLX[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = cjI.sLY.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(cjI.sLY[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = cjI.sLZ.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(cjI.sLZ[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = cjI.sMa.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(cjI.sMa[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = cjI.sMb.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(cjI.sMb[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = cjI.sMc.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(cjI.sMc[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            if (!(cjI.sMd == null || cjI.sMd.isEmpty())) {
                Iterator it = cjI.sMd.iterator();
                while (it.hasNext()) {
                    q qVar = (q) it.next();
                    stringBuilder.append(Pattern.quote(qVar.field_key)).append("|");
                    if (!bi.oW(qVar.field_cnValue)) {
                        stringBuilder.append(Pattern.quote(qVar.field_cnValue)).append("|");
                    }
                    if (!bi.oW(qVar.field_enValue)) {
                        stringBuilder.append(Pattern.quote(qVar.field_enValue)).append("|");
                    }
                    if (!bi.oW(qVar.field_qqValue)) {
                        stringBuilder.append(Pattern.quote(qVar.field_qqValue)).append("|");
                    }
                    if (!bi.oW(qVar.field_twValue)) {
                        stringBuilder.append(Pattern.quote(qVar.field_twValue)).append("|");
                    }
                    if (!bi.oW(qVar.field_thValue)) {
                        stringBuilder.append(Pattern.quote(qVar.field_thValue)).append("|");
                    }
                }
            }
            f.sMh = Pattern.compile(stringBuilder.toString());
        }
        Matcher matcher = f.sMh.matcher(str.substring(i < 6 ? 0 : i - 6, i + 6 >= length ? length - 1 : i + 6));
        while (matcher.find()) {
            if (6 > matcher.start() && 6 < matcher.end()) {
                i2 = matcher.start();
                break;
            }
        }
        i2 = 6;
        return i + (i2 + -6 > 0 ? i2 - 6 : 0);
    }
}
