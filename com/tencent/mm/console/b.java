package com.tencent.mm.console;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.console.a.a.a;
import com.tencent.mm.console.a.c;
import com.tencent.mm.console.a.d;
import com.tencent.mm.console.a.e;
import com.tencent.mm.console.a.f;
import com.tencent.mm.console.a.g;
import com.tencent.mm.console.a.h;
import com.tencent.mm.console.a.i;
import com.tencent.mm.console.a.j;
import com.tencent.mm.console.a.k;
import com.tencent.mm.console.a.l;
import com.tencent.mm.console.a.m;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.model.am;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.o$g;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bn;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.ah;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.xweb.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class b {
    static {
        d.init();
        i.init();
        j.init();
        g.init();
        e.init();
        f.init();
        com.tencent.mm.console.a.b.init();
        c.init();
        l.init();
        h.init();
        k.init();
        m.init();
        try {
            Class.forName("com.tencent.mm.console.a.b.a");
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.CommandProcessor", th, "", new Object[0]);
        }
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[]{"//fsd"});
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.b(), new String[]{"//hcsetting"});
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a(), new String[]{"//clearrecent"});
    }

    private static int ft(String str) {
        if (!str.startsWith("//") || str.length() <= 2) {
            return 0;
        }
        int indexOf = str.indexOf(" ");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        try {
            indexOf = bi.getInt(str.substring(2, indexOf), 0);
            int i = com.tencent.mm.protocal.d.qVN % 256;
            if (i == 0 || indexOf < i || indexOf % i != 0) {
                return 0;
            }
            return indexOf / i;
        } catch (Exception e) {
            return 0;
        }
    }

    private static String fu(String str) {
        int indexOf = str.indexOf(" ");
        if (indexOf < 0) {
            return "";
        }
        return str.substring(indexOf).trim();
    }

    public static boolean z(Context context, final String str) {
        if (!str.startsWith("//")) {
            return false;
        }
        if (1 < x.getLogLevel() && !str.startsWith("//uplog") && !str.startsWith("//upcrash")) {
            x.i("MicroMsg.CommandProcessor", "summer processed log level[%s], need open debug ret false", Integer.valueOf(x.getLogLevel()));
            return false;
        } else if (com.tencent.mm.pluginsdk.cmd.b.be(context, str)) {
            return true;
        } else {
            StringBuilder stringBuilder;
            View textView;
            int dimensionPixelSize;
            String[] split;
            SharedPreferences sharedPreferences;
            Editor edit;
            if (str.startsWith("//clearWXSNSDB")) {
                com.tencent.mm.sdk.b.a.sFg.m(new pr());
                return true;
            } else if (str.startsWith("//verifytokenerror")) {
                af.eye = true;
                return true;
            } else if (str.startsWith("//resetbackupdata")) {
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.valueOf(false));
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.valueOf(false));
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.valueOf(false));
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.valueOf(false));
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.valueOf(false));
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.valueOf(false));
                au.HU().Gz().ckt();
                au.HU().GA().ckt();
                au.HU().Gy().ckt();
                Toast.makeText(ad.getContext(), "backup data has been reset!", 1).show();
                return true;
            } else if (str.equalsIgnoreCase("//ftsmsbiz")) {
                avl bTb = com.tencent.mm.plugin.websearch.api.x.bTb();
                stringBuilder = new StringBuilder();
                Iterator it = bTb.hbG.iterator();
                while (it.hasNext()) {
                    avk avk = (avk) it.next();
                    stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{r.gT(avk.rdS), Double.valueOf(avk.rYh), com.tencent.mm.pluginsdk.f.h.h("yyyy-MM-dd HH:mm", avk.rYi / 1000)}));
                    stringBuilder.append("\n");
                }
                textView = new TextView(context);
                textView.setText(stringBuilder.toString());
                textView.setGravity(19);
                textView.setTextSize(1, 10.0f);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setTextColor(-16711936);
                textView.setTypeface(Typeface.MONOSPACE);
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.LargePadding);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                com.tencent.mm.ui.base.h.a(context, null, textView, null);
                return true;
            } else if (str.startsWith("//setgamejs")) {
                split = str.split(" ");
                if (split.length == 2) {
                    if (split[1] == null || split[1].isEmpty() || split[1].endsWith("/")) {
                        s.makeText(context, "param set error, please don't end with /", 0).show();
                    } else {
                        sharedPreferences = ad.getContext().getSharedPreferences("app_brand_global_sp", 0);
                        if (sharedPreferences != null) {
                            edit = sharedPreferences.edit();
                            edit.remove("app_brand_game_js_path");
                            edit.commit();
                            if (!split[1].equalsIgnoreCase("null")) {
                                edit.putString("app_brand_game_js_path", split[1]);
                                edit.commit();
                            }
                        }
                    }
                }
                return true;
            } else {
                if (com.tencent.mm.sdk.a.b.chp()) {
                    if (str.startsWith("//launchapp clear")) {
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_LAUNCH_APP_NOT_ASK_PKG_STRING, (Object) "");
                        return true;
                    } else if (str.startsWith("//setsupportwxcode")) {
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.valueOf(true));
                        return true;
                    } else if (str.startsWith("//setnotsupportwxcode")) {
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.valueOf(false));
                        return true;
                    } else if (str.startsWith("//resetsupportwxcode")) {
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, null);
                        return true;
                    }
                }
                Intent intent;
                if (str.startsWith("//testsightwidget")) {
                    intent = new Intent();
                    intent.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
                    intent.putExtra("KSightThumbPath", "");
                    intent.putExtra("sight_md5", com.tencent.mm.a.g.cu("/mnt/sdcard/tencent/tempvideo4.mp4"));
                    intent.putExtra("KSnsPostManu", true);
                    intent.putExtra("KTouchCameraTime", bi.VE());
                    intent.putExtra("Ksnsupload_type", 14);
                    com.tencent.mm.bg.d.b(context, "sns", ".ui.SnsUploadUI", intent);
                    return true;
                } else if (str.startsWith("//openremitbank")) {
                    com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(1));
                    return true;
                } else if (str.startsWith("//angerbag")) {
                    com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_WEBVIEW_BAG_TEST_INFO_STRING_SYNC, ((String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.USERINFO_WEBVIEW_BAG_TEST_INFO_STRING_SYNC, (Object) "0")).equals("0") ? "1" : "0");
                    return true;
                } else if (str.startsWith("//clearbag")) {
                    com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_WEBVIEW_BAG_INFO_STRING_SYNC, (Object) "");
                    return true;
                } else if (str.startsWith("//closeremitbank")) {
                    com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(0));
                    return true;
                } else {
                    if (str.startsWith("//ftstemplatetest")) {
                        bc bcVar = new bc();
                        bcVar.bIB.bIC = 27;
                        bcVar.bIB.bIC = 1;
                        bcVar.bIB.filePath = "/sdcard/fts_template.zip";
                        com.tencent.mm.sdk.b.a.sFg.m(bcVar);
                    }
                    String str2;
                    String[] split2;
                    Intent intent2;
                    int intValue;
                    String fG;
                    if (str.startsWith("//sightforward")) {
                        intent = new Intent();
                        intent.setClassName(context, "com.tencent.mm.ui.transmit.SightForwardUI");
                        context.startActivity(intent);
                        return true;
                    } else if (str.startsWith("//remit")) {
                        com.tencent.mm.bg.d.b(context, "remittance", ".ui.RemittanceBusiUI", new Intent());
                        return true;
                    } else if (str.startsWith("//fixtools")) {
                        intent = new Intent();
                        intent.setClassName(context, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
                        intent.putExtra("entry_fix_tools", 2);
                        context.startActivity(intent);
                        return true;
                    } else if (str.startsWith("//uplog")) {
                        intent = new Intent();
                        intent.setClassName(context, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI");
                        intent.putExtra("entry_fix_tools_uplog", 5);
                        MMWizardActivity.D(context, intent);
                        return true;
                    } else if (str.startsWith("//upcrash")) {
                        str2 = "weixin";
                        if (au.HX()) {
                            str2 = q.GF();
                        }
                        split2 = str.split(" ");
                        dimensionPixelSize = 0;
                        if (split2 != null) {
                            if (split2.length > 1) {
                                dimensionPixelSize = bi.getInt(split2[1], 0);
                            }
                            if (split2.length > 2) {
                                str2 = split2[2];
                            }
                        }
                        au.DF().d(new bg(new 1(str2, dimensionPixelSize)));
                        return true;
                    } else if (str.startsWith("//switchnotificationstatus")) {
                        com.tencent.mm.k.f.bj(!com.tencent.mm.k.f.Ai());
                        return true;
                    } else if (str.startsWith("//fixError0831")) {
                        x.i("MicroMsg.CommandProcessor", "fixError0831");
                        com.tencent.mm.sdk.b.a.sFg.m(new bj());
                        return true;
                    } else if (str.startsWith("//resetbankremit")) {
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0));
                        return true;
                    } else if (str.startsWith("//busiluck ")) {
                        str2 = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=" + str.replace("//busiluck ", "");
                        intent2 = new Intent();
                        intent2.putExtra("key_way", 5);
                        intent2.putExtra("key_native_url", str2);
                        com.tencent.mm.bg.d.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2);
                        return true;
                    } else if (str.startsWith("//testsoter")) {
                        intent = new Intent();
                        intent.setClassName(ad.getPackageName(), "com.tencent.mm.plugin.soter.ui.SoterTestUI");
                        context.startActivity(intent);
                        return true;
                    } else if (str.startsWith("//facevideo")) {
                        split = str.split(" ");
                        if (split.length == 3) {
                            at.dBv.T("imgType", split[1]);
                            at.dBv.T("depth", split[2]);
                        }
                        return true;
                    } else if (str.startsWith("//alpha")) {
                        split = str.split(" ");
                        if (split.length == 2) {
                            at.dBv.T("alpha_duration", split[1]);
                        }
                        return true;
                    } else if (str.startsWith("//rectwidth")) {
                        split = str.split(" ");
                        if (split.length == 2) {
                            at.dBv.T("rect_width", split[1]);
                        }
                        return true;
                    } else if (str.startsWith("//newyearsw ")) {
                        au.HU();
                        intValue = ((Integer) com.tencent.mm.model.c.DT().get(aa.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
                        au.HU();
                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(intValue));
                        return true;
                    } else if (str.startsWith("//commitxlog")) {
                        au.DF().a(1, "", 0, false);
                        x.chR();
                        return true;
                    } else if (str.startsWith("//open neattextview")) {
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, Boolean.valueOf(true));
                        return true;
                    } else if (str.startsWith("//close neattextview")) {
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, Boolean.valueOf(false));
                        return true;
                    } else if (str.startsWith("//unprint specialtext")) {
                        MMNeatTextView.uGn = false;
                        return true;
                    } else if (str.startsWith("//print specialtext")) {
                        MMNeatTextView.uGn = true;
                        return true;
                    } else if (str.startsWith("//netstatus")) {
                        fG = ao.fG(ad.getContext());
                        com.tencent.mm.ui.base.h.a(context, fG, "netstatus", context.getString(R.l.voip_get_key_copy), context.getString(R.l.confirm_dialog_cancel), new 8(context, fG), null);
                        return true;
                    } else {
                        long j;
                        if (str.startsWith("//scaninterval ")) {
                            j = -1;
                            try {
                                j = bi.getLong(str.split(" ")[1], -1);
                            } catch (Exception e) {
                            }
                            if (j > 0) {
                                au.HU();
                                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_WECHAT_FILE_SCAN_INTERVAL_LONG, Long.valueOf(j));
                                x.i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", Long.valueOf(j));
                                return true;
                            }
                        }
                        if (str.startsWith("//scanwait ")) {
                            j = -1;
                            try {
                                j = bi.getLong(str.split(" ")[1], -1);
                            } catch (Exception e2) {
                            }
                            if (j > 0) {
                                au.HU();
                                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_WECHAT_FILE_SCAN_WAIT_TIME_LONG, Long.valueOf(j));
                                x.i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", Long.valueOf(j));
                                return true;
                            }
                        }
                        SharedPreferences chZ;
                        boolean z;
                        boolean booleanValue;
                        View textView2;
                        ab Yg;
                        if (str.equalsIgnoreCase("//delayquery")) {
                            af.eyh = !af.eyh;
                            return true;
                        } else if (str.startsWith("//newinit -hard")) {
                            com.tencent.mm.kernel.g.Ek();
                            com.tencent.mm.kernel.g.Ei().DT().set(15, Integer.valueOf(0));
                            return true;
                        } else if (str.startsWith("//opensearchpreload ")) {
                            split = str.split("\\s+");
                            if (split.length == 2) {
                                if ("1".equals(split[1].trim())) {
                                    z.bTc().jP(true);
                                } else if ("0".equals(split[1].trim())) {
                                    z.bTc().jP(false);
                                }
                            }
                            return true;
                        } else if (str.startsWith("//closesearchhtmlpreload ")) {
                            split = str.split("\\s+");
                            if (split.length == 2) {
                                if ("1".equals(split[1].trim())) {
                                    p.bSN();
                                } else if ("0".equals(split[1].trim())) {
                                    p.bSN();
                                }
                            }
                            return true;
                        } else if (str.equalsIgnoreCase("//swipe")) {
                            chZ = ad.chZ();
                            chZ.edit().putBoolean("settings_support_swipe", !chZ.getBoolean("settings_support_swipe", true)).commit();
                            return true;
                        } else if (str.equalsIgnoreCase("//multiwebview")) {
                            chZ = LauncherUI.cpQ().getSharedPreferences(ad.chY(), 0);
                            z = chZ.getBoolean("settings_multi_webview", false);
                            if (z) {
                                chZ.edit().putBoolean("settings_multi_webview", !z).commit();
                            }
                            return true;
                        } else if (str.equalsIgnoreCase("//sightinfo")) {
                            au.HU();
                            booleanValue = ((Boolean) com.tencent.mm.model.c.DT().get(344065, Boolean.valueOf(false))).booleanValue();
                            au.HU();
                            com.tencent.mm.model.c.DT().set(344065, Boolean.valueOf(!booleanValue));
                            au.HU();
                            com.tencent.mm.model.c.DT().lm(true);
                            return true;
                        } else if (str.startsWith("//sighttest")) {
                            intValue = bi.WU(str.replace("//sighttest ", ""));
                            au.HU();
                            com.tencent.mm.model.c.DT().set(344066, Integer.valueOf(intValue));
                            au.HU();
                            com.tencent.mm.model.c.DT().lm(true);
                            return true;
                        } else if (str.startsWith("//wxcamera")) {
                            x.i("MicroMsg.CommandProcessor", "set param %d", Integer.valueOf(bi.WU(str.replace("//wxcamera ", ""))));
                            au.HU();
                            com.tencent.mm.model.c.DT().a(aa.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, Integer.valueOf(intValue));
                            return true;
                        } else if (str.startsWith("//printcrash")) {
                            str2 = str.replace("//printcrash ", "");
                            textView2 = new TextView(context);
                            textView2.setText(fX(bi.getInt(str2, 0)));
                            textView2.setGravity(19);
                            textView2.setTextSize(1, 8.0f);
                            textView2.setLayoutParams(new LayoutParams(-1, -2));
                            textView2.setTextColor(-16711936);
                            textView2.setTypeface(Typeface.MONOSPACE);
                            intValue = context.getResources().getDimensionPixelSize(R.f.SmallestPadding);
                            textView2.setPadding(intValue, intValue, intValue, intValue);
                            textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
                            com.tencent.mm.ui.base.h.a(context, null, textView2, null);
                            return true;
                        } else if (str.startsWith("//printleak")) {
                            textView = new TextView(context);
                            textView.setText(com.tencent.mm.compatible.b.f.yS());
                            textView.setGravity(19);
                            textView.setTextSize(1, 8.0f);
                            textView.setLayoutParams(new LayoutParams(-1, -2));
                            textView.setTextColor(-16711936);
                            textView.setTypeface(Typeface.MONOSPACE);
                            dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.SmallestPadding);
                            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
                            com.tencent.mm.ui.base.h.a(context, null, textView, null);
                            return true;
                        } else if (str.startsWith("//resetmapcnt")) {
                            au.HU();
                            com.tencent.mm.model.c.DT().a(aa.a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(0));
                            return true;
                        } else if (str.equals("//testrsa")) {
                            y.J("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                            return true;
                        } else if (str.equals("//testrsabad")) {
                            y.J("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                            return true;
                        } else if (str.equals("//walletofflinetest")) {
                            au.HU();
                            com.tencent.mm.model.c.DT().a(aa.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(false));
                            return false;
                        } else if (str.startsWith("//makemsgdata ")) {
                            intValue = bi.getInt(str.split(" ")[1], 0);
                            au.HU();
                            com.tencent.mm.model.c.FT().H(com.tencent.mm.ui.chatting.y.tMb, (long) intValue);
                            return true;
                        } else if (str.startsWith("//pullappservice")) {
                            ap.ccb().eT(ad.getContext());
                            return true;
                        } else if (str.startsWith("//boundaryconfig")) {
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitSessionTextMsg"), 0)));
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitSNSObjectText"), 0)));
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsCommentMaxSize"), 0)));
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitFavText"), 0)));
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitSendEmotionBufSize"), 0)));
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitSendEmotionWidth"), 0)));
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitFavImageSize"), 0)));
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitFavVoiceLength"), 0)));
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitSessionShortVideoBufSize"), 0)));
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitVideoSize"), 0)));
                            x.i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitFileSize"), 0)));
                            return true;
                        } else if (str.startsWith("//whatsnew")) {
                            MMAppMgr.V((Activity) context);
                            return true;
                        } else if (str.startsWith("//profile ")) {
                            au.HU();
                            Yg = com.tencent.mm.model.c.FR().Yg(str.replace("//profile ", "").trim());
                            if (!(Yg == null || Yg.BJ() == 0)) {
                                intent2 = new Intent();
                                intent2.putExtra("Contact_User", Yg.getUsername());
                                com.tencent.mm.bg.d.b(context, "profile", ".ui.ContactInfoUI", intent2);
                            }
                            return true;
                        } else if (str.startsWith("//minigameupdate")) {
                            au.HU();
                            com.tencent.mm.model.c.DT().a(aa.a.USERINFO_MINIGAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(0));
                            return true;
                        } else {
                            if (com.tencent.mm.sdk.a.b.chp()) {
                                if (str.startsWith("//cs")) {
                                    intent = new Intent();
                                    intent.putExtra("voipCSBizId", "gh_b35727b00b78");
                                    intent.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
                                    com.tencent.mm.bg.d.b(ad.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                                    return true;
                                } else if (str.startsWith("//acs")) {
                                    intent = new Intent();
                                    intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                                    intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                                    com.tencent.mm.bg.d.b(ad.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                                    return true;
                                } else if (str.startsWith("//wifiset")) {
                                    intent = new Intent();
                                    intent.putExtra("free_wifi_ssid", "Xiaomi_WENDY");
                                    intent.putExtra("free_wifi_passowrd", "WX12345789");
                                    com.tencent.mm.bg.d.b(ad.getContext(), "freewifi", ".ui.FreeWifiCopyPwdUI", intent);
                                    return true;
                                } else if (str.startsWith("//bcs")) {
                                    intent = new Intent();
                                    intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                                    intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                                    intent.putExtra("voipCSAllowBackCamera", "1");
                                    intent.putExtra("voipCSShowOther", "1");
                                    intent.putExtra("voipCSAvatarUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=28737416,3249768666&fm=58");
                                    intent.putExtra("voipCSContext", "test");
                                    com.tencent.mm.bg.d.b(ad.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                                    return true;
                                }
                            }
                            String str3;
                            String str4;
                            boolean z2;
                            int tbsSDKVersion;
                            Editor edit2;
                            if (str.startsWith("//getfpkey")) {
                                fG = bn.cmZ();
                                com.tencent.mm.ui.base.h.a(context, fG, "Fingerprint Key", context.getString(R.l.voip_get_key_copy), context.getString(R.l.confirm_dialog_cancel), new 9(context, fG), null);
                                return true;
                            } else if (str.startsWith("//commitwd")) {
                                WatchDogPushReceiver.Sk();
                                return true;
                            } else if (str.startsWith("//setsnstestenv")) {
                                String str5;
                                String[] split3 = str.split(" +");
                                str3 = null;
                                if (split3.length > 1) {
                                    str5 = split3[1];
                                    if (com.tencent.mm.sdk.platformtools.p.isIPv4Address(str5) || com.tencent.mm.sdk.platformtools.p.isIPv6Address(str5)) {
                                        if (split3.length > 2) {
                                            str4 = split3[2];
                                            if (com.tencent.mm.sdk.platformtools.p.isIPv4Address(str4) || com.tencent.mm.sdk.platformtools.p.isIPv6Address(str4)) {
                                                if (split3.length > 3) {
                                                    fG = split3[3];
                                                    str3 = str4;
                                                } else {
                                                    fG = null;
                                                    str3 = str4;
                                                }
                                                af.exF = str5 != null;
                                                af.exw = str5;
                                                af.exY = str3;
                                                af.exZ = fG;
                                                com.tencent.mm.modelcdntran.g.NA().NF();
                                                Toast.makeText(context, String.format("%s %s %s", new Object[]{af.exw, af.exY, af.exZ}), 1).show();
                                                return true;
                                            }
                                        }
                                        fG = null;
                                        if (str5 != null) {
                                        }
                                        af.exF = str5 != null;
                                        af.exw = str5;
                                        af.exY = str3;
                                        af.exZ = fG;
                                        com.tencent.mm.modelcdntran.g.NA().NF();
                                        Toast.makeText(context, String.format("%s %s %s", new Object[]{af.exw, af.exY, af.exZ}), 1).show();
                                        return true;
                                    }
                                }
                                fG = null;
                                str5 = null;
                                if (str5 != null) {
                                }
                                af.exF = str5 != null;
                                af.exw = str5;
                                af.exY = str3;
                                af.exZ = fG;
                                com.tencent.mm.modelcdntran.g.NA().NF();
                                Toast.makeText(context, String.format("%s %s %s", new Object[]{af.exw, af.exY, af.exZ}), 1).show();
                                return true;
                            } else if (str.startsWith("//snsvcodec")) {
                                split = str.split(" +");
                                if (split.length > 1) {
                                    str2 = split[1];
                                    if ("on".equalsIgnoreCase(str2)) {
                                        fY(1);
                                        x.i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
                                    } else if ("off".equalsIgnoreCase(str2)) {
                                        fY(0);
                                        x.i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
                                    }
                                } else {
                                    fY(-1);
                                    x.i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
                                }
                                return true;
                            } else if (str.startsWith("//snswxpc")) {
                                split = str.split(" +");
                                if (split.length > 1) {
                                    str2 = split[1];
                                    if ("on".equalsIgnoreCase(str2)) {
                                        fZ(1);
                                        x.i("MicroMsg.CommandProcessor", "snswxpc val: 1");
                                    } else if ("off".equalsIgnoreCase(str2)) {
                                        fZ(0);
                                        x.i("MicroMsg.CommandProcessor", "snswxpc val: 0");
                                    }
                                } else {
                                    fZ(-1);
                                    x.i("MicroMsg.CommandProcessor", "snswxpc val: -1");
                                }
                                return true;
                            } else if (str.startsWith("//mmdumpsys")) {
                                au.Em().H(new 10());
                                return true;
                            } else if (str.startsWith("//remittance reset")) {
                                au.HU();
                                com.tencent.mm.model.c.DT().set(327729, "0");
                                return true;
                            } else if (str.startsWith("//wv ")) {
                                str2 = str.replace("//wv ", "");
                                intent2 = new Intent();
                                intent2.putExtra("rawUrl", str2);
                                com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                                return true;
                            } else if (str.startsWith("//wvjsapi ")) {
                                str2 = str.replace("//wvjsapi ", "");
                                intent2 = new Intent();
                                intent2.putExtra("rawUrl", str2);
                                com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewTestUI", intent2);
                                return true;
                            } else if (str.startsWith("//setibeacontabuinopen")) {
                                if (!au.HX()) {
                                    return false;
                                }
                                au.HU();
                                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(1));
                                return true;
                            } else if (str.startsWith("//setibeacontabuinclose")) {
                                if (!au.HX()) {
                                    return false;
                                }
                                au.HU();
                                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(0));
                                return true;
                            } else if (str.startsWith("//setibeaconpushopen")) {
                                if (!au.HX()) {
                                    return false;
                                }
                                au.HU();
                                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(true));
                                return true;
                            } else if (str.startsWith("//setibeaconpushclose")) {
                                if (!au.HX()) {
                                    return false;
                                }
                                au.HU();
                                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(false));
                                return true;
                            } else if (str.startsWith("//ibeacon")) {
                                booleanValue = false;
                                z = false;
                                if (VERSION.SDK_INT >= 18) {
                                    booleanValue = true;
                                }
                                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                                if (defaultAdapter != null && defaultAdapter.getState() == 12) {
                                    z = true;
                                }
                                boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                                z2 = booleanValue && z && hasSystemFeature;
                                fG = "isNowSupportedIbeacon:" + z2 + "\n\nisSystemSupported:" + booleanValue + "\nisBlueStateOn:" + z + "\nisSupportedBLE:" + hasSystemFeature + "\nSDK:" + VERSION.SDK_INT + "\nModel:" + Build.BRAND + "-" + com.tencent.mm.compatible.e.q.zE() + "\noperatingSystemInfo:" + com.tencent.mm.compatible.e.q.zI();
                                com.tencent.mm.ui.base.h.a(context, fG, "TestResult", context.getString(R.l.chatting_copy), context.getString(R.l.confirm_dialog_cancel), new 11(context, fG), null);
                                return true;
                            } else if (str.startsWith("//gettbs")) {
                                booleanValue = com.tencent.mm.compatible.e.q.deP.dfC;
                                sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                                str3 = sharedPreferences.getString("tbs_download", null);
                                str4 = sharedPreferences.getString("tbs_webview_disable", null);
                                boolean z3 = sharedPreferences.getBoolean("x5_jscore_enabled", false);
                                int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
                                tbsSDKVersion = WebView.getTbsSDKVersion(context);
                                String string = sharedPreferences.getString("tbs_webview_min_sdk_version", null);
                                fG = sharedPreferences.getString("tbs_webview_max_sdk_version", null);
                                Toast.makeText(context, String.format("forceSys:%b\ntbs_download:%s\ntbs_disable:%s\ntbs_disable_min_sdk_version:%s\ntbs_disable_max_sdk_version:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d\nx5JsCoreEnabled:%b", new Object[]{Boolean.valueOf(booleanValue), str3, str4, string, fG, Integer.valueOf(installedTbsCoreVersion), Integer.valueOf(tbsSDKVersion), Boolean.valueOf(z3)}), 1).show();
                                return true;
                            } else if (str.startsWith("//deletetbs")) {
                                intent = new Intent();
                                intent.setComponent(new ComponentName(ad.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                                context.sendBroadcast(intent);
                                edit2 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                                edit2.putLong("last_check_ts", 0);
                                edit2.apply();
                                au.HU();
                                com.tencent.mm.model.c.DT().a(aa.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.valueOf(false));
                                return true;
                            } else if (str.startsWith("//tbsDisableOverScroll")) {
                                edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                                try {
                                    str2 = str.substring(str.indexOf(":") + 1);
                                } catch (IndexOutOfBoundsException e3) {
                                    str2 = "";
                                }
                                edit.putBoolean("tbs_disable_over_scroll", Boolean.parseBoolean(str2));
                                edit.apply();
                                return true;
                            } else if (str.startsWith("//enabletbs")) {
                                edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                                str3 = str.replace("//enabletbs ", "");
                                edit.putString("tbs_webview_disable", "1".equals(str3) ? "0" : "1");
                                if ("0".equals(str3)) {
                                    edit.putString("tbs_webview_min_sdk_version", "0");
                                    edit.putString("tbs_webview_max_sdk_version", "0");
                                }
                                edit.apply();
                                return true;
                            } else if (str.startsWith("//wvsha1")) {
                                edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                                try {
                                    str2 = str.substring(str.indexOf(":") + 1);
                                } catch (IndexOutOfBoundsException e4) {
                                    str2 = "";
                                }
                                edit.putBoolean("wvsha1", Boolean.parseBoolean(str2));
                                edit.apply();
                                return true;
                            } else {
                                if (str.startsWith("//channelId")) {
                                    com.tencent.mm.ui.base.h.D(context, com.tencent.mm.sdk.platformtools.e.bxk, "channelId");
                                }
                                if (str.startsWith("//traceroute")) {
                                    com.tencent.mm.bg.d.A(context, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                                    return true;
                                }
                                if (str.startsWith("//qzone ")) {
                                    new u(context).TM(str.replace("//qzone ", ""));
                                }
                                int i;
                                if (str.startsWith("//dumpcrash")) {
                                    com.tencent.mm.sdk.platformtools.j.q(com.tencent.mm.compatible.util.e.duN + "crash/", com.tencent.mm.compatible.util.e.duP, false);
                                    return true;
                                } else if (str.startsWith("//dumpanr")) {
                                    com.tencent.mm.sdk.platformtools.j.q("/data/anr/", com.tencent.mm.compatible.util.e.duP, false);
                                    return true;
                                } else if (str.startsWith("//testanr")) {
                                    try {
                                        Thread.sleep(10000);
                                    } catch (Throwable e5) {
                                        x.printErrStackTrace("MicroMsg.CommandProcessor", e5, "", new Object[0]);
                                    }
                                    return true;
                                } else if (str.startsWith("//opensnsadRightbar")) {
                                    af.exv = true;
                                    return true;
                                } else if (str.startsWith("//setlocation ")) {
                                    split = str.split(" ");
                                    if (split == null || !com.tencent.mm.sdk.a.b.chp()) {
                                        return false;
                                    }
                                    af.ewL = true;
                                    if (split.length > 0) {
                                        af.lat = bi.getDouble(split[1], 0.0d);
                                    }
                                    if (split.length > 1) {
                                        af.lng = bi.getDouble(split[2], 0.0d);
                                    }
                                    return true;
                                } else if (str.startsWith("//switchsdcard")) {
                                    String str6;
                                    ArrayList ciH = ax.ciH();
                                    int size = ciH.size();
                                    x.i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = " + size);
                                    if (!(size <= 0 || ciH.get(0) == null || bi.oW(((ax.a) ciH.get(0)).sIK))) {
                                        for (intValue = 0; intValue < size; intValue++) {
                                            x.i("MicroMsg.CommandProcessor", "switchsdcard list i = " + intValue + " StatMountParse: " + ciH.get(intValue));
                                        }
                                    }
                                    for (i = 0; i < size; i++) {
                                        if (!((ax.a) ciH.get(i)).sIK.equals(com.tencent.mm.compatible.util.e.bnC)) {
                                            str6 = ((ax.a) ciH.get(i)).sIK;
                                            break;
                                        }
                                    }
                                    str6 = null;
                                    Activity activity = (Activity) context;
                                    x.i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: " + str6);
                                    if (bi.oW(str6)) {
                                        com.tencent.mm.ui.base.h.by(context, context.getString(R.l.switch_sdcard_failed));
                                        return true;
                                    }
                                    com.tencent.mm.ui.base.h.a(context, context.getString(R.l.switch_sdcard_tips), "", context.getString(R.l.app_ok), context.getString(R.l.app_cancel), new 12(str6, context, activity), null);
                                    return true;
                                } else if (str.startsWith("//getip")) {
                                    au.DF().d(new bg(new 13()));
                                    return true;
                                } else if (str.startsWith("//localjsapi")) {
                                    x.v("MicroMsg.CommandProcessor", "alvinluo path: %s", "file://" + com.tencent.mm.compatible.util.e.bnE + "test_jsapi.html");
                                    intent2 = new Intent();
                                    intent2.putExtra("rawUrl", str2);
                                    com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                                    return true;
                                } else if (str.startsWith("//getlocalkey")) {
                                    fG = bn.cmY();
                                    com.tencent.mm.ui.base.h.a(context, fG, "Fingerprint Key", context.getString(R.l.voip_get_key_copy), context.getString(R.l.confirm_dialog_cancel), new 14(context, fG), null);
                                    return true;
                                } else if (str.startsWith("//getdevid")) {
                                    fG = com.tencent.mm.compatible.e.q.zz();
                                    com.tencent.mm.ui.base.h.a(context, fG, "devid", context.getString(R.l.chatting_copy), context.getString(R.l.confirm_dialog_cancel), new 15(context, fG), null);
                                    return true;
                                } else if (str.startsWith("//testhtml")) {
                                    intent = new Intent();
                                    intent.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
                                    com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                                    return true;
                                } else if (str.startsWith("//testlocalhtml ")) {
                                    str2 = str.replace("//testlocalhtml ", "");
                                    intent2 = new Intent();
                                    intent2.putExtra("rawUrl", "file://" + str2);
                                    intent2.putExtra("neverGetA8Key", true);
                                    com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                                    return true;
                                } else if (str.startsWith("//setkey")) {
                                    if (bn.Zn(str.replace("//setkey", ""))) {
                                        Toast.makeText(context, R.l.voip_config_succ, 0).show();
                                    }
                                    return true;
                                } else if (str.startsWith("//checkspell")) {
                                    fG = str.replace("//checkspell ", "");
                                    if (bi.oW(fG)) {
                                        return true;
                                    }
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    for (intValue = 0; intValue < fG.length(); intValue++) {
                                        stringBuilder2.append("[" + fG.charAt(intValue) + ":" + SpellMap.g(fG.charAt(intValue)) + "]");
                                    }
                                    com.tencent.mm.ui.base.h.D(context, stringBuilder2.toString(), "Check Spell");
                                    return true;
                                } else if (str.startsWith("//gallery ")) {
                                    str2 = str.replace("//gallery ", "");
                                    if (bi.oW(str2)) {
                                        return true;
                                    }
                                    context.getSharedPreferences(ad.chY(), 0).edit().putString("gallery", str2).commit();
                                    return true;
                                } else if (str.startsWith("//svgtag")) {
                                    str2 = str.replace("//svgtag ", "");
                                    if (str2.equals("on")) {
                                        com.tencent.mm.bq.c.kZ(true);
                                    } else if (str2.equals("off")) {
                                        com.tencent.mm.bq.c.kZ(false);
                                    }
                                    return true;
                                } else if (str.startsWith("//svgcode")) {
                                    try {
                                        str2 = str.replace("//svgcode ", "");
                                        if (!str2.equals("on")) {
                                            str2.equals("off");
                                        }
                                        Class cls = Class.forName("com.tencent.mm.BuildConfig");
                                        Field declaredField = cls.getDeclaredField("SVGCode");
                                        declaredField.setAccessible(true);
                                        booleanValue = declaredField.getBoolean(cls);
                                        try {
                                            Toast.makeText(ad.getContext(), "Using SVG Code : " + booleanValue + " " + com.tencent.mm.svg.b.b.com(), 1).show();
                                        } catch (Exception e6) {
                                        }
                                    } catch (Throwable e52) {
                                        x.printErrStackTrace("MicroMsg.CommandProcessor", e52, "", new Object[0]);
                                        booleanValue = false;
                                    } catch (Throwable e522) {
                                        x.printErrStackTrace("MicroMsg.CommandProcessor", e522, "", new Object[0]);
                                        booleanValue = false;
                                    } catch (Throwable e5222) {
                                        x.printErrStackTrace("MicroMsg.CommandProcessor", e5222, "", new Object[0]);
                                        booleanValue = false;
                                    } catch (Throwable e52222) {
                                        x.printErrStackTrace("MicroMsg.CommandProcessor", e52222, "", new Object[0]);
                                        booleanValue = false;
                                    }
                                    return true;
                                } else if (str.startsWith("//testMbanner")) {
                                    try {
                                        split = str.replace("//testMbanner ", "").split(",");
                                        if (split.length >= 2) {
                                            com.tencent.mm.model.bc.Ig().a(new bb(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue(), null));
                                        }
                                    } catch (Exception e7) {
                                    }
                                    return true;
                                } else {
                                    if (str.startsWith("//testrsa")) {
                                        y.J("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                                    }
                                    if (str.startsWith("//recomT")) {
                                        try {
                                            au.HU().Gt().a(str.replace("//recomT ", ""), true, null);
                                        } catch (Exception e8) {
                                        }
                                        return true;
                                    } else if (str.startsWith("//recomF")) {
                                        try {
                                            au.HU().Gt().a(str.replace("//recomF ", ""), false, null);
                                        } catch (Exception e9) {
                                        }
                                        return true;
                                    } else if (str.startsWith("//resetwxpayagree")) {
                                        com.tencent.mm.kernel.g.Ek();
                                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(false));
                                        return true;
                                    } else if (str.startsWith("//ffmpeg")) {
                                        try {
                                            intValue = str.indexOf("-r ");
                                            dimensionPixelSize = str.indexOf("-b ");
                                            str2 = str.substring(intValue + 3, dimensionPixelSize);
                                            fG = str.substring(dimensionPixelSize + 3);
                                            float f = bi.getFloat(str2.trim(), 0.0f);
                                            dimensionPixelSize = bi.getInt(fG.trim(), 0);
                                            com.tencent.mm.plugin.sight.base.b.nbW = dimensionPixelSize;
                                            com.tencent.mm.plugin.sight.base.b.nbX = f;
                                            Toast.makeText(ad.getContext(), "set C2C video encode frame rate " + f + " bitrate " + dimensionPixelSize, 0).show();
                                        } catch (Exception e10) {
                                            Toast.makeText(ad.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                                        }
                                        return true;
                                    } else if (str.startsWith("//onlinevideo")) {
                                        try {
                                            intValue = bi.getInt(str.replace("//onlinevideo ", ""), 0);
                                            au.HU();
                                            com.tencent.mm.model.c.DT().a(aa.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(intValue));
                                            Toast.makeText(ad.getContext(), intValue > 0 ? "online video" : "offline video", 0).show();
                                        } catch (Throwable e522222) {
                                            x.printErrStackTrace("MicroMsg.CommandProcessor", e522222, "", new Object[0]);
                                            Toast.makeText(ad.getContext(), "set online video fail, please ensure your command.", 1).show();
                                        }
                                        return true;
                                    } else if (str.startsWith("//hevcinfo")) {
                                        str2 = com.tencent.mm.plugin.u.e.bdt();
                                        fG = com.tencent.mm.ui.chatting.y.tMb;
                                        bd bdVar = new bd();
                                        bdVar.ep(fG);
                                        bdVar.eX(2);
                                        bdVar.setType(1);
                                        bdVar.ay(System.currentTimeMillis());
                                        bdVar.setContent(str2);
                                        com.tencent.mm.model.bd.i(bdVar);
                                        return true;
                                    } else if (str.startsWith("//presns")) {
                                        com.tencent.mm.kernel.g.Em().h(new 2(), 3000);
                                        Toast.makeText(ad.getContext(), "preload sns", 0).show();
                                        return true;
                                    } else if (str.startsWith("//calcwxdata")) {
                                        au.HU();
                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_BACKGROUND_CALC_TIME_LONG, Long.valueOf(0));
                                        Toast.makeText(ad.getContext(), "calc wx data success", 0).show();
                                        return true;
                                    } else if (str.startsWith("//checkspace")) {
                                        try {
                                            intValue = bi.getInt(str.replace("//checkspace ", ""), 0);
                                            com.tencent.mm.g.a.bb bbVar = new com.tencent.mm.g.a.bb();
                                            bbVar.bIz.bIA = intValue;
                                            com.tencent.mm.sdk.b.a.sFg.m(bbVar);
                                            Toast.makeText(ad.getContext(), "check space code " + intValue, 0).show();
                                        } catch (Throwable e5222222) {
                                            x.printErrStackTrace("MicroMsg.CommandProcessor", e5222222, "", new Object[0]);
                                            Toast.makeText(ad.getContext(), "check space code fail, please ensure your command.", 1).show();
                                        }
                                        return true;
                                    } else {
                                        if (str.startsWith("//showkv") && com.tencent.mm.sdk.a.b.chp()) {
                                            try {
                                                intent2 = new Intent();
                                                intent2.addFlags(134217728);
                                                intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                                                ((com.tencent.mm.plugin.kitchen.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.kitchen.a.a.class)).s(context, intent2);
                                                return true;
                                            } catch (Exception e11) {
                                                x.e("MicroMsg.CommandProcessor", "showkv error [%s]", e11.toString());
                                            }
                                        }
                                        CharSequence replace;
                                        gs gsVar;
                                        ArrayList ciH2;
                                        if (str.startsWith("//showexpt") && com.tencent.mm.sdk.a.b.chp()) {
                                            ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.expt.a.a.class)).q(context, new Intent());
                                            return true;
                                        } else if (str.startsWith("//showroomexpt") && com.tencent.mm.sdk.a.b.chp()) {
                                            ((com.tencent.mm.plugin.expt.roomexpt.d) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.expt.roomexpt.d.class)).r(context, new Intent());
                                            return true;
                                        } else if (str.startsWith("//upfacemodel")) {
                                            au.DF().d(new com.tencent.mm.pluginsdk.g.a.a.m(42));
                                            return true;
                                        } else if (str.startsWith("//facett")) {
                                            au.HU();
                                            com.tencent.mm.model.c.DT().a(aa.a.USERINFO_FACE_SHOW_TUTORIAL_BOOLEAN_SYNC, Boolean.valueOf(false));
                                            return true;
                                        } else if (str.startsWith("//switchpaytype")) {
                                            split = str.split(" ");
                                            if (split == null || split.length < 2) {
                                                return false;
                                            }
                                            try {
                                                intValue = bi.getInt(split[1], 0);
                                                au.HU();
                                                com.tencent.mm.model.c.DT().set(339975, Integer.valueOf(intValue));
                                                return true;
                                            } catch (Exception e12) {
                                                x.e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                                                return false;
                                            }
                                        } else if (str.startsWith("//setNfcOpenUrl ")) {
                                            str2 = str.replace("//setNfcOpenUrl ", "");
                                            edit = ad.cia().edit();
                                            if (str2.equalsIgnoreCase("null")) {
                                                str2 = "";
                                            }
                                            edit.putString("nfc_open_url", str2);
                                            edit.commit();
                                            return true;
                                        } else if (str.startsWith("//setMBV8Debug ")) {
                                            str2 = str.replace("//setMBV8Debug ", "");
                                            edit = ad.cia().edit();
                                            if (str2.equalsIgnoreCase("true")) {
                                                edit.putBoolean("appbrandgame_open_v8debug", true);
                                            } else {
                                                edit.putBoolean("appbrandgame_open_v8debug", false);
                                            }
                                            edit.commit();
                                            return true;
                                        } else if (str.startsWith("//setAppBrandActionBar ")) {
                                            str2 = str.replace("//setAppBrandActionBar ", "");
                                            edit = ad.cia().edit();
                                            if (str2.equalsIgnoreCase("new")) {
                                                edit.putBoolean("appbrand_new_actionbar", true);
                                            } else {
                                                edit.putBoolean("appbrand_new_actionbar", false);
                                            }
                                            edit.commit();
                                            return true;
                                        } else if (str.startsWith("//snskvtest ")) {
                                            str2 = str.replace("//snskvtest", "").trim();
                                            if (str2.equals("0")) {
                                                af.exR = false;
                                            } else if (str2.equals("1")) {
                                                af.exR = true;
                                            }
                                            return true;
                                        } else if (str.startsWith("//emoji ")) {
                                            ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zr(str.replace("//emoji ", ""));
                                            return true;
                                        } else if (str.startsWith("//share ")) {
                                            intValue = Integer.valueOf(str.replace("//share ", "")).intValue();
                                            au.HU();
                                            com.tencent.mm.model.c.DT().set(229635, Integer.valueOf(intValue));
                                            return true;
                                        } else if (str.startsWith("//dumpappinfoblob ")) {
                                            com.tencent.mm.pluginsdk.model.app.f SW = com.tencent.mm.pluginsdk.model.app.ao.bmf().SW(str.replace("//dumpappinfoblob ", ""));
                                            com.tencent.mm.ui.base.h.D(context, SW.wJ() + "\n" + SW.wK() + "\n" + SW.wL(), "");
                                            return true;
                                        } else if (str.startsWith("//googleauth ")) {
                                            replace = str.replace("//googleauth ", "");
                                            if (!TextUtils.isEmpty(replace)) {
                                                if ("webview".equals(replace)) {
                                                    context.getSharedPreferences(ad.chY(), 0).edit().putBoolean("googleauth", true).commit();
                                                } else if ("local".equals(replace)) {
                                                    context.getSharedPreferences(ad.chY(), 0).edit().putBoolean("googleauth", false).commit();
                                                }
                                            }
                                            return true;
                                        } else if (str.startsWith("//clrgamecache")) {
                                            com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
                                            if (aSm != null) {
                                                aSm.dn(context);
                                            }
                                            return true;
                                        } else if (str.startsWith("//clearwepkg")) {
                                            ub ubVar = new ub();
                                            ubVar.cfW.bIH = 6;
                                            fG = str.replace("//clearwepkg ", "").trim();
                                            if (!(bi.oW(fG) || fG.equals("//clearwepkg"))) {
                                                ubVar.cfW.cfX = fG;
                                            }
                                            com.tencent.mm.sdk.b.a.sFg.m(ubVar);
                                            return true;
                                        } else if (str.startsWith("//clrgsd")) {
                                            gsVar = new gs();
                                            gsVar.bPT.bIH = 3;
                                            fG = str.replace("//clrgsd ", "").trim();
                                            if (!(bi.oW(fG) || fG.equals("//clrgsd"))) {
                                                gsVar.bPT.bPS = fG;
                                            }
                                            com.tencent.mm.sdk.b.a.sFg.m(gsVar);
                                            return true;
                                        } else if (str.startsWith("//delDownload")) {
                                            gsVar = new gs();
                                            gsVar.bPT.bIH = 4;
                                            fG = str.replace("//delDownload ", "").trim();
                                            if (!(bi.oW(fG) || fG.equals("//delDownload"))) {
                                                gsVar.bPT.bPS = fG;
                                                com.tencent.mm.sdk.b.a.sFg.m(gsVar);
                                            }
                                            return true;
                                        } else if (str.startsWith("//googlemap")) {
                                            af.exu = true;
                                            return true;
                                        } else if (str.startsWith("//sosomap")) {
                                            af.exu = false;
                                            return true;
                                        } else if (str.startsWith("//opentrace")) {
                                            com.tencent.mm.ui.applet.d dVar = new com.tencent.mm.ui.applet.d();
                                            com.tencent.mm.ui.applet.d.gB(ad.getContext());
                                            return true;
                                        } else if (str.startsWith("//updateConversation")) {
                                            x.i("MicroMsg.CommandProcessor", "update all conversation start");
                                            au.HU();
                                            for (String str22 : com.tencent.mm.model.c.FW().clE()) {
                                                au.HU();
                                                bd dG = com.tencent.mm.model.c.FT().dG(str22, " and not ( type = 10000 and isSend != 2 ) ");
                                                au.HU();
                                                com.tencent.mm.model.c.FW().ak(dG);
                                            }
                                            x.i("MicroMsg.CommandProcessor", "update all conversation end");
                                            return true;
                                        } else if (str.startsWith("//setshakecarddata")) {
                                            o.a.cbj().buy();
                                            return true;
                                        } else if (str.startsWith("//clearshakecarddata")) {
                                            o.a.cbj().buz();
                                            return true;
                                        } else if (str.startsWith("//pageSize")) {
                                            Context context2 = ad.getContext();
                                            stringBuilder = new StringBuilder("pageSize is ");
                                            au.HU();
                                            Toast.makeText(context2, stringBuilder.append(com.tencent.mm.model.c.FO().getPageSize()).toString(), 1).show();
                                            return true;
                                        } else if (str.startsWith("//resetDBStatus")) {
                                            au.HU();
                                            File file = new File(com.tencent.mm.model.c.DR());
                                            try {
                                                stringBuilder = new StringBuilder();
                                                au.HU();
                                                com.tencent.mm.ui.tools.d.i(new File(stringBuilder.append(com.tencent.mm.model.c.Gp()).append(file.getName().replace(".db", ".db.backup")).toString()), file);
                                                x.i("MicroMsg.CommandProcessor", "backupPath db path is %s", fG);
                                                com.tencent.mm.a.e.d(file, new File(file.getAbsolutePath() + "err" + System.currentTimeMillis()));
                                                Toast.makeText(ad.getContext(), "db状态已重置,请重启微信", 1).show();
                                            } catch (Exception e112) {
                                                x.w("MicroMsg.CommandProcessor", "delete failed: " + e112.getMessage());
                                            }
                                            return true;
                                        } else if (str.startsWith("//makesnsdata ")) {
                                            o$g.cbk().eB((long) bi.getInt(str.replace("//makesnsdata ", ""), 0));
                                            return true;
                                        } else if (str.startsWith("//setsnsupload ")) {
                                            af.exE = bi.getInt(str.replace("//setsnsupload ", ""), 0);
                                            return true;
                                        } else if (str.startsWith("//logsnstable")) {
                                            com.tencent.mm.sdk.b.a.sFg.m(new cl());
                                            return true;
                                        } else if (str.startsWith("//resetsnstip")) {
                                            au.HU();
                                            com.tencent.mm.model.c.DT().set(327776, Integer.valueOf(0));
                                            return true;
                                        } else if (str.startsWith("//checkcount")) {
                                            au.HU();
                                            intValue = com.tencent.mm.model.c.FT().GV(com.tencent.mm.ui.chatting.y.tMb);
                                            au.HU();
                                            Toast.makeText(context, "current count :" + intValue + " countAuto :" + com.tencent.mm.model.c.FT().GT(com.tencent.mm.ui.chatting.y.tMb), 1).show();
                                            return true;
                                        } else if (str.startsWith("//changeframe ")) {
                                            ad.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(str.replace("//changeframe ", "")).floatValue()).commit();
                                            return true;
                                        } else if (str.startsWith("//opendumpview")) {
                                            com.tencent.mm.ui.applet.c cVar = new com.tencent.mm.ui.applet.c();
                                            com.tencent.mm.ui.applet.c.gA(ad.getContext());
                                            return true;
                                        } else if (str.startsWith("//dumpmemory")) {
                                            System.gc();
                                            System.gc();
                                            com.tencent.mm.bv.b.cot();
                                            return true;
                                        } else if (str.startsWith("//dumpsnsfile")) {
                                            com.tencent.mm.sdk.b.a.sFg.m(new pu());
                                            return true;
                                        } else if (str.startsWith("//coverage")) {
                                            com.tencent.mm.plugin.report.b.f.KF(str.trim().substring(10));
                                            return true;
                                        } else if (str.startsWith("//dumpthreadpool")) {
                                            com.tencent.mm.sdk.f.e.cjz();
                                            return true;
                                        } else if (str.startsWith("//testverifypsw ")) {
                                            str22 = str.replace("//testverifypsw ", "").trim();
                                            if (str22.equals("0")) {
                                                af.exT = false;
                                            } else if (str22.equals("1")) {
                                                af.exT = true;
                                            }
                                            x.d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", str, Boolean.valueOf(af.exT));
                                            return true;
                                        } else if (str.startsWith("//pickpoi")) {
                                            intent = new Intent();
                                            intent.putExtra("map_view_type", 8);
                                            com.tencent.mm.bg.d.b(context, "location", ".ui.RedirectUI", intent);
                                            return true;
                                        } else if (str.startsWith("//configlist")) {
                                            if (str.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                                                List aH = ai.aH(str, "^//configlist set ([\\S]*)=([\\S]*)$");
                                                if (aH != null && aH.size() == 2) {
                                                    com.tencent.mm.k.g.AT().put((String) aH.get(0), (String) aH.get(1));
                                                    com.tencent.mm.sdk.b.a.sFg.m(new cm());
                                                }
                                            } else if (str.matches("^//configlist get ([\\S]*)$")) {
                                                List aH2 = ai.aH(str, "^//configlist get ([\\S]*)$");
                                                if (aH2 != null && aH2.size() == 1) {
                                                    str22 = (String) aH2.get(0);
                                                    Toast.makeText(context, str22 + "=" + com.tencent.mm.k.g.AT().getValue(str22), 0).show();
                                                }
                                            } else {
                                                au.HU();
                                                str22 = (String) com.tencent.mm.model.c.DT().get(278530, (Object) "");
                                                au.HU();
                                                fG = (String) com.tencent.mm.model.c.DT().get(278529, (Object) "");
                                                str3 = com.tencent.mm.compatible.util.e.bnE + "dynacfg.xml";
                                                bi.r(str3, (str22 + fG).getBytes());
                                                Toast.makeText(context, "output dynacfg xml to " + str3, 0).show();
                                            }
                                            return true;
                                        } else if (str.startsWith("//security")) {
                                            try {
                                                au.HU().Gu().a(str.replace("//security ", ""), true, null);
                                            } catch (Exception e13) {
                                            }
                                            return true;
                                        } else if (str.startsWith("//updatepackage")) {
                                            try {
                                                au.DF().d(new com.tencent.mm.ar.k(bi.getInt(str.replace("//updatepackage ", "").trim(), 0)));
                                            } catch (Exception e14) {
                                            }
                                            return true;
                                        } else if (str.startsWith("//copypackage")) {
                                            x.i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", str);
                                            ciH2 = ax.ciH();
                                            tbsSDKVersion = ciH2.size();
                                            x.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", Integer.valueOf(tbsSDKVersion));
                                            if (tbsSDKVersion < 2) {
                                                com.tencent.mm.ui.base.h.by(context, context.getString(R.l.copy_acc_fail));
                                            } else {
                                                com.tencent.mm.ui.base.h.a(context, context.getString(R.l.copy_acc_tips), "", context.getString(R.l.app_ok), context.getString(R.l.app_cancel), new 3(tbsSDKVersion, ciH2, context), null);
                                            }
                                            return true;
                                        } else if (str.startsWith("//copy -n ")) {
                                            x.i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", str);
                                            ciH2 = ax.ciH();
                                            tbsSDKVersion = ciH2.size();
                                            x.i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", Integer.valueOf(tbsSDKVersion));
                                            if (tbsSDKVersion < 2) {
                                                com.tencent.mm.ui.base.h.by(context, context.getString(R.l.copy_acc_fail));
                                            } else {
                                                com.tencent.mm.ui.base.h.a(context, context.getString(R.l.copy_acc_tips), "", context.getString(R.l.app_ok), context.getString(R.l.app_cancel), new 4(str, tbsSDKVersion, ciH2, context), null);
                                            }
                                            return true;
                                        } else if (str.startsWith("//deletepackage")) {
                                            try {
                                                str22 = str.replace("//deletepackage ", "");
                                                ce ceVar = new ce();
                                                ceVar.bJD.bJE = bi.getInt(str22, 0);
                                                com.tencent.mm.sdk.b.a.sFg.m(ceVar);
                                            } catch (Exception e15) {
                                            }
                                            return true;
                                        } else if (str.startsWith("//audiowritetofile")) {
                                            com.tencent.mm.compatible.e.q.deN.dcd = true;
                                            return true;
                                        } else if (str.startsWith("//bankcard")) {
                                            intent = new Intent();
                                            intent.putExtra("BaseScanUI_select_scan_mode", 7);
                                            intent.putExtra("bank_card_owner", "test");
                                            if (!(com.tencent.mm.plugin.voip.b.bx(context) || com.tencent.mm.ax.e.bw(context))) {
                                                com.tencent.mm.bg.d.b((Activity) context, "scanner", ".ui.BaseScanUI", intent);
                                            }
                                            return true;
                                        } else {
                                            if (str.startsWith("//banner")) {
                                                Map z4 = bl.z("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                                                str22 = (String) z4.get(".sysmsg.mainframebanner.$type");
                                                fG = (String) z4.get(".sysmsg.mainframebanner.showtype");
                                                str3 = (String) z4.get(".sysmsg.mainframebanner.data");
                                                x.d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", str22, fG, str3);
                                            }
                                            if (str.startsWith("//gamemsg")) {
                                                me meVar = new me();
                                                meVar.bWO.content = str;
                                                com.tencent.mm.sdk.b.a.sFg.m(meVar);
                                                return true;
                                            } else if (str.startsWith("//shortcut#")) {
                                                ty tyVar = new ty();
                                                tyVar.cfE.cfF = str;
                                                com.tencent.mm.sdk.b.a.sFg.m(tyVar);
                                                return true;
                                            } else if (str.startsWith("//gallerytype")) {
                                                com.tencent.mm.ui.chatting.p.tJa = !com.tencent.mm.ui.chatting.p.tJa;
                                                return true;
                                            } else {
                                                context.getString(R.l.voipface_debug);
                                                Object replace2;
                                                if (str.startsWith("//fullexit")) {
                                                    com.tencent.mm.sdk.platformtools.af.Wq("show_whatsnew");
                                                    com.tencent.mm.kernel.k.j(context, true);
                                                    MMAppMgr.bc(context);
                                                    au.hold();
                                                    com.tencent.mm.kernel.g.Ek().gi("");
                                                    MMAppMgr.afu();
                                                    return true;
                                                } else if (str.startsWith("//cleardldb")) {
                                                    au.HU();
                                                    com.tencent.mm.model.c.FX().aDd();
                                                    return true;
                                                } else if (str.startsWith("//setcardlayouttestdata")) {
                                                    replace2 = str.replace("//setcardlayouttestdata ", "");
                                                    au.HU();
                                                    com.tencent.mm.model.c.DT().a(aa.a.USERINFO_CARDLAYOUT_TESTDATA_STRING, replace2);
                                                    return true;
                                                } else if (str.startsWith("//delchatroomsysmsg")) {
                                                    str22 = str.replace("//delchatroomsysmsg ", "");
                                                    dimensionPixelSize = str22.indexOf(" ");
                                                    str3 = str22.substring(0, dimensionPixelSize);
                                                    str22 = str22.substring(dimensionPixelSize);
                                                    if (bi.oW(str3)) {
                                                        return false;
                                                    }
                                                    if (!str22.startsWith("<")) {
                                                        return false;
                                                    }
                                                    bd bdVar2 = new bd();
                                                    bdVar2.ay(System.currentTimeMillis());
                                                    bdVar2.setType(10002);
                                                    bdVar2.setContent(str22);
                                                    bdVar2.eX(0);
                                                    bdVar2.ep(str3);
                                                    com.tencent.mm.model.bd.i(bdVar2);
                                                    return true;
                                                } else {
                                                    if (str.startsWith("//resetcrseq")) {
                                                        split = str.split(" ");
                                                        try {
                                                            long j2 = bi.getLong(split[1], -1);
                                                            long j3 = bi.getLong(split[2], -1);
                                                            long j4 = bi.getLong(split[3], -1);
                                                            intValue = bi.getInt(split[4], -1);
                                                            if (j2 > 0) {
                                                                fG = j2 + "@chatroom";
                                                                au.HU();
                                                                com.tencent.mm.storage.ai Yq = com.tencent.mm.model.c.FW().Yq(fG);
                                                                if (Yq != null) {
                                                                    x.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] before [%d, %d, %d] [%d, %d, %d]", Yq.getUsername(), Long.valueOf(Yq.wV()), Long.valueOf(Yq.wT()), Integer.valueOf(Yq.wU()), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(intValue));
                                                                    if (j3 > -1) {
                                                                        Yq.av(j3);
                                                                    }
                                                                    if (j4 > -1) {
                                                                        Yq.au(j4);
                                                                    }
                                                                    if (intValue >= 0) {
                                                                        Yq.fc(intValue);
                                                                    }
                                                                    au.HU();
                                                                    intValue = com.tencent.mm.model.c.FW().a(Yq, Yq.getUsername(), false);
                                                                    x.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] done [%d, %d, %d] ret:%d", Yq.getUsername(), Long.valueOf(Yq.wV()), Long.valueOf(Yq.wT()), Integer.valueOf(Yq.wU()), Integer.valueOf(intValue));
                                                                    return true;
                                                                }
                                                            }
                                                        } catch (Throwable e52222222) {
                                                            x.printErrStackTrace("MicroMsg.CommandProcessor", e52222222, "summerbadcr resetcrseq", new Object[0]);
                                                        }
                                                    }
                                                    if (str.startsWith("//printchatroominfo")) {
                                                        str22 = com.tencent.mm.ui.chatting.y.tMb;
                                                        if (!com.tencent.mm.model.s.fq(str22)) {
                                                            return false;
                                                        }
                                                        au.HU();
                                                        final com.tencent.mm.storage.u ih = com.tencent.mm.model.c.Ga().ih(str22);
                                                        if (ih == null) {
                                                            x.e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", str22);
                                                            return false;
                                                        }
                                                        au.Em().H(new Runnable() {
                                                            public final void run() {
                                                                int ckK = ih.ckK();
                                                                int i = ih.field_chatroomdataflag;
                                                                int ckN = ih.ckN();
                                                                com.tencent.mm.storage.u uVar = ih;
                                                                if (uVar.b(uVar.sOi)) {
                                                                    uVar.ckJ();
                                                                }
                                                                int i2 = uVar.sOi.status;
                                                                int ckO = ih.ckO();
                                                                uVar = ih;
                                                                if (uVar.b(uVar.sOi)) {
                                                                    uVar.ckJ();
                                                                }
                                                                String str = uVar.sOi.dax;
                                                                List Nn = ih.Nn();
                                                                au.HU();
                                                                com.tencent.mm.g.c.cm dG = com.tencent.mm.model.c.FT().dG(str22, " and flag != 0 and msgSeq != 0");
                                                                boolean z = dG != null && dG.field_msgId > 0;
                                                                au.HU();
                                                                x.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", str22, Integer.valueOf(ckK), Integer.valueOf(i), Integer.valueOf(ckN), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(com.tencent.mm.model.c.FT().GT(str22)), Integer.valueOf(ckO), str, Integer.valueOf(Nn.size()));
                                                                StringBuilder stringBuilder = new StringBuilder();
                                                                stringBuilder.append("---chatroominfo---\nid:").append(str22).append("\nver:").append(ckK).append("\nflag:").append(i).append("\ntype:").append(ckN).append("\nstatus:").append(i2).append("\nget:").append(z).append("\nmsgCount:").append(r8).append("\nmaxCount:").append(ckO).append("\nupgrader:").append(str).append("\nmembersize:").append(Nn.size());
                                                                int i3 = -1;
                                                                try {
                                                                    i3 = bi.getInt(str.split(" ")[1], 0);
                                                                } catch (Exception e) {
                                                                }
                                                                if (i3 == -1) {
                                                                    i3 = Nn.size();
                                                                }
                                                                if (i3 > Nn.size()) {
                                                                    i3 = Nn.size();
                                                                }
                                                                if (i3 > 10) {
                                                                    i = 10;
                                                                } else {
                                                                    i = i3;
                                                                }
                                                                if (i > 0) {
                                                                    stringBuilder.append("\nmember:");
                                                                }
                                                                for (ckK = 0; ckK < i; ckK++) {
                                                                    stringBuilder.append("\n").append((String) Nn.get(ckK));
                                                                }
                                                                bd bdVar = new bd();
                                                                bdVar.ep(str22);
                                                                bdVar.eX(2);
                                                                bdVar.setType(1);
                                                                bdVar.ay(System.currentTimeMillis());
                                                                bdVar.setContent(stringBuilder.toString());
                                                                com.tencent.mm.model.bd.i(bdVar);
                                                            }
                                                        });
                                                        return true;
                                                    } else if (str.equals("//testupdate")) {
                                                        str22 = "";
                                                        try {
                                                            str22 = bi.convertStreamToString(context.getAssets().open("aplha_update_info.xml"));
                                                        } catch (Throwable e16) {
                                                            x.printErrStackTrace("MicroMsg.CommandProcessor", e16, "", new Object[0]);
                                                        }
                                                        au.HU();
                                                        com.tencent.mm.model.c.DT().set(352273, str22);
                                                        au.HU();
                                                        com.tencent.mm.model.c.DT().set(352274, Long.valueOf(System.currentTimeMillis()));
                                                        new com.tencent.mm.pluginsdk.model.app.a(str22).cbI();
                                                        return true;
                                                    } else if (str.equals("//checkUpdate0") || str.equals("//checkUpdate1")) {
                                                        com.tencent.mm.plugin.y.d.bfB().gB(str.equals("//checkUpdate1"));
                                                        com.tencent.mm.plugin.y.d.lrA = true;
                                                        return true;
                                                    } else if (str.equals("//debugsnstimelinestat")) {
                                                        af.exM = !af.exM;
                                                        Toast.makeText(ad.getContext(), "debugSnsTimelineStat: " + af.exM, 0).show();
                                                        return true;
                                                    } else if (str.startsWith("//abtestmsg") && com.tencent.mm.sdk.a.b.chp()) {
                                                        com.tencent.mm.model.c.a.a ja = com.tencent.mm.model.c.a.ja(str.replace("//abtestmsg", ""));
                                                        com.tencent.mm.model.c.c.Jx().j(ja.dEw, 0);
                                                        com.tencent.mm.model.c.c.Jy().j(ja.dEx, 1);
                                                        return true;
                                                    } else if (str.startsWith("//triggergetabtest")) {
                                                        au.HU();
                                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(1));
                                                        return true;
                                                    } else if (str.startsWith("//vad")) {
                                                        chZ = ad.chZ();
                                                        if (chZ == null) {
                                                            return false;
                                                        }
                                                        if (str.startsWith("//vad get")) {
                                                            com.tencent.mm.ui.base.h.D(context, com.tencent.mm.modelvoiceaddr.a.c.Ug(), "VAD PARAMS").show();
                                                            return true;
                                                        }
                                                        edit2 = chZ.edit();
                                                        if (str.startsWith("//vad sd")) {
                                                            edit2.putInt("s_delay_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                                        }
                                                        if (str.startsWith("//vad st")) {
                                                            edit2.putInt("sil_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                                        }
                                                        if (str.startsWith("//vad snr")) {
                                                            edit2.putFloat("s_n_ration", Float.valueOf(str.substring(10).trim()).floatValue());
                                                        }
                                                        if (str.startsWith("//vad sw")) {
                                                            edit2.putInt("s_window", Integer.valueOf(str.substring(9).trim()).intValue());
                                                        }
                                                        if (str.startsWith("//vad sl")) {
                                                            edit2.putInt("s_length", Integer.valueOf(str.substring(9).trim()).intValue());
                                                        }
                                                        edit2.apply();
                                                        return true;
                                                    } else if (str.startsWith("//dumpabtestrecords")) {
                                                        if (2 < x.getLogLevel()) {
                                                            return false;
                                                        }
                                                        if (str.contains("info")) {
                                                            replace = com.tencent.mm.model.c.c.Jy().ckp();
                                                        } else {
                                                            replace = com.tencent.mm.model.c.c.Jx().ckp();
                                                        }
                                                        textView2 = new TextView(context);
                                                        textView2.setText(replace);
                                                        textView2.setGravity(8388627);
                                                        textView2.setTextSize(1, 10.0f);
                                                        textView2.setLayoutParams(new LayoutParams(-1, -2));
                                                        textView2.setTextColor(-16744704);
                                                        textView2.setTypeface(Typeface.MONOSPACE);
                                                        textView2.setMovementMethod(new ScrollingMovementMethod());
                                                        intValue = context.getResources().getDimensionPixelSize(R.f.LargePadding);
                                                        textView2.setPadding(intValue, intValue, intValue, intValue);
                                                        com.tencent.mm.ui.base.h.a(context, null, textView2, null);
                                                        return true;
                                                    } else if (str.startsWith("//triggerWebViewCookiesCleanup")) {
                                                        au.HU();
                                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(0));
                                                        return true;
                                                    } else if (str.startsWith("//cleanwebcache")) {
                                                        com.tencent.mm.sdk.b.a.sFg.m(new com.tencent.mm.g.a.bl());
                                                        return true;
                                                    } else if (str.startsWith("//triggerWebViewCacheCleanup")) {
                                                        intent = new Intent();
                                                        intent.setComponent(new ComponentName(com.tencent.mm.ui.e.i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                                                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                                                        context.sendBroadcast(intent);
                                                        return true;
                                                    } else if (str.startsWith("//dumpsnsabtest")) {
                                                        com.tencent.mm.sdk.b.a.sFg.m(new cj());
                                                        return true;
                                                    } else if (str.startsWith("//dumpsilkvoicefile")) {
                                                        af.exQ = true;
                                                        return true;
                                                    } else if (str.startsWith("//fucktit")) {
                                                        au.HU();
                                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.valueOf(true));
                                                        return true;
                                                    } else if (str.startsWith("//clog ")) {
                                                        com.tencent.mm.plugin.report.service.h.mEJ.ep(str.substring(7), "test cLog " + System.currentTimeMillis());
                                                        return true;
                                                    } else if (str.startsWith("//testformsg") && com.tencent.mm.sdk.a.b.chp()) {
                                                        str22 = str.substring(12).trim();
                                                        x.i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + au.getSysCmdMsgExtension());
                                                        by byVar = new by();
                                                        byVar.rcl = com.tencent.mm.platformtools.ab.oT(str22);
                                                        byVar.jQd = 10002;
                                                        au.getSysCmdMsgExtension().b(new com.tencent.mm.ab.d.a(byVar, false, false, false));
                                                        return true;
                                                    } else if (str.startsWith("//canwebviewcachedownload")) {
                                                        booleanValue = bi.getInt(bi.oV(str.substring(25)).trim(), 1) > 0;
                                                        au.HU();
                                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_SET_CAN_WEBVIEW_CACHE_DOWNLOAD_BOOLEAN, Boolean.valueOf(booleanValue));
                                                        return true;
                                                    } else if (str.startsWith("//canwebviewcacheprepushdownload")) {
                                                        booleanValue = bi.getInt(bi.oV(str.substring(32)).trim(), 1) > 0;
                                                        au.HU();
                                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_SET_CAN_WEBVIEW_CACHE_PRE_PUSH_DOWNLOAD_BOOLEAN, Boolean.valueOf(booleanValue));
                                                        return true;
                                                    } else if (str.startsWith("//resetsnslukcy")) {
                                                        au.HU();
                                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCTRLHASSHOW_BOOLEAN_SYNC, Boolean.valueOf(false));
                                                        au.HU();
                                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(0));
                                                        au.HU();
                                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(0));
                                                        com.tencent.mm.sdk.b.a.sFg.m(new qk());
                                                        return true;
                                                    } else if (str.startsWith("//mmimgdec ")) {
                                                        str22 = str.substring(11);
                                                        if ("on".equalsIgnoreCase(str22)) {
                                                            MMBitmapFactory.setUseMMBitmapFactory(true);
                                                            Toast.makeText(context, "内置图片(png)解析库开启", 0).show();
                                                        } else if ("off".equalsIgnoreCase(str22)) {
                                                            MMBitmapFactory.setUseMMBitmapFactory(false);
                                                            Toast.makeText(context, "内置图片(png)解析库关闭", 0).show();
                                                        }
                                                        return true;
                                                    } else if (str.startsWith("//enablempsp")) {
                                                        an.a.lf(false);
                                                        Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                                        return true;
                                                    } else if (str.startsWith("//disablempsp")) {
                                                        an.a.lf(true);
                                                        Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                                        return true;
                                                    } else if (str.startsWith("//soterpay")) {
                                                        com.tencent.mm.bg.d.A(context, "fingerprint", ".ui.SoterPayTestUI");
                                                        return true;
                                                    } else if (str.startsWith(context.getString(R.l.voip_debug))) {
                                                        af.exX = !af.exX;
                                                        Toast.makeText(ad.getContext(), String.format("showVoipDebugLog:%b", new Object[]{Boolean.valueOf(af.exX)}), 0).show();
                                                        return true;
                                                    } else if (str.startsWith("//getdltaskinfo")) {
                                                        str22 = str.replace("//getdltaskinfo ", "");
                                                        try {
                                                            if (com.tencent.mm.plugin.downloader.model.c.cs(bi.getLong(str22, 0)) != null) {
                                                                x.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.plugin.downloader.model.c.cs(bi.getLong(str22, 0)).field_downloadId), com.tencent.mm.plugin.downloader.model.c.cs(bi.getLong(str22, 0)).field_downloadUrl, com.tencent.mm.plugin.downloader.model.c.cs(bi.getLong(str22, 0)).field_filePath, com.tencent.mm.plugin.downloader.model.c.cs(bi.getLong(str22, 0)).field_md5);
                                                            } else {
                                                                x.i("getdltaskinfo", "infoID null");
                                                            }
                                                        } catch (Exception e17) {
                                                            if (com.tencent.mm.plugin.downloader.model.c.yN(str22) != null) {
                                                                x.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.plugin.downloader.model.c.yN(str22).field_downloadId), com.tencent.mm.plugin.downloader.model.c.yN(str22).field_downloadUrl, com.tencent.mm.plugin.downloader.model.c.yN(str22).field_filePath, com.tencent.mm.plugin.downloader.model.c.yN(str22).field_md5);
                                                            } else {
                                                                x.i("getdltaskinfo", "infoURL null");
                                                            }
                                                        }
                                                        return true;
                                                    } else if (str.startsWith("//testscan ")) {
                                                        split = str.split(" ");
                                                        af.exW = bi.getFloat(split[1], 0.0f);
                                                        af.exV = bi.getFloat(split[2], 0.0f);
                                                        Toast.makeText(ad.getContext(), "mode auto:" + af.exW + ",mode continuous:" + af.exV, 1).show();
                                                        return true;
                                                    } else if (str.startsWith("//switchrecordmode")) {
                                                        sharedPreferences = ad.chZ();
                                                        z2 = sharedPreferences.getBoolean("settings_voicerecorder_mode", false);
                                                        sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", !z2).commit();
                                                        if (z2) {
                                                            Toast.makeText(ad.getContext(), "Turn off silk record", 1).show();
                                                        } else {
                                                            Toast.makeText(ad.getContext(), "Turn on silk record", 1).show();
                                                        }
                                                        return true;
                                                    } else if (str.startsWith("//indoorsensorconfig ")) {
                                                        com.tencent.mm.modelstat.e.RW().nl(str.replace("//indoorsensorconfig ", ""));
                                                        return true;
                                                    } else if (str.startsWith("//testindoorsensor ")) {
                                                        String[] split4 = str.replace("//testindoorsensor ", "").split(",");
                                                        com.tencent.mm.modelstat.e.RW().a(12345, false, split4[0].equals("1"), bi.getFloat(split4[1], 0.0f), bi.getFloat(split4[2], 0.0f), 12);
                                                        return true;
                                                    } else if (str.startsWith("//facedebug")) {
                                                        return true;
                                                    } else {
                                                        if (str.startsWith("//rstfacett")) {
                                                            return true;
                                                        }
                                                        if (str.startsWith("//switchjsc")) {
                                                            str22 = str.replace("//switchjsc ", "");
                                                            sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                                                            if ("clear".equals(str22)) {
                                                                sharedPreferences.edit().remove("switch_x5_jscore").apply();
                                                            } else if ("true".equals(str22)) {
                                                                sharedPreferences.edit().putBoolean("switch_x5_jscore", true).apply();
                                                            } else if ("false".equals(str22)) {
                                                                sharedPreferences.edit().putBoolean("switch_x5_jscore", false).apply();
                                                            }
                                                            return true;
                                                        } else if (str.startsWith("//rfcdn")) {
                                                            try {
                                                                com.tencent.mm.modelcdntran.g.NE().keep_OnRequestDoGetCdnDnsInfo(888);
                                                            } catch (Throwable e522222222) {
                                                                x.e("MicroMsg.CommandProcessor", "rfcdn :%s", bi.i(e522222222));
                                                            }
                                                            return true;
                                                        } else {
                                                            if (str.startsWith("//testcrscroll ")) {
                                                                split = str.split(" ");
                                                                if (split != null && split.length > 1) {
                                                                    ah.tSa = bi.getInt(split[1], 0);
                                                                    x.i("MicroMsg.CommandProcessor", "summerbadcr testscroll new BADCR_SCROLL_DELAY[%d]", Integer.valueOf(ah.tSa));
                                                                    return true;
                                                                }
                                                            }
                                                            if (str.startsWith("//switchx5jscore")) {
                                                                chZ = ad.chZ();
                                                                chZ.edit().putBoolean("switch_x5_jscore", !chZ.getBoolean("switch_x5_jscore", true)).apply();
                                                                return true;
                                                            } else if (str.startsWith("//removeaudioplayer")) {
                                                                split = str.split(" ");
                                                                if (split.length >= 2) {
                                                                    intValue = bi.getInt(split[1], 3);
                                                                    if (intValue >= 2 && intValue <= 9) {
                                                                        au.HU();
                                                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC, Integer.valueOf(intValue));
                                                                    }
                                                                }
                                                                return true;
                                                            } else if (str.startsWith("//showaudiotoast")) {
                                                                split = str.split(" ");
                                                                if (split.length >= 2) {
                                                                    intValue = bi.getInt(split[1], 0);
                                                                    au.HU();
                                                                    com.tencent.mm.model.c.DT().a(aa.a.USERINFO_MUSIC_SHOW_AUDIO_TOAST_BOOLEAN_SYNC, Boolean.valueOf(intValue == 1));
                                                                }
                                                                return true;
                                                            } else if (str.startsWith("//switchmusicplayer")) {
                                                                x.i("MicroMsg.CommandProcessor", "msg:%s", str);
                                                                split2 = str.split(" ");
                                                                if (split2.length > 2) {
                                                                    Object obj;
                                                                    if (bi.getInt(split2[1], 0) == 0) {
                                                                        obj = null;
                                                                    } else {
                                                                        dimensionPixelSize = 1;
                                                                    }
                                                                    int i2 = bi.getInt(split2[2], -1);
                                                                    au.HU();
                                                                    i = ((Integer) com.tencent.mm.model.c.DT().get(aa.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(0))).intValue();
                                                                    replace2 = 1;
                                                                    if (i2 == -1) {
                                                                        if (obj != null) {
                                                                            dimensionPixelSize = 255;
                                                                        } else {
                                                                            dimensionPixelSize = 0;
                                                                        }
                                                                    } else if (i2 == 0) {
                                                                        if (obj != null) {
                                                                            dimensionPixelSize = i | 1;
                                                                        } else {
                                                                            dimensionPixelSize = i & -2;
                                                                        }
                                                                    } else if (i2 == 1) {
                                                                        if (obj != null) {
                                                                            dimensionPixelSize = i | 2;
                                                                        } else {
                                                                            dimensionPixelSize = i & -3;
                                                                        }
                                                                    } else if (i2 == 4) {
                                                                        if (obj != null) {
                                                                            dimensionPixelSize = i | 4;
                                                                        } else {
                                                                            dimensionPixelSize = i & -5;
                                                                        }
                                                                    } else if (i2 == 6) {
                                                                        if (obj != null) {
                                                                            dimensionPixelSize = i | 16;
                                                                        } else {
                                                                            dimensionPixelSize = i & -17;
                                                                        }
                                                                    } else if (i2 == 7) {
                                                                        if (obj != null) {
                                                                            dimensionPixelSize = i | 32;
                                                                        } else {
                                                                            dimensionPixelSize = i & -33;
                                                                        }
                                                                    } else if (i2 == 8) {
                                                                        if (obj != null) {
                                                                            dimensionPixelSize = i | 64;
                                                                        } else {
                                                                            dimensionPixelSize = i & -65;
                                                                        }
                                                                    } else if (i2 != 9) {
                                                                        replace2 = null;
                                                                        dimensionPixelSize = i;
                                                                    } else if (obj != null) {
                                                                        dimensionPixelSize = i | FileUtils.S_IWUSR;
                                                                    } else {
                                                                        dimensionPixelSize = i & -129;
                                                                    }
                                                                    if (replace2 != null) {
                                                                        au.HU();
                                                                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(dimensionPixelSize));
                                                                    }
                                                                }
                                                                return true;
                                                            } else if (str.startsWith("//testdefaultrsa")) {
                                                                x.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa");
                                                                split = str.split(" ");
                                                                booleanValue = split != null && split.length > 1;
                                                                y.J("", "", 0);
                                                                com.tencent.mm.network.e DJ = com.tencent.mm.kernel.g.Eh().DF().DJ();
                                                                if (DJ == null) {
                                                                    x.w("MicroMsg.CommandProcessor", "summercert testdefaultrsa push not alive");
                                                                    return false;
                                                                }
                                                                new com.tencent.mm.modelsimple.q("", "", "", 0).Rc().a(DJ, new 6(booleanValue, context));
                                                                return true;
                                                            } else if (str.startsWith("//dumpdefaultrsa")) {
                                                                return A(context, "");
                                                            } else {
                                                                if (str.startsWith("//hardwareinfo")) {
                                                                    ((com.tencent.mm.plugin.hardwareopt.a.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).fD(true);
                                                                    return true;
                                                                } else if (str.startsWith("//showStringName")) {
                                                                    chZ = ad.chZ();
                                                                    chZ.edit().putBoolean("ShowStringName", !chZ.getBoolean("ShowStringName", false)).commit();
                                                                    return true;
                                                                } else if (str.startsWith("//mmphotoedit")) {
                                                                    com.tencent.mm.bg.d.b(context, "mmsight", ".ui.TestVideoEditUI", new Intent());
                                                                    return true;
                                                                } else if (str.startsWith("//msgDelay")) {
                                                                    com.tencent.mm.ui.conversation.a.m.gW(context);
                                                                    return true;
                                                                } else if (str.startsWith("//cpDelayedMsg")) {
                                                                    com.tencent.mm.ui.conversation.a.m.gX(context);
                                                                    return true;
                                                                } else if (str.startsWith("//testhce")) {
                                                                    com.tencent.mm.bg.d.A(context, "nfc", ".ui.HceTestUI");
                                                                    return true;
                                                                } else if (str.startsWith("//debugbigimg")) {
                                                                    split = str.split(" ");
                                                                    if (split.length == 2) {
                                                                        if (split[1].equals("1")) {
                                                                            ad.chZ().edit().putBoolean("debug_big_img", true).apply();
                                                                        } else {
                                                                            ad.chZ().edit().putBoolean("debug_big_img", false).apply();
                                                                        }
                                                                    }
                                                                    return true;
                                                                } else if (str.startsWith("//testservice ")) {
                                                                    str22 = str.replace("//testservice ", "");
                                                                    edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                                                                    str3 = "forceTrigger";
                                                                    booleanValue = str22 != null && str22.equals("1");
                                                                    edit.putBoolean(str3, booleanValue).commit();
                                                                    return true;
                                                                } else if (str.startsWith("//openDetect")) {
                                                                    ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putBoolean("msg_delay_close_detect", false).apply();
                                                                    return true;
                                                                } else if (str.startsWith("//closeDetect")) {
                                                                    ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putBoolean("msg_delay_close_detect", true).apply();
                                                                    return true;
                                                                } else if (str.startsWith("//snsimage")) {
                                                                    try {
                                                                        intValue = bi.getInt(str.replace("//snsimage ", ""), 0);
                                                                        com.tencent.mm.modelcdntran.g.ND().hA(intValue);
                                                                        Toast.makeText(ad.getContext(), intValue > 0 ? "tcp sns image download" : "http sns image download", 0).show();
                                                                    } catch (Throwable e5222222222) {
                                                                        x.printErrStackTrace("MicroMsg.CommandProcessor", e5222222222, "", new Object[0]);
                                                                        Toast.makeText(ad.getContext(), "set snsimage fail, please ensure your command.", 1).show();
                                                                    }
                                                                    return true;
                                                                } else {
                                                                    x.d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", Integer.valueOf(ft(str)));
                                                                    switch (ft(str)) {
                                                                        case 0:
                                                                            return false;
                                                                        case 568:
                                                                            Assert.assertTrue("test errlog", false);
                                                                            return true;
                                                                        case 569:
                                                                            au.HU().Gr();
                                                                            return true;
                                                                        case 570:
                                                                            if (bn.Zn(fu(str))) {
                                                                                Toast.makeText(context, R.l.voip_config_succ, 0).show();
                                                                            }
                                                                            return true;
                                                                        case 571:
                                                                            str22 = fu(str);
                                                                            au.HU();
                                                                            com.tencent.mm.model.c.DT().set(8195, str22);
                                                                            return true;
                                                                        case 572:
                                                                            com.tencent.mm.sdk.platformtools.e.bxm = Integer.valueOf(fu(str)).intValue();
                                                                            return true;
                                                                        case 574:
                                                                            StringBuilder append = new StringBuilder().append(com.tencent.mm.compatible.e.q.zy());
                                                                            au.HU();
                                                                            com.tencent.mm.ui.base.h.D(context, com.tencent.mm.a.g.u(append.append(com.tencent.mm.model.c.Df()).toString().getBytes()), "md5");
                                                                            return true;
                                                                        case 579:
                                                                            am.a.HD().R(fu(str), "");
                                                                            return true;
                                                                        case 580:
                                                                            au.DF().d(new bg(new 7()));
                                                                            return true;
                                                                        case 581:
                                                                            com.tencent.mm.pluginsdk.model.app.ao.bme().SU(fu(str));
                                                                            return true;
                                                                        case 582:
                                                                            str22 = fu(str);
                                                                            au.HU();
                                                                            Yg = com.tencent.mm.model.c.FR().Yg(str22);
                                                                            if (Yg == null || Yg.BJ() == 0) {
                                                                                return false;
                                                                            }
                                                                            Yg.Bb();
                                                                            com.tencent.mm.model.s.t(Yg);
                                                                            return true;
                                                                        case 583:
                                                                            au.HU();
                                                                            com.tencent.mm.model.c.Gs();
                                                                            return true;
                                                                        case 584:
                                                                        case 585:
                                                                            bf.iH(fu(str));
                                                                            return true;
                                                                        case 586:
                                                                            split = str.split(" ");
                                                                            if (split != null && split.length == 3) {
                                                                                com.tencent.mm.modelmulti.r.bh(bi.getInt(split[1], 0), bi.getInt(split[2], 0));
                                                                            }
                                                                            return true;
                                                                        case 587:
                                                                            com.tencent.mm.sdk.b.a.sFg.m(new ck());
                                                                            return true;
                                                                        case 588:
                                                                            com.tencent.mm.a.e.cr("/sdcard/tencent/MicroMsg/back");
                                                                            au.HU();
                                                                            com.tencent.mm.sdk.platformtools.j.q(com.tencent.mm.model.c.Gp(), "/sdcard/tencent/MicroMsg/back", false);
                                                                            return true;
                                                                        case 590:
                                                                            return true;
                                                                        case 591:
                                                                            try {
                                                                                split = str.split(" ");
                                                                                if (split != null && split.length > 1) {
                                                                                    au.HU().Gv().r(bl.z(split[0], "sysmsg"));
                                                                                }
                                                                            } catch (Throwable e52222222222) {
                                                                                x.printErrStackTrace("MicroMsg.CommandProcessor", e52222222222, "hy: error occured in commandProcessor", new Object[0]);
                                                                            }
                                                                            return true;
                                                                        default:
                                                                            return false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean A(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!bi.oW(str)) {
            stringBuffer.append(str + "\n\n");
        }
        stringBuffer.append("Default RSA Info:\n");
        stringBuffer.append("ClientVersion: " + com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION + "\n");
        stringBuffer.append("BASE_RSA_PUBLIC_VERSION = 173\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYN = D55D10C78FAE31AEEA46BFF785E3CCD0144084E3E426D7A5CAABB8943E815EC235FD86CC426C537C2B6E5E99301FBD0ACB50B562E1867A9C92222F9BFD8F2359AD32A36D0F7D8BCDECCE523EBB4115DE250F5BEC19A11D563AD3FBB45E1A0E49B2D64DECEFE22DC01FC575CEA1A129A5765293168C0CDA1467873B91229ED398F417EB43671D87C41A2D713095F379F22FC4578FB8DB77A9F1897C014F4B5AAF06626AC970811098516FD82B4A84E2960B2F039C463C36DB4CFF46DB0C3E0392172C7022591EE6495AFBE759828F713899994E138897A027F60D104C6A90EE08C9C3FBAE3C2BF7EB0CB613FD1DB2BFC34A677E8FB31EF780957F3D5FD9A4C41D len(512)\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
        stringBuffer.append("REQ_RSA_PUBLIC_VERSION = 174\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYN = D153E8A2B314D2110250A0A550DDACDCD77F5801F3D1CC21CB1B477E4F2DE8697D40F10265D066BE8200876BB7135EDC74CDBC7C4428064E0CDCBE1B6B92D93CEAD69EC27126DEBDE564AAE1519ACA836AA70487346C85931273E3AA9D24A721D0B854A7FCB9DED49EE03A44C189124FBEB8B17BB1DBE47A534637777D33EEC88802CD56D0C7683A796027474FEBF237FA5BF85C044ADC63885A70388CD3696D1F2E466EB6666EC8EFE1F91BC9353F8F0EAC67CC7B3281F819A17501E15D03291A2A189F6A35592130DE2FE5ED8E3ED59F65C488391E2D9557748D4065D00CBEA74EB8CA19867C65B3E57237BAA8BF0C0F79EBFC72E78AC29621C8AD61A2B79B len(512)\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
        x.i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + stringBuffer.toString());
        if (!com.tencent.mm.sdk.a.b.chp()) {
            return false;
        }
        View textView = new TextView(context);
        textView.setText(stringBuffer.toString());
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.SmallestPadding);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        com.tencent.mm.ui.base.h.a(context, null, textView, null);
        if (!y.cgv()) {
            return true;
        }
        Toast.makeText(context, "dump file:" + com.tencent.mm.compatible.util.e.bnE + "DefaultRSA.java", 1).show();
        return true;
    }

    private static StringBuilder fX(int i) {
        Throwable e;
        Date date = new Date(bi.VF() - (((long) i) * 86400000));
        String str = com.tencent.mm.compatible.util.e.duP + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt";
        StringBuilder stringBuilder = new StringBuilder();
        if (!new File(str).exists()) {
            return new StringBuilder(" day -" + i + " no crash.");
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            try {
                if (bi.oW(bufferedReader.readLine())) {
                    bufferedReader.close();
                    StringBuilder stringBuilder2 = new StringBuilder("read day -" + i + "file failed");
                    try {
                        bufferedReader.close();
                        return stringBuilder2;
                    } catch (Exception e2) {
                        return stringBuilder2;
                    }
                }
                while (true) {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        stringBuilder.append(new String(Base64.decode(str.split("error_")[1], 0)).split("#accinfo.uin=")[1]);
                        stringBuilder.append("\n_____________________________________\n");
                    } else {
                        try {
                            break;
                        } catch (Exception e3) {
                        }
                    }
                }
                bufferedReader.close();
                return stringBuilder;
            } catch (Exception e4) {
                e = e4;
                try {
                    x.printErrStackTrace("MicroMsg.CommandProcessor", e, "", new Object[0]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    return stringBuilder;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e7) {
            e = e7;
            bufferedReader = null;
            x.printErrStackTrace("MicroMsg.CommandProcessor", e, "", new Object[0]);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e52) {
                }
            }
            return stringBuilder;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e62) {
                }
            }
            throw e;
        }
    }

    private static void fY(int i) {
        SharedPreferences m = an.m(ad.getContext(), "sp_sns_dynswitch_stg", 4);
        switch (i) {
            case -1:
                m.edit().remove("st_sw_use_vcodec_img").commit();
                return;
            case 0:
                m.edit().putBoolean("st_sw_use_vcodec_img", false).commit();
                return;
            case 1:
                m.edit().putBoolean("st_sw_use_vcodec_img", true).commit();
                return;
            default:
                throw new IllegalArgumentException("Bad op parameter: " + i);
        }
    }

    private static void fZ(int i) {
        SharedPreferences m = an.m(ad.getContext(), "sp_sns_dynswitch_stg", 4);
        switch (i) {
            case -1:
                m.edit().remove("st_sw_use_wxpc_img").commit();
                return;
            case 0:
                m.edit().putBoolean("st_sw_use_wxpc_img", false).commit();
                return;
            case 1:
                m.edit().putBoolean("st_sw_use_wxpc_img", true).commit();
                return;
            default:
                throw new IllegalArgumentException("Bad op parameter: " + i);
        }
    }
}
