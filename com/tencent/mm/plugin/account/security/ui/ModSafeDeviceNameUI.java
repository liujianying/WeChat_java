package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ModSafeDeviceNameUI extends MMActivity implements e {
    private String bKv;
    private long createTime;
    private ProgressDialog eHw = null;
    private String eOA;
    private EditText eOx;
    private String eOy;
    private String eOz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        g.DF().a(361, this);
        super.onResume();
    }

    protected void onPause() {
        g.DF().b(361, this);
        super.onPause();
    }

    protected final void initView() {
        this.eOy = getIntent().getStringExtra("safe_device_name");
        this.eOA = getIntent().getStringExtra("safe_device_uid");
        this.bKv = getIntent().getStringExtra("safe_device_type");
        setMMTitle(a.af(this, j.safe_device_edit_title));
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(j.app_save), new 2(this));
        3 3 = new 3(this);
        this.eOx = (EditText) findViewById(f.mod_safe_device_name);
        c cVar = new c(this.eOx, null, 32);
        cVar.uGk = 3;
        this.eOx.addTextChangedListener(cVar);
        if (bi.oW(this.eOy)) {
            enableOptionMenu(false);
        } else {
            this.eOx.setText(this.eOy);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.mod_safe_device_name;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (i == 0 && i2 == 0) {
            d dVar = new d();
            dVar.field_devicetype = this.bKv;
            dVar.field_name = this.eOz;
            dVar.field_uid = this.eOA;
            dVar.field_createtime = this.createTime;
            com.tencent.mm.plugin.account.security.a.g.Yq().c(dVar, new String[0]);
            h.bA(this, a.af(this, j.safe_device_mod_name_ok));
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    ModSafeDeviceNameUI.this.finish();
                }
            }, 1000);
        } else if (!com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, str)) {
        }
    }
}
