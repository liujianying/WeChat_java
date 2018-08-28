package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.so;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoiceaddr.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.VoiceInputUI;
import com.tencent.mm.pluginsdk.ui.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.c;
import java.util.HashSet;
import java.util.Set;

public final class n extends LinearLayout {
    private String bEN = "";
    private Button kXG;
    private TelephonyManager knT;
    PhoneStateListener knU;
    private Context mContext;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a qHB = new 7(this);
    private boolean qHG = false;
    private MMEditText qHM;
    private int qKG = com.tencent.mm.bp.a.fromDPToPix(getContext(), 395);
    private c qLt;
    private int qNA = 300;
    private final String qNB = "voiceinput_downdistance_content";
    private boolean qNC = false;
    private boolean qND = false;
    private long qNE = 0;
    private long qNF = 0;
    private long qNG = 0;
    private boolean qNH = false;
    private boolean qNI = false;
    private final int qNJ = 2;
    private boolean qNK = false;
    private String qNL = "";
    private Toast qNM;
    private Set<String> qNN = new HashSet();
    private m qNO;
    private com.tencent.mm.sdk.b.c<so> qNP;
    private b qNQ;
    private VoiceInputLayout.b qNR = new 9(this);
    private boolean qNS = true;
    private VoiceInputLayout qNm;
    private ImageButton qNn;
    private Button qNo;
    private a qNp;
    private MMEditText qNq = null;
    private VoiceInputScrollView qNr;
    private TextView qNs;
    private long qNt = 0;
    private boolean qNu = false;
    private float qNv = 0.0f;
    private float qNw = 0.0f;
    private boolean qNx = false;
    private boolean qNy = false;
    private boolean qNz = false;

    public interface a {
        void RA(String str);

        void bXG();

        void ki(boolean z);
    }

    static /* synthetic */ void Cp(int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.fail = i;
        a(voiceInputBehavior);
        Cn(i);
    }

    static /* synthetic */ boolean a(n nVar, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (nVar.qNr.getScrollY() <= 0) {
                nVar.qNy = true;
                nVar.qNv = motionEvent.getRawY();
            }
            nVar.qNz = true;
        } else if (motionEvent.getAction() == 2) {
            nVar.qNx = true;
        } else if (motionEvent.getAction() == 1) {
            float f;
            if (nVar.qNx && nVar.qNy) {
                nVar.qNw = motionEvent.getRawY();
                f = nVar.qNw - nVar.qNv;
            } else {
                f = 0.0f;
            }
            nVar.qNz = false;
            nVar.qNx = false;
            nVar.qNy = false;
            nVar.qNw = 0.0f;
            nVar.qNv = 0.0f;
            if (f > ((float) nVar.qNA)) {
                if (!(nVar.qHM == null || nVar.qHM.getText() == null || nVar.qHM.getText().length() <= 0)) {
                    SharedPreferences chZ = ad.chZ();
                    if (chZ != null) {
                        chZ.edit().putString("voiceinput_downdistance_content", nVar.qHM.getText().toString()).apply();
                        x.d("MicroMsg.VoiceInputPanel", "onDownDistance save memory content");
                    }
                }
                nVar.ceV();
            } else if (nVar.qHG) {
                nVar.qHG = false;
            } else if ((view instanceof MMEditText) && nVar.qHM != null && nVar.qHM.getText() != null && nVar.qHM.getText().length() > 0) {
                Spannable newSpannable = Factory.getInstance().newSpannable(((MMEditText) view).getText());
                MMEditText mMEditText = (MMEditText) view;
                motionEvent.getAction();
                int x = (((int) motionEvent.getX()) - mMEditText.getTotalPaddingLeft()) + mMEditText.getScrollX();
                int y = (((int) motionEvent.getY()) - mMEditText.getTotalPaddingTop()) + mMEditText.getScrollY();
                Layout layout = mMEditText.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    clickableSpanArr[0].onClick(view);
                } else {
                    x.i("MicroMsg.VoiceInputPanel", "startVoiceInputUIActivity offset = %s", new Object[]{Integer.valueOf(((MMEditText) view).getOffsetForPosition(motionEvent.getX(), motionEvent.getY()))});
                    if (nVar.qNm != null) {
                        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                        voiceInputBehavior.textClick = nVar.qNm.getCurrentState();
                        a(voiceInputBehavior);
                    }
                    Intent intent = new Intent();
                    intent.setClass(nVar.getContext(), VoiceInputUI.class);
                    intent.putExtra("offset", offsetForHorizontal);
                    intent.putExtra("userCode", nVar.bEN);
                    if (!(nVar.qHM == null || nVar.qHM.getText() == null)) {
                        intent.putExtra("text", nVar.qHM.getText().toString());
                        if (nVar.qNO != null) {
                            nVar.qNO.b(nVar.qHM);
                        }
                    }
                    if (nVar.qNL.equalsIgnoreCase("。") || nVar.qNL.equalsIgnoreCase(".")) {
                        intent.putExtra("punctuation", nVar.qNL);
                    }
                    nVar.getContext().startActivity(intent);
                    if (nVar.qNm != null) {
                        bi.hideVKB(nVar.qNm);
                        nVar.qNm.Uh();
                    }
                }
            }
            return view instanceof MMEditText;
        }
        return view instanceof MMEditText;
    }

    static /* synthetic */ void ceX() {
        x.i("MicroMsg.VoiceInputPanel", "pauseMusic");
        au.HV().yL();
    }

    static /* synthetic */ void s(n nVar) {
        if (nVar.qHM != null && nVar.qHM.getText() != null) {
            String obj = nVar.qHM.getText().toString();
            if (obj.length() <= 0) {
                return;
            }
            if (!nVar.qNu || nVar.qHM.getSelectionStart() >= obj.length()) {
                nVar.qNL = obj.substring(obj.length() - 1, obj.length());
                x.i("MicroMsg.VoiceInputPanel", "delPunctuation msg = %s ,msg.length() = %s, punctuation = %s", new Object[]{bi.Xf(obj), Integer.valueOf(obj.length()), nVar.qNL});
                if (nVar.qNL.equalsIgnoreCase("。") || nVar.qNL.equalsIgnoreCase(".")) {
                    nVar.qHM.setText(obj.substring(0, obj.length() - 1));
                }
            }
        }
    }

    static /* synthetic */ void u(n nVar) {
        if (nVar.qHM != null && nVar.qHM.getText() != null && nVar.qHM.getText().length() > 0) {
            if (nVar.qNL.equalsIgnoreCase("。") || nVar.qNL.equalsIgnoreCase(".")) {
                if (!nVar.qNu || nVar.qHM.getSelectionStart() >= nVar.qHM.getText().length()) {
                    nVar.qNO.a(nVar.qHM, nVar.qNL, true);
                    nVar.qNO.b(nVar.qHM);
                }
                nVar.qNL = "";
            }
            String obj = nVar.qHM.getText().toString();
            x.i("MicroMsg.VoiceInputPanel", "addPunctuation msg = %s,msg.length() = %s", new Object[]{bi.Xf(obj), Integer.valueOf(obj.length())});
        }
    }

    public n(Context context, boolean z, MMEditText mMEditText) {
        super(context);
        this.mContext = context;
        this.qNu = z;
        this.qNq = mMEditText;
        init();
        this.qNO = new m(this.mContext);
        this.bEN = String.valueOf(System.nanoTime());
        x.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[]{this.bEN});
        ceU();
    }

    @TargetApi(16)
    private void init() {
        x.d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), R.i.voice_input_panel, this);
        this.qNn = (ImageButton) findViewById(R.h.voice_panel_close_btn);
        this.qNo = (Button) findViewById(R.h.voice_panel_clear_btn);
        this.kXG = (Button) findViewById(R.h.voice_panel_send_btn);
        this.qNs = (TextView) findViewById(R.h.status_text);
        if (this.qNu) {
            this.qNn.setVisibility(4);
        } else {
            this.qNn.setVisibility(0);
        }
        this.kXG.setVisibility(4);
        this.qNo.setVisibility(8);
        if (!this.qNu || this.qNq == null) {
            this.qHM = (MMEditText) findViewById(R.h.voice_panel_text_edit);
            this.qHM.setHintTextColor(getResources().getColor(R.e.normal_color));
            this.qHM.setClickable(true);
            this.qHM.setOnLongClickListener(new 1(this));
            this.qHM.setOnTouchListener(new 2(this));
        } else {
            this.qHM = this.qNq;
        }
        this.qNr = (VoiceInputScrollView) findViewById(R.h.voice_panel_scroll);
        this.qNn.setOnClickListener(new 3(this));
        this.kXG.setOnClickListener(new 4(this));
        this.qNo.setOnClickListener(new 5(this));
        this.qNr.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return n.a(n.this, view, motionEvent);
            }
        });
    }

    public final void ceU() {
        this.qNt = bi.VG();
        if (this.qNP == null) {
            x.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.qNP = new 8(this);
            com.tencent.mm.sdk.b.a.sFg.b(this.qNP);
        }
        if (this.qNm == null) {
            this.qNm = (VoiceInputLayout) findViewById(R.h.voice_panel_voice_search);
            this.qNm.setVoiceDetectListener(this.qNR);
            this.qNm.setLongClickLisnter(this.qHB);
            this.qNm.setFromFullScreen(this.qNu);
        }
        this.qNs.setVisibility(0);
        if (this.qNQ == null) {
            this.qNQ = new b();
        }
        SharedPreferences chZ = ad.chZ();
        if (chZ != null) {
            String string = chZ.getString("voiceinput_downdistance_content", "");
            if (!string.equalsIgnoreCase("")) {
                x.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[]{Integer.valueOf(string.length())});
                this.qNO.b(this.qHM);
                this.qNO.a(this.qHM, string, false);
                this.qNO.a(this.qHM);
                this.qNO.b(this.qHM);
                ceW();
                this.qNr.fullScroll(130);
                chZ.edit().remove("voiceinput_downdistance_content").apply();
            }
        }
        this.knT = (TelephonyManager) ad.getContext().getSystemService("phone");
        if (this.knT != null) {
            if (this.knU == null) {
                this.knU = new b(this, (byte) 0);
            }
            this.knT.listen(this.knU, 32);
        }
    }

    public final void setFullScreenData(String str) {
        if (str != null) {
            this.qNL = str;
        }
        ceW();
    }

    public final void setCallback(a aVar) {
        this.qNp = aVar;
    }

    public final void pause() {
        x.i("MicroMsg.VoiceInputPanel", "pause");
        if (this.qNm != null) {
            this.qNm.Uh();
        }
        this.qNv = 0.0f;
        this.qNw = 0.0f;
        this.qNx = false;
        this.qNy = false;
        this.qHG = false;
        this.qNz = false;
        this.qNH = false;
        this.qNS = true;
    }

    public final void reset() {
        x.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
        pause();
        this.qNI = false;
        this.qNN.clear();
        if (this.qHM != null) {
            if (this.qNO != null) {
                this.qNO.b(this.qHM);
                this.qNO.a(this.qHM, "", false);
                this.qNO.a(this.qHM);
                this.qNO.b(this.qHM);
            }
            ceW();
        }
    }

    public final void destroy() {
        x.i("MicroMsg.VoiceInputPanel", "destroy");
        reset();
        if (this.qNP != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.qNP);
            this.qNP = null;
        }
        if (this.qNm != null) {
            this.qNm.setVoiceDetectListener(null);
            this.qNm = null;
        }
        if (this.qNQ != null) {
            this.qNQ = null;
        }
        if (!(this.knT == null || this.knU == null)) {
            this.knT.listen(this.knU, 0);
            this.knU = null;
        }
        this.knT = null;
        this.qNq = null;
    }

    private void ceV() {
        x.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (this.qNp != null) {
            this.qNH = true;
            x.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (this.qHM == null || this.qHM.getText() == null || this.qHM.getText().length() <= 0) {
                if (this.qNH) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (this.qNH) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (this.qNt != 0) {
                voiceInputBehavior.voiceInputTime = bi.bI(this.qNt);
                this.qNt = 0;
            }
            a(voiceInputBehavior);
            this.qNp.bXG();
        }
    }

    public final void setPortHeightPX(int i) {
        x.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[]{Integer.valueOf(this.qKG), Integer.valueOf(i)});
        if (this.qKG != i) {
            this.qKG = i;
            this.qNS = true;
        }
    }

    public final void cee() {
        x.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[]{Integer.valueOf(this.qKG), Boolean.valueOf(this.qNS)});
        if (this.qNS) {
            this.qNS = false;
            View findViewById = findViewById(R.h.voice_panel_display_view);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = this.qKG;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            init();
            ceW();
            requestLayout();
        }
    }

    public final void setToUser(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
        } else {
            this.bEN = str;
        }
    }

    private void ceW() {
        x.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.qHM == null || this.qHM.getText() == null || this.qHM.getText().length() != 0) {
            if (this.qHM != null) {
                this.qHM.setCursorVisible(true);
            }
            this.kXG.setVisibility(0);
            if (!this.qNu) {
                this.qNn.setVisibility(8);
                this.qNo.setVisibility(0);
            }
            this.qNs.setVisibility(8);
        } else {
            this.qHM.setSelection(0);
            this.qHM.setCursorVisible(false);
            this.kXG.setVisibility(4);
            if (!this.qNu) {
                this.qNn.setVisibility(0);
            }
            this.qNo.setVisibility(8);
            this.qNs.setVisibility(0);
        }
        if (this.qNu) {
            if (this.qNq == null || this.qNq.getText() == null || this.qNq.getText().length() != 0) {
                this.kXG.setVisibility(0);
            } else {
                this.kXG.setVisibility(4);
            }
        }
        if (this.qHM != null) {
            this.qHM.clearFocus();
        }
        x.i("MicroMsg.VoiceInputPanel", "resumeMusic");
        au.HV().yM();
        if (!this.qND) {
            this.qND = true;
            this.qNG = System.currentTimeMillis();
            x.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[]{Long.valueOf(this.qNG), Long.valueOf(this.qNG - this.qNF)});
        }
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        x.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[]{Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime)});
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        h.mEJ.c(13905, log_13905);
    }

    private static void Cn(int i) {
        x.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[]{Integer.valueOf(i)});
        h.mEJ.a(455, (long) i, 1, false);
    }
}
