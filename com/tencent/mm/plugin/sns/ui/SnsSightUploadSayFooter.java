package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter extends BasePanelKeybordLayout {
    MMActivity bGc;
    private ImageButton kXE;
    ChatFooterPanel kXH;
    private boolean kXK = true;
    private MMEditText obg = null;
    SightRangeWidget obh;
    SightLocationWidget obi;

    static /* synthetic */ void d(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        if (snsSightUploadSayFooter.kXH.getVisibility() == 8) {
            snsSightUploadSayFooter.bGc.YC();
            snsSightUploadSayFooter.kXH.onResume();
            snsSightUploadSayFooter.kXH.setVisibility(0);
            snsSightUploadSayFooter.obg.requestFocus();
            snsSightUploadSayFooter.kXE.setImageResource(i$i.sight_icon_keyboard);
            snsSightUploadSayFooter.kXK = false;
            return;
        }
        snsSightUploadSayFooter.kXK = false;
        snsSightUploadSayFooter.obg.requestFocus();
        snsSightUploadSayFooter.hideSmileyPanel();
        snsSightUploadSayFooter.bGc.showVKB();
        snsSightUploadSayFooter.kXE.setImageResource(i$i.sight_icon_emoji);
    }

    public SnsSightUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.bGc, i$g.sns_sight_upload_say_footer, this);
        this.kXE = (ImageButton) viewGroup.findViewById(i$f.album_comment_mode_iv);
        this.kXE.setOnClickListener(new 4(this));
        if (e.qMK == null) {
            this.kXH = new d(this.bGc);
        } else {
            this.kXH = e.qMK.da(getContext());
            this.kXH.setEntranceScene(ChatFooterPanel.SCENE_SNS);
            this.kXH.setVisibility(8);
            ((LinearLayout) findViewById(i$f.root)).addView(this.kXH, -1, 0);
            this.kXH.un();
            this.kXH.aE(false);
            this.kXH.setOnTextOperationListener(new 5(this));
        }
        this.obh = (SightRangeWidget) viewGroup.findViewById(i$f.range_widget);
        this.obh.nLD = null;
        this.obh.style = 1;
        this.obi = (SightLocationWidget) viewGroup.findViewById(i$f.location_widget);
    }

    public void setMMEditText(MMEditText mMEditText) {
        this.obg = mMEditText;
        mMEditText.setOnClickListener(new 1(this));
        mMEditText.setOnEditorActionListener(new 2(this));
        ah.i(new 3(this), 200);
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

    public arj getLocation() {
        return this.obi.getLocation();
    }
}
