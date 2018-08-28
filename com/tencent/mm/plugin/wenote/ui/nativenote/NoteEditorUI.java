package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.k.b;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.10;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.11;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.12;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.13;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.2;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.4;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e.5;
import com.tencent.mm.plugin.wenote.model.nativenote.c.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.c;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.1;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.6;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.7;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.8;
import com.tencent.mm.plugin.wenote.ui.nativenote.c.9;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class NoteEditorUI extends BaseFavDetailReportUI implements e, a, g.a, a {
    private static final long jaZ = ((long) b.AB());
    private View FU = null;
    OnGlobalLayoutListener LE = new 31(this);
    private RecyclerView Sa;
    private long bJC = -1;
    private long dTK = -1;
    private ag dvh;
    private ProgressDialog eHw = null;
    private float ftq = 0.0f;
    private float ftr = 0.0f;
    private p iBL = null;
    private String iSr;
    private String iux = "";
    private int jDz = 0;
    protected com.tencent.mm.ui.widget.snackbar.a.b jKu = new 16(this);
    private boolean qnN = false;
    private int qrC;
    private k qtF;
    private c qtG;
    private LinearLayout qtH;
    private c qtI = null;
    private RelativeLayout qtJ = null;
    private g qtK = null;
    private boolean qtL = false;
    private boolean qtM = false;
    private boolean qtN = false;
    private String qtO = "";
    private com.tencent.mm.plugin.wenote.ui.nativenote.a.a qtP;
    private boolean qtQ = false;
    private boolean qtR = false;
    private a qtS;
    private vx qtT;
    private boolean qtU = false;
    private final Object qtV = new Object();
    private LinearLayout qtW = null;
    private String qtX = "";
    private int qtY = 0;
    private int qtZ = 0;
    private int qub = 0;
    private String[] quc = null;
    private boolean qud = true;
    private long que = 0;
    private boolean quf = false;
    private String qug;
    private boolean quh = false;
    private boolean qui = false;
    private boolean quj = false;
    private boolean quk = true;
    private int qul = 0;
    private RecyclerView.k qum = null;
    OnTouchListener qun = new 35(this);
    private boolean quo = false;
    private int qup = -1;
    private boolean quq = false;

    public void onCreate(Bundle bundle) {
        this.qrC = getIntent().getIntExtra("note_open_from_scene", 2);
        this.bJC = getIntent().getLongExtra("note_msgid", -1);
        this.qui = getIntent().getBooleanExtra("record_show_share", false);
        this.dTK = getIntent().getLongExtra("note_fav_localid", -1);
        this.iux = getIntent().getStringExtra("note_link_sns_localid");
        this.qnN = getIntent().getBooleanExtra("edit_status", false);
        this.qtX = getIntent().getStringExtra("fav_note_xml");
        this.qtZ = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
        this.qub = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
        this.iSr = getIntent().getStringExtra("fav_note_thumbpath");
        this.qud = getIntent().getBooleanExtra("show_share", true);
        this.qug = getIntent().getStringExtra("fav_note_link_sns_xml");
        String stringExtra = getIntent().getStringExtra("fav_note_link_source_info");
        this.quj = getIntent().getBooleanExtra("fav_note_out_of_date", false);
        if (!bi.oW(stringExtra)) {
            this.quc = stringExtra.split(";");
        }
        if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
            this.quf = true;
        }
        d.qnP = false;
        if (this.quc == null && this.dTK > 0) {
            fz fzVar = new fz();
            fzVar.bOL.type = 30;
            fzVar.bOL.bOS = 3;
            fzVar.bOL.bJA = this.dTK;
            com.tencent.mm.sdk.b.a.sFg.m(fzVar);
            this.quc = bi.oW(fzVar.bOM.path) ? null : fzVar.bOM.path.split(";");
        }
        if (this.quc == null || this.quc.length >= 3) {
            View inflate;
            this.dvh = new ag();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c bZD = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD();
            bZD.gBc = new ArrayList();
            bZD.qpR = this;
            bZD.qpS = new vx();
            bZD.qpT = 0;
            bZD.qpU = 0;
            bZD.qpV = 0;
            x.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
            com.tencent.mm.pluginsdk.e.k(this);
            super.onCreate(bundle);
            dE(this.dTK);
            x.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
            h hVar = new h();
            hVar.content = "";
            hVar.qoH = true;
            hVar.qoN = false;
            if (this.qnN) {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(hVar);
                this.quf = true;
            }
            this.FU = this.mController.contentView;
            this.FU.getRootView().setBackgroundColor(-1);
            this.Sa = (RecyclerView) findViewById(R.h.werichtext_content);
            this.qtH = (LinearLayout) this.FU.findViewById(R.h.edit_footer);
            this.qtH.setVisibility(8);
            this.qtW = (LinearLayout) this.qtH.findViewById(R.h.note_words_style_layout);
            this.qtW.setVisibility(8);
            this.qtJ = (RelativeLayout) findViewById(R.h.wenote_cover_rl);
            this.qtJ.setOnClickListener(new 1(this));
            this.qtK = new g(this, this.qtJ);
            this.qtK.qqv = this;
            this.qtP = new com.tencent.mm.plugin.wenote.ui.nativenote.a.a();
            this.qtP.qvc = j.db(this)[1];
            this.Sa.setLayoutManager(this.qtP);
            this.Sa.setHasFixedSize(true);
            this.qtS = new a(this);
            this.Sa.a(this.qtS);
            this.qtF = new k(this);
            this.qtF.bJA = this.dTK;
            this.qtF.qrC = this.qrC;
            this.qtF.qrD = this.quf;
            this.qtG = new c(this.qtF);
            this.Sa.setAdapter(this.qtG);
            if (this.qrC == 2) {
                this.Sa.setOnTouchListener(this.qun);
            }
            this.Sa.getItemAnimator().RV = 0;
            this.Sa.getItemAnimator().RY = 0;
            this.Sa.getItemAnimator().RX = 0;
            this.Sa.getItemAnimator().RW = 120;
            ((aj) this.Sa.getItemAnimator()).UM = false;
            this.qul = com.tencent.mm.bp.a.fromDPToPix(this, 48);
            if (this.quk) {
                x.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
                boolean z = this.qrC == 2 && this.quf;
                int color = getResources().getColor(R.e.note_cursor_color);
                com.tencent.mm.plugin.wenote.model.nativenote.c.e cap = com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap();
                x.i("NoteSelectManager", "onInit start");
                if (this == null || this == null) {
                    x.e("NoteSelectManager", "context or listener is null");
                } else {
                    cap.qsc = z;
                    cap.qsf = 14;
                    cap.qsg = 32;
                    cap.qsh = com.tencent.mm.bp.a.fromDPToPix(this, 21) - cap.qsg;
                    cap.qsi = com.tencent.mm.bp.a.fromDPToPix(this, 40) + (cap.qsg * 2);
                    cap.qsj = com.tencent.mm.bp.a.fromDPToPix(this, 240) + (cap.qsg * 2);
                    cap.qsd = com.tencent.mm.bp.a.fromDPToPix(this, 22);
                    cap.qse = com.tencent.mm.bp.a.fromDPToPix(this, 1);
                    cap.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
                    cap.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
                    cap.qsn = new int[]{-1, -1};
                    cap.qso = new int[]{-1, -1};
                    cap.qsp = new int[]{-1, -1};
                    cap.qsq = new int[]{-1, -1};
                    com.tencent.mm.plugin.wenote.model.nativenote.c.a aVar = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, cap.qsd, cap.qse, color, cap);
                    cap.qsr = new PopupWindow(aVar, aVar.getViewWidth(), aVar.getViewHeight(), false);
                    cap.qsr.setClippingEnabled(false);
                    cap.qsr.setAnimationStyle(R.m.note_cursor_mid_style);
                    cap.qsl = aVar.getOffsetForCursorMid();
                    cap.qsm = com.tencent.mm.bp.a.fromDPToPix(this, 6);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.a aVar2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, cap.qsd, cap.qse, color, cap);
                    cap.qss = new PopupWindow(aVar2, aVar2.getViewWidth(), aVar.getViewHeight(), false);
                    cap.qss.setClippingEnabled(false);
                    cap.qss.setAnimationStyle(R.m.note_cursor_left_style);
                    aVar2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, cap.qsd, cap.qse, color, cap);
                    cap.qst = new PopupWindow(aVar2, aVar2.getViewWidth(), aVar.getViewHeight(), false);
                    cap.qst.setClippingEnabled(false);
                    cap.qst.setAnimationStyle(R.m.note_cursor_right_style);
                    inflate = LayoutInflater.from(this).inflate(R.i.note_operation_window, null);
                    inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    cap.qsu = new PopupWindow(inflate, -2, -2, false);
                    cap.qsu.setBackgroundDrawable(getResources().getDrawable(R.g.sub_menu_bg));
                    cap.qsu.setClippingEnabled(false);
                    cap.qsu.setAnimationStyle(R.m.note_operation_window_style);
                    cap.qsA = (TextView) inflate.findViewById(R.h.note_bold_tv);
                    cap.qsB = (TextView) inflate.findViewById(R.h.note_unbold_tv);
                    cap.qsC = (TextView) inflate.findViewById(R.h.note_select_tv);
                    cap.qsD = (TextView) inflate.findViewById(R.h.note_select_all_tv);
                    cap.qsE = (TextView) inflate.findViewById(R.h.note_delete_tv);
                    cap.qsF = (TextView) inflate.findViewById(R.h.note_cut_tv);
                    cap.qsG = (TextView) inflate.findViewById(R.h.note_copy_tv);
                    cap.qsH = (TextView) inflate.findViewById(R.h.note_paste_tv);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.f(cap.qsA, cap.qsf);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.f(cap.qsB, cap.qsf);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.f(cap.qsC, cap.qsf);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.f(cap.qsD, cap.qsf);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.f(cap.qsE, cap.qsf);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.f(cap.qsF, cap.qsf);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.f(cap.qsG, cap.qsf);
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.f(cap.qsH, cap.qsf);
                    cap.qsA.setOnClickListener(new 10(cap));
                    cap.qsB.setOnClickListener(new 11(cap));
                    cap.qsC.setOnClickListener(new 12(cap));
                    cap.qsD.setOnClickListener(new 13(cap));
                    cap.qsE.setOnClickListener(new 2(cap));
                    cap.qsF.setOnClickListener(new e$3(cap));
                    cap.qsG.setOnClickListener(new 4(cap));
                    cap.qsH.setOnClickListener(new 5(cap));
                    cap.qsk = aVar.getViewPadding();
                    cap.qsv = this;
                    cap.qsw = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
                    cap.qsx = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
                    cap.mHandler = new ag();
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = true;
                    x.i("NoteSelectManager", "onInit end");
                }
                this.qum = new RecyclerView.k() {
                    public final void e(RecyclerView recyclerView, int i) {
                        super.e(recyclerView, i);
                        switch (i) {
                            case 0:
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().ky(com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().caw());
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().kx(com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().cau());
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().f(false, 50);
                                return;
                            case 1:
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().cax();
                                com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().cav();
                                return;
                            default:
                                return;
                        }
                    }

                    public final void c(RecyclerView recyclerView, int i, int i2) {
                        super.c(recyclerView, i, i2);
                        if (i2 > 30) {
                            com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().cax();
                            com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().cav();
                        }
                        com.tencent.mm.plugin.wenote.model.nativenote.c.d car = com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().car();
                        if ((NoteEditorUI.this.qtR || (NoteEditorUI.this.qtH != null && NoteEditorUI.this.qtH.getVisibility() == 0)) && car.cao() == 2 && f.g(recyclerView, car.dHJ) == null) {
                            NoteEditorUI.this.bZs();
                        }
                    }
                };
                this.Sa.a(this.qum);
            }
            if (this.iBL != null) {
                this.iBL.dismiss();
                this.iBL = null;
            }
            if (!(this.qnN || this.quj)) {
                this.iBL = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.wv_loading), true, new 12(this));
            }
            if (this.quj) {
                x.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
                com.tencent.mm.ui.base.h.b(this.mController.tml, this.mController.tml.getString(R.l.note_fail_or_clean), null, true);
            }
            if (this.qud) {
                addIconOptionMenu(1, R.l.top_item_desc_more, R.k.actionbar_icon_dark_more, new 23(this));
            }
            setMMTitle(getString(R.l.favorite_wenote_detail));
            lD(true);
            setBackBtn(new 30(this), R.k.actionbar_icon_dark_back);
            com.tencent.mm.pluginsdk.e.l(this);
            if (this.qnN) {
                e(true, 300);
                Q(1, 0);
            }
            if (this.qrC == 2 && this.quf) {
                this.qtI = new c();
                c cVar = this.qtI;
                inflate = this.qtH;
                cVar.eZZ = inflate;
                k.caj().qrx = cVar;
                cVar.quI = (LinearLayout) inflate.findViewById(R.h.note_words_style_layout);
                cVar.quH = (ImageButton) inflate.findViewById(R.h.wenote_h5_footer_words_style);
                cVar.quJ = (ImageButton) inflate.findViewById(R.h.wenote_h5_footer_file);
                cVar.quK = (ImageButton) inflate.findViewById(R.h.wenote_h5_footer_location);
                cVar.quL = (ImageButton) inflate.findViewById(R.h.wenote_h5_footer_image);
                cVar.quM = (ImageButton) inflate.findViewById(R.h.wenote_h5_footer_voice);
                cVar.quN = (LinearLayout) cVar.quI.findViewById(R.h.words_style_btn_note_bold_ll);
                cVar.quO = (LinearLayout) cVar.quI.findViewById(R.h.words_style_btn_note_ul_ll);
                cVar.quP = (LinearLayout) cVar.quI.findViewById(R.h.words_style_btn_note_ol_ll);
                cVar.quQ = (LinearLayout) cVar.quI.findViewById(R.h.words_style_btn_note_split_ll);
                cVar.quR = (LinearLayout) cVar.quI.findViewById(R.h.more_btn_note_todo_ll);
                cVar.quH.setOnClickListener(new 1(cVar, this));
                cVar.quL.setOnClickListener(new 6(cVar, this));
                cVar.quM.setOnClickListener(new 7(cVar, this, this));
                cVar.quJ.setOnClickListener(new 8(cVar, this));
                cVar.quK.setOnClickListener(new 9(cVar, this));
                cVar.quR.setOnClickListener(new c.10(cVar, this));
                cVar.quN.setOnClickListener(new c$11(cVar, this));
                cVar.quO.setOnClickListener(new c$12(cVar, this));
                cVar.quP.setOnClickListener(new c.13(cVar, this));
                cVar.quQ.setOnClickListener(new c.2(cVar, this));
                getWindow().setSoftInputMode(18);
            } else {
                this.qtH.setVisibility(8);
            }
            this.Sa.getViewTreeObserver().addOnGlobalLayoutListener(this.LE);
            this.que = System.currentTimeMillis();
            x.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", new Object[]{Long.valueOf(this.que)});
            au.DF().a(921, this);
        }
    }

    private boolean c(com.tencent.mm.plugin.wenote.model.a.p pVar) {
        if (pVar == null) {
            return false;
        }
        if (pVar.qpf != (this.qrC == 1)) {
            return false;
        }
        if ((this.qrC == 1 && pVar.qph == this.bJC) || (this.qrC == 2 && pVar.qpg == this.dTK)) {
            return true;
        }
        return false;
    }

    public void onBackPressed() {
        if (caP()) {
            goBack();
            super.onBackPressed();
        }
    }

    protected final int getLayoutId() {
        return R.i.note_editor_main;
    }

    public final void bZp() {
        com.tencent.mm.ui.base.h.b(this.mController.tml, getString(R.l.note_record_exit_request), null, true);
    }

    private boolean caP() {
        if (this.qtI == null || !this.qtI.quS) {
            return true;
        }
        bZp();
        return false;
    }

    private void goBack() {
        if (this.qrC == 2 && this.qtF.qrD) {
            if (!(this.qtM || this.qnN)) {
                fz fzVar = new fz();
                fzVar.bOL.type = 19;
                fzVar.bOL.bJA = this.dTK;
                fzVar.bOL.bOS = -1;
                com.tencent.mm.sdk.b.a.sFg.m(fzVar);
                if (!(!fzVar.bOM.bPd)) {
                    this.qtM = true;
                    this.qtN = true;
                } else {
                    return;
                }
            }
            caQ();
            finish();
        }
    }

    public final void caQ() {
        this.qtI.a(this);
        final String bZK = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZK();
        String Sp = com.tencent.mm.plugin.wenote.b.b.Sp(Pattern.compile("<object[^>]*>", 2).matcher(bZK).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#"));
        if (!(bi.oW(Sp) || Sp.length() == 0)) {
            Sp = Pattern.compile("\\s*|\t|\r|\n").matcher(Sp).replaceAll("");
        }
        if ((bi.oW(Sp) ? 1 : null) != null) {
            fz fzVar = new fz();
            fzVar.bOL.type = 12;
            fzVar.bOL.bJA = this.dTK;
            com.tencent.mm.sdk.b.a.sFg.m(fzVar);
        } else if (this.qnN) {
            x.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
            au.Em().H(new Runnable() {
                public final void run() {
                    NoteEditorUI.this.bj(bZK, true);
                }
            });
        } else if (this.qtM) {
            x.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
            au.Em().H(new 34(this, bZK));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.quk) {
            if (this.Sa != null) {
                RecyclerView recyclerView = this.Sa;
                RecyclerView.k kVar = this.qum;
                if (recyclerView.RD != null) {
                    recyclerView.RD.remove(kVar);
                }
            }
            com.tencent.mm.plugin.wenote.model.nativenote.c.e cap = com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap();
            x.i("NoteSelectManager", "onDestroy");
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit = false;
            if (cap.qsy != null) {
                cap.qsy.SO();
            }
            if (cap.qsz != null) {
                cap.qsz.SO();
            }
            if (cap.qsr != null) {
                cap.qsr.dismiss();
            }
            if (cap.qss != null) {
                cap.qss.dismiss();
            }
            if (cap.qst != null) {
                cap.qst.dismiss();
            }
            if (cap.qsu != null) {
                cap.qsu.dismiss();
            }
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.qsb = null;
        }
        au.DF().b(921, this);
        if (this.qtF != null) {
            k kVar2 = this.qtF;
            kVar2.qrF.SO();
            kVar2.qrv = -1;
            k.qrq = null;
        }
        if (com.tencent.mm.plugin.wenote.model.c.bZb().qnC != null) {
            com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnI.clear();
            com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnH.clear();
            com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnG.clear();
        }
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a cbb = com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cbb();
        cbb.stopPlay();
        cbb.hlW = null;
        cbb.hma = null;
        cbb.cWy.clear();
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.qwc = null;
        if (com.tencent.mm.plugin.wenote.model.k.bZf() != null) {
            com.tencent.mm.plugin.wenote.model.k.destroy();
        }
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().qpR = null;
    }

    public final void bZy() {
        if (this.qtI != null) {
            this.qtI.a(null);
        }
    }

    public final void Bo(final int i) {
        Handler handler = getWindow().getDecorView().getHandler();
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[]{Integer.valueOf(i)});
                    NoteEditorUI.this.qtG.bl(i);
                    x.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[]{Integer.valueOf(i)});
                }
            }, 0);
        }
    }

    public final void Bq(int i) {
        try {
            this.qtG.bn(i);
        } catch (Exception e) {
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public final void Bp(int i) {
        try {
            this.qtG.bm(i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public final void en(int i, int i2) {
        try {
            this.qtG.Z(i, i2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void eo(int i, int i2) {
        try {
            this.qtG.X(i, i2);
        } catch (Exception e) {
            x.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void caR() {
        try {
            this.qtG.RR.notifyChanged();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            x.i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
        }
    }

    public final void kr(boolean z) {
        x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[]{Boolean.valueOf(z)});
        if (this.qtL || com.tencent.mm.plugin.wenote.model.c.bZb().qnC == null) {
            boolean z2;
            String str = "MicroMsg.Note.NoteEditorUI";
            String str2 = "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.qtL);
            if (com.tencent.mm.plugin.wenote.model.c.bZb().qnC == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            x.e(str, str2, objArr);
            return;
        }
        v vVar;
        if (this.qrC != 1) {
            x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
            if (com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnF == null) {
                x.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
                return;
            }
            vVar = (v) com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnG.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnF.field_localId));
        } else {
            x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
            if (com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnE == null) {
                x.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
                return;
            }
            vVar = (v) com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnG.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnE.bJC));
        }
        if (vVar != null && !this.qnN) {
            this.qtU = vVar.qpw;
            if (vVar.qpw) {
                m(vVar.qpv, false);
                return;
            }
            this.qtL = true;
            m(vVar.qpv, true);
        }
    }

    public final synchronized void m(Object obj, final boolean z) {
        x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData,canDismissLoadingDialog:%B", new Object[]{Boolean.valueOf(z)});
        synchronized (this.qtV) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZE();
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList == null) {
            } else {
                x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData start");
                if (this.qrC == 2 && !this.quf) {
                    l lVar = com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnE;
                    if (lVar == null) {
                    } else {
                        com.tencent.mm.plugin.wenote.model.a.d dVar = new com.tencent.mm.plugin.wenote.model.a.d(lVar.qpa);
                        dVar.qoH = false;
                        dVar.qoN = false;
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(dVar);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    n nVar = (n) it.next();
                    switch (nVar.type) {
                        case IX5WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                        case IX5WebViewClient.ERROR_HOST_LOOKUP /*-2*/:
                            break;
                        case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a((com.tencent.mm.plugin.wenote.model.a.g) nVar);
                            break;
                        case 1:
                            h hVar = (h) nVar;
                            if (bi.oW(hVar.content)) {
                                hVar.content = "";
                            }
                            hVar.content = hVar.content.replaceAll("<font", "<wx-font").replaceAll("<div", "<wx-div").replaceAll("<p", "<wx-p").replaceAll("</font>", "</wx-font>").replaceAll("<ul>", "<wx-ul>").replaceAll("</ul>", "</wx-ul>").replaceAll("<ol>", "<wx-ol>").replaceAll("</ol>", "</wx-ol>").replaceAll("<li>", "<wx-li>").replaceAll("</li>", "</wx-li>").replaceAll("<b>", "<wx-b>").replaceAll("</b>", "</wx-b>").replaceAll("</div>", "</wx-div>").replaceAll("</p>", "</wx-p>");
                            if (hVar.content.length() > 100) {
                                com.tencent.mm.plugin.wenote.model.nativenote.a.a.Sk(hVar.content);
                            } else {
                                Object obj2;
                                String str = hVar.content;
                                String str2 = "<br/>";
                                int length = str2.length();
                                if (bi.oW(str) || str.length() < length) {
                                    obj2 = null;
                                } else {
                                    int i = 0;
                                    while (i < str.length()) {
                                        int i2 = i + length;
                                        if (i2 > str.length()) {
                                            obj2 = null;
                                        } else if (str2.equalsIgnoreCase(str.substring(i, i2))) {
                                            i = i2;
                                        } else {
                                            obj2 = null;
                                        }
                                    }
                                    i = 1;
                                }
                                if (obj2 != null) {
                                    hVar.content = hVar.content.substring(0, hVar.content.length() - 5);
                                }
                            }
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(hVar);
                            break;
                        case 2:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a((com.tencent.mm.plugin.wenote.model.a.e) nVar);
                            break;
                        case 3:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a((com.tencent.mm.plugin.wenote.model.a.f) nVar);
                            break;
                        case 4:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a((com.tencent.mm.plugin.wenote.model.a.k) nVar);
                            break;
                        case 5:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a((com.tencent.mm.plugin.wenote.model.a.c) nVar);
                            break;
                        case 6:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a((com.tencent.mm.plugin.wenote.model.a.j) nVar);
                            break;
                        default:
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a((i) nVar);
                            break;
                    }
                }
                x.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData finish");
                if (!z) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c bZD = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD();
                    synchronized (bZD) {
                        bZD.qpW = true;
                    }
                }
                ah.A(new Runnable() {
                    public final void run() {
                        synchronized (NoteEditorUI.this.qtV) {
                            NoteEditorUI.this.caR();
                            NoteEditorUI.this.qtL = true;
                            x.i("MicroMsg.Note.NoteEditorUI", "postToMainThread,isInitDataList = true,canDismissLoadingDialog :%B,mHasFreshedDataByHtml:%B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(NoteEditorUI.this.qtU)});
                            if (NoteEditorUI.this.iBL != null && z) {
                                NoteEditorUI.this.iBL.dismiss();
                            }
                        }
                    }
                });
                if (this.qtZ > 0 || this.qub != 0) {
                    this.dvh.postDelayed(new Runnable() {
                        public final void run() {
                            if (NoteEditorUI.this.qtP != null) {
                                NoteEditorUI.this.qtP.Q(NoteEditorUI.this.qtZ, NoteEditorUI.this.qub);
                                NoteEditorUI.this.jDz = NoteEditorUI.this.qtZ;
                                NoteEditorUI.this.qtY = NoteEditorUI.this.qub;
                            }
                        }
                    }, 100);
                }
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZJ();
            }
        }
    }

    public final RecyclerView caS() {
        return this.Sa;
    }

    public final Context caT() {
        return this.mController.tml;
    }

    public final a caU() {
        return this;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.qup = i;
        if (i2 != -1) {
            this.quo = false;
            return;
        }
        int i3;
        this.quo = true;
        String stringExtra;
        String str;
        ActionBarActivity actionBarActivity;
        String stringExtra2;
        p a;
        fz fzVar;
        switch (i) {
            case 4096:
                stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                String stringExtra3 = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!bi.oW(stringExtra)) {
                    au.HU();
                    bd dW = com.tencent.mm.model.c.FT().dW(this.bJC);
                    if (dW.field_msgId == this.bJC) {
                        au.Em().H(new 6(this, dW, stringExtra, stringExtra3, com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.favorite_forward_tips), false, null)));
                        i3 = 2;
                        break;
                    }
                    x.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
                    return;
                }
                x.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                return;
            case 4097:
                x.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
                if (intent.getParcelableExtra("key_req_result") == null) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    x.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
                } else {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14547, new Object[]{Integer.valueOf(i3)});
                    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().eq(0, stringArrayListExtra.size())) {
                        bZn();
                        i3 = 0;
                        break;
                    }
                    ActionBarActivity actionBarActivity2 = this.mController.tml;
                    getString(R.l.app_tip);
                    this.eHw = com.tencent.mm.ui.base.h.a(actionBarActivity2, getString(R.l.app_waiting), true, new 8(this));
                    au.Em().H(new 9(this, stringArrayListExtra));
                }
                stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                String stringExtra4 = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                if (!bi.oW(stringExtra4) && stringArrayListExtra == null) {
                    stringArrayListExtra = new ArrayList();
                    stringArrayListExtra.add(stringExtra4);
                }
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14547, new Object[]{Integer.valueOf(i3)});
                    if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().eq(0, stringArrayListExtra.size())) {
                        str = (String) stringArrayListExtra.get(0);
                        com.tencent.mm.plugin.sight.base.a Lo = com.tencent.mm.plugin.sight.base.d.Lo(str);
                        if (Lo != null) {
                            int bvB = Lo.bvB();
                            com.tencent.mm.plugin.wenote.model.a.j jVar = new com.tencent.mm.plugin.wenote.model.a.j();
                            jVar.qpd = true;
                            jVar.bOX = "";
                            jVar.bVd = "";
                            jVar.duration = bvB;
                            jVar.type = 6;
                            jVar.qpc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZJ();
                            jVar.qoT = com.tencent.mm.a.e.cp(str);
                            jVar.jdM = com.tencent.mm.plugin.wenote.model.f.Sf(jVar.toString());
                            this.qtT = new vx();
                            this.qtT.UO(jVar.jdM);
                            this.qtT.UL(jVar.qoT);
                            stringExtra4 = com.tencent.mm.plugin.wenote.model.f.c(this.qtT);
                            stringExtra = com.tencent.mm.plugin.wenote.model.f.o(this.qtT);
                            if (!bi.oW(str)) {
                                x.v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", new Object[]{str});
                                List arrayList = new ArrayList();
                                arrayList.add(str);
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.d dVar = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d(arrayList, stringExtra4, stringExtra, jVar, new 14(this));
                                actionBarActivity = this.mController.tml;
                                getString(R.l.app_tip);
                                this.eHw = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(R.l.app_waiting), true, new 15(this, dVar, jVar));
                                com.tencent.mm.sdk.f.e.post(dVar, "NoteEditor_importVideo");
                                i3 = 0;
                                break;
                            }
                            x.e("MicroMsg.Note.NoteEditorUI", "video is null");
                            i3 = 0;
                            break;
                        }
                        x.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", new Object[]{bi.oV(str)});
                        i3 = 0;
                        break;
                    }
                    bZn();
                    i3 = 0;
                    break;
                }
                x.i("MicroMsg.Note.NoteEditorUI", "no video selected");
                i3 = 0;
                break;
                break;
            case 4098:
                com.tencent.mm.plugin.report.service.h.mEJ.h(14547, new Object[]{Integer.valueOf(4)});
                if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().eq(0, 1)) {
                    com.tencent.mm.plugin.wenote.model.a.f fVar = new com.tencent.mm.plugin.wenote.model.a.f();
                    fVar.lat = (double) ((float) intent.getDoubleExtra("kwebmap_slat", 0.0d));
                    fVar.lng = (double) ((float) intent.getDoubleExtra("kwebmap_lng", 0.0d));
                    fVar.qpq = (double) intent.getIntExtra("kwebmap_scale", 0);
                    fVar.dRH = bi.aG(intent.getStringExtra("Kwebmap_locaion"), "");
                    fVar.kFa = intent.getStringExtra("kPoiName");
                    fVar.qpc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZJ();
                    fVar.type = 3;
                    fVar.qpd = true;
                    fVar.bVd = "";
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(fVar, this.qtF.cam(), false, false, false);
                    i3 = 0;
                    break;
                }
                bZn();
                i3 = 0;
                break;
            case 4099:
                com.tencent.mm.plugin.report.service.h.mEJ.h(14547, new Object[]{Integer.valueOf(5)});
                str = intent.getStringExtra("choosed_file_path");
                if (!bi.oW(str)) {
                    File file = new File(str);
                    if (file.exists()) {
                        if (file.length() < jaZ) {
                            if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().eq(0, 1)) {
                                if (this.eHw != null) {
                                    this.eHw.dismiss();
                                    this.eHw = null;
                                }
                                actionBarActivity = this.mController.tml;
                                getString(R.l.app_tip);
                                this.eHw = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(R.l.app_waiting), true, new 10(this));
                                com.tencent.mm.plugin.wenote.model.a.c cVar = new com.tencent.mm.plugin.wenote.model.a.c();
                                cVar.title = file.getName();
                                cVar.content = com.tencent.mm.plugin.wenote.model.f.aj((float) com.tencent.mm.a.e.cm(str));
                                cVar.fTs = com.tencent.mm.plugin.wenote.model.h.Sj(com.tencent.mm.a.e.cp(str));
                                cVar.qpc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZJ();
                                cVar.type = 5;
                                cVar.qpd = true;
                                cVar.qoT = com.tencent.mm.a.e.cp(str);
                                cVar.jdM = com.tencent.mm.plugin.wenote.model.f.Sf(cVar.toString());
                                this.qtT = new vx();
                                this.qtT.UO(cVar.jdM);
                                this.qtT.UL(cVar.qoT);
                                cVar.bVd = com.tencent.mm.plugin.wenote.model.f.o(this.qtT);
                                FileOp.y(str, cVar.bVd);
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(cVar, this.qtF.cam(), false, true, false);
                                i3 = 2;
                                break;
                            }
                            bZn();
                            i3 = 2;
                            break;
                        }
                        i3 = 3;
                        break;
                    }
                    i3 = 1;
                    break;
                }
                i3 = 1;
                break;
            case 4101:
                stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                str = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!bi.oW(stringExtra2)) {
                    a = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.favorite_forward_tips), false, null);
                    fzVar = new fz();
                    fzVar.bOL.type = 13;
                    fzVar.bOL.context = this.mController.tml;
                    fzVar.bOL.toUser = stringExtra2;
                    fzVar.bOL.bOR = str;
                    fzVar.bOL.bJA = this.dTK;
                    fzVar.bOL.bOQ = new 7(this, a);
                    com.tencent.mm.sdk.b.a.sFg.m(fzVar);
                    i3 = 2;
                    break;
                }
                x.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                return;
            case 4354:
                this.dvh.post(new 11(this));
                i3 = 2;
                break;
            case 4355:
                stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                str = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!bi.oW(stringExtra2)) {
                    a = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.favorite_forward_tips), false, null);
                    fzVar = new fz();
                    fzVar.bOL.type = 13;
                    fzVar.bOL.context = this.mController.tml;
                    fzVar.bOL.toUser = stringExtra2;
                    fzVar.bOL.bOR = str;
                    fzVar.bOL.bJA = this.dTK;
                    fzVar.bOL.bJH = com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnO;
                    fzVar.bOL.bOQ = new 13(this, a);
                    com.tencent.mm.sdk.b.a.sFg.m(fzVar);
                    break;
                }
                x.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                return;
        }
        i3 = 2;
        if (i3 == 0) {
            return;
        }
        if (1 == i3) {
            com.tencent.mm.ui.base.h.bA(this.mController.tml, getString(R.l.favorite_fail));
        } else if (3 == i3) {
            Toast.makeText(this.mController.tml, getString(R.l.favorite_too_large), 1).show();
        }
    }

    public final void bj(String str, boolean z) {
        x.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlstr:%s,isInsert:%B", new Object[]{str, Boolean.valueOf(z)});
        fz fzVar;
        if (z || !str.equals(this.qtO)) {
            wl Sm = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().Sm(str);
            if (Sm == null) {
                x.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
                return;
            }
            fz fzVar2;
            if (z) {
                fzVar2 = new fz();
                fzVar2.bOL.type = 19;
                fzVar2.bOL.bJH = Sm;
                fzVar2.bOL.title = str;
                fzVar2.bOL.bJA = this.dTK;
                fzVar2.bOL.desc = "fav_add_new_note";
                com.tencent.mm.sdk.b.a.sFg.m(fzVar2);
            } else {
                fzVar2 = new fz();
                fzVar2.bOL.type = 19;
                fzVar2.bOL.bJH = Sm;
                fzVar2.bOL.title = str;
                fzVar2.bOL.bJA = this.dTK;
                fzVar2.bOL.desc = "";
                if (this.qtN) {
                    fzVar2.bOL.bOS = -2;
                }
                com.tencent.mm.sdk.b.a.sFg.m(fzVar2);
            }
            x.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
            if (z) {
                boolean z2;
                fzVar = new fz();
                fzVar.bOL.type = 30;
                fzVar.bOL.bOS = 6;
                fzVar.bOL.bJA = this.dTK;
                com.tencent.mm.sdk.b.a.sFg.m(fzVar);
                if (fzVar.bOM.ret == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    this.qnN = false;
                    this.qtM = true;
                }
            }
            this.qtO = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZK();
        } else if (!this.quh && this.qtF.qrz > 0 && !bi.oW(this.qtF.qrA) && this.qtF.qrB > 0) {
            fzVar = new fz();
            fzVar.bOL.type = 19;
            fzVar.bOL.bOS = -3;
            fzVar.bOL.bJA = this.dTK;
            Intent intent = new Intent();
            intent.putExtra("fav_note_item_status", this.qtF.qrz);
            intent.putExtra("fav_note_xml", this.qtF.qrA);
            intent.putExtra("fav_note_item_updatetime", this.qtF.qrB);
            fzVar.bOL.bOO = intent;
            com.tencent.mm.sdk.b.a.sFg.m(fzVar);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.qrC == 2) {
            switch (this.qup) {
                case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                    if (this.quq) {
                        e(true, 100);
                        Q(1, 0);
                        break;
                    }
                    break;
                case 4097:
                    if (!this.quo) {
                        e(true, 100);
                        Q(1, 0);
                        break;
                    }
                    break;
                case 4098:
                case 4099:
                    e(true, 100);
                    Q(1, 0);
                    break;
            }
        }
        this.qup = -1;
        this.quo = false;
    }

    protected void onPause() {
        super.onPause();
        if (this.qtI != null) {
            this.qtI.a(this);
        }
        if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cbb().aLq()) {
            com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cbb().stopPlay();
        }
        this.quq = this.qtR;
        e(false, 0);
        com.tencent.mm.plugin.wenote.model.a.p bZY = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.bZX().bZY();
        if (c(bZY)) {
            bZY.qpj = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().Sn(getString(R.l.wenote_keep_top_default_title));
            bZY.qpl = this.jDz;
            bZY.qpm = this.qtY;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.h.bZX().a(bZY);
        }
    }

    public void onDrag() {
        super.onDrag();
        if (this.quk) {
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().cax();
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().cav();
        }
    }

    public void onCancel() {
        super.onCancel();
        if (this.quk) {
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().ky(false);
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().kx(false);
        }
    }

    public final void bZq() {
        com.tencent.mm.ui.base.h.a(this, getString(R.l.note_delete_confirm_msg), "", getString(R.l.note_delete_confirm), getString(R.l.note_delete_cancel), new 17(this), null);
    }

    public final void bZr() {
        Toast.makeText(this.mController.tml, getString(R.l.note_operation_failed), 0).show();
    }

    public final int bZt() {
        if (this.qtR) {
            return j.fx(this);
        }
        return 0;
    }

    public final int bZu() {
        int i = 0;
        if (this.qtH != null && this.qtH.getVisibility() == 0) {
            i = this.qul + 0;
        }
        if (this.qtW == null || this.qtW.getVisibility() != 0) {
            return i;
        }
        return i + this.qul;
    }

    public final boolean bZv() {
        return (this.qtF == null || this.qtF.cai() == null) ? false : true;
    }

    public final RecyclerView bZw() {
        return this.Sa;
    }

    public final void bZs() {
        if (this.qrC == 2 && this.qtF.qrD) {
            int bZF = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZF();
            com.tencent.mm.plugin.wenote.model.a.b Bv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().Bv(bZF);
            if (Bv != null) {
                Bv.qoH = false;
                Bv.qoN = false;
                Bo(bZF);
            }
            this.dvh.post(new 18(this));
            e(false, 0);
            Q(0, 0);
        }
    }

    public final void a(WXRTEditText wXRTEditText, boolean z, int i) {
        if (this.qrC == 2 && this.qtF.qrD) {
            ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a) this.Sa.getLayoutManager()).qvd = z;
            if (this.qtQ) {
                ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a) this.Sa.getLayoutManager()).qvd = false;
            }
            if (z) {
                if (!(this.qnN || this.qtM)) {
                    this.qtO = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZK();
                    this.qtM = true;
                }
                if (wXRTEditText == null || wXRTEditText.getEditTextType() != 1) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().ad(i, false);
                    return;
                } else {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().ad(i, true);
                    return;
                }
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().ac(-1, false);
        }
    }

    public final void bZx() {
        if (!this.qnN && !this.qtM) {
            this.qtO = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZK();
            this.qtM = true;
        }
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        this.qtR = this.mController.tmG == 1;
        if (this.qtR) {
            Q(1, 0);
        }
        if (this.quk) {
            this.dvh.postDelayed(new Runnable() {
                public final void run() {
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().ky(com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().caw());
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().kx(com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().cau());
                }
            }, 200);
        }
    }

    public final void e(boolean z, long j) {
        if (this.qrC == 2 && this.qtF.qrD) {
            this.dvh.postDelayed(new 20(this, z), j);
        }
    }

    public final void Q(int i, long j) {
        if (this.qrC == 2 && this.qtF.qrD) {
            this.dvh.postDelayed(new 21(this, i), j);
        }
    }

    public final void bZl() {
        if (!this.qtI.quS) {
            bZs();
            this.dvh.postDelayed(new 22(this, this.mController.tml), 400);
        }
    }

    public final void a(WXRTEditText wXRTEditText) {
        if (wXRTEditText != null) {
            boolean z;
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.gvR == null || com.tencent.mm.plugin.wenote.model.nativenote.manager.f.gvR.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                ArrayList bZS = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bZS();
                if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().Y(bZS)) {
                    bZn();
                    return;
                }
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(bZS, wXRTEditText, true, true, false, false);
                int recyclerItemPosition = wXRTEditText.getRecyclerItemPosition();
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().er(recyclerItemPosition, (bZS.size() + recyclerItemPosition) + 1);
                bZs();
                if (this.quk) {
                    com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().cat();
                }
            }
        }
    }

    public final void bZW() {
        int eE = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.eE(this.mController.tml);
        if (eE == 2) {
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.eD(this)) {
                bZn();
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZE();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.f.acV();
            h hVar = new h();
            hVar.content = "";
            hVar.qoH = false;
            hVar.qoN = false;
            hVar.qoJ = 0;
            hVar.qoP = true;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(hVar);
            caR();
        } else if (eE == 3) {
            ArrayList bZS = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bZS();
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().Y(bZS)) {
                bZn();
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZE();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(bZS, null, false, false, false, false);
            bZs();
        }
    }

    public final void bZT() {
        h hVar = new h();
        hVar.content = "";
        hVar.qoH = true;
        hVar.qoN = false;
        hVar.qoJ = 0;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZE();
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(hVar);
        caR();
        e(true, 50);
        Q(1, 0);
    }

    public final void bZU() {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(this.mController.tml, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZL());
    }

    public final void bZV() {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(this.mController.tml, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZL());
        bZT();
    }

    public final void ep(int i, int i2) {
        this.qtQ = Math.abs(i2 - i) > 0;
    }

    public final void Br(int i) {
        if (i >= 0 && i < com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().size()) {
            this.dvh.post(new 24(this, i));
        }
    }

    public final void bZm() {
        this.dvh.post(new 25(this));
    }

    public final void bZn() {
        if (this.qnN || this.qtM) {
            bZs();
            if (this.quk) {
                com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap().cat();
            }
            this.dvh.postDelayed(new 26(this), 100);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.Note.NoteEditorUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case s$l.AppCompatTheme_panelMenuListTheme /*80*/:
                if (iArr[0] != 0) {
                    bZo();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void bZo() {
        com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 27(this), new 28(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(int r15, int r16, java.lang.String r17, com.tencent.mm.ab.l r18) {
        /*
        r14 = this;
        monitor-enter(r14);
        r2 = r18.getType();	 Catch:{ all -> 0x0083 }
        r3 = 921; // 0x399 float:1.29E-42 double:4.55E-321;
        if (r2 == r3) goto L_0x000b;
    L_0x0009:
        monitor-exit(r14);
        return;
    L_0x000b:
        r0 = r18;
        r2 = r0 instanceof com.tencent.mm.plugin.wenote.model.b;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x0009;
    L_0x0011:
        r18 = (com.tencent.mm.plugin.wenote.model.b) r18;	 Catch:{ all -> 0x0083 }
        r0 = r18;
        r2 = r0.qnu;	 Catch:{ all -> 0x0083 }
        r3 = 1;
        if (r2 != r3) goto L_0x0009;
    L_0x001a:
        if (r16 != 0) goto L_0x045c;
    L_0x001c:
        r2 = "MicroMsg.Note.NoteEditorUI";
        r3 = "genlong pic , allow";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ all -> 0x0083 }
        r2 = r14.Sa;	 Catch:{ all -> 0x0083 }
        r5 = r2.getAdapter();	 Catch:{ all -> 0x0083 }
        if (r5 == 0) goto L_0x0409;
    L_0x002d:
        r6 = r5.getItemCount();	 Catch:{ all -> 0x0083 }
        if (r6 > 0) goto L_0x0088;
    L_0x0033:
        r14.aHL();	 Catch:{ all -> 0x0083 }
        r2 = r14.mController;	 Catch:{ all -> 0x0083 }
        r2 = r2.tml;	 Catch:{ all -> 0x0083 }
        r3 = r14.mController;	 Catch:{ all -> 0x0083 }
        r3 = r3.tml;	 Catch:{ all -> 0x0083 }
        r4 = com.tencent.mm.R.l.note_pic_save_fail;	 Catch:{ all -> 0x0083 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0083 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x0083 }
        r2.show();	 Catch:{ all -> 0x0083 }
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0083 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r6 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r6 = 4;
        r2 = r14.quf;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x0086;
    L_0x0078:
        r2 = 1;
    L_0x0079:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0083 }
        r5[r6] = r2;	 Catch:{ all -> 0x0083 }
        r3.h(r4, r5);	 Catch:{ all -> 0x0083 }
        goto L_0x0009;
    L_0x0083:
        r2 = move-exception;
        monitor-exit(r14);
        throw r2;
    L_0x0086:
        r2 = 0;
        goto L_0x0079;
    L_0x0088:
        r2 = 0;
        r3 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r8 = r3.maxMemory();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r10 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r8 = r8 / r10;
        r3 = (int) r8;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r3 / 8;
        r7 = new com.tencent.mm.sdk.platformtools.aa;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r7.<init>(r3);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = 0;
        r4 = r3;
    L_0x009e:
        if (r4 >= r6) goto L_0x0266;
    L_0x00a0:
        r3 = r14.Sa;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r8 = r5.getItemViewType(r4);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r8 = r5.d(r3, r8);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r5.a(r8, r4);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r8.SU;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r9 = r14.Sa;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r9 = r9.getWidth();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r10 = 0;
        r11 = 0;
        r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r11);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3.measure(r9, r10);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r8.SU;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r9 = 0;
        r10 = 0;
        r11 = r8.SU;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r11 = r11.getMeasuredWidth();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r12 = r8.SU;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r12 = r12.getMeasuredHeight();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3.layout(r9, r10, r11, r12);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r8.SU;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r3.getWidth();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r9 = r8.SU;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r9 = r9.getHeight();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        if (r3 <= 0) goto L_0x0105;
    L_0x00e5:
        if (r9 <= 0) goto L_0x0105;
    L_0x00e7:
        r10 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Throwable -> 0x0109, Exception -> 0x0142 }
        r9 = android.graphics.Bitmap.createBitmap(r3, r9, r10);	 Catch:{ Throwable -> 0x0109, Exception -> 0x0142 }
        r3 = new android.graphics.Canvas;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3.<init>(r9);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r10 = r8.SU;	 Catch:{ Exception -> 0x01b7, Throwable -> 0x0209 }
        r10.draw(r3);	 Catch:{ Exception -> 0x01b7, Throwable -> 0x0209 }
    L_0x00f7:
        r3 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r7.put(r3, r9);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r8.SU;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r3.getMeasuredHeight();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = r2 + r3;
    L_0x0105:
        r3 = r4 + 1;
        r4 = r3;
        goto L_0x009e;
    L_0x0109:
        r2 = move-exception;
        r2 = 0;
        r3 = r2;
    L_0x010c:
        if (r3 >= r4) goto L_0x0127;
    L_0x010e:
        r2 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = (android.graphics.Bitmap) r2;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        if (r2 == 0) goto L_0x0123;
    L_0x011a:
        r5 = r2.isRecycled();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        if (r5 != 0) goto L_0x0123;
    L_0x0120:
        r2.recycle();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
    L_0x0123:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x010c;
    L_0x0127:
        r14.aHL();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = r14.mController;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = r2.tml;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r14.mController;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r3.tml;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r4 = com.tencent.mm.R.l.note_pic_save_fail;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r3.getString(r4);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2.show();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        goto L_0x0009;
    L_0x0142:
        r2 = move-exception;
        r2 = "MicroMsg.Note.NoteEditorUI";
        r3 = "genlongpic fail,Exception error msg a";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x0083 }
        r14.aHL();	 Catch:{ all -> 0x0083 }
        r2 = r14.mController;	 Catch:{ all -> 0x0083 }
        r2 = r2.tml;	 Catch:{ all -> 0x0083 }
        r3 = r14.mController;	 Catch:{ all -> 0x0083 }
        r3 = r3.tml;	 Catch:{ all -> 0x0083 }
        r4 = com.tencent.mm.R.l.note_pic_save_fail;	 Catch:{ all -> 0x0083 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0083 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x0083 }
        r2.show();	 Catch:{ all -> 0x0083 }
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0083 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r6 = 2;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r6 = 4;
        r2 = r14.quf;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x0403;
    L_0x0191:
        r2 = 1;
    L_0x0192:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0083 }
        r5[r6] = r2;	 Catch:{ all -> 0x0083 }
        r3.h(r4, r5);	 Catch:{ all -> 0x0083 }
    L_0x019b:
        r2 = r14.qtF;	 Catch:{ all -> 0x0083 }
        r0 = r18;
        r3 = r0.qny;	 Catch:{ all -> 0x0083 }
        r2.qrC = r3;	 Catch:{ all -> 0x0083 }
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD();	 Catch:{ all -> 0x0083 }
        r3 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD();	 Catch:{ all -> 0x0083 }
        r3 = r3.size();	 Catch:{ all -> 0x0083 }
        r3 = r3 + -1;
        r4 = 0;
        r2.ab(r3, r4);	 Catch:{ all -> 0x0083 }
        goto L_0x0009;
    L_0x01b7:
        r3 = move-exception;
        r14.aHL();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r14.mController;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r3.tml;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r10 = r14.mController;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r10 = r10.tml;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r11 = com.tencent.mm.R.l.note_pic_save_fail;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r10 = r10.getString(r11);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r11 = 1;
        r3 = android.widget.Toast.makeText(r3, r10, r11);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3.show();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r10 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r11 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r3 = 5;
        r12 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = 0;
        r13 = 0;
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r12[r3] = r13;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = 1;
        r13 = 0;
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r12[r3] = r13;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = 2;
        r13 = 0;
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r12[r3] = r13;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = 3;
        r13 = 1;
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r12[r3] = r13;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r13 = 4;
        r3 = r14.quf;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        if (r3 == 0) goto L_0x0264;
    L_0x01fd:
        r3 = 1;
    L_0x01fe:
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r12[r13] = r3;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r10.h(r11, r12);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        goto L_0x00f7;
    L_0x0209:
        r2 = move-exception;
        r2 = "MicroMsg.Note.NoteEditorUI";
        r3 = "genlongpic fail,Throwable error msg throw";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x0083 }
        r14.aHL();	 Catch:{ all -> 0x0083 }
        r2 = r14.mController;	 Catch:{ all -> 0x0083 }
        r2 = r2.tml;	 Catch:{ all -> 0x0083 }
        r3 = r14.mController;	 Catch:{ all -> 0x0083 }
        r3 = r3.tml;	 Catch:{ all -> 0x0083 }
        r4 = com.tencent.mm.R.l.note_pic_save_fail;	 Catch:{ all -> 0x0083 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0083 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x0083 }
        r2.show();	 Catch:{ all -> 0x0083 }
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0083 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r6 = 2;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r6 = 4;
        r2 = r14.quf;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x0406;
    L_0x0258:
        r2 = 1;
    L_0x0259:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0083 }
        r5[r6] = r2;	 Catch:{ all -> 0x0083 }
        r3.h(r4, r5);	 Catch:{ all -> 0x0083 }
        goto L_0x019b;
    L_0x0264:
        r3 = 0;
        goto L_0x01fe;
    L_0x0266:
        r3 = r14.mController;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r3 = r3.tml;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r4 = 14;
        r3 = com.tencent.mm.bp.a.fromDPToPix(r3, r4);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r4 = r14.Sa;	 Catch:{ Throwable -> 0x02bd, Exception -> 0x0350 }
        r4 = r4.getMeasuredWidth();	 Catch:{ Throwable -> 0x02bd, Exception -> 0x0350 }
        r4 = r4 + 0;
        r5 = r2 + r3;
        r8 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Throwable -> 0x02bd, Exception -> 0x0350 }
        r2 = android.graphics.Bitmap.createBitmap(r4, r5, r8);	 Catch:{ Throwable -> 0x02bd, Exception -> 0x0350 }
        r5 = r2;
    L_0x0281:
        r8 = new android.graphics.Canvas;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r8.<init>(r5);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = -1;
        r8.drawColor(r2);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = r14.mController;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = r2.tml;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r3 = 8;
        r3 = com.tencent.mm.bp.a.fromDPToPix(r2, r3);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = 0;
        r4 = r2;
    L_0x0296:
        if (r4 >= r6) goto L_0x03b9;
    L_0x0298:
        r2 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = (android.graphics.Bitmap) r2;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        if (r2 == 0) goto L_0x02b8;
    L_0x02a4:
        r9 = 0;
        r10 = (float) r3;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r11 = 0;
        r8.drawBitmap(r2, r9, r10, r11);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r9 = r2.getHeight();	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r3 = r3 + r9;
        r9 = r2.isRecycled();	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        if (r9 != 0) goto L_0x02b8;
    L_0x02b5:
        r2.recycle();	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
    L_0x02b8:
        r2 = r3;
        r4 = r4 + 1;
        r3 = r2;
        goto L_0x0296;
    L_0x02bd:
        r4 = move-exception;
        r4 = "MicroMsg.Note.NoteEditorUI";
        r5 = "favorite, note, gen long pic ,rgb 888  error,errormsg ";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r4 = r14.Sa;	 Catch:{ Throwable -> 0x02d8, Exception -> 0x0350 }
        r4 = r4.getMeasuredWidth();	 Catch:{ Throwable -> 0x02d8, Exception -> 0x0350 }
        r4 = r4 + 0;
        r2 = r2 + r3;
        r3 = android.graphics.Bitmap.Config.RGB_565;	 Catch:{ Throwable -> 0x02d8, Exception -> 0x0350 }
        r2 = android.graphics.Bitmap.createBitmap(r4, r2, r3);	 Catch:{ Throwable -> 0x02d8, Exception -> 0x0350 }
        r5 = r2;
        goto L_0x0281;
    L_0x02d8:
        r2 = move-exception;
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = 0;
        r8 = 0;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r5[r2] = r8;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = 1;
        r8 = 0;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r5[r2] = r8;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = 2;
        r8 = 0;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r5[r2] = r8;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = 3;
        r8 = 2;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r5[r2] = r8;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r8 = 4;
        r2 = r14.quf;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        if (r2 == 0) goto L_0x034e;
    L_0x0305:
        r2 = 1;
    L_0x0306:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r5[r8] = r2;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r3.h(r4, r5);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = "MicroMsg.Note.NoteEditorUI";
        r3 = "favorite, note, gen long pic , 565 error,errormsg is er:";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r14.aHL();	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = r14.mController;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = r2.tml;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r3 = r14.mController;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r3 = r3.tml;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r4 = com.tencent.mm.R.l.note_pic_save_fail;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r3 = r3.getString(r4);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2.show();	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = 0;
        r3 = r2;
    L_0x0333:
        if (r3 >= r6) goto L_0x0009;
    L_0x0335:
        r2 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        r2 = (android.graphics.Bitmap) r2;	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        if (r2 == 0) goto L_0x034a;
    L_0x0341:
        r4 = r2.isRecycled();	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
        if (r4 != 0) goto L_0x034a;
    L_0x0347:
        r2.recycle();	 Catch:{ Exception -> 0x0350, Throwable -> 0x0209 }
    L_0x034a:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0333;
    L_0x034e:
        r2 = 0;
        goto L_0x0306;
    L_0x0350:
        r2 = move-exception;
        r3 = "MicroMsg.Note.NoteEditorUI";
        r4 = "genlongpic fail,error msg Exception";
        com.tencent.mm.sdk.platformtools.x.e(r3, r4);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = "MicroMsg.Note.NoteEditorUI";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r14.aHL();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = r14.mController;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = r2.tml;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r14.mController;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r3.tml;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r4 = com.tencent.mm.R.l.note_pic_save_fail;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r3.getString(r4);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2.show();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r5[r2] = r6;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r5[r2] = r6;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r5[r2] = r6;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = 3;
        r6 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r5[r2] = r6;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r6 = 4;
        r2 = r14.quf;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        if (r2 == 0) goto L_0x03b7;
    L_0x03ab:
        r2 = 1;
    L_0x03ac:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r5[r6] = r2;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3.h(r4, r5);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        goto L_0x0009;
    L_0x03b7:
        r2 = 0;
        goto L_0x03ac;
    L_0x03b9:
        r2 = r14.iBL;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        if (r2 == 0) goto L_0x03f6;
    L_0x03bd:
        r2 = r14.iBL;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = r2.isShowing();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        if (r2 == 0) goto L_0x03f6;
    L_0x03c5:
        r14.aHL();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = r14.mController;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = r2.tml;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r14.mController;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r3.tml;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r4 = com.tencent.mm.R.l.cropimage_saved;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r7 = 0;
        r8 = com.tencent.mm.platformtools.r.Vs();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = r3.getString(r4, r6);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2.show();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2 = com.tencent.mm.model.au.Em();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$29;	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r3.<init>(r14, r5);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        r2.H(r3);	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        goto L_0x019b;
    L_0x03f6:
        if (r5 == 0) goto L_0x019b;
    L_0x03f8:
        r2 = r5.isRecycled();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        if (r2 != 0) goto L_0x019b;
    L_0x03fe:
        r5.recycle();	 Catch:{ Exception -> 0x0142, Throwable -> 0x0209 }
        goto L_0x019b;
    L_0x0403:
        r2 = 0;
        goto L_0x0192;
    L_0x0406:
        r2 = 0;
        goto L_0x0259;
    L_0x0409:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0083 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r6 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r6 = 4;
        r2 = r14.quf;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x045a;
    L_0x0435:
        r2 = 1;
    L_0x0436:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0083 }
        r5[r6] = r2;	 Catch:{ all -> 0x0083 }
        r3.h(r4, r5);	 Catch:{ all -> 0x0083 }
        r14.aHL();	 Catch:{ all -> 0x0083 }
        r2 = r14.mController;	 Catch:{ all -> 0x0083 }
        r2 = r2.tml;	 Catch:{ all -> 0x0083 }
        r3 = r14.mController;	 Catch:{ all -> 0x0083 }
        r3 = r3.tml;	 Catch:{ all -> 0x0083 }
        r4 = com.tencent.mm.R.l.note_pic_save_fail;	 Catch:{ all -> 0x0083 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0083 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x0083 }
        r2.show();	 Catch:{ all -> 0x0083 }
        goto L_0x019b;
    L_0x045a:
        r2 = 0;
        goto L_0x0436;
    L_0x045c:
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x0083 }
        r4 = 14811; // 0x39db float:2.0755E-41 double:7.3176E-320;
        r2 = 5;
        r5 = new java.lang.Object[r2];	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r6 = 4;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r5[r2] = r6;	 Catch:{ all -> 0x0083 }
        r6 = 4;
        r2 = r14.quf;	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x04b6;
    L_0x0488:
        r2 = 1;
    L_0x0489:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0083 }
        r5[r6] = r2;	 Catch:{ all -> 0x0083 }
        r3.h(r4, r5);	 Catch:{ all -> 0x0083 }
        r2 = "MicroMsg.Note.NoteEditorUI";
        r3 = "genlong pic , not allow";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x0083 }
        r14.aHL();	 Catch:{ all -> 0x0083 }
        r2 = r14.mController;	 Catch:{ all -> 0x0083 }
        r2 = r2.tml;	 Catch:{ all -> 0x0083 }
        r3 = r14.mController;	 Catch:{ all -> 0x0083 }
        r3 = r3.tml;	 Catch:{ all -> 0x0083 }
        r4 = com.tencent.mm.R.l.note_pic_save_fail;	 Catch:{ all -> 0x0083 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0083 }
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x0083 }
        r2.show();	 Catch:{ all -> 0x0083 }
        goto L_0x019b;
    L_0x04b6:
        r2 = 0;
        goto L_0x0489;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.a(int, int, java.lang.String, com.tencent.mm.ab.l):void");
    }

    private void aHL() {
        if (this.iBL != null) {
            this.iBL.dismiss();
            this.iBL = null;
        }
    }
}
