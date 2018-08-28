package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter extends LinearLayout {
    private MMActivity bGc;
    private ImageButton gIl;
    private boolean kXK = true;
    private b qlA;
    private WebViewSmileyPanel qlB;
    private View qlC;
    private View qlD;
    private View qlE;
    MMEditText qlF;
    private LinearLayout qlG;
    private boolean qlH;
    private int qlI = Integer.MAX_VALUE;
    private c qly;
    private a qlz;
    private int state = 0;

    public final void setOnTextSendListener(c cVar) {
        this.qly = cVar;
    }

    public final void setOnSmileyChosenListener(a aVar) {
        this.qlz = aVar;
    }

    public final void setOnSmileyPanelVisibilityChangedListener(b bVar) {
        this.qlA = bVar;
    }

    public WebViewInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.bGc, R.i.webview_input_footer, this);
        this.qlG = (LinearLayout) viewGroup.findViewById(R.h.webview_input_container);
        this.qlD = viewGroup.findViewById(R.h.webview_input_send_btn);
        this.qlE = viewGroup.findViewById(R.h.webview_input_green_send_btn);
        this.qlC = viewGroup.findViewById(R.h.webview_input_send_button_container);
        this.qlF = (MMEditText) viewGroup.findViewById(R.h.webview_input_content_edit);
        this.gIl = (ImageButton) viewGroup.findViewById(R.h.webview_input_smiley_image);
        this.gIl.setOnClickListener(new 1(this));
        this.qlF.setOnTouchListener(new 2(this));
        this.qlB = new WebViewSmileyPanel(getContext());
        this.qlB.setVisibility(8);
        this.qlB.setBackgroundResource(R.g.bottombar_bg);
        this.qlB.setOnTextOperationListener(new 3(this));
        ((LinearLayout) findViewById(R.h.root)).addView(this.qlB, -1, 0);
        this.qlE.setOnClickListener(new 4(this));
        this.qlF.addTextChangedListener(new 5(this));
    }

    private int bWd() {
        if (this.qlA != null) {
            this.qlA.aSX();
        }
        if (this.qlF != null) {
            this.bGc.hideVKB(this.qlF);
        }
        this.qlB.setVisibility(0);
        WebViewSmileyPanel webViewSmileyPanel = this.qlB;
        if (webViewSmileyPanel.FU != null) {
            webViewSmileyPanel.FU.setVisibility(0);
        }
        LayoutParams layoutParams = this.qlB.getLayoutParams();
        if (layoutParams != null && this.kXK) {
            layoutParams.height = j.fA(getContext());
            this.qlB.setLayoutParams(layoutParams);
        }
        if (layoutParams != null) {
            return layoutParams.height;
        }
        return 0;
    }

    private void hideSmileyPanel() {
        if (this.qlA != null) {
            this.qlA.aSY();
        }
        this.qlB.setVisibility(8);
        this.gIl.setImageResource(R.k.textfield_icon_emoji_normal);
        this.state = 0;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bYz();
        if (!(this.qlF == null || this.bGc == null)) {
            this.bGc.hideVKB(this.qlF);
        }
        this.qlF = null;
        WebViewSmileyPanel webViewSmileyPanel = this.qlB;
        c cVar = webViewSmileyPanel.qlL;
        cVar.qlR = null;
        cVar.gKE = null;
        if (webViewSmileyPanel.FU != null) {
            ((ViewGroup) webViewSmileyPanel.FU.getParent()).removeView(webViewSmileyPanel.FU);
            ((ViewGroup) webViewSmileyPanel.FU).removeAllViews();
            webViewSmileyPanel.FU = null;
        }
        webViewSmileyPanel.gKS = null;
        removeAllViews();
        this.bGc = null;
        this.qly = null;
    }

    public final void setText(String str) {
        this.qlF.setText("");
        if (!bi.oW(str)) {
            try {
                this.qlF.append(str);
            } catch (Exception e) {
                x.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[]{e});
            }
            x.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[]{this.qlF.getText()});
        }
    }

    public final void setMaxCount(int i) {
        if (i > 0) {
            this.qlI = i;
        }
    }

    private void bYz() {
        if (this.qlF != null) {
            this.qlF.clearFocus();
            this.qlF.setFocusable(false);
            this.qlF.setFocusableInTouchMode(false);
        }
    }

    public final void show() {
        setVisibility(0);
        if (this.qlG != null) {
            this.qlG.setVisibility(0);
        }
        if (this.qlF != null) {
            this.qlF.setEnabled(true);
            this.qlF.setBackgroundResource(R.g.input_bar_bg_active);
        }
        if (this.qlC != null) {
            this.qlC.setVisibility(0);
        }
        this.qlH = false;
        if (this.qlF != null) {
            this.qlF.setFocusable(true);
            this.qlF.setFocusableInTouchMode(true);
            this.qlF.requestFocus();
        }
        if (this.bGc != null) {
            this.bGc.showVKB();
        }
        this.state = 0;
    }

    public final int bYA() {
        setVisibility(0);
        if (this.qlG != null) {
            this.qlG.setVisibility(8);
        }
        this.qlH = true;
        this.state = 1;
        return bWd();
    }

    public final void hide() {
        setVisibility(8);
        if (this.bGc != null) {
            if (this.qlF != null) {
                this.bGc.hideVKB(this.qlF);
            }
            this.bGc.YC();
        }
        this.state = 0;
        hideSmileyPanel();
        bYz();
    }

    public final void bYB() {
        if (this.qlH) {
            setVisibility(8);
        }
        this.state = 0;
        hideSmileyPanel();
    }

    public final boolean isShown() {
        return getVisibility() == 0;
    }
}
