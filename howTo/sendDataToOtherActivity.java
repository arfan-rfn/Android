/**

* send data to other Activity.

*/

/**************** send data (put extra) ***************************/
Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
intent.putExtra("key", String anyString);
startActivity(intent);

/**************** get data (put extra) ***************************/
Intent intent = getIntent();
String str = intent.getStringExtra("key"); // remmber for int/double it is need to put a default value