package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.l;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.ah;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel$a;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.b;
import com.tencent.mm.pluginsdk.ui.chat.h.a;
import com.tencent.mm.pluginsdk.ui.chat.i.2;
import com.tencent.mm.pluginsdk.ui.chat.i.3;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChatFooter extends LinearLayout implements OnGlobalLayoutListener, a {
    private static int count = 0;
    private static final int[] erx = new int[]{R.g.amp1, R.g.amp2, R.g.amp3, R.g.amp4, R.g.amp5, R.g.amp6, R.g.amp7};
    private static final int[] hnd = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private Activity activity;
    public String bSS;
    private Context context;
    private View ern;
    private final ag hnB;
    private ImageView hnl;
    private boolean hnt;
    public View iZf;
    public View iZg;
    public View iZh;
    public View iZi;
    public MMEditText kXF;
    public Button kXG;
    public ChatFooterPanel kXH;
    public final ag mHandler;
    private int nVE;
    private int nVF;
    public o oxs;
    private TextView oxt;
    private ImageView oxu;
    public View oxv;
    f qFb;
    private int qFc;
    public n qHf;
    public boolean qHi;
    private boolean qLA;
    private TextView qLB;
    private InputMethodManager qLC;
    private int qLD;
    private boolean qLE;
    private boolean qLF;
    public boolean qLG;
    private boolean qLH;
    private boolean qLI;
    public b qLJ;
    public c qLK;
    private m$a qLL;
    private boolean qLM;
    public x qLN;
    private boolean qLO;
    private Animation qLP;
    private Animation qLQ;
    private ChatFooterPanel$a qLR;
    private b qLS;
    public e qLT;
    private int qLU;
    private c qLV;
    private boolean qLW;
    private int qLX;
    private final int qLY;
    private final int qLZ;
    private String qLj;
    public AppPanel qLk;
    public TextView qLl;
    private Button qLm;
    public ImageButton qLn;
    public ChatFooterBottom qLo;
    private TextView qLp;
    public ImageButton qLq;
    public ImageButton qLr;
    public View qLs;
    private com.tencent.mm.ui.widget.a.c qLt;
    private i qLu;
    public m qLv;
    private b qLw;
    private d qLx;
    public final a qLy;
    public boolean qLz;
    private final int qMa;
    private final int qMb;
    private final int qMc;
    private final int qMd;
    private final int qMe;
    private final int qMf;
    private int qMg;
    private int qMh;
    private int qMi;
    private int qMj;
    private boolean qMk;
    private final int qMl;
    private final int qMm;
    private volatile boolean qMn;
    private ag qMo;
    private int qMp;
    private int qMq;
    private int qMr;
    private View qMs;
    public boolean qMt;
    private int qMu;
    public String toUser;

    static /* synthetic */ void A(ChatFooter chatFooter) {
        if (com.tencent.mm.p.a.by(chatFooter.context) || com.tencent.mm.p.a.bw(chatFooter.context)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "voip is running, cann't record voice");
            return;
        }
        chatFooter.findViewById(R.h.chatting_foot_bar_group).setVisibility(8);
        chatFooter.qLD = 1;
        chatFooter.kXF.setVisibility(8);
        chatFooter.qLm.setVisibility(8);
        chatFooter.Ch(R.g.chatting_setmode_voice_btn);
        if (chatFooter.kXH != null) {
            chatFooter.kXH.setVisibility(8);
        }
        chatFooter.setAppPanelVisible(8);
        chatFooter.qLo.setVisibility(0);
        chatFooter.a(false);
        if (chatFooter.qHf == null) {
            chatFooter.qHf = new n(chatFooter.getContext(), false, null);
            chatFooter.qLo.addView(chatFooter.qHf, new LayoutParams(-1, -1));
            chatFooter.qHf.setCallback(new 13(chatFooter));
            if (chatFooter.qLk.getHeight() > 0) {
                chatFooter.qHf.setPortHeightPX(chatFooter.qLk.getHeight());
            } else {
                chatFooter.qHf.setPortHeightPX(j.fA(chatFooter.context));
            }
        }
        chatFooter.qHf.setToUser(chatFooter.toUser);
        chatFooter.qHf.ceU();
        chatFooter.qHf.cee();
        chatFooter.qHf.setVisibility(0);
        chatFooter.qHi = true;
    }

    static /* synthetic */ void J(ChatFooter chatFooter) {
        chatFooter.qMo.removeMessages(4097);
        chatFooter.qMo.sendEmptyMessageDelayed(4097, 1);
    }

    static /* synthetic */ void a(ChatFooter chatFooter, int i, String str) {
        if (bi.oW(chatFooter.qLj)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatFooter", "doSendImage : talker is null");
        } else if (str == null || str.equals("") || !e.cn(str)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatFooter", " doSendImage : filePath is null or empty");
        } else {
            au.DF().a(new l(4, q.GF(), chatFooter.qLj, str, i, null, 0, "", "", true, R.g.chat_img_template), 0);
        }
    }

    static /* synthetic */ int ceQ() {
        int i = count;
        count = i + 1;
        return i;
    }

    static /* synthetic */ void q(ChatFooter chatFooter) {
        if (chatFooter.qLD == 1) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")), bi.cjd(), chatFooter.activity});
            if (com.tencent.mm.pluginsdk.permission.a.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")) {
                chatFooter.setMode(2);
                return;
            }
            return;
        }
        chatFooter.setMode(1);
        if (chatFooter.qLw != null) {
            chatFooter.qLw.gq(true);
            chatFooter.qLw.bcw();
        }
    }

    public ChatFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.ern = null;
        this.kXF = null;
        this.kXG = null;
        this.qLl = null;
        this.qLx = null;
        this.qLy = new a((byte) 0);
        this.qLz = false;
        this.qLA = false;
        this.hnt = false;
        this.qLE = false;
        this.qLF = false;
        this.qLG = false;
        this.qHi = false;
        this.qLH = false;
        this.qLI = true;
        this.nVE = -1;
        this.nVF = -1;
        this.qLL = new 1(this);
        this.mHandler = new 12(this);
        this.qLM = false;
        this.qLO = false;
        this.qLR = new 10(this);
        this.qLS = new 11(this);
        this.hnB = new ag() {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (ChatFooter.this.oxs != null) {
                    ChatFooter.this.oxs.dismiss();
                    ChatFooter.this.qLm.setBackgroundDrawable(com.tencent.mm.bp.a.f(ChatFooter.this.getContext(), R.g.record_shape_normal));
                    ChatFooter.this.qLm.setEnabled(true);
                }
            }
        };
        this.qLU = 0;
        this.qLV = new 17(this);
        this.qLW = false;
        this.qLX = 0;
        this.qLY = 0;
        this.qLZ = 1;
        this.qMa = 2;
        this.qMb = 3;
        this.qMc = 20;
        this.qMd = 21;
        this.qMe = 22;
        this.qMf = 23;
        this.qMg = 0;
        this.qMh = 0;
        this.qMi = -1;
        this.qMj = -1;
        this.qMk = false;
        this.qMl = 4097;
        this.qMm = 4098;
        this.qMo = new 24(this);
        this.qMp = -1;
        this.qMq = -1;
        this.qMr = -1;
        this.qMs = null;
        this.qMt = true;
        this.qMu = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.qLC = (InputMethodManager) context.getSystemService("input_method");
        this.ern = inflate(context, R.i.chatting_footer, this);
        this.kXF = (MMEditText) this.ern.findViewById(R.h.chatting_content_et);
        com.tencent.mm.ui.tools.a.c.d(this.kXF).Gi(com.tencent.mm.k.b.Au()).a(null);
        this.kXF.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
        this.kXF.setOnFocusChangeListener(new 25(this));
        nc ncVar = new nc();
        ncVar.bYc.bYe = this.kXF;
        ncVar.bYc.bYd = new 26(this);
        com.tencent.mm.sdk.b.a.sFg.m(ncVar);
        this.qLs = this.ern.findViewById(R.h.text_panel_ll);
        this.qLo = (ChatFooterBottom) findViewById(R.h.chatting_bottom_panel);
        this.qLq = (ImageButton) this.ern.findViewById(R.h.chatting_attach_btn);
        this.kXG = (Button) this.ern.findViewById(R.h.chatting_send_btn);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.kXG.setTextSize(0, ((float) com.tencent.mm.bp.a.ae(context, R.f.HintTextSize)) * com.tencent.mm.bp.a.fg(context));
        this.qLm = (Button) this.ern.findViewById(R.h.voice_record_bt);
        this.qLn = (ImageButton) findViewById(R.h.chatting_mode_btn);
        go(false);
        ceO();
        this.qLu = new i(getContext(), getRootView(), this, new 27(this, context));
        this.qLu.qMS = this;
        Context context2 = getContext();
        getRootView();
        this.qLv = new m(context2);
        this.qLv.qLL = this.qLL;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[]{Integer.valueOf(this.kXF.getImeOptions())});
        this.kXF.setOnEditorActionListener(new 28(this));
        this.kXF.setOnTouchListener(new 29(this));
        this.kXF.setOnLongClickListener(new 2(this));
        this.kXG.setOnClickListener(new 3(this));
        this.qLm.setOnTouchListener(new 8(this));
        this.qLm.setOnKeyListener(new 9(this));
        this.qLn.setOnClickListener(new 7(this));
        cel();
        this.qLq.setVisibility(0);
        this.qLq.setContentDescription(getContext().getString(R.l.chat_footer_app_btn_fold));
        this.qLq.setOnClickListener(new 5(this));
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "[init]");
        Cl(-1);
        findViewById(R.h.chatting_foot_bar_group).setOnTouchListener(new 4(this));
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "init time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(Context context, Activity activity) {
        this.activity = activity;
        ceO();
        if (this.kXH != null) {
            this.kXH.onResume();
        }
        if (!this.qLM && this.qLF) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
            this.qLF = false;
            this.kXF.setImeOptions(0);
            this.kXF.setInputType(this.kXF.getInputType() | 64);
        } else if (this.qLM && !this.qLF) {
            ceF();
        }
        if (t.fC(context) != this.qLI) {
            ul();
        }
        if (this.qLk != null) {
            this.qLk.context = context;
        }
        this.context = context;
        this.qLu.qMR = false;
        if (!this.qHi) {
            this.ern.findViewById(R.h.chatting_send_group).setVisibility(0);
            this.kXF.setVisibility(0);
        }
        ceB();
        post(new 22(this));
        com.tencent.mm.sdk.b.a.sFg.b(this.qLV);
    }

    public void setFooterType(int i) {
        this.qFc = i;
        if (this.kXH != null) {
            this.kXH.setFooterType(i);
        }
    }

    public final void onPause() {
        this.qLO = true;
        if (this.kXH != null) {
            this.kXH.onPause();
        }
        if (this.qHi && this.qHf != null) {
            this.qHf.pause();
        }
        if (this.qLw != null) {
            this.qLw.onPause();
        }
        this.qMt = false;
        com.tencent.mm.sdk.b.a.sFg.c(this.qLV);
    }

    public void setTipsShowCallback(b bVar) {
        this.qLJ = bVar;
    }

    public void setVoiceInputShowCallback(c cVar) {
        this.qLK = cVar;
    }

    public final void destroy() {
        if (this.kXH != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "jacks chat footer desctory smiley panel");
            this.kXH.um();
            this.kXH.destroy();
            this.kXH = null;
        }
        if (this.qHf != null) {
            this.qHf.destroy();
            this.qHf = null;
            this.qHi = false;
        }
        if (this.qLw != null) {
            this.qLw.release();
        }
        if (this.qLv != null) {
            this.qLv.qLL = null;
            this.qLv.qNc = null;
            this.qLv.hide();
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "jacks destroy");
    }

    public final void cei() {
        if (this.qLk != null) {
            this.qLk.cdZ();
        }
    }

    private void go(boolean z) {
        if (this.qLP == null) {
            this.qLP = AnimationUtils.loadAnimation(getContext(), R.a.pop_in);
            this.qLP.setDuration(150);
        }
        if (this.qLQ == null) {
            this.qLQ = AnimationUtils.loadAnimation(getContext(), R.a.pop_out);
            this.qLQ.setDuration(150);
        }
        if (this.kXG != null && this.qLq != null) {
            if (this.qLM) {
                if (this.qLq.getVisibility() != 0) {
                    this.qLq.setVisibility(0);
                }
            } else if (this.kXG.getVisibility() != 0 || !z) {
                if (this.qLq.getVisibility() != 0 || z) {
                    if (z) {
                        this.kXG.startAnimation(this.qLP);
                        this.kXG.setVisibility(0);
                        this.qLq.startAnimation(this.qLQ);
                        this.qLq.setVisibility(8);
                    } else {
                        this.qLq.startAnimation(this.qLP);
                        if (!this.qLA) {
                            this.qLq.setVisibility(0);
                        }
                        this.kXG.startAnimation(this.qLQ);
                        this.kXG.setVisibility(8);
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[]{Boolean.valueOf(z)});
                    this.kXG.getParent().requestLayout();
                }
            }
        }
    }

    public int getBarGroupHeight() {
        return findViewById(R.h.chatting_foot_bar_group).getHeight();
    }

    public final void cej() {
        if (this.qLw != null) {
            this.qLw.bcv();
        }
        if (this.qLk.getVisibility() != 0 || this.qLo.ccw) {
            r(2, 22, true);
            if (this.qHf != null && this.qHf.getVisibility() == 0 && this.qHi) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
                this.qHf.setVisibility(8);
                this.qHi = false;
                this.qHf.reset();
            }
            ap ccb = ap.ccb();
            Context context = ad.getContext();
            if (g.Eg().Dx() && context != null) {
                try {
                    String value = com.tencent.mm.k.g.AT().getValue("ShowAPPSuggestion");
                    if (bi.oW(value) || Integer.valueOf(value).intValue() != 1) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[]{value});
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[]{e.getMessage()});
                }
                if (ccb.qAT) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
                } else {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
                    ccb.qAT = true;
                    if (System.currentTimeMillis() - ccb.qAW < 43200000) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SuggestionAppListLogic", "not now");
                        ccb.qAT = false;
                    } else {
                        g.Ek();
                        ccb.qAW = g.Ei().DT().Dj(352275);
                        if (System.currentTimeMillis() - ccb.qAW < 43200000) {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.SuggestionAppListLogic", "not now sp");
                            ccb.qAT = false;
                        } else {
                            if (ccb.lang == null) {
                                ccb.lang = w.d(context.getSharedPreferences(ad.chY(), 0));
                            }
                            ah ahVar = new ah(ccb.lang, new LinkedList());
                            com.tencent.mm.plugin.ac.a.bmi();
                            d.a(4, ahVar);
                        }
                    }
                }
            }
            ap ccb2 = ap.ccb();
            Context context2 = ad.getContext();
            if (g.Eg().Dx() && context2 != null) {
                if (ccb2.qAU) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
                    return;
                }
                ccb2.qAU = true;
                if (System.currentTimeMillis() - ccb2.qAZ < 43200000) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
                    ccb2.qAU = false;
                    return;
                }
                g.Ek();
                ccb2.qAZ = g.Ei().DT().Dj(352276);
                if (System.currentTimeMillis() - ccb2.qAZ < 43200000) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
                    ccb2.qAU = false;
                    return;
                }
                if (ccb2.lang == null) {
                    ccb2.lang = w.d(context2.getSharedPreferences(ad.chY(), 0));
                }
                ap.cR(ccb2.lang, ccb2.qAY);
            }
        } else if (this.qLD == 1) {
            showVKB();
        } else {
            r(0, -1, false);
        }
    }

    /* renamed from: kN */
    public final void a(boolean z) {
        if (this.kXF != null) {
            if (z) {
                this.kXF.requestFocus();
            } else {
                this.kXF.clearFocus();
            }
        }
    }

    public final void cek() {
        boolean z = true;
        if (this.context == null) {
            String str = "MicroMsg.ChatFooter";
            String str2 = "[initSmiley] activity = null? %s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.activity == null);
            com.tencent.mm.sdk.platformtools.x.e(str, str2, objArr);
            if (this.activity != null) {
                this.context = this.activity.getBaseContext();
            } else {
                this.context = getContext();
            }
        }
        if (e.qMK != null && this.context != null) {
            if (this.kXH != null) {
                this.kXH.destroy();
            }
            this.kXH = e.qMK.da(this.context);
            if (this.kXH != null) {
                this.kXH.setEntranceScene(ChatFooterPanel.qFe);
                if (this.kXH != null) {
                    this.kXH.setVisibility(8);
                }
                if (this.kXH != null) {
                    this.kXH.setFooterType(this.qFc);
                }
                if (this.qLo != null) {
                    this.qLo.addView(this.kXH, -1, -2);
                }
                if (this.kXH != null) {
                    this.kXH.setOnTextOperationListener(this.qLR);
                }
                if (this.kXH != null) {
                    ChatFooterPanel chatFooterPanel = this.kXH;
                    if (this.kXF.getText().length() <= 0) {
                        z = false;
                    }
                    chatFooterPanel.setSendButtonEnable(z);
                }
                if (this.kXH != null) {
                    this.kXH.setTalkerName(this.qLj);
                    if (j.fC(getContext())) {
                        this.kXH.setPortHeightPx(getKeyBordHeightPX());
                    } else {
                        this.kXH.setPortHeightPx(j.fA(getContext()));
                    }
                    if (!bi.oW(this.kXF.getText().toString())) {
                        this.kXH.up();
                    }
                }
                if (this.qLG) {
                    un();
                }
                setSmileyPanelCallback(this.qFb);
            }
        } else if (this.context == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", new Object[]{bi.cjd()});
            this.kXH = new d(ad.getContext());
        } else {
            this.kXH = new d(this.context);
        }
    }

    public final void un() {
        this.qLG = true;
        if (this.kXH != null) {
            this.kXH.un();
        }
    }

    public void setFooterEventListener(b bVar) {
        this.qLw = bVar;
    }

    public void setSmileyPanelCallback(f fVar) {
        this.qFb = fVar;
        if (this.kXH != null) {
            this.kXH.setCallback(fVar);
        }
    }

    public f getCallback() {
        return this.qFb;
    }

    public void setSmileyPanelCallback2(j jVar) {
        this.qLv.qNc = jVar;
    }

    private void Ch(int i) {
        if (this.qLn != null) {
            int i2;
            if (i == R.g.chatting_setmode_voice_btn) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.qLn != null) {
                if (i2 != 0) {
                    this.qLn.setContentDescription(getContext().getString(R.l.chat_footer_switch_mode_voice_btn));
                } else {
                    this.qLn.setContentDescription(getContext().getString(R.l.chat_footer_switch_mode_keybord_btn));
                }
            }
            this.qLn.setImageResource(i);
            this.qLn.setPadding(0, 0, 0, 0);
        }
    }

    private void cel() {
        this.qLk = (AppPanel) findViewById(R.h.chatting_app_panel);
        this.qLk.setOnSwitchPanelListener(this.qLS);
        this.qLk.setPortHeighPx(t.fA(this.context));
        if (s.hO(this.qLj) || s.hH(this.qLj)) {
            this.qLk.init(0);
        } else if (s.hf(this.qLj)) {
            this.qLk.init(4);
        } else if (s.fq(this.qLj)) {
            this.qLk.init(2);
        } else {
            this.qLk.init(1);
        }
        this.qLp = (TextView) findViewById(R.h.chatting_app_panel_tip);
    }

    public void setAppPanelTip(CharSequence charSequence) {
        if (this.qLp != null && this.qLk != null) {
            this.qLp.setText(charSequence);
        }
    }

    public void setAppPanelTipVisible(boolean z) {
        if (this.qLp != null) {
            if (TextUtils.isEmpty(this.qLp.getText())) {
                this.qLp.setVisibility(8);
                return;
            }
            if (z) {
                Context context = this.qLp.getContext();
                this.qLk.getPageMaxRowCount();
                int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(context, 32);
                ViewGroup.LayoutParams layoutParams = this.qLp.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
                    ((MarginLayoutParams) layoutParams).bottomMargin = fromDPToPix;
                }
            }
            this.qLp.setVisibility(z ? 0 : 8);
        }
    }

    public final void cem() {
        this.qLD = 1;
        this.qLs.setVisibility(0);
        this.qLm.setVisibility(8);
        Ch(R.g.chatting_setmode_voice_btn);
        if (this.qHf != null) {
            this.qHf.setVisibility(8);
            this.qHi = false;
            this.qHf.reset();
        }
        r(2, 21, true);
    }

    public void setDefaultSmileyByDetail(String str) {
        if (!bi.oW(str)) {
            if (this.kXH == null) {
                cek();
            }
            this.kXH.setDefaultEmojiByDetail(str);
        }
    }

    private void cdz() {
        if (this.qHi) {
            View findViewById = findViewById(R.h.chatting_foot_bar_group);
            this.qHi = false;
            if (this.qHf != null) {
                this.qHf.destroy();
                this.qHf.setVisibility(8);
            }
            findViewById.setVisibility(0);
            this.kXF.setVisibility(0);
            this.kXF.setText("");
            a(true);
            ceB();
            r(0, -1, false);
        }
    }

    public void setAtSomebody(String str) {
        this.qLy.qMB = str;
    }

    public void setLastContent(String str) {
        this.qLy.qMA = str;
    }

    public final void am(String str, String str2, String str3) {
        LinkedList linkedList;
        if (this.qLy.qMD.containsKey(str)) {
            linkedList = (LinkedList) this.qLy.qMD.get(str);
        } else {
            linkedList = new LinkedList();
            this.qLy.qMD.put(str, linkedList);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(str3, str2);
        linkedList.add(hashMap);
    }

    public void setInsertPos(int i) {
        this.qLy.qMC = i;
    }

    public String getAtSomebody() {
        return this.qLy.qMB;
    }

    public final HashMap<String, String> fD(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (bi.oW(str2)) {
            if (this.qLy.qMD.containsKey(str)) {
                this.qLy.qMD.remove(str);
            }
            return null;
        } else if (!this.qLy.qMD.containsKey(str) || ((LinkedList) this.qLy.qMD.get(str)).size() <= 0) {
            return null;
        } else {
            List<String> linkedList = new LinkedList();
            int i = 0;
            while (i < str2.length()) {
                i = str2.indexOf("@", i);
                if (i == -1) {
                    break;
                }
                int indexOf = str2.indexOf(8197, i);
                if (indexOf == -1 || indexOf - i > 40) {
                    break;
                }
                linkedList.add(str2.substring(i + 1, indexOf));
                i = indexOf + 1;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "after split @ :%s", new Object[]{linkedList});
            if (linkedList.size() <= 0) {
                ((LinkedList) this.qLy.qMD.get(str)).clear();
                return null;
            }
            LinkedList linkedList2 = (LinkedList) this.qLy.qMD.get(str);
            if (linkedList2 == null || linkedList2.size() <= 0) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChatFooter", "list is null or size 0");
                return null;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", new Object[]{Integer.valueOf(linkedList2.size())});
            List linkedList3 = new LinkedList();
            for (String str3 : linkedList) {
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    HashMap hashMap = (HashMap) it.next();
                    if (hashMap.containsKey(str3)) {
                        linkedList3.add(hashMap.get(str3));
                        break;
                    }
                }
            }
            HashMap<String, String> hashMap2 = new HashMap(1);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", new Object[]{Integer.valueOf(linkedList3.size())});
            hashMap2.put("atuserlist", "<![CDATA[" + bi.c(linkedList3, ",") + "]]>");
            linkedList2.clear();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return hashMap2;
        }
    }

    public String getLastContent() {
        return this.qLy.qMA;
    }

    public int getInsertPos() {
        return this.qLy.qMC;
    }

    public void setLastText(String str) {
        o(str, -1, true);
    }

    public final void o(String str, int i, boolean z) {
        if (z && (str == null || str.length() == 0 || this.kXF == null)) {
            this.kXF.setText("");
            return;
        }
        this.qLz = true;
        this.kXF.setText(com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), str, this.kXF.getTextSize()));
        this.qLz = false;
        if (i < 0 || i > this.kXF.getText().length()) {
            this.kXF.setSelection(this.kXF.getText().length());
        } else {
            this.kXF.setSelection(i);
        }
    }

    public void setHint(String str) {
        if (this.kXF != null) {
            this.kXF.setHint(str);
        }
    }

    public final void cen() {
        this.qLm.setEnabled(false);
        this.qLm.setBackgroundDrawable(com.tencent.mm.bp.a.f(getContext(), R.g.record_shape_disable));
        if (this.oxs != null) {
            this.iZg.setVisibility(0);
            this.iZf.setVisibility(8);
            this.oxv.setVisibility(8);
            this.oxs.update();
        }
        this.hnB.sendEmptyMessageDelayed(0, 500);
    }

    public String getLastText() {
        return this.kXF == null ? "" : this.kXF.getText().toString();
    }

    public int getSelectionStart() {
        return this.kXF.getSelectionStart();
    }

    public char getCharAtCursor() {
        int selectionStart = getSelectionStart();
        if (selectionStart <= 0) {
            return 'x';
        }
        return getLastText().charAt(selectionStart - 1);
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        this.qLT = new e(this, textWatcher);
        this.kXF.addTextChangedListener(this.qLT);
    }

    public final void Ci(int i) {
        this.qLU = 0;
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(getContext(), 180);
        int b = BackwardSupportUtil.b.b(getContext(), 50.0f);
        if (i + b < fromDPToPix) {
            this.qLU = -1;
        } else {
            this.qLU = ((i - fromDPToPix) / 2) + b;
        }
        if (this.oxs == null) {
            this.oxs = new o(View.inflate(getContext(), R.i.voice_rcd_hint_window, null), -1, -2);
            this.hnl = (ImageView) this.oxs.getContentView().findViewById(R.h.voice_rcd_hint_anim);
            this.iZh = this.oxs.getContentView().findViewById(R.h.voice_rcd_hint_anim_area);
            this.iZi = this.oxs.getContentView().findViewById(R.h.voice_rcd_hint_cancel_area);
            this.oxt = (TextView) this.oxs.getContentView().findViewById(R.h.voice_rcd_hint_cancel_text);
            this.oxu = (ImageView) this.oxs.getContentView().findViewById(R.h.voice_rcd_hint_cancel_icon);
            this.oxv = this.oxs.getContentView().findViewById(R.h.voice_rcd_hint_loading);
            this.iZf = this.oxs.getContentView().findViewById(R.h.voice_rcd_hint_rcding);
            this.iZg = this.oxs.getContentView().findViewById(R.h.voice_rcd_hint_tooshort);
            this.qLB = (TextView) this.oxs.getContentView().findViewById(R.h.voice_rcd_normal_wording);
        }
        if (this.qLU != -1) {
            this.iZg.setVisibility(8);
            this.iZf.setVisibility(8);
            this.oxv.setVisibility(0);
            new ag().post(new 15(this));
            this.oxs.showAtLocation(this, 49, 0, this.qLU);
        }
    }

    public void setRecordNormalWording(String str) {
        if (str != null && this.qLB != null) {
            this.qLB.setText(str);
        }
    }

    public final void ceo() {
        this.oxv.setVisibility(8);
        this.iZf.setVisibility(0);
    }

    public final void aMo() {
        post(new 16(this));
    }

    public final void Cj(int i) {
        int i2 = 0;
        while (i2 < erx.length) {
            if (i >= hnd[i2] && i < hnd[i2 + 1]) {
                this.hnl.setBackgroundDrawable(com.tencent.mm.bp.a.f(getContext(), erx[i2]));
                break;
            }
            i2++;
        }
        if (i == -1 && this.oxs != null) {
            this.oxs.dismiss();
            this.oxv.setVisibility(0);
            this.iZf.setVisibility(8);
            this.iZg.setVisibility(8);
        }
    }

    public void setMode(int i) {
        ag(i, true);
    }

    private void Ck(int i) {
        this.qLD = i;
        switch (i) {
            case 1:
                this.qLs.setVisibility(0);
                this.qLm.setVisibility(8);
                Ch(R.g.chatting_setmode_voice_btn);
                return;
            case 2:
                this.qLs.setVisibility(8);
                this.qLm.setVisibility(0);
                Ch(R.g.chatting_setmode_keyboard_btn);
                if (q.Hn().booleanValue() && this.qLJ != null) {
                    this.qLJ.b(Boolean.valueOf(true), Boolean.valueOf(true));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void ag(int i, boolean z) {
        boolean z2 = true;
        Ck(i);
        switch (i) {
            case 1:
                a(true);
                ceL();
                if (z) {
                    showVKB();
                    if (this.kXF.length() <= 0) {
                        z2 = false;
                    }
                    go(z2);
                    return;
                }
                if (this.kXF.length() <= 0) {
                    z2 = false;
                }
                go(z2);
                return;
            case 2:
                r(0, -1, false);
                go(false);
                return;
            default:
                setVisibility(0);
                return;
        }
    }

    public final void kO(boolean z) {
        if (this.kXH != null) {
            this.kXH.i(z, false);
        }
    }

    public final void cep() {
        this.qLs.setVisibility(0);
        this.qLn.setVisibility(8);
        this.qLm.setVisibility(8);
    }

    public final void ceq() {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qKJ.value = false;
        appPanel.ceb();
    }

    public final void cer() {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qLb.value = false;
        appPanel.ceb();
    }

    public final void ces() {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qKK.value = false;
        appPanel.ceb();
    }

    public final void cet() {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qKM.value = false;
        appPanel.ceb();
    }

    public final void ceu() {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qKN.value = false;
        appPanel.ceb();
    }

    public final void cev() {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qLa.value = false;
        appPanel.ceb();
    }

    public final void S(boolean z, boolean z2) {
        AppPanel appPanel = this.qLk;
        boolean z3 = !z;
        appPanel.qKn.qKO.value = z3;
        appPanel.ceb();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppPanel", "enable " + z3 + " isVoipPluginEnable " + appPanel.qKn.qKP.value);
        this.qLk.kI(z2);
    }

    public final void kP(boolean z) {
        AppPanel appPanel = this.qLk;
        boolean z2 = !z;
        appPanel.qKn.qLd.value = z2;
        appPanel.ceb();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppPanel", "enable " + appPanel.qKn.qLd.value + " isMultiTalkEnable " + z2);
    }

    public final void kQ(boolean z) {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qKW.value = !z;
        appPanel.ceb();
    }

    public final void cew() {
        AppPanel appPanel = this.qLk;
        appPanel.qKv = true;
        appPanel.qKn.kL(false);
        appPanel.ceb();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppPanel", "disableServiceLuckyMoney %s", new Object[]{bi.cjd().toString()});
    }

    public final void cex() {
        AppPanel appPanel = this.qLk;
        appPanel.qKw = true;
        appPanel.qKn.kK(false);
        appPanel.ceb();
    }

    public final void cey() {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qKT.value = false;
        appPanel.ceb();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppPanel", "disableTalkroom enable false");
    }

    public final void cez() {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qKY.value = false;
        appPanel.ceb();
    }

    public final void ceA() {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qKS.value = false;
        appPanel.ceb();
    }

    public final void ceB() {
        this.qLr = (ImageButton) this.ern.findViewById(R.h.chatting_smiley_btn);
        this.qLr.setVisibility(0);
        this.qLr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (ChatFooter.this.qLw != null) {
                    ChatFooter.this.qLw.bcu();
                }
                if (ChatFooter.this.qLo.ccw || ChatFooter.this.kXH == null || ChatFooter.this.kXH.getVisibility() != 0) {
                    if (ChatFooter.this.qLA) {
                        ChatFooter.this.un();
                    }
                    ChatFooter.this.cem();
                    return;
                }
                ChatFooter.this.showVKB();
            }
        });
        if (this.qLv != null) {
            this.qLv.qNb = this.qLr;
        }
    }

    public final void ceC() {
        if (this.qLr != null) {
            this.qLr.setVisibility(8);
        }
    }

    public final void ceD() {
        AppPanel appPanel = this.qLk;
        appPanel.qKx = true;
        appPanel.qKn.kM(false);
        appPanel.ceb();
    }

    public final void ceE() {
        AppPanel appPanel = this.qLk;
        appPanel.qKn.qLg.value = false;
        appPanel.ceb();
    }

    public final void ceF() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
        this.qLF = true;
        this.kXF.setImeOptions(4);
        this.kXF.setInputType(this.kXF.getInputType() & -65);
    }

    public int getMode() {
        return this.qLD;
    }

    public final void ceG() {
        if (this.kXH != null) {
            this.kXH.refresh();
        }
    }

    public void setAppPanelVisible(int i) {
        if (this.qLk != null) {
            this.qLk.setVisibility(i);
        }
        setAppPanelTipVisible(i == 0);
    }

    public final void ul() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "[dealOrientationChange]");
        cdz();
        ceL();
        Cl(-1);
        this.qLW = true;
        this.qLI = t.fC(this.context);
        ceG();
        if (this.kXH != null) {
            this.kXH.ul();
        }
    }

    public void setBottomPanelVisibility(int i) {
        if (i == 0) {
            this.qLo.setVisibility(i);
        } else {
            ceJ();
        }
    }

    public final boolean ceH() {
        if (this.qLN == null || this.qLN.getView() == null) {
            return false;
        }
        Rect rect = new Rect();
        this.qLN.getView().getGlobalVisibleRect(rect);
        if (rect.left > 0) {
            return true;
        }
        return false;
    }

    public final boolean ceI() {
        return this.qLo.getVisibility() == 0;
    }

    public void setWordCountLimit(int i) {
        this.qLl = (TextView) this.ern.findViewById(R.h.chatting_wordcount_tv);
        this.kXF.setFilters(new InputFilter[]{new LengthFilter(i)});
    }

    @TargetApi(11)
    public void setEditTextOnDragListener(OnDragListener onDragListener) {
        this.kXF.setOnDragListener(onDragListener);
    }

    public void setOnEditFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.kXF.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void setAppPanelListener(AppPanel.a aVar) {
        this.qLk.setAppPanelListener(aVar);
    }

    public void setSetTolastCustomPage(boolean z) {
    }

    public void setOnFooterSwitchListener(d dVar) {
        this.qLx = dVar;
        if (dVar != null) {
            View findViewById = findViewById(R.h.chatting_mode_switcher);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new 18(this));
        }
    }

    public void setSwitchButtonMode(int i) {
        if (i != this.qLX) {
            this.qLX = i;
            ImageView imageView = (ImageView) findViewById(R.h.switch_btn);
            ImageView imageView2 = (ImageView) findViewById(R.h.open_mini_program_btn);
            if (this.qLX == 1) {
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
                return;
            }
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
        }
    }

    public int getSmieyType() {
        return 0;
    }

    @TargetApi(11)
    public void setToSendTextColor(boolean z) {
        if (com.tencent.mm.compatible.util.d.fR(11)) {
            com.tencent.mm.compatible.a.a.a(11, new 19(this, z));
        } else if (z) {
            this.kXF.setTextColor(getResources().getColor(R.e.mm_edit_text_color));
        } else {
            this.kXF.setTextColor(getResources().getColor(R.e.half_alpha_black));
            a(false);
        }
    }

    public final void ceJ() {
        r(2, 20, false);
    }

    public final void showVKB() {
        if (!(this.qLN == null || !this.qLN.isSupportNavigationSwipeBack() || this.qLN.getSwipeBackLayout() == null)) {
            this.qLN.getSwipeBackLayout().setOnceDisEnableGesture(true);
        }
        post(new 21(this));
    }

    public final void r(int i, int i2, boolean z) {
        boolean z2 = true;
        if (!z) {
            this.qLq.setContentDescription(getContext().getString(R.l.chat_footer_app_btn_fold));
            switch (i) {
                case 0:
                    bi.hideVKB(this);
                    a(false);
                    if (!this.qHi) {
                        ceL();
                        break;
                    }
                    break;
                case 1:
                    bi.hideVKB(this);
                    break;
                case 2:
                    if (i2 != 20) {
                        if (i2 != 22) {
                            if (i2 != 21) {
                                if (i2 == 23) {
                                    cdz();
                                    ceL();
                                    break;
                                }
                            } else if (this.kXH != null) {
                                this.kXH.setVisibility(8);
                                break;
                            }
                        }
                        setAppPanelVisible(8);
                        break;
                    } else if (!this.qHi) {
                        ceL();
                        break;
                    } else {
                        bi.hideVKB(this);
                        break;
                    }
                    break;
            }
        }
        if (q.Hn().booleanValue() && this.qLJ != null) {
            this.qLJ.a(Boolean.valueOf(true), Boolean.valueOf(false));
            this.qLJ.b(Boolean.valueOf(true), Boolean.valueOf(false));
        }
        this.qLq.setContentDescription(getContext().getString(R.l.chat_footer_app_btn_expand));
        switch (i) {
            case 1:
                this.qLo.setIsHide(true);
                if (!t.fC(this.context) || isInMultiWindowMode()) {
                    this.qLo.setVisibility(8);
                }
                a(true);
                setToSendTextColor(true);
                this.qLC.showSoftInput(this.kXF, 0);
                break;
            case 2:
                if (i2 == 22) {
                    if (this.qLk == null) {
                        cel();
                    }
                    this.qLk.cee();
                    if (this.kXH != null) {
                        this.kXH.setVisibility(8);
                    }
                    setAppPanelVisible(0);
                    i iVar = this.qLu;
                    au.Em().H(new 3(iVar, new 2(iVar, iVar.context.getMainLooper())));
                    a(false);
                    if (this.qLD == 2) {
                        Ck(1);
                    }
                } else if (i2 == 21) {
                    if (this.qLk != null) {
                        setAppPanelVisible(8);
                    }
                    if (this.kXH == null) {
                        cek();
                    }
                    if (this.kXH != null) {
                        if (ab.XR(this.qLj)) {
                            this.kXH.un();
                        }
                        this.kXH.setVisibility(0);
                    }
                    kR(true);
                    a(true);
                }
                if (ceK() && j.fC(getContext()) && !isInMultiWindowMode()) {
                    this.qLH = true;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "bottom panel will show lately");
                } else {
                    this.qLo.setVisibility(0);
                }
                if (!(ceK() && j.fC(getContext()))) {
                    ViewGroup.LayoutParams layoutParams = this.qLo.getLayoutParams();
                    if (layoutParams != null && layoutParams.height == 0) {
                        layoutParams.height = j.fA(getContext());
                        this.qLo.setLayoutParams(layoutParams);
                    }
                }
                bi.hideVKB(this);
                break;
            case 3:
                this.qLo.setIsHide(true);
                if (!t.fC(this.context)) {
                    this.qLo.setVisibility(8);
                }
                a(true);
                setToSendTextColor(true);
                break;
            default:
                z = false;
                break;
        }
        if (!((!z || i2 == 21 || this.qLr == null) && (this.qLr == null || z || (i2 != 21 && i2 != 20)))) {
            kR(false);
        }
        if (i == 0 && !z) {
            kR(false);
        } else if (z && i2 != 22) {
            if (this.kXF.length() <= 0) {
                z2 = false;
            }
            go(z2);
        }
    }

    public final boolean ceK() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "is show key board %d, %d, %d", new Object[]{Integer.valueOf(this.nVF), Integer.valueOf(this.nVE), Integer.valueOf(ak.gs(this.context))});
        if (this.nVF <= 0 || this.nVF >= this.nVE - r2) {
            return false;
        }
        return true;
    }

    @TargetApi(24)
    private boolean isInMultiWindowMode() {
        if (!(getContext() instanceof Activity) || !com.tencent.mm.compatible.util.d.fR(24)) {
            return false;
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "isInMultiWindow %b ", new Object[]{Boolean.valueOf(((Activity) getContext()).isInMultiWindowMode())});
        return ((Activity) getContext()).isInMultiWindowMode();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        super.onLayout(z, i, i2, i3, i4);
        this.nVE = this.nVE < i4 ? i4 : this.nVE;
        this.nVF = i4;
        if (getTop() != 0) {
            if (getTop() > this.qMh) {
                this.qMh = getTop();
            }
            if (this.qMh - getTop() > 50) {
                if (this.qLw != null) {
                    this.qLw.gq(true);
                }
            } else if (this.qLw != null) {
                this.qLw.gq(false);
            }
        }
        if (z && this.qLv != null) {
            m mVar = this.qLv;
            if (mVar.qNa.isShowing()) {
                mVar.qNa.dismiss();
                mVar.ceT();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", new Object[]{Integer.valueOf(MeasureSpec.getSize(i2)), Integer.valueOf(getMeasuredHeight())});
        super.onMeasure(i, i2);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", new Object[]{Integer.valueOf(getMeasuredHeight())});
        if (this.qLH && this.qLo != null) {
            this.qLo.setVisibility(0);
            this.qLH = false;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "bottom panel shows as expected");
        }
    }

    public int getKeyBordHeightPX() {
        return j.s(getContext(), true);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    private void kR(boolean z) {
        if (this.qLr != null) {
            if (!this.qMk || !z) {
                if (this.qMk || z) {
                    this.qMk = z;
                    if (z) {
                        this.qLr.setImageDrawable(getContext().getResources().getDrawable(R.g.chatting_setmode_keyboard_btn));
                    } else {
                        this.qLr.setImageDrawable(getContext().getResources().getDrawable(R.g.chatting_setmode_biaoqing_btn));
                    }
                }
            }
        }
    }

    private void ceL() {
        this.qLo.setVisibility(8);
        setAppPanelVisible(8);
        if (this.kXH != null) {
            this.kXH.setVisibility(8);
        }
        kR(false);
    }

    private void Cl(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "[refreshBootomHeight] keyborPx:%d", new Object[]{Integer.valueOf(i)});
        j.chB();
        int al = j.al(this.context, i);
        this.qMg = al;
        if (al > 0 && this.qLo != null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "set bottom panel height: %d", new Object[]{Integer.valueOf(al)});
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 0);
            layoutParams.height = al;
            this.qLo.setLayoutParams(layoutParams);
        }
        if (this.qLk != null) {
            this.qLk.setPortHeighPx(al);
            AppPanel appPanel = this.qLk;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppPanel", "[forceRefreshSize]");
            appPanel.cee();
            appPanel.ul();
        }
        if (this.qHf != null) {
            this.qHf.setPortHeightPX(al);
            this.qHf.cee();
        }
        if (this.kXH != null) {
            if (!ceK()) {
                ceG();
            }
            this.kXH.setPortHeightPx(al);
            this.kXH.uq();
        }
    }

    /* renamed from: ceM */
    public final void y() {
        this.hnt = false;
        this.qLm.setBackgroundDrawable(com.tencent.mm.bp.a.f(getContext(), R.g.record_shape_normal));
        this.qLm.setText(R.l.chatfooter_presstorcd);
        if (this.qLw == null) {
            return;
        }
        if (this.iZi == null || this.iZi.getVisibility() != 0) {
            this.qLw.bcq();
        } else {
            this.qLw.bcs();
        }
    }

    public final boolean ceN() {
        return this.qMh - getTop() > 50;
    }

    public void setUserName(String str) {
        this.qLj = str;
        if (this.kXH != null) {
            this.kXH.setTalkerName(this.qLj);
        }
        if (this.qLk == null) {
            return;
        }
        if (s.hO(this.qLj) || s.hH(this.qLj)) {
            this.qLk.setServiceShowFlag(0);
        } else if (s.hf(this.qLj)) {
            this.qLk.setServiceShowFlag(4);
        } else if (s.fq(this.qLj)) {
            this.qLk.setServiceShowFlag(2);
        } else {
            this.qLk.setServiceShowFlag(1);
        }
    }

    public final void ceO() {
        au.HU();
        this.qLM = ((Boolean) com.tencent.mm.model.c.DT().get(66832, Boolean.valueOf(false))).booleanValue();
    }

    public void setCattingRootLayoutId(int i) {
        this.qMs = null;
        this.qMr = i;
    }

    public void onGlobalLayout() {
        if (this.activity != null && this.activity.getWindow() != null && this.activity.getWindow().getDecorView() != null) {
            if (this.qMr == -1) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChatFooter", "chattingui layout id == -1!");
                return;
            }
            if (this.qMs == null) {
                this.qMs = this.activity.getWindow().getDecorView().findViewById(this.qMr);
            }
            if (this.qMs == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatFooter", "can't get chattinguilayout by chattinguilayoutid: %d", new Object[]{Integer.valueOf(this.qMr)});
                return;
            }
            int height = this.qMs.getHeight();
            int width = this.qMs.getWidth();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "ashutest::keybord:ChatFooter measure height: %d, height: %d", new Object[]{Integer.valueOf(this.qMs.getMeasuredHeight()), Integer.valueOf(height)});
            if (this.qMj < height) {
                this.qMj = height;
            }
            this.qMi = height;
            if (this.qMp <= 0) {
                this.qMp = height;
            } else if (this.qMq <= 0) {
                this.qMq = width;
            } else if (this.qMp != height || this.qMq != width) {
                if (ceK() && this.qLO) {
                    this.qLO = false;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "keybord:Chatfooter Show keybord & hide diy panel by onGlobalLayout");
                    postDelayed(new 20(this), 10);
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "keybord:Chatfooter keybord old: %d, new: %d", new Object[]{Integer.valueOf(this.qMp), Integer.valueOf(height)});
                int gs = ak.gs(this.context);
                int abs = Math.abs(this.qMp - height);
                if (abs > gs) {
                    this.qMp = height;
                }
                height = Math.abs(this.qMq - width);
                this.qMq = width;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "alvinluo widthDiff: %d", new Object[]{Integer.valueOf(height)});
                if (this.qMt) {
                    if (abs == 0) {
                        if (this.qLk != null) {
                            this.qLk.setNeedRefreshHeight(true);
                            this.qLk.ul();
                        }
                        if (this.kXH != null) {
                            this.kXH.setPortHeightPx(j.fA(this.context));
                            ceG();
                            this.kXH.uq();
                        }
                    } else if (!j.fC(this.context)) {
                        return;
                    } else {
                        if (abs > gs) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "alvinluo keyboard current height: %d heightPx:%d", new Object[]{Integer.valueOf(this.qMg), Integer.valueOf(abs)});
                            if (this.qMg != abs || abs == -1) {
                                height = j.fA(this.context);
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "alvinluo valid panel height: %d", new Object[]{Integer.valueOf(height)});
                                width = j.fz(this.context);
                                gs = j.fy(this.context);
                                if (abs < width) {
                                    width = height;
                                } else {
                                    width = abs;
                                }
                                if (width <= gs) {
                                    height = width;
                                }
                                if (this.qLW) {
                                    this.qLW = false;
                                    if (height < this.qMg) {
                                        height = this.qMg;
                                    }
                                    this.qMg = height;
                                    Cl(height);
                                } else {
                                    this.qMg = height;
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatFooter", "jacks calc keyBord dialog height:%d", new Object[]{Integer.valueOf(this.qMg)});
                                    j.ak(getContext(), height);
                                    Cl(height);
                                }
                            }
                        }
                    }
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "keybord:Chatfooter Keyboard Size: " + abs);
            }
        }
    }

    public int getYFromBottom() {
        int fA = j.fA(getContext());
        int height = getHeight();
        return height < fA ? height + fA : height;
    }

    public View getPanel() {
        return this.qLo;
    }

    public void setLbsMode(boolean z) {
        this.qLA = z;
    }

    public boolean getIsVoiceInputPanleShow() {
        return this.qHi;
    }
}
