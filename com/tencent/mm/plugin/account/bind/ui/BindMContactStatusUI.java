package com.tencent.mm.plugin.account.bind.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.i;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI extends MMWizardActivity {
    private ImageView eFS;
    private TextView eGl;
    private TextView eGm;
    private Button eGn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.bind_mcontact_title_setting);
        initView();
    }

    protected final int getLayoutId() {
        return g.bindmcontact_status;
    }

    protected final void initView() {
        this.eFS = (ImageView) findViewById(f.bind_m_contact_status_state_icon);
        this.eGl = (TextView) findViewById(f.bind_m_contact_status_bind_state_title);
        this.eGm = (TextView) findViewById(f.bind_m_contact_status_bind_state);
        this.eGn = (Button) findViewById(f.bind_m_contact_status_ok_btn);
        if (l.XC() == a.eKt) {
            this.eFS.setImageResource(i.mobile_binded_icon);
            String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(6, null);
            if (str == null || str.equals("")) {
                str = (String) com.tencent.mm.kernel.g.Ei().DT().get(4097, null);
            }
            this.eGm.setText(getString(j.bind_mcontact_status_bind_ok));
            this.eGl.setText(getString(j.bind_mcontact_verify_mobile, new Object[]{str}));
        } else {
            this.eFS.setImageResource(i.mobile_unbind_icon);
            this.eGm.setText(j.bind_mcontact_unbind_ok);
            this.eGl.setText(j.bind_mcontact_unbind_ok);
            this.eGm.setVisibility(8);
        }
        this.eGn.setOnClickListener(new 1(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        DT(1);
        return true;
    }
}
