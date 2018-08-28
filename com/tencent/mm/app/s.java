package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.booter.notification.f;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.account.ui.LoginIndepPass;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.pluginsdk.ui.d.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.ContactRemarkInfoModUI;
import com.tencent.mm.ui.contact.ModRemarkNameUI;
import com.tencent.mm.ui.contact.SnsLabelContactListUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.tools.CountryCodeUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.widget.a.c;

public final class s implements m {
    public final void a(Intent intent, Context context) {
        if (context != null) {
            intent.setClassName(context, "com.tencent.mm.ui.contact.SayHiEditUI");
            context.startActivity(intent);
        }
    }

    public final void b(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            d.e(context, ".ui.tools.MultiStageCitySelectUI", intent);
        }
    }

    public final void c(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            d.b(context, "setting", ".ui.setting.EditSignatureUI", intent);
        }
    }

    public final void d(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            d.b(context, "profile", ".ui.ContactInfoUI", intent);
        }
    }

    public final void e(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            String stringExtra = intent.getStringExtra("Contact_User");
            if (stringExtra != null) {
                e.a(intent, stringExtra);
            }
            x.i("MicroMsg.WorkerUICallbackImpl", "startChattingUI %s %s", new Object[]{stringExtra, bi.cjd().toString()});
            intent.setClass(context, ChattingUI.class);
            context.startActivity(intent);
        }
    }

    public final void f(Intent intent, Context context) {
        if (context != null) {
            x.i("MicroMsg.WorkerUICallbackImpl with result", "startChattingUI %s", new Object[]{bi.cjd().toString()});
            intent.setClass(context, ChattingUI.class);
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 1);
            } else {
                context.startActivity(intent);
            }
        }
    }

    public final void g(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, BindMContactIntroUI.class);
            MMWizardActivity.D(context, intent);
        }
    }

    public final void h(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(context, BindQQUI.class);
            MMWizardActivity.D(context, intent);
        }
    }

    public final void i(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, LauncherUI.class).addFlags(67108864);
            context.startActivity(intent);
        }
    }

    public final void j(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public final void k(Intent intent, Context context) {
        q.f(context, intent.getBundleExtra("reportArgs"));
    }

    public final c bd(Context context) {
        return MMAppMgr.bd(context);
    }

    public final void l(Intent intent, Context context) {
        if (context != null) {
            if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
                intent.putExtra("Retr_Msg_Type", 4);
            }
            intent.setClass(context, MsgRetransmitUI.class);
            context.startActivity(intent);
        }
    }

    public final void m(Intent intent, Context context) {
        if (context != null) {
            intent.putExtra("Ksnsupload_type", 2);
            d.b(context, "sns", ".ui.SnsUploadUI", intent);
        }
    }

    public final void a(MMActivity mMActivity, String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        String string = mMActivity.getResources().getString(R.l.app_music);
        string = new StringBuffer(string).append(wXMediaMessage.title).toString();
        a aVar = new a(mMActivity);
        aVar.bZ(str2).TH(string).BX(R.l.confirm_dialog_share);
        aVar.g(Boolean.valueOf(true)).a(new 1(this, wXMediaMessage, str, str3, str2, mMActivity)).eIW.show();
    }

    public final void a(Intent intent, MMActivity mMActivity) {
        intent.setClass(mMActivity, SelectConversationUI.class);
        mMActivity.startActivityForResult(intent, 1);
    }

    public final void a(Intent intent, int i, MMActivity mMActivity, Intent intent2) {
        if (mMActivity != null) {
            intent.setClassName(mMActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
            au.HU();
            com.tencent.mm.ui.tools.a.a(mMActivity, intent2, intent, com.tencent.mm.model.c.Gb(), i);
        }
    }

    public final boolean b(Context context, String str, Bundle bundle) {
        return p.a.qyl.a(context, str, false, bundle);
    }

    public final void a(Activity activity, Intent intent, int i) {
        if (activity != null) {
            intent.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
            activity.startActivityForResult(intent, i);
        }
    }

    public final void a(Activity activity, Intent intent, Intent intent2, String str, int i, com.tencent.mm.ui.tools.a.a aVar) {
        if (activity != null) {
            intent2.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
            com.tencent.mm.ui.tools.a.b(activity, intent, intent2, str, i, aVar);
        }
    }

    public final void n(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, ContactRemarkInfoModUI.class);
            context.startActivity(intent);
        }
    }

    public final void o(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, ModRemarkNameUI.class);
            context.startActivity(intent);
        }
    }

    public final void a(Intent intent, Activity activity) {
        if (activity != null) {
            intent.setClass(activity, ModRemarkNameUI.class);
            activity.startActivityForResult(intent, 2);
        }
    }

    public final void b(Intent intent, Activity activity) {
        if (activity != null) {
            intent.setClass(activity, CountryCodeUI.class);
            activity.startActivityForResult(intent, 100);
        }
    }

    public final void p(Intent intent, Context context) {
        if (context != null) {
            d.b(context, "setting", ".ui.setting.SettingsLanguageUI", intent);
        }
    }

    public final void q(Intent intent, Context context) {
        if (intent != null && context != null) {
            intent.setClass(context, LauncherUI.class).addFlags(67108864);
            context.startActivity(intent);
        }
    }

    public final Intent be(Context context) {
        return new Intent(context, LauncherUI.class).addFlags(67108864);
    }

    public final void bf(Context context) {
        d.b(context, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
    }

    public final void r(Intent intent, Context context) {
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        d.b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
    }

    public final void s(Intent intent, Context context) {
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        com.tencent.mm.pluginsdk.d.eJ(context);
    }

    public final void t(Intent intent, Context context) {
        if (context != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            d.b(context, "subapp", ".ui.pluginapp.ContactSearchUI", intent2);
        }
    }

    public final void u(Intent intent, Context context) {
        if (context != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            d.b(context, "subapp", ".ui.pluginapp.ContactSearchResultUI", intent2);
        }
    }

    public final void a(Intent intent, Activity activity, int i) {
        if (activity != null) {
            intent.setClassName(activity, "com.tencent.mm.ui.contact.SnsAddressUI");
            activity.startActivityForResult(intent, i);
        }
    }

    public final void v(Intent intent, Context context) {
        intent.setClass(context, SnsLabelContactListUI.class);
        context.startActivity(intent);
    }

    public final void a(boolean z, boolean z2, Context context, String str, int i, int i2) {
        if (!z && !z2) {
            Intent intent = new Intent();
            intent.putExtra("VideoPlayer_File_nam", str);
            intent.putExtra("VideoRecorder_VideoLength", i);
            intent.putExtra("VideoRecorder_VideoSize", i2);
            d.b(context, "subapp", ".ui.video.VideoPlayerUI", intent);
        } else if (!com.tencent.mm.pluginsdk.h.b.a.a.b(str, context, z2)) {
            Toast.makeText(context, context.getString(R.l.video_play_export_file_error), 0).show();
        }
    }

    public final void bg(Context context) {
        d.b(context, "subapp", ".ui.openapi.AddAppUI", new Intent());
    }

    public final void d(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, ShowImageUI.class);
            context.startActivity(intent);
        }
    }

    public final void e(Context context, Intent intent) {
        if (context != null) {
            d.b(context, "account", ".security.ui.MySafeDeviceListUI", intent);
        }
    }

    public final void a(MMWizardActivity mMWizardActivity, Intent intent) {
        if (mMWizardActivity != null) {
            intent.setClass(mMWizardActivity, MobileInputUI.class);
            MMWizardActivity.D(mMWizardActivity, intent);
        }
    }

    public final void f(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, RegByMobileVoiceVerifyUI.class);
            context.startActivity(intent);
        }
    }

    public final void a(Context context, Intent intent, Intent intent2) {
        if (context != null) {
            int intExtra = intent.getIntExtra("from_source", 1);
            if (intExtra == 1) {
                intent.setClass(context, LoginUI.class);
                context.startActivity(intent);
            } else if (intExtra == 2) {
                intent.setClass(context, LoginPasswordUI.class);
                context.startActivity(intent);
            } else if (intExtra == 3) {
                intent.setClass(context, SimpleLoginUI.class);
                if (intent2 != null) {
                    MMWizardActivity.b(context, intent, intent2);
                } else {
                    MMWizardActivity.D(context, intent);
                }
            } else if (intExtra == 5) {
                intent.setClass(context, LoginIndepPass.class);
                context.startActivity(intent);
            } else if (intExtra == 6) {
                intent.setClass(context, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("mobile_auth_type", 7);
                context.startActivity(intent);
            }
        }
    }

    public final void g(Context context, Intent intent) {
        if (context != null) {
            d.a(context, "account", ".security.ui.SecurityAccountIntroUI", intent);
        }
    }

    public final void h(Context context, Intent intent) {
        if (context != null) {
            intent.setClassName(context, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
            context.startActivity(intent);
        }
    }

    public final boolean b(Context context, String str, Object... objArr) {
        return p.a.qyl.c(context, str, objArr);
    }

    public final void a(Intent intent, MMActivity.a aVar, MMActivity mMActivity) {
        if (mMActivity != null) {
            intent.setClassName(mMActivity, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
            mMActivity.b(aVar, intent, 8);
        }
    }

    public final void vo() {
        MMAppMgr.vo();
    }

    public final void cancelNotification(String str) {
        f.a.ya();
        if (str != null) {
            int id = b.yb().getId(str);
            x.d("MicroMsg.Notification.Handle", "cancel : %s", new Object[]{str});
            b.yb().cancel(id);
        }
    }

    public final void s(Context context, String str) {
        p.a.qyl.a(context, str, true);
    }
}
