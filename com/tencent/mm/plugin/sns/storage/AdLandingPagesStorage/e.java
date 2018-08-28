package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.mm.model.c.c;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class e {
    public static int nIr = 750;
    public static int nIs = 10;
    private static Set<a> nIt = null;

    private static boolean wW(int i) {
        if (i == i$l.AppCompatTheme_buttonStyleSmall || i == i$l.AppCompatTheme_checkedTextViewStyle) {
            return false;
        }
        return true;
    }

    private static boolean wX(int i) {
        if (i == i$l.AppCompatTheme_checkedTextViewStyle) {
            return true;
        }
        return false;
    }

    public static float a(double d, int i, int i2, int i3) {
        if (i == 0) {
            return (float) d;
        }
        if (i2 == 0) {
            return (float) d;
        }
        return (float) ad.au((((float) ((WindowManager) com.tencent.mm.sdk.platformtools.ad.getContext().getSystemService("window")).getDefaultDisplay().getWidth()) * (((float) d) * ((float) i3))) / ((float) i2));
    }

    private static s a(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        s sVar;
        int WU = bi.WU((String) map.get(str + ".type"));
        int WU2 = bi.WU((String) map.get(str + ".subType"));
        double WW;
        double WW2;
        int WU3;
        String str2;
        String str3;
        String str4;
        int i5;
        CharSequence charSequence;
        String charSequence2;
        p pVar;
        switch (WU) {
            case 1:
                u uVar = new u();
                uVar.nAX = WU;
                uVar.bID = WU2;
                uVar.nBt = bi.aG((String) map.get(str + ".content"), "");
                uVar.textAlignment = bi.WU((String) map.get(str + ".textAlignment"));
                uVar.nBu = bi.aG((String) map.get(str + ".fontColor"), "");
                uVar.duz = a(bi.WW((String) map.get(str + ".fontSize")), i, i2, i3);
                uVar.nBv = (bi.WU((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & u.nBo) > 0;
                uVar.nBw = (bi.WU((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & u.nBp) > 0;
                uVar.nBx = (bi.WU((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & u.nBq) > 0;
                uVar.maxLines = bi.WU((String) map.get(str + ".maxLines"));
                uVar.nBy = bi.WU((String) map.get(str + ".fontType"));
                sVar = uVar;
                break;
            case 21:
                l lVar;
                if (WU2 == 2) {
                    b bVar = new b();
                    bVar.bPS = (String) map.get(str + ".appid");
                    bVar.nAg = (String) map.get(str + ".appPageUrlAndroid");
                    bVar.channelId = (String) map.get(str + ".channelId");
                    bVar.rU = (String) map.get(str + ".pkg");
                    bVar.nzV = bi.WU((String) map.get(str + ".platform"));
                    bVar.nzW = (String) map.get(str + ".warningAndroid");
                    bVar.nzX = (String) map.get(str + ".btnBgColorTheme");
                    bVar.nzZ = (String) map.get(str + ".btnBgColorThemePressed");
                    bVar.nzY = (String) map.get(str + ".btnBgColorThemeDisable");
                    bVar.nAa = (String) map.get(str + ".btnBorderColorTheme");
                    bVar.nAc = (String) map.get(str + ".btnBorderColorThemePressed");
                    bVar.nAb = (String) map.get(str + ".btnBorderColorThemeDisable");
                    bVar.nAd = (String) map.get(str + ".fontColor");
                    bVar.nAf = (String) map.get(str + ".fontColorPressed");
                    bVar.nAe = (String) map.get(str + ".fontColorDisable");
                    lVar = bVar;
                } else if (WU2 == 4) {
                    f fVar = new f();
                    fVar.hvN = bi.aG((String) map.get(str + ".cardTpId"), "");
                    fVar.hwD = bi.aG((String) map.get(str + ".cardExt"), "");
                    lVar = fVar;
                } else if (WU2 == 7) {
                    k kVar = new k();
                    kVar.nAm = bi.aG((String) map.get(str + ".jumpCanvasId"), "");
                    kVar.nAn = bi.aG((String) map.get(str + ".jumpCanvasExt"), "");
                    kVar.nAo = bi.WU((String) map.get(str + ".jumpCanvasNoStore"));
                    kVar.nAp = bi.WU((String) map.get(str + ".btnCanvasEnterType"));
                    kVar.nAq = bi.WU((String) map.get(str + ".btnCanvasSource"));
                    lVar = kVar;
                } else if (WU2 == 8) {
                    j jVar = new j();
                    jVar.username = (String) map.get(str + ".weappUserName");
                    jVar.cbs = (String) map.get(str + ".weappPath");
                    lVar = jVar;
                } else if (WU2 == 9) {
                    WW = bi.WW((String) map.get(str + ".location.$x"));
                    WW2 = bi.WW((String) map.get(str + ".location.$y"));
                    WU3 = bi.WU((String) map.get(str + ".location.$scale"));
                    str2 = (String) map.get(str + ".location.$label");
                    str3 = (String) map.get(str + ".location.$poiname");
                    if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                        return null;
                    }
                    lVar = new g(new a(WW, WW2, WU3, str2, str3));
                } else if (WU2 == 10) {
                    str4 = str + ".phoneNumList.phoneNum";
                    List arrayList = new ArrayList();
                    i5 = 0;
                    while (true) {
                        if (i5 == 0) {
                            charSequence2 = (String) map.get(str4);
                        } else {
                            charSequence2 = (String) map.get(str4 + i5);
                        }
                        if (!TextUtils.isEmpty(charSequence2)) {
                            arrayList.add(charSequence2);
                            i5++;
                        } else if (arrayList.isEmpty()) {
                            return null;
                        } else {
                            lVar = new i(arrayList);
                        }
                    }
                } else {
                    lVar = new l();
                }
                lVar.nAX = WU;
                lVar.bID = WU2;
                lVar.title = bi.aG((String) map.get(str + ".btnTitle"), "");
                lVar.nAr = bi.WU((String) map.get(str + ".btnType"));
                lVar.nAs = bi.aG((String) map.get(str + ".btnJumpUrl"), "");
                lVar.nAt = bi.aG((String) map.get(str + ".btnJumpApp"), "");
                lVar.nAu = bi.aG((String) map.get(str + ".fontColor"), "");
                lVar.azb = a(bi.WW((String) map.get(str + ".fontSize")), i, i2, i3);
                lVar.textAlignment = bi.WU((String) map.get(str + ".btnAlignment"));
                lVar.nAv = a(bi.WW((String) map.get(str + ".borderSize")), i, i2, i3);
                lVar.height = a(bi.WW((String) map.get(str + ".btnHeight")), i, i2, i3);
                lVar.nAw = bi.aG((String) map.get(str + ".btnBgColorTheme"), "");
                lVar.nAx = bi.aG((String) map.get(str + ".btnBorderColorTheme"), "");
                lVar.nAy = bi.aG((String) map.get(str + ".btnBgImgUrl"), "");
                lVar.nAz = bi.WU((String) map.get(str + ".bCanLongPress"));
                lVar.nAA = bi.WU((String) map.get(str + ".bHideActionSheet"));
                lVar.nAB = bi.WU((String) map.get(str + ".hideProductActionHeader"));
                lVar.nAC = bi.WU((String) map.get(str + ".showProductActionCancelButton"));
                lVar.nAE = bi.aG((String) map.get(str + ".productActionTitle"), "");
                lVar.nAD = bi.aG((String) map.get(str + ".productActionBuffer"), "");
                lVar.nAF = bi.aG((String) map.get(str + ".productActionIconUrl"), "");
                if (map.containsKey(str + ".productActionItem.componentItem.type")) {
                    lVar.nAG = a((Map) map, i, i3, i2, i4, str + ".productActionItem.componentItem");
                }
                sVar = lVar;
                break;
            case i$l.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                pVar = new p();
                pVar.nAX = WU;
                pVar.bID = WU2;
                pVar.nAL = bi.aG((String) map.get(str + ".pureImageUrl"), "");
                pVar.nAM = bi.aG((String) map.get(str + ".bgColor"), "");
                if (map.containsKey(str + ".bgColorAlpha") && pVar.nAM.length() > 0) {
                    Map<String, String> map2 = map;
                    pVar.nAM = String.format("#%02x%s", new Object[]{Integer.valueOf((int) (bi.WW((String) map2.get(str + ".bgColorAlpha")) * 255.0d)), pVar.nAM.substring(1)});
                }
                pVar.width = a(bi.WW((String) map.get(str + ".imageWidth")), i, i2, i3);
                pVar.height = a(bi.WW((String) map.get(str + ".imageHeight")), i, i2, i3);
                pVar.nAI = false;
                sVar = pVar;
                break;
            case i$l.AppCompatTheme_listDividerAlertDialog /*44*/:
                o oVar = new o();
                oVar.nAX = WU;
                oVar.bID = WU2;
                oVar.nAL = bi.aG((String) map.get(str + ".panoramaImageUrl"), "");
                oVar.width = a(bi.WW((String) map.get(str + ".imageWidth")), i, i2, i3);
                oVar.height = a(bi.WW((String) map.get(str + ".imageHeight")), i, i2, i3);
                sVar = oVar;
                break;
            case i$l.AppCompatTheme_actionDropDownStyle /*45*/:
                pVar = new p();
                pVar.nAX = WU;
                pVar.bID = WU2;
                pVar.nAL = bi.aG((String) map.get(str + ".fullScreenImageUrl"), "");
                pVar.nAI = true;
                sVar = pVar;
                break;
            case i$l.AppCompatTheme_popupWindowStyle /*61*/:
                q qVar = new q();
                qVar.nAX = WU;
                qVar.bID = WU2;
                qVar.nAN = bi.aG((String) map.get(str + ".sightVideoUrl"), "");
                qVar.nAO = bi.aG((String) map.get(str + ".sightThumbUrl"), "");
                qVar.nAP = bi.aG((String) map.get(str + ".streamVideoUrl"), "");
                qVar.nAQ = bi.aG((String) map.get(str + ".jumpText"), "");
                qVar.nAm = bi.aG((String) map.get(str + ".jumpCanvasId"), "");
                qVar.nAn = bi.aG((String) map.get(str + ".jumpCanvasExt"), "");
                qVar.nAo = bi.WU((String) map.get(str + ".jumpCanvasNoStore"));
                try {
                    qVar.nAR = Color.parseColor((String) map.get(str + ".jumpTextColor"));
                } catch (Exception e) {
                    qVar.nAR = Color.rgb(255, 255, 255);
                }
                try {
                    qVar.nAS = Color.parseColor((String) map.get(str + ".separatorColor"));
                } catch (Exception e2) {
                    qVar.nAS = Color.rgb(255, 255, 255);
                }
                qVar.width = a(bi.WW((String) map.get(str + ".sightDisplayWidth")), i, i2, i3);
                qVar.height = a(bi.WW((String) map.get(str + ".sightDisplayHeight")), i, i2, i3);
                qVar.nAT = bi.WU((String) map.get(str + ".sightDisplayType"));
                sVar = qVar;
                break;
            case i$l.AppCompatTheme_editTextColor /*62*/:
                w wVar = new w();
                wVar.nAX = WU;
                wVar.bID = WU2;
                wVar.nAP = bi.aG((String) map.get(str + ".streamVideoUrl"), "");
                wVar.nBz = bi.aG((String) map.get(str + ".streamVideoThumb"), "");
                wVar.width = a(bi.WW((String) map.get(str + ".streamDisplayWidth")), i, i2, i3);
                wVar.height = a(bi.WW((String) map.get(str + ".streamDisplayHeight")), i, i2, i3);
                wVar.nBA = bi.WU((String) map.get(str + ".streamDisplayType"));
                sVar = wVar;
                break;
            case i$l.AppCompatTheme_listChoiceBackgroundIndicator /*81*/:
                v vVar = new v();
                vVar.nAX = WU;
                vVar.bID = WU2;
                vVar.kck = bi.aG((String) map.get(str + ".webviewUrl"), "");
                sVar = vVar;
                break;
            case i$l.AppCompatTheme_colorPrimary /*82*/:
                x xVar = new x();
                xVar.url = bi.aG((String) map.get(str + ".webviewUrl"), "");
                sVar = xVar;
                break;
            case i$l.AppCompatTheme_checkboxStyle /*102*/:
                sVar = c(map, str, i, i2, i3, i4);
                break;
            case i$l.AppCompatTheme_editTextStyle /*104*/:
                List b = b(map, str, i, i2, i3, i4);
                sVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
                sVar.ayR = b;
                break;
            case 121:
            case 122:
                int argb;
                double a = (double) a(bi.WW((String) map.get(str + ".topLineSize")), i, i2, i3);
                double a2 = (double) a(bi.WW((String) map.get(str + ".bottomLineSize")), i, i2, i3);
                if (wY(i4)) {
                    argb = Color.argb(51, 0, 0, 0);
                } else {
                    argb = Color.argb(51, 255, 255, 255);
                }
                if (WU != 121) {
                    if (WU != 122) {
                        sVar = null;
                        break;
                    }
                    str4 = str + ".phoneNumList.phoneNum";
                    List arrayList2 = new ArrayList();
                    i5 = 0;
                    while (true) {
                        if (i5 == 0) {
                            charSequence2 = (String) map.get(str4);
                        } else {
                            charSequence2 = (String) map.get(str4 + i5);
                        }
                        if (!TextUtils.isEmpty(charSequence2)) {
                            arrayList2.add(charSequence2);
                            i5++;
                        } else if (!arrayList2.isEmpty()) {
                            sVar = new d(a, a2, argb, arrayList2);
                            break;
                        } else {
                            return null;
                        }
                    }
                }
                WW = bi.WW((String) map.get(str + ".location.$x"));
                WW2 = bi.WW((String) map.get(str + ".location.$y"));
                WU3 = bi.WU((String) map.get(str + ".location.$scale"));
                str2 = (String) map.get(str + ".location.$label");
                str3 = (String) map.get(str + ".location.$poiname");
                if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
                    h hVar = new h(a, a2, new h.a(WW, WW2, WU3, str2, str3), argb);
                    break;
                }
                return null;
                break;
            case 131:
                t tVar = new t();
                tVar.nAX = WU;
                tVar.bID = WU2;
                tVar.label = bi.aG((String) map.get(str + ".label"), "");
                tVar.value = (float) bi.WW((String) map.get(str + ".value"));
                tVar.nBn = bi.aG((String) map.get(str + ".foregroundImage"), "");
                tVar.azb = a(bi.WW((String) map.get(str + ".fontSize")), i, i2, i3);
                tVar.fpc = bi.aG((String) map.get(str + ".backgroundColor"), "");
                sVar = tVar;
                break;
            case 132:
                sVar = a(map, str, i, i2, i3);
                break;
            default:
                return null;
        }
        if (sVar == null) {
            return sVar;
        }
        sVar.nBe = wY(i4);
        sVar.type = WU;
        sVar.bID = WU2;
        a(sVar, (Map) map, str, i, i2, i3);
        return sVar;
    }

    private static y a(Map<String, String> map, String str, int i, int i2, int i3) {
        y yVar = new y();
        try {
            String str2 = str + ".radarChart";
            yVar.nBB = (String) map.get(str2 + ".borderImg");
            yVar.nBH = (String) map.get(str2 + ".maskImg");
            yVar.nBC = (String) map.get(str2 + ".coverColor");
            yVar.nBD = Color.parseColor((String) map.get(str2 + ".labelFont.$color"));
            yVar.nBE = (int) a(bi.WW((String) map.get(str2 + ".labelFont.$size")), i, i2, i3);
            yVar.nBF = Color.parseColor((String) map.get(str2 + ".scoreFont.$color"));
            yVar.nBG = (int) a(bi.WW((String) map.get(str2 + ".scoreFont.$size")), i, i2, i3);
            yVar.borderWidth = a(bi.WW((String) map.get(str2 + ".borderImgWidth")), i, i2, i3);
            String str3 = str2 + ".itemList.item";
            int i4 = 0;
            while (true) {
                if (i4 != 0) {
                    str2 = str3 + i4;
                } else {
                    str2 = str3;
                }
                y.a aVar = new y.a();
                aVar.label = (String) map.get(str2 + ".label");
                aVar.nBI = (String) map.get(str2 + ".score");
                aVar.value = (float) bi.WW((String) map.get(str2 + ".value"));
                if (TextUtils.isEmpty(aVar.label) && TextUtils.isEmpty(aVar.nBI)) {
                    break;
                }
                yVar.mLN.add(aVar);
                i4++;
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", bi.i(e));
        }
        return yVar;
    }

    private static List<s> b(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        List<s> arrayList = new ArrayList();
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            s a = a((Map) map, i, i3, i2, i4, str3);
            if (a == null) {
                return arrayList;
            }
            if (a.nBi) {
                arrayList.add(a);
            } else {
                com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
            }
            i5++;
        }
    }

    private static m c(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        int parseColor;
        m mVar = new m();
        try {
            parseColor = Color.parseColor((String) map.get(str + ".bgColorTheme"));
            mVar.backgroundColor = (((int) (bi.getDouble((String) map.get(str + ".bgColorAlpha"), 0.0d) * 255.0d)) << 24) | (parseColor & 16777215);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "%s", new Object[]{bi.i(e)});
            mVar.backgroundColor = Color.argb(51, 0, 0, 0);
        }
        String str2 = (str + ".componentGroupList") + ".componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            parseColor = bi.WU((String) map.get(str3 + ".type"));
            s sVar = null;
            if (wW(parseColor)) {
                sVar = a((Map) map, str3, i, i2, i3, i4);
            }
            if (sVar == null) {
                return mVar;
            }
            if (sVar.nBi) {
                mVar.nAH.add(sVar);
            }
            i5++;
        }
    }

    private static n d(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        s nVar = new n();
        a(nVar, (Map) map, str, i, i2, i3);
        nVar.nAJ = bi.WU((String) map.get(str + ".pageCtrType"));
        nVar.nAK = bi.WU((String) map.get(new StringBuilder().append(str).append(".isFullScreen").toString())) == 1;
        String str2 = str + ".componentGroupList.componentGroup";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            m mVar = new m();
            String str4 = str3 + ".componentItem";
            int i6 = 0;
            while (true) {
                String str5;
                if (i6 == 0) {
                    str5 = str4;
                } else {
                    str5 = str4 + i6;
                }
                int WU = bi.WU((String) map.get(str5 + ".type"));
                s sVar = null;
                if (wW(WU)) {
                    sVar = a((Map) map, str5, i, i2, i3, i4);
                }
                if (sVar == null) {
                    break;
                }
                if (sVar.nBi) {
                    mVar.nAH.add(sVar);
                }
                i6++;
            }
            if (mVar.nAH.size() == 0) {
                return nVar;
            }
            nVar.nAH.add(mVar);
            i5++;
        }
    }

    private static void a(s sVar, Map<String, String> map, String str, int i, int i2, int i3) {
        boolean z = true;
        sVar.nAX = bi.WU((String) map.get(str + ".type"));
        sVar.type = sVar.nAX;
        sVar.nAW = bi.aG((String) map.get(str + ".id"), "");
        sVar.nAY = a(bi.WW((String) map.get(str + ".paddingTop")), i, i2, i3);
        sVar.nAZ = a(bi.WW((String) map.get(str + ".paddingBottom")), i, i2, i3);
        sVar.nBa = a(bi.WW((String) map.get(str + ".paddingLeft")), i, i2, i3);
        sVar.nBb = a(bi.WW((String) map.get(str + ".paddingRight")), i, i2, i3);
        sVar.bID = bi.WU((String) map.get(str + ".subType"));
        sVar.nBf = bi.aG((String) map.get(str + ".cellBackgroundColor"), "");
        String str2 = str + ".if";
        if (map.containsKey(str2)) {
            sVar.nBi = "1".equals(map.get(str2));
        } else {
            sVar.nBi = true;
        }
        str2 = str + ".noReport";
        if (map.containsKey(str2)) {
            if (!"1".equals(map.get(str2))) {
                z = false;
            }
            sVar.nBj = z;
        } else {
            sVar.nBj = false;
        }
        Object aG = bi.aG((String) map.get(str + ".layoutWidth"), "");
        Object aG2 = bi.aG((String) map.get(str + ".layoutHeight"), "");
        if (TextUtils.isEmpty(aG)) {
            sVar.nBc = 2.14748365E9f;
        } else {
            double WW = bi.WW(aG);
            if (WW < 0.0d) {
                sVar.nBc = (float) WW;
            } else {
                sVar.nBc = a(WW, i, i2, i3);
            }
        }
        if (TextUtils.isEmpty(aG2)) {
            sVar.nBd = 2.14748365E9f;
        } else {
            double WW2 = bi.WW(aG2);
            if (WW2 < 0.0d) {
                sVar.nBd = (float) WW2;
            } else {
                sVar.nBd = a(WW2, i, i2, i3);
            }
        }
        str2 = (String) map.get(str + ".verticalAlignment");
        String str3 = (String) map.get(str + ".horizontalAlignment");
        if (TextUtils.isEmpty(str2)) {
            sVar.nBg = -1;
        } else {
            sVar.nBg = bi.WU(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            sVar.nBh = -1;
        } else {
            sVar.nBh = bi.WU(str3);
        }
    }

    private static s e(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        s rVar = new r();
        rVar.nAV = bi.WU((String) map.get(str + ".subType"));
        a(rVar, (Map) map, str, i, i2, i3);
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            int WU = bi.WU((String) map.get(str3 + ".type"));
            s sVar = null;
            if (wW(WU)) {
                sVar = a((Map) map, str3, i, i2, i3, i4);
            } else if (wX(WU)) {
                sVar = e(map, str3, i, i2, i3, i4);
            }
            if (sVar == null) {
                return rVar;
            }
            if (sVar.nBi) {
                rVar.nAU.add(sVar);
            }
            i5++;
        }
    }

    public static LinkedList<c> p(String str, String str2, String str3, String str4) {
        LinkedList<c> linkedList = new LinkedList();
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        String str5 = "";
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("\\{\\{.*?\\}\\}", str5);
        }
        Map z = bl.z(str, str2);
        if (z == null) {
            com.tencent.mm.sdk.platformtools.x.w("AdLandingPagesParseHelper", " parse landingpages xml is error ," + str);
            return linkedList;
        }
        int i;
        String str6;
        int WU = bi.WU((String) z.get("." + str2 + ".adCanvasInfo.sizeType"));
        int WU2 = bi.WU((String) z.get("." + str2 + ".adCanvasInfo.basicRootFontSize"));
        int WU3 = bi.WU((String) z.get("." + str2 + ".adCanvasInfo.basicWidth"));
        if (WU2 == 0 && WU == 1) {
            i = nIs;
        } else {
            i = WU2;
        }
        if (WU3 == 0 && WU == 1) {
            WU3 = nIr;
        }
        String str7 = ".adCanvasInfo.PageList.Page";
        if (bi.oW(str2) || str7.equals("adCanvasInfo")) {
            str6 = str7;
        } else {
            str6 = "." + str2 + str7;
        }
        int i2 = 0;
        while (true) {
            String str8;
            if (i2 == 0) {
                str8 = str6;
            } else {
                str8 = str6 + i2;
            }
            c cVar = new c();
            cVar.nIg = bi.aG((String) z.get(str8 + ".backgroundCover"), "");
            cVar.fpc = bi.aG((String) z.get(str8 + ".backgroundColor"), "");
            cVar.nIh = bi.WU((String) z.get(new StringBuilder().append(str8).append(".backgroundCover.$isAddBlur").toString())) > 0;
            cVar.id = i2;
            str7 = str8 + ".if";
            if (z.containsKey(str7)) {
                cVar.nBi = "1".equals(z.get(str7));
            } else {
                cVar.nBi = true;
            }
            if (cVar.nBi) {
                String str9 = str8 + ".componentItemList.componentItem";
                int i3 = 0;
                while (true) {
                    s a;
                    if (i3 == 0) {
                        str8 = str9;
                    } else {
                        str8 = str9 + i3;
                    }
                    try {
                        a = a(z, WU, i, WU3, !TextUtils.isEmpty(cVar.fpc) ? Color.parseColor(cVar.fpc) : 0, str8);
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", bi.i(e));
                        a = a(z, WU, i, WU3, 0, str8);
                    }
                    if (a == null) {
                        break;
                    }
                    if (a.nBi) {
                        if (a.type == 21) {
                            ((l) a).nyj = str4;
                            ((l) a).nyk = str3;
                        }
                        a(a, z, str8, WU, WU3, i);
                        cVar.nIi.add(a);
                    } else {
                        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
                    }
                    i3++;
                }
                if (cVar.nIi.size() == 0) {
                    break;
                }
                linkedList.add(cVar);
            }
            i2++;
        }
        if (linkedList.size() > 0) {
            ((c) linkedList.get(0)).nIj = true;
        }
        return linkedList;
    }

    private static s a(Map<String, String> map, int i, int i2, int i3, int i4, String str) {
        int WU = bi.WU((String) map.get(str + ".type"));
        if (wW(WU)) {
            try {
                return a((Map) map, str, i, i3, i2, i4);
            } catch (Exception e) {
                return a((Map) map, str, i, i3, i2, 0);
            }
        }
        Object obj;
        if (WU == i$l.AppCompatTheme_buttonStyleSmall) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return d(map, str, i, i3, i2, i4);
        }
        if (wX(WU)) {
            return e(map, str, i, i3, i2, i4);
        }
        com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the type" + WU + " is not client known type");
        return null;
    }

    public static LinkedList<c> d(String str, String str2, String str3, String str4, String str5) {
        String str6 = new String(str);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "the jsonObject is " + jSONObject.toString());
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str7;
                Object next = keys.next();
                if (next != null && (next instanceof String)) {
                    str7 = (String) next;
                    String string = jSONObject.getString(str7);
                    if (!bi.oW(string)) {
                        str7 = str6.replace("{{" + str7 + "}}", "<![CDATA[" + string + "]]>");
                        str6 = str7;
                    }
                }
                str7 = str6;
                str6 = str7;
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the json is parsed error : " + str);
        }
        return p(str6, str2, str4, str5);
    }

    private static boolean wY(int i) {
        int i2 = i | -16777216;
        return i2 - -16777216 > -1 - i2;
    }

    private static boolean Ne(String str) {
        return bi.WU(bi.aG((String) bl.z(str, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1;
    }

    private static boolean b(String str, Context context, boolean z, int i) {
        String str2 = (String) bl.z(str, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (z) {
            try {
                str2 = l(str2, "exp=" + c.Jy().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + i);
            } catch (URISyntaxException e) {
            }
            com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "canvas jump url " + str2);
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str2);
        intent.putExtra("showShare", true);
        com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    public static String l(String str, String... strArr) {
        URI uri = new URI(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append).append("&");
        }
        if (stringBuilder.length() <= 1) {
            return str;
        }
        String stringBuilder2;
        StringBuilder deleteCharAt = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String query = uri.getQuery();
        if (query == null) {
            stringBuilder2 = deleteCharAt.toString();
        } else {
            stringBuilder2 = query + "&" + deleteCharAt.toString();
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder2, uri.getFragment()).toString();
    }

    public static String m(String str, String... strArr) {
        if (str == null) {
            str = "";
        }
        String join = TextUtils.join("&", strArr);
        String str2 = "?";
        if (str.contains("?")) {
            str2 = "&";
        }
        if (!str.contains("#")) {
            return str + str2 + join;
        }
        try {
            int indexOf = str.indexOf("#");
            String substring = str.substring(0, indexOf);
            return substring + str2 + join + str.substring(indexOf + 1);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "append url params failed, %s", new Object[]{e.toString()});
            return str;
        }
    }

    private static boolean bAA() {
        com.tencent.mm.storage.c fJ = c.Jx().fJ("100150");
        if (!fJ.isValid()) {
            return false;
        }
        int i = bi.getInt((String) fJ.ckq().get("openCanvas"), 0);
        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=" + i);
        if (i == 1) {
            return true;
        }
        return false;
    }

    public static boolean y(Intent intent, Context context) {
        int i = 0;
        String stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (TextUtils.isEmpty(stringExtra) || !eL(stringExtra, "adCanvasInfo")) {
                com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[]{stringExtra});
            } else {
                String str = "";
                boolean Ne = Ne(stringExtra);
                if (Ne) {
                    str = c.Jy().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    if (TextUtils.isEmpty(str)) {
                        i = bAA();
                    } else {
                        int da = c.Jy().da("Sns_Canvas_GameShare_JumpWay", 0);
                        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "abtestvalue = " + da);
                        if (da != 0) {
                            i = 1;
                        }
                    }
                } else {
                    i = 1;
                }
                if (i == 0) {
                    return b(stringExtra, context, Ne, intent.getIntExtra("sns_landig_pages_from_source", -1));
                }
                Intent intent2 = new Intent(intent);
                intent2.setClass(context, SnsAdNativeLandingPagesUI.class);
                intent2.putExtra("sns_landing_pages_expid", str);
                context.startActivity(intent2);
                return true;
            }
        }
        return false;
    }

    public static boolean a(bsu bsu, Activity activity) {
        String str = bsu.ogR;
        long longValue = new BigInteger(bsu.ksA).longValue();
        List list = bsu.sqc.ruA;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str) || !eL(str, "adCanvasInfo")) {
                com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[]{str});
            } else {
                boolean z;
                String str2 = "";
                boolean Ne = Ne(str);
                if (Ne) {
                    str2 = c.Jy().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    z = c.Jy().da("Sns_Canvas_GameShare_JumpWay", 0) != 0;
                    if (!z && bAA()) {
                        z = true;
                    }
                } else {
                    z = true;
                }
                if (z) {
                    com.tencent.mm.plugin.sns.storage.n fi = af.byo().fi(longValue);
                    Intent intent = new Intent();
                    if (fi != null) {
                        intent.putExtra("sns_landing_pages_share_sns_id", fi.bAK());
                        intent.putExtra("sns_landing_pages_rawSnsId", fi.bAJ().ksA);
                        intent.putExtra("sns_landing_pages_ux_info", fi.bBo());
                        intent.putExtra("sns_landing_pages_aid", fi.bBj());
                        intent.putExtra("sns_landing_pages_traceid", fi.bBk());
                        intent.putExtra("sns_landing_pages_rec_src", fi.bBq());
                    }
                    if (list != null && list.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(0)).rVE);
                    }
                    intent.putExtra("sns_landing_pages_expid", str2);
                    intent.putExtra("sns_landig_pages_from_source", 11);
                    intent.setClass(activity, SnsAdNativeLandingPagesUI.class);
                    intent.putExtra("sns_landing_pages_xml", str);
                    intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                    activity.startActivity(intent);
                    return true;
                }
                b(str, activity, Ne, 11);
            }
        }
        return false;
    }

    public static boolean Nf(String str) {
        return eL(str, "adCanvasInfo");
    }

    public static boolean eL(String str, String str2) {
        InputStream inputStream = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        int eventType;
        String name;
        if (nIt == null && nIt == null) {
            nIt = new HashSet();
            try {
                inputStream = com.tencent.mm.sdk.platformtools.ad.getContext().getAssets().open("sns/canvas_valid_type.xml");
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                newPullParser.setInput(inputStream, "UTF-8");
                int i = -1;
                int i2 = -1;
                eventType = newPullParser.getEventType();
                while (eventType != 1) {
                    int i3;
                    if (eventType == 2) {
                        boolean z;
                        name = newPullParser.getName();
                        if ("canvastype".equals(name)) {
                            i2 = 0;
                            z = false;
                        } else if ("pagetype".equals(name)) {
                            i2 = 1;
                            z = true;
                        } else if ("componenttype".equals(name)) {
                            i2 = 2;
                            z = true;
                        } else {
                            z = "subtype".equals(name) ? true : true;
                        }
                        if (!z) {
                            i3 = bi.getInt(newPullParser.getAttributeValue(null, "android"), 0) == 1 ? bi.getInt(newPullParser.getAttributeValue(null, "val"), -1) : -1;
                            switch (z) {
                                case false:
                                case true:
                                case true:
                                    break;
                                case true:
                                    if (!(i2 == -1 || i == -1 || i3 == -1)) {
                                        a aVar = new a((byte) 0);
                                        aVar.nIu = i2;
                                        aVar.nIv = i;
                                        aVar.nIw = i3;
                                        nIt.add(aVar);
                                        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "valid canvas type " + aVar);
                                        break;
                                    }
                            }
                        }
                    }
                    i3 = i;
                    eventType = newPullParser.next();
                    i = i3;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", bi.i(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", bi.i(e22));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
            }
        }
        if (nIt == null || nIt.isEmpty()) {
            return false;
        }
        Map z2 = bl.z(str, str2);
        if (z2 == null || z2.isEmpty()) {
            com.tencent.mm.sdk.platformtools.x.w("AdLandingPagesParseHelper", "invalid landingpages xml," + str);
            return false;
        }
        a aVar2 = new a((byte) 0);
        aVar2.nIu = 0;
        aVar2.nIv = bi.WU((String) z2.get(".adCanvasInfo.type"));
        aVar2.nIw = bi.WU((String) z2.get(".adCanvasInfo.subtype"));
        if (nIt.contains(aVar2)) {
            String str3 = ".adCanvasInfo.PageList.Page";
            int i4 = 0;
            while (true) {
                String str4;
                aVar2.nIu = 1;
                if (i4 == 0) {
                    str4 = str3;
                } else {
                    str4 = str3 + i4;
                }
                if (z2.containsKey(str4 + ".componentItemList.componentItem.type")) {
                    aVar2.nIv = bi.WU((String) z2.get(str4 + ".type"));
                    aVar2.nIw = bi.WU((String) z2.get(str4 + ".subType"));
                    if (nIt.contains(aVar2)) {
                        String str5 = str4 + ".componentItemList.componentItem";
                        aVar2.nIu = 2;
                        eventType = 0;
                        while (true) {
                            if (eventType == 0) {
                                str4 = str5;
                            } else {
                                str4 = str5 + eventType;
                            }
                            if (z2.containsKey(str4 + ".type")) {
                                aVar2.nIv = bi.WU((String) z2.get(str4 + ".type"));
                                aVar2.nIw = bi.WU((String) z2.get(str4 + ".subType"));
                                if (nIt.contains(aVar2)) {
                                    eventType++;
                                } else {
                                    com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid component type " + aVar2);
                                    return false;
                                }
                            }
                            i4++;
                        }
                    } else {
                        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid page type " + aVar2);
                        return false;
                    }
                }
                aVar2.nIu = 2;
                for (Entry entry : z2.entrySet()) {
                    if (entry.getKey() != null && ((String) entry.getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")) {
                        name = (String) entry.getKey();
                        String replace = ((String) entry.getKey()).replace(".type", ".subType");
                        aVar2.nIv = bi.WU((String) z2.get(name));
                        aVar2.nIw = bi.WU((String) z2.get(replace));
                        if (!nIt.contains(aVar2)) {
                            com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid component type " + aVar2);
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "invalid canvas type " + aVar2);
        return false;
    }

    public static String w(com.tencent.mm.plugin.sns.storage.n nVar) {
        if (nVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the snsinfo is null");
            return null;
        } else if (nVar.xb(32)) {
            com.tencent.mm.plugin.sns.storage.e bBp = nVar.bBp();
            if (bBp == null) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
                return null;
            }
            com.tencent.mm.plugin.sns.storage.b bAF = nVar.bAF();
            if (bAF == null) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the adxml is null");
                return null;
            }
            com.tencent.mm.plugin.sns.storage.a bAH = nVar.bAH();
            if (bAH == null) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the adInfo is null");
                return null;
            } else if (!bAF.bzm()) {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
                return null;
            } else if (bAH.nym != null && bAH.nym.size() != 0) {
                return o(bBp.field_adxml, bAH.nym);
            } else {
                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
                return null;
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
            return null;
        }
    }

    public static String o(String str, Map<String, String> map) {
        if (str == null || str.length() == 0) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
            return null;
        } else if (map == null || map.size() == 0) {
            com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
            return null;
        } else {
            LinkedList p = p(str, "adxml", "adId", "");
            for (String str2 : map.keySet()) {
                if (!bi.oW(str2)) {
                    String str3 = (String) map.get(str2);
                    if (!bi.oW(str3)) {
                        String str4;
                        Iterator it = p.iterator();
                        String str5 = null;
                        while (it.hasNext()) {
                            Iterator it2 = ((c) it.next()).nIi.iterator();
                            while (it2.hasNext()) {
                                s sVar = (s) it2.next();
                                if ((sVar instanceof f) && !bi.oW(((f) sVar).hvN) && ((f) sVar).hvN.equals(str2)) {
                                    str4 = ((f) sVar).hwD;
                                    break;
                                }
                            }
                            str4 = str5;
                            if (str4 != null) {
                                break;
                            }
                            str5 = str4;
                        }
                        str4 = str5;
                        if (!bi.oW(r2)) {
                            com.tencent.mm.sdk.platformtools.x.i("AdLandingPagesParseHelper", "old card ext is " + r2 + " and new card ext is " + str3);
                            str = str.replace(r2, str3);
                            try {
                                str = str.replace(bi.WS(r2), bi.WS(str3));
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.x.e("AdLandingPagesParseHelper", "the xml is error");
                            }
                        }
                    }
                }
            }
            return str;
        }
    }
}
