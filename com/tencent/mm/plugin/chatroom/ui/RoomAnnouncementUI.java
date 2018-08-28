package com.tencent.mm.plugin.chatroom.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
@Deprecated
public class RoomAnnouncementUI extends MMActivity {
    private String fsV;
    private WebView hNb;
    private boolean hNc;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hNc = getIntent().getBooleanExtra("need_bind_mobile", false);
        this.fsV = getIntent().getStringExtra("RoomInfo_Id");
        initView();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.hNb != null) {
            this.hNb.setVisibility(8);
            ((ViewGroup) this.hNb.getParent()).removeView(this.hNb);
            this.hNb.removeAllViews();
            this.hNb.destroy();
            this.hNb = null;
            System.gc();
        }
        super.onDestroy();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected final void initView() {
        setMMTitle(R.l.room_upgrade_responsibility_title);
        this.hNb = a.l(this, R.h.webview);
        this.hNb.getSettings().setJavaScriptEnabled(true);
        this.hNb.getSettings().cIv();
        this.hNb.getSettings().setBuiltInZoomControls(true);
        this.hNb.getSettings().setUseWideViewPort(true);
        this.hNb.getSettings().setLoadWithOverviewMode(true);
        this.hNb.getSettings().cIq();
        this.hNb.getSettings().cIp();
        this.hNb.getSettings().setGeolocationEnabled(false);
        this.hNb.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.hNb.setWebChromeClient(new 1(this));
        this.hNb.setWebViewClient(new 2(this));
        setBackBtn(new 3(this));
        this.hNb.loadUrl(getString(R.l.chatroom_owner_responsibility, new Object[]{w.chP()}));
    }

    public final int getLayoutId() {
        return R.i.chatroom_announcement;
    }
}
