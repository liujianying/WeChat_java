package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class SafeDeviceListPreference extends Preference implements e {
    private Context context;
    private ProgressDialog eHw;
    d eOO;
    private boolean eOP;
    private Button eOQ;
    a eOR;
    b eOS;
    int mode;

    public SafeDeviceListPreference(Context context) {
        this(context, null);
    }

    public SafeDeviceListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SafeDeviceListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mode = -2;
        this.eOP = false;
        this.context = context;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(a$f.content);
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            layoutInflater.inflate(a$g.mm_preference_edit_safe_device, viewGroup2);
        }
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.eOP = true;
        this.eOQ = (Button) view.findViewById(a$f.del_safe_device_btn);
        initView();
        super.onBindView(view);
    }

    private void TX() {
        g.DF().b(362, this);
    }

    final void initView() {
        if (this.eOP) {
            switch (this.mode) {
                case -2:
                    setWidgetLayoutResource(a$g.mm_preference_submenu);
                    return;
                case 1:
                    setWidgetLayoutResource(a$g.delete_safe_divice);
                    if (this.eOQ != null) {
                        this.eOQ.setOnClickListener(new 3(this));
                        return;
                    }
                    return;
                default:
                    setWidgetLayoutResource(a$g.mm_preference_submenu);
                    return;
            }
        }
        x.d("MicroMsg.SafeDeviceListPreference", "has not binded");
    }

    public final void a(int i, int i2, String str, l lVar) {
        TX();
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (i2 == 0 && i2 == 0) {
            com.tencent.mm.plugin.account.security.a.g.Yq().a(this.eOO, new String[0]);
            if (this.eOS != null) {
                this.eOS.pH(this.mKey);
            }
        } else if (!a.ezo.a(this.context, i, i2, str)) {
            Toast.makeText(this.context, this.context.getString(j.safe_device_del_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            if (this.eOR != null) {
                this.eOR.pI(this.eOO.field_uid);
            }
        }
    }
}
