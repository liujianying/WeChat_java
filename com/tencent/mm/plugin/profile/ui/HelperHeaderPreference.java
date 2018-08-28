package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.q;
import junit.framework.Assert;

public class HelperHeaderPreference extends Preference {
    private ImageView eBM;
    private TextView eBR;
    private boolean eFt = false;
    private TextView eZp;
    private ab guS;
    private TextView lWV;
    private a lWW;

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        this.eBM = (ImageView) view.findViewById(R.h.contact_info_avatar_iv);
        this.eBR = (TextView) view.findViewById(R.h.contact_info_status_tv);
        this.lWV = (TextView) view.findViewById(R.h.contact_info_nickname_tv);
        this.eZp = (TextView) view.findViewById(R.h.contact_info_helper_hing_tv);
        this.eFt = true;
        initView();
        super.onBindView(view);
    }

    public final void hd(boolean z) {
        if (this.lWW != null) {
            if (z) {
                this.eBR.setTextColor(q.hb(this.mContext));
                this.eBR.setText(R.l.settings_plugins_installed);
                this.eBR.setCompoundDrawablesWithIntrinsicBounds(R.g.status_enable, 0, 0, 0);
                return;
            }
            this.eBR.setTextColor(q.hc(this.mContext));
            this.eBR.setText(R.l.settings_plugins_uninstalled);
            this.eBR.setCompoundDrawablesWithIntrinsicBounds(R.g.status_disable, 0, 0, 0);
        }
    }

    private void initView() {
        if (!this.eFt || this.guS == null) {
            x.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.eFt + "contact = " + this.guS);
            return;
        }
        String str = this.guS.field_username;
        x.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = " + str);
        if (this.eBM != null && this.guS.field_username.equals(str)) {
            b.a(this.eBM, str);
        }
        if (this.lWV != null) {
            this.lWV.setText(this.guS.BK());
        }
        if (this.lWW != null) {
            this.lWW.a(this);
            CharSequence hint = this.lWW.getHint();
            if (hint != null) {
                this.eZp.setText(hint);
                this.eZp.setVisibility(0);
                return;
            }
            this.eZp.setVisibility(8);
        }
    }

    public final void a(ab abVar, a aVar) {
        Assert.assertTrue(abVar != null);
        this.guS = abVar;
        this.lWW = aVar;
        initView();
    }
}
