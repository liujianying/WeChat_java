package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.api.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e$a;

public final class c {
    public static void a(Intent intent, bja bja, int i) {
        ((h) g.l(h.class)).a(intent, bja, i);
    }

    public static void a(Intent intent, bjp bjp, int i) {
        intent.putExtra("Contact_User", bjp.hbL);
        intent.putExtra("Contact_Nick", bjp.hcS);
        intent.putExtra("Contact_PyInitial", bjp.ruh);
        intent.putExtra("Contact_QuanPin", bjp.rui);
        intent.putExtra("Contact_Sex", bjp.eJH);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra(e$a.ths, bjp.rEJ);
        intent.putExtra("key_add_contact_openim_appid", bjp.jQb);
        intent.putExtra("key_add_contact_match_type", bjp.sjj);
        intent.putExtra("key_add_contact_custom_detail_visible", bjp.sjA.saT);
        intent.putExtra("key_add_contact_custom_detail", bjp.sjA.jQf);
        intent.putExtra("key_add_contact_desc_wording_id", bjp.sjC);
        intent.putExtra("key_add_contact_desc_icon", bjp.sjB);
        x.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[]{bjp.rEJ});
    }
}
