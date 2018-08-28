package com.tencent.mm.ac;

import android.graphics.Bitmap;
import com.tencent.mm.aa.f;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    static boolean b(d dVar) {
        if (dVar == null) {
            x.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
            return false;
        } else if (!LP()) {
            return false;
        } else {
            int i = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("MMBizAttrSyncFreq", -1);
            if (i == -1) {
                x.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
                i = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = dVar.field_incrementUpdateTime;
            String str = dVar.field_attrSyncVersion;
            x.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(j), Integer.valueOf(i), str});
            return currentTimeMillis - j >= ((long) i) * 1000;
        }
    }

    public static boolean LP() {
        int i;
        Object obj = g.Ei().DT().get(com.tencent.mm.storage.aa.a.sQF, null);
        if (obj == null || !(obj instanceof Integer)) {
            x.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
            i = 1;
        } else {
            i = ((Integer) obj).intValue();
        }
        x.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", new Object[]{Integer.valueOf(i)});
        if (i == 1) {
            return true;
        }
        return false;
    }

    public final boolean km(String str) {
        if (bi.oW(str)) {
            x.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
            return false;
        }
        x.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
        d kA = z.MY().kA(str);
        if (b(kA)) {
            g.Eh().dpP.a(new p(str, kA.field_attrSyncVersion, new 1(this, new WeakReference(null), str)), 0);
            return true;
        }
        x.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
        return false;
    }

    public static boolean a(ab abVar, d dVar, List<hr> list) {
        if (abVar == null || list == null || list.size() == 0) {
            x.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
            return false;
        }
        String str = abVar.field_username;
        if (abVar.ckW()) {
            if (dVar == null) {
                dVar = z.MY().kA(str);
            }
            if (dVar == null) {
                x.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", new Object[]{str});
                return false;
            }
            JSONObject jSONObject;
            j kc = q.KH().kc(str);
            try {
                if (bi.oW(dVar.field_extInfo)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(dVar.field_extInfo);
                }
            } catch (Exception e) {
                x.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", new Object[]{e});
                jSONObject = new JSONObject();
            }
            long j = -1;
            long j2 = (long) abVar.field_type;
            int i = 0;
            Object obj = null;
            for (hr hrVar : list) {
                if (hrVar == null) {
                    x.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
                } else {
                    Object obj2;
                    String str2 = hrVar.riD;
                    x.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", new Object[]{str2, hrVar.mEl});
                    String str3 = hrVar.mEl;
                    if (!"UserName".equals(str2)) {
                        if ("NickName".equals(str2)) {
                            abVar.dx(str3);
                        } else if ("Alias".equals(str2)) {
                            abVar.du(str3);
                        } else if ("PYInitial".equals(str2)) {
                            abVar.dy(str3);
                        } else if ("QuanPin".equals(str2)) {
                            abVar.dz(str3);
                        } else if ("VerifyFlag".equals(str2)) {
                            abVar.eF(bi.getInt(str3, abVar.field_verifyFlag));
                        } else if ("VerifyInfo".equals(str2)) {
                            abVar.dR(str3);
                        } else if ("Signature".equals(str2)) {
                            abVar.dM(str3);
                        } else {
                            obj2 = null;
                            if (obj2 == null && !b(jSONObject, str2, hrVar.mEl)) {
                                str3 = hrVar.mEl;
                                if ("BrandInfo".equals(str2)) {
                                    dVar.field_brandInfo = str3;
                                } else if ("BrandIconURL".equals(str2)) {
                                    dVar.field_brandIconURL = str3;
                                } else if ("BrandFlag".equals(str2)) {
                                    dVar.field_brandFlag = bi.getInt(str3, dVar.field_brandFlag);
                                } else {
                                    if (!"Appid".equals(str2)) {
                                        obj2 = null;
                                    } else if (str3.equals(dVar.field_appId)) {
                                        obj2 = null;
                                    } else {
                                        dVar.field_appId = str3;
                                    }
                                    if (obj2 == null) {
                                        str3 = hrVar.mEl;
                                        if ("BigHeadImgUrl".equals(str2)) {
                                            if (kc != null) {
                                                kc.dHR = str3;
                                            }
                                        } else if (!"SmallHeadImgUrl".equals(str2)) {
                                            obj2 = null;
                                            if (obj2 != null) {
                                                i++;
                                                obj = 1;
                                            } else if ("BitMask".equals(str2)) {
                                                j = bi.getLong(hrVar.mEl, j);
                                                i++;
                                            } else {
                                                int i2;
                                                if ("BitVal".equals(str2)) {
                                                    j2 = bi.getLong(hrVar.mEl, j2);
                                                    i2 = i + 1;
                                                } else {
                                                    i2 = i;
                                                }
                                                i = i2;
                                            }
                                        } else if (kc != null) {
                                            kc.dHQ = str3;
                                        }
                                        obj2 = 1;
                                        if (obj2 != null) {
                                            i++;
                                            obj = 1;
                                        } else if ("BitMask".equals(str2)) {
                                            j = bi.getLong(hrVar.mEl, j);
                                            i++;
                                        } else {
                                            int i22;
                                            if ("BitVal".equals(str2)) {
                                                j2 = bi.getLong(hrVar.mEl, j2);
                                                i22 = i + 1;
                                            } else {
                                                i22 = i;
                                            }
                                            i = i22;
                                        }
                                    }
                                }
                                obj2 = 1;
                                if (obj2 == null) {
                                    str3 = hrVar.mEl;
                                    if ("BigHeadImgUrl".equals(str2)) {
                                        if (kc != null) {
                                            kc.dHR = str3;
                                        }
                                    } else if (!"SmallHeadImgUrl".equals(str2)) {
                                        obj2 = null;
                                        if (obj2 != null) {
                                            i++;
                                            obj = 1;
                                        } else if ("BitMask".equals(str2)) {
                                            j = bi.getLong(hrVar.mEl, j);
                                            i++;
                                        } else {
                                            int i222;
                                            if ("BitVal".equals(str2)) {
                                                j2 = bi.getLong(hrVar.mEl, j2);
                                                i222 = i + 1;
                                            } else {
                                                i222 = i;
                                            }
                                            i = i222;
                                        }
                                    } else if (kc != null) {
                                        kc.dHQ = str3;
                                    }
                                    obj2 = 1;
                                    if (obj2 != null) {
                                        i++;
                                        obj = 1;
                                    } else if ("BitMask".equals(str2)) {
                                        j = bi.getLong(hrVar.mEl, j);
                                        i++;
                                    } else {
                                        int i2222;
                                        if ("BitVal".equals(str2)) {
                                            j2 = bi.getLong(hrVar.mEl, j2);
                                            i2222 = i + 1;
                                        } else {
                                            i2222 = i;
                                        }
                                        i = i2222;
                                    }
                                }
                            }
                            i++;
                        }
                    }
                    obj2 = 1;
                    str3 = hrVar.mEl;
                    if ("BrandInfo".equals(str2)) {
                        dVar.field_brandInfo = str3;
                    } else if ("BrandIconURL".equals(str2)) {
                        dVar.field_brandIconURL = str3;
                    } else if ("BrandFlag".equals(str2)) {
                        dVar.field_brandFlag = bi.getInt(str3, dVar.field_brandFlag);
                    } else {
                        if (!"Appid".equals(str2)) {
                            obj2 = null;
                        } else if (str3.equals(dVar.field_appId)) {
                            obj2 = null;
                        } else {
                            dVar.field_appId = str3;
                        }
                        if (obj2 == null) {
                            str3 = hrVar.mEl;
                            if ("BigHeadImgUrl".equals(str2)) {
                                if (kc != null) {
                                    kc.dHR = str3;
                                }
                            } else if (!"SmallHeadImgUrl".equals(str2)) {
                                obj2 = null;
                                if (obj2 != null) {
                                    i++;
                                    obj = 1;
                                } else if ("BitMask".equals(str2)) {
                                    j = bi.getLong(hrVar.mEl, j);
                                    i++;
                                } else {
                                    int i22222;
                                    if ("BitVal".equals(str2)) {
                                        j2 = bi.getLong(hrVar.mEl, j2);
                                        i22222 = i + 1;
                                    } else {
                                        i22222 = i;
                                    }
                                    i = i22222;
                                }
                            } else if (kc != null) {
                                kc.dHQ = str3;
                            }
                            obj2 = 1;
                            if (obj2 != null) {
                                i++;
                                obj = 1;
                            } else if ("BitMask".equals(str2)) {
                                j = bi.getLong(hrVar.mEl, j);
                                i++;
                            } else {
                                int i222222;
                                if ("BitVal".equals(str2)) {
                                    j2 = bi.getLong(hrVar.mEl, j2);
                                    i222222 = i + 1;
                                } else {
                                    i222222 = i;
                                }
                                i = i222222;
                            }
                        }
                    }
                    obj2 = 1;
                    if (obj2 == null) {
                        str3 = hrVar.mEl;
                        if ("BigHeadImgUrl".equals(str2)) {
                            if (kc != null) {
                                kc.dHR = str3;
                            }
                        } else if (!"SmallHeadImgUrl".equals(str2)) {
                            obj2 = null;
                            if (obj2 != null) {
                                i++;
                                obj = 1;
                            } else if ("BitMask".equals(str2)) {
                                j = bi.getLong(hrVar.mEl, j);
                                i++;
                            } else {
                                int i2222222;
                                if ("BitVal".equals(str2)) {
                                    j2 = bi.getLong(hrVar.mEl, j2);
                                    i2222222 = i + 1;
                                } else {
                                    i2222222 = i;
                                }
                                i = i2222222;
                            }
                        } else if (kc != null) {
                            kc.dHQ = str3;
                        }
                        obj2 = 1;
                        if (obj2 != null) {
                            i++;
                            obj = 1;
                        } else if ("BitMask".equals(str2)) {
                            j = bi.getLong(hrVar.mEl, j);
                            i++;
                        } else {
                            int i22222222;
                            if ("BitVal".equals(str2)) {
                                j2 = bi.getLong(hrVar.mEl, j2);
                                i22222222 = i + 1;
                            } else {
                                i22222222 = i;
                            }
                            i = i22222222;
                        }
                    }
                    i++;
                }
            }
            if (i == 0) {
                x.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
                return false;
            }
            dVar.field_extInfo = jSONObject.toString();
            if (!(kc == null || obj == null)) {
                q.KH().a(kc);
                q.Kp();
                f.B(str, false);
                q.Kp();
                f.B(str, true);
                q.KJ().jO(str);
                com.tencent.mm.ac.m.a Ni = z.Ni();
                if (!bi.oW(str)) {
                    x.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", new Object[]{str});
                    WeakReference weakReference = (WeakReference) Ni.dMz.remove(str);
                    if (weakReference != null) {
                        Bitmap bitmap = (Bitmap) weakReference.get();
                        if (bitmap != null) {
                            bitmap.isRecycled();
                        }
                    }
                }
            }
            abVar.setType(abVar.field_type | ((int) (j & j2)));
            ((i) g.l(i.class)).FR().a(str, abVar);
            z.MY().e(dVar);
            x.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
            return true;
        }
        x.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", new Object[]{str});
        return false;
    }

    private static boolean b(JSONObject jSONObject, String str, String str2) {
        try {
            if ("IsShowHeadImgInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if ("IsHideInputToolbarInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if (!"IsAgreeProtocol".equals(str)) {
                if ("InteractiveMode".equals(str)) {
                    jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                } else if ("CanReceiveSpeexVoice".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConnectorMsgType".equals(str)) {
                    jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                } else if ("ReportLocationType".equals(str)) {
                    jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                } else if ("AudioPlayType".equals(str)) {
                    jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                } else if ("IsShowMember".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConferenceContactExpireTime".equals(str)) {
                    jSONObject.put(str, str2);
                } else if (!"VerifyMsg2Remark".equals(str)) {
                    if ("VerifyContactPromptTitle".equals(str)) {
                        jSONObject.put(str, str2);
                    } else if (!"IsSubscribeStat".equals(str)) {
                        if ("ScanQRCodeType".equals(str)) {
                            jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                        } else if ("ServiceType".equals(str)) {
                            jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                        } else if (!"NeedShowUserAddrObtaining".equals(str)) {
                            if ("SupportEmoticonLinkPrefix".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("FunctionFlag".equals(str)) {
                                jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                            } else if ("NotifyManage".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("ServicePhone".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("IsTrademarkProtection".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if (!"CanReceiveLongVideo".equals(str)) {
                                if ("TrademarkUrl".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("TrademarkName".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("MMBizMenu".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("VerifySource".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if (!"MMBizTabbar".equals(str)) {
                                    if ("PayShowInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("HardwareBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("EnterpriseBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if (!"MainPage".equals(str)) {
                                        if ("RegisterSource".equals(str)) {
                                            jSONObject.put(str, str2);
                                        } else if (!"IBeaconBizInfo".equals(str)) {
                                            if ("WxaAppInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WxaAppVersionInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WXAppType".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("BindWxaInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if (!"AcctTransferInfo".equals(str)) {
                                                return false;
                                            } else {
                                                jSONObject.put(str, str2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            x.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", new Object[]{str, str2, e});
        }
        return true;
    }
}
