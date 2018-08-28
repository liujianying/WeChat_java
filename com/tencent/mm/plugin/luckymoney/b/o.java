package com.tencent.mm.plugin.luckymoney.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.f;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.f.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.g$a;
import com.tencent.mm.y.h;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONObject;

public final class o {
    private static f<String, Bitmap> jaR = new f(10);
    public static int kQG = Integer.MAX_VALUE;

    public static String i(Context context, long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= 86400000) {
            return new SimpleDateFormat("HH:mm:ss").format(new Date(j));
        }
        Time time = new Time();
        time.set(j);
        return g.a(context.getString(i.fmt_datetime, new Object[]{" "}), time).toString();
    }

    public static void i(ImageView imageView, String str) {
        a(imageView, str, null, true);
    }

    public static void a(ImageView imageView, String str, String str2, boolean z) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bi.oW(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.bat();
                aVar.dXB = com.tencent.mm.plugin.luckymoney.a.a.bav();
                aVar.dXy = true;
                aVar.dXV = true;
                aVar.dXW = z;
                if (z) {
                    aVar.dXX = 0.0f;
                }
                if (bi.oW(str2)) {
                    aVar.dXG = false;
                } else {
                    aVar.bKg = str2;
                    aVar.dXG = true;
                }
                com.tencent.mm.ak.o.Pj().a(str, imageView, aVar.Pt());
            }
        }
    }

    public static void g(ImageView imageView, String str) {
        a(imageView, str, null, false);
    }

    public static void d(ImageView imageView, String str, int i) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bi.oW(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.bat();
                aVar.dXB = com.tencent.mm.plugin.luckymoney.a.a.bav();
                aVar.dXy = true;
                aVar.dXV = true;
                aVar.dXW = false;
                if (i != 0) {
                    aVar.dXN = i;
                }
                com.tencent.mm.ak.o.Pj().a(str, imageView, aVar.Pt());
            }
        }
    }

    public static void a(ImageView imageView, String str, String str2) {
        if (imageView != null) {
            if (bi.oW(str2)) {
                str2 = q.KJ().jR(str);
            }
            b.a(imageView, str2, 0.1f, false);
        }
    }

    public static void e(ImageView imageView, String str, int i) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bi.oW(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.bat();
                aVar.dXB = com.tencent.mm.plugin.luckymoney.a.a.bav();
                aVar.dXy = true;
                aVar.dXV = true;
                aVar.dXW = true;
                aVar.dXD = 1;
                if (i != 0) {
                    aVar.dXN = i;
                }
                com.tencent.mm.ak.o.Pj().a(str, imageView, aVar.Pt());
            }
        }
    }

    public static void a(Context context, TextView textView, String str) {
        if (textView != null) {
            textView.setText(j.a(context, str, textView.getTextSize()));
        }
    }

    public static void a(MMActivity mMActivity, int i, int i2, boolean z) {
        if (i != 0 || i2 <= 1) {
            a(mMActivity, 2, z);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(mMActivity, SelectLuckyMoneyContactUI.class);
        intent.putExtra("key_friends_num", i2);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        mMActivity.startActivityForResult(intent, 2);
    }

    public static void a(MMActivity mMActivity, int i, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        d.b(mMActivity, ".ui.transmit.SelectConversationUI", intent, i);
    }

    public static String baX() {
        com.tencent.mm.kernel.g.Ek();
        return (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sPv, null);
    }

    public static String Gd(String str) {
        com.tencent.mm.aa.j kc = q.KH().kc(str);
        if (kc != null) {
            return kc.Ky();
        }
        com.tencent.mm.kernel.g.Ek();
        ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(str);
        if (Yg == null || !Yg.field_username.equals(str) || Yg.csA == 4) {
            return null;
        }
        com.tencent.mm.kernel.g.Ek();
        byte[] Yk = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yk(str);
        if (bi.bC(Yk)) {
            return null;
        }
        String str2;
        try {
            str2 = ((aue) new aue().aG(Yk)).rra;
        } catch (Throwable e) {
            x.e("MicroMsg.LuckyMoneyUtil", "exception:%s", new Object[]{bi.i(e)});
            str2 = null;
        }
        return str2;
    }

    public static String gS(String str) {
        com.tencent.mm.kernel.g.Ek();
        ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(str);
        if (Yg == null || !Yg.field_username.equals(str)) {
            return null;
        }
        return Yg.field_nickname;
    }

    public static int dM(Context context) {
        if (kQG == Integer.MAX_VALUE) {
            kQG = context.getResources().getColor(c.lucky_money_err_color);
        }
        return kQG;
    }

    public static void a(View view, AnimationListener animationListener) {
        Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new 1(view, scaleAnimation2));
        if (animationListener != null) {
            scaleAnimation2.setAnimationListener(animationListener);
        }
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
    }

    public static void a(Button button) {
        b(button);
    }

    public static void b(Button button) {
        if (button != null) {
            button.setBackgroundResource(e.festival_lucky_money_open_btn_ani);
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.start();
            }
        }
    }

    public static void c(Button button) {
        if (button != null && (button.getBackground() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public static boolean C(String str, String str2, int i) {
        if (bi.oW(str) || bi.oW(str2)) {
            x.w("MicroMsg.LuckyMoneyUtil", bi.oV(str) + ", " + bi.oV(str2));
            return false;
        }
        bd bdVar = new bd();
        bdVar.setContent(str);
        bdVar.setStatus(2);
        bdVar.ep(str2);
        bdVar.ay(com.tencent.mm.model.bd.iD(str2));
        bdVar.eX(1);
        if (i == 3) {
            bdVar.setType(469762097);
        } else {
            bdVar.setType(436207665);
        }
        long T = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().T(bdVar);
        if (T < 0) {
            x.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.g.Ac() + "insert msg failed :" + T);
            return false;
        }
        if (bdVar.aQm()) {
            com.tencent.mm.modelstat.b.ehL.a(bdVar, h.g(bdVar));
        } else {
            com.tencent.mm.modelstat.b.ehL.f(bdVar);
        }
        bdVar.setMsgId(T);
        com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
        gVar.field_xml = bdVar.field_content;
        String WT = bi.WT(str);
        g$a g_a = null;
        if (WT != null) {
            g_a = g$a.J(WT, bdVar.field_reserved);
            if (g_a != null) {
                gVar.field_title = g_a.title;
                gVar.field_description = g_a.description;
            }
        }
        gVar.field_type = 2001;
        gVar.field_msgId = T;
        if (g_a != null && g_a.type == 2001 && g_a.showType == 1) {
            if (TextUtils.isEmpty(g_a.dyf) || TextUtils.isEmpty(g_a.dyg) || g_a.dyh <= 0) {
                x.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
            } else {
                x.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
                ai aiVar = new ai();
                aiVar.bHG = new ai.a();
                aiVar.bHG.bHI = g_a.dyg;
                aiVar.bHG.bHH = g_a.dyf;
                aiVar.bHG.bHJ = g_a.dyh;
                com.tencent.mm.sdk.b.a.sFg.m(aiVar);
            }
        }
        com.tencent.mm.y.g fI = com.tencent.mm.plugin.ac.a.bmg().fI(T);
        if (fI != null && fI.field_msgId == T) {
            com.tencent.mm.plugin.ac.a.bmg().c(gVar, new String[0]);
        } else if (!com.tencent.mm.plugin.ac.a.bmg().b(gVar)) {
            x.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:" + T);
        }
        return true;
    }

    public static boolean a(Activity activity, int i, l lVar, Bundle bundle, boolean z, int i2) {
        x.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
        if (i == TbsListener$ErrorCode.INFO_USE_BACKUP_FILE_INSTALL_BY_SERVER) {
            return a(activity, lVar, bundle, z, i2);
        }
        x.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
        return false;
    }

    private static boolean a(Activity activity, l lVar, Bundle bundle, boolean z, int i) {
        JSONObject jSONObject;
        String str;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (lVar != null && (lVar instanceof q)) {
            com.tencent.mm.ab.b bVar = ((q) lVar).diG;
            if (bVar != null) {
                amr amr = (amr) bVar.dIE.dIL;
                if (amr.rPv != null) {
                    try {
                        jSONObject = new JSONObject(com.tencent.mm.platformtools.ab.b(amr.rPv));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.LuckyMoneyUtil", e, "", new Object[0]);
                    }
                    if (jSONObject == null) {
                        x.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
                        if (jSONObject.has("real_name_info")) {
                            jSONObject = jSONObject.optJSONObject("real_name_info");
                        }
                        str2 = jSONObject.optString("guide_flag", "");
                        str3 = jSONObject.optString("guide_wording");
                        str4 = jSONObject.optString("left_button_wording", activity.getString(i.app_cancel));
                        str5 = jSONObject.optString("right_button_wording", activity.getString(i.app_ok));
                        str6 = jSONObject.optString("upload_credit_url", "");
                        str = str2;
                    } else {
                        str = str2;
                    }
                    if ("1".equals(str)) {
                        x.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
                        return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, i);
                    } else if (!"2".equals(str) || bi.oW(str6)) {
                        x.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bi.oW(str6));
                        return false;
                    } else {
                        x.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
                        return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, str3, str6, str4, str5, z, null);
                    }
                }
            }
        }
        jSONObject = null;
        if (jSONObject == null) {
            str = str2;
        } else {
            x.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
            if (jSONObject.has("real_name_info")) {
                jSONObject = jSONObject.optJSONObject("real_name_info");
            }
            str2 = jSONObject.optString("guide_flag", "");
            str3 = jSONObject.optString("guide_wording");
            str4 = jSONObject.optString("left_button_wording", activity.getString(i.app_cancel));
            str5 = jSONObject.optString("right_button_wording", activity.getString(i.app_ok));
            str6 = jSONObject.optString("upload_credit_url", "");
            str = str2;
        }
        if ("1".equals(str)) {
            x.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, i);
        } else if (!"2".equals(str) || bi.oW(str6)) {
            x.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bi.oW(str6));
            return false;
        } else {
            x.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, str3, str6, str4, str5, z, null);
        }
    }

    public static String Ge(String str) {
        if (bi.oW(str) || !com.tencent.mm.kernel.g.Eg().Dx()) {
            return "";
        }
        r2 = new Object[2];
        com.tencent.mm.kernel.g.Ek();
        r2[0] = com.tencent.mm.kernel.g.Ei().dqp;
        r2[1] = "LuckyMoney";
        File file = new File(String.format("%s/%s/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    public static Bitmap aE(String str, boolean z) {
        Bitmap bitmap;
        boolean z2 = true;
        if (z) {
            bitmap = (Bitmap) jaR.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        if (com.tencent.mm.compatible.util.f.zZ()) {
            int i;
            int i2;
            int i3;
            int i4;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                bitmap.recycle();
            }
            boolean z3 = z.bv(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z4;
            if (!z.bu(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z3 || z4) {
                i = options.outHeight;
                i2 = options.outWidth;
                while (i2 * i > 2764800) {
                    i2 >>= 1;
                    i >>= 1;
                }
                i2 = Math.max(1, i2);
                i = Math.max(1, i);
                x.w("MicroMsg.LuckyMoneyUtil", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i2), Integer.valueOf(i)});
                i3 = i2;
            } else {
                i = 960;
                i3 = 960;
            }
            int VX = ExifHelper.VX(str);
            if (VX == 90 || VX == 270) {
                i2 = i3;
                i4 = i;
            } else {
                i2 = i;
                i4 = i3;
            }
            if (MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.LuckyMoneyUtil";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                x.i(str2, str3, objArr);
            } else {
                bitmap = com.tencent.mm.sdk.platformtools.c.e(str, i2, i4, false);
            }
            if (bitmap == null) {
                x.e("MicroMsg.LuckyMoneyUtil", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                return null;
            }
            bitmap = com.tencent.mm.sdk.platformtools.c.b(bitmap, (float) VX);
            if (!z) {
                return bitmap;
            }
            jaR.put(str, bitmap);
            return bitmap;
        }
        x.e("MicroMsg.LuckyMoneyUtil", "sdcard is not avail!");
        return BitmapFactory.decodeResource(ad.getContext().getResources(), e.nosdcard_chatting_bg);
    }

    public static String bv(List<ai> list) {
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return stringBuilder.toString();
            }
            ai aiVar = (ai) list.get(i2);
            if (aiVar != null) {
                if (i2 != 0) {
                    stringBuilder.append("|");
                }
                stringBuilder.append(aiVar.type);
                stringBuilder.append("|");
                stringBuilder.append(aiVar.name);
            }
            i = i2 + 1;
        }
    }

    public static void dC(String str, String str2) {
        if (!bi.oW(str) && !bi.oW(str2)) {
            bd bdVar = new bd();
            bdVar.eX(0);
            bdVar.ep(str2);
            bdVar.setStatus(3);
            bdVar.setContent(str);
            bdVar.ay(com.tencent.mm.model.bd.o(str2, System.currentTimeMillis() / 1000));
            bdVar.setType(10000);
            ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().T(bdVar);
        }
    }
}
