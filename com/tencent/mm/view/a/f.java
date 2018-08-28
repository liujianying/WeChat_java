package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.n.a.d;
import com.tencent.mm.plugin.n.a.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.view.SmileySubGrid;
import com.tencent.mm.view.f.a;
import java.lang.ref.WeakReference;

public final class f extends w {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter";
    Context mContext;
    public int mCount;
    a uSK;
    public boolean uTT;
    public int uTU;
    public boolean uTV;
    public d uTW;
    WeakReference<e> uTX;

    public f(a aVar, Context context) {
        this.mContext = context;
        this.uSK = aVar;
    }

    public final int getItemViewType(int i) {
        com.tencent.mm.view.c.a GX = this.uSK.GX(i);
        String str = GX.iiv;
        int i2 = "TAG_DEFAULT_TAB".equals(str) ? a.a.uWN : (String.valueOf(EmojiGroupInfo.tcz).equals(str) || String.valueOf(EmojiGroupInfo.tcy).equals(str)) ? a.a.uWO : !GX.uVz ? a.a.uWM : a.a.uWO;
        switch (1.uTY[i2 - 1]) {
            case 1:
                return 0;
            case 2:
                if (this.uSK.cCL() && i == 0) {
                    return 3;
                }
                return 1;
            case 3:
                return 2;
            default:
                return super.getItemViewType(i);
        }
    }

    public final float ak(int i) {
        if (this.uSK.cCL() && i == 0) {
            return 4.0f / ((float) this.uSK.GX(i).pGX);
        }
        return super.ak(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int itemViewType = getItemViewType(i);
        int i2 = (!this.uSK.cCL() || i <= 0) ? i : i - 1;
        com.tencent.mm.view.c.a GX = this.uSK.GX(i);
        Object tag = view == null ? null : view.getTag(e.smiley_panel_id);
        int intValue;
        if (tag instanceof Integer) {
            intValue = ((Integer) tag).intValue();
        } else {
            intValue = -1;
        }
        b bVar2;
        if (view == null || view.getTag() == null || intValue != itemViewType) {
            View n;
            switch (itemViewType) {
                case 0:
                    n = com.tencent.mm.pluginsdk.ui.chat.e.qML.n(this.mContext, this.uSK.cCI());
                    bVar2 = new b(this, n, itemViewType);
                    break;
                case 3:
                    n = LayoutInflater.from(this.mContext).inflate(com.tencent.mm.plugin.n.a.f.smiley_panel_recent_page, null);
                    bVar2 = new a(this, n, itemViewType);
                    break;
                default:
                    n = LayoutInflater.from(this.mContext).inflate(com.tencent.mm.plugin.n.a.f.smiley_panel_middle_page, null);
                    bVar2 = new b(this, n, itemViewType);
                    break;
            }
            n.setTag(bVar2);
            n.setTag(e.smiley_panel_id, Integer.valueOf(itemViewType));
            bVar = bVar2;
            view = n;
        } else {
            bVar2 = (b) view.getTag();
            view.setTag(e.smiley_panel_id, Integer.valueOf(itemViewType));
            bVar = bVar2;
        }
        int i3 = this.uSK.abS(GX.iiv).uVx;
        int i4 = GX.uVy;
        switch (itemViewType) {
            case 0:
                bVar.uUb.setProductID(GX.iiv);
                break;
            case 1:
                ListAdapter listAdapter;
                if (this.uSK.cCL() && i == 1) {
                    this.uTW = new d(this.mContext, this.uSK);
                    listAdapter = this.uTW;
                } else {
                    listAdapter = new b(this.mContext, this.uSK);
                }
                bVar.uUc.setAdapter(listAdapter);
                bVar.uUc.cCb();
                bVar.uUc.setCallback(GX.getSmileyPanelCallback());
                bVar.uUc.setOnTextOperationListener(GX.cCo());
                bVar.uUc.setNumColumns(GX.pGX);
                bVar.uUc.setColumnWidth(GX.getColumnWidth());
                bVar.uUc.setScrollbarFadingEnabled(false);
                bVar.uUc.setVerticalScrollBarEnabled(false);
                bVar.uUc.setSelector(d.mm_trans);
                bVar.uUc.setHorizontalScrollBarEnabled(false);
                bVar.uUc.setLongClickable(false);
                bVar.uUc.setPadding(0, i4, 0, 0);
                bVar.uUc.setVerticalSpacing(i3);
                bVar.uUc.i(GX.getType(), i2 - GX.gKG, GX.uVw, GX.aqd(), GX.cCn());
                bVar.uUc.setIsShowPopWin(false);
                bVar.uUc.setScene(this.uSK.fdx);
                listAdapter.c(GX.getType(), GX.uVw, GX.aqd(), GX.cCn(), i2 - GX.gKG, GX.pGW, GX.pGX);
                listAdapter.uTI = GX.iiv;
                break;
            case 2:
                c cVar = new c(this.mContext, this.uSK);
                bVar.uUc.setAdapter(cVar);
                bVar.uUc.cCb();
                bVar.uUc.setNumColumns(GX.pGX);
                bVar.uUc.setColumnWidth(GX.getColumnWidth());
                bVar.uUc.setScrollbarFadingEnabled(false);
                bVar.uUc.setHorizontalScrollBarEnabled(false);
                bVar.uUc.setVerticalScrollBarEnabled(false);
                bVar.uUc.setCallback(GX.getSmileyPanelCallback());
                bVar.uUc.setFastScrollEnabled(false);
                bVar.uUc.setViewParent(GX.uVv.uVF);
                bVar.uUc.cCb();
                bVar.uUc.setPadding(0, i4, 0, 0);
                bVar.uUc.setVerticalSpacing(i3 / 2);
                bVar.uUc.setIsShowPopWin(true);
                bVar.uUc.setScene(this.uSK.fdx);
                bVar.uUc.i(GX.getType(), i - GX.gKG, GX.uVw, GX.aqd(), GX.cCn());
                cVar.c(GX.getType(), GX.uVw, GX.pGX * GX.pGW, GX.cCn(), i - GX.gKG, GX.pGW, GX.pGX);
                cVar.uTI = GX.iiv;
                if (cVar.uSC != 23) {
                    if (cVar.uSC == 25) {
                        cVar.inB = ((c) g.n(c.class)).getProvider().aDY();
                        break;
                    }
                }
                cVar.inB = ((c) g.n(c.class)).getProvider().zt(cVar.uTI);
                break;
                break;
            case 3:
                if (bVar instanceof a) {
                    a aVar = (a) bVar;
                    i3 = viewGroup.getWidth();
                    i4 = aVar.uUa.uSK.abS(GX.iiv).uVx;
                    itemViewType = GX.uVy;
                    LayoutParams layoutParams = (LayoutParams) aVar.uUc.getLayoutParams();
                    layoutParams.width = (i3 / GX.pGX) * 3;
                    layoutParams.topMargin = itemViewType;
                    layoutParams.height = (aVar.uUa.uSK.uWh * GX.pGW) + ((GX.pGW - 1) * i4);
                    aVar.uUc.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) aVar.uTZ.getLayoutParams();
                    layoutParams.height = itemViewType;
                    aVar.uTZ.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) aVar.eCO.getLayoutParams();
                    layoutParams.leftMargin = (i3 / GX.pGX) / 2;
                    layoutParams.topMargin = aVar.uUa.uSK.uWh / 4;
                    layoutParams.bottomMargin = aVar.uUa.uSK.uWh / 4;
                    aVar.eCO.setLayoutParams(layoutParams);
                    e eVar = new e(aVar.uUa.mContext, aVar.uUa.uSK);
                    aVar.uUc.setAdapter(eVar);
                    aVar.uUc.setNumColumns(3);
                    aVar.uUc.setColumnWidth(GX.getColumnWidth());
                    aVar.uUc.setVerticalSpacing(i4);
                    aVar.uUc.setOnTextOperationListener(GX.cCo());
                    SmileySubGrid smileySubGrid = aVar.uUc;
                    smileySubGrid.setOnItemClickListener(smileySubGrid.uSH);
                    aVar.uUc.setLongClickable(false);
                    aVar.uUc.setIsShowPopWin(false);
                    aVar.uUc.setVerticalScrollBarEnabled(false);
                    eVar.c(GX.getType(), GX.uVw, GX.aqd(), GX.cCn() * GX.pGX, GX.gKG, GX.pGW, 3);
                    eVar.update();
                    aVar.uUa.uTX = new WeakReference(eVar);
                    break;
                }
                break;
        }
        return view;
    }

    public final int getCount() {
        return this.mCount;
    }

    public final int k(Object obj) {
        if (!this.uTT) {
            return super.k(obj);
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "get item position always changed");
        return -2;
    }

    public final void cCe() {
        a aVar = this.uSK;
        this.mCount = aVar.uWu ? aVar.abS("TAG_DEFAULT_TAB").cCn() : aVar.jub;
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "refresh data mCount:%d", Integer.valueOf(this.mCount));
    }

    public final void as(int i, boolean z) {
        this.uTU = i;
        if (this.uTU != 0 || z) {
            this.uSK.cCM();
            if (this.uTX != null && this.uTX.get() != null) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "update at page " + this.uTU);
                ((e) this.uTX.get()).update();
                return;
            }
            return;
        }
        this.uTV = true;
    }
}
