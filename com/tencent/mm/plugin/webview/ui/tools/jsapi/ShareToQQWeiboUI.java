package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ShareToQQWeiboUI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    private TextView mPC;
    private EditText meN;

    protected final int getLayoutId() {
        return R.i.edit_share_qqweibo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(26, this);
        initView();
    }

    public void onDestroy() {
        au.DF().b(26, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.share_to_tencent_microblog);
        this.meN = (EditText) findViewById(R.h.content);
        this.mPC = (TextView) findViewById(R.h.wordcount);
        String stringExtra = getIntent().getStringExtra("content");
        Object stringExtra2 = getIntent().getStringExtra("shortUrl");
        this.meN.addTextChangedListener(new c(this.meN, this.mPC, 280));
        if (stringExtra.contains(stringExtra2)) {
            this.meN.setText(stringExtra.trim());
        } else {
            this.meN.setText(stringExtra + " " + stringExtra2);
        }
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.app_share), new 2(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (lVar.getType() == 26) {
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (i == 0 && i2 == 0) {
                YC();
                setResult(-1);
                finish();
                return;
            }
            setResult(1, new Intent().putExtra("err_code", i2));
            Toast.makeText(this, getString(R.l.share_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
