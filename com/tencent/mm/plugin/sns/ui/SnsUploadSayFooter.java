package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public class SnsUploadSayFooter extends BasePanelKeybordLayout {
    private MMActivity bGc;
    private ImageButton kXE;
    ChatFooterPanel kXH;
    private boolean kXK = true;
    private boolean nVC = false;
    private boolean nVD = false;
    private int nVE = -1;
    private int nVF = -1;
    private boolean nVG = t.fC(getContext());
    private MMEditText obg = null;

    static /* synthetic */ void b(SnsUploadSayFooter snsUploadSayFooter) {
        if (snsUploadSayFooter.kXH.getVisibility() == 8) {
            snsUploadSayFooter.bGc.YC();
            snsUploadSayFooter.kXH.onResume();
            if (t.fC(snsUploadSayFooter.getContext())) {
                boolean z = snsUploadSayFooter.nVF > 0 && snsUploadSayFooter.nVF < snsUploadSayFooter.nVE - a.fromDPToPix(snsUploadSayFooter.bGc, 50);
                if (z) {
                    snsUploadSayFooter.nVD = true;
                    snsUploadSayFooter.obg.requestFocus();
                    snsUploadSayFooter.kXE.setImageResource(i$e.sns_setmode_keyboard_btn);
                    return;
                }
            }
            snsUploadSayFooter.kXH.setVisibility(0);
            snsUploadSayFooter.obg.requestFocus();
            snsUploadSayFooter.kXE.setImageResource(i$e.sns_setmode_keyboard_btn);
            return;
        }
        snsUploadSayFooter.obg.requestFocus();
        snsUploadSayFooter.hideSmileyPanel();
        snsUploadSayFooter.bGc.showVKB();
        snsUploadSayFooter.kXE.setImageResource(i$e.sns_upload_biaoqing_btn);
    }

    public SnsUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        this.kXE = (ImageButton) ((ViewGroup) y.gq(this.bGc).inflate(g.sns_upload_say_footer, this)).findViewById(f.album_comment_mode_iv);
        this.kXE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SnsUploadSayFooter.b(SnsUploadSayFooter.this);
            }
        });
        if (e.qMK == null) {
            this.kXH = new d(this.bGc);
            return;
        }
        this.kXH = e.qMK.da(getContext());
        this.kXH.setEntranceScene(ChatFooterPanel.SCENE_SNS);
        this.kXH.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(f.root);
        linearLayout.setOnClickListener(null);
        linearLayout.addView(this.kXH, -1, 0);
        this.kXH.un();
        this.kXH.aE(false);
        this.kXH.setOnTextOperationListener(new 4(this));
    }

    public final void bEv() {
        setVisibility(0);
        if (this.kXE != null) {
            this.kXE.setImageResource(i$e.sns_upload_biaoqing_btn);
        }
    }

    public void setMMEditText(MMEditText mMEditText) {
        this.obg = mMEditText;
        mMEditText.setOnClickListener(new 1(this));
        mMEditText.setOnEditorActionListener(new 2(this));
    }

    public final boolean bEw() {
        return this.kXH.getVisibility() == 0;
    }

    public final void bEx() {
        hideSmileyPanel();
        setVisibility(8);
    }

    private void hideSmileyPanel() {
        this.kXH.onPause();
        this.kXH.setVisibility(8);
    }

    protected List<View> getPanelView() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.kXH);
        return arrayList;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nVD || this.nVC) {
            x.i("MicroMsg.SnsUploadSayFooter", "onLayout maxBottom %d currBottom %d layoutBottom %d", new Object[]{Integer.valueOf(this.nVE), Integer.valueOf(this.nVF), Integer.valueOf(i4)});
        }
        if (!(!this.nVD || this.kXH == null || this.nVF == i4)) {
            this.kXH.setVisibility(0);
            this.nVD = false;
        }
        this.nVE = this.nVE < i4 ? i4 : this.nVE;
        this.nVF = i4;
        if (t.fC(getContext()) != this.nVG || this.kXK) {
            this.kXH.setPortHeightPx(t.fA(getContext()));
            this.kXH.refresh();
            this.nVG = t.fC(getContext());
            LayoutParams layoutParams = this.kXH.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = j.fA(getContext());
                this.kXH.setLayoutParams(layoutParams);
            }
            this.kXK = false;
        }
    }
}
