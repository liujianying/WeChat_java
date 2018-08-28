package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.d.m;
import com.tencent.mm.plugin.ipcall.a.e;
import com.tencent.mm.plugin.ipcall.a.e.d;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.cce;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g extends Dialog {
    private ScrollView fPS;
    View hyK;
    private int jbU = R.e.feedback_white_tag_color;
    private int jbV = R.g.feedback_white_tab_selector;
    private int kvK = 0;
    private int kvL;
    private long kvM;
    private LinearLayout kvN;
    private LinearLayout kvO;
    private RelativeLayout kvP;
    private RelativeLayout kvQ;
    private RelativeLayout kvR;
    private ImageView kvS;
    private ImageView kvT;
    private ImageView kvU;
    private int kvV;
    private FrameLayout kvW;
    private FlowLayout kvX;
    private Button kvY;
    private Button kvZ;
    private PasterEditText kwa;
    private Button kwb;
    private Button kwc;
    private TextView kwd;
    private Animation kwe;
    private int kwf = R.g.feedback_green_tab_selector;
    private int kwg = R.e.white_text_color;
    private Activity mActivity;
    private Context mContext;
    private ag mHandler = new ag();
    private ArrayList<a> mItemList;
    private OnClickListener mOnClickListener = new 3(this);
    private CharSequence sn;

    static /* synthetic */ void g(g gVar) {
        au.DF().a(new m(gVar.kvL, gVar.kvV, gVar.rE(gVar.kvV)), 0);
        if (gVar.kvV == 3) {
            gVar.rF(2);
            return;
        }
        gVar.hide();
        gVar.mHandler.postDelayed(new 9(gVar), 1800);
        b.h(gVar.mActivity, gVar.mContext.getString(R.l.ipcall_feedback_commit_finish));
        d.a(1, -1, gVar.kvV, gVar.rD(gVar.kvV), 0, -1, -1, gVar.kvL, gVar.kvM);
    }

    public g(Activity activity, Context context, int i, long j) {
        CharSequence format;
        super(context, R.m.mmalertdialog);
        setCancelable(false);
        this.mContext = context;
        this.kvL = i;
        this.kvM = j;
        this.mActivity = activity;
        this.hyK = View.inflate(this.mContext, R.i.ipcall_feedback_dialog_ui, null);
        this.kvN = (LinearLayout) this.hyK.findViewById(R.h.layoutFeedback);
        this.kvO = (LinearLayout) this.hyK.findViewById(R.h.layoutInvite);
        this.kwe = AnimationUtils.loadAnimation(ad.getContext(), R.a.alpha_in);
        this.kwe.setDuration(200);
        this.kwe.setStartOffset(100);
        aYj();
        this.kvP = (RelativeLayout) this.hyK.findViewById(R.h.layoutStar_1);
        this.kvQ = (RelativeLayout) this.hyK.findViewById(R.h.layoutStar_2);
        this.kvR = (RelativeLayout) this.hyK.findViewById(R.h.layoutStar_3);
        this.kvP.setOnClickListener(this.mOnClickListener);
        this.kvQ.setOnClickListener(this.mOnClickListener);
        this.kvR.setOnClickListener(this.mOnClickListener);
        this.kvS = (ImageView) this.hyK.findViewById(R.h.imgStar_1);
        this.kvT = (ImageView) this.hyK.findViewById(R.h.imgStar_2);
        this.kvU = (ImageView) this.hyK.findViewById(R.h.imgStar_3);
        this.kvV = 0;
        rC(this.kvV);
        this.kwb = (Button) this.hyK.findViewById(R.h.invite_dialog_btn_cancel);
        this.kwc = (Button) this.hyK.findViewById(R.h.invite_dialog_btn_invite);
        this.kwd = (TextView) this.hyK.findViewById(R.h.invite_dialog_msg_content_tv);
        if (c.aYD() != null) {
            format = String.format(this.mContext.getString(R.l.ipcall_share_coupon_card_content_desc), new Object[]{r0.rMO});
        } else {
            format = null;
        }
        if (bi.oW(format)) {
            this.kwd.setVisibility(4);
        } else {
            this.kwd.setVisibility(0);
            this.kwd.setText(format);
        }
        this.kwb.setOnClickListener(new 7(this));
        this.kwc.setOnClickListener(new 8(this));
        this.fPS = (ScrollView) this.hyK.findViewById(R.h.feedback_dialog_scrollview);
        View childAt = ((ViewGroup) this.mActivity.findViewById(16908290)).getChildAt(0);
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new 1(this, childAt));
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.hyK);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        rF(0);
    }

    private void rC(int i) {
        this.kvV = i;
        if (i == 0) {
            this.kvS.setVisibility(4);
            this.kvT.setVisibility(4);
            this.kvU.setVisibility(4);
            this.kvZ.setEnabled(false);
            rF(0);
        } else if (i == 1) {
            this.kvS.setVisibility(0);
            this.kvT.setVisibility(4);
            this.kvU.setVisibility(4);
            this.kvZ.setEnabled(true);
            rF(1);
        } else if (i == 2) {
            this.kvS.setVisibility(0);
            this.kvT.setVisibility(0);
            this.kvU.setVisibility(4);
            this.kvZ.setEnabled(true);
            rF(1);
        } else if (i == 3) {
            this.kvS.setVisibility(0);
            this.kvT.setVisibility(0);
            this.kvU.setVisibility(0);
            this.kvZ.setEnabled(true);
            rF(0);
        }
    }

    private void aYj() {
        String ew;
        f fVar;
        this.kvW = (FrameLayout) this.hyK.findViewById(R.h.flowLayoutParent);
        this.kvX = (FlowLayout) this.hyK.findViewById(R.h.flowLayout);
        this.kvY = (Button) this.hyK.findViewById(R.h.confirm_dialog_btn_cancel);
        this.kvZ = (Button) this.hyK.findViewById(R.h.confirm_dialog_btn_commit);
        this.kwa = (PasterEditText) this.hyK.findViewById(R.h.confirm_dialog_text_et);
        this.kvY.setOnClickListener(new 4(this));
        this.kvZ.setOnClickListener(new 5(this));
        e aXi = e.aXi();
        if (aXi.kop == null) {
            x.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
            b$c.qCd;
            ew = com.tencent.mm.pluginsdk.g.a.a.b.ew(39, 1);
            if (bi.oW(ew)) {
                x.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
            } else {
                byte[] f = com.tencent.mm.a.e.f(ew, 0, -1);
                if (f != null) {
                    aXi.az(f);
                } else {
                    x.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
                }
            }
        }
        if (aXi.kop != null) {
            String str;
            ew = w.e(ad.getContext().getSharedPreferences(ad.chY(), 0));
            if (!"language_default".equalsIgnoreCase(ew) || Locale.getDefault() == null) {
                str = ew;
            } else {
                str = Locale.getDefault().toString();
            }
            Iterator it = aXi.kop.iterator();
            while (it.hasNext()) {
                fVar = (f) it.next();
                if (str.equalsIgnoreCase(fVar.ksC)) {
                    x.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[]{str, Integer.valueOf(aXi.kop.size())});
                    break;
                }
            }
            x.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[]{str, Integer.valueOf(aXi.kop.size())});
        }
        fVar = null;
        if (fVar != null) {
            ArrayList arrayList = fVar.ksD;
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.tencent.mm.plugin.ipcall.a.g.e eVar = (com.tencent.mm.plugin.ipcall.a.g.e) it2.next();
                a aVar = new a();
                aVar.ksA = eVar.ksA;
                aVar.ksB = eVar.ksB;
                aVar.kwj = false;
                arrayList2.add(aVar);
            }
            this.mItemList = arrayList2;
            Iterator it3 = this.mItemList.iterator();
            while (it3.hasNext()) {
                a aVar2 = (a) it3.next();
                FlowLayout flowLayout = this.kvX;
                View textView = new TextView(getContext());
                textView.setTextSize(0, getContext().getResources().getDimension(R.f.feedback_tag_font_size) * a.fe(getContext()));
                textView.setBackgroundResource(this.jbV);
                textView.setTextColor(this.mContext.getResources().getColor(this.jbU));
                textView.setTag(aVar2);
                textView.setGravity(17);
                textView.setEllipsize(TruncateAt.END);
                textView.setSingleLine();
                textView.setText(aVar2.ksB);
                textView.setOnClickListener(new 6(this));
                flowLayout.addView(textView);
            }
        }
    }

    private String rD(int i) {
        String str = "";
        if (i == 3) {
            return "";
        }
        if (!bi.oW(this.kwa.getText().toString().trim())) {
            str = "0";
        }
        if (this.mItemList == null) {
            return str;
        }
        Iterator it = this.mItemList.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            a aVar = (a) it.next();
            if (!aVar.kwj) {
                str = str2;
            } else if (str2.equals("")) {
                str = aVar.ksA;
            } else {
                str = str2 + "_" + aVar.ksA;
            }
        }
    }

    private LinkedList<cce> rE(int i) {
        LinkedList<cce> linkedList = new LinkedList();
        if (i == 3) {
            return linkedList;
        }
        String trim = this.kwa.getText().toString().trim();
        if (!bi.oW(trim)) {
            cce cce = new cce();
            cce.bzI = 0;
            cce.jSA = trim;
            linkedList.add(cce);
        }
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.kwj) {
                    cce cce2 = new cce();
                    try {
                        cce2.bzI = bi.getInt(aVar.ksA, 0);
                        linkedList.add(cce2);
                    } catch (NumberFormatException e) {
                        x.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + aVar.ksA);
                    }
                }
            }
        }
        return linkedList;
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.sn = charSequence;
        } else {
            this.sn = null;
        }
    }

    public final void show() {
        super.show();
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    private void rF(int i) {
        if (i == 0) {
            this.kvN.setVisibility(0);
            this.kvO.setVisibility(4);
            if (this.kvK == 1) {
                ((LayoutParams) this.kvW.getLayoutParams()).height = 0;
                this.kvW.requestLayout();
            }
            bi.hideVKB(this.hyK);
        } else if (i == 1) {
            this.kvN.setVisibility(0);
            this.kvO.setVisibility(4);
            if (this.kvK == 0) {
                ((LayoutParams) this.kvW.getLayoutParams()).height = -2;
                this.kvW.requestLayout();
                this.kvW.startAnimation(this.kwe);
            }
        } else if (i == 2) {
            this.kvN.setVisibility(4);
            this.kvO.setVisibility(0);
            bi.hideVKB(this.hyK);
        }
        this.kvK = i;
    }
}
