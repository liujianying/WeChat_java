package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameTabWebUI extends GameWebViewUI {
    private Activity activity;
    private BroadcastReceiver kcU = new 2(this);
    private String kcX;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameTabWebUI", "%s create", new Object[]{getClass().getSimpleName()});
        this.activity = this;
        GameTabData gameTabData = (GameTabData) getIntent().getParcelableExtra("tab_data");
        this.kcX = getIntent().getStringExtra("tab_key");
        GameTabWidget gameTabWidget = new GameTabWidget(this);
        a aVar = new a(this);
        gameTabWidget.setAdapter(aVar);
        aVar.a(gameTabData, this.kcX);
        ((LinearLayout) findViewById(R.h.webview_keyboard_ll)).addView(gameTabWidget);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.kcU, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameTabWebUI.this.goBack();
                return true;
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            if (!bi.oV(this.kcX).equals(intent.getStringExtra("tab_key"))) {
                x.i("MicroMsg.GameTabWebUI", "reload %s", new Object[]{this.activity.getClass().getSimpleName()});
                finish();
                startActivity(intent);
            }
            overridePendingTransition(R.a.in_no_slide, R.a.in_no_slide);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.kcU);
    }

    public void onBackPressed() {
        super.onBackPressed();
        goBack();
    }

    private void goBack() {
        x.i("MicroMsg.GameTabWebUI", "%s goBack!", new Object[]{this.activity.getClass().getSimpleName()});
        if (bi.oV(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.e(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.a.slide_left_in, R.a.slide_right_out);
            x.i("MicroMsg.GameTabWebUI", "back to FindMoreFriendsUI.");
        }
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
    }
}
