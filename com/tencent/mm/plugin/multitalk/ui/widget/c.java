package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class c implements OnClickListener {
    private TextView hoe;
    private MultiTalkMainUI lvs;
    private View lvt;
    private TextView lvu;
    private ImageView lvv;
    private LinearLayout lvw;
    private ImageButton lvx;
    private ImageButton lvy;

    public c(MultiTalkMainUI multiTalkMainUI) {
        this.lvs = multiTalkMainUI;
        this.lvt = multiTalkMainUI.findViewById(R.h.invite_layout);
        this.lvu = (TextView) multiTalkMainUI.findViewById(R.h.invite_main_nickname_tv);
        this.lvv = (ImageView) multiTalkMainUI.findViewById(R.h.invite_main_avatar_iv);
        this.lvw = (LinearLayout) multiTalkMainUI.findViewById(R.h.small_avatar_iv_container);
        this.hoe = (TextView) multiTalkMainUI.findViewById(R.h.introduce_tv);
        this.lvx = (ImageButton) multiTalkMainUI.findViewById(R.h.invite_pickup_btn);
        this.lvy = (ImageButton) multiTalkMainUI.findViewById(R.h.invite_hangup_btn);
        this.lvx.setOnClickListener(this);
        this.lvy.setOnClickListener(this);
    }

    public final void n(MultiTalkGroup multiTalkGroup) {
        int i;
        this.lvt.setVisibility(0);
        String bgD = i.bgD();
        List arrayList = new ArrayList();
        if (!bi.oW(bgD)) {
            for (i = 0; i < multiTalkGroup.vgq.size(); i++) {
                if (!((MultiTalkGroupMember) multiTalkGroup.vgq.get(i)).vgr.equals(bgD)) {
                    arrayList.add(((MultiTalkGroupMember) multiTalkGroup.vgq.get(i)).vgr);
                }
            }
            this.lvu.setText(j.a(this.lvs, r.gT(bgD)));
            b.a(this.lvv, bgD, 0.1f, true);
        }
        if (arrayList.size() > 0) {
            this.hoe.setVisibility(0);
            this.hoe.setText(R.l.multitalk_member_wording);
            this.lvw.setVisibility(0);
            this.lvw.removeAllViews();
            for (i = 0; i < arrayList.size(); i++) {
                View imageView = new ImageView(this.lvs.mController.tml);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(b.lvl, b.lvl);
                if (i != 0) {
                    layoutParams.leftMargin = b.lvj;
                }
                imageView.setLayoutParams(layoutParams);
                this.lvw.addView(imageView);
                b.a(imageView, (String) arrayList.get(i), 0.1f, false);
            }
            return;
        }
        this.hoe.setVisibility(8);
        this.lvw.setVisibility(8);
    }

    public final void bgT() {
        this.lvt.setVisibility(8);
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.invite_hangup_btn) {
            o.bgN().g(true, false, false);
        } else if (view.getId() == R.h.invite_pickup_btn) {
            e bgN = o.bgN();
            if (bgN.bgl()) {
                x.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s", new Object[]{i.h(bgN.ltt)});
                o.bgM().lta.B(bgN.ltt.vgm, bgN.ltt.vcc, bgN.ltt.vgo);
                return;
            }
            x.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
    }
}
