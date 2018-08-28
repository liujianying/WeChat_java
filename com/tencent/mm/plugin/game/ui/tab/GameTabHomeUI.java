package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.game.f$a;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterUI5;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameTabHomeUI extends GameCenterUI5 {
    private BroadcastReceiver kcU = new 2(this);
    public String kcX;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameTabHomeUI", "%s create", new Object[]{getClass().getSimpleName()});
        GameTabData gameTabData = (GameTabData) getIntent().getParcelableExtra("tab_data");
        this.kcX = getIntent().getStringExtra("tab_key");
        GameTabWidget gameTabWidget = (GameTabWidget) findViewById(e.tabwidget);
        a aVar = new a(this);
        gameTabWidget.setAdapter(aVar);
        aVar.a(gameTabData, this.kcX);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.kcU, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
        setBackBtn(new 1(this));
    }

    protected void onResume() {
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            if (!bi.oV(this.kcX).equals(intent.getStringExtra("tab_key"))) {
                x.i("MicroMsg.GameTabHomeUI", "reload %s. current_key:%s, next_key:%s", new Object[]{getClass().getSimpleName(), this.kcX, intent.getStringExtra("tab_key")});
                finish();
                startActivity(intent);
            }
            overridePendingTransition(f$a.in_no_slide, f$a.in_no_slide);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.kcU);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        x.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI goBack!");
        if (bi.oV(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.e(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(f$a.slide_left_in, f$a.slide_right_out);
            x.i("MicroMsg.GameTabHomeUI", "back to FindMoreFriendsUI");
        }
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
    }
}
