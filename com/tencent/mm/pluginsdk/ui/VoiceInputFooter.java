package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter extends BasePanelKeybordLayout {
    private MMActivity bGc;
    ChatFooterPanel kXH;
    LinearLayout lqO;
    MMEditText obg = null;
    n qHf;
    ImageButton qHg;
    private ImageButton qHh;
    private boolean qHi = false;
    private boolean qHj = false;
    private final int qHk = 1;
    private final int qHl = 2;
    private a qHm;

    static /* synthetic */ void c(VoiceInputFooter voiceInputFooter) {
        voiceInputFooter.obg.requestFocus();
        if (voiceInputFooter.qHi) {
            voiceInputFooter.a();
            voiceInputFooter.bGc.showVKB();
        } else {
            voiceInputFooter.qHi = true;
            voiceInputFooter.bGc.YC();
            if (voiceInputFooter.bEw()) {
                voiceInputFooter.b();
            }
            if (voiceInputFooter.qHf != null) {
                voiceInputFooter.qHf.setVisibility(0);
            }
            voiceInputFooter.qHh.setImageResource(R.g.chatting_setmode_keyboard_btn);
            int ae = a.ae(voiceInputFooter.bGc, R.f.voice_input_album_voiceinput_padding);
            voiceInputFooter.qHh.setPadding(ae, 0, ae, 0);
            voiceInputFooter.qHg.setImageResource(R.g.chatting_setmode_biaoqing_btn);
            voiceInputFooter.qHg.setVisibility(8);
            if (voiceInputFooter.qHm != null) {
                voiceInputFooter.qHm.kF(true);
            }
        }
        kB(2);
    }

    static /* synthetic */ void d(VoiceInputFooter voiceInputFooter) {
        if (voiceInputFooter.cdy()) {
            voiceInputFooter.a();
        }
        if (voiceInputFooter.qHj) {
            voiceInputFooter.obg.requestFocus();
            voiceInputFooter.b();
            voiceInputFooter.bGc.showVKB();
            voiceInputFooter.qHg.setImageResource(R.g.chatting_setmode_biaoqing_btn);
        } else {
            voiceInputFooter.bGc.YC();
            voiceInputFooter.qHj = true;
            voiceInputFooter.kXH.onResume();
            voiceInputFooter.kXH.setVisibility(0);
            voiceInputFooter.obg.requestFocus();
            voiceInputFooter.qHg.setImageResource(R.g.chatting_setmode_keyboard_btn);
            voiceInputFooter.qHh.setImageResource(R.g.voiceinputui_setmode_voice_btn);
        }
        kB(1);
    }

    public VoiceInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) y.gq(this.bGc).inflate(R.i.voice_input_ui_footer, this);
        this.qHh = (ImageButton) viewGroup.findViewById(R.h.album_voiceinput_mode_iv);
        this.qHh.setOnClickListener(new 3(this));
        this.qHg = (ImageButton) viewGroup.findViewById(R.h.album_comment_mode_iv);
        this.qHg.setOnClickListener(new 4(this));
        if (e.qMK == null) {
            this.kXH = new d(this.bGc);
            return;
        }
        this.kXH = e.qMK.da(getContext());
        this.kXH.setEntranceScene(ChatFooterPanel.SCENE_SNS);
        this.kXH.setVisibility(8);
        this.lqO = (LinearLayout) findViewById(R.h.root);
        this.lqO.setOnClickListener(null);
        this.lqO.addView(this.kXH, -1, 0);
        this.kXH.un();
        this.kXH.aE(false);
        this.kXH.setOnTextOperationListener(new 5(this));
    }

    public void setVoiceInputFooterListener(a aVar) {
        this.qHm = aVar;
    }

    public final boolean bEw() {
        return this.kXH.getVisibility() == 0;
    }

    public final boolean cdy() {
        return this.qHf.getVisibility() == 0;
    }

    /* renamed from: cdz */
    final void a() {
        this.qHi = false;
        if (this.qHf != null) {
            this.qHf.pause();
            this.qHf.setVisibility(8);
            this.qHh.setImageResource(R.g.voiceinputui_setmode_voice_btn);
            this.qHh.setPadding(0, 0, a.ae(this.bGc, R.f.voice_input_album_voiceinput_padding), 0);
            this.qHg.setVisibility(0);
            if (this.qHm != null) {
                this.qHm.kF(false);
            }
        }
    }

    /* renamed from: hideSmileyPanel */
    final void b() {
        this.qHj = false;
        this.kXH.onPause();
        this.kXH.setVisibility(8);
    }

    protected List<View> getPanelView() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.kXH);
        arrayList.add(this.qHf);
        return arrayList;
    }

    private static void kB(int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (i == 1) {
            voiceInputBehavior.smileIconClick = 1;
        } else if (i == 2) {
            voiceInputBehavior.voiceIconClick = 1;
        } else {
            return;
        }
        x.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        h.mEJ.c(13905, log_13905);
    }
}
