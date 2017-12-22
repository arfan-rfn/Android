/*
to save some data on user devise, the important class is < SharedPreference />
Only String, int, double, HashSet<> can be save on this process.
*** if an array need to be store,  use < ObjectSerializer /> class
*/


/**************** put the data ******************/

SharedPreferences sharedPreferences = Context.getSharedPreferences(String name, Context.MODE_PRIVATE);
/**
 * Context: this / getApplicationContext()
 * String Name: name of the application (generally the package name on the top. ie. "com.exception.memorableplace")
 * Context (MOOD): can have different mode
 * key: an unique key helps to find it back
 */
// HashSet<String> data = new HashSet<>(an array); or
String set = "anyString";
sharedPreferences.edit().putStringSet("key", data).apply();



/**************** get the data ******************/
SharedPreferences sharedPreferences = Context.getSharedPreferences(String name, Context.MODE_PRIVATE);
sharedPreferences.getString("key", "default value")


/**************** using < ObjectSerializer/>  put data ******************/
ArrayList<String> arrayList = new ArrayList<>(); // the array must be a String or need to convert into String
SharedPreferences sharedPreferences = Context.getSharedPreferences(String name, Context.MODE_PRIVATE);
try {
sharedPreferences.edit().putString("key", ObjectSerializer.serialize(arrayList)).apply();
} catch (IOException e) {
	e.printStackTrace();
}


/**************** using < ObjectSerializer/> get data ******************/
ArrayList<String> newArray = new ArrayList<>();
try {
newArray = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("key", ObjectSerializer.serialize(new ArrayList<String>())));
} catch (IOException e) {
	e.printStackTrace();
}
