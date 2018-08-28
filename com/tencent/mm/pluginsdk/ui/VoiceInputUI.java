package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.VoiceInputFooter.1;
import com.tencent.mm.pluginsdk.ui.VoiceInputFooter.2;
import com.tencent.mm.pluginsdk.ui.VoiceInputFooter.6;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMEditText;

@a(3)
public class VoiceInputUI extends MMActivity {
    private String bIr;
    private String cds;
    private Button ioq;
    private int offset;
    private MMEditText qHM;
    private VoiceInputFooter qHN;
    private String qHO;
    private long qHP = 0;
    private boolean qHQ = true;
    private boolean qHR = false;
    private OnTouchListener qHS = new 2(this);
    private OnMenuItemClickListener qHT = new 3(this);
    private VoiceInputFooter.a qHU = new 4(this);
    private int textChangeCount = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        Intent intent = getIntent();
        if (intent != null) {
            this.bIr = intent.getStringExtra("text");
            this.offset = intent.getIntExtra("offset", -1);
            this.qHO = intent.getStringExtra("punctuation");
            this.cds = intent.getStringExtra("userCode");
        }
        this.qHP = bi.VG();
        this.textChangeCount = 0;
        this.qHR = false;
        this.qHQ = true;
        this.qHM = (MMEditText) findViewById(R.h.voice_input_ui_text_edit);
        this.ioq = (Button) findViewById(R.h.voice_input_ui_send_btn);
        this.qHM.addTextChangedListener(new 5(this));
        this.ioq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 3;
                VoiceInputUI.a(voiceInputBehavior);
                VoiceInputUI.this.BW(7);
            }
        });
        setMMTitle(getString(R.l.voice_input_ui_eidt_content));
        enableOptionMenu(true);
        setBackBtn(new 1(this));
        this.qHM.setOnTouchListener(this.qHS);
        this.qHM.abr(this.bIr);
        if (this.offset != -1) {
            this.qHM.setSelection(this.offset);
        }
        this.qHN = (VoiceInputFooter) findViewById(R.h.say_footer);
        VoiceInputFooter voiceInputFooter = this.qHN;
        MMEditText mMEditText = this.qHM;
        String str = this.qHO;
        voiceInputFooter.obg = mMEditText;
        mMEditText.setOnClickListener(new 1(voiceInputFooter));
        mMEditText.setOnEditorActionListener(new 2(voiceInputFooter));
        if (voiceInputFooter.qHf == null) {
            voiceInputFooter.qHf = new n(voiceInputFooter.getContext(), true, voiceInputFooter.obg);
            voiceInputFooter.qHf.setCallback(new 6(voiceInputFooter));
            voiceInputFooter.qHf.setPortHeightPX(j.fA(voiceInputFooter.getContext()));
        }
        voiceInputFooter.qHf.ceU();
        voiceInputFooter.qHf.cee();
        voiceInputFooter.qHf.setVisibility(8);
        voiceInputFooter.qHf.setFullScreenData(str);
        voiceInputFooter.lqO.addView(voiceInputFooter.qHf, -1, 0);
        this.qHN.setVoiceInputFooterListener(this.qHU);
    }

    protected void onResume() {
        super.onResume();
        this.qHM.requestFocus();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.qHN != null) {
            VoiceInputFooter voiceInputFooter = this.qHN;
            if (voiceInputFooter.kXH != null) {
                voiceInputFooter.kXH.um();
                voiceInputFooter.kXH.destroy();
            }
            if (voiceInputFooter.qHf != null) {
                voiceInputFooter.qHf.destroy();
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.voice_input_ui;
    }

    public void onSwipeBack() {
        BW(3);
        super.onSwipeBack();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            BW(2);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void BW(int i) {
        x.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[]{Integer.valueOf(i), bi.cjd().toString()});
        if (i == 8) {
            kB(7);
        } else {
            kB(i);
        }
        so soVar = new so();
        if (i == 7) {
            soVar.cdq.action = 1;
        } else if (i == 8) {
            soVar.cdq.action = 4;
        } else {
            soVar.cdq.action = 2;
        }
        if (this.qHR) {
            soVar.cdq.cdr = 1;
        } else {
            soVar.cdq.cdr = 2;
        }
        soVar.cdq.result = this.qHM.getText().toString();
        soVar.cdq.cds = this.cds;
        com.tencent.mm.sdk.b.a.sFg.m(soVar);
        bi.hideVKB(this.qHM);
        super.finish();
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        x.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[]{Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime)});
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        h.mEJ.c(13905, log_13905);
    }

    private void kB(int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.textChangeCount = this.textChangeCount;
        voiceInputBehavior.textChangeReturn = i;
        if (this.qHP != 0) {
            voiceInputBehavior.textChangeTime = bi.bI(this.qHP);
            this.qHP = 0;
        }
        a(voiceInputBehavior);
    }
}
