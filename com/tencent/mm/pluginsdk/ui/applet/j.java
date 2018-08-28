package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class j extends BaseAdapter {
    public static int qIV = 44;
    public static int qIW = 5;
    boolean bSD;
    private List<String> bTR = new ArrayList();
    u hLB;
    boolean hNA;
    c hOC = null;
    private Context mContext;
    a qIX;
    private ArrayList<ab> qIY = new ArrayList();
    boolean qIZ = false;
    public boolean qJa = false;
    public boolean qJb = false;
    private List<ab> qJc = new ArrayList();
    private List<Object> qJd = new ArrayList();
    private Set<String> qJe = new HashSet();
    int qJf = 0;
    int qJg = 0;
    d qJh;
    public boolean qJi = false;
    public boolean qJj = false;
    public boolean qJk = false;
    private boolean qJl = true;
    boolean qJm = false;
    int qJn = 12;
    String qJo;
    private final int qJp;
    public boolean qJq = false;
    private boolean qJr = true;
    private boolean qJs = false;
    boolean qJt = true;
    public boolean qJu = false;
    String username;

    public j(Context context) {
        this.mContext = context;
        this.hNA = false;
        this.qJp = context.getResources().getDimensionPixelSize(a.c.BasicPaddingSize);
    }

    public final boolean cdR() {
        if (this.qIZ) {
            return this.qJb;
        }
        return s.fq(this.username);
    }

    public final void co(List<String> list) {
        this.qJl = true;
        this.bTR = list;
    }

    public final void Z(ArrayList<ab> arrayList) {
        this.qJl = false;
        this.qIY = arrayList;
    }

    private void cdS() {
        if (this.qIY != null) {
            x.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[]{Integer.valueOf(this.qIY.size())});
            this.qJe.clear();
            this.qJc.clear();
            if (this.qIY.size() > 0) {
                Iterator it = this.qIY.iterator();
                while (it.hasNext()) {
                    ab abVar = (ab) it.next();
                    this.qJc.add(abVar);
                    this.qJe.add(abVar.field_username);
                }
            }
            this.qJg = this.qJc.size();
        }
    }

    public final boolean Ca(int i) {
        if (this.hNA) {
            return false;
        }
        if (i >= this.qJg) {
            return true;
        }
        this.hNA = true;
        caR();
        return true;
    }

    private void caR() {
        if (this.qIX != null) {
            this.qIX.caR();
        }
    }

    private b di(View view) {
        b bVar = new b(this);
        bVar.qJv = (ImageView) view.findViewById(e.room_info_contact_owner);
        bVar.eCl = (ImageView) view.findViewById(e.roominfo_img);
        bVar.mUo = (ImageView) view.findViewById(e.room_info_contact_del);
        bVar.eTm = (TextView) view.findViewById(e.roominfo_contact_name);
        bVar.hOE = (TextView) view.findViewById(e.roominfo_contact_name_for_span);
        bVar.hkU = (ImageView) view.findViewById(e.room_info_contact_status);
        bVar.eCl.setScaleType(ScaleType.CENTER_CROP);
        view.setTag(bVar);
        return bVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object item;
        ai aiVar;
        int i2;
        b di;
        int dimensionPixelSize;
        if (i < this.qJg) {
            if (this.qIZ) {
                item = getItem(i);
                aiVar = null;
                i2 = 0;
            } else {
                item = null;
                aiVar = (ab) getItem(i);
                i2 = 0;
            }
        } else if (i == this.qJg && this.qJj) {
            item = null;
            aiVar = null;
            i2 = 3;
        } else if (i == this.qJg + 1 && this.qJi) {
            item = null;
            aiVar = null;
            i2 = 4;
        } else if (i == this.qJg + 1 && this.qJk && !this.qJi) {
            item = null;
            aiVar = null;
            i2 = 5;
        } else if (i == this.qJg + 2 && this.qJk && this.qJi) {
            item = null;
            aiVar = null;
            i2 = 5;
        } else {
            item = null;
            aiVar = null;
            i2 = 2;
        }
        if (view == null) {
            view = View.inflate(this.mContext, f.roominfo_contact, null);
            di = di(view);
        } else {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                di = di(view);
            } else {
                di = bVar;
            }
        }
        if (qIW == 4 || this.qJu) {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.c.NormalAvatarWrapSize);
            di.eCl.getLayoutParams().height = dimensionPixelSize;
            di.eCl.getLayoutParams().width = dimensionPixelSize;
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.c.NormalAvatarSize);
            di.eCl.getLayoutParams().height = dimensionPixelSize;
            di.eCl.getLayoutParams().width = dimensionPixelSize;
        }
        di.qJv.setVisibility(8);
        TextView textView;
        if (i2 == 0) {
            CharSequence gT;
            di.eCl.setVisibility(0);
            if (this.bSD) {
                if (bi.oW(aiVar.field_conRemark)) {
                    String str = aiVar.field_username;
                    if (this.hLB == null) {
                        Object gT2 = null;
                    } else {
                        gT2 = this.hLB.gT(str);
                    }
                } else {
                    gT2 = aiVar.field_conRemark;
                }
                if (bi.oW(gT2)) {
                    gT2 = aiVar.field_conRemark;
                }
                if (bi.oW(gT2)) {
                    gT2 = aiVar.BK();
                }
                gT2 = com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, gT2, di.eTm.getTextSize());
            } else if (this.qIZ) {
                gT2 = com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, p.a.qJH.bW(item), di.eTm.getTextSize());
            } else if (ab.XR(aiVar.field_username)) {
                b bVar2 = (b) g.l(b.class);
                Context context = ad.getContext();
                String BL = aiVar.BL();
                String str2 = aiVar.field_openImAppid;
                gT2 = bVar2.d(context, BL, (int) di.eTm.getTextSize());
            } else {
                gT2 = com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, aiVar.BL(), di.eTm.getTextSize());
            }
            if (gT2 instanceof SpannableString) {
                di.eTm.setVisibility(8);
                di.hOE.setVisibility(0);
                di.hOE.setText(gT2);
            } else {
                di.eTm.setVisibility(0);
                di.hOE.setVisibility(8);
                di.eTm.setText(gT2);
            }
            di.eCl.setContentDescription("");
            if (this.qIZ) {
                o.Pj().a(p.a.qJH.bX(item), di.eCl, this.hOC);
                di.eCl.setBackgroundDrawable(null);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(di.eCl, aiVar.field_username);
                com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) di.eCl.getDrawable();
                if (this.qJh != null) {
                    this.qJh.a(aVar);
                }
            }
            if (this.qIZ) {
                if (!this.hNA || (this.qJo != null && this.qJo.equals(p.a.qJH.bY(item)))) {
                    di.mUo.setVisibility(8);
                } else {
                    di.mUo.setVisibility(0);
                }
            } else if (!this.hNA || (this.qJo != null && this.qJo.equals(aiVar.field_username))) {
                di.mUo.setVisibility(8);
            } else {
                di.mUo.setVisibility(0);
            }
        } else if (i2 == 3) {
            di.eTm.setVisibility(i == 0 ? 8 : 4);
            textView = di.hOE;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            di.mUo.setVisibility(8);
            if (this.hNA) {
                di.eCl.setVisibility(4);
            } else {
                di.eCl.setVisibility(0);
                if (this.qIZ) {
                    o.Pj().a("", di.eCl, this.hOC);
                    di.eCl.setBackgroundDrawable(null);
                }
                di.eCl.setImageResource(a.d.big_add_selector);
                di.eCl.setContentDescription(this.mContext.getString(h.add_selector_btn));
            }
        } else if (i2 == 4) {
            di.eTm.setVisibility(1 == i ? 8 : 4);
            textView = di.hOE;
            if (1 == i) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            di.mUo.setVisibility(8);
            if (this.hNA || this.qJg == 0) {
                di.eCl.setVisibility(4);
            } else {
                di.eCl.setVisibility(0);
                if (this.qIZ) {
                    o.Pj().a("", di.eCl, this.hOC);
                    di.eCl.setBackgroundDrawable(null);
                }
                di.eCl.setImageResource(a.d.big_del_selector);
                di.eCl.setContentDescription(this.mContext.getString(h.del_selector_btn));
            }
        } else if (i2 == 5) {
            textView = di.eTm;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            textView = di.hOE;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            di.mUo.setVisibility(8);
            if (this.hNA) {
                di.eCl.setVisibility(4);
            } else {
                di.eCl.setVisibility(0);
                if (this.qIZ) {
                    o.Pj().a("", di.eCl, this.hOC);
                    di.eCl.setBackgroundDrawable(null);
                }
                di.eCl.setImageResource(a.d.big_more_selector);
                di.eCl.setContentDescription(this.mContext.getString(h.more_selector_btn));
            }
        } else if (i2 == 2) {
            if (this.qIZ) {
                o.Pj().a("", di.eCl, this.hOC);
            }
            di.eTm.setVisibility(4);
            di.hOE.setVisibility(4);
            di.mUo.setVisibility(8);
            di.eCl.setVisibility(4);
            di.eCl.setImageResource(a.d.mm_trans);
            di.eCl.setBackgroundResource(a.d.mm_trans);
        }
        if (!this.qIZ || item == null) {
            di.hkU.setVisibility(8);
        }
        di.hER = i2;
        return view;
    }

    public final boolean Cb(int i) {
        return i < this.qJg;
    }

    public final void notifyChanged() {
        if (this.bTR != null || this.qIY != null) {
            if (!this.qJl) {
                cdS();
            } else if (this.bTR != null) {
                x.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[]{Integer.valueOf(this.bTR.size())});
                this.qJe.clear();
                this.qJc.clear();
                this.qJd.clear();
                if (this.bTR.size() > 0) {
                    String str;
                    ab Yg;
                    for (String str2 : this.bTR) {
                        if (this.qIZ) {
                            this.qJd.add(p.a.qJH.TF(str2));
                        } else {
                            ab Yg2 = ((i) g.l(i.class)).FR().Yg(str2);
                            if (Yg2 == null || bi.oW(Yg2.field_username) || !Yg2.field_username.equals(str2)) {
                                this.qJc.add(new ab(this.username));
                            } else {
                                this.qJc.add(Yg2);
                            }
                        }
                        this.qJe.add(str2);
                    }
                    if (this.qJr && !bi.oW(this.qJo) && this.bTR.contains(this.qJo)) {
                        if (!this.qIZ) {
                            for (ab Yg3 : this.qJc) {
                                if (this.qJo.equals(Yg3.field_username)) {
                                    this.qJc.remove(Yg3);
                                    this.qJc.add(0, Yg3);
                                    break;
                                }
                            }
                        }
                        for (Object next : this.qJd) {
                            if (this.qJo.equals(p.a.qJH.bY(next))) {
                                this.qJd.remove(next);
                                this.qJd.add(0, next);
                                break;
                            }
                        }
                    }
                    if (this.qJs && !this.qIZ) {
                        String aG = bi.aG((String) g.Ei().DT().get(2, null), "");
                        if (this.bTR.contains(aG)) {
                            this.qJe.remove(aG);
                            for (ab Yg32 : this.qJc) {
                                if (aG.equals(Yg32.field_username)) {
                                    this.qJc.remove(Yg32);
                                    break;
                                }
                            }
                        }
                        Yg32 = ((i) g.l(i.class)).FR().Yg(aG);
                        if (Yg32 == null || bi.oW(Yg32.field_username) || !Yg32.field_username.equals(aG)) {
                            this.qJc.add(1, new ab(aG));
                        } else {
                            this.qJc.add(1, Yg32);
                        }
                        this.qJe.add(aG);
                        if (this.qJt && this.qJc.size() >= 3) {
                            int size = this.qJc.size();
                            LinkedList linkedList = new LinkedList();
                            for (int i = 0; i < size; i++) {
                                Yg32 = (ab) this.qJc.get(i);
                                if (Yg32.field_showHead > 0) {
                                    linkedList.add(Yg32.field_showHead);
                                } else if (!bi.oW(Yg32.field_conRemark)) {
                                    linkedList.add(Yg32.field_conRemark);
                                } else if (!bi.oW(Yg32.field_conRemarkPYShort)) {
                                    linkedList.add(Yg32.field_conRemarkPYShort);
                                } else if (!bi.oW(Yg32.field_conRemarkPYFull)) {
                                    linkedList.add(Yg32.field_conRemarkPYFull);
                                } else if (!bi.oW(Yg32.wP())) {
                                    linkedList.add(Yg32.wP());
                                } else if (!bi.oW(Yg32.field_username)) {
                                    linkedList.add(Yg32.field_username);
                                }
                            }
                            x.v("MicroMsg.ContactsListArchAdapter", "klem, order list:%s", new Object[]{linkedList.toString()});
                            List arrayList = new ArrayList();
                            arrayList.add(this.qJc.get(0));
                            arrayList.add(this.qJc.get(1));
                            List linkedList2 = new LinkedList();
                            linkedList2.add(linkedList.get(0));
                            linkedList2.add(linkedList.get(0));
                            int size2 = this.qJc.size();
                            for (int i2 = 2; i2 < size2; i2++) {
                                str2 = (String) linkedList.get(i2);
                                int size3 = arrayList.size();
                                int i3 = 1;
                                while (i3 < size3 && str2.compareToIgnoreCase((String) linkedList2.get(i3)) >= 0) {
                                    i3++;
                                }
                                linkedList2.add(i3, str2);
                                arrayList.add(i3, this.qJc.get(i2));
                            }
                            this.qJc.clear();
                            this.qJc = arrayList;
                        }
                    }
                }
                if (this.qIZ) {
                    this.qJg = this.qJd.size();
                } else if (!this.bSD) {
                    this.qJg = this.qJc.size();
                } else if (bi.oW(this.qJo) || !(this.qJo == null || this.qJo.equals(q.GF()))) {
                    this.qJg = this.qJc.size() >= qIV ? qIV : this.qJc.size();
                } else {
                    this.qJg = this.qJc.size() >= qIV + -1 ? qIV - 1 : this.qJc.size();
                }
            }
            if (this.qJg == 0) {
                this.qJf = qIW;
            } else if (this.qJj && this.qJi && this.qJk) {
                this.qJf = (((this.qJg + 2) / qIW) + 1) * qIW;
            } else if ((this.qJj && this.qJi && !this.qJk) || ((this.qJj && !this.qJi && this.qJk) || (!this.qJj && this.qJi && this.qJk))) {
                this.qJf = (((this.qJg + 1) / qIW) + 1) * qIW;
            } else if ((this.qJj && !this.qJi && !this.qJk) || ((!this.qJj && this.qJi && !this.qJk) || (!this.qJj && !this.qJi && this.qJk))) {
                this.qJf = ((this.qJg / qIW) + 1) * qIW;
            } else if (!(this.qJj || this.qJi || this.qJk)) {
                this.qJf = (((this.qJg - 1) / qIW) + 1) * qIW;
            }
            x.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.qJg + " realySize : " + this.qJf);
            caR();
        }
    }

    public final int getCount() {
        if (this.qJm) {
            return Math.min(this.qJn, this.qJf);
        }
        return this.qJf;
    }

    public final Object getItem(int i) {
        if (i >= this.qJg) {
            return null;
        }
        if (this.qIZ) {
            return this.qJd.get(i);
        }
        return this.qJc.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
