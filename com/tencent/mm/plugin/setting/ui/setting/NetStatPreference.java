package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference extends Preference {
    boolean mQa;

    public NetStatPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatPreference(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.mQa = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.NetStatPreference, i, 0);
        if (obtainStyledAttributes.getInt(j.NetStatPreference_srcType, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.mQa = z;
        obtainStyledAttributes.recycle();
        setSummary(context.getString(i.settings_netstat_statistic_period, new Object[]{Integer.valueOf(15)}));
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, g.mm_preference_content_netstat, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(f.group);
        linearLayout.removeAllViews();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        for (int i = 15; i > 0; i -= 5) {
            NetStatGroup netStatGroup = new NetStatGroup(this.mContext);
            int i2 = (currentTimeMillis - i) + 1;
            boolean z = this.mQa;
            Object charSequence = DateFormat.format(netStatGroup.getContext().getString(i.fmt_date, new Object[]{""}), ((long) i2) * 86400000).toString();
            netStatGroup.mPZ.setText(charSequence);
            x.d("MicroMsg.NetStatGroup", "NetStat dataTime = " + charSequence);
            netStatGroup.mPY.removeAllViews();
            for (int i3 = 0; i3 < 5; i3++) {
                View netStatUnit = new NetStatUnit(netStatGroup.getContext());
                k it = q.Sj().it(i2 + i3);
                if (it != null) {
                    if (z) {
                        x.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", new Object[]{Integer.valueOf(it.ejM), Integer.valueOf(it.eki), Integer.valueOf(it.ejW), Integer.valueOf(it.ekk), Integer.valueOf(it.ejY)});
                        netStatUnit.dr(it.eki + it.ejW, it.ejY + it.ekk);
                    } else {
                        x.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", new Object[]{Integer.valueOf(it.ejM), Integer.valueOf(it.ekh), Integer.valueOf(it.ejV), Integer.valueOf(it.ekj), Integer.valueOf(it.ejX)});
                        netStatUnit.dr(it.ekh + it.ejV, it.ejX + it.ekj);
                    }
                }
                netStatUnit.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
                netStatGroup.mPY.addView(netStatUnit);
            }
            linearLayout.addView(netStatGroup, -2, -1);
        }
        linearLayout = (LinearLayout) view.findViewById(f.ruler);
        linearLayout.removeAllViews();
        NetStatGroup netStatGroup2 = new NetStatGroup(this.mContext);
        boolean z2 = this.mQa;
        netStatGroup2.removeAllViews();
        View.inflate(netStatGroup2.getContext(), g.netstat_ruler, netStatGroup2);
        netStatGroup2.mPY = (LinearLayout) netStatGroup2.findViewById(f.group);
        NetStatRuler netStatRuler = new NetStatRuler(netStatGroup2.getContext());
        netStatRuler.setTag(z2 ? "wifi" : "mobile");
        netStatRuler.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
        netStatGroup2.mPY.addView(netStatRuler);
        linearLayout.addView(netStatGroup2);
    }
}
