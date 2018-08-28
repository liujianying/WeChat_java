package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class d extends r<ai> implements b {
    private static long uoj = 2000;
    private String eIQ;
    private boolean eMT = false;
    protected List<String> gRN = null;
    protected g hkN;
    protected MMSlideDelView$c hkO;
    protected f hkP;
    protected com.tencent.mm.ui.base.MMSlideDelView.d hkQ = MMSlideDelView.getItemStatusCallBack();
    boolean nNk = false;
    private float tEh = -1.0f;
    protected float tEi = -1.0f;
    private float tEj = -1.0f;
    private ColorStateList[] tEk = new ColorStateList[5];
    HashMap<String, d> tEl;
    private boolean unU = true;
    private f unV;
    private com.tencent.mm.pluginsdk.ui.d unW;
    private boolean unX = false;
    private boolean unY = false;
    private boolean unZ = false;
    private boolean uoa = false;
    private c uob;
    private c uoc = null;
    private b uod = null;
    public String uoe = "";
    final e uof = new e(this);
    private final int uog;
    private final int uoh;
    private a uoi;
    private boolean uok = false;
    private al uol = new al(au.Em().lnJ.getLooper(), new 1(this), false);

    public d(Context context, a aVar) {
        super(context, new ai());
        this.tlG = aVar;
        this.tEk[0] = com.tencent.mm.bp.a.ac(context, R.e.hint_text_color);
        this.tEk[1] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_unread);
        this.tEk[3] = com.tencent.mm.bp.a.ac(context, R.e.normal_text_color);
        this.tEk[2] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_three);
        this.tEk[2] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_three);
        this.tEk[4] = com.tencent.mm.bp.a.ac(context, R.e.light_text_color);
        this.tEl = new HashMap();
        if (com.tencent.mm.bp.a.fi(context)) {
            this.uoh = context.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
            this.uog = context.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
        } else {
            this.uoh = context.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
            this.uog = context.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth);
        }
        this.tEh = (float) com.tencent.mm.bp.a.ad(context, R.f.NormalTextSize);
        this.tEi = (float) com.tencent.mm.bp.a.ad(context, R.f.HintTextSize);
        this.tEj = (float) com.tencent.mm.bp.a.ad(context, R.f.SmallestTextSize);
    }

    public final void setPerformItemClickListener(g gVar) {
        this.hkN = gVar;
    }

    public final void a(f fVar) {
        this.hkP = fVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView$c mMSlideDelView$c) {
        this.hkO = mMSlideDelView$c;
    }

    public void detach() {
    }

    private CharSequence h(ai aiVar) {
        if (aiVar.field_status == 1) {
            return this.context.getString(R.l.main_sending);
        }
        return aiVar.field_conversationTime == Long.MAX_VALUE ? "" : h.c(this.context, aiVar.field_conversationTime, true);
    }

    protected final void WS() {
        WT();
    }

    public final void onPause() {
        if (this.hkQ != null) {
            this.hkQ.aYl();
        }
        this.unX = false;
    }

    private void cyH() {
        if (this.tEl != null) {
            for (Entry value : this.tEl.entrySet()) {
                ((d) value.getValue()).uop = null;
            }
        }
    }

    public final void onResume() {
        boolean z = true;
        x.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[]{Boolean.valueOf(this.unX), Boolean.valueOf(this.unZ), Boolean.valueOf(this.unY), Boolean.valueOf(this.uoa)});
        this.unX = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = com.tencent.mm.pluginsdk.f.g.a("MM/dd", time).toString();
        if (this.uoe.equals(charSequence)) {
            z = false;
        }
        this.uoe = charSequence;
        if (z) {
            cyH();
        }
        if (this.unZ && this.uod != null) {
            this.unZ = false;
        }
        if (this.unY || this.uoa) {
            super.a(null, null);
            this.unY = false;
            this.uoa = false;
        }
    }

    public final void onDestroy() {
        this.uol.SO();
        this.uod = null;
        this.uob = null;
        if (this.tEl != null) {
            this.tEl.clear();
            this.tEl = null;
        }
        aYc();
        this.tlG = null;
        detach();
    }

    public void WT() {
        x.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[]{Boolean.valueOf(this.eMT)});
        if (this.eMT) {
            Cursor[] cursorArr = new Cursor[2];
            cursorArr[0] = au.HU().dAb.a(s.dAN, this.gRN, this.eIQ);
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            if (this.gRN != null && this.gRN.size() > 0) {
                arrayList.addAll(this.gRN);
            }
            while (cursorArr[0].moveToNext()) {
                try {
                    String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                    arrayList.add(string);
                    if (!string.endsWith("@chatroom")) {
                        arrayList2.add(string);
                    }
                    x.d("MicroMsg.ConversationAdapter", "block user " + string);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ConversationAdapter", e, "", new Object[0]);
                }
            }
            arrayList.add("officialaccounts");
            arrayList.add("helper_entry");
            cursorArr[1] = au.HU().dAc.b(this.eIQ, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
            setCursor(new MergeCursor(cursorArr));
        } else {
            au.HU();
            setCursor(com.tencent.mm.model.c.FW().a(s.dAN, this.gRN, com.tencent.mm.m.a.dhR, false));
        }
        if (!(this.unV == null || this.eIQ == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        g gVar;
        int i2;
        d dVar;
        ai aiVar = (ai) getItem(i);
        String str = aiVar.field_username;
        e eVar = this.uof;
        eVar.talker = str;
        eVar.guS = null;
        eVar.uoB = null;
        eVar.initialized = false;
        if (!com.tencent.mm.platformtools.ai.oW(str)) {
            eVar.initialized = true;
        }
        this.uoi = new a(this, (byte) 0);
        if (view == null) {
            g gVar2 = new g();
            if (com.tencent.mm.bp.a.fi(this.context)) {
                inflate = View.inflate(this.context, R.i.conversation_item_large, null);
            } else {
                inflate = View.inflate(this.context, R.i.conversation_item, null);
            }
            gVar2.eCl = (ImageView) inflate.findViewById(R.h.avatar_iv);
            com.tencent.mm.pluginsdk.ui.a.b.a(gVar2.eCl, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) gVar2.eCl.getDrawable();
            if (this.unW != null) {
                this.unW.a(aVar);
            }
            gVar2.tEp = (NoMeasuredTextView) inflate.findViewById(R.h.nickname_tv);
            gVar2.uoC = (NoMeasuredTextView) inflate.findViewById(R.h.source_tv);
            gVar2.tEq = (NoMeasuredTextView) inflate.findViewById(R.h.update_time_tv);
            gVar2.tEr = (NoMeasuredTextView) inflate.findViewById(R.h.last_msg_tv);
            gVar2.hkV = (TextView) inflate.findViewById(R.h.tipcnt_tv);
            gVar2.hkV.setBackgroundResource(com.tencent.mm.ui.tools.r.hd(this.context));
            gVar2.tEs = (ImageView) inflate.findViewById(R.h.image_mute);
            gVar2.tEu = inflate.findViewById(R.h.avatar_prospect_iv);
            gVar2.tEt = (ImageView) inflate.findViewById(R.h.talkroom_iv);
            gVar2.uoD = (ImageView) inflate.findViewById(R.h.location_share_iv);
            inflate.setTag(gVar2);
            gVar2.tEr.setTextSize(0, this.tEi);
            gVar2.tEq.setTextSize(0, this.tEj);
            gVar2.tEp.setTextSize(0, this.tEh);
            gVar2.uoC.setTextSize(0, this.tEi);
            gVar2.tEr.setTextColor(this.tEk[0]);
            gVar2.tEq.setTextColor(this.tEk[4]);
            gVar2.tEp.setTextColor(this.tEk[3]);
            gVar2.uoC.setTextColor(this.tEk[0]);
            gVar2.tEr.setShouldEllipsize(true);
            gVar2.tEq.setShouldEllipsize(false);
            gVar2.tEp.setShouldEllipsize(true);
            gVar2.uoC.setShouldEllipsize(true);
            gVar2.tEq.setGravity(5);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
            inflate = view;
        }
        d dVar2 = (d) this.tEl.get(str);
        if (dVar2 == null) {
            String str2;
            d dVar3 = new d(this, (byte) 0);
            eVar = this.uof;
            if (eVar.initialized && eVar.guS == null) {
                au.HU();
                eVar.guS = com.tencent.mm.model.c.FR().Yg(eVar.talker);
            }
            ab abVar = eVar.guS;
            if (abVar != null) {
                dVar3.uot = abVar.csS;
                dVar3.uos = (int) abVar.dhP;
            } else {
                dVar3.uot = -1;
                dVar3.uos = -1;
            }
            dVar3.uox = abVar != null;
            boolean z = abVar != null && abVar.BE();
            dVar3.uoz = z;
            z = abVar != null && abVar.csI == 0;
            dVar3.uoy = z;
            dVar3.qpi = s.fq(str);
            z = dVar3.qpi && dVar3.uoy && aiVar.field_unReadCount > 0;
            dVar3.uow = z;
            dVar3.hER = 0;
            if (wW(aiVar.field_msgType) == 34 && aiVar.field_isSend == 0 && !com.tencent.mm.platformtools.ai.oW(aiVar.field_content)) {
                str2 = aiVar.field_content;
                if (str.equals("qmessage") || str.equals("floatbottle")) {
                    String[] split = str2.split(":");
                    if (split != null && split.length > 3) {
                        str2 = split[1] + ":" + split[2] + ":" + split[3];
                    }
                }
                if (!new n(str2).enG) {
                    dVar3.hER = 1;
                }
            }
            str2 = com.tencent.mm.model.r.a(abVar, str, dVar3.qpi);
            if (dVar3.qpi && str2 == null) {
                dVar3.nickName = this.context.getString(R.l.chatting_roominfo_noname);
            } else {
                dVar3.nickName = j.a(this.context, com.tencent.mm.model.r.a(abVar, str, dVar3.qpi), gVar.tEp.getTextSize());
            }
            dVar3.uop = h(aiVar);
            dVar3.uoq = a(aiVar, (int) gVar.tEr.getTextSize(), dVar3.uow);
            dVar3.uoA = aiVar.field_attrflag;
            switch (aiVar.field_status) {
                case 0:
                    i2 = -1;
                    break;
                case 1:
                    i2 = R.k.msg_state_sending;
                    break;
                case 2:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.k.msg_state_failed;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            dVar3.uor = i2;
            dVar3.uou = s.a(aiVar);
            au.HU();
            dVar3.tEm = com.tencent.mm.model.c.FW().g(aiVar);
            z = abVar != null && abVar.BD();
            dVar3.uov = z;
            dVar3.qBs = w.chL();
            this.tEl.put(str, dVar3);
            dVar = dVar3;
        } else {
            dVar = dVar2;
        }
        if (dVar.uop == null) {
            dVar.uop = h(aiVar);
        }
        if (dVar.uow || s.hE(aiVar.field_parentRef)) {
            gVar.tEr.setTextColor(this.tEk[0]);
        } else {
            gVar.tEr.setTextColor(this.tEk[dVar.hER]);
        }
        com.tencent.mm.booter.notification.a.h.fz(gVar.tEr.getWidth());
        com.tencent.mm.booter.notification.a.h.fA((int) gVar.tEr.getTextSize());
        com.tencent.mm.booter.notification.a.h.a(gVar.tEr.getPaint());
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            gVar.tEp.setCompoundRightDrawablesWithIntrinsicBounds(R.g.icon_tencent_weibo);
            gVar.tEp.setDrawRightDrawable(true);
        } else {
            gVar.tEp.setDrawRightDrawable(false);
        }
        i2 = dVar.uor;
        if (i2 != -1) {
            gVar.tEr.setCompoundLeftDrawablesWithIntrinsicBounds(i2);
            gVar.tEr.setDrawLeftDrawable(true);
        } else {
            gVar.tEr.setDrawLeftDrawable(false);
        }
        gVar.tEp.setText(dVar.nickName);
        gVar.uoC.setVisibility(8);
        LayoutParams layoutParams = gVar.tEq.getLayoutParams();
        if (dVar.uop.length() > 9) {
            if (layoutParams.width != this.uoh) {
                layoutParams.width = this.uoh;
                gVar.tEq.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.uog) {
            layoutParams.width = this.uog;
            gVar.tEq.setLayoutParams(layoutParams);
        }
        x.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[]{Integer.valueOf(layoutParams.width)});
        gVar.tEq.setText(dVar.uop);
        gVar.tEr.setText(dVar.uoq);
        if (dVar.qpi && dVar.uoy) {
            gVar.tEs.setVisibility(0);
        } else if (dVar.uov) {
            gVar.tEs.setVisibility(0);
        } else {
            gVar.tEs.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(gVar.eCl, str);
        if (this.unU) {
            if (aiVar == null || gVar == null || dVar == null) {
                x.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                gVar.hkV.setVisibility(4);
                gVar.tEu.setVisibility(4);
                if (s.hE(aiVar.field_username)) {
                    gVar.tEu.setVisibility(aiVar.field_unReadCount > 0 ? 0 : 4);
                    gVar.tEp.setTextColor(this.tEk[3]);
                } else {
                    NoMeasuredTextView noMeasuredTextView = gVar.tEp;
                    ColorStateList colorStateList = (dVar.uox && dVar.uot == 1) ? this.tEk[2] : this.tEk[3];
                    noMeasuredTextView.setTextColor(colorStateList);
                    if (!dVar.uox || dVar.uos == 0) {
                        x.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
                    } else if (s.hE(aiVar.field_parentRef)) {
                        gVar.tEu.setVisibility(aiVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.uov && dVar.uoz) {
                        gVar.tEu.setVisibility(aiVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.qpi && dVar.uoy) {
                        gVar.tEu.setVisibility(aiVar.field_unReadCount > 0 ? 0 : 4);
                    } else {
                        i2 = aiVar.field_unReadCount;
                        if (i2 > 99) {
                            gVar.hkV.setText(R.l.unread_count_overt_100);
                            gVar.hkV.setVisibility(0);
                        } else if (i2 > 0) {
                            gVar.hkV.setText(aiVar.field_unReadCount);
                            gVar.hkV.setVisibility(0);
                        }
                        this.uoi.uon = i2;
                    }
                }
            }
        }
        if (!dVar.uou && dVar.tEm && au.HX()) {
            au.HU();
            com.tencent.mm.model.c.FW().f(aiVar);
        }
        if (!dVar.tEm || aiVar.field_conversationTime == -1) {
            inflate.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
        } else {
            inflate.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
        }
        com.tencent.mm.bg.d.cfH();
        rn rnVar = new rn();
        rnVar.ccn.ccp = true;
        com.tencent.mm.sdk.b.a.sFg.m(rnVar);
        if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 7, 0) || aiVar.field_username.equals(rnVar.cco.ccr))) {
            aiVar.at(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 6, aiVar.field_conversationTime));
            au.HU();
            com.tencent.mm.model.c.FW().a(aiVar, aiVar.field_username);
        }
        if (com.tencent.mm.ax.g.elf == null || !com.tencent.mm.ax.g.elf.nq(aiVar.field_username)) {
            gVar.tEt.setVisibility(8);
        } else {
            gVar.tEt.setVisibility(0);
            if (aiVar.field_username.equals(rnVar.cco.ccr)) {
                gVar.tEt.setImageResource(R.k.talk_room_mic_speaking);
            } else {
                gVar.tEt.setImageResource(R.k.talk_room_mic_idle);
            }
        }
        if (com.tencent.mm.ay.d.elh == null || !com.tencent.mm.ay.d.elh.nt(aiVar.field_username)) {
            gVar.uoD.setVisibility(8);
        } else {
            gVar.uoD.setVisibility(0);
        }
        this.uoi.content = String.valueOf(dVar.uoq);
        this.uoi.bgn = String.valueOf(dVar.nickName);
        this.uoi.uoo = String.valueOf(dVar.uop);
        a aVar2 = this.uoi;
        com.tencent.mm.ui.a.a.a.cqX().a(inflate, aVar2.bgn, aVar2.uon, aVar2.uoo, aVar2.content);
        a(str, gVar);
        a(aiVar, dVar.tEm, i, false);
        return inflate;
    }

    protected void a(String str, g gVar) {
    }

    protected void a(ai aiVar, boolean z, int i, boolean z2) {
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

    private CharSequence a(ai aiVar, int i, boolean z) {
        CharSequence replace;
        if (com.tencent.mm.platformtools.ai.oW(aiVar.field_editingMsg) || (aiVar.field_atCount > 0 && aiVar.field_unReadCount > 0)) {
            CharSequence charSequence = aiVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(j.c(this.context, charSequence, (float) i));
            }
            int i2;
            String str;
            String str2 = aiVar.field_username;
            if (str2.equals("qqmail")) {
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
            if (str2.equals("tmessage")) {
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
            if (aiVar.field_msgType != null && (aiVar.field_msgType.equals("47") || aiVar.field_msgType.equals("1048625"))) {
                str2 = aaf(aiVar.field_digest);
                str = "";
                if (str2 != null) {
                    return "[" + str2 + "]";
                }
                if (aiVar.field_digest != null && aiVar.field_digest.contains(":")) {
                    str = aiVar.field_digest.substring(0, aiVar.field_digest.indexOf(":"));
                    str2 = aaf(aiVar.field_digest.substring(aiVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (str2 != null) {
                        str2 = "[" + str2 + "]";
                        return com.tencent.mm.platformtools.ai.oW(str) ? str2 : str + ": " + str2;
                    }
                }
                str2 = this.context.getString(R.l.app_emoji);
                aiVar.ed(com.tencent.mm.platformtools.ai.oW(str) ? str2 : str + ": " + str2);
            }
            if (!com.tencent.mm.platformtools.ai.oW(aiVar.field_digest)) {
                if (com.tencent.mm.platformtools.ai.oW(aiVar.field_digestUser)) {
                    str = aiVar.field_digest;
                } else {
                    str = (aiVar.field_isSend == 0 && s.fq(aiVar.field_username)) ? com.tencent.mm.model.r.getDisplayName(aiVar.field_digestUser, aiVar.field_username) : com.tencent.mm.model.r.gT(aiVar.field_digestUser);
                    try {
                        str = String.format(aiVar.field_digest, new Object[]{str});
                    } catch (Exception e) {
                    }
                }
                replace = str.replace(10, ' ');
                if (aiVar.field_atCount > 0 || aiVar.field_unReadCount <= 0) {
                    if (!z && aiVar.field_unReadCount > 1) {
                        replace = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), replace});
                    } else if (aiVar.field_unReadCount > 1 && s.hE(aiVar.field_parentRef)) {
                        replace = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), replace});
                    }
                    return j.a(this.context, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_chatroom_at_hint));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(j.a(this.context, replace, i));
                return spannableStringBuilder;
            }
            str = com.tencent.mm.booter.notification.a.h.a(aiVar.field_isSend, aiVar.field_username, aiVar.field_content, wW(aiVar.field_msgType), this.context);
            replace = str.replace(10, ' ');
            if (aiVar.field_atCount > 0) {
            }
            if (!z) {
            }
            replace = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), replace});
            return j.a(this.context, replace, i);
        }
        replace = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_last_editing_msg_prefix));
        replace.setSpan(new ForegroundColorSpan(-5569532), 0, replace.length(), 33);
        replace.append(" ").append(j.a(this.context, aiVar.field_editingMsg, i));
        return replace;
    }

    private static String aaf(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zf(str);
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[]{Boolean.valueOf(this.unX), Boolean.valueOf(this.unY), str});
        if (!(com.tencent.mm.platformtools.ai.oW(str) || this.tEl == null)) {
            this.tEl.remove(str);
        }
        if (this.unX) {
            x.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[]{Boolean.valueOf(this.uok), Boolean.valueOf(this.uol.ciq())});
            this.uok = true;
            if (this.uol.ciq()) {
                cyI();
                return;
            }
            return;
        }
        this.unY = true;
    }

    private void cyI() {
        ah.A(new 2(this));
    }
}
