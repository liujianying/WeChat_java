package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.aq.h;
import com.tencent.mm.aq.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.f.a.c;
import java.util.ArrayList;
import java.util.List;

public class BindFacebookUI extends MMWizardActivity implements e {
    private c eOa;
    private ProgressDialog ePA;
    private OnCancelListener ePB;
    private v ePC;

    static /* synthetic */ void cl(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new a(32, z ? "0" : "1"));
        ((i) g.l(i.class)).FQ().b(new h(arrayList));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        g.DF().a(183, this);
        initView();
    }

    protected void onPause() {
        super.onPause();
        g.DF().b(183, this);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.bindfacebook;
    }

    protected final void initView() {
        this.eOa = new c("290293790992170");
        this.ePB = new 1(this);
        addTextOptionMenu(0, getString(a$j.app_ignore_it), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindFacebookUI.this.DT(1);
                return true;
            }
        });
        setMMTitle(a$j.bind_facebook_start_title);
        TextView textView = (TextView) findViewById(f.setting_bind_facebook_hint);
        textView.setVisibility(4);
        textView.setText(a$j.bind_facebook_start_hint);
        Button button = (Button) findViewById(f.bind_facebook_start_btn);
        button.setVisibility(0);
        button.setOnClickListener(new 3(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 183) {
            if (this.ePA != null) {
                this.ePA.dismiss();
            }
            if (!com.tencent.mm.plugin.account.a.a.ezo.a(this.mController.tml, i, i2, str)) {
                int i3 = ((v) lVar).opType;
                if (i == 0 && i2 == 0) {
                    if (i3 == 1) {
                        ((i) g.l(i.class)).FW().Yp("facebookapp");
                        ((i) g.l(i.class)).bcY().GK("facebookapp");
                    }
                    DT(1);
                } else if (i == 4 && i2 == -67) {
                    Toast.makeText(this, a$j.facebook_auth_have_bind_facebook, 1).show();
                } else if (i == 4 && i2 == -5) {
                    Toast.makeText(this, i3 == 1 ? a$j.facebook_auth_bind_access_denied : a$j.facebook_auth_unbind_access_denied, 1).show();
                } else {
                    Toast.makeText(this, i3 == 0 ? a$j.contact_info_facebookapp_unbind_fail : a$j.contact_info_facebookapp_bind_fail, 1).show();
                }
            }
        }
    }
}
