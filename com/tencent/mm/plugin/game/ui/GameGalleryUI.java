package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameGalleryUI extends MMActivity implements e {
    private String appId = "";
    private MMDotView gKU;
    private ViewPager hE;
    private int iMP = -1;
    private int jYI = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.hE = (ViewPager) findViewById(f.e.game_gallery);
        this.gKU = (MMDotView) findViewById(f.e.game_gallery_indicator);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("URLS");
        if (stringArrayExtra == null) {
            finish();
            return;
        }
        int intExtra = getIntent().getIntExtra("CURRENT", 0);
        if (intExtra < 0 || intExtra >= stringArrayExtra.length) {
            intExtra = 0;
        }
        this.appId = getIntent().getStringExtra("REPORT_APPID");
        this.iMP = getIntent().getIntExtra("REPORT_SCENE", -1);
        this.jYI = getIntent().getIntExtra("SOURCE_SCENE", 0);
        this.hE.setAdapter(new a(this, stringArrayExtra));
        this.hE.setOnPageChangeListener(this);
        this.hE.k(intExtra, false);
        this.gKU.setInvertedStyle(true);
        this.gKU.setDotCount(stringArrayExtra.length);
        this.gKU.setSelectedDot(intExtra);
        if (intExtra == 0) {
            an.a(this, this.iMP, 1202, 1, 12, this.appId, this.jYI, null);
        }
    }

    protected final int getLayoutId() {
        return f.f.game_gallery;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void O(int i) {
        this.gKU.setSelectedDot(i);
        an.a(this, this.iMP, 1202, i + 1, 12, this.appId, this.jYI, null);
    }

    public final void N(int i) {
    }
}
