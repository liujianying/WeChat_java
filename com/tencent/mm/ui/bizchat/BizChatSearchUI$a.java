package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.protocal.c.hw;
import com.tencent.mm.protocal.c.hz;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bizchat.BizChatSearchUI.d;
import com.tencent.mm.ui.bizchat.BizChatSearchUI.g;
import java.util.ArrayList;
import java.util.List;

class BizChatSearchUI$a extends BaseAdapter implements e {
    public static int tEP = 3;
    private int Ma = 0;
    private Context context;
    String dBm;
    private c dXk;
    String hpJ;
    private int scene;
    private int tEQ;
    boolean tER;
    boolean tES;
    private ArrayList<com.tencent.mm.ac.a.c> tET = new ArrayList();
    private ArrayList<Object> tEU = new ArrayList();
    private ArrayList<com.tencent.mm.ac.a.c> tEV = new ArrayList();
    private g tEW;
    private ArrayList<g> tEX = new ArrayList();
    private g tEY;
    private g tEZ;
    private ArrayList<g> tFa = new ArrayList();
    private g tFb;
    public boolean tFc = true;
    public boolean tFd = false;
    public boolean tFe = false;
    private boolean tFf = true;
    private int tFg = 0;
    public boolean tFh = false;
    int tFi = 0;

    public BizChatSearchUI$a(Context context, String str, int i) {
        boolean z;
        boolean z2 = false;
        this.context = context;
        this.hpJ = str;
        this.scene = i;
        if (this.scene == 1 || this.scene == 2) {
            z = true;
        } else {
            z = false;
        }
        this.tER = z;
        if (this.scene == 1 || this.scene == 3) {
            z2 = true;
        }
        this.tES = z2;
        this.tEQ = this.scene == 1 ? tEP : Integer.MAX_VALUE;
        a aVar = new a();
        aVar.dXB = com.tencent.mm.ac.a.e.cy(this.hpJ);
        aVar.dXy = true;
        aVar.dXV = true;
        aVar.dXN = R.k.default_avatar;
        this.dXk = aVar.Pt();
        if (this.tER) {
            au.DF().a(1364, this);
        }
    }

    public final int getCount() {
        return this.Ma;
    }

    public final int getItemViewType(int i) {
        g ED = getItem(i);
        if (ED != null) {
            return ED.hER;
        }
        return g.tFl;
    }

    public final int getViewTypeCount() {
        return g.tFr;
    }

    /* renamed from: ED */
    public final g getItem(int i) {
        int i2;
        if (i < this.tFg) {
            if (i == 0) {
                if (this.tEW == null) {
                    this.tEW = new g(g.tFq, Integer.valueOf(g.tFs));
                }
                return this.tEW;
            } else if (i == this.tFg - 1 && this.tFd && cst()) {
                if (this.tEY == null) {
                    this.tEY = new g();
                }
                this.tEY.hER = g.tFp;
                this.tEY.data = Integer.valueOf(g.tFs);
                return this.tEY;
            } else if (i == this.tFg - 1 && this.tFc && cst()) {
                if (this.tEY == null) {
                    this.tEY = new g();
                }
                this.tEY.hER = g.tFo;
                this.tEY.data = Integer.valueOf(g.tFs);
                return this.tEY;
            } else {
                i2 = i - 1;
                if (i2 >= 0 && i2 < this.tEX.size()) {
                    return (g) this.tEX.get(i2);
                }
            }
        } else if (i == this.tFg) {
            if (this.tEZ == null) {
                this.tEZ = new g(g.tFq, Integer.valueOf(g.tFt));
            }
            return this.tEZ;
        } else if (i == this.Ma - 1 && this.tFf && cst()) {
            if (this.tFb == null) {
                this.tFb = new g(g.tFo, Integer.valueOf(g.tFt));
            }
            return this.tFb;
        } else {
            i2 = (i - this.tFg) - 1;
            if (i2 >= 0 && i2 < this.tFa.size()) {
                return (g) this.tFa.get(i2);
            }
        }
        return new g();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        g ED = getItem(i);
        String str;
        CharSequence a;
        if (ED.hER == g.tFm || ED.hER == g.tFn) {
            boolean z2;
            boolean z3;
            String str2;
            CharSequence charSequence;
            CharSequence concat;
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.i.fts_contact_item, viewGroup, false);
                view.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
                BizChatSearchUI$f bizChatSearchUI$f = new BizChatSearchUI$f();
                bizChatSearchUI$f.eCl = (ImageView) view.findViewById(R.h.avatar_iv);
                bizChatSearchUI$f.eCm = (TextView) view.findViewById(R.h.title_tv);
                bizChatSearchUI$f.eCn = (TextView) view.findViewById(R.h.desc_tv);
                bizChatSearchUI$f.contentView = view.findViewById(R.h.search_item_content_layout);
                view.setTag(bizChatSearchUI$f);
            }
            BizChatSearchUI$f bizChatSearchUI$f2 = (BizChatSearchUI$f) view.getTag();
            String str3 = "";
            String str4 = "";
            CharSequence charSequence2 = "";
            if (ED.data instanceof com.tencent.mm.ac.a.c) {
                com.tencent.mm.ac.a.c cVar = (com.tencent.mm.ac.a.c) ED.data;
                if (cVar != null) {
                    if (!cVar.isGroup()) {
                        j cz = z.Nc().cz(cVar.field_bizChatServId);
                        if (cz != null) {
                            str4 = cz.field_userName;
                            str = cz.field_headImageUrl;
                            str3 = str4;
                        }
                    }
                    str4 = cVar.field_chatName;
                    str = cVar.field_headImageUrl;
                    str3 = str4;
                } else {
                    str = str4;
                }
                z2 = true;
                z3 = false;
                str2 = str;
                charSequence = str3;
            } else if (ED.data instanceof hw) {
                hw hwVar = (hw) ED.data;
                hz hzVar = hwVar.riN;
                charSequence = hzVar.hyG;
                str2 = hzVar.riF;
                boolean equals = "userid".equals(hwVar.riO);
                boolean z4 = !equals;
                Object charSequence22 = hwVar.riP;
                z2 = z4;
                z3 = equals;
            } else {
                z2 = false;
                z3 = false;
                str2 = str4;
                Object charSequence3 = str3;
            }
            if (z2) {
                a = a(this.context, f.a(charSequence3, this.dBm), b.c.jvw);
            } else {
                a = a(this.context, new SpannableString(charSequence3), b.c.jvw);
            }
            if (z3) {
                str = this.context.getString(R.l.bizchat_search_user_tag_userid);
                SpannableString a2 = a(this.context, f.a(charSequence22, this.dBm), b.c.jvw);
                concat = TextUtils.concat(new CharSequence[]{str, a2});
            } else {
                concat = "";
            }
            if (ED.hER == g.tFm && i == this.tFg - 1 && this.tFg != this.Ma) {
                z = false;
            }
            m.h(bizChatSearchUI$f2.contentView, z);
            o.Pj().a(str2, bizChatSearchUI$f2.eCl, this.dXk);
            m.a(a, bizChatSearchUI$f2.eCm);
            m.a(concat, bizChatSearchUI$f2.eCn);
            return view;
        } else if (ED.hER == g.tFq) {
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.i.fts_header_item, viewGroup, false);
                BizChatSearchUI.b bVar = new BizChatSearchUI.b((byte) 0);
                bVar.hRY = (TextView) view.findViewById(R.h.header_tv);
                bVar.jxR = view.findViewById(R.h.padding_view);
                bVar.contentView = view.findViewById(R.h.search_item_content_layout);
                view.setTag(bVar);
            }
            BizChatSearchUI.b bVar2 = (BizChatSearchUI.b) view.getTag();
            str = ((Integer) ED.data).intValue() == g.tFs ? this.context.getResources().getString(R.l.bizchat_search_user) : ((Integer) ED.data).intValue() == g.tFt ? this.context.getResources().getString(R.l.bizchat_search_group) : "";
            m.a(str, bVar2.hRY);
            if (i == 0) {
                bVar2.jxR.setVisibility(8);
            } else {
                bVar2.jxR.setVisibility(0);
            }
            bVar2.contentView.setBackgroundResource(R.g.list_thicklinecell_bg);
            return view;
        } else if (ED.hER == g.tFo) {
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.i.fts_more_item, viewGroup, false);
                BizChatSearchUI.e eVar = new BizChatSearchUI.e((byte) 0);
                eVar.jxy = (TextView) view.findViewById(R.h.tip_tv);
                eVar.gmn = (ImageView) view.findViewById(R.h.icon_iv);
                eVar.contentView = view.findViewById(R.h.search_item_content_layout);
                view.setTag(eVar);
            }
            BizChatSearchUI.e eVar2 = (BizChatSearchUI.e) view.getTag();
            a = "";
            if (((Integer) ED.data).intValue() == g.tFs) {
                a = this.context.getResources().getString(R.l.bizchat_search_more_user);
            } else if (((Integer) ED.data).intValue() == g.tFt) {
                Object string = this.context.getResources().getString(R.l.bizchat_search_more_group);
            }
            if (((Integer) ED.data).intValue() == g.tFs && this.tFg != this.Ma) {
                z = false;
            }
            m.h(eVar2.contentView, z);
            eVar2.jxy.setText(a);
            eVar2.gmn.setImageResource(R.k.fts_more_button_icon);
            return view;
        } else if (ED.hER != g.tFp) {
            return null;
        } else {
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.i.fts_loading_item, viewGroup, false);
                d dVar = new d((byte) 0);
                dVar.jxy = (TextView) view.findViewById(R.h.tip_tv);
                dVar.contentView = view.findViewById(R.h.search_item_content_layout);
                view.setTag(dVar);
            }
            d dVar2 = (d) view.getTag();
            if (((Integer) ED.data).intValue() == g.tFs && this.tFg != this.Ma) {
                z = false;
            }
            m.h(dVar2.contentView, z);
            dVar2.jxy.setText(this.context.getResources().getString(R.l.bizchat_search_loading));
            return view;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.ab.l r12) {
        /*
        r8 = this;
        r1 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r8.tER;
        if (r0 == 0) goto L_0x0045;
    L_0x0007:
        r0 = r12.getType();
        r4 = 1364; // 0x554 float:1.911E-42 double:6.74E-321;
        if (r0 != r4) goto L_0x0045;
    L_0x000f:
        r0 = r12 instanceof com.tencent.mm.ac.a.l;
        if (r0 == 0) goto L_0x0045;
    L_0x0013:
        r8.tFe = r3;
        r12 = (com.tencent.mm.ac.a.l) r12;
        r0 = r12.diG;
        if (r0 == 0) goto L_0x0046;
    L_0x001b:
        r0 = r12.diG;
        r0 = r0.dID;
        r0 = r0.dIL;
        if (r0 == 0) goto L_0x0046;
    L_0x0023:
        r0 = r12.diG;
        r0 = r0.dID;
        r0 = r0.dIL;
        r0 = (com.tencent.mm.protocal.c.hx) r0;
    L_0x002b:
        r4 = r0.bHt;
        r5 = r0.riK;
        r6 = r8.dBm;
        r6 = r4.equals(r6);
        if (r6 == 0) goto L_0x0045;
    L_0x0037:
        r6 = r8.hpJ;
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0045;
    L_0x003f:
        r5 = r8.tFi;
        r0 = r0.offset;
        if (r5 == r0) goto L_0x0048;
    L_0x0045:
        return;
    L_0x0046:
        r0 = r1;
        goto L_0x002b;
    L_0x0048:
        if (r9 != 0) goto L_0x004c;
    L_0x004a:
        if (r10 == 0) goto L_0x0050;
    L_0x004c:
        r8.css();
        goto L_0x0045;
    L_0x0050:
        r0 = r12.diG;
        if (r0 == 0) goto L_0x0074;
    L_0x0054:
        r0 = r12.diG;
        r0 = r0.dIE;
        r0 = r0.dIL;
        if (r0 == 0) goto L_0x0074;
    L_0x005c:
        r0 = r12.diG;
        r0 = r0.dIE;
        r0 = r0.dIL;
        r0 = (com.tencent.mm.protocal.c.hy) r0;
    L_0x0064:
        if (r0 == 0) goto L_0x0070;
    L_0x0066:
        r1 = r0.riQ;
        if (r1 == 0) goto L_0x0070;
    L_0x006a:
        r1 = r0.riQ;
        r1 = r1.ret;
        if (r1 == 0) goto L_0x0076;
    L_0x0070:
        r8.css();
        goto L_0x0045;
    L_0x0074:
        r0 = r1;
        goto L_0x0064;
    L_0x0076:
        r1 = r0.riR;
        r0 = r0.riS;
        r5 = r8.dBm;
        r5 = r4.equals(r5);
        if (r5 == 0) goto L_0x0045;
    L_0x0082:
        r8.tFd = r3;
        r5 = r8.tFi;
        r6 = r1.size();
        r5 = r5 + r6;
        r8.tFi = r5;
        r5 = r8.cst();
        if (r5 == 0) goto L_0x00b3;
    L_0x0093:
        r5 = r8.tEU;
        r5 = r5.size();
        r6 = r8.tET;
        r6 = r6.size();
        if (r5 >= r6) goto L_0x00a5;
    L_0x00a1:
        r8.bx(r4, r2);
        goto L_0x0045;
    L_0x00a5:
        r4 = r8.tEU;
        r4 = r4.size();
        r5 = r8.tET;
        r5 = r5.size();
        if (r4 > r5) goto L_0x0101;
    L_0x00b3:
        r4 = r8.a();
        if (r4 == 0) goto L_0x00bb;
    L_0x00b9:
        r8.tFc = r0;
    L_0x00bb:
        r0 = r8.csv();
        if (r0 != 0) goto L_0x0045;
    L_0x00c1:
        r4 = r1.iterator();
    L_0x00c5:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0101;
    L_0x00cb:
        r0 = r4.next();
        r1 = r0;
        r1 = (com.tencent.mm.protocal.c.hw) r1;
        r5 = r1.riN;
        r0 = r5.riL;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x00c5;
    L_0x00dc:
        r0 = r8.tET;
        r6 = r0.iterator();
    L_0x00e2:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0106;
    L_0x00e8:
        r0 = r6.next();
        r0 = (com.tencent.mm.ac.a.c) r0;
        r7 = r5.riL;
        r0 = r0.field_bizChatServId;
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x00e2;
    L_0x00f8:
        r0 = r2;
    L_0x00f9:
        if (r0 != 0) goto L_0x00c5;
    L_0x00fb:
        r0 = r8.tEU;
        r0.add(r1);
        goto L_0x00c5;
    L_0x0101:
        r8.lQ(r2);
        goto L_0x0045;
    L_0x0106:
        r0 = r3;
        goto L_0x00f9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.bizchat.BizChatSearchUI$a.a(int, int, java.lang.String, com.tencent.mm.ab.l):void");
    }

    private void css() {
        if (a()) {
            this.tFd = false;
            this.tFh = true;
            csw();
        }
    }

    private boolean cst() {
        return this.scene == 1;
    }

    /* renamed from: csu */
    final boolean a() {
        return this.scene == 2;
    }

    private boolean csv() {
        return this.scene == 3;
    }

    private static SpannableString a(Context context, Spannable spannable, int i) {
        int i2 = 0;
        SpannableString a = com.tencent.mm.pluginsdk.ui.d.j.a(context, spannable, i);
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
        if (foregroundColorSpanArr != null) {
            int length = foregroundColorSpanArr.length;
            while (i2 < length) {
                Object obj = foregroundColorSpanArr[i2];
                a.setSpan(obj, spannable.getSpanStart(obj), spannable.getSpanEnd(obj), spannable.getSpanFlags(obj));
                i2++;
            }
        }
        return a;
    }

    final void bx(String str, boolean z) {
        com.tencent.mm.ac.a.b Nb = z.Nb();
        String str2 = this.hpJ;
        List<com.tencent.mm.ac.a.c> arrayList = new ArrayList();
        if (!bi.oW(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select BizChatInfo.*");
            stringBuilder.append(" from BizChatConversation , BizChatInfo");
            stringBuilder.append(" where BizChatConversation.brandUserName = '").append(str2).append("'");
            stringBuilder.append(" and BizChatInfo.brandUserName = '").append(str2).append("'");
            stringBuilder.append(" and BizChatConversation.bizChatId");
            stringBuilder.append(" = BizChatInfo.bizChatLocalId");
            stringBuilder.append(" and BizChatInfo.chatName like '%").append(str).append("%'");
            stringBuilder.append(" order by BizChatConversation.flag desc");
            stringBuilder.append(" , BizChatConversation.lastMsgTime desc");
            x.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", new Object[]{stringBuilder.toString()});
            Cursor rawQuery = Nb.rawQuery(stringBuilder.toString(), new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        com.tencent.mm.ac.a.c cVar = new com.tencent.mm.ac.a.c();
                        cVar.d(rawQuery);
                        arrayList.add(cVar);
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
        }
        acV();
        for (com.tencent.mm.ac.a.c cVar2 : arrayList) {
            boolean isGroup = cVar2.isGroup();
            if (isGroup && this.tES) {
                this.tEV.add(cVar2);
            } else if (!isGroup && this.tER) {
                this.tEU.add(cVar2);
                this.tET.add(cVar2);
            }
        }
        if (this.tER) {
            boolean z2;
            if (this.tEU.size() <= this.tEQ) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.tFd = z2;
        }
        lQ(z);
    }

    final void aag(String str) {
        if (this.tER) {
            ah.i(new 1(this, str), 200);
        }
    }

    final void acV() {
        this.tFi = 0;
        this.tEU.clear();
        this.tET.clear();
        this.tEV.clear();
    }

    final void lQ(boolean z) {
        int i;
        int i2 = 1;
        this.tEX.clear();
        this.tFa.clear();
        for (i = 0; i < Math.min(this.tEQ, this.tEU.size()); i++) {
            this.tEX.add(new g(g.tFm, this.tEU.get(i)));
        }
        for (i = 0; i < Math.min(this.tEQ, this.tEV.size()); i++) {
            this.tFa.add(new g(g.tFn, this.tEV.get(i)));
        }
        int size = this.tEU.size();
        int size2 = this.tEV.size();
        if (this.scene != 2) {
            this.tFc = this.tEU.size() > this.tEQ;
        }
        this.tFf = this.tEV.size() > this.tEQ;
        if (size > 0 || this.tFd) {
            size = Math.min(size, this.tEQ) + 1;
            if (cst()) {
                i = (this.tFd || this.tFc) ? 1 : 0;
                i += size;
            } else {
                i = size;
            }
        } else {
            i = 0;
        }
        this.tFg = i;
        if (size2 > 0) {
            i = (i + 1) + Math.min(size2, this.tEQ);
            if (cst()) {
                if (!this.tFf) {
                    i2 = 0;
                }
                i += i2;
            }
        }
        this.Ma = i;
        if (z) {
            notifyDataSetChanged();
            csw();
        }
    }

    final void csw() {
        BizChatSearchUI bizChatSearchUI = (BizChatSearchUI) this.context;
        if (!cst()) {
            if (bi.oW(this.dBm)) {
                bizChatSearchUI.tEM.setVisibility(0);
                bizChatSearchUI.tEM.setText("");
                bizChatSearchUI.tEL.setVisibility(8);
            } else if (a() && this.tFd) {
                bizChatSearchUI.tEM.setVisibility(0);
                bizChatSearchUI.tEM.setText(R.l.bizchat_search_loading);
                bizChatSearchUI.tEL.setVisibility(8);
            } else if (a() && this.tFh) {
                bizChatSearchUI.tEM.setVisibility(0);
                bizChatSearchUI.tEM.setText(R.l.bizchat_search_loading_error);
                bizChatSearchUI.tEL.setVisibility(8);
            } else if (getCount() <= 0) {
                bizChatSearchUI.tEM.setVisibility(0);
                bizChatSearchUI.tEM.setText(f.a(bizChatSearchUI.getString(R.l.search_contact_no_result_pre), bizChatSearchUI.getString(R.l.search_contact_no_result_post), com.tencent.mm.plugin.fts.a.a.d.b(this.dBm, this.dBm)).jrO);
                bizChatSearchUI.tEL.setVisibility(8);
            } else {
                bizChatSearchUI.tEM.setVisibility(8);
                bizChatSearchUI.tEL.setVisibility(0);
            }
            if (!a()) {
                return;
            }
            if (this.tFe) {
                bizChatSearchUI.EC(1);
            } else if (this.tFc) {
                bizChatSearchUI.EC(2);
            } else {
                bizChatSearchUI.EC(0);
            }
        } else if (bi.oW(this.dBm)) {
            bizChatSearchUI.tEM.setVisibility(8);
            bizChatSearchUI.tEL.setVisibility(8);
        } else if (getCount() <= 0) {
            bizChatSearchUI.tEM.setVisibility(0);
            bizChatSearchUI.tEL.setVisibility(8);
        } else {
            bizChatSearchUI.tEM.setVisibility(8);
            bizChatSearchUI.tEL.setVisibility(0);
        }
    }
}
