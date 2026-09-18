package androidx.camera.core.log;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class CameraLog {
    public static String APP_CAMERA_EVENT = "app_camera_event";

    public static void cameraFilter(JSONArray lensArr, JSONArray lensArr2, int mLensFacing) {
        Map<String, String> hmParams = new HashMap<>();
        if (lensArr2.length() == 0) {
            hmParams.put("logtype", "cameraFilter1");
        } else {
            hmParams.put("logtype", "cameraFilter2");
        }
        hmParams.put("lensArr1", "" + lensArr);
        hmParams.put("lensArr2", "" + lensArr2);
        hmParams.put("mLensFacing", "" + mLensFacing);
        hmParams.put("eventtype", APP_CAMERA_EVENT);
    }

    public static void rotationErr(int displayLength, Exception e) {
        Map<String, String> hmParams = new HashMap<>();
        hmParams.put("logtype", "rotationErr");
        hmParams.put("error", "" + e.getMessage());
        hmParams.put("displayLength", "" + displayLength);
        hmParams.put("eventtype", APP_CAMERA_EVENT);
    }

    public static void displayErr(JSONArray jsonArray) {
        Map<String, String> hmParams = new HashMap<>();
        hmParams.put("logtype", "displayErr");
        hmParams.put("jsonArray", "" + jsonArray);
        hmParams.put("eventtype", APP_CAMERA_EVENT);
    }
}
