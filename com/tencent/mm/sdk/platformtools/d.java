package com.tencent.mm.sdk.platformtools;

public final class d {
    public static String BUILD_TAG;
    public static String CLIENT_VERSION;
    public static String COMMAND;
    public static boolean DEBUG;
    public static boolean EX_DEVICE_LOGIN;
    public static String HOSTNAME;
    public static String OWNER;
    public static boolean REDESIGN_ENTRANCE;
    public static String REV;
    public static String SVNPATH;
    public static String TIME;
    public static boolean duK;
    public static boolean sFx;
    public static boolean sFy;

    private static class a {
        public static String fL(String str, String str2) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf(str2);
            return indexOf >= 0 ? str.substring(indexOf) : str;
        }

        public static String fM(String str, String str2) {
            if (str == null) {
                return null;
            }
            if (str.equals(str2)) {
                return str;
            }
            return String.format("%s(%s)", new Object[]{str, str2});
        }
    }

    public static String avA() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[b.ver] %s\n", new Object[]{a.fM(CLIENT_VERSION, com.tencent.mm.loader.stub.a.CLIENT_VERSION)}));
        stringBuilder.append(String.format("[tag  ] %s\n", new Object[]{a.fM(BUILD_TAG, com.tencent.mm.loader.stub.a.BUILD_TAG)}));
        stringBuilder.append(String.format("[by   ] %s\n", new Object[]{a.fM(OWNER, com.tencent.mm.loader.stub.a.OWNER)}));
        stringBuilder.append(String.format("[host ] %s\n", new Object[]{a.fM(HOSTNAME, com.tencent.mm.loader.stub.a.HOSTNAME)}));
        stringBuilder.append(String.format("[time ] %s\n", new Object[]{a.fM(TIME, com.tencent.mm.loader.stub.a.TIME)}));
        stringBuilder.append(String.format("[cmd  ] %s\n", new Object[]{a.fM(COMMAND, com.tencent.mm.loader.stub.a.COMMAND)}));
        stringBuilder.append(String.format("[path ] %s\n", new Object[]{a.fM(a.fL(SVNPATH, "MicroMsg_proj"), a.fL(com.tencent.mm.loader.stub.a.SVNPATH, "MicroMsg_proj"))}));
        stringBuilder.append(String.format("[rev  ] %s\n", new Object[]{a.fM(REV, com.tencent.mm.loader.stub.a.REV)}));
        String str = "[p.rev] %s\n";
        Object[] objArr = new Object[1];
        objArr[0] = com.tencent.mm.loader.stub.a.patchEnabled() ? com.tencent.mm.loader.stub.a.codeRevision() : "disabled";
        stringBuilder.append(String.format(str, objArr));
        return stringBuilder.toString();
    }
}
