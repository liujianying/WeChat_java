package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.s$g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public class WxaBindBizInfoUI extends DrawStatusBarActivity {
    private ThreeDotsLoadingView gtb;
    private String gwV;
    a gwW;
    private LoadMoreRecyclerView gwX;
    private View gwY;
    private String mAppId;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this), i.actionbar_icon_dark_back);
        setMMTitle(j.app_brand_profile_biz_brand_belong_title);
        nS(-16777216);
        lF(-855310);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
        this.mAppId = getIntent().getStringExtra("app_id");
        this.gwX = (LoadMoreRecyclerView) findViewById(s$g.dataLv);
        this.gwW = new a(getLayoutInflater());
        this.gwX.setOnItemClickListener(new 2(this));
        this.gwW.ap(parcelableArrayListExtra);
        this.gwX.setItemAnimator(null);
        this.gwX.setOnLoadingStateChangedListener(new 3(this));
        this.gwX.setAdapter(this.gwW);
        View inflate = getLayoutInflater().inflate(h.wxa_bind_biz_ui_loading_footer, this.gwX, false);
        this.gtb = (ThreeDotsLoadingView) inflate.findViewById(s$g.loading_view);
        this.gtb.cAG();
        this.gwX.setLoadingView(inflate);
        this.gwY = getLayoutInflater().inflate(h.wxa_bind_biz_ui_no_more_footer, this.gwX, false);
        this.gwX.addFooterView(this.gwY);
        this.gwY.setVisibility(8);
        if (this.gwW.getItemCount() > 20) {
            this.gwX.ds(true);
            this.gwW.gxc = false;
        }
        this.mController.contentView.setBackgroundColor(-855310);
    }

    protected final int getLayoutId() {
        return h.wxa_bind_biz_info_ui;
    }
}
