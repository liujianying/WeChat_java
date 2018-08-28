package com.tencent.mm.ui.d;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    private String kxY = null;
    String mUrl = null;
    private boolean tsf = false;
    private com.tencent.mm.model.b.b.b tsg = null;
    private String tsh = "";

    public a(Context context, com.tencent.mm.model.b.b.b bVar) {
        super(context);
        this.tsg = bVar;
        refresh();
    }

    public final int getLayoutId() {
        return R.i.chatting_monitored_banner;
    }

    private void refresh() {
        au.HU().Gv();
        if (com.tencent.mm.model.b.b.a(this.tsg)) {
            x.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[]{this.tsg, this.kxY, this.mUrl, Boolean.valueOf(this.tsf)});
            if (this.tsg == com.tencent.mm.model.b.b.b.dDZ) {
                au.HU().Gv();
                this.kxY = com.tencent.mm.model.b.b.Jc();
                au.HU().Gv();
                this.mUrl = com.tencent.mm.model.b.b.Jd();
                au.HU().Gv();
                this.tsf = com.tencent.mm.model.b.b.Je();
            } else {
                au.HU().Gv();
                this.kxY = com.tencent.mm.model.b.b.IZ();
                au.HU().Gv();
                this.mUrl = com.tencent.mm.model.b.b.Ja();
                au.HU().Gv();
                this.tsf = com.tencent.mm.model.b.b.Jb();
            }
            TextView textView = (TextView) getView().findViewById(R.h.chatting_monitored_banner_text);
            ImageView imageView = (ImageView) getView().findViewById(R.h.close_icon);
            if (bi.oW(this.kxY)) {
                textView.setText(R.l.app_waiting);
            } else {
                textView.setText(this.kxY);
            }
            textView.setSelected(true);
            if (bi.oW(this.mUrl)) {
                getView().findViewById(R.h.monitor_content).setBackgroundResource(R.e.tipsbar_black_bg_color);
                imageView.setImageResource(R.g.monitor_close);
                textView.setTextColor(ad.getContext().getResources().getColor(R.e.white));
            } else {
                getView().findViewById(R.h.monitor_content).setBackgroundResource(R.g.tips_bar_white_selector);
                imageView.setImageResource(R.g.monitor_close_dark);
                textView.setTextColor(ad.getContext().getResources().getColor(R.e.tipsbar_text_color));
            }
            getView().setOnClickListener(new 1(this));
            if (getView().getVisibility() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                g.Eg();
                this.tsh = stringBuilder.append(com.tencent.mm.kernel.a.Df()).append("_").append(System.currentTimeMillis()).toString();
                Ed(0);
            }
            setVisibility(0);
            if (this.tsf) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new 2(this));
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        x.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
        setVisibility(8);
    }

    public final void setVisibility(int i) {
        super.setVisibility(i);
        getView().findViewById(R.h.monitor_content).setVisibility(i);
    }

    public final boolean anR() {
        refresh();
        return super.anR();
    }

    public final void destroy() {
    }

    final void Ed(int i) {
        int i2 = 1;
        h hVar = h.mEJ;
        Object[] objArr = new Object[3];
        objArr[0] = this.tsh;
        objArr[1] = Integer.valueOf(i);
        if (this.tsg == com.tencent.mm.model.b.b.b.dDY) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        hVar.h(14439, objArr);
        h.mEJ.a(633, (long) i, 1, false);
    }
}
