package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bt.a.a;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$d;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.f$a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class g extends f<String, ai> implements b {
    private boolean eMT;
    protected List<String> gRN;
    protected com.tencent.mm.ui.base.MMSlideDelView.g hkN;
    protected c hkO;
    protected MMSlideDelView$d hkQ;
    boolean kGt;
    boolean nNk;
    private float tEh;
    private float tEi;
    private float tEj;
    private ColorStateList[] tEk;
    HashMap<String, d> tEl;
    public boolean tOj;
    private boolean unU;
    com.tencent.mm.pluginsdk.ui.d unW;
    private boolean unZ;
    com.tencent.mm.sdk.b.c uoc;
    public String uoe;
    private final int uog;
    private final int uoh;
    private boolean upJ;
    private rn upK;
    b upL;
    private HashSet<String> upM;
    private boolean upN;
    HashMap<String, Integer> upO;
    private HashMap<String, Integer> upP;
    boolean upQ;
    HashSet<String> upR;
    boolean upS;
    private boolean upT;
    private NoMeasuredTextView.c upU;
    public String upV;
    final e upW;
    private float upX;
    private a upY;
    private long upZ;

    private class d {
        public String daA;
        public int hER;
        public CharSequence nickName;
        public boolean qpi;
        public boolean tEm;
        public CharSequence uop;
        public CharSequence uoq;
        public int uor;
        public int uos;
        public int uot;
        public boolean uou;
        public boolean uov;
        public boolean uow;
        public boolean uox;
        public boolean uoy;
        public boolean uoz;

        private d() {
        }

        /* synthetic */ d(g gVar, byte b) {
            this();
        }
    }

    public final /* synthetic */ a coc() {
        return new ai();
    }

    public g(Context context, f$a f_a) {
        super(context, (short) 0);
        this.gRN = null;
        this.tEk = new ColorStateList[5];
        this.unU = true;
        this.upJ = false;
        this.hkQ = MMSlideDelView.getItemStatusCallBack();
        this.upK = null;
        this.eMT = false;
        this.tEh = -1.0f;
        this.tEi = -1.0f;
        this.tEj = -1.0f;
        this.unZ = false;
        this.uoc = null;
        this.upL = null;
        this.tOj = false;
        this.upN = false;
        this.upO = new HashMap();
        this.upP = new HashMap();
        this.upQ = false;
        this.upS = false;
        this.upT = false;
        this.upU = new 1(this);
        this.uoe = "";
        this.upV = "";
        this.upW = new e(this);
        this.nNk = false;
        this.upX = -1.0f;
        this.upZ = 0;
        this.kGt = false;
        this.TAG = "MicroMsg.ConversationWithCacheAdapter";
        super.a(f_a);
        this.tEk[0] = com.tencent.mm.bp.a.ac(context, R.e.hint_text_color);
        this.tEk[1] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_unread);
        this.tEk[3] = com.tencent.mm.bp.a.ac(context, R.e.normal_text_color);
        this.tEk[2] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_three);
        this.tEk[2] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_three);
        this.tEk[4] = com.tencent.mm.bp.a.ac(context, R.e.light_text_color);
        if (com.tencent.mm.bp.a.fi(context)) {
            this.uoh = context.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
            this.uog = context.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
        } else {
            this.uoh = context.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
            this.uog = context.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth);
        }
        this.tEl = new HashMap();
        this.upM = new HashSet();
        this.upR = new HashSet();
        this.tEh = context.getResources().getDimension(R.f.NormalTextSize);
        this.tEi = context.getResources().getDimension(R.f.HintTextSize);
        this.tEj = context.getResources().getDimension(R.f.SmallestTextSize);
        this.gRN = new ArrayList();
        this.gRN.add("qmessage");
    }

    public final void setPerformItemClickListener(com.tencent.mm.ui.base.MMSlideDelView.g gVar) {
        this.hkN = gVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.hkO = cVar;
    }

    private CharSequence h(ai aiVar) {
        if (aiVar.field_status == 1) {
            return this.context.getString(R.l.main_sending);
        }
        return aiVar.field_conversationTime == Long.MAX_VALUE ? "" : h.c(this.context, aiVar.field_conversationTime, true);
    }

    public final void cxZ() {
        boolean z = true;
        if (this.gRN == null) {
            this.gRN = new ArrayList();
        }
        this.gRN.clear();
        boolean z2 = (q.GJ() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0;
        boolean GW = q.GW();
        if (!(z2 && GW)) {
            z = false;
        }
        if (z != this.upT) {
            if (z) {
                au.HU();
                a(5, (m) com.tencent.mm.model.c.FW(), (Object) "floatbottle");
            } else {
                au.HU();
                a(2, (m) com.tencent.mm.model.c.FW(), (Object) "floatbottle");
            }
            this.upT = z;
        }
        if (this.upT) {
            this.gRN.add("floatbottle");
        }
        this.gRN.add("qmessage");
    }

    public final void onPause() {
        x.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.tOj);
        if (this.tOj) {
            this.tOj = false;
            super.pause();
            if (this.hkQ != null) {
                this.hkQ.aYl();
            }
        }
    }

    private void cyH() {
        if (this.tEl != null) {
            for (Entry value : this.tEl.entrySet()) {
                ((d) value.getValue()).uop = null;
            }
        }
    }

    public final void onResume() {
        x.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.tOj);
        if (!this.tOj) {
            boolean z;
            this.tOj = true;
            cxZ();
            cyQ();
            x.i(this.TAG, "newcursor resume syncNow ");
            this.thB = true;
            lu(true);
            Time time = new Time();
            time.setToNow();
            String charSequence = com.tencent.mm.pluginsdk.f.g.a("MM/dd", time).toString();
            String chP = w.chP();
            if (this.uoe.equals(charSequence) && this.upV.equals(chP)) {
                z = false;
            } else {
                z = true;
            }
            this.uoe = charSequence;
            this.upV = chP;
            if (z) {
                cyH();
            }
            if (this.unZ && this.upL != null) {
                this.upL.cyR();
                this.unZ = false;
                super.q(null, 1);
            }
            this.upK = new rn();
            this.upK.ccn.ccp = true;
            com.tencent.mm.sdk.b.a.sFg.m(this.upK);
        }
    }

    public final void cyP() {
        super.q(null, 1);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        View view2;
        this.upY = new a(this, (byte) 0);
        ai aiVar = (ai) Dy(i);
        String str = aiVar.field_username;
        this.upW.ep(str);
        if (!this.upO.containsKey(str)) {
            this.upO.put(str, Integer.valueOf(i));
        } else if (i != ((Integer) this.upO.get(str)).intValue()) {
            int i2;
            SparseArray[] coX = coX();
            HashMap cnT = this.thC == null ? null : this.thC.teA.cnT();
            StringBuffer stringBuffer = new StringBuffer();
            for (SparseArray sparseArray : coX) {
                int i3 = 0;
                while (true) {
                    i2 = i3;
                    if (i2 >= sparseArray.size() || i2 >= 50) {
                    } else {
                        stringBuffer.append("[");
                        stringBuffer.append(i2);
                        stringBuffer.append(",");
                        stringBuffer.append(sparseArray.keyAt(i2));
                        stringBuffer.append(",");
                        stringBuffer.append((String) sparseArray.valueAt(i2));
                        stringBuffer.append("]");
                        i3 = i2 + 1;
                    }
                }
            }
            stringBuffer.append("\n");
            if (cnT != null) {
                i2 = 0;
                for (Entry entry : cnT.entrySet()) {
                    if (i2 >= 50) {
                        break;
                    }
                    i2++;
                    stringBuffer.append("[");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(",");
                    if (entry.getValue() != null) {
                        stringBuffer.append(((ai) entry.getValue()).field_username);
                    }
                    stringBuffer.append("]");
                }
                stringBuffer.append("\n");
            }
            String str2 = "MicroMsg.ConversationWithCacheAdapter";
            String str3 = "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d";
            Object[] objArr = new Object[5];
            objArr[0] = stringBuffer.toString();
            objArr[1] = str;
            objArr[2] = Integer.valueOf(i);
            objArr[3] = this.upO.toString();
            objArr[4] = Integer.valueOf(cnT != null ? cnT.size() : 0);
            x.i(str2, str3, objArr);
            if (!this.upN) {
                e.qd(20);
                this.upN = true;
            }
            if (System.currentTimeMillis() - this.upZ > 3600000) {
                super.q(null, 1);
                this.upZ = System.currentTimeMillis();
            }
        }
        if (view == null) {
            View a;
            fVar = new f();
            if (com.tencent.mm.bp.a.fi(this.context)) {
                a = com.tencent.mm.kiss.a.b.EY().a((Activity) this.context, "R.layout.conversation_item_with_cache_large", R.i.conversation_item_with_cache_large);
            } else if (com.tencent.mm.bp.a.fj(this.context)) {
                a = com.tencent.mm.kiss.a.b.EY().a((Activity) this.context, "R.layout.conversation_item_with_cache_small", R.i.conversation_item_with_cache_small);
            } else {
                a = com.tencent.mm.kiss.a.b.EY().a((Activity) this.context, "R.layout.conversation_item_with_cache", R.i.conversation_item_with_cache);
            }
            fVar.eCl = (ImageView) a.findViewById(R.h.avatar_iv);
            com.tencent.mm.pluginsdk.ui.a.b.a(fVar.eCl, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) fVar.eCl.getDrawable();
            if (this.unW != null) {
                this.unW.a(aVar);
            }
            fVar.tEp = (NoMeasuredTextView) a.findViewById(R.h.nickname_tv);
            fVar.tEp.setLayoutCallback(this.upU);
            fVar.tEq = (NoMeasuredTextView) a.findViewById(R.h.update_time_tv);
            fVar.uqj = (ImageView) a.findViewById(R.h.last_msg_type_iv);
            fVar.tEr = (NoMeasuredTextView) a.findViewById(R.h.last_msg_tv);
            fVar.hkV = (TextView) a.findViewById(R.h.tipcnt_tv);
            fVar.tEs = (ImageView) a.findViewById(R.h.image_mute);
            fVar.tEu = a.findViewById(R.h.avatar_prospect_iv);
            fVar.tEt = (ImageView) a.findViewById(R.h.talkroom_iv);
            fVar.uoD = (ImageView) a.findViewById(R.h.location_share_iv);
            fVar.uqk = (ImageView) a.findViewById(R.h.multitalk_iv);
            fVar.hkV.setBackgroundResource(r.hd(this.context));
            fVar.uql = new c(this);
            a.setTag(fVar);
            fVar.tEr.setTextSize(0, (float) com.tencent.mm.bp.a.ad(this.context, R.f.SmallerTextSize));
            fVar.tEq.setTextSize(0, (float) com.tencent.mm.bp.a.ad(this.context, R.f.SmallestTextSize));
            fVar.tEp.setTextSize(0, (float) com.tencent.mm.bp.a.ad(this.context, R.f.NormalTextSize));
            this.upX = fVar.tEp.getTextSize();
            fVar.tEr.setTextColor(this.tEk[0]);
            fVar.tEq.setTextColor(this.tEk[4]);
            fVar.tEp.setTextColor(this.tEk[3]);
            fVar.tEr.setShouldEllipsize(true);
            fVar.tEq.setShouldEllipsize(false);
            fVar.tEp.setShouldEllipsize(true);
            fVar.tEq.setGravity(5);
            view2 = a;
        } else {
            view2 = view;
            fVar = (f) view.getTag();
        }
        d i4 = i(aiVar);
        if (i4.uoq == null) {
            i4.uoq = b(aiVar, (int) fVar.tEr.getTextSize(), i4.uow);
        }
        if (i4.uop == null) {
            i4.uop = h(aiVar);
        }
        if (i4.uow) {
            fVar.tEr.setTextColor(this.tEk[0]);
        } else {
            fVar.tEr.setTextColor(this.tEk[i4.hER]);
        }
        com.tencent.mm.booter.notification.a.h.fz(fVar.tEr.getWidth());
        com.tencent.mm.booter.notification.a.h.fA((int) fVar.tEr.getTextSize());
        com.tencent.mm.booter.notification.a.h.a(fVar.tEr.getPaint());
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            fVar.tEp.setCompoundRightDrawablesWithIntrinsicBounds(R.g.icon_tencent_weibo);
            fVar.tEp.setDrawRightDrawable(true);
        } else {
            fVar.tEp.setDrawRightDrawable(false);
        }
        int i5 = i4.uor;
        if (i5 != -1) {
            fVar.tEr.setCompoundLeftDrawablesWithIntrinsicBounds(i5);
            fVar.tEr.setDrawLeftDrawable(true);
            x.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[]{str, Integer.valueOf(i4.uor)});
        } else {
            fVar.tEr.setDrawLeftDrawable(false);
            fVar.tEr.invalidate();
        }
        if (ab.XR(aiVar.field_username)) {
            this.upW.ep(aiVar.field_username);
            ab cyS = this.upW.cyS();
            String str4 = "";
            if (cyS != null) {
                str4 = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).aE(cyS.field_openImAppid, cyS.field_descWordingId);
            }
            if (com.tencent.mm.platformtools.ai.oW(str4)) {
                fVar.tEp.an(null, 0, 0);
            } else {
                if ("3552365301".equals(cyS.field_openImAppid)) {
                    str4 = "@" + str4;
                }
                fVar.tEp.an(str4, R.e.lable_text_color, 14);
            }
        } else {
            fVar.tEp.an(null, 0, 0);
        }
        fVar.tEp.setText(i4.nickName);
        LayoutParams layoutParams = fVar.tEq.getLayoutParams();
        if (i4.uop.length() >= 9) {
            if (layoutParams.width != this.uoh) {
                layoutParams.width = this.uoh;
                fVar.tEq.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.uog) {
            layoutParams.width = this.uog;
            fVar.tEq.setLayoutParams(layoutParams);
        }
        fVar.tEq.setText(i4.uop);
        fVar.tEr.setText(i4.uoq);
        fVar.uqj.setVisibility(8);
        fVar.tEs.setVisibility(8);
        if (i4.qpi) {
            if (i4.uoy) {
                fVar.tEs.setVisibility(0);
            }
        } else if (i4.uov) {
            fVar.tEs.setVisibility(0);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(fVar.eCl, str);
        if (this.unU) {
            if (aiVar == null || fVar == null || i4 == null) {
                x.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                fVar.hkV.setVisibility(4);
                fVar.tEu.setVisibility(4);
                ColorStateList colorStateList = (!s.hb(aiVar.field_username) && i4.uox && (i4.uot == 1 || i4.uot == 2 || i4.uot == 3)) ? this.tEk[2] : this.tEk[3];
                fVar.tEp.setTextColor(colorStateList);
                if (!i4.uox || i4.uos == 0) {
                    x.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
                } else {
                    i5 = a(aiVar, i4);
                    if (i5 == 1) {
                        fVar.tEu.setVisibility(0);
                    } else if (i5 == 2) {
                        i5 = aiVar.field_unReadCount;
                        if (i5 > 99) {
                            fVar.hkV.setText(R.l.unread_count_overt_100);
                            fVar.hkV.setVisibility(0);
                        } else if (i5 > 0) {
                            fVar.hkV.setText(aiVar.field_unReadCount);
                            fVar.hkV.setVisibility(0);
                        }
                        this.upY.uon = i5;
                    }
                }
            }
        }
        if (!i4.uou && i4.tEm && au.HX()) {
            au.HU();
            com.tencent.mm.model.c.FW().f(aiVar);
        }
        if (!i4.tEm || aiVar.field_conversationTime == -1) {
            view2.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
        } else {
            view2.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
        }
        if (VERSION.SDK_INT >= 21) {
            view2.findViewById(R.h.conversation_item_ll).setOnTouchListener(new 3(this));
        }
        com.tencent.mm.bg.d.cfH();
        if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 7, 0) || aiVar.field_username.equals(this.upK.cco.ccr))) {
            aiVar.at(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 6, aiVar.field_conversationTime));
            au.HU();
            com.tencent.mm.model.c.FW().a(aiVar, aiVar.field_username);
        }
        if (com.tencent.mm.ax.g.elf == null || !com.tencent.mm.ax.g.elf.nq(aiVar.field_username)) {
            fVar.tEt.setVisibility(8);
        } else {
            fVar.tEt.setVisibility(0);
            if (aiVar.field_username.equals(this.upK.cco.ccr)) {
                fVar.tEt.setImageResource(R.k.talk_room_mic_speaking);
            } else {
                fVar.tEt.setImageResource(R.k.talk_room_mic_idle);
            }
        }
        if (com.tencent.mm.ay.d.elh == null || !com.tencent.mm.ay.d.elh.nt(aiVar.field_username)) {
            fVar.uoD.setVisibility(8);
        } else {
            fVar.uoD.setVisibility(0);
        }
        if (s.fq(aiVar.field_username) && o.a.qyi != null && o.a.qyi.HD(aiVar.field_username)) {
            if (o.a.qyi.bgn() && o.a.qyi.dL(aiVar.field_username, q.GF())) {
                fVar.uqk.setImageResource(R.k.chatlist_multitalk_highlight_icon);
            } else {
                fVar.uqk.setImageResource(R.k.chatlist_multitalk_icon);
            }
            fVar.uqk.setVisibility(0);
        } else {
            fVar.uqk.setVisibility(8);
        }
        this.upY.content = String.valueOf(i4.uoq);
        this.upY.bgn = i4.daA;
        this.upY.uoo = String.valueOf(i4.uop);
        a aVar2 = this.upY;
        com.tencent.mm.ui.a.a.a.cqX().a(view2, aVar2.bgn, aVar2.uon, aVar2.uoo, aVar2.content);
        return view2;
    }

    final d i(ai aiVar) {
        boolean z = true;
        String str = aiVar.field_username;
        d dVar = (d) this.tEl.get(str);
        if (dVar != null) {
            return dVar;
        }
        boolean z2;
        int i;
        d dVar2 = new d(this, (byte) 0);
        this.upW.ep(str);
        ab cyS = this.upW.cyS();
        if (cyS != null) {
            dVar2.uot = cyS.csS;
            dVar2.uos = (int) cyS.dhP;
        } else {
            dVar2.uot = -1;
            dVar2.uos = -1;
        }
        if (cyS != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        dVar2.uox = z2;
        if (cyS == null || !cyS.BE()) {
            z2 = false;
        } else {
            z2 = true;
        }
        dVar2.uoz = z2;
        if (cyS == null || cyS.csI != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        dVar2.uoy = z2;
        dVar2.qpi = s.fq(str);
        if (dVar2.qpi && dVar2.uoy && aiVar.field_unReadCount > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        dVar2.uow = z2;
        dVar2.hER = 0;
        if (wW(aiVar.field_msgType) == 34 && aiVar.field_isSend == 0 && !com.tencent.mm.platformtools.ai.oW(aiVar.field_content)) {
            String str2 = aiVar.field_content;
            if (str.equals("qmessage") || str.equals("floatbottle") || str.equals("officialaccounts") || aiVar.gh(2097152) || aiVar.gh(8388608)) {
                String[] split = str2.split(":");
                if (split != null && split.length > 3) {
                    str2 = split[1] + ":" + split[2] + ":" + split[3];
                }
            }
            if (!new n(str2).enG) {
                dVar2.hER = 1;
            }
        }
        if (s.hE(str) && com.tencent.mm.storage.s.auK()) {
            dVar2.daA = this.context.getResources().getString(R.l.biz_time_line_title);
        } else {
            dVar2.daA = com.tencent.mm.model.r.a(cyS, str, dVar2.qpi);
        }
        a(dVar2, cyS);
        dVar2.uop = h(aiVar);
        switch (aiVar.field_status) {
            case 0:
                i = -1;
                break;
            case 1:
            case 8:
                i = R.k.msg_state_sending;
                break;
            case 2:
                i = -1;
                break;
            case 5:
                i = R.k.msg_state_failed;
                break;
            default:
                i = -1;
                break;
        }
        dVar2.uor = i;
        dVar2.uou = s.a(aiVar);
        au.HU();
        dVar2.tEm = com.tencent.mm.model.c.FW().g(aiVar);
        if (cyS == null || !cyS.BD()) {
            z = false;
        }
        dVar2.uov = z;
        this.tEl.put(str, dVar2);
        return dVar2;
    }

    private void a(d dVar, ab abVar) {
        if (dVar.qpi && dVar.daA == null) {
            dVar.nickName = this.context.getString(R.l.chatting_roominfo_noname);
        } else if (ab.XR(abVar.field_username)) {
            com.tencent.mm.openim.a.b bVar = (com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class);
            Context context = ad.getContext();
            String str = dVar.daA;
            String str2 = abVar.field_openImAppid;
            dVar.nickName = bVar.d(context, str, com.tencent.mm.bp.a.ad(this.context, R.f.NormalTextSize));
        } else {
            dVar.nickName = j.a(this.context, dVar.daA, com.tencent.mm.bp.a.ad(this.context, R.f.NormalTextSize));
        }
    }

    static int a(ai aiVar, d dVar) {
        if (aiVar == null || aiVar.field_unReadCount <= 0) {
            if (aiVar != null && ((aiVar.gh(8388608) || aiVar.gh(2097152)) && aiVar != null && aiVar.field_unReadMuteCount > 0)) {
                return 1;
            }
            if (aiVar == null || !s.hE(aiVar.field_username) || !com.tencent.mm.storage.s.auK() || aiVar.field_unReadMuteCount <= 0) {
                return 0;
            }
            return 1;
        } else if (!s.hE(aiVar.field_username)) {
            if (s.hJ(aiVar.field_username)) {
                au.HU();
                if (!com.tencent.mm.model.c.DT().getBoolean(aa.a.sUk, true)) {
                    return 1;
                }
            }
            if (s.hN(aiVar.field_username)) {
                au.HU();
                if (!com.tencent.mm.model.c.DT().getBoolean(aa.a.sUl, true)) {
                    return 1;
                }
            }
            if (dVar.uov && dVar.uoz) {
                return 1;
            }
            if (dVar.qpi && dVar.uoy) {
                return 1;
            }
            return 2;
        } else if (com.tencent.mm.storage.s.auK() && com.tencent.mm.storage.s.auL()) {
            return 2;
        } else {
            return 1;
        }
    }

    private static int wW(String str) {
        int i = 1;
        if (str == null || str.length() <= 0) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public final void clearCache() {
        if (this.tEl != null) {
            this.tEl.clear();
            this.upS = true;
        }
    }

    private CharSequence b(ai aiVar, int i, boolean z) {
        CharSequence string;
        if (com.tencent.mm.platformtools.ai.oW(aiVar.field_editingMsg) || (aiVar.field_atCount > 0 && (aiVar.field_unReadCount > 0 || aiVar.field_unReadMuteCount > 0))) {
            String gT;
            if (wW(aiVar.field_msgType) == 10000) {
                boolean hE = s.hE(aiVar.field_username);
                if (!hE) {
                    hE = aiVar.gh(2097152);
                }
                if (!hE) {
                    hE = aiVar.gh(8388608);
                }
                if (!hE) {
                    hE = aiVar.gh(16777216);
                }
                if (!hE) {
                    hE = s.hN(aiVar.field_username);
                }
                if (!hE) {
                    return new SpannableString(j.d(this.context, aiVar.field_content, i));
                }
            }
            if (wW(aiVar.field_msgType) == 49) {
                gT = com.tencent.mm.model.r.gT(aiVar.field_digestUser);
                com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(aiVar.field_content);
                if (gp != null && gp.type == 40 && k.gv(aiVar.field_content).dzv == 19) {
                    string = com.tencent.mm.platformtools.ai.oW(gT) ? this.context.getString(R.l.app_record) : gT + ": " + this.context.getString(R.l.app_record);
                    aiVar.ed(string);
                    return string;
                }
            }
            CharSequence charSequence = aiVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(j.c(this.context, charSequence, (float) i));
            }
            int i2;
            String str = aiVar.field_username;
            if (str.equals("qqmail")) {
                au.HU();
                if (com.tencent.mm.platformtools.ai.f((Integer) com.tencent.mm.model.c.DT().get(17, null)) == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    return this.context.getString(R.l.settings_plugins_disable);
                }
            }
            if (str.equals("tmessage")) {
                au.HU();
                bl Hg = com.tencent.mm.model.c.FZ().Hg("@t.qq.com");
                if (Hg == null || !Hg.isEnable()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 == 0) {
                    return this.context.getString(R.l.settings_plugins_disable);
                }
            }
            if (aiVar.field_msgType != null && aiVar.field_msgType.equals("64")) {
                return aiVar.field_content;
            }
            CharSequence charSequence2;
            if (aiVar.field_msgType != null && (aiVar.field_msgType.equals("47") || aiVar.field_msgType.equals("1048625"))) {
                str = aaf(aiVar.field_digest);
                gT = "";
                if (!com.tencent.mm.platformtools.ai.oW(str)) {
                    return "[" + str + "]";
                }
                if (aiVar.field_digest != null && aiVar.field_digest.contains(":")) {
                    gT = aiVar.field_digest.substring(0, aiVar.field_digest.indexOf(":"));
                    str = aaf(aiVar.field_digest.substring(aiVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (!com.tencent.mm.platformtools.ai.oW(str)) {
                        charSequence2 = "[" + str + "]";
                        if (com.tencent.mm.platformtools.ai.oW(gT)) {
                            return j.a(this.context, gT, i);
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append(j.a(this.context, gT, i));
                        spannableStringBuilder.append(": ");
                        spannableStringBuilder.append(charSequence2);
                        return spannableStringBuilder;
                    }
                }
                str = this.context.getString(R.l.app_emoji);
                aiVar.ed(com.tencent.mm.platformtools.ai.oW(gT) ? str : gT + ": " + str);
            }
            if (!com.tencent.mm.platformtools.ai.oW(aiVar.field_digest)) {
                if (com.tencent.mm.platformtools.ai.oW(aiVar.field_digestUser)) {
                    gT = aiVar.field_digest;
                } else {
                    gT = (aiVar.field_isSend == 0 && s.fq(aiVar.field_username)) ? com.tencent.mm.model.r.getDisplayName(aiVar.field_digestUser, aiVar.field_username) : com.tencent.mm.model.r.gT(aiVar.field_digestUser);
                    try {
                        gT = String.format(aiVar.field_digest, new Object[]{gT});
                    } catch (Exception e) {
                    }
                }
                charSequence = gT.replace(10, ' ');
                SpannableStringBuilder spannableStringBuilder2;
                if (!aiVar.gh(33554432) && (aiVar.field_unReadCount > 0 || aiVar.field_unReadMuteCount > 0)) {
                    string = new SpannableStringBuilder(this.context.getString(R.l.subscribe_notify_digest_prefix));
                    string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
                    string.append(" ").append(j.a(this.context, charSequence, i));
                    return string;
                } else if (aiVar.field_UnReadInvite > 0) {
                    spannableStringBuilder2 = new SpannableStringBuilder(aiVar.field_UnReadInvite < 4096 ? this.context.getString(R.l.main_conversation_chatroom_invite_hint, new Object[]{Integer.valueOf(aiVar.field_UnReadInvite)}) : this.context.getString(R.l.main_conversation_chatroom_accept_invite_hint));
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
                    spannableStringBuilder2.append(" ").append(j.a(this.context, charSequence, i));
                    return spannableStringBuilder2;
                } else if (aiVar.field_atCount > 0 && (aiVar.field_unReadCount > 0 || aiVar.field_unReadMuteCount > 0)) {
                    spannableStringBuilder2 = new SpannableStringBuilder(this.context.getString(aiVar.field_atCount < 4096 ? R.l.main_conversation_chatroom_at_hint : R.l.main_conversation_chatroom_notice_at_hint));
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
                    spannableStringBuilder2.append(" ").append(j.a(this.context, charSequence, i));
                    return spannableStringBuilder2;
                } else if (!aiVar.gh(16777216) || (aiVar.field_unReadCount <= 0 && aiVar.field_unReadMuteCount <= 0)) {
                    if (!z || (aiVar.field_unReadCount <= 1 && aiVar.field_unReadMuteCount <= 0)) {
                        if (s.hE(aiVar.field_username) && com.tencent.mm.storage.s.auK()) {
                            if (com.tencent.mm.storage.s.auL()) {
                                if (aiVar.field_unReadMuteCount > 0) {
                                    string = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_biz_time_line_unread_digest_hint2));
                                    string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
                                    string.append(" ").append(j.a(this.context, charSequence, i));
                                    return string;
                                }
                            } else if (aiVar.field_unReadMuteCount > 0) {
                                string = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_biz_time_line_unread_digest_hint, new Object[]{Integer.valueOf(aiVar.field_unReadMuteCount)}));
                                string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
                                string.append(" ").append(j.a(this.context, charSequence, i));
                                return string;
                            } else if (aiVar.field_unReadCount > 0) {
                                string = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), charSequence});
                            }
                        }
                        string = charSequence;
                    } else {
                        string = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), charSequence});
                    }
                    return j.a(this.context, string, i);
                } else {
                    charSequence2 = this.context.getString(R.l.aa_digest_prefix);
                    charSequence = charSequence.replace(charSequence2, "");
                    string = new SpannableStringBuilder(charSequence2);
                    string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
                    string.append(j.a(this.context, charSequence, i));
                    return string;
                }
            }
            gT = com.tencent.mm.booter.notification.a.h.a(aiVar.field_isSend, aiVar.field_username, aiVar.field_content, wW(aiVar.field_msgType), this.context);
            charSequence = gT.replace(10, ' ');
            if (!aiVar.gh(33554432)) {
            }
            if (aiVar.field_UnReadInvite > 0) {
                spannableStringBuilder2 = new SpannableStringBuilder(aiVar.field_UnReadInvite < 4096 ? this.context.getString(R.l.main_conversation_chatroom_invite_hint, new Object[]{Integer.valueOf(aiVar.field_UnReadInvite)}) : this.context.getString(R.l.main_conversation_chatroom_accept_invite_hint));
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder2.append(" ").append(j.a(this.context, charSequence, i));
                return spannableStringBuilder2;
            } else if (aiVar.field_atCount > 0 && (aiVar.field_unReadCount > 0 || aiVar.field_unReadMuteCount > 0)) {
                spannableStringBuilder2 = new SpannableStringBuilder(this.context.getString(aiVar.field_atCount < 4096 ? R.l.main_conversation_chatroom_at_hint : R.l.main_conversation_chatroom_notice_at_hint));
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder2.append(" ").append(j.a(this.context, charSequence, i));
                return spannableStringBuilder2;
            } else if (!aiVar.gh(16777216) || (aiVar.field_unReadCount <= 0 && aiVar.field_unReadMuteCount <= 0)) {
                if (!z || (aiVar.field_unReadCount <= 1 && aiVar.field_unReadMuteCount <= 0)) {
                    if (s.hE(aiVar.field_username) && com.tencent.mm.storage.s.auK()) {
                        if (com.tencent.mm.storage.s.auL()) {
                            if (aiVar.field_unReadMuteCount > 0) {
                                string = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_biz_time_line_unread_digest_hint2));
                                string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
                                string.append(" ").append(j.a(this.context, charSequence, i));
                                return string;
                            }
                        } else if (aiVar.field_unReadMuteCount > 0) {
                            string = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_biz_time_line_unread_digest_hint, new Object[]{Integer.valueOf(aiVar.field_unReadMuteCount)}));
                            string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
                            string.append(" ").append(j.a(this.context, charSequence, i));
                            return string;
                        } else if (aiVar.field_unReadCount > 0) {
                            string = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), charSequence});
                        }
                    }
                    string = charSequence;
                } else {
                    string = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), charSequence});
                }
                return j.a(this.context, string, i);
            } else {
                charSequence2 = this.context.getString(R.l.aa_digest_prefix);
                charSequence = charSequence.replace(charSequence2, "");
                string = new SpannableStringBuilder(charSequence2);
                string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
                string.append(j.a(this.context, charSequence, i));
                return string;
            }
        }
        string = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_last_editing_msg_prefix));
        string.setSpan(new ForegroundColorSpan(-5569532), 0, string.length(), 33);
        string.append(" ").append(j.a(this.context, aiVar.field_editingMsg, i));
        return string;
    }

    private static String aaf(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zf(str);
    }

    public final com.tencent.mm.bt.a.d coW() {
        x.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
        au.HU();
        return (com.tencent.mm.bt.a.d) com.tencent.mm.model.c.FW().a(s.dAN, this.gRN, com.tencent.mm.m.a.dhR, true);
    }

    public final ArrayList<ai> ae(ArrayList<String> arrayList) {
        x.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList<ai> arrayList2 = new ArrayList(arrayList.size());
        au.HU();
        Cursor a = com.tencent.mm.model.c.FW().a(arrayList, s.dAN, this.gRN, com.tencent.mm.m.a.dhR);
        while (a.moveToNext()) {
            ai aiVar = new ai();
            aiVar.d(a);
            arrayList2.add(aiVar);
        }
        a.close();
        return arrayList2;
    }

    public final SparseArray<String>[] a(HashSet<f.b<String, ai>> hashSet, SparseArray<String>[] sparseArrayArr) {
        if (sparseArrayArr != null && sparseArrayArr.length > 0) {
            f.b bVar;
            x.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", new Object[]{Integer.valueOf(hashSet.size()), Integer.valueOf(sparseArrayArr[0].size())});
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                bVar = (f.b) it.next();
                if (!(bVar == null || bVar.thP == 5 || arrayList.contains(bVar.object))) {
                    x.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + ((String) bVar.object));
                    arrayList.add(bVar.object);
                }
            }
            HashMap hashMap = new HashMap();
            au.HU();
            Cursor a = com.tencent.mm.model.c.FW().a(arrayList, s.dAN, this.gRN, com.tencent.mm.m.a.dhR);
            while (a.moveToNext()) {
                ai aiVar = new ai();
                aiVar.d(a);
                hashMap.put(aiVar.field_username, aiVar);
            }
            a.close();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                bVar = (f.b) it2.next();
                if (bVar != null) {
                    if (bVar.thP != 5) {
                        x.d("MicroMsg.ConversationWithCacheAdapter", "evnet name," + ((String) bVar.object) + "  event.newObj   ==" + (hashMap.get(bVar.object) == null));
                        bVar.thQ = hashMap.get(bVar.object);
                    } else {
                        bVar.thQ = null;
                    }
                }
            }
            arrayList.clear();
            hashMap.clear();
            HashMap hashMap2 = new HashMap();
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                bVar = (f.b) it3.next();
                if (bVar != null) {
                    a(bVar, sparseArrayArr[0], hashMap2);
                    if (bVar.thP != 5) {
                        hashMap2.put(bVar.object, bVar.thQ);
                    }
                }
            }
        }
        return sparseArrayArr;
    }

    private ai c(String str, HashMap<String, ai> hashMap) {
        if (hashMap == null || !hashMap.containsKey(str)) {
            return (ai) cn(str);
        }
        return (ai) hashMap.get(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.util.SparseArray<java.lang.String> a(com.tencent.mm.ui.f.b<java.lang.String, com.tencent.mm.storage.ai> r17, android.util.SparseArray<java.lang.String> r18, java.util.HashMap<java.lang.String, com.tencent.mm.storage.ai> r19) {
        /*
        r16 = this;
        r0 = r17;
        r2 = r0.object;
        r2 = (java.lang.String) r2;
        r6 = r18.size();
        r0 = r17;
        r3 = r0.thQ;
        r3 = (com.tencent.mm.storage.ai) r3;
        r7 = r18.size();
        r5 = 0;
    L_0x0015:
        if (r5 >= r7) goto L_0x0058;
    L_0x0017:
        r0 = r18;
        r4 = r0.get(r5);
        r4 = (java.lang.String) r4;
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x0055;
    L_0x0025:
        r4 = "MicroMsg.ConversationWithCacheAdapter";
        r7 = "resortPosition username %s,  size %d, position %d";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r2;
        r9 = 1;
        r10 = java.lang.Integer.valueOf(r6);
        r8[r9] = r10;
        r9 = 2;
        r10 = java.lang.Integer.valueOf(r5);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.x.d(r4, r7, r8);
        r0 = r17;
        r4 = r0.thP;
        switch(r4) {
            case 2: goto L_0x0079;
            case 3: goto L_0x0049;
            case 4: goto L_0x0049;
            case 5: goto L_0x005b;
            default: goto L_0x0049;
        };
    L_0x0049:
        if (r5 >= 0) goto L_0x00ed;
    L_0x004b:
        r2 = "MicroMsg.ConversationWithCacheAdapter";
        r3 = "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
    L_0x0054:
        return r18;
    L_0x0055:
        r5 = r5 + 1;
        goto L_0x0015;
    L_0x0058:
        r4 = -1;
        r5 = r4;
        goto L_0x0025;
    L_0x005b:
        if (r5 < 0) goto L_0x0054;
    L_0x005d:
        r2 = r6 + -1;
        if (r5 >= r2) goto L_0x0071;
    L_0x0061:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.get(r2);
        r0 = r18;
        r0.put(r5, r2);
        r5 = r5 + 1;
        goto L_0x005d;
    L_0x0071:
        r2 = r6 + -1;
        r0 = r18;
        r0.remove(r2);
        goto L_0x0054;
    L_0x0079:
        if (r3 != 0) goto L_0x00b1;
    L_0x007b:
        r3 = "MicroMsg.ConversationWithCacheAdapter";
        r4 = "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null";
        com.tencent.mm.sdk.platformtools.x.e(r3, r4);
        if (r5 < 0) goto L_0x0054;
    L_0x0086:
        r3 = "MicroMsg.ConversationWithCacheAdapter";
        r4 = "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r2;
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r7);
    L_0x0095:
        r2 = r6 + -1;
        if (r5 >= r2) goto L_0x00a9;
    L_0x0099:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.get(r2);
        r0 = r18;
        r0.put(r5, r2);
        r5 = r5 + 1;
        goto L_0x0095;
    L_0x00a9:
        r2 = r6 + -1;
        r0 = r18;
        r0.remove(r2);
        goto L_0x0054;
    L_0x00b1:
        if (r5 >= 0) goto L_0x0049;
    L_0x00b3:
        r4 = 0;
        r5 = r4;
    L_0x00b5:
        if (r5 >= r6) goto L_0x00d3;
    L_0x00b7:
        r0 = r18;
        r4 = r0.get(r5);
        r4 = (java.lang.String) r4;
        r0 = r16;
        r1 = r19;
        r4 = r0.c(r4, r1);
        r8 = r4.field_flag;
        r10 = r3.field_flag;
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 <= 0) goto L_0x00d3;
    L_0x00cf:
        r4 = r5 + 1;
        r5 = r4;
        goto L_0x00b5;
    L_0x00d3:
        r3 = r6;
    L_0x00d4:
        if (r3 <= r5) goto L_0x00e6;
    L_0x00d6:
        r4 = r3 + -1;
        r0 = r18;
        r4 = r0.get(r4);
        r0 = r18;
        r0.put(r3, r4);
        r3 = r3 + -1;
        goto L_0x00d4;
    L_0x00e6:
        r0 = r18;
        r0.put(r5, r2);
        goto L_0x0054;
    L_0x00ed:
        r0 = r16;
        r1 = r19;
        r4 = r0.c(r2, r1);
        if (r3 != 0) goto L_0x0123;
    L_0x00f7:
        r3 = "MicroMsg.ConversationWithCacheAdapter";
        r4 = "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r2;
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r7);
    L_0x0106:
        r2 = r6 + -1;
        if (r5 >= r2) goto L_0x011a;
    L_0x010a:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.get(r2);
        r0 = r18;
        r0.put(r5, r2);
        r5 = r5 + 1;
        goto L_0x0106;
    L_0x011a:
        r2 = r6 + -1;
        r0 = r18;
        r0.remove(r2);
        goto L_0x0054;
    L_0x0123:
        r8 = r4.field_flag;
        r10 = r3.field_flag;
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 == 0) goto L_0x0054;
    L_0x012b:
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 >= 0) goto L_0x019a;
    L_0x012f:
        r7 = 0;
        r8 = r5 + -1;
        r4 = 1;
        r6 = r4;
    L_0x0134:
        r9 = 0;
        r10 = r7;
    L_0x0136:
        if (r10 > r8) goto L_0x01c0;
    L_0x0138:
        r0 = r18;
        r4 = r0.get(r10);
        r4 = (java.lang.String) r4;
        r0 = r16;
        r1 = r19;
        r4 = r0.c(r4, r1);
        r12 = r4.field_flag;
        r14 = r3.field_flag;
        r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r4 > 0) goto L_0x01a1;
    L_0x0150:
        r3 = 1;
    L_0x0151:
        r4 = "MicroMsg.ConversationWithCacheAdapter";
        r9 = "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s";
        r11 = 6;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r7 = java.lang.Integer.valueOf(r7);
        r11[r12] = r7;
        r7 = 1;
        r8 = java.lang.Integer.valueOf(r8);
        r11[r7] = r8;
        r7 = 2;
        r8 = -1;
        r8 = java.lang.Integer.valueOf(r8);
        r11[r7] = r8;
        r7 = 3;
        r8 = java.lang.Boolean.valueOf(r3);
        r11[r7] = r8;
        r7 = 4;
        r8 = java.lang.Integer.valueOf(r5);
        r11[r7] = r8;
        r7 = 5;
        r11[r7] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r4, r9, r11);
        if (r3 == 0) goto L_0x0054;
    L_0x0186:
        if (r6 == 0) goto L_0x01a4;
    L_0x0188:
        if (r5 <= r10) goto L_0x01b8;
    L_0x018a:
        r3 = r5 + -1;
        r0 = r18;
        r3 = r0.get(r3);
        r0 = r18;
        r0.put(r5, r3);
        r5 = r5 + -1;
        goto L_0x0188;
    L_0x019a:
        r7 = r5 + 1;
        r8 = r6 + -1;
        r4 = 0;
        r6 = r4;
        goto L_0x0134;
    L_0x01a1:
        r10 = r10 + 1;
        goto L_0x0136;
    L_0x01a4:
        r3 = r10 + -1;
    L_0x01a6:
        if (r5 >= r3) goto L_0x01b9;
    L_0x01a8:
        r4 = r5 + 1;
        r0 = r18;
        r4 = r0.get(r4);
        r0 = r18;
        r0.put(r5, r4);
        r5 = r5 + 1;
        goto L_0x01a6;
    L_0x01b8:
        r3 = r10;
    L_0x01b9:
        r0 = r18;
        r0.put(r3, r2);
        goto L_0x0054;
    L_0x01c0:
        r3 = r9;
        goto L_0x0151;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.g.a(com.tencent.mm.ui.f$b, android.util.SparseArray, java.util.HashMap):android.util.SparseArray<java.lang.String>");
    }

    public final void a(int i, m mVar, Object obj) {
        int i2 = 0;
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        if (mVar instanceof az) {
            x.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[]{Integer.valueOf(i), str});
            if (!(!str.contains("@") || str.endsWith("@chatroom") || str.endsWith("@micromsg.qq.com") || ab.XR(str))) {
                i2 = 1;
            }
            if (i2 == 0) {
                if (this.tEl != null) {
                    if (!obj.equals("")) {
                        this.upR.add(str);
                    } else if (i == 5) {
                        this.upS = true;
                        super.q(null, 1);
                        return;
                    }
                }
                if (i == 3) {
                    i = 2;
                }
                super.q(str, i);
            }
        } else if (mVar instanceof ay) {
            x.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", new Object[]{Integer.valueOf(i), obj, Boolean.valueOf(this.kGt)});
            if (!this.kGt) {
                this.upQ = true;
                if (i != 5 && i != 2 && this.tEl != null && this.tEl.containsKey(str) && this.upM != null) {
                    this.upM.add(str);
                }
            }
        }
    }

    private void cyQ() {
        if (this.tEl != null && this.upM != null && !this.upM.isEmpty()) {
            x.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[]{Integer.valueOf(this.upM.size())});
            Iterator it = this.upM.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                String str = (String) it.next();
                if (!(str == null || str.equals("") || !this.tEl.containsKey(str))) {
                    d dVar = (d) this.tEl.get(str);
                    if (dVar != null) {
                        this.upW.ep(str);
                        boolean fq = s.fq(str);
                        ab cyS = this.upW.cyS();
                        if (cyS != null) {
                            String a = com.tencent.mm.model.r.a(cyS, str, fq);
                            x.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[]{a, dVar.daA});
                            if (!(a == null || a.equals(dVar.daA))) {
                                dVar.daA = a;
                                a(dVar, cyS);
                                i = 1;
                            }
                            boolean BD = cyS.BD();
                            fq = cyS.csI == 0;
                            if (!(dVar.uov == BD && fq == dVar.uoy)) {
                                dVar.uov = BD;
                                dVar.uoy = fq;
                                dVar.uoz = cyS.BE();
                                x.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", new Object[]{str});
                                i2 = 1;
                                i = i2;
                            }
                        }
                    }
                }
                i2 = i;
                i = i2;
            }
            if (i != 0) {
                notifyDataSetChanged();
            }
            this.upM.clear();
        }
    }

    public final boolean cnU() {
        return super.cnU();
    }

    public final boolean aaR(String str) {
        return this.tEl == null || !this.tEl.containsKey(str);
    }

    public final void FT(int i) {
        if (i >= 0 && i < getCount()) {
            ai aiVar = (ai) Dy(i);
            if (aiVar != null) {
                com.tencent.mm.pluginsdk.ui.a.b.ccZ().cJ(aiVar.field_username);
            }
        }
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.upO.clear();
        x.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
}
