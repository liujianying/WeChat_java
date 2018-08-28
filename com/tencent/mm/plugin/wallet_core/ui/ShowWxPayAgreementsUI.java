package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(3)
public class ShowWxPayAgreementsUI extends MMActivity {
    private String content;
    private MMWebView psF;
    private TextView psG;
    private TextView psH;
    private int type;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        boolean z = false;
        h.mEJ.h(15236, new Object[]{Integer.valueOf(1)});
        getSupportActionBar().hide();
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.push_up_in, com.tencent.mm.plugin.wxpay.a.a.anim_not_change);
        this.type = getIntent().getIntExtra("agreement_type", 0);
        View view = this.mController.contentView;
        int i = a$f.agreement_webview;
        MMWebView.he(this);
        MMWebView mMWebView = (MMWebView) view.findViewById(i);
        mMWebView.dfF = true;
        if (mMWebView.getX5WebViewExtension() != null) {
            z = true;
        }
        MMWebView.e(mMWebView, z);
        this.psF = mMWebView;
        this.psF.getSettings().setJavaScriptEnabled(true);
        this.psG = (TextView) findViewById(a$f.agreement_disagree_btn);
        this.psH = (TextView) findViewById(a$f.agreement_agree_btn);
        this.content = getIntent().getStringExtra("agreement_content");
        this.psH.setOnClickListener(new 1(this));
        this.psG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.mEJ.h(15236, new Object[]{Integer.valueOf(3)});
                ShowWxPayAgreementsUI.this.finish();
            }
        });
        this.psF.setWebViewClient(new e(this));
        this.psF.loadData(this.content, "text/html; charset=UTF-8", null);
    }

    protected final int getLayoutId() {
        return a$g.show_wxpayagreements_ui;
    }

    public void finish() {
        x.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
        super.finish();
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.anim_not_change, com.tencent.mm.plugin.wxpay.a.a.push_down_out);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
