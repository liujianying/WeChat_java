package com.tencent.mm.ui.conversation.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.bp.a;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends b {
    private boolean dZm = false;
    TextView eCm;
    private TextView eCn;
    private ProgressDialog eHw = null;
    private TextView eSV;
    View gYR = null;
    private ImageView gmn;
    int oDy = 0;
    private TextView usE;
    private TextView usF;
    private ImageView usG;
    private ImageView usH;
    private ImageView usI;
    private ProgressBar usJ;
    String usK;
    private boolean usL = false;
    int usM;
    boolean usN;
    boolean usO;
    boolean usP;
    String usQ;
    al usR;
    c<kd> usS;
    boolean usT = false;

    static /* synthetic */ void a(n nVar, int i) {
        Intent intent = new Intent();
        intent.putExtra("diagnose_state", i);
        intent.putExtra("diagnose_percent", nVar.usM);
        intent.putExtra("diagnose_kvInfo", nVar.usQ);
        x.i("MicroMsg.NetWarnView", "put state: %d, process: %d, kv: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(nVar.usM), nVar.usQ});
        d.b((Context) nVar.qJS.get(), "traceroute", ".ui.NetworkDiagnoseAllInOneUI", intent);
    }

    public n(Context context) {
        super(context);
        initialize();
    }

    public final int getLayoutId() {
        return R.i.net_warn_item;
    }

    private void initialize() {
        if (!this.usL && this.view != null) {
            this.gYR = this.view.findViewById(R.h.nwview);
            this.eCm = (TextView) this.view.findViewById(R.h.nw_detail);
            this.eCn = (TextView) this.view.findViewById(R.h.nw_detail_tip);
            this.eSV = (TextView) this.view.findViewById(R.h.nw_hint_tip);
            this.usE = (TextView) this.view.findViewById(R.h.nw_btn);
            this.usJ = (ProgressBar) this.view.findViewById(R.h.nw_prog);
            this.gmn = (ImageView) this.view.findViewById(R.h.nw_icon);
            this.usG = (ImageView) this.view.findViewById(R.h.close_icon);
            this.usH = (ImageView) this.view.findViewById(R.h.forward_icon);
            this.usI = (ImageView) this.view.findViewById(R.h.silent_icon);
            this.usF = (TextView) this.view.findViewById(R.h.empty_space);
            this.usG.setVisibility(8);
            this.usL = true;
        }
    }

    final void czg() {
        if (this.usR != null) {
            this.usR.SO();
            this.usR = null;
        }
    }

    public final boolean anR() {
        boolean z;
        int i = 0;
        int Lg = au.DF().Lg();
        String networkServerIp = au.DF().getNetworkServerIp();
        this.usK = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.qVN), com.tencent.mm.protocal.d.DEVICE_TYPE, q.GF(), networkServerIp, w.chP()});
        initialize();
        x.i("MicroMsg.NetWarnView", "update st:%d", new Object[]{Integer.valueOf(Lg)});
        switch (Lg) {
            case 0:
                this.eCm.setText(R.l.net_warn_no_network);
                this.eCn.setVisibility(8);
                this.usE.setVisibility(8);
                this.usJ.setVisibility(8);
                this.gmn.setVisibility(0);
                this.gYR.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, ((Context) n.this.qJS.get()).getString(R.l.net_warn_no_network));
                        intent.putExtra("rawUrl", ((Context) n.this.qJS.get()).getString(R.l.net_warn_detail_doc));
                        intent.putExtra("showShare", false);
                        d.b((Context) n.this.qJS.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
                z = true;
                break;
            case 2:
                if (this.oDy == 1) {
                    this.eCm.setText(((Context) this.qJS.get()).getResources().getString(R.l.net_warn_diagnose_doing, new Object[]{Integer.valueOf(this.usM)}));
                } else {
                    this.eCm.setText(R.l.net_warn_diagnose_begin);
                }
                this.eCn.setVisibility(8);
                this.usE.setVisibility(8);
                this.usJ.setVisibility(8);
                this.gmn.setVisibility(0);
                this.gYR.setOnClickListener(new 4(this));
                z = true;
                break;
            case 3:
                this.eCm.setText(R.l.net_warn_connecting);
                this.eCn.setVisibility(8);
                this.usE.setVisibility(8);
                this.usJ.setVisibility(0);
                this.gmn.setVisibility(0);
                z = true;
                break;
            case 5:
                this.eCm.setText(R.l.net_warn_server_down);
                this.eCn.setText(((Context) this.qJS.get()).getString(R.l.net_warn_server_down_tip));
                this.eCn.setVisibility(0);
                this.usE.setVisibility(8);
                this.usJ.setVisibility(8);
                this.gmn.setVisibility(0);
                this.gYR.setOnClickListener(new 5(this));
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            this.eSV.setVisibility(8);
            this.eCm.setVisibility(0);
            this.gYR.setBackgroundResource(R.g.tips_bar_red_selector);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.gmn.getLayoutParams());
            layoutParams.setMargins(a.fromDPToPix((Context) this.qJS.get(), 10), 0, a.fromDPToPix((Context) this.qJS.get(), 4), 0);
            this.gmn.setLayoutParams(layoutParams);
            this.gmn.setImageResource(R.k.tipsbar_icon_warning);
            this.usH.setVisibility(8);
            this.usI.setVisibility(8);
            this.usF.setVisibility(8);
        } else {
            au.HU();
            if (com.tencent.mm.model.c.FM()) {
                au.HU();
                if (l.il(com.tencent.mm.model.c.FN())) {
                    o DF = au.DF();
                    au.HU();
                    DF.a(new l(com.tencent.mm.model.c.FN()), 0);
                }
            }
            au.HU();
            if (!(!com.tencent.mm.model.c.FM() || ai.oW(l.efv) || l.QX())) {
                this.gYR.setBackgroundResource(R.g.tips_bar_white_selector);
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.gmn.getLayoutParams());
                layoutParams2.setMargins(a.fromDPToPix((Context) this.qJS.get(), 22), 0, a.fromDPToPix((Context) this.qJS.get(), 20), 0);
                this.gmn.setLayoutParams(layoutParams2);
                this.eCm.setVisibility(8);
                this.eCn.setVisibility(8);
                this.eSV.setVisibility(0);
                if (q.gT(q.GL())) {
                    if (l.Ra() || !l.QY()) {
                        this.eSV.setText(l.efv);
                    } else {
                        this.eSV.setText(l.efC);
                    }
                } else if (l.Ra() || !l.QY()) {
                    this.eSV.setText(l.efy);
                } else {
                    this.eSV.setText(l.efD);
                }
                this.usE.setVisibility(8);
                this.usJ.setVisibility(8);
                this.gmn.setPadding(0, 0, 0, 0);
                if (l.QW() == 1) {
                    this.gmn.setImageResource(R.k.connectkeyboad_banner_icon_pc);
                } else if (l.QW() == 2) {
                    if (l.QY()) {
                        this.gmn.setImageResource(R.k.connectkeyboad_banner_icon_maclock);
                    } else {
                        this.gmn.setImageResource(R.k.connectkeyboad_banner_icon_mac);
                    }
                } else if (l.QW() == 3) {
                    this.gmn.setImageResource(R.k.connectkeyboad_banner_icon_ipad);
                } else {
                    this.gmn.setImageResource(R.k.tipsbar_icon_default);
                }
                this.gmn.setVisibility(0);
                this.usH.setVisibility(8);
                this.usI.setVisibility(8);
                TextView textView = this.usF;
                if (q.gT(q.GL())) {
                    Lg = 8;
                } else {
                    Lg = 0;
                }
                textView.setVisibility(Lg);
                Intent intent = new Intent();
                intent.putExtra("intent.key.online_version", l.QZ());
                this.gYR.setOnClickListener(new 6(this, intent));
                z = true;
            }
        }
        if (!z) {
            this.usG.setVisibility(8);
            if (af.ewG) {
                boolean z2;
                int backgroundLimitType = ao.getBackgroundLimitType((Context) this.qJS.get());
                if (!ao.isLimited(backgroundLimitType) || this.usT) {
                    this.usG.setVisibility(8);
                    z2 = z;
                } else {
                    this.eCm.setText(((Context) this.qJS.get()).getString(R.l.process_limited_warn_title));
                    this.eCn.setText(((Context) this.qJS.get()).getString(R.l.process_limited_warn_message));
                    this.eCn.setVisibility(0);
                    this.usE.setVisibility(8);
                    this.usJ.setVisibility(8);
                    this.gmn.setVisibility(0);
                    this.usG.setVisibility(0);
                    this.gYR.setOnClickListener(new 7(this, backgroundLimitType));
                    this.usG.setOnClickListener(new 8(this, backgroundLimitType));
                    z2 = true;
                }
                z = z2;
            }
        }
        this.usI.setImageResource(R.k.chat_mute_notify_normal);
        this.usG.setImageResource(R.g.bottle_close_frame_state);
        View view = this.gYR;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        return z;
    }

    public final void destroy() {
        czg();
        if (this.usS != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.usS);
        }
    }

    public final void setVisibility(int i) {
        if (this.gYR != null) {
            this.gYR.setVisibility(i);
        }
    }

    public final int getOrder() {
        return 2;
    }
}
