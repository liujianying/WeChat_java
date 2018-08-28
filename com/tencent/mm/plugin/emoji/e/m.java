package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    public static void a(Context context, ts tsVar, int i, int i2, int i3, String str, int i4) {
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        if (tsVar != null) {
            intent.putExtra("extra_id", tsVar.rem);
            intent.putExtra("extra_name", tsVar.rwQ);
            intent.putExtra("extra_copyright", tsVar.rxa);
            intent.putExtra("extra_coverurl", tsVar.rwY);
            intent.putExtra("extra_description", tsVar.rwR);
            intent.putExtra("extra_price", tsVar.rwT);
            intent.putExtra("extra_type", tsVar.rwU);
            intent.putExtra("extra_flag", tsVar.rwV);
            intent.putExtra("preceding_scence", i4);
            intent.putExtra("call_by", 1);
            intent.putExtra("check_clickflag", false);
            intent.putExtra("download_entrance_scene", i);
            if (i2 != -1) {
                intent.putExtra("extra_status", i2);
            }
            if (i3 != -1) {
                intent.putExtra("extra_progress", -1);
            }
            if (!bi.oW(str)) {
                intent.putExtra("to_talker_name", str);
            }
        } else {
            x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
        }
        context.startActivity(intent);
    }

    private static void a(Context context, tj tjVar, int i, int i2) {
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", tjVar.rem);
        intent.putExtra("extra_name", tjVar.bHD);
        intent.putExtra("extra_description", tjVar.jOS);
        intent.putExtra("preceding_scence", i2);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", i);
        intent.putExtra("check_clickflag", true);
        context.startActivity(intent);
    }

    public static void a(Context context, tj tjVar, boolean z) {
        if (tjVar == null) {
            x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
            return;
        }
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        Intent intent;
        switch (tjVar.rwJ) {
            case 0:
                x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
                h.mEJ.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(tjVar.bzI), tjVar.bHD, Integer.valueOf(0), Integer.valueOf(0)});
                return;
            case 1:
                if (z) {
                    a(context, tjVar, 15, 8);
                } else {
                    a(context, tjVar, 3, 5);
                }
                h.mEJ.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(tjVar.bzI), tjVar.bHD, Integer.valueOf(0), Integer.valueOf(4)});
                return;
            case 2:
                String str5 = tjVar.rwH;
                str = tjVar.bHD;
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str5);
                intent2.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, str);
                b.ezn.j(intent2, context);
                h.mEJ.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(tjVar.bzI), tjVar.bHD, Integer.valueOf(0), Integer.valueOf(3)});
                return;
            case 3:
                i = tjVar.bzI;
                str = tjVar.bHD;
                str2 = tjVar.jOS;
                str3 = tjVar.jPG;
                str4 = tjVar.rwI;
                intent = new Intent();
                intent.setClass(context, EmojiStoreTopicUI.class);
                intent.putExtra("topic_id", i);
                intent.putExtra("topic_name", str);
                intent.putExtra("topic_ad_url", str4);
                intent.putExtra("topic_icon_url", str3);
                intent.putExtra("topic_desc", str2);
                if (z) {
                    intent.putExtra("extra_scence", 15);
                } else {
                    intent.putExtra("extra_scence", 3);
                }
                context.startActivity(intent);
                h.mEJ.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(tjVar.bzI), tjVar.bHD, Integer.valueOf(0), Integer.valueOf(2)});
                return;
            case 4:
                i = tjVar.bzI;
                str = tjVar.bHD;
                str2 = tjVar.jOS;
                str3 = tjVar.jPG;
                str4 = tjVar.rwI;
                intent = new Intent();
                intent.putExtra("set_id", i);
                intent.putExtra("headurl", str4);
                intent.putExtra("set_title", str);
                intent.putExtra("set_iconURL", str3);
                intent.putExtra("set_desc", str2);
                intent.setClass(context, EmojiStoreV2SingleProductUI.class);
                context.startActivity(intent);
                h.mEJ.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(tjVar.bzI), tjVar.bHD, Integer.valueOf(0), Integer.valueOf(1)});
                return;
            default:
                x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", new Object[]{Integer.valueOf(tjVar.rwJ)});
                return;
        }
    }
}
