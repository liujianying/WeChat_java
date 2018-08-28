package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.q;

public class HelperHeaderPreference extends Preference {
    private a qOK = new a();

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        ImageView imageView = (ImageView) view.findViewById(e.avatar_iv);
        TextView textView = (TextView) view.findViewById(e.status_tv);
        TextView textView2 = (TextView) view.findViewById(e.nickname_tv);
        TextView textView3 = (TextView) view.findViewById(e.hint_tv);
        if (imageView != null) {
            b.a(imageView, this.qOK.bWJ);
        }
        if (textView != null) {
            switch (this.qOK.status) {
                case 0:
                    textView.setVisibility(0);
                    textView.setTextColor(q.hc(this.mContext));
                    textView.setText(h.settings_plugins_uninstalled);
                    textView.setCompoundDrawablesWithIntrinsicBounds(d.status_disable, 0, 0, 0);
                    break;
                case 1:
                    textView.setVisibility(0);
                    textView.setTextColor(q.hb(this.mContext));
                    textView.setText(h.settings_plugins_installed);
                    textView.setCompoundDrawablesWithIntrinsicBounds(d.status_enable, 0, 0, 0);
                    break;
                case 2:
                    textView.setVisibility(8);
                    break;
            }
        }
        if (textView2 != null) {
            textView2.setText(this.qOK.daA);
        }
        if (textView3 != null) {
            textView3.setText(this.qOK.eVC);
        }
        super.onBindView(view);
    }

    public final void an(String str, String str2, String str3) {
        this.qOK.bWJ = str;
        this.qOK.daA = str2;
        this.qOK.eVC = str3;
        super.callChangeListener(null);
    }

    public final void nw(int i) {
        this.qOK.status = i;
        super.callChangeListener(null);
    }
}
