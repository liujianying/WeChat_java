package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.widget.MMEditText;

public class ShareToQQUI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    private TextView mPC;
    private int mPD;
    private boolean mPE = false;
    private EditText meN;

    static /* synthetic */ void d(ShareToQQUI shareToQQUI) {
        x.e("MicroMsg.ShareToQQUI", "dealWithRefreshTokenFail");
        if (!shareToQQUI.mPE) {
            String string = shareToQQUI.mController.tml.getString(i.app_tip);
            h.a(shareToQQUI.mController.tml, shareToQQUI.mController.tml.getString(i.facebook_friend_need_rebind), string, new 6(shareToQQUI), null);
        }
    }

    protected final int getLayoutId() {
        return g.edit_sharetoqq;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.DF().a(26, this);
        initView();
        if (q.Hg()) {
            c cVar = new c("290293790992170");
            cVar.aaT(bi.oV((String) com.tencent.mm.kernel.g.Ei().DT().get(65830, null)));
            new com.tencent.mm.plugin.account.model.g(cVar, new 5(this)).Yl();
        }
    }

    public void onDestroy() {
        com.tencent.mm.kernel.g.DF().b(26, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.send_qrcode_to_microblog);
        this.meN = (EditText) findViewById(f.content);
        this.mPC = (TextView) findViewById(f.wordcount);
        this.meN.addTextChangedListener(new MMEditText.c(this.meN, this.mPC, 280));
        this.mPD = getIntent().getIntExtra("show_to", 2);
        if (this.mPD == 4) {
            this.meN.setText(i.self_qrcode_show_facebook_et_content);
        } else {
            this.meN.setText(i.self_qrcode_show_qq_et_content);
        }
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(i.app_share), new 2(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (lVar.getType() == 26) {
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (i == 4 && i2 == -68) {
                if (bi.oW(str)) {
                    str = "error";
                }
                h.a(this, str, getString(i.app_tip), new 3(this), null);
            } else if (i == 0 && i2 == 0) {
                YC();
                String string = getString(i.share_ok);
                4 4 = new 4(this);
                h.bA(this, string);
            } else {
                this.mPE = false;
                if (!b.ezo.a(this.mController.tml, i, i2, str)) {
                    Toast.makeText(this, getString(i.share_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }
}
