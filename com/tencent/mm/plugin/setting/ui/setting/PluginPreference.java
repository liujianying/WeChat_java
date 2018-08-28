package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference extends Preference implements c {
    private MMActivity bGc;
    private ImageView eKk;
    int iRP;
    String mQg;
    String mQh;
    private String mQi;
    private int mQj;
    private int mQk;
    boolean mQl;

    public PluginPreference(Context context) {
        this(context, null);
    }

    public PluginPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mQi = "";
        this.mQj = -1;
        this.mQk = 8;
        this.mQl = false;
        this.eKk = null;
        this.iRP = 255;
        this.bGc = (MMActivity) context;
        setLayoutResource(g.mm_preference);
        q.Kp().a(this);
    }

    public final boolean KW(String str) {
        ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(str);
        if (Yg == null || ((int) Yg.dhP) == 0) {
            x.e("MicroMsg.PluginPreference", "plugin do not exist");
            return false;
        }
        this.mQg = Yg.field_username;
        this.mQh = Yg.BK();
        setKey("settings_plugins_list_#" + this.mQg);
        return true;
    }

    private void bru() {
        if (this.eKk != null) {
            b.a(this.eKk, this.mQg);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(g.mm_preference_content_plugin, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.eKk = (ImageView) view.findViewById(f.image_iv);
        this.eKk.setAlpha(this.iRP);
        TextView textView = (TextView) view.findViewById(f.text_tv_one);
        if (textView != null) {
            textView.setVisibility(this.mQk);
            textView.setText(this.mQi);
            if (this.mQj != -1) {
                textView.setBackgroundDrawable(a.f(this.bGc, this.mQj));
            }
        }
        textView = (TextView) view.findViewById(f.new_dot);
        if (textView != null) {
            textView.setVisibility(this.mQl ? 0 : 8);
        }
        bru();
    }

    public final void jX(String str) {
        if (this.mQg != null && this.mQg.equals(str)) {
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    PluginPreference.this.bru();
                }
            });
        }
    }
}
