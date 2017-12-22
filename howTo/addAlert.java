/* pop up Atart button on android
*/

new AlertDialog.Builder(this)  // carefull with <this/>
    .setIcon(android.R.drawable.ic_btn_speak_now)  // icon
    .setTitle("title") // title
    .setMessage("Which Language would you like") // details messsage
    .setPositiveButton("Yes", new DialogInterface.OnClickListener() { // add positive Button
        @Override
        public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(), "get is english", Toast.LENGTH_SHORT).show();
                            
         }
    })
    .setNegativeButton("No", null) // add negative button
    .show(); // don't forget it
