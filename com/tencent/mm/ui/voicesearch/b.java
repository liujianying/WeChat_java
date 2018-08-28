package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.m;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b extends r<ab> implements e {
    private Context context;
    private LinkedList<biy> dzs = new LinkedList();
    private ProgressDialog eHw = null;
    public com.tencent.mm.ui.applet.b eKg = new com.tencent.mm.ui.applet.b(new 1(this));
    private com.tencent.mm.ui.applet.b.b eKh = null;
    private List<String> gRN = null;
    private int showType = 1;
    public String[] tDY;
    public String uFG;
    private boolean uFH = false;
    private ab uFI = null;
    private boolean uFJ = true;
    public boolean uFK = false;
    private boolean uFL = false;
    public String ugF;

    public b(Context context, int i) {
        super(context, new ab());
        this.context = context;
        this.showType = i;
        this.uFI = new ab();
        this.uFI.setUsername("_find_more_public_contact_");
        this.uFI.Bk();
        this.ugF = "@micromsg.with.all.biz.qq.com";
    }

    public final void dQ(List<String> list) {
        ae(new 5(this, list));
    }

    public final void mz(boolean z) {
        this.uFK = z;
        if (z) {
            this.uFI.Bk();
        }
    }

    public final void detach() {
        if (this.eKg != null) {
            this.eKg.detach();
            this.eKg = null;
        }
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final int getItemViewType(int i) {
        if (this.showType == 2) {
            return 2;
        }
        return Gl(i) ? 1 : 0;
    }

    protected final int aUZ() {
        int i = 0;
        if (!this.uFH) {
            return 0;
        }
        if (!this.uFI.isHidden()) {
            i = this.dzs.size();
        }
        return i + 1;
    }

    public final biy Gk(int i) {
        try {
            x.d("MicroMsg.SearchResultAdapter", "position " + i + " size " + this.dzs.size() + "  " + (i - aFL()));
            return (biy) this.dzs.get((i - aFL()) - 1);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SearchResultAdapter", e, "", new Object[0]);
            return null;
        }
    }

    /* renamed from: oj */
    public final ab getItem(int i) {
        if (qY(i)) {
            return (ab) aVa();
        }
        return (ab) super.getItem(i);
    }

    public final void mA(boolean z) {
        ae(new 6(this, z));
    }

    public final void abn(String str) {
        ae(new 7(this, str));
    }

    public final boolean Gl(int i) {
        if (this.uFH) {
            int aFL = aFL();
            if (i == aFL && i < aFL + aUZ()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isEnabled(int i) {
        if (!Gl(i) || ((this.dzs != null && this.dzs.size() != 0) || this.uFJ)) {
            return true;
        }
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean qY = qY(i);
        boolean Gl = Gl(i);
        a aVar;
        a aVar2;
        String gY;
        if (this.uFH && qY) {
            if (view != null) {
                aVar = (a) view.getTag();
                if (Gl && aVar.uFO == null) {
                    view = null;
                }
            }
            if (view != null) {
                aVar2 = (a) view.getTag();
            } else if (Gl) {
                view = View.inflate(this.context, R.i.contact_find_more_item, null);
                aVar2 = new a();
                aVar2.eMf = (TextView) view.findViewById(R.h.contactitem_nick);
                aVar2.uFO = (ProgressBar) view.findViewById(R.h.search_progress);
                view.setTag(aVar2);
            } else {
                view = View.inflate(this.context, R.i.contact_item, null);
                aVar2 = new a();
                aVar2.kuR = (TextView) view.findViewById(R.h.contactitem_catalog);
                aVar2.hPe = (MaskLayout) view.findViewById(R.h.contactitem_avatar);
                aVar2.eMf = (TextView) view.findViewById(R.h.contactitem_nick);
                aVar2.eCo = (CheckBox) view.findViewById(R.h.contactitem_select_cb);
                aVar2.ume = (TextView) view.findViewById(R.h.contactitem_account);
                view.setTag(aVar2);
            }
            if (Gl) {
                if (this.uFL) {
                    aVar2.uFO.setVisibility(0);
                } else {
                    aVar2.uFO.setVisibility(8);
                }
                x.d("MicroMsg.SearchResultAdapter", "refresh  " + this.uFJ);
                if ((this.dzs == null || this.dzs.size() == 0) && !this.uFJ) {
                    aVar2.eMf.setText(this.context.getString(R.l.address_more_no_public_contact));
                    aVar2.eMf.setTextColor(this.context.getResources().getColor(R.e.lightgrey));
                    return view;
                }
                aVar2.eMf.setText(this.context.getString(R.l.address_more_public_contact));
                aVar2.eMf.setTextColor(a.ac(this.context, R.e.mm_list_textcolor_one));
                return view;
            }
            if (this.eKh == null) {
                this.eKh = new 8(this);
            }
            if (this.eKg != null) {
                this.eKg.a((i - aFL()) - 1, this.eKh);
            }
            biy Gk = Gk(i);
            aVar2.kuR.setVisibility(8);
            if (Gk == null) {
                return view;
            }
            aVar2.ume.setVisibility(8);
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) aVar2.hPe.getContentView(), Gk.rvi.siM);
            if (Gk.rTe == 0) {
                aVar2.hPe.setMaskDrawable(null);
            } else if (am.a.dBt != null) {
                gY = am.a.dBt.gY(Gk.rTe);
                if (gY != null) {
                    aVar2.hPe.f(m.kU(gY), MaskLayout.a.tzk);
                } else {
                    aVar2.hPe.setMaskDrawable(null);
                }
            } else {
                aVar2.hPe.setMaskDrawable(null);
            }
            try {
                aVar2.eMf.setText(j.a(this.context, bi.oV(Gk.rQz.siM), aVar2.eMf.getTextSize()));
                return view;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SearchResultAdapter", e, "", new Object[0]);
                aVar2.eMf.setText("");
                return view;
            }
        } else if (this.showType == 2) {
            if (view == null) {
                view = View.inflate(this.context, R.i.voice_dosearch_item, null);
                aVar2 = new a();
                aVar2.eMf = (TextView) view.findViewById(R.h.contactitem_nick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ab oj = getItem(i);
            aVar.eMf.setTextColor(a.ac(this.context, R.e.mm_list_textcolor_one));
            try {
                aVar.eMf.setText(j.a(this.context, this.context.getString(R.l.voice_search_item_tip, new Object[]{com.tencent.mm.model.r.a(oj, oj.field_username)}), aVar.eMf.getTextSize()));
            } catch (Exception e2) {
                aVar.eMf.setText("");
            }
            aVar.eMf.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            return view;
        } else {
            View view2;
            if (view != null) {
                aVar = (a) view.getTag();
                view2 = aVar == null ? null : view;
            } else {
                aVar = null;
                view2 = view;
            }
            if (view2 == null) {
                view2 = y.gq(this.context).inflate(R.i.contact_item, null);
                aVar2 = new a();
                aVar2.kuR = (TextView) view2.findViewById(R.h.contactitem_catalog);
                aVar2.hPe = (MaskLayout) view2.findViewById(R.h.contactitem_avatar);
                aVar2.eMf = (TextView) view2.findViewById(R.h.contactitem_nick);
                aVar2.eCo = (CheckBox) view2.findViewById(R.h.contactitem_select_cb);
                aVar2.ume = (TextView) view2.findViewById(R.h.contactitem_account);
                view2.setTag(aVar2);
            } else {
                aVar2 = aVar;
            }
            ab oj2 = getItem(i);
            if (aVar2.kuR != null) {
                aVar2.kuR.setVisibility(8);
            }
            aVar2.eMf.setTextColor(a.ac(this.context, !s.hO(oj2.field_username) ? R.e.mm_list_textcolor_one : R.e.mm_list_textcolor_spuser));
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) aVar2.hPe.getContentView(), oj2.field_username);
            aVar2.ume.setVisibility(8);
            if (oj2.field_verifyFlag == 0) {
                aVar2.hPe.setMaskDrawable(null);
            } else if (am.a.dBt != null) {
                gY = am.a.dBt.gY(oj2.field_verifyFlag);
                if (gY != null) {
                    aVar2.hPe.f(m.kU(gY), MaskLayout.a.tzk);
                } else {
                    aVar2.hPe.setMaskDrawable(null);
                }
            } else {
                aVar2.hPe.setMaskDrawable(null);
            }
            try {
                aVar2.eMf.setText(j.a(this.context, com.tencent.mm.model.r.a(oj2, oj2.field_username), aVar2.eMf.getTextSize()));
            } catch (Exception e3) {
                aVar2.eMf.setText("");
            }
            return view2;
        }
    }

    public final void WT() {
        ae(new 9(this));
    }

    protected final void WS() {
        aYc();
        WT();
    }

    public final void onResume() {
        au.DF().a(i$l.AppCompatTheme_ratingBarStyle, this);
    }

    public final void onPause() {
        au.DF().b(i$l.AppCompatTheme_ratingBarStyle, this);
    }

    public final void ed(List<String> list) {
        this.tDY = (String[]) list.toArray(new String[list.size()]);
        this.uFG = null;
        aYc();
        WT();
    }

    public static String abo(String str) {
        String trim = str.trim();
        if (trim.startsWith("@")) {
            trim = trim.substring(1) + "%@micromsg.with.all.biz.qq.com";
        }
        x.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + trim + "]");
        return trim;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (lVar.getType() != i$l.AppCompatTheme_ratingBarStyle) {
            x.e("MicroMsg.SearchResultAdapter", "error type");
            return;
        }
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        this.uFL = false;
        if (w.a.a(this.context, i, i2, str, 7)) {
            this.uFJ = false;
        } else if (i == 4 && i2 == -4) {
            ae(new 11(this));
        } else if (i == 0 && i2 == 0) {
            ae(new 3(this, lVar));
        } else {
            ae(new 2(this));
        }
    }

    public final void ae(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            notifyDataSetChanged();
            return;
        }
        ah.A(new 4(this, runnable));
    }

    public final boolean abp(String str) {
        if (!(this.gRN == null || str == null)) {
            for (String equals : this.gRN) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
