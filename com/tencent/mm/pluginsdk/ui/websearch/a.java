package com.tencent.mm.pluginsdk.ui.websearch;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.HashSet;
import java.util.Set;

public final class a extends LinearLayout {
    private String bEN = "";
    AudioManager daT;
    private Button kXG;
    private TelephonyManager knT;
    PhoneStateListener knU = new 4(this);
    private Context mContext;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a qHB = new com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a() {
        public final void cdE() {
            a.a(a.this, R.l.voice_input_speak_too_short);
        }
    };
    private boolean qHG = false;
    private MMEditText qHM;
    public int qKG = com.tencent.mm.bp.a.fromDPToPix(getContext(), 280);
    private int qNA = TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE;
    private boolean qNC = false;
    private boolean qND = false;
    private long qNE = 0;
    private long qNF = 0;
    private long qNG = 0;
    private boolean qNH = false;
    private boolean qNI = false;
    private final int qNJ = 2;
    private boolean qNK = false;
    private Toast qNM;
    private Set<String> qNN = new HashSet();
    private c<so> qNP;
    private b qNR = new b() {
        public final void cdF() {
            a.this.qNE = System.currentTimeMillis();
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[]{Long.valueOf(a.this.qNE)});
            x.d("VOICEDEBUG", "Start Record Time = %s", new Object[]{Long.valueOf(a.this.qNE)});
            a.this.qNC = false;
            a.this.qND = true;
            a.this.qNK = true;
            a.this.qNF = 0;
            a.this.qNG = 0;
            a.this.d();
            a.this.qNs.setVisibility(8);
            a.this.qND = false;
            a aVar = a.this;
            if (aVar.daT != null) {
                aVar.daT.setStreamMute(3, true);
            }
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().addFlags(128);
            }
            a.this.kXG.setVisibility(4);
            a.this.qNn.setVisibility(4);
            a.this.qNo.setVisibility(8);
            a.this.qHM.setHint(a.this.getResources().getString(R.l.voice_input_panel_hint_content));
            a.this.qUG.ki(true);
        }

        public final void cdG() {
            a.this.qUG.ki(false);
            a.this.qHM.setHint(null);
        }

        public final void cdH() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            a.this.d();
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            a.this.qUG.ki(false);
            a.this.qHM.setHint(null);
            a.b(a.this, 2);
        }

        public final void cdI() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
            a.this.d();
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            a.this.qUG.ki(false);
            a.this.qHM.setHint(null);
        }

        public final void cdJ() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
            a.this.d();
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            a.this.qUG.ki(false);
            a.this.qHM.setHint(null);
            a.b(a.this, 2);
        }

        public final void b(String[] strArr, Set<String> set) {
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (a.this.qNK) {
                    a.this.qNK = false;
                }
                x.i("MicroMsg.VoiceInputPanel", "onDetected %s", new Object[]{strArr[0]});
                a.this.qHM.setText(strArr[0]);
                if (!(a.this.qNC || strArr[0].length() == 0)) {
                    a.this.qNC = true;
                    a.this.qNF = System.currentTimeMillis();
                    x.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(a.this.qNF - a.this.qNE)});
                }
                a.this.qNN.addAll(set);
            }
        }

        public final void ag(int i, int i2, int i3) {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis())});
            a.this.d();
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            if (i == 12) {
                a.a(a.this, R.l.voice_input_please_check_network);
            } else {
                a.a(a.this, R.l.app_err_system_busy_tip);
            }
            a.this.qUG.ki(false);
            a.this.qHM.setHint(null);
        }
    };
    public boolean qNS = true;
    private VoiceInputLayout qNm;
    private ImageButton qNn;
    private Button qNo;
    private VoiceInputScrollView qNr;
    private TextView qNs;
    private long qNt = 0;
    private float qNv = 0.0f;
    private float qNw = 0.0f;
    private boolean qNx = false;
    private boolean qNy = false;
    private boolean qNz = false;
    private a qUG;

    static /* synthetic */ void a(a aVar) {
        x.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (aVar.qUG != null) {
            aVar.qNH = true;
            x.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (aVar.qHM == null || aVar.qHM.getText() == null || aVar.qHM.getText().length() <= 0) {
                if (aVar.qNH) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (aVar.qNH) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (aVar.qNt != 0) {
                voiceInputBehavior.voiceInputTime = bi.bI(aVar.qNt);
                aVar.qNt = 0;
            }
            aVar.qUG.bXG();
        }
    }

    public a(Context context) {
        super(context);
        this.mContext = context;
        x.d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), R.i.websearch_voice_input_panel, this);
        this.qNn = (ImageButton) findViewById(R.h.voice_panel_close_btn);
        this.qNo = (Button) findViewById(R.h.voice_panel_clear_btn);
        this.kXG = (Button) findViewById(R.h.voice_panel_send_btn);
        this.qNs = (TextView) findViewById(R.h.status_text);
        this.qNn.setVisibility(0);
        this.kXG.setVisibility(4);
        this.qNo.setVisibility(8);
        this.qHM = (MMEditText) findViewById(R.h.voice_panel_text_edit);
        this.qHM.setHintTextColor(getResources().getColor(R.e.normal_color));
        this.qHM.setClickable(false);
        this.qNr = (VoiceInputScrollView) findViewById(R.h.voice_panel_scroll);
        this.qNn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                a.a(a.this);
            }
        });
        this.qHM.clearFocus();
        this.qHM.setFocusable(false);
        this.qHM.setClickable(false);
        this.qHM.setLongClickable(false);
        this.daT = (AudioManager) getContext().getSystemService("audio");
        this.bEN = String.valueOf(System.nanoTime());
        x.i("MicroMsg.VoiceInputPanel", "mToUser %s", new Object[]{this.bEN});
        ceU();
    }

    public final void ceU() {
        this.qNt = bi.VG();
        if (this.qNP == null) {
            x.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.qNP = new c<so>() {
                {
                    this.sFo = so.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    so soVar = (so) bVar;
                    if (!(soVar instanceof so)) {
                        x.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                        return false;
                    } else if (soVar == null || soVar.cdq == null) {
                        x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                        return false;
                    } else if (soVar.cdq.cds.equalsIgnoreCase(a.this.bEN)) {
                        x.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", new Object[]{Integer.valueOf(soVar.cdq.action), Integer.valueOf(soVar.cdq.cdr)});
                        if (soVar.cdq.action == 2) {
                            if (soVar.cdq.cdr == 1) {
                                a.this.qNI = true;
                            } else {
                                a.this.qNI = false;
                            }
                            a.this.qHM.setText(soVar.cdq.result);
                            a.this.d();
                        } else if (soVar.cdq.action == 3) {
                            if (a.this.qUG != null) {
                                a.this.qUG.bXG();
                            }
                        } else if (soVar.cdq.action == 1 || soVar.cdq.action == 4) {
                            if (soVar.cdq.cdr == 1) {
                                a.this.qNI = true;
                            } else {
                                a.this.qNI = false;
                            }
                            a.this.qHM.setText(soVar.cdq.result);
                            a.this.d();
                            a.b(a.this, soVar.cdq.action);
                        } else {
                            a.this.reset();
                        }
                        return true;
                    } else {
                        x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
                        a.this.destroy();
                        return false;
                    }
                }
            };
            com.tencent.mm.sdk.b.a.sFg.b(this.qNP);
        }
        if (this.qNm == null) {
            this.qNm = (VoiceInputLayout) findViewById(R.h.voice_panel_voice_search);
            this.qNm.setVoiceDetectListener(this.qNR);
            this.qNm.setLongClickLisnter(this.qHB);
        }
        this.qNs.setVisibility(0);
        this.knT = (TelephonyManager) ad.getContext().getSystemService("phone");
        this.knT.listen(this.knU, 32);
    }

    public final void setCallback(a aVar) {
        this.qUG = aVar;
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
            this.qHM.setText("");
            d();
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
        if (!(this.knT == null || this.knU == null)) {
            this.knT.listen(this.knU, 0);
            this.knU = null;
        }
        this.knT = null;
    }

    public final void setToUser(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
        } else {
            this.bEN = str;
        }
    }

    /* renamed from: ceW */
    public final void d() {
        x.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.qHM == null || this.qHM.getText() == null || this.qHM.getText().length() != 0) {
            this.qNn.setVisibility(4);
            this.qNs.setVisibility(8);
        } else {
            this.kXG.setVisibility(4);
            this.qNn.setVisibility(0);
            this.qNo.setVisibility(8);
            this.qNs.setVisibility(0);
        }
        if (this.daT != null) {
            this.daT.setStreamMute(3, false);
        }
        if (!this.qND) {
            this.qND = true;
            this.qNG = System.currentTimeMillis();
            x.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[]{Long.valueOf(this.qNG), Long.valueOf(this.qNG - this.qNF)});
        }
    }
}
