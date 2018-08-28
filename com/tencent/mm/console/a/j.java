package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class j implements a {
    static {
        b.a(new j(), new String[]{"//version"});
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        int i;
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{e.b(context, d.qVN, true), Integer.valueOf(d.qVN)}));
        stringBuilder.append(com.tencent.mm.sdk.platformtools.d.avA());
        stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(e.bxk)}));
        stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(p.zP(0))}));
        stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{"0x26060736"}));
        if (com.tencent.mm.loader.stub.a.EX_DEVICE_LOGIN) {
            try {
                Map z = bl.z(bi.convertStreamToString(context.getAssets().open("merged_features.xml")), "merged");
                if (z != null) {
                    i = 0;
                    while (true) {
                        if (((String) z.get(".merged.feature" + (i > 0 ? String.valueOf(i) : ""))) == null) {
                            break;
                        }
                        stringBuilder.append(String.format("[feature#%02d] %s\n", new Object[]{Integer.valueOf(i), (String) z.get(".merged.feature" + (i > 0 ? String.valueOf(i) : ""))}));
                        i++;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Version", e, "", new Object[0]);
            }
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16777216);
        textView.setTypeface(Typeface.MONOSPACE);
        i = context.getResources().getDimensionPixelSize(R.f.LargePadding);
        textView.setPadding(i, i, i, i);
        h.a(context, null, textView, null);
        return true;
    }
}
