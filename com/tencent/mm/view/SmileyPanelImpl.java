package com.tencent.mm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.bo.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.n.a.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.view.e.a.3;
import com.tencent.mm.view.e.a.a;
import com.tencent.mm.view.f.a.1;
import java.util.Iterator;

public class SmileyPanelImpl extends SmileyPanel implements a {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanel";
    private boolean gIv = false;
    private com.tencent.mm.view.e.a uSJ;
    private com.tencent.mm.view.f.a uSK;

    public SmileyPanelImpl(Context context) {
        super(context, null);
        init();
    }

    public SmileyPanelImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.uSK = new com.tencent.mm.view.f.a();
        this.uSJ = new com.tencent.mm.view.e.a(getContext(), this.uSK, this);
    }

    public final void onResume() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
        com.tencent.mm.view.f.a aVar = this.uSK;
        aVar.uWz = true;
        aVar.cCK();
        aVar.cCB();
        com.tencent.mm.view.e.a aVar2 = this.uSJ;
        if (!(aVar2.uVG == null || aVar2.uVF == null)) {
            aVar2.uVG.as(aVar2.uVF.getCurrentItem(), true);
        }
        aVar2.cCt();
        aVar2.cCv();
    }

    public void setShowProductId(String str) {
        this.uSK.setShowProductId(str);
    }

    public final void onPause() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
        this.uSK.onPause();
    }

    public final void destroy() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDestroy");
        this.qFa = null;
        if (this.uSJ != null) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "ui clear");
            com.tencent.mm.view.e.a aVar = this.uSJ;
            aVar.cCr();
            aVar.gKE = null;
            if (aVar.uVF != null) {
                aVar.uVF.setAdapter(null);
            }
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager destroy remove listener.");
            ((c) g.n(c.class)).getProvider().i(aVar.uVX);
            ((c) g.n(c.class)).getProvider().g(aVar.igR);
            ((c) g.n(c.class)).getProvider().k(aVar.uVY);
            com.tencent.mm.sdk.b.a.sFg.c(aVar.igS);
            this.uSJ = null;
        }
        if (this.uSK != null) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "stg clear");
            this.uSK.onPause();
            com.tencent.mm.view.f.a aVar2 = this.uSK;
            Iterator it = aVar2.uWG.iterator();
            while (it.hasNext()) {
                com.tencent.mm.view.c.a aVar3 = (com.tencent.mm.view.c.a) it.next();
                if (aVar3 != null) {
                    aVar3.uSK = null;
                    aVar3.uVv = null;
                }
            }
            aVar2.cCJ();
        }
        ((c) g.n(c.class)).getProvider().onDestroy();
    }

    public void setCallback(f fVar) {
        super.setCallback(fVar);
    }

    public void setSendButtonEnable(boolean z) {
        com.tencent.mm.view.e.a aVar = this.uSJ;
        if (aVar.uVP != null) {
            aVar.uVP.setEnabled(z);
        }
    }

    public final void ul() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "dealOrientationChange");
        this.uSJ.uSK.OT = 0;
    }

    public final void um() {
        this.qFa = null;
    }

    public final void refresh() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "reflesh");
        try {
            if (this.uSK != null && this.uSJ != null) {
                this.uSJ.cCw();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanel", e, "", new Object[0]);
        }
    }

    public final void un() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideCustomBtn");
        this.uSK.uWu = true;
    }

    public final void uo() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "[hideDefaultBtn]");
        this.uSK.uWv = true;
    }

    public final void i(boolean z, boolean z2) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        this.uSK.uWw = z;
        this.uSK.uWx = z2;
    }

    public final void aE(boolean z) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSendButton:B", new Object[]{Boolean.valueOf(z)});
        this.uSJ.mL(z);
        this.uSK.uWA = true;
    }

    public ChatFooterPanel.a getTextOpListener() {
        return this.qFa;
    }

    public j getSmileyPanelCallback() {
        return (j) this.qFb;
    }

    public void setPortHeightPx(int i) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[]{Integer.valueOf(i)});
        this.uSK.OT = 0;
        com.tencent.mm.view.f.a aVar = this.uSK;
        if (aVar.uWl != i) {
            aVar.uWF = false;
            aVar.uWE = false;
        }
        aVar.uWl = i;
        this.uSK.cCA();
        this.uSK.GW(i - this.uSK.uWb);
        this.uSK.gLa = 0;
    }

    public int getBottomHeightPx() {
        return this.uSK.uWl;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setVisibility(int i) {
        int i2 = 0;
        super.setVisibility(i);
        if (i == 0) {
            this.gIv = false;
            if (this.uSJ != null) {
                com.tencent.mm.view.e.a aVar = this.uSJ;
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initView begin");
                if (this == null) {
                    return;
                }
                if (aVar.mView != null && getChildCount() > 0) {
                    x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "already load view --- pass");
                    if (aVar.uVG != null) {
                        aVar.uVG.as(aVar.uVF.getCurrentItem(), true);
                    }
                    aVar.cCq();
                    return;
                } else if (aVar.uSK == null) {
                    x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "mPanelStg is null");
                    return;
                } else {
                    aVar.uSK.uWK = false;
                    if (aVar.mView == null) {
                        aVar.mView = View.inflate(aVar.rc, com.tencent.mm.plugin.n.a.f.smiley_panel_main, null);
                    } else if (aVar.mView.getParent() != null) {
                        ((ViewGroup) aVar.mView.getParent()).removeView(aVar.mView);
                    }
                    aVar.uVF = (SmileyPanelViewPager) aVar.findViewById(e.smiley_panel_view_pager);
                    aVar.uVF.setPanelStg(aVar.uSK);
                    aVar.uVF.setSmileyPanelViewPagerLayoutListener(aVar);
                    aVar.uVF.setOnPageChangeListener(aVar);
                    aVar.uVF.setOffscreenPageLimit(3);
                    aVar.uSK.gLa = aVar.uVF.getWidth();
                    aVar.uVH = (SmileyPanelScrollView) aVar.findViewById(e.smiley_panel_dot);
                    aVar.uVH.setOnPageSelectListener(aVar);
                    aVar.uVH.setSmileyPanelStg(aVar.uSK);
                    aVar.uVI = (HorizontalListViewV2) aVar.findViewById(e.smiley_list_view);
                    aVar.uVJ = new com.tencent.mm.view.a.g(aVar.gKE, aVar.uSK);
                    aVar.uVI.setAdapter(aVar.uVJ);
                    aVar.uVI.setOnItemClickListener(aVar.uVZ);
                    aVar.uVP = (TextView) aVar.findViewById(e.send_btn);
                    aVar.uVL = (ImageView) aVar.findViewById(e.right_store_btn);
                    aVar.uVL.setOnClickListener(aVar);
                    aVar.uVK = aVar.findViewById(e.right_stoe_btn_container);
                    aVar.uVM = (ImageView) aVar.findViewById(e.right_store_btn_new);
                    aVar.uVP.setOnClickListener(aVar);
                    aVar.uVP.setVisibility(aVar.uSK.cCE() ? 0 : 8);
                    addView(aVar.mView, new LayoutParams(-1, -1));
                    aVar.uSK.uWK = true;
                    View view = aVar.uVK;
                    int i3 = (aVar.uSK.uWu || aVar.uSK.uWv) ? 8 : 0;
                    view.setVisibility(i3);
                    aVar.uVO = (ImageButton) aVar.findViewById(e.hide_panel_btn);
                    aVar.uVO.setOnClickListener(aVar);
                    ImageButton imageButton = aVar.uVO;
                    if (!(aVar.uSK.uWv && aVar.uSK.fdx == ChatFooterPanel.qFf)) {
                        i2 = 8;
                    }
                    imageButton.setVisibility(i2);
                    return;
                }
            }
            x.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley Panel Manager is null.");
        } else if (this.uSK != null) {
            this.uSK.cCJ();
        } else {
            x.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley PanelStg Manager is null.");
        }
    }

    public void setTalkerName(String str) {
        this.uSK.qLj = str;
    }

    public void setDefaultEmojiByDetail(String str) {
        com.tencent.mm.view.f.a aVar = this.uSK;
        aVar.setShowProductId(str);
        aVar.cCA();
        if (aVar.uWJ == null) {
            aVar.uWJ = new 1(aVar);
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "add succeed send listener");
        com.tencent.mm.sdk.b.a.sFg.b(aVar.uWJ);
    }

    protected void onMeasure(int i, int i2) {
        if (this.gIv) {
            setVisibility(8);
            i = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setHide(boolean z) {
        this.gIv = z;
    }

    public final void uq() {
        this.uSK.uWC = true;
    }

    public final void up() {
        if (this.uSJ != null) {
            com.tencent.mm.view.e.a aVar = this.uSJ;
            String str = "TAG_DEFAULT_TAB";
            if (!(aVar.uVF == null || aVar.uSK == null)) {
                if (aVar.uVT) {
                    aVar.uVU = null;
                    aVar.uVF.post(new 3(aVar, str));
                } else {
                    aVar.uVU = str;
                }
            }
        }
        if (this.uSK != null) {
            com.tencent.mm.bo.a.cgy();
            b bVar = com.tencent.mm.bo.a.sCv;
            b.VP("TAG_DEFAULT_TAB");
        }
    }

    public void setEntranceScene(int i) {
        if (this.uSK != null) {
            this.uSK.fdx = i;
        }
    }
}
