package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public final class a {
    public static final SparseArray<a> mOe;

    static {
        SparseArray sparseArray = new SparseArray();
        mOe = sparseArray;
        sparseArray.put(19, new a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
        mOe.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte) 0));
        mOe.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
        mOe.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
        mOe.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
        mOe.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
        mOe.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
        mOe.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
        mOe.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
        mOe.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
        mOe.put(23, new a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
        mOe.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
        mOe.put(24, new a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
        mOe.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
        mOe.put(28, new a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
        mOe.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
        mOe.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
        mOe.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
        mOe.put(35, new a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
        mOe.put(38, new a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
        mOe.put(39, new a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
        mOe.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
        mOe.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
        mOe.put(42, new a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
        mOe.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
        mOe.put(43, new a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
        mOe.put(50, new a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
        mOe.put(51, new a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
    }

    private static boolean aH(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        d.b(context, "profile", ".ui.ContactInfoUI", intent);
        return true;
    }

    public static boolean L(Context context, int i) {
        if (mOe.indexOfKey(i) < 0) {
            return false;
        }
        if (i == 30 && (com.tencent.mm.p.a.bx(context) || com.tencent.mm.p.a.bw(context))) {
            return false;
        }
        a aVar = (a) mOe.get(i);
        if (aVar.mOf != -1 && (q.GQ() & aVar.mOf) != 0) {
            return aH(context, aVar.username);
        }
        if (!bi.oW(aVar.mOg)) {
            Intent intent = new Intent();
            if (i == 28) {
                intent.putExtra("type", 20);
            }
            if (i == 1) {
                intent.putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
            }
            intent.putExtra("animation_pop_in", aVar.mOh);
            if (i == 32) {
                h.mEJ.h(12065, new Object[]{Integer.valueOf(6)});
            }
            if (i == 6) {
                intent.putExtra("pay_channel", 15);
            }
            if (i == 31) {
                intent.putExtra("game_report_from_scene", 4);
            }
            if (i == 41) {
                intent.putExtra("key_from_scene", 5);
            }
            if (i == 42) {
                intent.putExtra("key_from_scene", 4);
            }
            if (i == 33) {
                b.a(context, ".ui.FavoriteIndexUI", new Intent());
            } else if (i == 35) {
                intent.setClassName(context, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
                MMWizardActivity.D(context, intent);
            } else if (aVar.mOg.equals("app")) {
                d.e(context, aVar.uri, intent);
            } else {
                d.b(context, aVar.mOg, aVar.uri, intent);
            }
            com.tencent.mm.ui.base.b.E(context, intent);
            return true;
        } else if (aVar.uri.equals(".ui.chatting.ChattingUI")) {
            String str = aVar.username;
            if (com.tencent.mm.l.a.gd(((i) g.l(i.class)).FR().Yg(str).field_type)) {
                Intent intent2 = new Intent();
                intent2.putExtra("Chat_User", str);
                intent2.putExtra("finish_direct", true);
                d.e(context, ".ui.chatting.ChattingUI", intent2);
            } else {
                aH(context, str);
            }
            return true;
        } else if (aVar.uri.equals(".plugin.profile.ui.ContactInfoUI")) {
            return aH(context, aVar.username);
        } else {
            x.e("MicroMsg.Feature", "Error URI of android feature");
            return false;
        }
    }
}
