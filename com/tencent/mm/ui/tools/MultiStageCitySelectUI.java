package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MultiStageCitySelectUI extends MMPreference implements e {
    private static List<Region> uBa;
    private int bUw = 0;
    private a cXs = new 1(this);
    private String countryCode = null;
    private String dDe = null;
    private String dDf = null;
    private c dMm;
    private String dYy = null;
    private o eMS = new o((byte) 0);
    private f eOE;
    private ag handler = new ag(Looper.getMainLooper());
    private String uAP = null;
    private String uAQ = null;
    private boolean uAR = false;
    private int uAS = -1;
    private Region[] uAT;
    private boolean uAU = false;
    private boolean uAV = true;
    private boolean uAW = true;
    private boolean uAX = false;
    private boolean uAY = false;
    private ZoneRecommandPreference uAZ;
    private String uBb;
    private Runnable uBc = new 4(this);

    static /* synthetic */ void g(MultiStageCitySelectUI multiStageCitySelectUI) {
        if (multiStageCitySelectUI.uAR) {
            multiStageCitySelectUI.bUw = 3;
        } else if (multiStageCitySelectUI.countryCode == null) {
            multiStageCitySelectUI.bUw = 0;
        } else if (multiStageCitySelectUI.dDf == null) {
            multiStageCitySelectUI.bUw = 1;
        } else {
            multiStageCitySelectUI.bUw = 2;
        }
    }

    static /* synthetic */ void k(MultiStageCitySelectUI multiStageCitySelectUI) {
        if (!bi.oW(multiStageCitySelectUI.uBb)) {
            PreferenceTitleCategory preferenceTitleCategory;
            ArrayList arrayList = new ArrayList();
            List<Region> arrayList2 = new ArrayList();
            List<Region> arrayList3 = new ArrayList();
            List<Region> arrayList4 = new ArrayList();
            for (Region region : uBa) {
                if (region.getName() != null && region.getName().contains(multiStageCitySelectUI.uBb)) {
                    if ("CN".equalsIgnoreCase(region.getCountryCode()) || "HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode()) || ((region.getParent() == null || !region.hasChildren()) && (region.getParent() == null || region.hasChildren()))) {
                        if (region.getParent() == null || !("CN".equalsIgnoreCase(region.getCountryCode()) || "HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode()))) {
                            if (!(region.getParent() == null && ("HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode())))) {
                                arrayList2.add(region);
                            }
                        } else if (region.hasChildren() && region.getParent() != null) {
                            arrayList3.add(region);
                        } else if (!(region.hasChildren() || region.getParent() == null)) {
                            arrayList4.add(region);
                        }
                    }
                }
            }
            if (arrayList4.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle(R.l.setting_zone_search_result_city);
                multiStageCitySelectUI.eOE.a(preferenceTitleCategory);
                for (Region region2 : arrayList4) {
                    ZonePreference zonePreference = new ZonePreference(multiStageCitySelectUI);
                    region2.setHasChildren(false);
                    zonePreference.a(region2);
                    multiStageCitySelectUI.eOE.b(zonePreference);
                }
            }
            if (arrayList3.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle(R.l.setting_zone_search_result_province);
                multiStageCitySelectUI.eOE.a(preferenceTitleCategory);
                for (Region region22 : arrayList3) {
                    ZonePreference zonePreference2 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference2.a(region22);
                    multiStageCitySelectUI.eOE.b(zonePreference2);
                }
            }
            if (arrayList2.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle(R.l.setting_zone_search_result_country);
                multiStageCitySelectUI.eOE.a(preferenceTitleCategory);
                for (Region region222 : arrayList2) {
                    ZonePreference zonePreference3 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference3.a(region222);
                    multiStageCitySelectUI.eOE.b(zonePreference3);
                }
            }
            multiStageCitySelectUI.eOE.notifyDataSetChanged();
            multiStageCitySelectUI.uAS = multiStageCitySelectUI.bUw;
            multiStageCitySelectUI.bUw = 4;
        }
    }

    public final void czK() {
        Region[] Zj;
        int i;
        if (this.bUw == 3) {
            Zj = RegionCodeDecoder.cmS().Zj("CN");
        } else if (bi.oW(this.countryCode)) {
            Zj = RegionCodeDecoder.cmS().cmU();
            if (this.uAX) {
                List arrayList = new ArrayList();
                if (Zj != null) {
                    for (Region region : Zj) {
                        if (!("CN".equalsIgnoreCase(region.getCode()) || "HK".equalsIgnoreCase(region.getCode()) || "TW".equalsIgnoreCase(region.getCode()) || "MO".equalsIgnoreCase(region.getCode()))) {
                            arrayList.add(region);
                        }
                    }
                }
                Zj = new Region[arrayList.size()];
                arrayList.toArray(Zj);
            }
        } else {
            Zj = bi.oW(this.dDf) ? RegionCodeDecoder.cmS().Zj(this.countryCode) : RegionCodeDecoder.cmS().gb(this.countryCode, this.dDf);
        }
        this.uAT = Zj;
        if (this.uAT == null || this.uAT.length <= 0) {
            x.e("MicroMsg.MultiStageCitySelectUI", "initZoneItems error ,check zone lists!");
            return;
        }
        this.eOE.removeAll();
        au.HU();
        String str = (String) com.tencent.mm.model.c.DT().get(12324, null);
        au.HU();
        String str2 = (String) com.tencent.mm.model.c.DT().get(12325, null);
        au.HU();
        String str3 = (String) com.tencent.mm.model.c.DT().get(12326, null);
        this.uAW = getIntent().getBooleanExtra("ShowSelectedLocation", true);
        i = 0;
        while (i < this.uAT.length) {
            if (!(this.uAT[i] == null || bi.oW(this.uAT[i].getCode()) || bi.oW(this.uAT[i].getName()))) {
                ZonePreference zonePreference = new ZonePreference(this);
                zonePreference.a(this.uAT[i]);
                if (!this.uAW) {
                    this.eOE.a(zonePreference);
                } else if (this.bUw == 0 && this.uAT[i].getCode().equalsIgnoreCase(str)) {
                    this.eOE.a(zonePreference, 0);
                    zonePreference.setSummary(R.l.setting_zone_selected_location);
                } else if (this.bUw == 1 && this.uAT[i].getCode().equalsIgnoreCase(str2)) {
                    this.eOE.a(zonePreference, 0);
                    zonePreference.setSummary(R.l.setting_zone_selected_location);
                } else if (this.bUw == 2 && this.uAT[i].getCode().equalsIgnoreCase(str3)) {
                    this.eOE.a(zonePreference, 0);
                    zonePreference.setSummary(R.l.setting_zone_selected_location);
                } else {
                    this.eOE.a(zonePreference);
                }
            }
            i++;
        }
        if (this.bUw == 3) {
            ZoneSelectOtherCountryPreference zoneSelectOtherCountryPreference = new ZoneSelectOtherCountryPreference(this);
            zoneSelectOtherCountryPreference.text = getString(R.l.setting_zone_non_china_mainland);
            zoneSelectOtherCountryPreference.uCL = new 2(this);
            this.eOE.a(zoneSelectOtherCountryPreference);
        }
        this.eOE.a(new PreferenceCategory(this.mController.tml));
        if (this.bUw == 0 || this.bUw == 3) {
            PreferenceTitleCategory preferenceTitleCategory;
            if (this.uAV) {
                preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle(R.l.setting_zone_category_get_location);
                this.eOE.a(preferenceTitleCategory, 0);
                this.uAZ = new ZoneRecommandPreference(this);
                this.uAZ.setKey("current_location");
                this.eOE.a(this.uAZ, 1);
                x.i("MicroMsg.MultiStageCitySelectUI", "settings district,checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
                if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    czL();
                }
            }
            preferenceTitleCategory = new PreferenceTitleCategory(this);
            preferenceTitleCategory.setTitle(R.l.setting_zone_category_all_locations);
            if (this.uAV) {
                this.eOE.a(preferenceTitleCategory, 2);
            } else {
                this.eOE.a(preferenceTitleCategory, 0);
            }
        }
    }

    private void czL() {
        if (this.dMm == null) {
            this.dMm = c.OB();
        }
        this.dMm.a(this.cXs, true);
    }

    private void czM() {
        switch (this.bUw) {
            case 0:
                this.countryCode = null;
                return;
            case 1:
                this.dDf = null;
                return;
            case 2:
                this.dDe = null;
                return;
            default:
                return;
        }
    }

    private static List<Region> czN() {
        String str;
        Reader inputStreamReader;
        Throwable e;
        Reader reader;
        Reader reader2;
        RegionCodeDecoder cmS = RegionCodeDecoder.cmS();
        cmS.tcp = w.chP();
        String cmT = cmS.cmT();
        if (bi.oW(cmT)) {
            x.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + cmS.tcp);
            str = null;
        } else {
            str = RegionCodeDecoder.tco + cmT;
        }
        if (bi.oW(str)) {
            return null;
        }
        List<Region> arrayList = new ArrayList();
        InputStream openRead;
        try {
            openRead = FileOp.openRead(str);
            try {
                inputStreamReader = new InputStreamReader(openRead);
            } catch (Exception e2) {
                e = e2;
                reader = null;
                inputStreamReader = null;
                try {
                    x.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", new Object[]{e.getMessage()});
                    if (openRead != null) {
                        com.tencent.mm.a.e.f(openRead);
                    }
                    if (inputStreamReader != null) {
                        com.tencent.mm.a.e.a(inputStreamReader);
                    }
                    if (reader != null) {
                        com.tencent.mm.a.e.a(reader);
                    }
                    return arrayList;
                } catch (Throwable th) {
                    e = th;
                    reader2 = reader;
                    if (openRead != null) {
                        com.tencent.mm.a.e.f(openRead);
                    }
                    if (inputStreamReader != null) {
                        com.tencent.mm.a.e.a(inputStreamReader);
                    }
                    if (reader2 != null) {
                        com.tencent.mm.a.e.a(reader2);
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                reader2 = null;
                inputStreamReader = null;
                if (openRead != null) {
                    com.tencent.mm.a.e.f(openRead);
                }
                if (inputStreamReader != null) {
                    com.tencent.mm.a.e.a(inputStreamReader);
                }
                if (reader2 != null) {
                    com.tencent.mm.a.e.a(reader2);
                }
                throw e;
            }
            try {
                reader2 = new BufferedReader(inputStreamReader);
                Region region = null;
                Region region2 = null;
                while (true) {
                    try {
                        String readLine = reader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        Region region3;
                        String[] split = readLine.split("\\|");
                        Region region4 = new Region();
                        if (split.length == 2) {
                            region4.setName(split[1]);
                            split = split[0].split("_");
                            String str2 = split[0];
                            region4.setCountryCode(str2);
                            if (!bi.oW(str2)) {
                                if (split.length == 1) {
                                    region4.setCode(str2);
                                    region4.setProvince(false);
                                    region4.setCity(false);
                                    region4.setCountry(true);
                                    region = region4;
                                    region3 = region2;
                                } else if (split.length == 2) {
                                    region4.setCode(split[1]);
                                    region4.setProvince(true);
                                    region4.setCountry(false);
                                    region4.setCity(false);
                                    if (region != null && region.getCountryCode().equals(region4.getCountryCode())) {
                                        region.setHasChildren(true);
                                        region4.setParent(region);
                                    }
                                    region3 = region4;
                                } else {
                                    if (split.length == 3) {
                                        region4.setCode(split[2]);
                                        region4.setCity(true);
                                        region4.setCountry(false);
                                        region4.setProvince(false);
                                        region4.setHasChildren(false);
                                        if (region2 != null && region2.getCode().equals(split[1])) {
                                            region4.setParent(region2);
                                            region2.setHasChildren(true);
                                        }
                                    }
                                    region3 = region2;
                                }
                                arrayList.add(region4);
                            }
                        } else {
                            region3 = region2;
                        }
                        region2 = region3;
                    } catch (Exception e3) {
                        e = e3;
                        reader = reader2;
                        x.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", new Object[]{e.getMessage()});
                        if (openRead != null) {
                            com.tencent.mm.a.e.f(openRead);
                        }
                        if (inputStreamReader != null) {
                            com.tencent.mm.a.e.a(inputStreamReader);
                        }
                        if (reader != null) {
                            com.tencent.mm.a.e.a(reader);
                        }
                        return arrayList;
                    } catch (Throwable th3) {
                        e = th3;
                        if (openRead != null) {
                            com.tencent.mm.a.e.f(openRead);
                        }
                        if (inputStreamReader != null) {
                            com.tencent.mm.a.e.a(inputStreamReader);
                        }
                        if (reader2 != null) {
                            com.tencent.mm.a.e.a(reader2);
                        }
                        throw e;
                    }
                }
                if (openRead != null) {
                    com.tencent.mm.a.e.f(openRead);
                }
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(reader2);
            } catch (Exception e4) {
                e = e4;
                reader = null;
                x.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", new Object[]{e.getMessage()});
                if (openRead != null) {
                    com.tencent.mm.a.e.f(openRead);
                }
                if (inputStreamReader != null) {
                    com.tencent.mm.a.e.a(inputStreamReader);
                }
                if (reader != null) {
                    com.tencent.mm.a.e.a(reader);
                }
                return arrayList;
            } catch (Throwable th4) {
                e = th4;
                reader2 = null;
                if (openRead != null) {
                    com.tencent.mm.a.e.f(openRead);
                }
                if (inputStreamReader != null) {
                    com.tencent.mm.a.e.a(inputStreamReader);
                }
                if (reader2 != null) {
                    com.tencent.mm.a.e.a(reader2);
                }
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            reader = null;
            inputStreamReader = null;
            openRead = null;
        } catch (Throwable th5) {
            e = th5;
            reader2 = null;
            inputStreamReader = null;
            openRead = null;
            if (openRead != null) {
                com.tencent.mm.a.e.f(openRead);
            }
            if (inputStreamReader != null) {
                com.tencent.mm.a.e.a(inputStreamReader);
            }
            if (reader2 != null) {
                com.tencent.mm.a.e.a(reader2);
            }
            throw e;
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(665, this);
        this.eOE = this.tCL;
        initView();
        if (this.uAY) {
            if (uBa == null || uBa.size() <= 0) {
                long VG = bi.VG();
                Region[] cmU = RegionCodeDecoder.cmS().cmU();
                if (cmU != null && cmU.length > 0 && (uBa == null || uBa.size() <= 0)) {
                    List czN = czN();
                    uBa = czN;
                    if (czN != null) {
                        x.i("MicroMsg.MultiStageCitySelectUI", "buildAllSearchRegion used %sms, size: %s", new Object[]{Long.valueOf(bi.bI(VG)), Integer.valueOf(uBa.size())});
                    }
                }
            }
            a(this.eMS);
            this.eMS.uBw = new 3(this);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        au.DF().b(665, this);
        if (this.dMm != null) {
            this.dMm.c(this.cXs);
        }
        super.onDestroy();
    }

    public final int Ys() {
        return R.i.zoneselect;
    }

    protected final void initView() {
        setMMTitle(R.l.nearby_friend_city_select);
        setBackBtn(new 5(this));
        this.uAU = getIntent().getBooleanExtra("GetAddress", false);
        this.countryCode = getIntent().getStringExtra("Country");
        this.dDf = getIntent().getStringExtra("Provice");
        this.dYy = getIntent().getStringExtra("CountryName");
        this.uAP = getIntent().getStringExtra("ProviceName");
        this.uAV = getIntent().getBooleanExtra("IsAutoPosition", !bi.fU(this));
        this.uAR = getIntent().getBooleanExtra("IsRealNameVerifyScene", false);
        this.uAX = getIntent().getBooleanExtra("IsSelectNonChinaCountry", false);
        this.uAY = getIntent().getBooleanExtra("IsNeedShowSearchBar", false);
        x.i("MicroMsg.MultiStageCitySelectUI", " country = " + this.countryCode + " province =" + this.dDf + " city = " + this.dDe + " " + this.dYy + " " + this.uAP + " " + this.uAR + " " + this.uAX);
        if (this.uAR) {
            this.bUw = 3;
        } else if (this.countryCode == null) {
            this.bUw = 0;
            this.dDf = null;
            this.dDe = null;
        } else if (this.dDf == null) {
            this.bUw = 1;
            this.dDe = null;
        } else {
            this.bUw = 2;
        }
        czK();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = null;
        String str2;
        if (preference instanceof ZonePreference) {
            Region region = ((ZonePreference) preference).uCD;
            if (region == null || bi.oW(region.getCode())) {
                Object valueOf;
                str = "MicroMsg.MultiStageCitySelectUI";
                StringBuilder stringBuilder = new StringBuilder("onPreferenceTreeClick error item, code:");
                if (region == null) {
                    valueOf = Integer.valueOf(-1);
                } else {
                    valueOf = region.getCode();
                }
                stringBuilder = stringBuilder.append(valueOf).append(" ,name:");
                if (region == null) {
                    str2 = "null";
                } else {
                    str2 = region.getName();
                }
                x.e(str, stringBuilder.append(str2).toString());
                return false;
            }
            if (this.bUw == 3) {
                this.countryCode = "CN";
                this.dDf = region.getCode();
                this.uAP = region.getName();
            }
            if (this.bUw == 0) {
                this.countryCode = region.getCode();
                this.dYy = region.getName();
            } else if (this.bUw == 1) {
                this.dDf = region.getCode();
                this.uAP = region.getName();
            } else if (this.bUw == 2) {
                this.dDe = region.getCode();
                this.uAQ = region.getName();
                if ("CN".equalsIgnoreCase(this.countryCode) || "HK".equalsIgnoreCase(this.countryCode) || "MO".equalsIgnoreCase(this.countryCode) || "TW".equalsIgnoreCase(this.countryCode)) {
                    this.dYy = null;
                } else {
                    this.uAP = null;
                }
            } else if (this.bUw == 4) {
                if (region.getParent() != null && !region.hasChildren()) {
                    this.dDe = region.getCode();
                    this.uAQ = region.getName();
                    this.dDf = region.getParent().getCode();
                    this.uAP = region.getParent().getName();
                    this.countryCode = region.getCountryCode();
                    this.dYy = null;
                } else if (!region.hasChildren() || region.getParent() == null) {
                    this.countryCode = region.getCode();
                    this.dYy = region.getName();
                    this.dDf = null;
                    this.uAP = null;
                    this.dDe = null;
                    this.uAQ = null;
                } else {
                    this.dDf = region.getCode();
                    this.uAP = region.getName();
                    this.countryCode = region.getCountryCode();
                    this.dYy = null;
                }
            }
            if (region.hasChildren()) {
                Intent intent = new Intent(this, MultiStageCitySelectUI.class);
                Bundle bundle = new Bundle();
                bundle.putString("Country", this.countryCode);
                bundle.putString("Provice", this.dDf);
                bundle.putString("CountryName", this.dYy);
                bundle.putString("ProviceName", this.uAP);
                bundle.putBoolean("GetAddress", this.uAU);
                bundle.putBoolean("ShowSelectedLocation", this.uAW);
                if (this.uAR) {
                    str2 = region.getCountryCode();
                    if (bi.oW(str2)) {
                        str2 = this.countryCode;
                    }
                    if ("CN".equalsIgnoreCase(str2) || "HK".equalsIgnoreCase(str2) || "MO".equalsIgnoreCase(str2) || "TW".equalsIgnoreCase(str2)) {
                        bundle.putBoolean("IsNeedShowSearchBar", true);
                    }
                }
                intent.putExtras(bundle);
                YC();
                startActivityForResult(intent, 1);
            } else {
                if (!this.uAU) {
                    au.HU();
                    com.tencent.mm.model.c.DT().set(12324, this.countryCode);
                    au.HU();
                    com.tencent.mm.model.c.DT().set(12325, this.dDf);
                    au.HU();
                    com.tencent.mm.model.c.DT().set(12326, this.dDe);
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CountryName", this.dYy);
                intent2.putExtra("ProviceName", this.uAP);
                intent2.putExtra("CityName", this.uAQ);
                intent2.putExtra("Country", this.countryCode);
                intent2.putExtra("Contact_Province", this.dDf);
                intent2.putExtra("Contact_City", this.dDe);
                YC();
                setResult(-1, intent2);
                finish();
            }
            return true;
        }
        if (preference.mKey.equals("current_location")) {
            if (this.uAZ.status == 1) {
                ZoneRecommandPreference zoneRecommandPreference = this.uAZ;
                Region[] regionArr = new Region[]{zoneRecommandPreference.uCG, zoneRecommandPreference.uCH, zoneRecommandPreference.uCI};
                au.HU();
                com.tencent.mm.model.c.DT().set(12324, regionArr[0] == null ? null : regionArr[0].getCode());
                au.HU();
                com.tencent.mm.model.c.DT().set(12325, regionArr[1] == null ? null : regionArr[1].getCode());
                au.HU();
                com.tencent.mm.model.c.DT().set(12326, regionArr[2] == null ? null : regionArr[2].getCode());
                str2 = regionArr[0] == null ? null : regionArr[0].getCode();
                String name = regionArr[0] == null ? null : regionArr[0].getName();
                String code = regionArr[1] == null ? null : regionArr[1].getCode();
                String name2 = regionArr[1] == null ? null : regionArr[1].getName();
                if ("CN".equalsIgnoreCase(str2) || "HK".equalsIgnoreCase(str2) || "MO".equalsIgnoreCase(str2) || "TW".equalsIgnoreCase(str2)) {
                    name = null;
                } else {
                    name2 = null;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CountryName", name);
                intent3.putExtra("ProviceName", name2);
                intent3.putExtra("CityName", regionArr[2] == null ? null : regionArr[2].getName());
                intent3.putExtra("Country", str2);
                intent3.putExtra("Contact_Province", code);
                str2 = "Contact_City";
                if (regionArr[2] != null) {
                    str = regionArr[2].getCode();
                }
                intent3.putExtra(str2, str);
                YC();
                setResult(-1, intent3);
                finish();
            }
        }
        return false;
    }

    public void onBackPressed() {
        czM();
        super.onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 0;
        if (i != 0 || i2 != 0) {
            czO();
        } else if (lVar.getType() == 665) {
            Region region;
            Region region2;
            j jVar = (j) lVar;
            x.i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", new Object[]{jVar.country, jVar.csK, jVar.csL});
            for (Region region3 : RegionCodeDecoder.cmS().cmU()) {
                if (region3.getCode().equalsIgnoreCase(r2)) {
                    for (Region region4 : RegionCodeDecoder.cmS().Zj(region3.getCode())) {
                        if (region4.getCode().equalsIgnoreCase(r5)) {
                            Region[] gb = RegionCodeDecoder.cmS().gb(region3.getCode(), region4.getCode());
                            int length = gb.length;
                            while (i3 < length) {
                                region2 = gb[i3];
                                if (region2.getCode().equalsIgnoreCase(r6)) {
                                    break;
                                }
                                i3++;
                            }
                            region2 = null;
                            if (region3 != null && region4 == null && region2 == null) {
                                if (this.uAZ != null) {
                                    this.uAZ.czY();
                                    return;
                                }
                                return;
                            } else if (this.uAZ == null) {
                                ZoneRecommandPreference zoneRecommandPreference = this.uAZ;
                                zoneRecommandPreference.status = 1;
                                zoneRecommandPreference.uCG = region3;
                                zoneRecommandPreference.uCH = region4;
                                zoneRecommandPreference.uCI = region2;
                                zoneRecommandPreference.czX();
                            }
                        }
                    }
                    region2 = null;
                    region4 = null;
                    if (region3 != null) {
                    }
                    if (this.uAZ == null) {
                        ZoneRecommandPreference zoneRecommandPreference2 = this.uAZ;
                        zoneRecommandPreference2.status = 1;
                        zoneRecommandPreference2.uCG = region3;
                        zoneRecommandPreference2.uCH = region4;
                        zoneRecommandPreference2.uCI = region2;
                        zoneRecommandPreference2.czX();
                    }
                }
            }
            region2 = null;
            region4 = null;
            Region region32 = null;
            if (region32 != null) {
            }
            if (this.uAZ == null) {
                ZoneRecommandPreference zoneRecommandPreference22 = this.uAZ;
                zoneRecommandPreference22.status = 1;
                zoneRecommandPreference22.uCG = region32;
                zoneRecommandPreference22.uCH = region4;
                zoneRecommandPreference22.uCI = region2;
                zoneRecommandPreference22.czX();
            }
        }
    }

    private void czO() {
        if (this.uAZ != null) {
            this.uAZ.czY();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.MultiStageCitySelectUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case i$l.AppCompatTheme_imageButtonStyle /*64*/:
                if (iArr[0] == 0 && this.uAZ != null) {
                    czL();
                    return;
                } else if (this.uAZ != null) {
                    this.uAZ.czY();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
