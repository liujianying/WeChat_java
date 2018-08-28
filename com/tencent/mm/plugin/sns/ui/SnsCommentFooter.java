package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.ArrayList;
import java.util.List;

public class SnsCommentFooter extends BasePanelKeybordLayout {
    private MMActivity bGc;
    private ImageButton kXE;
    MMEditText kXF;
    private Button kXG;
    ChatFooterPanel kXH;
    boolean kXI = false;
    public boolean kXJ = false;
    private boolean kXK = true;
    boolean kXL = true;
    private TextWatcher kXM = new 1(this);
    private Button nVA;
    private int nVB = 0;
    private boolean nVC = false;
    private boolean nVD = false;
    private int nVE = -1;
    private int nVF = -1;
    private boolean nVG = t.fC(getContext());
    public boolean nVH;
    private String nVI = "";
    private boolean nVJ = false;
    private a nVK;
    private d nVL;
    private bi nVM;
    ImageView nVz;
    bon noe = null;
    int state = 0;

    interface a {
        void bDh();
    }

    public void setState(String str) {
        if (v.NG(str)) {
            if (this.nVA != null) {
                this.nVA.setEnabled(true);
            }
            if (this.nVz != null) {
                this.nVz.setEnabled(true);
                return;
            }
            return;
        }
        if (this.nVA != null) {
            this.nVA.setEnabled(false);
        }
        if (this.nVz != null) {
            this.nVz.setEnabled(false);
        }
    }

    public void setModeClick(boolean z) {
        this.kXI = z;
    }

    public final boolean bDj() {
        if (this.kXF.getText() == null || bi.oW(this.kXF.getText().toString())) {
            return true;
        }
        return false;
    }

    public SnsCommentFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
    }

    public void setAfterEditAction(Runnable runnable) {
        ViewGroup viewGroup = (ViewGroup) inflate(this.bGc, i$g.sns_comment_footer, this);
        this.nVz = (ImageView) viewGroup.findViewById(i$f.sns_liked_iv);
        this.kXG = (Button) viewGroup.findViewById(i$f.album_comment_send_btn);
        this.nVA = (Button) viewGroup.findViewById(i$f.album_comment_green_send_btn);
        this.kXF = (MMEditText) viewGroup.findViewById(i$f.album_comment_content_et);
        go(false);
        this.kXE = (ImageButton) viewGroup.findViewById(i$f.album_comment_mode_iv);
        this.kXE.setOnClickListener(new 3(this));
        this.kXF.setHint(this.bGc.getString(i$j.sns_ui_comment));
        this.kXF.setOnTouchListener(new 4(this));
        if (e.qMK == null) {
            this.kXH = new d(this.bGc);
            return;
        }
        this.kXH = e.qMK.da(getContext());
        this.kXH.setEntranceScene(ChatFooterPanel.SCENE_SNS);
        this.kXH.setVisibility(8);
        this.kXH.setBackgroundResource(i.e.bottombar_bg);
        ((LinearLayout) findViewById(i$f.root)).addView(this.kXH, -1, 0);
        this.kXH.un();
        this.kXH.aE(false);
        this.kXH.setOnTextOperationListener(new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a() {
            public final void bbF() {
            }

            public final void gp(boolean z) {
            }

            public final void apK() {
                if (SnsCommentFooter.this.kXF != null && SnsCommentFooter.this.kXF.getInputConnection() != null) {
                    SnsCommentFooter.this.kXF.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                    SnsCommentFooter.this.kXF.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                }
            }

            public final void append(String str) {
                try {
                    SnsCommentFooter.this.kXF.abr(str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                }
            }
        });
    }

    public void setVisibility(int i) {
        boolean z = false;
        this.state = 0;
        if (i == 0) {
            z = true;
        }
        ir(z);
        super.setVisibility(i);
    }

    public final void ir(boolean z) {
        if (this.kXH != null) {
            this.nVH = z;
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
                return;
            }
            this.kXH.setVisibility(8);
            this.kXE.setImageResource(i$i.textfield_icon_emoji_normal);
            this.bGc.YC();
            requestLayout();
        }
    }

    private void apI() {
        LayoutParams layoutParams;
        this.kXH.onResume();
        if (t.fC(getContext())) {
            boolean z = this.nVF > 0 && this.nVF < this.nVE - com.tencent.mm.bp.a.fromDPToPix(this.bGc, 50);
            if (z) {
                this.nVD = true;
                layoutParams = this.kXH.getLayoutParams();
                if (layoutParams != null && (this.kXK || layoutParams.height == 0)) {
                    layoutParams.height = j.fA(getContext());
                    this.kXH.setLayoutParams(layoutParams);
                    this.kXK = false;
                }
                if (this.nVL != null) {
                    this.nVL.onShow();
                }
            }
        }
        this.kXH.setVisibility(0);
        layoutParams = this.kXH.getLayoutParams();
        layoutParams.height = j.fA(getContext());
        this.kXH.setLayoutParams(layoutParams);
        this.kXK = false;
        if (this.nVL != null) {
            this.nVL.onShow();
        }
    }

    private void hideSmileyPanel() {
        this.kXH.onPause();
        if (t.fC(getContext())) {
            this.nVC = true;
        } else {
            this.kXH.setVisibility(8);
        }
    }

    public final boolean bDk() {
        return this.state == 1;
    }

    public final void bDl() {
        if (this.kXF == null) {
            x.e("MicroMsg.SnsCommentFooter", "send edittext is null");
            return;
        }
        this.kXF.removeTextChangedListener(this.kXM);
        this.kXF.addTextChangedListener(this.kXM);
    }

    public int getSendType() {
        return this.nVB;
    }

    public void setSendType(int i) {
        this.nVB = i;
    }

    public final void h(List<l> list, String str) {
        this.nVI = str;
        if (this.kXF != null) {
            String aG;
            String str2 = "";
            for (l lVar : list) {
                if (str.equals(lVar.aAL)) {
                    list.remove(lVar);
                    aG = bi.aG(lVar.text, "");
                    break;
                }
            }
            aG = str2;
            if (bi.oW(aG)) {
                this.kXF.setText("");
            } else {
                this.nVA.setVisibility(0);
                this.kXG.setVisibility(8);
                this.kXF.setText("");
                this.kXF.abr(aG);
            }
            if (!this.nVJ) {
                this.kXF.addTextChangedListener(new 2(this, list));
            }
            this.nVJ = true;
        }
    }

    public void setText(String str) {
        if (this.kXF != null) {
            this.kXF.setText("");
            this.kXF.abr(str);
        }
    }

    public final void a(String str, bon bon) {
        this.nVB = 0;
        if (bi.oW(str)) {
            this.kXF.setHint("");
        } else {
            this.kXF.setHint(com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), str + this.bGc.getString(i$j.sns_after_reply, new Object[]{Float.valueOf(this.kXF.getTextSize())})));
        }
        this.noe = bon;
    }

    public final void b(String str, bon bon) {
        if (bi.oW(str)) {
            this.kXF.setHint("");
        } else {
            this.kXF.setHint(com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), this.bGc.getString(i$j.sns_ad_at_tips1) + str + this.bGc.getString(i$j.sns_after_reply, new Object[]{Float.valueOf(this.kXF.getTextSize())})));
            this.nVB = 1;
        }
        this.noe = bon;
    }

    public void setmComment(bon bon) {
        this.noe = bon;
    }

    public final void bDm() {
        this.kXF.setText("");
        this.kXF.setHint("");
        this.noe = null;
        this.nVB = 0;
        this.state = 0;
    }

    public void setHint(String str) {
        this.kXF.setHint(com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), str, this.kXF.getTextSize()));
    }

    public bon getCommentInfo() {
        if (this.noe == null) {
            return new bon();
        }
        return this.noe;
    }

    public void setOnEditTouchListener(a aVar) {
        this.nVK = aVar;
    }

    public void setOnSmileyShowListener(d dVar) {
        this.nVL = dVar;
    }

    public void setOnCommentSendImp(c cVar) {
        this.nVA.setOnClickListener(new 6(this, cVar));
    }

    public final void setOnCommentLikedImp$632a1e7b(final b bVar) {
        this.nVz.setVisibility(0);
        this.nVz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SnsCommentFooter.this.nVz.setImageResource(i.e.chatting_setmode_heart_btn_pressed);
                Animation scaleAnimation = new ScaleAnimation(0.9f, 1.3f, 0.9f, 1.3f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(400);
                scaleAnimation.setStartOffset(100);
                scaleAnimation.setRepeatCount(0);
                SnsCommentFooter.this.nVz.startAnimation(scaleAnimation);
                scaleAnimation.setAnimationListener(new 1(this));
                bVar.bDi();
            }
        });
    }

    public void setHeartBtnVisibility(int i) {
        this.nVz.setVisibility(i);
    }

    protected final void qN(int i) {
        super.qN(i);
        switch (i) {
            case IX5WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                this.kXJ = true;
                if (getVisibility() == 0 && this.nVM != null) {
                    x.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
                    this.nVM.bEE();
                    return;
                }
                return;
            default:
                this.kXJ = false;
                return;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nVD || this.nVC) {
            x.i("MicroMsg.SnsCommentFooter", "onLayout maxBottom %d currBottom %d layoutBottom %d", new Object[]{Integer.valueOf(this.nVE), Integer.valueOf(this.nVF), Integer.valueOf(i4)});
        }
        if (!(!this.nVD || this.kXH == null || this.nVF == i4)) {
            this.kXH.setVisibility(0);
            this.nVD = false;
        }
        this.nVE = this.nVE < i4 ? i4 : this.nVE;
        this.nVF = i4;
        if (this.nVC && this.kXH != null) {
            this.kXH.setVisibility(8);
            this.nVC = false;
        }
        if (t.fC(getContext()) != this.nVG) {
            this.kXH.setPortHeightPx(t.fA(getContext()));
            this.kXH.refresh();
            this.nVG = t.fC(getContext());
            hideSmileyPanel();
            this.kXE.setImageResource(i.e.chatting_setmode_biaoqing_btn);
            this.state = 0;
        }
    }

    public final void bbE() {
        this.nVM = null;
        if (this.kXH != null) {
            x.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.kXH.um();
            this.kXH.destroy();
        }
    }

    public void setAnitiomAdjust(bi biVar) {
        this.nVM = biVar;
    }

    private void go(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.sns.i.a.pop_in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.sns.i.a.pop_out);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.kXG != null && this.nVA != null) {
            if (z) {
                if (this.kXG.getVisibility() != 8 && this.kXG.getVisibility() != 4) {
                    this.nVA.startAnimation(loadAnimation);
                    this.nVA.setVisibility(0);
                    this.kXG.startAnimation(loadAnimation2);
                    this.kXG.setVisibility(8);
                } else {
                    return;
                }
            } else if (this.kXG.getVisibility() != 0 && this.kXG.getVisibility() != 0) {
                this.kXG.startAnimation(loadAnimation);
                this.kXG.setVisibility(0);
                this.nVA.startAnimation(loadAnimation2);
                this.nVA.setVisibility(8);
            } else {
                return;
            }
            this.nVA.getParent().requestLayout();
        }
    }

    protected List<View> getPanelView() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.kXH);
        return arrayList;
    }
}
