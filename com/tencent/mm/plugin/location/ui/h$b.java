package com.tencent.mm.plugin.location.ui;

import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class h$b {
    private LayoutParams jUD;
    final /* synthetic */ h kFD;
    boolean kFG = false;
    a kFH;
    String username;

    class a {
        ImageView eDn;
        RelativeLayout kFI;

        a() {
        }
    }

    public h$b(h hVar, String str) {
        this.kFD = hVar;
        this.username = str;
        if (bi.oW(str)) {
            x.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
            return;
        }
        this.kFH = new a();
        LayoutInflater layoutInflater = (LayoutInflater) this.kFD.context.getSystemService("layout_inflater");
        this.kFH.kFI = (RelativeLayout) layoutInflater.inflate(f.location_share_header_avatar_layout, null);
        this.kFH.eDn = (ImageView) this.kFH.kFI.findViewById(e.avatar);
        b.n(this.kFH.eDn, this.username);
        this.kFH.kFI.setTag(this.username);
        this.jUD = new LayoutParams(-2, -2);
        this.jUD.leftMargin = BackwardSupportUtil.b.b(this.kFD.context, 5.0f);
        this.jUD.rightMargin = BackwardSupportUtil.b.b(this.kFD.context, 5.0f);
        this.jUD.gravity = 17;
    }

    public final void aZD() {
        x.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[]{this.username});
        this.kFH.kFI.setBackgroundResource(d.location_share_avatar_bg_hl);
        this.kFH.kFI.invalidate();
        this.kFG = true;
    }

    public final void aZE() {
        x.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[]{this.username});
        this.kFH.kFI.setBackgroundResource(d.location_share_avatar_bg);
        this.kFH.kFI.invalidate();
        this.kFG = false;
    }
}
