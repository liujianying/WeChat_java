package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.game.f$a;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameTabBridgeUI extends GameCenterActivity {
    private BroadcastReceiver kcU = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) && GameTabBridgeUI.this != null && !GameTabBridgeUI.this.isFinishing()) {
                x.i("MicroMsg.GameTabBridgeUI", "GameTabBridgeUI exit!");
                GameTabBridgeUI.this.finish();
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameTabBridgeUI", "%s create", new Object[]{getClass().getSimpleName()});
        GameTabWidget.kda = hashCode();
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_EXIT");
        registerReceiver(this.kcU, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
        Intent intent = getIntent();
        GameTabData gameTabData = (GameTabData) intent.getParcelableExtra("tab_data");
        String stringExtra = intent.getStringExtra("tab_key");
        GameTabWidget gameTabWidget = (GameTabWidget) findViewById(e.tabwidget);
        a aVar = new a(this);
        gameTabWidget.setAdapter(aVar);
        aVar.a(gameTabData, stringExtra);
        intent.setComponent((ComponentName) intent.getParcelableExtra("next_tab_component"));
        f.a("com.tencent.mm:tools", null, GameTabWidget.a.class, new 1(this, System.currentTimeMillis(), intent));
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameTabBridgeUI.this.goBack();
                return true;
            }
        });
        setMMTitle(i.game_wechat_game);
    }

    protected void onResume() {
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
    }

    protected final boolean aUL() {
        return false;
    }

    public final int aUM() {
        return 0;
    }

    public final int aUN() {
        return 0;
    }

    public final int aUO() {
        return 0;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.game.f.f.game_bridge_layout;
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
        x.i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
        if (bi.oV(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.e(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(f$a.slide_left_in, f$a.slide_right_out);
            x.i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
        }
        sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
    }
}
