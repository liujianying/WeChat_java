package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.api.b;
import com.tencent.mm.api.e;
import com.tencent.mm.api.m;
import com.tencent.mm.api.m.a.a;
import com.tencent.mm.api.m.c;
import com.tencent.mm.plugin.w.a$d;
import com.tencent.mm.ui.MMActivity;

public class TestVideoEditUI extends MMActivity implements e {
    private m lqK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(a$d.content);
        this.lqK = m.bwV.tY();
        m mVar = this.lqK;
        a aVar = new a();
        aVar.bwX = false;
        aVar.bwZ = true;
        aVar.bxa = new Rect(0, 0, 1080, 1080);
        aVar.bwW = c.bxb;
        mVar.a(aVar.uk());
        b aQ = this.lqK.aQ(this.mController.tml);
        aQ.setActionBarCallback(this);
        frameLayout.addView(aQ, new LayoutParams(-1, -1));
        aQ.setSelectedFeatureListener(new 1(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.lqK.onDestroy();
    }

    public void onBackPressed() {
        if (!this.lqK.tW()) {
            finish();
        }
    }

    public void onSwipeBack() {
        super.onSwipeBack();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.w.a.e.test_video_edit_ui;
    }

    public final void onFinish() {
        this.lqK.a(new 2(this));
    }

    public final void ua() {
        finish();
    }
}
