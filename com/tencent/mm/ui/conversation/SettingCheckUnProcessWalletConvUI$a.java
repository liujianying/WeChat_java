package com.tencent.mm.ui.conversation;

import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.tools.r;
import java.util.HashMap;

class SettingCheckUnProcessWalletConvUI$a extends BaseAdapter {
    private float tEh = -1.0f;
    protected float tEi = -1.0f;
    private float tEj = -1.0f;
    private ColorStateList[] tEk = new ColorStateList[5];
    private HashMap<String, a> tEl;
    private final int uog;
    private final int uoh;
    final /* synthetic */ SettingCheckUnProcessWalletConvUI urE;

    public SettingCheckUnProcessWalletConvUI$a(SettingCheckUnProcessWalletConvUI settingCheckUnProcessWalletConvUI) {
        this.urE = settingCheckUnProcessWalletConvUI;
        this.tEk[0] = a.ac(settingCheckUnProcessWalletConvUI, R.e.hint_text_color);
        this.tEk[1] = a.ac(settingCheckUnProcessWalletConvUI, R.e.mm_list_textcolor_unread);
        this.tEk[3] = a.ac(settingCheckUnProcessWalletConvUI, R.e.normal_text_color);
        this.tEk[2] = a.ac(settingCheckUnProcessWalletConvUI, R.e.mm_list_textcolor_three);
        this.tEk[2] = a.ac(settingCheckUnProcessWalletConvUI, R.e.mm_list_textcolor_three);
        this.tEk[4] = a.ac(settingCheckUnProcessWalletConvUI, R.e.light_text_color);
        if (a.fi(settingCheckUnProcessWalletConvUI)) {
            this.uoh = settingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
            this.uog = settingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
        } else {
            this.uoh = settingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
            this.uog = settingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth);
        }
        this.tEh = (float) a.ad(settingCheckUnProcessWalletConvUI, R.f.NormalTextSize);
        this.tEi = (float) a.ad(settingCheckUnProcessWalletConvUI, R.f.HintTextSize);
        this.tEj = (float) a.ad(settingCheckUnProcessWalletConvUI, R.f.SmallestTextSize);
        this.tEl = new HashMap();
    }

    public final int getCount() {
        return SettingCheckUnProcessWalletConvUI.d(this.urE).size();
    }

    /* renamed from: FU */
    public final ai getItem(int i) {
        String str = (String) SettingCheckUnProcessWalletConvUI.d(this.urE).get(i);
        au.HU();
        return c.FW().Yq(str);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View inflate;
        if (view == null) {
            bVar = new b(this, (byte) 0);
            if (a.fi(this.urE)) {
                inflate = View.inflate(this.urE, R.i.conversation_item_large, null);
            } else {
                inflate = View.inflate(this.urE, R.i.conversation_item, null);
            }
            bVar.eCl = (ImageView) inflate.findViewById(R.h.avatar_iv);
            bVar.tEp = (NoMeasuredTextView) inflate.findViewById(R.h.nickname_tv);
            bVar.uoC = (NoMeasuredTextView) inflate.findViewById(R.h.source_tv);
            bVar.tEq = (NoMeasuredTextView) inflate.findViewById(R.h.update_time_tv);
            bVar.tEr = (NoMeasuredTextView) inflate.findViewById(R.h.last_msg_tv);
            bVar.hkV = (TextView) inflate.findViewById(R.h.tipcnt_tv);
            bVar.hkV.setBackgroundResource(r.hd(this.urE));
            bVar.tEs = (ImageView) inflate.findViewById(R.h.image_mute);
            bVar.tEu = inflate.findViewById(R.h.avatar_prospect_iv);
            bVar.tEt = (ImageView) inflate.findViewById(R.h.talkroom_iv);
            bVar.uoD = (ImageView) inflate.findViewById(R.h.location_share_iv);
            inflate.setTag(bVar);
            bVar.tEr.setTextSize(0, this.tEi);
            bVar.tEq.setTextSize(0, this.tEj);
            bVar.tEp.setTextSize(0, this.tEh);
            bVar.uoC.setTextSize(0, this.tEi);
            bVar.tEr.setTextColor(this.tEk[0]);
            bVar.tEq.setTextColor(this.tEk[4]);
            bVar.tEp.setTextColor(this.tEk[3]);
            bVar.uoC.setTextColor(this.tEk[0]);
            bVar.tEr.setShouldEllipsize(true);
            bVar.tEq.setShouldEllipsize(false);
            bVar.tEp.setShouldEllipsize(true);
            bVar.uoC.setShouldEllipsize(true);
            bVar.tEq.setGravity(5);
        } else {
            bVar = (b) view.getTag();
            inflate = view;
        }
        ai FU = getItem(i);
        if (FU != null) {
            b.a(bVar.eCl, FU.field_username);
            bVar.eCl.getDrawable();
            String str = FU.field_username;
            a aVar = (a) this.tEl.get(str);
            if (aVar == null) {
                String str2;
                int i2;
                a aVar2 = new a(this, (byte) 0);
                aVar2.uot = -1;
                aVar2.uos = -1;
                aVar2.uox = false;
                aVar2.uoz = false;
                aVar2.uoy = false;
                aVar2.qpi = s.fq(FU.field_username);
                boolean z = aVar2.qpi && aVar2.uoy && FU.field_unReadCount > 0;
                aVar2.uow = z;
                aVar2.hER = 0;
                if (wW(FU.field_msgType) == 34 && FU.field_isSend == 0 && !com.tencent.mm.platformtools.ai.oW(FU.field_content)) {
                    str2 = FU.field_content;
                    if (str.equals("qmessage") || str.equals("floatbottle")) {
                        String[] split = str2.split(":");
                        if (split != null && split.length > 3) {
                            str2 = split[1] + ":" + split[2] + ":" + split[3];
                        }
                    }
                    if (!new n(str2).enG) {
                        aVar2.hER = 1;
                    }
                }
                str2 = com.tencent.mm.model.r.gT(str);
                if (aVar2.qpi && str2 == null) {
                    aVar2.nickName = this.urE.getString(R.l.chatting_roominfo_noname);
                } else {
                    aVar2.nickName = j.a(this.urE, com.tencent.mm.model.r.gT(str), bVar.tEp.getTextSize());
                }
                aVar2.uop = h(FU);
                aVar2.uoq = c(FU, (int) bVar.tEr.getTextSize(), aVar2.uow);
                aVar2.uoA = FU.field_attrflag;
                switch (FU.field_status) {
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
                aVar2.uor = i2;
                aVar2.uou = s.a(FU);
                au.HU();
                aVar2.tEm = c.FW().g(FU);
                aVar2.uov = false;
                aVar2.qBs = w.chL();
                this.tEl.put(str, aVar2);
                aVar = aVar2;
            }
            if (aVar.uop == null) {
                aVar.uop = h(FU);
            }
            if (aVar.uow || s.hE(FU.field_parentRef)) {
                bVar.tEr.setTextColor(this.tEk[0]);
            } else {
                bVar.tEr.setTextColor(this.tEk[aVar.hER]);
            }
            if (str.toLowerCase().endsWith("@t.qq.com")) {
                bVar.tEp.setCompoundRightDrawablesWithIntrinsicBounds(R.g.icon_tencent_weibo);
                bVar.tEp.setDrawRightDrawable(true);
            } else {
                bVar.tEp.setDrawRightDrawable(false);
            }
            int i3 = aVar.uor;
            if (i3 != -1) {
                bVar.tEr.setCompoundLeftDrawablesWithIntrinsicBounds(i3);
                bVar.tEr.setDrawLeftDrawable(true);
            } else {
                bVar.tEr.setDrawLeftDrawable(false);
            }
            bVar.tEp.setText(aVar.nickName);
            bVar.uoC.setVisibility(8);
            LayoutParams layoutParams = bVar.tEq.getLayoutParams();
            if (aVar.uop.length() > 9) {
                if (layoutParams.width != this.uoh) {
                    layoutParams.width = this.uoh;
                    bVar.tEq.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.width != this.uog) {
                layoutParams.width = this.uog;
                bVar.tEq.setLayoutParams(layoutParams);
            }
            x.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[]{Integer.valueOf(layoutParams.width)});
            bVar.tEq.setText(aVar.uop);
            bVar.tEr.setText(aVar.uoq);
            if (aVar.qpi && aVar.uoy) {
                bVar.tEs.setVisibility(0);
            } else if (aVar.uov) {
                bVar.tEs.setVisibility(0);
            } else {
                bVar.tEs.setVisibility(8);
            }
            b.a(bVar.eCl, str);
            if (!aVar.uou && aVar.tEm && au.HX()) {
                au.HU();
                c.FW().f(FU);
            }
            if (!aVar.tEm || FU.field_conversationTime == -1) {
                inflate.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
            } else {
                inflate.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
            }
            bVar.tEt.setVisibility(8);
        }
        return inflate;
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

    private CharSequence h(ai aiVar) {
        if (aiVar.field_status == 1) {
            return this.urE.getString(R.l.main_sending);
        }
        return aiVar.field_conversationTime == Long.MAX_VALUE ? "" : h.c(this.urE, aiVar.field_conversationTime, true);
    }

    private CharSequence c(ai aiVar, int i, boolean z) {
        CharSequence replace;
        if (com.tencent.mm.platformtools.ai.oW(aiVar.field_editingMsg) || (aiVar.field_atCount > 0 && aiVar.field_unReadCount > 0)) {
            CharSequence charSequence = aiVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(j.c(this.urE, charSequence, (float) i));
            }
            int i2;
            String str;
            String str2 = aiVar.field_username;
            if (str2.equals("qqmail")) {
                au.HU();
                if (com.tencent.mm.platformtools.ai.f((Integer) c.DT().get(17, null)) == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    return this.urE.getString(R.l.settings_plugins_disable);
                }
            }
            if (str2.equals("tmessage")) {
                au.HU();
                bl Hg = c.FZ().Hg("@t.qq.com");
                if (Hg == null || !Hg.isEnable()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 == 0) {
                    return this.urE.getString(R.l.settings_plugins_disable);
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
                str2 = this.urE.getString(R.l.app_emoji);
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
                        replace = this.urE.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), replace});
                    } else if (aiVar.field_unReadCount > 1 && s.hE(aiVar.field_parentRef)) {
                        replace = this.urE.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), replace});
                    }
                    return j.a(this.urE, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.urE.getString(R.l.main_conversation_chatroom_at_hint));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(j.a(this.urE, replace, i));
                return spannableStringBuilder;
            }
            str = com.tencent.mm.booter.notification.a.h.a(aiVar.field_isSend, aiVar.field_username, aiVar.field_content, wW(aiVar.field_msgType), this.urE);
            replace = str.replace(10, ' ');
            if (aiVar.field_atCount > 0) {
            }
            if (!z) {
            }
            replace = this.urE.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), replace});
            return j.a(this.urE, replace, i);
        }
        replace = new SpannableStringBuilder(this.urE.getString(R.l.main_conversation_last_editing_msg_prefix));
        replace.setSpan(new ForegroundColorSpan(-5569532), 0, replace.length(), 33);
        replace.append(" ").append(j.a(this.urE, aiVar.field_editingMsg, i));
        return replace;
    }

    private static String aaf(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zf(str);
    }
}
