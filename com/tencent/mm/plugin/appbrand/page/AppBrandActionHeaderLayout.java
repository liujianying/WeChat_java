package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;

public class AppBrandActionHeaderLayout extends LinearLayout {
    public LinearLayout glR;
    public HorizontalScrollView glS;
    public AppBrandActionSingleHeaderView glT;
    private AppBrandActionMultipleHeaderView glU;
    private AppBrandActionMultipleHeaderView glV;
    private AppBrandActionMultipleHeaderView glW;
    private AppBrandActionMultipleHeaderView glX;
    private TextView glY;
    private int glZ = 1;
    private int gma = 2;
    private String mAppId;
    private Context mContext;

    public AppBrandActionHeaderLayout(Context context) {
        super(context);
        co(context);
    }

    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        co(context);
    }

    @TargetApi(11)
    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        co(context);
    }

    private void co(Context context) {
        this.mContext = context;
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(h.appbrand_action_game_header_layout, this);
        this.glR = (LinearLayout) findViewById(g.appbrand_action_header_single_layout);
        this.glS = (HorizontalScrollView) findViewById(g.appbrand_action_header_hscrollview);
        this.glT = (AppBrandActionSingleHeaderView) findViewById(g.appbrand_action_single_header_view);
        this.glU = (AppBrandActionMultipleHeaderView) findViewById(g.appbrand_action_multiple_header_view1);
        this.glV = (AppBrandActionMultipleHeaderView) findViewById(g.appbrand_action_multiple_header_view2);
        this.glW = (AppBrandActionMultipleHeaderView) findViewById(g.appbrand_action_multiple_header_view3);
        this.glX = (AppBrandActionMultipleHeaderView) findViewById(g.appbrand_action_multiple_header_view4);
        this.glY = (TextView) findViewById(g.appbrand_action_header_status);
        this.glU.setVisibility(8);
        this.glV.setVisibility(8);
        this.glW.setVisibility(8);
        this.glX.setVisibility(8);
        this.glY.setVisibility(8);
    }

    public void setActionHeaderStyle(boolean z) {
        if (z) {
            this.glT.setTextViewTextColor(this.mContext.getResources().getColor(c.white_text_color));
            this.glU.setTextViewTextColor(this.mContext.getResources().getColor(c.white_text_color));
            this.glV.setTextViewTextColor(this.mContext.getResources().getColor(c.white_text_color));
            this.glW.setTextViewTextColor(this.mContext.getResources().getColor(c.white_text_color));
            this.glX.setTextViewTextColor(this.mContext.getResources().getColor(c.white_text_color));
            this.glY.setTextColor(this.mContext.getResources().getColor(c.white_text_color));
            return;
        }
        this.glT.setTextViewTextColor(this.mContext.getResources().getColor(c.bottom_sheet_text_color));
        this.glU.setTextViewTextColor(this.mContext.getResources().getColor(c.bottom_sheet_text_color));
        this.glV.setTextViewTextColor(this.mContext.getResources().getColor(c.bottom_sheet_text_color));
        this.glW.setTextViewTextColor(this.mContext.getResources().getColor(c.bottom_sheet_text_color));
        this.glX.setTextViewTextColor(this.mContext.getResources().getColor(c.bottom_sheet_text_color));
        this.glY.setTextColor(this.mContext.getResources().getColor(c.bottom_sheet_text_color));
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setStatusId(int i) {
        this.glY.setText(i);
        this.glY.setVisibility(0);
        this.glR.setVisibility(8);
        this.glS.setVisibility(8);
    }
}
