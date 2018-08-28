package com.tencent.mm.plugin.product.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import java.util.List;

@a(3)
public class MallGalleryUI extends MallBaseUI {
    private final String TAG = "MicroMsg.MallGalleryUI";
    private ViewPager lSo;
    private g lSp;
    private List<String> lSq;
    private int lSr = 0;
    private boolean lSs;

    static /* synthetic */ void c(MallGalleryUI mallGalleryUI) {
        mallGalleryUI.lSs = !mallGalleryUI.lSs;
        if (mallGalleryUI.lSs) {
            mallGalleryUI.mController.showTitleView();
        } else {
            mallGalleryUI.mController.hideTitleView();
        }
    }

    protected final int getLayoutId() {
        return g.product_gallery_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lSq = getIntent().getStringArrayListExtra("keys_img_urls");
        this.mController.hideTitleView();
        this.lSs = false;
        initView();
    }

    protected void onResume() {
        super.onResume();
        this.lSp.aK(this.lSq);
        this.lSp.notifyDataSetChanged();
        if (this.lSq != null) {
            this.lSq.size();
        }
    }

    protected final void initView() {
        this.lSo = (ViewPager) findViewById(f.mall_gallery);
        this.lSo.setOnPageChangeListener(new 1(this));
        this.lSp = new g(this);
        this.lSp.lSO = new 2(this);
        this.lSo.setAdapter(this.lSp);
        setBackBtn(new 3(this));
        addIconOptionMenu(0, e.mm_title_btn_menu, new 4(this));
    }

    final String bnc() {
        String str;
        if (this.lSq == null || this.lSq.size() < this.lSr + 1) {
            x.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
            str = null;
        } else {
            str = (String) this.lSq.get(this.lSr);
        }
        if (!bi.oW(str)) {
            return c.JC(str);
        }
        x.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
        return null;
    }
}
