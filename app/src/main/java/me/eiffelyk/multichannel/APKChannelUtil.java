package me.eiffelyk.multichannel;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/**
 * 获得发布渠道代码
 * Created by eiffelyk on 2015/8/21.
 */
public class APKChannelUtil {
    public static final String KEY_APP_KEY = "IFENGLIAN_CHANNEL";
    // 取得AppKey
    public static String getAppKey(Context context) {
        Bundle metaData = null;
        String appKey = null;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
            if (null != ai)
                metaData = ai.metaData;
            if (null != metaData) {
                appKey = metaData.getString(KEY_APP_KEY);
                //if ((null == appKey) || appKey.length() != 24) {
                //    appKey = null;
                //}
            }
        } catch (PackageManager.NameNotFoundException e) {

        }
        return appKey;
    }
}
