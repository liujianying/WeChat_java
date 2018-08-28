package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactSearchUI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    private EditText otx;

    protected final int getLayoutId() {
        return R.i.contact_search;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        au.DF().a(106, (e) this);
        super.onResume();
    }

    protected void onPause() {
        au.DF().b(106, (e) this);
        super.onPause();
    }

    protected final void initView() {
        setMMTitle(R.l.contact_search_title);
        this.otx = (EditText) findViewById(R.h.contact_search_account_et);
        this.otx.addTextChangedListener(new 1(this));
        this.otx.setImeOptions(3);
        this.otx.setOnEditorActionListener(new 2(this));
        addTextOptionMenu(0, getString(R.l.app_find), new 3(this));
        setBackBtn(new 4(this));
        if (getIntent().getBooleanExtra("from_webview", false)) {
            this.otx.setText(getIntent().getStringExtra("userName"));
            bGA();
        }
    }

    private void bGA() {
        String trim = this.otx.getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            h.i(this.mController.tml, R.l.verify_input_null_tip, R.l.app_tip);
            return;
        }
        x.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
        l fVar = new f(trim, 1);
        au.DF().a(fVar, 0);
        Context context = this.mController.tml;
        getString(R.l.app_tip);
        this.eHw = h.a(context, getString(R.l.address_searching), true, new 5(this, fVar));
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (!b.ezo.b(this.mController.tml, i, i2, str)) {
            if (i == 4 && i2 == -4) {
                h.i(this.mController.tml, R.l.address_not_found, R.l.app_tip);
            } else if (i == 0 && i2 == 0) {
                bja bcS = ((f) lVar).bcS();
                if (bcS.rHb > 0) {
                    Intent intent = new Intent();
                    intent.setClass(this, ContactSearchResultUI.class);
                    try {
                        intent.putExtra("result", bcS.toByteArray());
                        startActivity(intent);
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ContactSearchUI", e, "", new Object[0]);
                        return;
                    }
                }
                String a = ab.a(bcS.rvi);
                Intent intent2 = new Intent();
                ((i) g.l(i.class)).a(intent2, bcS, On(this.otx.getText().toString().trim()));
                if (bi.oV(a).length() > 0) {
                    if ((bcS.rTe & 8) > 0) {
                        com.tencent.mm.plugin.report.service.h.mEJ.k(10298, a + "," + On(this.otx.getText().toString().trim()));
                    }
                    d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                }
            } else {
                Toast.makeText(this, getString(R.l.fmt_search_err_no_code), 0).show();
                x.w("MicroMsg.ContactSearchUI", getString(R.l.fmt_search_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            }
        }
    }

    private static int On(String str) {
        if (bi.WE(str)) {
            return 1;
        }
        if (bi.WF(str)) {
            return 2;
        }
        return bi.WG(str) ? 3 : 3;
    }
}
