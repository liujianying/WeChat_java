package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.br;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.a.a$c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class a {
    private static Context context = null;
    private static boolean nhl = false;
    private static String nhm = "0";
    private static OnClickListener nhn = null;
    private static int nho = -1;
    private static int nhp = -1;
    private static long nhq = 0;
    private static View nhr = null;
    private static b nhs = null;
    private static c nht = null;
    private static com.tencent.mm.sdk.b.c nhu = new 1();
    private static com.tencent.mm.sdk.b.c nhv = new 2();

    static /* synthetic */ void a(View view, Context context, n nVar) {
        if (context != null) {
            if (nVar != null) {
                nhq = nVar.field_snsId;
            }
            b bVar = nhs;
            if (view != null && !bVar.nhR) {
                com.tencent.mm.sdk.b.a.sFg.m(new br());
                if (bVar.nhP) {
                    bVar.bwH();
                    return;
                }
                if (bVar.gwO == 0) {
                    bVar.gwO = e.eL(context);
                }
                if (bVar.JP == 0) {
                    bVar.JP = e.eK(context);
                }
                if (bVar.nhK == 0) {
                    bVar.nhK = view.getMeasuredHeight();
                    if (bVar.nhK <= 0) {
                        bVar.nhK = com.tencent.mm.bp.a.fromDPToPix(context, 15);
                    }
                }
                if (bVar.nhL <= 0) {
                    bVar.nhL = com.tencent.mm.bp.a.fromDPToPix(context, 8);
                }
                if (bVar.nhM <= 0) {
                    bVar.nhM = com.tencent.mm.bp.a.fromDPToPix(context, 3);
                }
                if (bVar.mScreenHeight == 0) {
                    bVar.mScreenHeight = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
                    bVar.mScreenHeight -= bVar.JP;
                    bVar.mScreenHeight -= bVar.gwO;
                }
                if (bVar.nhN == 0) {
                    bVar.nhN = com.tencent.mm.bp.a.fromDPToPix(context, 150);
                }
                if (bVar.nhO == 0) {
                    bVar.nhO = com.tencent.mm.bp.a.fromDPToPix(context, 13);
                }
                bVar.nhD = new NotInterestMenu(context);
                if (bVar.nhy != null) {
                    bVar.nhD.setOnSelectMenuItemListener(bVar.nhy);
                }
                bVar.nhD.setOnClickMenuListener(bVar.nhF);
                bVar.nhD.setSnsInfo(nVar);
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                x.d("MicroMsg.NotInterestMenuHelper", "hateLocation: %s", new Object[]{Arrays.toString(iArr)});
                int i = (((iArr[1] - bVar.gwO) - bVar.JP) + bVar.nhK) - bVar.nhL;
                x.d("MicroMsg.NotInterestMenuHelper", "getDownModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickDownPadding:%d", new Object[]{Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(bVar.gwO), Integer.valueOf(bVar.JP), Integer.valueOf(bVar.nhK), Integer.valueOf(bVar.nhL)});
                x.d("MicroMsg.NotInterestMenuHelper", "isEnoughHeightToDownMenu, y:%d, menuHeight:%d, screenHeight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(bVar.nhN), Integer.valueOf(bVar.mScreenHeight)});
                if (bVar.nhN + i <= bVar.mScreenHeight) {
                    bVar.nhD.setBackgroundResource(i.e.not_interest_dlg_bg_down);
                    bVar.nhS = true;
                } else {
                    bVar.nhD.setBackgroundResource(i.e.not_interest_dlg_bg_up);
                    i = (((iArr[1] - bVar.gwO) - bVar.JP) - bVar.nhN) + bVar.nhM;
                    x.d("MicroMsg.NotInterestMenuHelper", "getUpModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickUpPadding:%d, mMenuHeight:%d", new Object[]{Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(bVar.gwO), Integer.valueOf(bVar.JP), Integer.valueOf(bVar.nhK), Integer.valueOf(bVar.nhM), Integer.valueOf(bVar.nhN)});
                    bVar.nhS = false;
                }
                if (bVar.nhQ == null) {
                    bVar.nhQ = new AbsoluteLayout(context);
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bVar.nhQ.setBackgroundDrawable(context.getResources().getDrawable(i.e.dim_background));
                    bVar.nhQ.setPadding(bVar.nhO, 0, bVar.nhO, 0);
                    bVar.nhQ.setLayoutParams(layoutParams);
                }
                if (bVar.nhE != null) {
                    bVar.nhE.addView(bVar.nhQ);
                }
                bVar.nhQ.addView(bVar.nhD, new AbsoluteLayout.LayoutParams(-1, -2, 0, i));
                bVar.nhD.setVisibility(4);
                if (bVar.nhS) {
                    bVar.nhD.startAnimation(bVar.nhG);
                } else {
                    bVar.nhD.startAnimation(bVar.nhH);
                }
            }
        }
    }

    static /* synthetic */ void b(Context context, n nVar) {
        if (nVar != null && context != null) {
            a(nVar);
            String str = nVar.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str);
            intent.putExtra("sns_permission_snsinfo_svr_id", nVar.field_snsId);
            intent.putExtra("sns_permission_block_scene", 6);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
    }

    static /* synthetic */ void bwD() {
        if (nhl && nhq != 0) {
            String str = nho + "|" + nhp + "|" + nhq;
            g.IW().iP("7").dDS = 4;
            g.IW().iP("7").result = str;
            f.a(g.IW().iP("7"));
            x.d("MicroMsg.NotInteresetABTestManager", "report not interest abtest, scene:%d, result:%s", new Object[]{Integer.valueOf(4), str});
        }
        nhp = -1;
        nho = -1;
        nhq = 0;
    }

    static /* synthetic */ void c(Context context, n nVar) {
        if (nVar != null && context != null) {
            a(nVar);
            Intent intent = new Intent();
            x.i("MicroMsg.NotInteresetABTestManager", "expose id " + nVar.bAK());
            intent.putExtra("showShare", false);
            intent.putExtra("k_expose_msg_id", nVar == null ? 0 : nVar.field_snsId);
            intent.putExtra("k_username", nVar == null ? "" : nVar.field_userName);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public static void d(Context context, ViewGroup viewGroup) {
        if (g.IW().iP("7") != null) {
            nhl = true;
            nhm = g.IW().iP("7").value;
            x.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[]{nhm});
            nhr = viewGroup;
            nhs = new b(viewGroup);
            context = context;
            com.tencent.mm.sdk.b.a.sFg.b(nhu);
            com.tencent.mm.sdk.b.a.sFg.b(nhv);
            nhn = new 3();
            nht = new 4();
            nhs.nhy = nht;
        }
    }

    public static void bwC() {
        if (nhs != null) {
            nhs.bwH();
        }
    }

    private static void a(n nVar) {
        boolean equals = nhm.equals("3");
        if (nVar.field_type == 1) {
            if (equals) {
                nhp = 5;
            } else {
                nhp = 0;
            }
        } else if (nVar.field_type == 2) {
            if (equals) {
                nhp = 4;
            } else {
                nhp = 1;
            }
        } else if (nVar.field_type == 15) {
            if (!equals) {
                nhp = 2;
            }
        } else if (!com.tencent.mm.plugin.sns.data.i.f(nVar)) {
        } else {
            if (equals) {
                nhp = 6;
            } else {
                nhp = 3;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6, com.tencent.mm.plugin.sns.storage.n r7) {
        /*
        r0 = 2;
        r1 = 1;
        r2 = nhl;
        if (r2 == 0) goto L_0x004c;
    L_0x0006:
        if (r7 == 0) goto L_0x004c;
    L_0x0008:
        if (r6 == 0) goto L_0x004c;
    L_0x000a:
        r2 = r7.field_snsId;
        nhq = r2;
        a(r7);
        r2 = new android.content.Intent;
        r3 = com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.class;
        r2.<init>(r6, r3);
        r3 = "sns_info_svr_id";
        r4 = nhq;
        r2.putExtra(r3, r4);
        r3 = "sns_info_not_interest_scene";
        r4 = nhl;
        if (r4 == 0) goto L_0x006a;
    L_0x0027:
        r4 = nhm;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 != 0) goto L_0x006a;
    L_0x002f:
        r4 = nhm;
        r5 = "1";
        r4 = r4.equals(r5);
        if (r4 != 0) goto L_0x0045;
    L_0x003a:
        r4 = nhm;
        r5 = "2";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x004d;
    L_0x0045:
        r0 = r1;
    L_0x0046:
        r2.putExtra(r3, r0);
        r6.startActivity(r2);
    L_0x004c:
        return;
    L_0x004d:
        r4 = nhm;
        r5 = "3";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x006a;
    L_0x0058:
        r4 = com.tencent.mm.plugin.sns.data.i.f(r7);
        if (r4 == 0) goto L_0x0060;
    L_0x005e:
        r0 = 4;
        goto L_0x0046;
    L_0x0060:
        r4 = r7.field_type;
        if (r4 != r1) goto L_0x0066;
    L_0x0064:
        r0 = 3;
        goto L_0x0046;
    L_0x0066:
        r1 = r7.field_type;
        if (r1 == r0) goto L_0x0046;
    L_0x006a:
        r0 = 0;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.abtest.a.a(android.content.Context, com.tencent.mm.plugin.sns.storage.n):void");
    }

    public static void a(ContextMenu contextMenu, n nVar) {
        if (nhl && nhm.equals("3") && nVar != null && !nVar.xb(32) && !nVar.field_userName.equals(af.bxU()) && nVar.field_type != 15) {
            contextMenu.add(0, 13, 0, j.sns_hate_op_un_like);
        }
    }

    public static void a(View view, a$c a_c) {
        if (nhl && !bi.oW(nhm) && !nhm.equals("0")) {
            a_c.ojD = (ImageView) view.findViewById(i.f.sns_hate_item_arrow);
            a_c.ojD.setVisibility(8);
            a_c.ojE = false;
            if (!nhm.equals("3")) {
                a_c.ojD.setOnClickListener(nhn);
            }
        }
    }

    public static void b(n nVar) {
        if (nhl) {
            nhq = nVar.field_snsId;
            a(nVar);
        }
    }

    public static void clean() {
        nhp = -1;
        nho = -1;
        nhq = 0;
        nhn = null;
        nht = null;
        nhr = null;
        context = null;
        nhl = false;
        nhm = "0";
        f.iU("7");
        com.tencent.mm.sdk.b.a.sFg.c(nhu);
        com.tencent.mm.sdk.b.a.sFg.c(nhv);
    }
}
