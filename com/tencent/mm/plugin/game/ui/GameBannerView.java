package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.smtt.utils.TbsLog;
import java.util.LinkedList;

public class GameBannerView extends LinearLayout implements e, OnClickListener {
    private MMDotView gKU;
    private ViewPager hE;
    private float hlo = 0.0f;
    private int jNv = 0;
    private b jUj;
    LinkedList<a> jUk;
    al jUl = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean vD() {
            if (GameBannerView.this.hE == null || GameBannerView.this.jUk.size() <= 1) {
                GameBannerView.this.jUl.SO();
                return false;
            }
            GameBannerView.this.hE.k(GameBannerView.this.hE.getCurrentItem() + 1, true);
            return true;
        }
    }, true);
    private float jUm = 0.0f;
    private Context mContext;

    public static class a {
        public String dGg;
        public int index;
        public String jLe;
        public f jUo;
    }

    public GameBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        inflate(context, com.tencent.mm.plugin.game.f.f.game_banner_view, this);
        this.jUk = new LinkedList();
    }

    public void setSourceScene(int i) {
        this.jNv = i;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.gKU = (MMDotView) findViewById(com.tencent.mm.plugin.game.f.e.game_ad_dot);
        this.hE = (ViewPager) findViewById(com.tencent.mm.plugin.game.f.e.game_ad_flipper);
        this.hE.setOnPageChangeListener(this);
        this.jUj = new b(this, (byte) 0);
    }

    public void setBannerList(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.GameBannerView", "Empty banner list");
            setVisibility(8);
            return;
        }
        x.i("MicroMsg.GameBannerView", "bannerList size", new Object[]{Integer.valueOf(linkedList.size())});
        this.jUl.SO();
        this.jUk.clear();
        this.jUk.addAll(linkedList);
        this.hE.setAdapter(this.jUj);
        this.hE.k(linkedList.size() * TbsLog.TBSLOG_CODE_SDK_BASE, false);
        if (this.jUk.size() > 1) {
            this.jUl.J(5000, 5000);
        }
        this.gKU.setVisibility(8);
        setVisibility(0);
    }

    public final void N(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void O(int i) {
        int size = i % this.jUk.size();
        x.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", new Object[]{Integer.valueOf(i), Integer.valueOf(size)});
        if (((a) this.jUk.get(size)).jUo != null && g.Eg().Dx()) {
            an.a(this.mContext, 11, 1101, size + 1, 1, this.jNv, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action) {
            case 0:
                this.jUm = rawX;
                this.hlo = rawY;
                break;
            case 1:
            case 3:
                fy(false);
                this.jUm = 0.0f;
                this.hlo = 0.0f;
                break;
            case 2:
                if (Math.abs((int) (rawX - this.jUm)) > Math.abs((int) (rawY - this.hlo))) {
                    fy(true);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.jUl.SO();
                break;
            case 1:
            case 3:
                this.jUl.J(5000, 5000);
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void fy(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            f fVar = aVar.jUo;
            if (bi.oW(aVar.jLe)) {
                x.i("MicroMsg.GameBannerView", "null or nil url");
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", fVar.field_appId);
                bundle.putInt("game_report_from_scene", 5);
                an.a(this.mContext, 11, 1101, 1, c.b(this.mContext, fVar.field_appId, null, bundle), this.jNv, null);
                return;
            }
            an.a(this.mContext, 11, 1101, 1, c.an(this.mContext, aVar.jLe), this.jNv, null);
        }
    }
}
