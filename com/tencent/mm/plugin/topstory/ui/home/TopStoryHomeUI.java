package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class TopStoryHomeUI extends MMActivity {
    private b ozv = new b(this, true);

    public void onCreate(Bundle bundle) {
        this.tlN = true;
        super.onCreate(bundle);
        x.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
        this.ozv.onCreate(bundle);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ozv.yd(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onResume() {
        super.onResume();
        this.ozv.onResume();
    }

    protected void onPause() {
        this.ozv.onPause();
        super.onPause();
    }

    protected void onDestroy() {
        this.ozv.onDestroy();
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        this.ozv.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    protected final int getLayoutId() {
        return e.top_story_home_ui;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ozv.onSaveInstanceState(bundle);
    }
}
