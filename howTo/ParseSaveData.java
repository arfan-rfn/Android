/********** to begin with *************
* from E2C (amazon AWS) get the keyFile and create new project on Parse.
* get the appID, masterKey, serverURL from <ssh/> to the project
* add those id, key, url to the <startedApplication/> class below
* go to main activity and do whanever you wnat
****************** next step ******************/

/************ create a class on database Server & add data on it *************/
	// add them on onCreate method

      ParseObject parse = new ParseObject("ClassName"); // ClassName: the name of the Table

      // parse.put("columnName", "the thing need to save")
      parse.put("username", "rob");
      parse.put("score", 86);
      parse.saveInBackground(new SaveCallback() {  // don't forget to save it
          @Override
          public void done(ParseException e) {
              if (e == null){
                  Log.i("saveInBackground", "successful");
              }else {
                  Log.i("saveInBackground", "failed! Error: "+e.toString());
              }
          }
      });
      ParseAnalytics.trackAppOpenedInBackground(getIntent());

/***************** get data or update data *************/

      ParseQuery<ParseObject> query = ParseQuery.getQuery("ClassName"); // ClassName: Name of the class
      query.getInBackground("ID", new GetCallback<ParseObject>() { // ID: can be found on database
          @Override
          public void done(ParseObject object, ParseException e) {
              if (e == null && object != null){

                  // how to update data on server?
                  object.put("score", 200);
                  object.saveInBackground();  // don't forget to save it

                  // that's how you can get the data from server
                  Log.i("ObjectValue", object.getString("username"));
                  Log.i("ObjectValue", String.valueOf(object.getInt("score")));
              }else {
                  Log.i("ObjectValue", "Failed! error: " + e.toString());
              }
          }
          ParseAnalytics.trackAppOpenedInBackground(getIntent());



/***************** find data / loop through the database *************/
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

    // find specific username or any data
    query.whereEqualTo("username", "tommy");
      // play with query.where...... (the way to find the shit)
    query.setLimit(1);


    // to loop through all the database.
    query.findInBackground(new FindCallback<ParseObject>() {
        @Override
        public void done(List<ParseObject> objects, ParseException e) {
            if (e == null){
                Log.i("have any object?", String.valueOf(objects.size()));

                if (objects.size() > 0){
                    for (ParseObject object: objects){
                        Log.i("findInBackground", object.getInt("score")+",");
                    }
                }
            }
        }
    });




/*********************** user log in ******************/

// set username and password
ParseUser user = new ParseUser();
    user.setUsername("arfan");
    user.setPassword("password");

    user.signUpInBackground(new SignUpCallback() {
        @Override
        public void done(ParseException e) {
            if (e == null){
                Log.i("sign up", "successful");
            }else {
                Log.i("sign up", "failed");
            }
        }
    });



// check if the username and password id currect (log in the user)
     ParseUser.logInInBackground("arfan", "pass", new LogInCallback() {
        @Override
        public void done(ParseUser user, ParseException e) {
            if (user != null){
                Log.i("log in", "successful");
            }else {
                Log.i("log in", "failed" + e.toString());
            }
        }
    });

// check if the user is logged in or not
      if (ParseUser.getCurrentUser() != null){
        Log.i("currentUser", "logged in " + ParseUser.getCurrentUser().getUsername());
    }else {
        Log.i("currentUser", "not logged in");
    }

// log out user
        ParseUser.logOut();



/*********************** the class needed ******************/
import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class StarterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Enable Local DataStore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
            .applicationId("f86c864f3102bb9930f82fe2d39c213623ec877c")
            .clientKey("ec20fb354821cbd512e52f15cbcb719bb0d6902a")
            .server("http://18.216.89.106:80/parse/")
            .build()
    );


    ParseUser.enableAutomaticUser();

    ParseACL defaultACL = new ParseACL();
    defaultACL.setPublicReadAccess(true);
    defaultACL.setPublicWriteAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);

  }
}
/************************** end ***********************/
// add that line on Main_activity onCreate method
ParseAnalytics.trackAppOpenedInBackground(getIntent());
