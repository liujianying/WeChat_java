package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.MMWizardActivity;

public final class k extends b {
    protected bb usp = null;

    static /* synthetic */ void v(Context context, boolean z) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 8);
            intent.putExtra("is_bind_for_contact_sync", z);
            intent.putExtra("KEnterFromBanner", true);
            MMWizardActivity.D(context, intent);
            e iP = g.IW().iP("4");
            if (iP != null && !bi.oW(iP.value) && (iP.value.equals("1") || iP.value.equals("2"))) {
                g.IW().iP("4").result = "1";
                f.iU("4");
                if (iP.value.equals("1")) {
                    au.HU();
                    c.DT().set(328195, Boolean.valueOf(true));
                    return;
                }
                au.HU();
                c.DT().set(328196, Boolean.valueOf(true));
            } else if (z) {
                h.mEJ.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
            } else {
                h.mEJ.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            }
        }
    }

    public k(Context context, bb bbVar) {
        super(context);
        this.usp = bbVar;
        if (this.view != null) {
            OnClickListener 3;
            MMImageView mMImageView = (MMImageView) this.view.findViewById(R.h.mainframe_banner_icon);
            TextView textView = (TextView) this.view.findViewById(R.h.mainframe_banner_text);
            switch (this.usp.type) {
                case 1:
                    mMImageView.setImageResource(R.k.userguide_bindmb_icon);
                    textView.setText(R.l.banner_bind_mobile_hint);
                    break;
                case 2:
                    mMImageView.setImageResource(R.k.userguide_contacts_icon);
                    textView.setText(R.l.find_mcontact_add_frined_btn);
                    break;
                case 3:
                    mMImageView.setImageResource(R.k.userguide_avatar_icon);
                    textView.setText(R.l.banner_upload_avatar_hint);
                    break;
                case 4:
                    mMImageView.setImageResource(R.k.userguide_nearfriends_icon);
                    textView.setText(R.l.banner_meet_nearby_hint);
                    break;
                case 6:
                    mMImageView.setImageResource(R.k.userguide_emostore_icon);
                    textView.setText(R.l.banner_open_sticker_shop_hint);
                    break;
                case 7:
                    mMImageView.setImageResource(R.k.userguide_gamecenter_icon);
                    textView.setText(R.l.banner_open_games_hint);
                    break;
                case 8:
                    mMImageView.setImageResource(R.k.userguide_grounpmessage_icon);
                    textView.setText(R.l.banner_send_broadcast_message_hint);
                    break;
                case 9:
                    mMImageView.setImageResource(R.k.userguide_moments_icon);
                    textView.setText(R.l.banner_moments_timeline_hint);
                    break;
                case 10:
                    mMImageView.setImageResource(R.k.userguide_autoadd_icon);
                    textView.setText(R.l.banner_auto_add_friends_hint);
                    break;
            }
            View view = this.view;
            int i = this.usp.type;
            int i2 = this.usp.showType;
            switch (i) {
                case 1:
                    3 = new 3(this, i, i2);
                    break;
                case 2:
                    3 = new 4(this, i, i2);
                    break;
                case 3:
                    3 = new 2(this, i, i2);
                    break;
                case 4:
                    3 = new 1(this, i, i2);
                    break;
                case 6:
                    3 = new 5(this, i, i2);
                    break;
                case 7:
                    3 = new 6(this, i, i2);
                    break;
                case 8:
                    3 = new 7(this, i, i2);
                    break;
                case 9:
                    3 = new 8(this, i, i2);
                    break;
                case 10:
                    3 = new 9(this, i, i2);
                    break;
                default:
                    3 = null;
                    break;
            }
            view.setOnClickListener(3);
        }
    }

    public final int getLayoutId() {
        return R.i.mainframe_banner_header_view;
    }

    public final void destroy() {
    }
}
