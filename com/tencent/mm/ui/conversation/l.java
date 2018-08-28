package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.Map;

public final class l {
    private static c urp = null;

    public static void gS(Context context) {
        if (e.chv()) {
            String value = g.AT().getValue("NewShowRating");
            if (!bi.oW(value)) {
                Map z = bl.z(value, "ShowRatingNode");
                value = (z == null || z.get(".ShowRatingNode.MinVer") == null) ? "0" : (String) z.get(".ShowRatingNode.MinVer");
                int intValue = Integer.decode(value).intValue();
                value = (z == null || z.get(".ShowRatingNode.MaxVer") == null) ? "0" : (String) z.get(".ShowRatingNode.MaxVer");
                int intValue2 = Integer.decode(value).intValue();
                if (z == null || z.get(".ShowRatingNode.WaitDays") == null) {
                    value = "0";
                } else {
                    value = (String) z.get(".ShowRatingNode.WaitDays");
                }
                int intValue3 = Integer.decode(value).intValue();
                if (intValue <= d.qVN && d.qVN <= intValue2) {
                    Object obj;
                    final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
                    int i = sharedPreferences.getInt("show_rating_flag", 0);
                    int i2 = sharedPreferences.getInt("show_rating_version", 0);
                    long j = sharedPreferences.getLong("show_rating_timestamp", 0);
                    boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
                    long j2 = ((long) (intValue3 == 0 ? 7 : intValue3)) * 86400000;
                    if (i2 == 0 || intValue > i2 || i2 > intValue2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        sharedPreferences.edit().putInt("show_rating_version", d.qVN).commit();
                        sharedPreferences.edit().putInt("show_rating_flag", 0).commit();
                        i = 0;
                        j = System.currentTimeMillis();
                        sharedPreferences.edit().putLong("show_rating_timestamp", j).commit();
                        sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                        sharedPreferences.edit().putInt("show_rating_wait_days", intValue3).commit();
                        sharedPreferences.edit().putInt("show_rating_first_second_time", (int) (System.currentTimeMillis() / 1000)).commit();
                        x.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", new Object[]{Integer.valueOf(d.qVN), Integer.valueOf(i2), Integer.valueOf(intValue), Integer.valueOf(intValue2), Long.valueOf(j2)});
                    }
                    if (intValue <= d.qVN && d.qVN <= intValue2 && i == 0 && j != 0 && System.currentTimeMillis() >= j + j2) {
                        x.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
                        final Context context2 = context;
                        urp = h.a(context, false, context.getString(R.l.show_rating_enjoy_dialog_wording), "", context.getString(R.l.show_rating_button_yes), context.getString(R.l.show_rating_button_no), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                sharedPreferences.edit().putInt("show_rating_flag", 1).commit();
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                                l.urp = null;
                                l.u(context2, true);
                                x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
                            }
                        }, new 2(sharedPreferences, context));
                    } else if (z2 && j != 0 && System.currentTimeMillis() >= (j + j2) + 345600000) {
                        x.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
                        u(context, false);
                        sharedPreferences.edit().putInt("show_rating_flag", 3).commit();
                    } else if (i == 1) {
                        u(context, true);
                    } else if (i == 2) {
                        gT(context);
                    } else if (i == 3) {
                        u(context, false);
                    }
                }
            }
        }
    }

    private static void u(Context context, boolean z) {
        String string;
        String str;
        String str2;
        SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
        int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string2;
        String string3;
        if (z) {
            string2 = context.getString(R.l.show_rating_dialog_wording);
            string3 = context.getString(R.l.show_rating_dialog_button_yes);
            string = context.getString(R.l.show_rating_dialog_button_no);
            str = string3;
            str2 = string2;
        } else {
            string2 = context.getString(R.l.show_rating_dialog_again_wording);
            string3 = context.getString(R.l.show_rating_dialog_again_button_yes);
            string = context.getString(R.l.show_rating_dialog_again_button_no);
            str = string3;
            str2 = string2;
        }
        urp = h.a(context, false, str2, "", str, string, new 3(sharedPreferences, context, z2, i2, i), new 4(sharedPreferences, z2, i2, i));
    }

    private static void gT(final Context context) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string = context.getString(R.l.show_rating_feedback_dialog_button_yes);
        String string2 = context.getString(R.l.show_rating_feedback_dialog_button_no);
        OnClickListener anonymousClass5 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                com.tencent.mm.pluginsdk.d.a(context, (int) System.currentTimeMillis(), new byte[0], "weixin://dl/feedback");
                l.urp = null;
                com.tencent.mm.plugin.report.service.h.mEJ.h(11216, new Object[]{Integer.valueOf(2), Integer.valueOf(i2), Integer.valueOf(i)});
            }
        };
        6 6 = new 6(sharedPreferences, i2, i);
        urp = h.a(context, false, context.getString(R.l.show_rating_feedback_dialog_wording), "", string, string2, anonymousClass5, 6);
    }

    public static void czc() {
        if (urp != null) {
            urp.dismiss();
            urp = null;
        }
    }
}
