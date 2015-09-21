package rsantillanc.aboutme;

import android.app.Application;

/**
 * Created by rsantillanc on 21/09/2015.
 */
public class AppAboutMe extends Application {
    private static AppAboutMe ourInstance = new AppAboutMe();

    public static AppAboutMe getInstance() {
        return ourInstance;
    }

    private AppAboutMe() {
    }
}
