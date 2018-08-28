package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class TopStoryTabHomeUI extends MMActivity {
    private c ozE = new c(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
        this.ozE.onCreate(bundle);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ozE.yd(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onResume() {
        super.onResume();
        this.ozE.onResume();
    }

    protected void onPause() {
        this.ozE.onPause();
        super.onPause();
    }

    protected void onDestroy() {
        this.ozE.onDestroy();
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        this.ozE.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    protected final int getLayoutId() {
        return e.top_story_home_ui;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ozE.onSaveInstanceState(bundle);
    }
}
