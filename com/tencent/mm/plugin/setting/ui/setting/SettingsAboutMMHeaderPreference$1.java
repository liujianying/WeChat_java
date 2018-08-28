package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.n;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.ui.base.h;

class SettingsAboutMMHeaderPreference$1 implements OnClickListener {
    private long mQS = 0;
    final /* synthetic */ SettingsAboutMMHeaderPreference mQT;

    SettingsAboutMMHeaderPreference$1(SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference) {
        this.mQT = settingsAboutMMHeaderPreference;
    }

    public final void onClick(View view) {
        long VF = bi.VF();
        if (this.mQS > VF || VF - this.mQS > 300) {
            this.mQS = VF;
            return;
        }
        this.mQS = VF;
        Context context = this.mQT.mContext;
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{e.b(context, d.qVN, true), Integer.valueOf(d.qVN)}));
        stringBuilder.append(com.tencent.mm.sdk.platformtools.d.avA());
        stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(e.bxk)}));
        stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(p.zP(0))}));
        stringBuilder.append(String.format("[l.ver] %d\n", new Object[]{Integer.valueOf(p.zP(1))}));
        stringBuilder.append(String.format("[ws.ver] %d\n", new Object[]{Integer.valueOf(n.adQ())}));
        stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{"0x26060736"}));
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16777216);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(a.d.LargePadding);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        h.a(context, null, textView, null);
    }
}
