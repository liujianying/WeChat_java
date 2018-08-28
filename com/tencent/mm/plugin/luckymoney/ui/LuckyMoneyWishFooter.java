package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter extends BasePanelKeybordLayout {
    private MMActivity bGc;
    private ImageButton kXE;
    private MMEditText kXF;
    private Button kXG;
    private ChatFooterPanel kXH;
    boolean kXI = false;
    public boolean kXJ = false;
    private boolean kXK = true;
    boolean kXL = true;
    private TextWatcher kXM = new 1(this);
    private a kXN;
    private c kXO;
    private int state = 0;

    public interface b {
        void Gf(String str);
    }

    public void setModeClick(boolean z) {
        this.kXI = z;
    }

    public LuckyMoneyWishFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.bGc, g.lucky_money_wish_footer, this);
        this.kXG = (Button) viewGroup.findViewById(f.lucky_money_wish_send_btn);
        go(false);
        this.kXE = (ImageButton) viewGroup.findViewById(f.lucky_money_wish_mode_iv);
        this.kXE.setOnClickListener(new 2(this));
        this.kXF = (MMEditText) viewGroup.findViewById(f.lucky_money_wish_content_et);
        this.kXF.setOnTouchListener(new 3(this));
        if (e.qMK == null) {
            this.kXH = new d(this.bGc);
            return;
        }
        this.kXH = e.qMK.da(getContext());
        this.kXH.setEntranceScene(ChatFooterPanel.qFd);
        this.kXH.setVisibility(8);
        this.kXH.setBackgroundResource(a.e.bottombar_bg);
        ((LinearLayout) findViewById(f.root)).addView(this.kXH, -1, 0);
        this.kXH.un();
        this.kXH.aE(false);
        this.kXH.setOnTextOperationListener(new 4(this));
    }

    public void setVisibility(int i) {
        boolean z;
        this.state = 0;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.kXH != null) {
            x.i("MicroMsg.SnsCommentFooter", "showState " + z);
            if (z) {
                if (this.state == 0) {
                    this.bGc.showVKB();
                    this.kXF.requestFocus();
                    this.kXH.setVisibility(8);
                } else {
                    this.bGc.YC();
                    this.kXF.requestFocus();
                    apI();
                }
                this.kXK = false;
            } else {
                this.kXH.setVisibility(8);
                this.kXE.setImageResource(h.textfield_icon_emoji_normal);
                this.bGc.YC();
                requestLayout();
            }
        }
        super.setVisibility(i);
    }

    private void apI() {
        this.kXH.onResume();
        this.kXH.setVisibility(0);
        LayoutParams layoutParams = this.kXH.getLayoutParams();
        if ((layoutParams != null && layoutParams.height <= 0) || (layoutParams != null && j.fC(getContext()) && this.kXK)) {
            layoutParams.height = j.fA(getContext());
            this.kXH.setLayoutParams(layoutParams);
            this.kXK = false;
        }
    }

    public void setMaxLength(int i) {
        this.kXF.setFilters(new InputFilter[]{new LengthFilter(i)});
    }

    public final boolean a(MMEditText.a aVar) {
        if (this.kXF == null) {
            return false;
        }
        this.kXF.setBackListener(aVar);
        return true;
    }

    public void setText(String str) {
        if (this.kXF != null) {
            this.kXF.setText("");
            this.kXF.abr(str);
        }
    }

    public void setHint(String str) {
        this.kXF.setHint(str);
    }

    public void setOnEditTouchListener(a aVar) {
        this.kXN = aVar;
    }

    public void setOnSmileyShowListener(c cVar) {
        this.kXO = cVar;
    }

    public void setOnWishSendImp(b bVar) {
        this.kXG.setOnClickListener(new 5(this, bVar));
    }

    protected final void qN(int i) {
        super.qN(i);
        switch (i) {
            case -3:
                this.kXJ = true;
                return;
            default:
                this.kXJ = false;
                return;
        }
    }

    public final void bbE() {
        if (this.kXH != null) {
            x.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.kXH.um();
            this.kXH.destroy();
        }
    }

    private void go(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.a.pop_in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), a.a.pop_out);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.kXG != null) {
            if (z) {
                if (this.kXG.getVisibility() != 8 && this.kXG.getVisibility() != 4) {
                    this.kXG.startAnimation(loadAnimation2);
                    this.kXG.setVisibility(8);
                }
            } else if (this.kXG.getVisibility() != 0 && this.kXG.getVisibility() != 0) {
                this.kXG.startAnimation(loadAnimation);
                this.kXG.setVisibility(0);
            }
        }
    }

    protected List<View> getPanelView() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.kXH);
        return arrayList;
    }
}
